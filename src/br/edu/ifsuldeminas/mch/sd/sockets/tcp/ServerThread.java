package br.edu.ifsuldeminas.mch.sd.sockets.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread{
    private DataInputStream inputFlow;
    private DataOutputStream outputFlow;
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
        try {
            this.inputFlow = new DataInputStream(this.socket.getInputStream());
            this.outputFlow = new DataOutputStream(
                    this.socket.getOutputStream());

            this.start();
        } catch (IOException ioException) {
            System.err.printf("Error creating client connection: %s",
                    ioException.getMessage());
        }
    }

    public void run() {
        boolean client = true;

        while (client) {
            try {
                String clientMensagem = inputFlow.readUTF();
                System.out.printf("Cliente: %d:%d Message > %s \n", this.getId(),
                        socket.getPort(), clientMensagem);
                outputFlow.writeUTF(clientMensagem);
            } catch (IOException ioException) {
                
                try {           	
					socket.close();
					System.err.printf("Cliente: %d:%d Socket closed.\n", this.getId(),
                            socket.getPort());
					client = false;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
            }
        }
    }
}
