package pack_11;

public class Principal {

	public static void main(String[] args) {

		Object o = new Object();
		ParImparHilo h1 = new ParImparHilo("Hilo Par", o);
		ParImparHilo h2 = new ParImparHilo("Hilo Impar", o);

		h1.start();
		h2.start();

	}

}

class ParImparHilo extends Thread {

	private static Integer intObject = 0;
	private Object o;

	public ParImparHilo(String nombre, Object o) {
		super(nombre);
		this.o = o;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (o) {
				System.out.println(getName() + " -> " + intObject++);
				try {
					Thread.sleep(1000);
					o.notifyAll();
					o.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

//	// Otra solucion
//	@Override
//	public void run() {
//		while (true) {
//			synchronized (ParImparHilo.class) {
//				System.out.println(getName() + " -> " + intObject++);
//				try {
//					Thread.sleep(1000);
//					ParImparHilo.class.notifyAll();
//					ParImparHilo.class.wait();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
}
