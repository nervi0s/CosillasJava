package pack_14;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MensajesExecutor {

	public static void main(String[] args) {

		System.out.println("Método main() iniciado\n");

		// Creamos dos tareas que serán dos hilos que comparten un objeto en común que
		// es el de la clase Message
		Message message = Message.getInstance();
		Customer c1 = new Customer("Peter", message);
		Customer c2 = new Customer("Homer", message);

		// Creamos un ExecutorService usando un método estático de Executors, el objeto
		// "execService" nos permitirá inciar nuevas taréas asíncronas
		ExecutorService execService = Executors.newFixedThreadPool(4);

		// Iniciamos las tareas
		execService.submit(c1);
		execService.submit(c2);

		// Se invoca el método para decir que acabe con las taréas pendientes y después
		// se apague
		execService.shutdown();

		// Mientras execService no haya acabado todas las teréas esperamos
		while (!execService.isTerminated()) {
			System.out.println("Esperando a que acaben las tareas");
			try {
				Thread.sleep(500);// Añadimos una demora pequeña entre mensajes
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Instant.now() nos da el instante de tiempo en que ha sido llamado
		System.out.println("\nVamos a mostrar los menasjes generados por los hilos: " + Instant.now() + "\n");

		// Si no esperamos e intentamos mostrar el contenido de la lista veremos que
		// está vacía o incompleta
		for (String msg : message.outputs) {
			System.out.println(msg);
		}

		System.out.println("\nMétodo main() finalizado");

	}

}

//Clase con un Singleton que será el objeto compartido
class Message {

	private static Message instance;

	// Hacemos la variable de instancia pública para leerla más cómodamente
	public final List<String> outputs = new ArrayList<>(100);

	private Message() {
	}

	public static Message getInstance() {
		if (instance != null) {
			return instance;
		} else {
			instance = new Message();
			return instance;
		}
	}

	public void sendMessage() {
		String msg = "Hello from " + Thread.currentThread().getName() + " at: " + Instant.now();
		outputs.add(msg);
	}

}

class Customer implements Runnable {

	private Message message;
	private String name;

	public Customer(String name, Message message) {
		this.name = name;
		this.message = message;
	}

	@Override
	public void run() {
		// Asignamos al hilo que llame a este Runnable un nombre
		Thread.currentThread().setName(name);

		for (int i = 1; i <= 10; i++) {
			// Usanmos este diseño de bloque sincronizado para obtener el resultado que
			// queremos en este caso, que es que se muetre un hilo y luego el otro
			synchronized (message) {

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// LLamamaos al método del objeto compartido
				message.sendMessage();

				message.notifyAll();

				try {
					message.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				message.notifyAll();
			}
		}
	}

}