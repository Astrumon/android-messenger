@echo off
setlocal enabledelayedexpansion

set JAR_FILE=create.jar

if not exist "%JAR_FILE%" (
    echo Error: %JAR_FILE% not found!
    exit /b 1
)

java -jar "%JAR_FILE%" %*