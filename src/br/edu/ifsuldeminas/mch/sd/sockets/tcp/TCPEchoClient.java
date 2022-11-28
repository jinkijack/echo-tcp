package br.edu.ifsuldeminas.mch.sd.sockets.tcp;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TCPEchoClient {
	public static String KEY_TO_EXIT = "q";
	public static void main(String[] args) {

		String serverName = "localhost";
		int serverPort = 3000;

		Scanner reader = new Scanner(System.in);
		String message = "";
		ClientConnection clientConnection = new ClientConnection();
		try {
			while (!message.equals(KEY_TO_EXIT)) {
				System.out.printf("Digite uma mensagem (%s para sair): ",
						KEY_TO_EXIT);
				message = reader.nextLine();

				clientConnection.conectar(serverPort, serverName);

				clientConnection.send(message);
				clientConnection.receive();

			}
			reader.close();
		}
		catch (NoSuchElementException noSuchElementException) {
			noSuchElementException.printStackTrace();
		}
		finally {
			if (reader != null) {
				reader.close();
			}
			clientConnection.isSocketNull();
		}

	}
}