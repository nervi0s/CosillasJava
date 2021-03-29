package pack_18;

import java.util.ArrayList;
import java.util.List;

// Creamos una clase de la cual ambos hilos compartirán una misma instancia de esta
public class Deposit {
	// Lista donde se almacenan los valores generados
	List<Integer> deposit;

	public Deposit() {
		deposit = new ArrayList<>();
	}

	// Método para poner un elemento a la lista del depósito

	public void putItem(Integer item) {
		deposit.add(item);
	}

	// Método para obtener un elemento de la lista del depósito

	public Integer getItem(int index) {
		int itemToReturn = deposit.get(index);
		deposit.remove(index);
		return itemToReturn;
	}

}
