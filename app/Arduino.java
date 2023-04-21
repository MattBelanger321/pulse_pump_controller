package app;

import java.nio.ByteBuffer;

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
			System.out.println(p);
		}
	}

	public void sendStart() {
		String message = "START;";

		byte[] byteStream = message.getBytes();

		System.out.println("Writing: " + message);

		int bytesWritten = 0;

		if (port != null && port.isOpen()) {
			bytesWritten = port.writeBytes(byteStream, byteStream.length);
		}

		System.out.println("Wrote " + bytesWritten + " Bytes");
	}

	public void sendStop() {
		String message = "STOP;";

		byte[] byteStream = message.getBytes();

		System.out.println("Writing: " + message);

		int bytesWritten = 0;

		if (port != null && port.isOpen()) {
			bytesWritten = port.writeBytes(byteStream, byteStream.length);
		}

		System.out.println("Wrote " + bytesWritten + " Bytes");
	}

	public void sendHome() {
		String message = "HOME;";

		byte[] byteStream = message.getBytes();

		System.out.println("Writing: " + message);

		int bytesWritten = 0;

		if (port != null && port.isOpen()) {
			bytesWritten = port.writeBytes(byteStream, byteStream.length);
		}

		System.out.println("Wrote " + bytesWritten + " Bytes");
	}

	public void sendPosition(int start, int stop) { // positions are in mm

		String message = String.format("POSITION:%d:%d;", start, stop);

		byte[] byteStream = message.getBytes();

		System.out.println("Writing: " + message);

		int bytesWritten = 0;

		if (port != null && port.isOpen()) {
			bytesWritten = port.writeBytes(byteStream, byteStream.length);
		}

		System.out.println("Wrote " + bytesWritten + " Bytes");
	}

	public void sendDelay(int delay) { // delay is in ms

		String message = String.format("DELAY:%d;", delay);

		byte[] byteStream = message.getBytes();

		System.out.println("Writing: " + message);

		int bytesWritten = 0;

		if (port != null && port.isOpen()) {
			bytesWritten = port.writeBytes(byteStream, byteStream.length);
		}

		System.out.println("Wrote " + bytesWritten + " Bytes");
	}

	public void sendDuration(int duration) { // Duration is in ms

		String message = String.format("DURATION:%d;", duration);

		byte[] byteStream = message.getBytes();

		System.out.println("Writing: " + message);

		int bytesWritten = 0;

		if (port != null && port.isOpen()) {
			bytesWritten = port.writeBytes(byteStream, byteStream.length);
		}

		System.out.println("Wrote " + bytesWritten + " Bytes");
	}

	public boolean isOpen() {
		return port.isOpen();
	}
}
