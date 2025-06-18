package q.thread.ex1;

public class Run {
	//쓰레드 : 프로그램 내에서 실행의 흐름을 가지고있는 최소단위
	//		 main메소드 실행시 메인쓰레드가 실행되는 것이다.
	
	public static void main(String[] args) {
		 	Task t1 = new Task();
		 	
		 	Runnable t2run = new MyRunable();
		 	Thread t2 = new Thread(t2run);
		 	
		 	Thread t3 = new Thread(() -> {
		 		int n1 = 20;
				int n2 = 30;
				
				String name = Thread.currentThread().getName();
				System.out.println(name + " : " + (n1 + n2));
		 	});
		 	
		 	t1.start(); // 쓰레드를 실행시키는 메소드
		 	t2.start();
		 	t3.start();
		 	System.out.println("END : " + Thread.currentThread().getName());
	}

}
