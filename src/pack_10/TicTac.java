package pack_10;

public class TicTac {
	
	public void tic() {
		synchronized (this) {

			System.out.println("tic");

			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void tac() {
		synchronized (this) {
			System.out.println("TAC");
			notifyAll();
		}
	}
}
