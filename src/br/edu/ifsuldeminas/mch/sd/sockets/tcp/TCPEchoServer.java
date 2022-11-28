package br.edu.ifsuldeminas.mch.sd.sockets.tcp;
import java.net.Socket;

public class TCPEchoServer {
	public static void main(String[] args) {
		int serverPort = 3000;
		Socket socket = null;
		ServerConnection serverConnection = new ServerConnection();
		try {
			serverConnection.start(serverPort);
			while (true) {

				serverConnection.connect();
				socket = serverConnection.getSocket();

				new ServerThread(socket);
			}
		} finally {
			serverConnection.isServerSocketNull();
		}
	}
}