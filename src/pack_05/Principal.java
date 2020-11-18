package pack_05;

import javax.swing.JFrame;

public class Principal {

	public static void main(String[] args) {

		// Creating a new Publisher object
		Publisher mensajero = new Publisher("ventanaTipo1", "ventanaTipo2", "ventanaTipo3", "ventanaTipo4");

		// Creating windows
		Marco ventana1 = new Marco("Ventana 1", 100, 50, "ventanaTipo1");
		Marco ventana2 = new Marco("Ventana 2", 700, 50, "ventanaTipo2");
		Marco ventana3 = new Marco("Ventana 3", 100, 400, "ventanaTipo3");
		Marco ventana4 = new Marco("Ventana 4", 700, 400, "ventanaTipo4");

		// Adding JPanel with buttons to the windows
		ventana1.setLamina("Rojo", "Verde");
		ventana2.setLamina("Azul", "Amarillo");
		ventana3.setLamina("Naranja", "Rojo");
		ventana4.setLamina("Rojo", "Amarillo");
		// Adding publishers for each window JPanel
		ventana1.getLamina().setMensajero(mensajero);
		ventana2.getLamina().setMensajero(mensajero);
		ventana3.getLamina().setMensajero(mensajero);
		ventana4.getLamina().setMensajero(mensajero);

		// Set subscribers to publisher
		mensajero.subscribe("ventanaTipo1", ventana2.getLamina(), ventana4.getLamina());
		mensajero.subscribe("ventanaTipo3", ventana2.getLamina(), ventana4.getLamina());
		mensajero.subscribe("ventanaTipo2", ventana1.getLamina());
		mensajero.subscribe("ventanaTipo4", ventana3.getLamina());
	}

}

@SuppressWarnings("serial") // Only for avoid warnings in this class (can be removed)
class Marco extends JFrame {

	private JPanelWithButtons lamina;
	private String tipo;

	public Marco(String title, int x, int y, String tipo) {
		setTitle(title);
		setBounds(x, y, 400, 300);

		this.tipo = tipo;

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void setLamina(String button1Name, String button2Name) {
		lamina = new JPanelWithButtons(button1Name, button2Name, tipo);
		add(lamina);
		setVisible(true);
	}

	public JPanelWithButtons getLamina() {
		return lamina;
	}
}
