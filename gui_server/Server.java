package gui_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Server {

	public static final int PORT = 55588;
	private ServerSocket serverSocket; // This application's endpoin
	private Socket client; // Socket of the application sending files for the Bot

	public DataOutputStream arduinoOutStrean;
	public DataInputStream arduinoInStrean;

	Server() {
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("Awaiting Connection...");
			client = serverSocket.accept(); // client is now the endpoint of the arduino client
			System.out.println("Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void send_command(byte[] command) throws IOException {
		int bytes_wrote = 0;
		arduinoOutStrean.write(command, 0, command.length);
	}

}
