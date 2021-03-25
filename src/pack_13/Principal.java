package pack_13;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Principal {

	public static void main(String[] args) {
		boolean[] completed = { false };

		ExecutorService es = Executors.newFixedThreadPool(4);

		Future<Integer> f = es.submit(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + " hola " + i);
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 1;
		});

		System.out.println(f.isDone());

		if (!completed[0]) {
			es.submit(() -> {
				while (!completed[0]) {
					System.out.println(Thread.currentThread().getName() + " esperando");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}

		try {
			System.out.println(f.get());
			completed[0] = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println(f.isDone());

		es.shutdown();

		System.out.println(Thread.currentThread().getName() + " lol");
		
		System.out.println(Message.getInstance());

	}

}

class Message {

	private static Message instance;

	private Message() {
		if (instance != null) {
			;
		} else {
			instance = new Message();
		}
	}

	public static Message getInstance() {
		return new Message();
	}
}