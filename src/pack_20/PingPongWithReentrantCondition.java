package pack_20;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PingPongWithReentrantCondition {

	// Objeto usado para el bloqueo
	public static final ReentrantLock locker = new ReentrantLock(true);

	public static void main(String[] args) {

		Condition c = locker.newCondition();
		PingPong ping = new PingPong("PING", c);
		PingPong pong = new PingPong("pong", c);

		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<Integer> futurePing = executorService.submit(ping);
		Future<Integer> futurePong = executorService.submit(pong);

		try {
			System.out.printf("Ping se ha impreso: %d de veces.%n", futurePing.get()); // Recordad que el métdo get
																						// detiene al hilo que lo llama
																						// hasta completar la taréa
			System.out.printf("Pong se ha impreso: %d de veces.%n", futurePong.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		executorService.shutdown();

		System.out.println("Fin del main");
	}

}

class PingPong implements Callable<Integer> {

	private int counter = 0;
	private final String name;
	private final Condition condition; // Condition usada para la instancia de ReentrantLock

	private static AtomicBoolean canSayPing = new AtomicBoolean();

	public PingPong(String name, Condition condition) {
		this.name = name;
		this.condition = condition;
	}

	@Override
	public Integer call() throws Exception {
		for (int i = 1; i <= 500; i++) {
			if (name.equalsIgnoreCase("ping")) {
				sayPing();
			} else {
				sayPong();
			}
			++counter;
		}
		return counter;
	}

	public void sayPing() throws InterruptedException {

		PingPongWithReentrantCondition.locker.lock();

		try {
			while (!canSayPing.get()) {
				condition.await(0, TimeUnit.SECONDS);
			}
			System.out.println(name);
			canSayPing.set(false);
			condition.signal();
		} finally {
			PingPongWithReentrantCondition.locker.unlock();
		}

	}

	public void sayPong() throws InterruptedException {

		PingPongWithReentrantCondition.locker.lock();

		try {
			while (canSayPing.get()) {
				condition.await(0, TimeUnit.SECONDS);
			}
			System.out.println(name);
			canSayPing.set(true);
			condition.signal();
		} finally {
			PingPongWithReentrantCondition.locker.unlock();
		}
	}

}