package q.thread.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 3000);
			
			ClientSend cs = new ClientSend(socket);
			cs.start();
			
			ClientReceive cr = new ClientReceive(socket);
			cr.start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}