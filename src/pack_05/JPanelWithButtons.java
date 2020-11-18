package pack_05;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import java.awt.Color;

@SuppressWarnings("serial") // Only for avoid warnings in this class (can be removed)
public class JPanelWithButtons extends JPanel implements Observer, MouseListener {

	private JButton[] botones = new JButton[2];
	private Publisher mensajero;
	private String tipo;

	public JPanelWithButtons(String nameButton1, String nameButton2, String tipo) {
		this.tipo = tipo;

		// Buttons creation
		botones[0] = new JButton(nameButton1);
		botones[1] = new JButton(nameButton2);

		// Default background color
		setBackground(Color.BLACK);

		// Adding buttons to the panel
		for (JButton boton : botones) {
			add(boton);
		}

		// Adding mouse listener to the buttons
		botones[0].addMouseListener(this);
		botones[1].addMouseListener(this);
	}

	public void setMensajero(Publisher p) {
		mensajero = p;
	}

	@Override
	public void update(String key, Color c) {
		System.out.println("Soy del tipo " + tipo + " "
				+ "y he sido alertado de un click. Noticación enviada a los suscriptores de: " + key);
		// Changing background color
		setBackground(c);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("\nEnviando info desde el tipo: " + tipo);

		// Sending notification requests to the publisher
		mensajero.nofifyObservers(tipo, (JButton) e.getSource());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Nothing to do here.
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Nothing to do here.
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Nothing to do here.
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Nothing to do here.
	}

}
