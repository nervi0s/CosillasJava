package pack_16;

import java.util.ArrayList;
import java.util.List;

public class Deposit {

	List<Integer> deposit;

	public Deposit() {
		deposit = new ArrayList<>();
	}

	public void putItem(Integer item) {
		synchronized (deposit) {
			if (deposit.size() < 5) {
				deposit.add(item);
				System.out.println("El hilo: " + Thread.currentThread().getName() + " ha producido: " + item
						+ " estado deposito: " + deposit);
				deposit.notifyAll();
			} else {
				try {
					System.out.println("El depósito está lleno, el hilo: " + Thread.currentThread().getName()
							+ " está esperando , tamaño actual depósito: " + deposit);
					deposit.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Integer getItem(int index) {

		synchronized (deposit) {
			while (deposit.isEmpty()) {
				try {
					System.out.println("El depósito está vacío, el hilo: " + Thread.currentThread().getName()
							+ " está esperando , tamaño actual depósito: " + deposit);
					deposit.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			int itemToReturn = deposit.get(index);
			deposit.remove(index);
			System.out.println("El hilo: " + Thread.currentThread().getName() + " ha consumido: " + itemToReturn
					+ " estado deposito: " + deposit);
			deposit.notifyAll();
			return itemToReturn;
		}
	}

}
