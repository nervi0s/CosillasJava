package pack_16;

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

		synchronized (this) { // Podr�an ser m�todos sincronizados
			// La lista solo puede tener 5 elemento almacenados
			if (deposit.size() < 5) {
				deposit.add(item);
				System.out.println("El hilo: " + Thread.currentThread().getName() + " ha producido: " + item
						+ " estado deposito: " + deposit);
				notifyAll();
			} else {
				try {
					System.out.println("El dep�sito est� lleno, el hilo: " + Thread.currentThread().getName()
							+ " est� esperando , tama�o actual dep�sito: " + deposit);
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// M�todo para obtener un elemento de la lista del dep�sito

	public Integer getItem(int index) {

		synchronized (this) { // Podr�an ser m�todos sincronizados
			while (deposit.isEmpty()) {
				try {
					System.out.println("El dep�sito est� vac�o, el hilo: " + Thread.currentThread().getName()
							+ " est� esperando , tama�o actual dep�sito: " + deposit);
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
