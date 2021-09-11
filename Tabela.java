
public class Tabela {

	private Box[][] boxes;
	public static int ROWS;
	public static int COLS;
	private Pozita currentPlayerPosition, barrierPosition;

	public Tabela(int rows, int cols) {
		ROWS = rows;
		COLS = cols;
		boxes = new Box[ROWS][COLS];
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				boxes[row][col] = new Box();
			}
		}
		currentPlayerPosition = new Pozita();
		barrierPosition = new Pozita();
	}

	public Box getBox(Pozita position) {
		return boxes[position.getX()][position.getY()];
	}

	public Box getBox(int x, int y) {
		Pozita temp = new Pozita(x, y);
		return getBox(temp);
	}

	public boolean isValidPosition(Pozita position) {
		return getBox(position).isEmpty();
	}

	public void updatePlayerPosition(Lojtari player, Pozita position) {
		getBox(position).setPlayer(player);
		this.currentPlayerPosition = position;
	}

	public void BarrierPosition(Pengesa barrier, Pozita position) {
		getBox(position).setBarrier(barrier);
		this.barrierPosition = position;
	}

	public Pozita getBarrierPosition() {
		return barrierPosition;
	}

	public Pozita getCurrentPlayerPosition() {
		return currentPlayerPosition;
	}

	public static String repeatBottomLine(String s, int cols) {
// Kjo metode sherben per te shtypur vijen e poshtme te rreshtit (- - - -) dhe eshte perdorur me poshte tek metoda toString(). 
// Logjika e saj eshte se dy vija - me nje SPACE mes tyre mjaftojne per nje kolone
		String m = "";
		for (int i = 0; i < cols * 2; i++) {
			m += s;
		}
		return m;
	}

	@Override
	public String toString() {
		StringBuilder boardString = new StringBuilder("");
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				Box box = boxes[row][col];
				if (box.isEmpty()) {
					boardString.append("   ");
				} else if (box.hasPlayer()) {
					boardString.append(" " + box.getPlayer() + " ");
				} else if (box.hasBarrier()) {
					boardString.append(" " + box.getBarrier() + " ");
				}
				// nese eshte kolona e fundit mos e shtyp
				if (col <= boxes[row].length) {
					boardString.append("|");
				}
			}
			boardString.append("\n");
			if (row < boxes.length) {
				boardString.append(repeatBottomLine("- ", COLS));
				boardString.append("\n");
			}
		}
		boardString.append("\n");
		return boardString.toString();
	}

	public static boolean areInsideBounds(int xPosition, int yPosition) {
		return xPosition >= 0 && xPosition < ROWS && yPosition >= 0 && yPosition < COLS;
	}

}
