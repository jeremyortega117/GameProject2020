package NPCServer;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import javax.swing.JButton;
import javax.swing.JFrame;

import NPCClient.NPCClient_1A;

public class NPCServer_1A extends Thread{

	private ServerSocket serverSocket;

	public NPCServer_1A(int port) throws IOException
	{
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}

	public void run(){
		while(true){
			try{
				System.out.println("Waiting for client on port "+serverSocket.getLocalPort()+"...");
				Socket server = serverSocket.accept();

				System.out.print("just connected to server: "+ server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());

				System.out.println(in.readUTF());
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				out.writeUTF("Thank you for connecting to "+server.getLocalSocketAddress()+"\nGoodbye!");

				server.close();
			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
			} catch (IOException e){
				e.printStackTrace();
				break;
			}
		}
	}


	public static void main(String[] args) {
		int port = 4997;


		try{
			Thread t = new NPCServer_1A(port);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
