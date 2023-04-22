package app;

import java.nio.charset.StandardCharsets;

import com.fazecast.jSerialComm.*;

// This class will send messages to the arduino

public class Arduino {
	private static String portDescriptor = "Arduino Uno";
	private SerialPort port;

	public Arduino() throws Exception {

		SerialPort ports[] = SerialPort.getCommPorts();

		for (SerialPort p : ports) {
			if (p.getPortDescription().indexOf(portDescriptor, 0) >= 0) {
				port = p;
				break;
			}
		}

		if (port == null) {
			for (SerialPort p : ports) {
				System.out.println(p);
			}

			throw new Exception("No " + portDescriptor + " Port Was Found");
		}

		// 9600 8n1
		port.setBaudRate(9600);
		port.setParity(SerialPort.NO_PARITY);
		port.setNumStopBits(SerialPort.ONE_STOP_BIT);
		port.setNumDataBits(8);
		port.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING | SerialPort.TIMEOUT_WRITE_BLOCKING, 5000, 5000);

		port.openPort();

		byte[] A = { 'A' };
		byte[] in = { 0 };

		while (in[0] == 0)
			port.readBytes(in, 1);

		System.out.println("Handshake Requested");

		int bytes_written = 0;

		while (bytes_written == 0) {
			bytes_written = port.writeBytes(A, 1);
		}

		if (in[0] == 'H')
			System.out.println("Handshake Completed");
		else
			throw new Exception("Bad Handshake Recieved: " + (int) in[0]);

		port.flushIOBuffers();
	}

	public void sendStart() {
		String message = "START;";

		byte[] byteStream = message.getBytes();

		for (byte b : byteStream) {
			System.out.println((int) b);
		}

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

		if (port == null) {
			return false;
		}

		return port.isOpen();
	}
}
