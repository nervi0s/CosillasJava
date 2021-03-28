package pack_15;

import java.util.concurrent.Phaser;

public class App {

	public static void main(String[] args) {
		System.out.println("Hola desde el main");

		while (true) {
			Phaser ph = new Phaser();

			Mensajero mensajeroPing = new Mensajero("PING", ph);

			// Hasta ahora tenemos un Phaser con 1 tarea registrada, registraremos el hilo
			// main como una tarea más para que se el que coordine a los demás hilos
			ph.register();

			// System.out.println("Estamos en la fase: ---> " + ph.getPhase());

			new Thread(mensajeroPing).start();

			// Necesitamos llamar una vez más a este método para que los registros y las
			// llegadas del Phaser sean iguales y pueda empezar a hacer la tereas
			// correspondientes a esta fase
			ph.arriveAndAwaitAdvance();

			// En este punto habrá registrada 1 taréa (ya que la del main no la hemos
			// desregistrado)
			Mensajero mensajeroPong = new Mensajero("pong", ph); // Ahora hanbrán 2 tareas registradas

			new Thread(mensajeroPong).start();

			ph.arriveAndAwaitAdvance();
		}

	}

}

class Mensajero implements Runnable {

	private Phaser phaser;
	private String name;

	// En este caso, usaremos un Phaser común a las instancias de esta clase
	public Mensajero(String name, Phaser phaser) {
		this.name = name;
		this.phaser = phaser;
		phaser.register();
	}

	@Override
	public void run() {
		Thread.currentThread().setName(name);
		// Espereamos a que el Phaser pueda avanzar hasta el que número de registros
		// "register()" sea igual al número de llegadas "arrive..."
		phaser.arriveAndAwaitAdvance();
		for (int i = 0; i < 5; i++) {
			System.out.println(name);
		}
		// Desregistramos a esta party
		// System.out.println("Estamos en la fase: ---> " + phaser.getPhase());
		phaser.arriveAndDeregister();
	}
}
