package pack_21;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * C�digo encontrado echando un ojo a los repositorios de GitHub del autor que
 * se menciona abajo
 * 
 * Date: 17.05.13 Time: 11:54
 *
 * @author Artem Prigoda
 */

public class PingPongUsingReentrantCondition {

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new PingPongUsingReentrantCondition().work();
		}
	}

	public void work() {
		System.out.println("\nLocks");

		final Lock monitor = new ReentrantLock();
		final Condition condition = monitor.newCondition();
		final AtomicBoolean pingReady = new AtomicBoolean(true);
		final AtomicBoolean pongReady = new AtomicBoolean(false);

		Thread pingThread = new Thread() {
			@Override
			public void run() {
				setName("thread1");
				int i = 0;
				while (i < 3) {
					monitor.lock();
					try {
						while (!pingReady.get()) {
							try {
								condition.await();
							} catch (InterruptedException e) {
								e.printStackTrace();
								return;
							}
						}
						System.out.println("[" + Thread.currentThread().getName() + "] Ping");
						pongReady.set(true);
						pingReady.set(false);
						condition.signalAll();
					} finally {
						monitor.unlock();
					}
					i++;
				}
			}
		};

		Thread pongThread = new Thread() {
			@Override
			public void run() {
				setName("thread2");
				int i = 0;
				while (i < 3) {
					monitor.lock();
					try {
						while (!pongReady.get()) {
							try {
								condition.await();
							} catch (InterruptedException e) {
								e.printStackTrace();
								return;
							}
						}
						System.out.println("[" + Thread.currentThread().getName() + "] Pong");
						pingReady.set(true);
						pongReady.set(false);
						condition.signalAll();
					} finally {
						monitor.unlock();
					}

					i++;
				}
			}
		};

		try {
			pingThread.start();
			pongThread.start();
			pingThread.join();
			pongThread.join();
			System.out.println("Done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}