package pack_10;

public class Principal {

	public static void main(String[] args) {

		TicTac o = new TicTac();

		HiloTicTac h1 = new HiloTicTac(1, o);
		HiloTicTac h2 = new HiloTicTac(2, o);

		h1.start();
		h2.start();

	}

}
