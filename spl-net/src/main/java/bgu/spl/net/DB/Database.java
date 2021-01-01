package bgu.spl.net.DB;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
	public static ConcurrentHashMap<String , User> users = new ConcurrentHashMap<>();
	public static ConcurrentHashMap<Integer , Course> courses = new ConcurrentHashMap<>();

	//to prevent user from creating new Database
	private Database() {
		// רשימת קורסים+קורסי קדם
		//שמות משתמשים+סיסמאות+סוג משתמש
		//סטודנטים+
	}

	/**
	 * Retrieves the single instance of this class.
	 */
	public static Database getInstance() {
		return SingletonHolder.instance;
	}
	
	/**
	 * loades the courses from the file path specified 
	 * into the Database, returns true if successful.
	 */
	boolean initialize(String coursesFilePath) {
		// TODO: implement
		return false;
	}

	private static class SingletonHolder {
		private static Database instance = new Database();
	}
	public Course getCourse(int num){
		return courses.get(num);
	}

	public boolean userChack (String username){
		if(username==null || users.containsKey(username))
			return true;
		return false;
	}
	public void addUser(User user){
		String username = user.username;
		users.put(username,user);
	}
	public User getUser(String username){
		return users.get(username);
	}

	public static  void courseReader(String[] args) {
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
	public void connectUser(String username){
		users.get(username).connect();
	}
	public void disConnectUser(String username){
		users.get(username).disConnect();
	}
	public void registerCourse(String username, int num){
		User user = users.get(username);
		((Student)user).addCourse(num);
		courses.get(num).addStudent(username);
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
			String reader = new String();
			while (i < data.length() && data.charAt(i) != '|'){
				ch = data.charAt(i);
				reader = reader + ch;
				i++;
			}
			counter++;
			if (counter == 1){
				numberCourse = Integer.parseInt(reader);
			}
			else if (counter == 2){
				nameCourse = reader;
			}
			else if (counter == 3){
				if (reader.length() > 2) {
					reader = reader.substring(1, reader.length()-1);
					reader = reader.replace(',', ' ');
					kdam = Arrays.stream(reader.split(" ")).mapToInt(Integer::parseInt).toArray();
				}
				else {
					kdam = new int[0];
				}
			}
			else if(counter == 4){
				maxStudents = Integer.parseInt(reader);
			}
		}
		Course toAdd = new Course(numberCourse , nameCourse , kdam , maxStudents);

		return toAdd;
	}


}


