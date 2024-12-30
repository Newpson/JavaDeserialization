cmake_minimum_required(VERSION 3.27)
project(Demo Java)

find_package(Java COMPONENTS Development REQUIRED)
include(UseJava)

find_jar(LIB_OPENCSV
	NAMES opencsv commons-lang3
	PATHS lib)

add_subdirectory(newpson/bullshit)
