if(win32)
        enable_language(RC)
endif()
cmake_minimum_required(VERSION 3.4.1)
set(CMAKE_CXX_STANDARD 11)

add_library(
        native-lib

        SHARED

        src/main/cpp/native-lib.cpp
)
find_library(
        log-lib
        log
)
target_link_libraries(
        native-lib
        ${log-lib}
)