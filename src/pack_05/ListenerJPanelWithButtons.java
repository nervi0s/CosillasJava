package pack_05;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ListenerJPanelWithButtons extends JPanel implements Observer, MouseListener {
	private JButton[] botones = new JButton[2];

	
	private Publisher mensajero;
	private String tipo;
	
	public ListenerJPanelWithButtons(String nameButton1, String nameButton2, String tipo) {
		this.tipo = tipo;
		
		// Creación de los botones
		botones[0] = new JButton(nameButton1);
		botones[1] = new JButton(nameButton2);

		// Fondo por defecto del JPanel
		setBackground(Color.BLACK);

		// Añadimos los botones al panel
		for (JButton boton : botones) {
			add(boton);
		}
		
		botones[0].addMouseListener(this);
		botones[1].addMouseListener(this);
	}


	@Override
	public void update(String key, Color c) {
		System.out.println("He detectado un click");
		System.out.println(key);
		setBackground(c);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mensajero.sendUpdate(tipo);
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
	
	public void setMensajero(Publisher p) {
		mensajero = p;
	}

}
