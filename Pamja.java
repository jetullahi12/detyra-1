
import java.util.Iterator;
import java.util.Scanner;

public class Pamja {

	private Scanner in;
	public int xPosition, yPosition;

	public Pamja(String string) {
		in = new Scanner(System.in);
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public void showMessage(String s) {
		System.out.print(s);
	}

	public Tabela initializeBoard() {
		showMessage("Inicializo tabelen: ");
		int rows = in.nextInt();
		int cols = in.nextInt();

		Tabela board = new Tabela(rows, cols);
		System.out.printf("Tabela %dx%d u ndertua", rows, cols);
		System.out.println();
		return board;
	}

	public Pozita putBarrierInABox(Pengesa barrier) {
		Pozita position = null;
		boolean continuee = true;
		do {
			showMessage("Vendos pengese: ");
			int xPosition = in.nextInt();
			int yPosition = in.nextInt();
			in.nextLine();

			boolean validInput = Tabela.areInsideBounds(xPosition, yPosition);
			if (validInput) {
				setxPosition(xPosition);
				setyPosition(yPosition);
				position = new Pozita(xPosition, yPosition);
				System.out.println();
				continuee = false;

				return position;
			} else {
				System.out.printf("Pozita duhet te jete ndermjet [0,0] dhe [%d,%d]: ", Tabela.ROWS - 1, Tabela.COLS - 1);
			}

		} while (continuee);
		return position;

	}

	public Pozita readPlayerPosition(Lojtari player) {
		Pozita position = null;
		boolean continuee = true;
		do {
			showMessage("Vendos lojtarin ne ndonje pozite: ");
			int xPosition = in.nextInt();
			int yPosition = in.nextInt();
			in.nextLine();
			boolean validInput = Tabela.areInsideBounds(xPosition, yPosition);
			if (validInput) {
				setxPosition(xPosition);
				setyPosition(yPosition);
				position = new Pozita(xPosition, yPosition);
				System.out.println();
				continuee = false;
				return position;
			} else {
				System.out.printf("Pozita duhet te jete ndermjet [0,0] dhe [%d,%d]: ", Tabela.ROWS - 1, Tabela.COLS - 1);
			}

		} while (continuee);
		return null;

	}

	public void update(Tabela board) {
		showMessage(board.toString());
	}

	public void moveUpRight(Lojtari player, Pozita p, Tabela board) {
		try {
			int X = p.getX() - 1;
			int Y = p.getY() + 1;
			if (board.getBox(X, Y).isEmpty() && Tabela.areInsideBounds(X, Y)) {
				Pozita newPosition = new Pozita(X, Y);
				board.getBox(p).clear();
				board.updatePlayerPosition(player, newPosition);
				update(board);
			} else {
				showMessage("\n");
			}
		} catch (Exception e) {
			System.out.println("Keni dalur jashte tabeles!\n");
		}

	}

	public void moveUpLeft(Lojtari player, Pozita p, Tabela board) {
		try {
			int X = p.getX() - 1;
			int Y = p.getY() - 1;
			if (board.getBox(X, Y).isEmpty() && Tabela.areInsideBounds(X, Y)) {
				Pozita newPosition = new Pozita(X, Y);
				board.getBox(p).clear();
				board.updatePlayerPosition(player, newPosition);
				update(board);
			} else {
				showMessage("Penges vendosu diku tjeter.\n");
			}
		} catch (Exception e) {
			System.out.println("Keni dalur jashte tabeles!\n");
		}

	}

	public void moveDownRight(Lojtari player, Pozita p, Tabela board) {
		try {
			int X = p.getX() + 1;
			int Y = p.getY() + 1;
			if (board.getBox(X, Y).isEmpty() && Tabela.areInsideBounds(X, Y)) {
				Pozita newPosition = new Pozita(X, Y);
				board.getBox(p).clear();
				board.updatePlayerPosition(player, newPosition);
				update(board);
			} else {
				showMessage("Penges vendosu diku tjeter.\n");
			}
		} catch (Exception e) {
			System.out.println("Keni dalur jashte tabeles!\n");
		}

	}

	public void moveDownLeft(Lojtari player, Pozita p, Tabela board) {
		try {
			int X = p.getX() + 1;
			int Y = p.getY() - 1;
			if (board.getBox(X, Y).isEmpty() && Tabela.areInsideBounds(X, Y)) {
				Pozita newPosition = new Pozita(X, Y);
				board.getBox(p).clear();
				board.updatePlayerPosition(player, newPosition);
				update(board);
			} else {
				showMessage("Penges vendosu diku tjeter.\n");
			}
		} catch (Exception e) {
			System.out.println("Keni dalur jashte tabeles!\n");
		}

	}

	public void moveUp(Lojtari player, Pozita p, Tabela board) {
		try {
			int X = p.getX() - 1;
			int Y = p.getY();
			if (board.getBox(X, Y).isEmpty() && Tabela.areInsideBounds(X, Y)) {
				Pozita newPosition = new Pozita(X, Y);
				board.getBox(p).clear();
				board.updatePlayerPosition(player, newPosition);
				update(board);
			} else {
				showMessage("Penges vendosu diku tjeter.\n");

			}
		} catch (Exception e) {
			System.out.println("Keni dalur jashte tabeles!\n");
		}

	}

	public void moveRight(Lojtari player, Pozita p, Tabela board) {
		try {
			int X = p.getX();
			int Y = p.getY() + 1;
			if (board.getBox(X, Y).isEmpty() && Tabela.areInsideBounds(X, Y)) {
				Pozita newPosition = new Pozita(X, Y);
				board.getBox(p).clear();
				board.updatePlayerPosition(player, newPosition);
				update(board);

			} else {
				showMessage("Penges vendosu diku tjeter.\n");
			}
		} catch (Exception e) {
			System.out.println("Keni dalur jashte tabeles!\n");
		}

	}

	public void moveLeft(Lojtari player, Pozita p, Tabela board) {
		try {
			int X = p.getX();
			int Y = p.getY() - 1;
			if (board.getBox(X, Y).isEmpty() && Tabela.areInsideBounds(X, Y)) {
				Pozita newPosition = new Pozita(X, Y);
				board.getBox(p).clear();
				board.updatePlayerPosition(player, newPosition);
				update(board);
			} else {
				showMessage("Penges vendosu diku tjeter.\n");
			}
		} catch (Exception e) {
			System.out.println("Keni dalur jashte tabeles!\n");
		}

	}

	public void moveDown(Lojtari player, Pozita p, Tabela board) {
		try {
			int X = p.getX() + 1;
			int Y = p.getY();
			if (board.getBox(X, Y).isEmpty() && Tabela.areInsideBounds(X, Y)) {
				Pozita newPosition = new Pozita(X, Y);
				board.getBox(p).clear();
				board.updatePlayerPosition(player, newPosition);
				update(board);
			} else {
				showMessage("Penges vendosu diku tjeter!\n");
			}
		} catch (Exception e) {
			System.out.println("Keni dale jashte tabeles!\n");
		}

	}

	public void movePlayer(Lojtari player, Pozita p, Tabela board) {
		boolean continuee = true;
		do {
			showMessage(
					"Komandat e mundshme jane:\nW: larte\nA: majtas\nD: djathtas\nS: poshte\nE: per lart djathtas\nQ: per lart majtas\nC: per posht djathtas\nZ: per posht majtas\nX: per dalje\n");
			showMessage("Komanda juaj eshte: ");
			String command = in.nextLine();
			if (command.length() > 0) {
				command = command.substring(0, 1);
				if (command.equalsIgnoreCase("W")) {
					moveUp(player, board.getCurrentPlayerPosition(), board);

				} else if (command.equalsIgnoreCase("A")) {
					moveLeft(player, board.getCurrentPlayerPosition(), board);

				} else if (command.equalsIgnoreCase("D")) {
					moveRight(player, board.getCurrentPlayerPosition(), board);

				} else if (command.equalsIgnoreCase("S")) {
					moveDown(player, board.getCurrentPlayerPosition(), board);
				} else if (command.equalsIgnoreCase("E")) {
					moveUpRight(player, board.getCurrentPlayerPosition(), board);

				} else if (command.equalsIgnoreCase("Q")) {
					moveUpLeft(player, board.getCurrentPlayerPosition(), board);

				} else if (command.equalsIgnoreCase("C")) {
					moveDownRight(player, board.getCurrentPlayerPosition(), board);

				} else if (command.equalsIgnoreCase("Z")) {
					moveDownLeft(player, board.getCurrentPlayerPosition(), board);

				} else if (command.equalsIgnoreCase("X")) {
					showMessage("Loja perfundoj.");
					return;
				} else {

					showMessage("Ju lutem shtypni ndonjeren nga komandat!\n");
				}
			}

		} while (continuee);

	}

}
