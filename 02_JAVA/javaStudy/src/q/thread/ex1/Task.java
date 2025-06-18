package q.thread.ex1;

//쓰레드를 만드는 방법1
//Thread클래스를 상속받는 클래스를 작성한다.
public class Task extends Thread{

	@Override
	public void run() {
		int n1 = 20;
		int n2 = 30;
		
		//Thread.currentThread() : 지금 실행하고 있는 쓰레드의 정보객체를 반환
		String name = Thread.currentThread().getName();
		System.out.println(name + " : " + (n1 + n2));
		super.run();
	}
		
}
