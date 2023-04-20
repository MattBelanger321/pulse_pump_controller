package app;

import com.fazecast.jSerialComm.*;

// This class will send messages to the arduino

public class Arduino {
	private static String portDescriptor = "PCI Serial Port";
	private SerialPort port;

	public Arduino() {

		SerialPort ports[] = SerialPort.getCommPorts();

		SerialPort.getCommPort(portDescriptor);

		for (SerialPort p : ports) {
			if (p.getPortDescription().equals(portDescriptor)) {
				port = p;
				break;
			}
		}

		System.out.println(port);
	}
}
