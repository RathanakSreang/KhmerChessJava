package MyChess;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Touk extends KonOuk {

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
	public ArrayList<PosKon> PostoGo(int x, int y, Board[][] board) {
		// TODO Auto-generated method stub
		// return super.PostoGo(board);
		ArrayList<PosKon> posKon = new ArrayList<PosKon>();
		// X............
		if (x != 7
				&& eatOrNot(placeStopMaX(x, y, board), oldY, board) == CheckMove.EAT) {
			// drawPlaceEat(placeStopMaX(x, y, board), y, g);
			posKon.add(new PosKon(placeStopMaX(x, y, board), y));
		} else if (x != 7
				&& eatOrNot(placeStopMaX(x, y, board), oldY, board) == CheckMove.NOTEAT) {
			if ((placeStopMaX(x, y, board) - 1) != x) {
				// drawPlaceGo(placeStopMaX(x, y, board) - 1, y, g);
				posKon.add(new PosKon(placeStopMaX(x, y, board) - 1, y));
			}
		} else if (x != 7
				&& eatOrNot(placeStopMaX(x, y, board), oldY, board) != CheckMove.NOTEAT) {
			// drawPlaceGo(placeStopMaX(x, y, board), y, g);
			posKon.add(new PosKon(placeStopMaX(x, y, board), y));
		}
		if (x != 0
				&& eatOrNot(placeStopMinX(x, y, board), oldY, board) == CheckMove.EAT) {
			// drawPlaceEat(placeStopMinX(x, y, board), y, g);
			posKon.add(new PosKon(placeStopMinX(x, y, board), y));
		} else if (x != 0
				&& eatOrNot(placeStopMinX(x, y, board), oldY, board) == CheckMove.NOTEAT) {
			if ((placeStopMinX(x, y, board) + 1) != x) {
				// drawPlaceGo(placeStopMinX(x, y, board) + 1, y, g);
				posKon.add(new PosKon(placeStopMinX(x, y, board) + 1, y));
			}
		} else if (x != 0
				&& eatOrNot(placeStopMinX(x, y, board), oldY, board) != CheckMove.NOTEAT) {
			// drawPlaceGo(placeStopMinX(x, y, board), y, g);
			posKon.add(new PosKon(placeStopMinX(x, y, board), y));
		}
		// Y ...............
		if (y != 7
				&& eatOrNot(x, placeStopMaxY(x, y, board), board) == CheckMove.EAT) {
			// drawPlaceEat(x, placeStopMaxY(x, y, board), g);
			posKon.add(new PosKon(x, placeStopMaxY(x, y, board)));
		} else if (y != 7
				&& eatOrNot(x, placeStopMaxY(x, y, board), board) == CheckMove.NOTEAT) {
			if (placeStopMaxY(x, y, board) - 1 != y) {
				// drawPlaceGo(x, placeStopMaxY(x, y, board) - 1, g);
				posKon.add(new PosKon(x, placeStopMaxY(x, y, board) - 1));
			}
		} else if (y != 7
				&& eatOrNot(x, placeStopMaxY(x, y, board), board) != CheckMove.NOTEAT) {
			// drawPlaceGo(x, placeStopMaxY(x, y, board), g);
			posKon.add(new PosKon(x, placeStopMaxY(x, y, board)));
		}
		if (y != 0
				&& eatOrNot(x, placeStopMinY(x, y, board), board) == CheckMove.EAT) {
			// drawPlaceEat(x, placeStopMinY(x, y, board), g);
			posKon.add(new PosKon(x, placeStopMinY(x, y, board)));
		} else if (y != 0
				&& eatOrNot(x, placeStopMinY(x, y, board), board) == CheckMove.NOTEAT) {
			if (placeStopMinY(x, y, board) + 1 != y) {
				// drawPlaceGo(x, placeStopMinY(x, y, board) + 1, g);
				posKon.add(new PosKon(x, placeStopMinY(x, y, board) + 1));
			}
		} else if (y != 0
				&& eatOrNot(x, placeStopMinY(x, y, board), board) != CheckMove.NOTEAT) {
			// drawPlaceGo(x, placeStopMinY(x, y, board), g);
			posKon.add(new PosKon(x, placeStopMinY(x, y, board)));
		}

		return posKon;
	}

	private boolean isKonPress = false;

	public Touk(int x, int y, TypeKonOuk kon) {
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
		for (int i = oldX; i <= placeStopMaX(oldX, oldY, board); i++) {
			if (x == i && y == oldY
					&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
				isMove = true;
				break;
			}
		}

		if (!isMove) {
			for (int i = oldX; i >= placeStopMinX(oldX, oldY, board); i--) {
				if (x == i && y == oldY
						&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
					isMove = true;
					break;
				}
			}
		}
		if (!isMove) {
			for (int i = oldY; i <= placeStopMaxY(oldX, oldY, board); i++) {
				if (x == oldX && y == i
						&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
					isMove = true;
					break;
				}
			}
		}
		if (!isMove) {
			for (int i = oldY; i >= placeStopMinY(oldX, oldY, board); i--) {
				if (x == oldX && y == i
						&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)) {
					isMove = true;
					break;
				}
			}
		}

		if (!isMove) {
			setxPos(oldX);
			setyPos(oldY);
		} else {
			OuKKing(board);
			setMove(true);
		}

	}

	private int placeStopMaX(int xP, int y, Board board[][]) {
		int index = 7;
		for (int i = xP + 1; i < 8; i++) {
			if (eatOrNot(i, y, board) == CheckMove.NOTEAT
					|| eatOrNot(i, y, board) == CheckMove.EAT)
				return i;
		}
		return index;
	}

	private int placeStopMinX(int xP, int y, Board board[][]) {
		int index = 0;

		for (int i = xP - 1; i >= 0; i--) {
			if (eatOrNot(i, y, board) == CheckMove.NOTEAT
					|| eatOrNot(i, y, board) == CheckMove.EAT) {
				return i;
			}
		}
		// System.out.println("xm=" + index);
		return index;
	}

	private int placeStopMaxY(int x, int yP, Board board[][]) {
		int index = 7;
		for (int i = yP + 1; i < 8; i++) {
			if (eatOrNot(x, i, board) == CheckMove.NOTEAT
					|| eatOrNot(x, i, board) == CheckMove.EAT) {
				return i;
			}

		}
		return index;
	}

	private int placeStopMinY(int x, int yP, Board board[][]) {
		int index = 0;
		for (int i = yP - 1; i >= 0; i--) {
			if (eatOrNot(x, i, board) == CheckMove.NOTEAT
					|| eatOrNot(x, i, board) == CheckMove.EAT)
				return i;
		}
		return index;
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
			if (typeKOn == TypeKonOuk.TOUK_RED) {
				return CheckMove.NOTEAT;
			} else {
				return CheckMove.EAT;
			}

		} else if (isWhiteSide(x, y, board)) {
			if (typeKOn == TypeKonOuk.TOUK_RED) {
				return CheckMove.EAT;
			} else {
				return CheckMove.NOTEAT;
			}

		} else if (board[x][y].getTypeKon() == TypeKonOuk.FREE) {
			return CheckMove.MOVE;
		}
		return CheckMove.NOTMOVE;
	}
}
