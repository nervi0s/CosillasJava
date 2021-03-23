package pack_10;

public class Principal {

	public static void main(String[] args) {

		Object o = new Object();

		Hilo h1 = new Hilo("tic", o);
		Hilo h2 = new Hilo("TAC", o);

		h1.start();
		h2.start();

	}

}
