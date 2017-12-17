# Sets the minimum version of CMake required to build the native
# library. You should either keep the default value or only pass a
# value of 3.4.0 or lower.
# by huzongyao

cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wall -DZLIB_STATIC -D__linux__ -D__CYGWIN__ -DANDROID")
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wcast-align -Wwrite-strings -Wstrict-prototypes -Winline")
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -O3 -s -fomit-frame-pointer -falign-functions=32 -finline-limit=3200")

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds it for you.
# Gradle automatically packages shared libraries with your APK.
file(GLOB_RECURSE NATIVE_SRCS "*.c")

add_library(droidzebra SHARED ${NATIVE_SRCS})

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in the
# build script, prebuilt third-party libraries, or system libraries.
target_link_libraries(droidzebra log z m)
