package MyChess;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class SES extends KonOuk {

	private boolean isKonPress = false;

	public SES(int x, int y, TypeKonOuk kon) {
		// TODO Auto-generated constructor stub
		super(x, y, kon);
	}

	@Override
	public ArrayList<PosKon> PostoGo(int x, int y, Board[][] board) {
		// TODO Auto-generated method stub
		// return super.PostoGo(board);
		ArrayList<PosKon> posKon = new ArrayList<PosKon>();
		if (x - 2 >= 0 && y - 1 >= 0) {
			if (board[x - 2][y - 1].getTypeKon() == TypeKonOuk.FREE) {
				// drawPlaceGo(x - 2, y - 1, g);
				posKon.add(new PosKon(x - 2, y - 1));
			}
		}
		if (x - 2 >= 0 && y + 1 < 8) {
			if (board[x - 2][y + 1].getTypeKon() == TypeKonOuk.FREE) {
				// drawPlaceGo(x - 2, y + 1, g);
				posKon.add(new PosKon(x - 2, y + 1));
			}
		}
		if (x + 2 < 8 && y + 1 < 8) {
			if (board[x + 2][y + 1].getTypeKon() == TypeKonOuk.FREE) {
				// drawPlaceGo(x + 2, y + 1, g);
				posKon.add(new PosKon(x + 2, y + 1));
			}
		}
		if (x + 2 < 8 && y - 1 >= 0) {
			if (board[x + 2][y - 1].getTypeKon() == TypeKonOuk.FREE) {
				// drawPlaceGo(x + 2, y - 1, g);
				posKon.add(new PosKon(x + 2, y - 1));
			}
		}
		if (x + 1 < 8 && y - 2 >= 0) {
			if (board[x + 1][y - 2].getTypeKon() == TypeKonOuk.FREE) {
				// drawPlaceGo(x + 1, y - 2, g);
				posKon.add(new PosKon(x + 1, y - 2));
			}
		}
		if (x - 1 >= 0 && y - 2 >= 0) {
			if (board[x - 1][y - 2].getTypeKon() == TypeKonOuk.FREE) {
				// drawPlaceGo(x - 1, y - 2, g);
				posKon.add(new PosKon(x - 1, y - 2));
			}
		}
		if (x + 1 < 8 && y + 2 < 8) {
			if (board[x + 1][y + 2].getTypeKon() == TypeKonOuk.FREE) {
				// drawPlaceGo(x + 1, y + 2, g);
				posKon.add(new PosKon(x + 1, y + 2));
			}
		}
		if (x - 1 >= 0 && y + 2 < 8) {
			if (board[x - 1][y + 2].getTypeKon() == TypeKonOuk.FREE) {
				// drawPlaceGo(x - 1, y + 2, g);
				posKon.add(new PosKon(x - 1, y + 2));
			}
		}

		// Eatable........................
		if (x - 2 >= 0 && y - 1 >= 0) {
			if (board[x - 2][y - 1].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x - 2, y - 1, board) == CheckMove.EAT) {
				// drawPlaceEat(x - 2, y - 1, g);
				posKon.add(new PosKon(x - 2, y - 1));
			}
		}
		if (x - 2 >= 0 && y + 1 < 8) {
			if (board[x - 2][y + 1].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x - 2, y + 1, board) == CheckMove.EAT) {
				// drawPlaceEat(x - 2, y + 1, g);
				posKon.add(new PosKon(x - 2, y + 1));
			}
		}
		if (x + 2 < 8 && y + 1 < 8) {
			if (board[x + 2][y + 1].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x + 2, y + 1, board) == CheckMove.EAT) {
				// drawPlaceEat(x + 2, y + 1, g);
				posKon.add(new PosKon(x + 2, y + 1));
			}
		}
		if (x + 2 < 8 && y - 1 >= 0) {
			if (board[x + 2][y - 1].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x + 2, y - 1, board) == CheckMove.EAT) {
				// drawPlaceEat(x + 2, y - 1, g);
				posKon.add(new PosKon(x + 2, y - 1));
			}
		}
		if (x + 1 < 8 && y - 2 >= 0) {
			if (board[x + 1][y - 2].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x + 1, y - 2, board) == CheckMove.EAT) {
				// drawPlaceEat(x + 1, y - 2, g);
				posKon.add(new PosKon(x + 1, y - 2));
			}
		}
		if (x - 1 >= 0 && y - 2 >= 0) {
			if (board[x - 1][y - 2].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x - 1, y - 2, board) == CheckMove.EAT) {
				// drawPlaceEat(x - 1, y - 2, g);
				posKon.add(new PosKon(x - 1, y - 2));
			}
		}
		if (x + 1 < 8 && y + 2 < 8) {
			if (board[x + 1][y + 2].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x + 1, y + 2, board) == CheckMove.EAT) {
				// drawPlaceEat(x + 1, y + 2, g);
				posKon.add(new PosKon(x + 1, y + 2));
			}
		}
		if (x - 1 >= 0 && y + 2 < 8) {
			if (board[x - 1][y + 2].getTypeKon() != TypeKonOuk.FREE
					&& eatOrNot(x - 1, y + 2, board) == CheckMove.EAT) {
				// drawPlaceEat(x - 1, y + 2, g);
				posKon.add(new PosKon(x - 1, y + 2));
			}
		}
		return posKon;
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
		if (x == oldX - 2 && y == oldY + 1
				&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
			isMove = true;
		} else if (x == oldX - 2 && y == oldY - 1
				&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
			isMove = true;
		} else if (x == oldX + 2 && y == oldY + 1
				&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
			isMove = true;
		} else if (x == oldX + 2 && y == oldY - 1
				&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
			isMove = true;
		} else if (x == oldX - 1 && y == oldY + 2
				&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
			isMove = true;
		} else if (x == oldX + 1 && y == oldY + 2
				&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
			isMove = true;
		} else if (x == oldX - 1 && y == oldY - 2
				&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
			isMove = true;
		} else if (x == oldX + 1 && y == oldY - 2
				&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
			isMove = true;
		}

		if (!isMove) {
			setxPos(oldX);
			setyPos(oldY);
		} else {
			OuKKing(board);
			setMove(true);
		}

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
			if (typeKOn == TypeKonOuk.SES_RED_LEFT
					|| typeKOn == TypeKonOuk.SES_RED_RIGHT) {
				return CheckMove.NOTEAT;
			} else {
				return CheckMove.EAT;
			}

		} else if (isWhiteSide(x, y, board)) {
			if (typeKOn == TypeKonOuk.SES_RED_LEFT
					|| typeKOn == TypeKonOuk.SES_RED_RIGHT) {
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
