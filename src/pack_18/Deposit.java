package pack_18;

import java.util.ArrayList;
import java.util.List;

// Creamos una clase de la cual ambos hilos compartir�n una misma instancia de esta
public class Deposit {
	// Lista donde se almacenan los valores generados
	List<Integer> deposit;

	public Deposit() {
		deposit = new ArrayList<>();
	}

	// M�todo para poner un elemento a la lista del dep�sito

	public void putItem(Integer item) {
		deposit.add(item);
	}

	// M�todo para obtener un elemento de la lista del dep�sito

	public Integer getItem(int index) {
		int itemToReturn = deposit.get(index);
		deposit.remove(index);
		return itemToReturn;
	}

}
