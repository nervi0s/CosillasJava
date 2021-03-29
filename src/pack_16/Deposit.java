package pack_16;

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

		synchronized (this) { // Podrían ser métodos sincronizados
			// La lista solo puede tener 5 elemento almacenados
			if (deposit.size() < 5) {
				deposit.add(item);
				System.out.println("El hilo: " + Thread.currentThread().getName() + " ha producido: " + item
						+ " estado deposito: " + deposit);
				notifyAll();
			} else {
				try {
					System.out.println("El depósito está lleno, el hilo: " + Thread.currentThread().getName()
							+ " está esperando , tamaño actual depósito: " + deposit);
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// Método para obtener un elemento de la lista del depósito

	public Integer getItem(int index) {

		synchronized (this) { // Podrían ser métodos sincronizados
			while (deposit.isEmpty()) {
				try {
					System.out.println("El depósito está vacío, el hilo: " + Thread.currentThread().getName()
							+ " está esperando , tamaño actual depósito: " + deposit);
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			int itemToReturn = deposit.get(index);
			deposit.remove(index);
			System.out.println("El hilo: " + Thread.currentThread().getName() + " ha consumido: " + itemToReturn
					+ " estado deposito: " + deposit);
			notifyAll();
			return itemToReturn;
		}
	}

}
