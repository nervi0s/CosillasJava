package pack_10;

public class Hilo extends Thread {
	private Object o;
	int counter = 0;
	public Hilo(String nombre, Object o) {
		super(nombre);
		this.o = o;
	}

	@Override
	public void run() {
		while (true) {
			if (this.getName().equals("tic")) {

				tic();

			} else {
				
				tac();
				

			}
		}
	}

	public void tic() {
		synchronized (o) {

			System.out.println("tic");
			try {
				//sleep(2000);
				o.wait();
				System.out.println("he pasao");
				//o.notify();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void tac() {
		synchronized (o) {
			System.out.println("TAC");
			o.notifyAll();
			System.out.println("he notidicado");
			try {
				sleep(3000);
				//o.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
