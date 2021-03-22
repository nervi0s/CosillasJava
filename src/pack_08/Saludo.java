package pack_08;

public class Saludo {

	// synchronized delante de un método se usa para que los hilos que accedan a la
	// misma instancia de esta clase, queden sincronizados de manera tal que un
	// único hilo pueda estar haciendo uno de este método a la vez.

	synchronized public void saludar() {
//		System.out.println("Hola desde " + Thread.currentThread().getName());

		for (int i = 1; i <= 200; i++) {
			System.out.println("Hola desde " + Thread.currentThread().getName());
		}
	}
}
