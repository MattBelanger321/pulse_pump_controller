package app;

import com.fazecast.jSerialComm.*;

class main {

	public static void main(String[] args) {
		main_frame frame = new main_frame();

		SerialPort[] ports = SerialPort.getCommPorts();

		for (int i = 0; i < ports.length; i++) {
			System.out.println(ports[i]);
		}
	}
}