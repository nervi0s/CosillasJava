package pack_09;

public class Messenger {

	private String msg;

	synchronized public void sendMessage() {
		System.out.println(msg + " desde " + Thread.currentThread().getName());
	}
	// Podr�amos pensar que como hemos a�adido la palabra synchronized delente del
	// m�todo (y por lo tanto, solo un hilo va a poder hacer uso de este m�todo
	// hasta que sea liberdo) que el mensaje por consola ser� alternante entre un
	// hilo y otro, sin embargo, al tener un bucle while infinito en el m�todo run
	// de los hilos, est�s est�n continuamente "compitiendo" por hacer uso del
	// m�todo sincronizado y puede darse la situaci�n de que al liberar el m�todo
	// sincronizado para que lo use otro hilo, puede que el mismo hilo que lo liber�
	// entre a usarlo de nuevo, de hecho es lo que ocurre como vemos en la salida de
	// la consola.
}
