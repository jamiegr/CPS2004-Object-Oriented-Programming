# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.10

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


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
CMAKE_COMMAND = /opt/clion-2018.1.2/bin/cmake/bin/cmake

# The command to remove a file.
RM = /opt/clion-2018.1.2/bin/cmake/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/jamie/CLionProjects/OOPCPP

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/jamie/CLionProjects/OOPCPP/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/OOPCPP.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/OOPCPP.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/OOPCPP.dir/flags.make

CMakeFiles/OOPCPP.dir/main.cpp.o: CMakeFiles/OOPCPP.dir/flags.make
CMakeFiles/OOPCPP.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/jamie/CLionProjects/OOPCPP/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/OOPCPP.dir/main.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/OOPCPP.dir/main.cpp.o -c /home/jamie/CLionProjects/OOPCPP/main.cpp

CMakeFiles/OOPCPP.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/OOPCPP.dir/main.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/jamie/CLionProjects/OOPCPP/main.cpp > CMakeFiles/OOPCPP.dir/main.cpp.i

CMakeFiles/OOPCPP.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/OOPCPP.dir/main.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/jamie/CLionProjects/OOPCPP/main.cpp -o CMakeFiles/OOPCPP.dir/main.cpp.s

CMakeFiles/OOPCPP.dir/main.cpp.o.requires:

.PHONY : CMakeFiles/OOPCPP.dir/main.cpp.o.requires

CMakeFiles/OOPCPP.dir/main.cpp.o.provides: CMakeFiles/OOPCPP.dir/main.cpp.o.requires
	$(MAKE) -f CMakeFiles/OOPCPP.dir/build.make CMakeFiles/OOPCPP.dir/main.cpp.o.provides.build
.PHONY : CMakeFiles/OOPCPP.dir/main.cpp.o.provides

CMakeFiles/OOPCPP.dir/main.cpp.o.provides.build: CMakeFiles/OOPCPP.dir/main.cpp.o


# Object files for target OOPCPP
OOPCPP_OBJECTS = \
"CMakeFiles/OOPCPP.dir/main.cpp.o"

# External object files for target OOPCPP
OOPCPP_EXTERNAL_OBJECTS =

OOPCPP: CMakeFiles/OOPCPP.dir/main.cpp.o
OOPCPP: CMakeFiles/OOPCPP.dir/build.make
OOPCPP: CMakeFiles/OOPCPP.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/jamie/CLionProjects/OOPCPP/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable OOPCPP"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/OOPCPP.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/OOPCPP.dir/build: OOPCPP

.PHONY : CMakeFiles/OOPCPP.dir/build

CMakeFiles/OOPCPP.dir/requires: CMakeFiles/OOPCPP.dir/main.cpp.o.requires

.PHONY : CMakeFiles/OOPCPP.dir/requires

CMakeFiles/OOPCPP.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/OOPCPP.dir/cmake_clean.cmake
.PHONY : CMakeFiles/OOPCPP.dir/clean

CMakeFiles/OOPCPP.dir/depend:
	cd /home/jamie/CLionProjects/OOPCPP/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/jamie/CLionProjects/OOPCPP /home/jamie/CLionProjects/OOPCPP /home/jamie/CLionProjects/OOPCPP/cmake-build-debug /home/jamie/CLionProjects/OOPCPP/cmake-build-debug /home/jamie/CLionProjects/OOPCPP/cmake-build-debug/CMakeFiles/OOPCPP.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/OOPCPP.dir/depend

