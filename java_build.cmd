cd ".\build"

dir /s /B ..\*.java > .\sources.txt
javac -cp ..\jSerialComm.jar; @sources.txt -d .