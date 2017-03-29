package MyChess;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class King extends KonOuk {

	@Override
	public ArrayList<PosKon> PostoGo(int x, int y, Board board[][]) {
		// TODO Auto-generated method stub
		ArrayList<PosKon> posKon = new ArrayList<PosKon>();
		if (x - 1 >= 0) {
			if (board[x - 1][y].getTypeKon() == TypeKonOuk.FREE) {
				posKon.add(new PosKon(x - 1, y));
			}
		}
		if (x - 1 >= 0 && y - 1 >= 0) {
			if (board[x - 1][y - 1].getTypeKon() == TypeKonOuk.FREE) {
				posKon.add(new PosKon(x - 1, y - 1));
			}
		}
		if (x - 1 >= 0 && y + 1 < 8) {
			if (board[x - 1][y + 1].getTypeKon() == TypeKonOuk.FREE) {
				posKon.add(new PosKon(x - 1, y + 1));
			}
		}
		if (x + 1 < 8) {
			if (board[x + 1][y].getTypeKon() == TypeKonOuk.FREE) {
				posKon.add(new PosKon(x + 1, y));
			}
		}
		if (x + 1 < 8 && y - 1 >= 0) {
			if (board[x + 1][y - 1].getTypeKon() == TypeKonOuk.FREE) {
				posKon.add(new PosKon(x + 1, y - 1));
			}
		}
		if (x + 1 < 8 && y + 1 < 8) {
			if (board[x + 1][y + 1].getTypeKon() == TypeKonOuk.FREE) {
				posKon.add(new PosKon(x + 1, y + 1));
			}
		}
		if (y - 1 >= 0) {
			if (board[x][y - 1].getTypeKon() == TypeKonOuk.FREE) {
				posKon.add(new PosKon(x, y - 1));
			}
		}
		if (y + 1 < 8) {
			if (board[x][y + 1].getTypeKon() == TypeKonOuk.FREE) {
				posKon.add(new PosKon(x, y + 1));
			}

		}
		// Eatable............................
		if (x - 1 >= 0) {
			if (board[x - 1][y].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x - 1, y, board) == CheckMove.EAT) {
				posKon.add(new PosKon(x - 1, y));
			}
		}
		if (x - 1 >= 0 && y - 1 >= 0) {
			if (board[x - 1][y - 1].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x - 1, y - 1, board) == CheckMove.EAT) {
				posKon.add(new PosKon(x - 1, y - 1));
			}
		}
		if (x - 1 >= 0 && y + 1 < 8) {
			if (board[x - 1][y + 1].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x - 1, y + 1, board) == CheckMove.EAT) {
				posKon.add(new PosKon(x - 1, y + 1));
			}
		}
		if (x + 1 < 8) {
			if (board[x + 1][y].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x + 1, y, board) == CheckMove.EAT) {
				posKon.add(new PosKon(x + 1, y));
			}
		}
		if (x + 1 < 8 && y - 1 >= 0) {
			if (board[x + 1][y - 1].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x + 1, y - 1, board) == CheckMove.EAT) {
				posKon.add(new PosKon(x + 1, y - 1));
			}
		}
		if (x + 1 < 8 && y + 1 < 8) {
			if (board[x + 1][y + 1].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x + 1, y + 1, board) == CheckMove.EAT) {
				posKon.add(new PosKon(x + 1, y + 1));
			}
		}
		if (y - 1 >= 0) {
			if (board[x][y - 1].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x, y - 1, board) == CheckMove.EAT) {
				posKon.add(new PosKon(x, y - 1));
			}
		}
		if (y + 1 < 8) {
			if (board[x][y + 1].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x, y + 1, board) == CheckMove.EAT) {
				posKon.add(new PosKon(x, y + 1));
			}

		}

		return posKon;
	}

	private boolean isKonPress;

	public King(int x, int y, TypeKonOuk kon) {
		// TODO Auto-generated constructor stub
		super(x, y, kon);
	}

	@Override
	public void mouseReleased(MouseEvent e, Board[][] board) {
		// TODO Auto-generated method stub
		super.mouseReleased(e, board);
		if (!isKonPress)
			return;
		mouseReleaseKon(e, board);
		isKonPress = false;
		boolean isMove = false;
		if (x == oldX - 1 && y == oldY
				&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
			isMove = true;
		} else if (x == oldX + 1 && y == oldY
				&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
			isMove = true;
		} else if (x == oldX + 1 && y == oldY + 1
				&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
			isMove = true;
		} else if (x == oldX + 1 && y == oldY - 1
				&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
			isMove = true;
		} else if (x == oldX - 1 && y == oldY + 1
				&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
			isMove = true;
		} else if (x == oldX - 1 && y == oldY - 1
				&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
			isMove = true;
		} else if (x == oldX && y == oldY - 1
				&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
			isMove = true;
		} else if (x == oldX && y == oldY + 1
				&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
			isMove = true;
		}

		if (!isMove) {
			setxPos(oldX);
			setyPos(oldY);
		} else {
			OuKKing(board);
			/*board[oldX][oldY].setTypeKon(TypeKonOuk.FREE);
			board[x][y].setTypeKon(typeKOn);
			oldX = x;
			oldY = y;*/
			setMove(true);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mousePressed(e);
		if (e.getX() > xPos && e.getX() < xPos + Component.KON_SIZE
				&& e.getY() > yPos && e.getY() < yPos + Component.KON_SIZE) {
			isKonPress = true;
		}

	}

	/*
	 * @Override public void mouseDragged(MouseEvent e) { // TODO Auto-generated
	 * method stub super.mouseDragged(e); if (isPressed) {
	 * 
	 * } }
	 */
	@Override
	public void drawKonOuk(Graphics g, Board board[][]) {
		// TODO Auto-generated method stub

		if (isKonPress) {
			ArrayList<PosKon> posKon = new ArrayList<PosKon>();
			posKon.addAll(PostoGo(x, y, board));
			for (int i = 0; i < posKon.size(); i++) {
				if (board[posKon.get(i).getX()][posKon.get(i).getY()]
						.getTypeKon() == TypeKonOuk.FREE) {
					drawPlaceGo(posKon.get(i).getX(), posKon.get(i).getY(), g);
				} else if (board[posKon.get(i).getX()][posKon.get(i).getY()]
						.getTypeKon() != TypeKonOuk.FREE
						&& eatOrNot(posKon.get(i).getX(), posKon.get(i).getY(),
								board) == CheckMove.EAT) {
					drawPlaceEat(posKon.get(i).getX(), posKon.get(i).getY(), g);
				}
			}
		}
		super.drawKonOuk(g, board);
	}

	private CheckMove eatOrNot(int x, int y, Board[][] board) {

		if (isRedSide(x, y, board)) {
			if (typeKOn == TypeKonOuk.ANG_RED) {
				return CheckMove.NOTEAT;
			} else {
				return CheckMove.EAT;
			}

		} else if (isWhiteSide(x, y, board)) {
			if (typeKOn == TypeKonOuk.ANG_RED) {
				return CheckMove.EAT;
			} else {
				return CheckMove.NOTEAT;
			}

		} else if (board[x][y].getTypeKon() == TypeKonOuk.FREE) {
			// System.out.print("In Freee");
			return CheckMove.MOVE;
		}
		return CheckMove.NOTMOVE;
	}
}
