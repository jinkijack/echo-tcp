package br.edu.ifsuldeminas.mch.sd.sockets.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientConnection {

	Socket socket = null;
	String message = "";
	
	public void conectar(int serverPort, String servername) {
		
		try {
			socket = new Socket(servername, serverPort);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void send(String message) {
		try {
			DataOutputStream outputFlow = new DataOutputStream(socket.getOutputStream());
			outputFlow.writeUTF(message);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void receive() {
		DataInputStream inputFlow;
		try {
			inputFlow = new DataInputStream(socket.getInputStream());
			String reply = inputFlow.readUTF();
			System.out.printf("Resposta> %s \n", reply);
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void isSocketNull() {
		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
}
