package pack_08;

public class Principal {

	public static void main(String[] args) {
		
		Saludo saludo = new Saludo();

		Thread h1 = new Hilo("Hilo 1", saludo);
		Thread h2 = new Hilo("Hilo 2", saludo);
		
		h1.start();
		h2.start();

		System.out.println("Fin del Main");
		
		
	}

}
