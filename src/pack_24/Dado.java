package pack_24;

import java.security.SecureRandom;

public class Dado {

	public enum CaraDado {
		A(1), B(2), C(3), D(4), E(5), F(6);

		private final int valor;

		private CaraDado(int valor) {
			this.valor = valor;
		}

		public int getValor() {
			return valor;
		}
	}

	// Lista con los nombres y los valores asignados a las caras del dado
	private CaraDado[] carasDelDado = CaraDado.values();
	private final int id;
	private CaraDado caraSuperior;

	public Dado(int id) {
		this.id = id;
	}

	// Simula lanzamiento del dado y asigda un valor enum a la cara superior
	public void lanzarDado() {
		SecureRandom random = new SecureRandom();
		int randonIndex = random.nextInt(6);
		caraSuperior = carasDelDado[randonIndex];
	}

	public int getValorCaraSuperior() {
		return caraSuperior.getValor();
	}
	
	public int getId() {
		return id;
	}
}
