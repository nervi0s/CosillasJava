package pack_09;

public class Messenger {

	private String msg;

	synchronized public void sendMessage() {
		System.out.println(msg + " desde " + Thread.currentThread().getName());
	}
	// Podríamos pensar que como hemos añadido la palabra synchronized delente del
	// método (y por lo tanto, solo un hilo va a poder hacer uso de este método
	// hasta que sea liberdo) que el mensaje por consola será alternante entre un
	// hilo y otro, sin embargo, al tener un bucle while infinito en el método run
	// de los hilos, estós están continuamente "compitiendo" por hacer uso del
	// método sincronizado y puede darse la situación de que al liberar el método
	// sincronizado para que lo use otro hilo, puede que el mismo hilo que lo liberó
	// entre a usarlo de nuevo, de hecho es lo que ocurre como vemos en la salida de
	// la consola.
}
