package pack_24;

public class Jugador {

	private enum Estado {
		GANA, PIERDE, CONTINUA;
	}

	private String nombre;
	private Dado dado1;
	private Dado dado2;
	private int lanzamientoNum;

	public Jugador(String name, Dado d1, Dado d2) {
		nombre = name;
		dado1 = d1;
		dado2 = d2;
	}

	public void jugar() {
		Estado estado;
		lanzarDados();

		int resultadoLanzamiento = dado1.getValorCaraSuperior() + dado2.getValorCaraSuperior();

		switch (resultadoLanzamiento) {
		case 2:
		case 3:
		case 12:
			estado = Estado.PIERDE;
			mostrarMensaje(estado, resultadoLanzamiento, lanzamientoNum);
			break;
		case 7:
		case 11:
			estado = Estado.GANA;
			mostrarMensaje(estado, resultadoLanzamiento, lanzamientoNum);
			break;
		default:
			estado = Estado.CONTINUA;
			int punto = resultadoLanzamiento;
			mostrarMensaje(estado, resultadoLanzamiento, lanzamientoNum);

			while (resultadoLanzamiento != 7) {
				lanzarDados();
				resultadoLanzamiento = dado1.getValorCaraSuperior() + dado2.getValorCaraSuperior();

				if (resultadoLanzamiento == punto) {
					estado = Estado.GANA;
					mostrarMensaje(estado, resultadoLanzamiento, lanzamientoNum);
					break;
				} else if (resultadoLanzamiento == 7) {
					estado = Estado.PIERDE;
					mostrarMensaje(estado, resultadoLanzamiento, lanzamientoNum);
					break;
				}

				mostrarMensaje(estado, resultadoLanzamiento, lanzamientoNum);
			}
			break;
		}
	}

	private void lanzarDados() {
		// Lanza los dados
		dado1.lanzarDado();
		dado2.lanzarDado();
		lanzamientoNum++;
	}

	private void mostrarMensaje(Estado e, int resultadoLanzamiento, int numLanzamiento) {
		System.out.printf("El jugador %s --> %s. Ha sacado %d en su lanzamiento número: %d%n", nombre, e.name(),
				resultadoLanzamiento, numLanzamiento);
	}
}
