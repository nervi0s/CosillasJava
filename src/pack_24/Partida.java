package pack_24;

public class Partida {

	public static void main(String[] args) {

		Dado dado1 = new Dado(1);
		Dado dado2 = new Dado(2);
		Jugador jugado1 = new Jugador("Max", dado1, dado2);
		
		jugado1.jugar();
	}

}
