# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.17

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /snap/clion/138/bin/cmake/linux/bin/cmake

# The command to remove a file.
RM = /snap/clion/138/bin/cmake/linux/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/spl211/Desktop/tester/Client

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/spl211/Desktop/tester/Client/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/src.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/src.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/src.dir/flags.make

CMakeFiles/src.dir/src/client.cpp.o: CMakeFiles/src.dir/flags.make
CMakeFiles/src.dir/src/client.cpp.o: ../src/client.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/spl211/Desktop/tester/Client/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/src.dir/src/client.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/src.dir/src/client.cpp.o -c /home/spl211/Desktop/tester/Client/src/client.cpp

CMakeFiles/src.dir/src/client.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/src.dir/src/client.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/spl211/Desktop/tester/Client/src/client.cpp > CMakeFiles/src.dir/src/client.cpp.i

CMakeFiles/src.dir/src/client.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/src.dir/src/client.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/spl211/Desktop/tester/Client/src/client.cpp -o CMakeFiles/src.dir/src/client.cpp.s

CMakeFiles/src.dir/src/connectionHandler.cpp.o: CMakeFiles/src.dir/flags.make
CMakeFiles/src.dir/src/connectionHandler.cpp.o: ../src/connectionHandler.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/spl211/Desktop/tester/Client/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/src.dir/src/connectionHandler.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/src.dir/src/connectionHandler.cpp.o -c /home/spl211/Desktop/tester/Client/src/connectionHandler.cpp

CMakeFiles/src.dir/src/connectionHandler.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/src.dir/src/connectionHandler.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/spl211/Desktop/tester/Client/src/connectionHandler.cpp > CMakeFiles/src.dir/src/connectionHandler.cpp.i

CMakeFiles/src.dir/src/connectionHandler.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/src.dir/src/connectionHandler.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/spl211/Desktop/tester/Client/src/connectionHandler.cpp -o CMakeFiles/src.dir/src/connectionHandler.cpp.s

CMakeFiles/src.dir/src/messageDecoder.cpp.o: CMakeFiles/src.dir/flags.make
CMakeFiles/src.dir/src/messageDecoder.cpp.o: ../src/messageDecoder.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/spl211/Desktop/tester/Client/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building CXX object CMakeFiles/src.dir/src/messageDecoder.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/src.dir/src/messageDecoder.cpp.o -c /home/spl211/Desktop/tester/Client/src/messageDecoder.cpp

CMakeFiles/src.dir/src/messageDecoder.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/src.dir/src/messageDecoder.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/spl211/Desktop/tester/Client/src/messageDecoder.cpp > CMakeFiles/src.dir/src/messageDecoder.cpp.i

CMakeFiles/src.dir/src/messageDecoder.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/src.dir/src/messageDecoder.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/spl211/Desktop/tester/Client/src/messageDecoder.cpp -o CMakeFiles/src.dir/src/messageDecoder.cpp.s

CMakeFiles/src.dir/src/messageEncoder.cpp.o: CMakeFiles/src.dir/flags.make
CMakeFiles/src.dir/src/messageEncoder.cpp.o: ../src/messageEncoder.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/spl211/Desktop/tester/Client/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Building CXX object CMakeFiles/src.dir/src/messageEncoder.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/src.dir/src/messageEncoder.cpp.o -c /home/spl211/Desktop/tester/Client/src/messageEncoder.cpp

CMakeFiles/src.dir/src/messageEncoder.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/src.dir/src/messageEncoder.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/spl211/Desktop/tester/Client/src/messageEncoder.cpp > CMakeFiles/src.dir/src/messageEncoder.cpp.i

CMakeFiles/src.dir/src/messageEncoder.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/src.dir/src/messageEncoder.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/spl211/Desktop/tester/Client/src/messageEncoder.cpp -o CMakeFiles/src.dir/src/messageEncoder.cpp.s

CMakeFiles/src.dir/src/echoClient.cpp.o: CMakeFiles/src.dir/flags.make
CMakeFiles/src.dir/src/echoClient.cpp.o: ../src/echoClient.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/spl211/Desktop/tester/Client/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_5) "Building CXX object CMakeFiles/src.dir/src/echoClient.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/src.dir/src/echoClient.cpp.o -c /home/spl211/Desktop/tester/Client/src/echoClient.cpp

CMakeFiles/src.dir/src/echoClient.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/src.dir/src/echoClient.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/spl211/Desktop/tester/Client/src/echoClient.cpp > CMakeFiles/src.dir/src/echoClient.cpp.i

CMakeFiles/src.dir/src/echoClient.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/src.dir/src/echoClient.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/spl211/Desktop/tester/Client/src/echoClient.cpp -o CMakeFiles/src.dir/src/echoClient.cpp.s

# Object files for target src
src_OBJECTS = \
"CMakeFiles/src.dir/src/client.cpp.o" \
"CMakeFiles/src.dir/src/connectionHandler.cpp.o" \
"CMakeFiles/src.dir/src/messageDecoder.cpp.o" \
"CMakeFiles/src.dir/src/messageEncoder.cpp.o" \
"CMakeFiles/src.dir/src/echoClient.cpp.o"

# External object files for target src
src_EXTERNAL_OBJECTS =

src: CMakeFiles/src.dir/src/client.cpp.o
src: CMakeFiles/src.dir/src/connectionHandler.cpp.o
src: CMakeFiles/src.dir/src/messageDecoder.cpp.o
src: CMakeFiles/src.dir/src/messageEncoder.cpp.o
src: CMakeFiles/src.dir/src/echoClient.cpp.o
src: CMakeFiles/src.dir/build.make
src: CMakeFiles/src.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/spl211/Desktop/tester/Client/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_6) "Linking CXX executable src"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/src.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/src.dir/build: src

.PHONY : CMakeFiles/src.dir/build

CMakeFiles/src.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/src.dir/cmake_clean.cmake
.PHONY : CMakeFiles/src.dir/clean

CMakeFiles/src.dir/depend:
	cd /home/spl211/Desktop/tester/Client/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/spl211/Desktop/tester/Client /home/spl211/Desktop/tester/Client /home/spl211/Desktop/tester/Client/cmake-build-debug /home/spl211/Desktop/tester/Client/cmake-build-debug /home/spl211/Desktop/tester/Client/cmake-build-debug/CMakeFiles/src.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/src.dir/depend

