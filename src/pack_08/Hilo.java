package pack_08;

public class Hilo extends Thread {

	private Saludo saludo;

	public Hilo(String nombre, Saludo saludo) {
		super(nombre);
		this.saludo = saludo;
	}

	@Override
	public void run() {
//		for (int i = 1; i <= 200; i++) {
//			saludo.saludar();
//		}
//		si ponemos el for en el m�todo run a veces cuando la expresi�n de condici�n del for se est� evaluando
//		el m�todo saludar() del objeto compartido saludo queda libre y en ese instante de tiempo puede que otro
//		hilo entre a usarlo sin haber acabo el bucle actual.

		saludo.saludar();
	}

}
