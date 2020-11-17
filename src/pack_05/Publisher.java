package pack_05;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Publisher {

	private Map<String, List<Observer>> listeners = new HashMap<String, List<Observer>>();

	public Publisher(String... types) {
		for (String key : types) {
			listeners.put(key, new ArrayList<Observer>());
		}
	}

	public void subscribe(String key, Observer panel) {
		List<Observer> listOfThisKey = listeners.get(key);
		listOfThisKey.add(panel);
	}

	public void unSubscribe(String key, Observer panel) {
		List<Observer> listOfThisKey = listeners.get(key);
		listOfThisKey.remove(panel);
	}

	public void sendUpdate(String key) {
		List<Observer> listOfThisKey = listeners.get(key);

		for (Observer panel : listOfThisKey) {
			panel.update(key, Color.ORANGE);
		}
	}

}
