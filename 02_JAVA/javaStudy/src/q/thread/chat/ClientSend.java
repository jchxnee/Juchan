package q.thread.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSend extends Thread{
	private Socket socket;

	public ClientSend(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try(PrintWriter pw = new PrintWriter(socket.getOutputStream());
				Scanner sc = new Scanner(System.in);) {
			
			while(true) {
			System.out.print("서버로 보낼 내용 : ");
			String message = sc.nextLine();
			pw.println(message);
			pw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.run();
	}
	
	
	
}
