package q.thread.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(3000);
			System.out.println("요청을 기다리는중입니다...");
			Socket socket = server.accept();
			System.out.println(socket.getInetAddress().getHostAddress() + "가 요청중입니다.");
			
			ServerSend ss = new ServerSend(socket);
			ss.start();
			
			ServerReceive sr = new ServerReceive(socket);
			sr.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
