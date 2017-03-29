package MyChess;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Neang extends KonOuk {

	private boolean isKonPress = false;

	public Neang(int x, int y, TypeKonOuk kon) {
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
		if (x == oldX + 1 && y == oldY + 1
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
		}
		if (!isMove) {
			setxPos(oldX);
			setyPos(oldY);
		} else {
			/*
			 * board[oldX][oldY].setTypeKon(TypeKonOuk.FREE);
			 * board[x][y].setTypeKon(typeKOn); oldX = x; oldY = y;
			 */
			OuKKing(board);
			setMove(true);
		}

	}

	@Override
	public ArrayList<PosKon> PostoGo(int x, int y, Board[][] board) {
		// TODO Auto-generated method stub
		// return super.PostoGo(board);
		ArrayList<PosKon> posKon = new ArrayList<PosKon>();
		if (x - 1 > 0 && y - 1 >= 0) {
			if (board[x - 1][y - 1].getTypeKon() == TypeKonOuk.FREE) {
				// drawPlaceGo(x - 1, y - 1, g);
				posKon.add(new PosKon(x - 1, y - 1));
			}
		}
		if (x - 1 > 0 && y + 1 < 8) {
			if (board[x - 1][y + 1].getTypeKon() == TypeKonOuk.FREE) {
				// drawPlaceGo(x - 1, y + 1, g);
				posKon.add(new PosKon(x - 1, y + 1));
			}
		}
		if (x + 1 < 8 && y - 1 >= 0) {
			if (board[x + 1][y - 1].getTypeKon() == TypeKonOuk.FREE) {
				// drawPlaceGo(x + 1, y - 1, g);
				posKon.add(new PosKon(x + 1, y - 1));
			}
		}
		if (x + 1 < 8 && y + 1 < 8) {
			if (board[x + 1][y + 1].getTypeKon() == TypeKonOuk.FREE) {
				// drawPlaceGo(x + 1, y + 1, g);
				posKon.add(new PosKon(x + 1, y + 1));
			}
		}
		// Eatable...................
		if (x - 1 >= 0 && y - 1 >= 0) {
			if (board[x - 1][y - 1].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x - 1, y - 1, board) == CheckMove.EAT) {
				// drawPlaceEat(x - 1, y - 1, g);
				posKon.add(new PosKon(x - 1, y - 1));
			}
		}
		if (x - 1 >= 0 && y + 1 < 8) {
			if (board[x - 1][y + 1].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x - 1, y + 1, board) == CheckMove.EAT) {
				// drawPlaceEat(x - 1, y + 1, g);
				posKon.add(new PosKon(x - 1, y + 1));
			}
		}
		if (x + 1 < 8 && y - 1 >= 0) {
			if (board[x + 1][y - 1].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x + 1, y - 1, board) == CheckMove.EAT) {
				// drawPlaceEat(x + 1, y - 1, g);
				posKon.add(new PosKon(x + 1, y - 1));
			}
		}
		if (x + 1 < 8 && y + 1 < 8) {
			if (board[x + 1][y + 1].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x + 1, y + 1, board) == CheckMove.EAT) {
				// drawPlaceEat(x + 1, y + 1, g);
				posKon.add(new PosKon(x + 1, y + 1));
			}
		}
		return posKon;
	}

	@Override
	public void drawKonOuk(Graphics g, Board[][] board) {
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

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mousePressed(e);
		if (e.getX() > xPos && e.getX() < xPos + Component.KON_SIZE
				&& e.getY() > yPos && e.getY() < yPos + Component.KON_SIZE) {
			isKonPress = true;
		}

	}

	private CheckMove eatOrNot(int x, int y, Board[][] board) {

		if (isRedSide(x, y, board)) {
			if (typeKOn == TypeKonOuk.NEANG_RED) {
				return CheckMove.NOTEAT;
			} else {
				return CheckMove.EAT;
			}

		} else if (isWhiteSide(x, y, board)) {
			if (typeKOn == TypeKonOuk.NEANG_RED) {
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
