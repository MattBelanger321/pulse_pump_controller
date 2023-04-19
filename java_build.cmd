cd "C:\Users\Matthew\Desktop\true_phantom\pulse_pump_controller\build"

dir /s /B ..\*.java > .\sources.txt
javac @sources.txt -d .