package pack_05;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import java.awt.Color;

public class Publisher {

	// Map(Key, Value) that contains key types and theirs associated observers objects
	private Map<String, List<Observer>> listeners = new HashMap<String, List<Observer>>();

	public Publisher(String... type) { // ... Allows send multiple arguments, in this case strings.
		for (String key : type) {
			listeners.put(key, new ArrayList<Observer>());
		}
	}

	public void subscribe(String key, Observer... panel) { // Allows subscribe one or many 'observers' in a 'key'
		List<Observer> listOfThisKey = listeners.get(key);
		listOfThisKey.addAll(Arrays.asList(panel));
	}

	public void unSubscribe(String key, Observer panel) { // Allows remove one subscriber from a 'key'
		List<Observer> listOfThisKey = listeners.get(key);
		listOfThisKey.remove(panel);
	}

	public void nofifyObservers(String key, JButton button) { // To notify an event to 'observers/subscribers'
		List<Observer> obserbersLinkedWithThisKey = listeners.get(key);
		System.out.println("Hay: " + obserbersLinkedWithThisKey.size() + " suscriptores");
		Color color = getColor(button);

		for (Observer panel : obserbersLinkedWithThisKey) {
			panel.update(key, color);
		}
	}

	private Color getColor(JButton button) {
		String colorName = button.getText().toLowerCase();
		Color color = Color.WHITE;

		switch (colorName) {
		case "rojo":
			color = Color.RED;
			break;
		case "azul":
			color = Color.BLUE;
			break;
		case "amarillo":
			color = Color.YELLOW;
			break;
		case "verde":
			color = Color.GREEN;
			break;
		case "naranja":
			color = Color.ORANGE;
			break;
		}
		return color;
	}

}
