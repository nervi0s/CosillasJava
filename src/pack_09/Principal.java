package pack_09;

public class Principal {

	public static void main(String[] args) {
		Messenger messenger = new Messenger();

		/*Thread h1 = new Thread() {
			public void run() {
				setName("HILO 1");
				while (true) {
					messenger.sendMessage();
				}
			};
		};

		Thread h2 = new Thread() {
			public void run() {
				while (true) {
					setName("HILO 2");
					messenger.sendMessage();
				}
			};
		};

		h1.start();
		h2.start();*/
		
		Hilo t1 = new Hilo(messenger);
		Hilo t2 = new Hilo(messenger);
		
		t1.start();
		t2.start();
	}

}
