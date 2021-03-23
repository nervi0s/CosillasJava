package pack_09;

public class Messenger {

	private String msg;

	synchronized public void sendMessage() {
		System.out.println(msg + " desde " + Thread.currentThread().getName());
	}
}
