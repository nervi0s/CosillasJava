package pack_05;

import javax.swing.JFrame;

public class Principal {

	public static void main(String[] args) {
		Publisher mensajero = new Publisher("tipo1", "tipo2");

		Marco ventana1 = new Marco("Ventana1", 300, 200, "tipo1");
		Marco ventana2 = new Marco("Ventana2", 300, 200, "tipo2");
		
		ventana1.lamina.setMensajero(mensajero);
		ventana2.lamina.setMensajero(mensajero);
		
		mensajero.subscribe("tipo2", ventana1.lamina);
		mensajero.subscribe("tipo1", ventana2.lamina);

		//mensajero.sendUpdate("tipo1");
	}

}

class Marco extends JFrame {

	public ListenerJPanelWithButtons lamina;

	public Marco(String title, int x, int y, String tipo) {
		setTitle(title);
		setBounds(x, y, 500, 400);

		lamina = new ListenerJPanelWithButtons("a", "b", tipo);
		add(lamina);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
