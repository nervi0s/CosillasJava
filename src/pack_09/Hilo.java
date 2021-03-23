package pack_09;

public class Hilo extends Thread {
	private Messenger mensajero;

	public Hilo(Messenger mensajero) {
		this.mensajero = mensajero;
	}

	@Override
	public void run() {
		while (true) {
			mensajero.sendMessage();
		}
	}
}
