package br.edu.ifsuldeminas.mch.sd.sockets.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnection {
	ServerSocket serverSocket = null;
	Socket socket = null;
	public void start(int serverPort) {
		try {
			serverSocket = new ServerSocket(serverPort);
			System.out.printf("Servidor rodando...\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void connect() {
		try {
			socket = serverSocket.accept();
			System.out.printf("Cliente %s conectando na porta %d ",
					socket.getInetAddress().getHostAddress(),
					socket.getPort());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public Socket getSocket() {

		return socket;
	}
	public void isServerSocketNull(){
		try {
			if (serverSocket != null)
				serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
