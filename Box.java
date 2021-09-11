
public class Box {

	private Pengesa barrier;
	private Lojtari player;
	private static Lojtari noplayer = new Lojtari(" ");
	private static Pengesa nobarrier = new Pengesa(" ");

	public Pengesa getBarrier() {
		if (isEmpty()) {
			return nobarrier;
		}
		return barrier;
	}

	public void setBarrier(Pengesa barrier) {
		this.barrier = barrier;
	}

	public void clear() {
		player = null;
		barrier = null;
	}

	public boolean isEmpty() {
		return player == null && barrier == null;
	}

	public Lojtari getPlayer() {
		if (isEmpty()) {
			return noplayer;
		}
		return player;
	}

	public void setPlayer(Lojtari player) {
		this.player = player;
	}

	public boolean hasBarrier() {
		return barrier != null;
	}

	public boolean hasPlayer() {
		return player != null;
	}

}
