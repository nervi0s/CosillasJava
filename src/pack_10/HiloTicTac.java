package pack_10;

public class HiloTicTac extends Thread {

	private TicTac tictacObject;
	private int id;

	public HiloTicTac(int id, TicTac tictac) {
		this.id = id;
		this.tictacObject = tictac;
	}

	@Override
	public void run() {
		while (true) {
			if (id == 1) {
				tictacObject.tic();
			} else if (id == 2) {
				tictacObject.tac();
			}
		}
	}

}
