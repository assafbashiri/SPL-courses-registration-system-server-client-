package bgu.spl.net.DB;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Passive object representing the Database where all courses and users are stored.
 * <p>
 * This class must be implemented safely as a thread-safe singleton.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You can add private fields and methods to this class as you see fit.
 */
public class Database {
	final public ConcurrentHashMap<String , User> users = new ConcurrentHashMap<>();
	final public ConcurrentHashMap<Integer , Course> courses = new ConcurrentHashMap<>();

	//to prevent user from creating new Database
	private Database() {
		initialize();
	}

	public boolean passCheck(String username, String password) {
		return  users.get(username).password.equals(password);

	}

	/**
	 * Retrieves the single instance of this class.
	 */

	private static class SingletonHolder {
		private static final Database instance = new Database();
	}
	public static Database getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * loades the courses from the file path specified 
	 * into the Database, returns true if successful.
	 */
	void initialize() {
		try {
			File myObj = new File("Courses.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				Course course = readLine(data);
				courses.put(course.getIdNumber(), course);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	public Course getCourse(int num){
		synchronized (courses) {
			return courses.get(num);
		}
	}

	public boolean userChack (String username){
		synchronized (users) {
			return users.containsKey(username);
		}
	}
	public boolean courseCheck(int num){
		return courses.containsKey(num);
	}
	public boolean addStudent(String username,String password){
		synchronized (users) {
			if(userChack(username))
				return false;
			else {
				Student user = new Student(username, password);
				users.put(username, user);
				return true;
			}
		}
	}
	public boolean addAdmin(String username,String password){
		synchronized (users) {
			if(userChack(username))
				return false;
			else {
				Admin user= new Admin(username,password);
				users.put(username, user);
				return true;
			}
		}
	}
	public boolean removeCourse(String username,int num) {
		synchronized (users) {
			synchronized (courses) {
				Student student = (Student) users.get(username);
				boolean output = student.removeCourse(num);
				if (output)
					output=courses.get(num).removeStudent(username);
				return output;
			}
		}
	}
	public User getUser(String username){
		synchronized (users) {
			return users.get(username);
		}
	}
	public String getKdam(int num){
		synchronized (courses) {
			Course course = courses.get(num);
			StringBuilder toReturn = new StringBuilder("ACK 6\n" + "[");
			int[] kdam = course.getKdam();
			for (int i = 0; i < kdam.length; i++) {
				toReturn.append(kdam[i]);
				if (i < kdam.length - 1)
					toReturn.append(",");
			}
			toReturn.append("]");
			return toReturn.toString();
		}
	}
	public List<Integer> getMyCourses(String username){
		synchronized (users) {
			Student student = (Student) users.get(username);
			return student.getCourseList();
		}
	}
	public String studentStatus(String username){
		synchronized (users) {
			Student student = (Student) users.get(username);
			List<Integer> list = student.getCourseList();
			String s = list.toString().replaceAll("\\s+", "");
			return "ACK 8\n" + "Student: " + username +
					"\n" + "Courses: " + s; //מה זה?

		}
	}


	public boolean kdamCheck(String username, int courseNum){
		synchronized (users) {
			synchronized (courses) {
				Course course =courses.get(courseNum);
				Student student = (Student) users.get(username);
				int[] kdam = course.getKdam();
				List<Integer> courseList = student.getCourseList();

				for (int j : kdam) {
					if (!courseList.contains(j))
						return false;
				}
				if(student.getCourseList().contains(courseNum))
					return false;
				return course.getAvailableSeats() != 0;
			}
		}
	}
	public boolean connectUser(String username){
		synchronized (users) {
			if(users.get(username).isConnected)
				return false;
			else {
				users.get(username).connect();
				return true;
			}
		}
	}
	public boolean disConnectUser(String username){
		synchronized (users) {
			if(!users.get(username).isConnected)
				return false;
			users.get(username).disConnect();
			return true;
		}
	}
	public boolean registerCourse(String username, int num){
		synchronized (users) {
			synchronized (courses) {
				if(!kdamCheck(username,num))
					return false;
				User user = users.get(username);
				boolean output = courses.get(num).addStudent(username);
				if(output)
					((Student) user).addCourse(num);
				return output;
			}
		}
	}
	public String getCourseStatus(int num){
		synchronized (courses){
			Course course=courses.get(num);
			return "ACK 7\n" + "Course: (" + num + ") " + course.getCourseName() + "\n" +
					"Seats Available: " + course.getAvailableSeats() + "/" + course.getTotalStudents() + "\n" +
					"Students Registered: " + course.getStudentList().toString().replaceAll("\\s+" , "");

		}
	}
	public String isReg(String username,int num){
		synchronized (users){
			synchronized (courses){
				Course c = courses.get(num);

				if(c.getStudentList().contains(username)) {
					return "ACK 9\n" + "REGISTERED";
				}

				return "ACK 9\n"+"NOT REGISTERED";
			}

		}
	}

	public static Course readLine(String data){
		//start
		String nameCourse = " ";
		int numberCourse = 0;
		int[] kdam = null;
		int maxStudents = 0;
		int counter = 0;
		for (int i = 0 ; i < data.length(); i++) {
			char ch ;
			StringBuilder reader = new StringBuilder();
			while (i < data.length() && data.charAt(i) != '|'){
				ch = data.charAt(i);
				reader.append(ch);
				i++;
			}
			counter++;
			if (counter == 1){
				numberCourse = Integer.parseInt(reader.toString());
			}
			else if (counter == 2){
				nameCourse = reader.toString();
			}
			else if (counter == 3){
				if (reader.length() > 2) {
					reader = new StringBuilder(reader.substring(1, reader.length() - 1));
					reader = new StringBuilder(reader.toString().replace(',', ' '));
					kdam = Arrays.stream(reader.toString().split(" ")).mapToInt(Integer::parseInt).toArray();
				}
				else {
					kdam = new int[0];
				}
			}
			else if(counter == 4){
				maxStudents = Integer.parseInt(reader.toString());
			}
		}
		return new Course(numberCourse , nameCourse , kdam , maxStudents);

	}
	//just added
//	public boolean connectUser(String name , String pass){
//		synchronized (users) {
//			User u = this.getUser(name);
//			if (u.password==pass)
//				return true;
//			if (u.getPassword() == pass)
//				return true;
//			return false;
//		}
//	}
	//finish just
	//add now
	public boolean Registered(){
		synchronized (users) {
			return !users.isEmpty();
		}
	}
	//finish

}

