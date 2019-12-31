package NPCClient;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class NPCClient_1A extends Thread{

	public static void main(String[] args) {

		int port = 4997;

		try {
			Socket client = new Socket("localhost", port);

			System.out.println("Just connected to client: "+client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);

			out.writeUTF("Hello from "+client.getLocalSocketAddress());
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);

			System.out.println("Server says "+in.readUTF());
			client.close();

		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
