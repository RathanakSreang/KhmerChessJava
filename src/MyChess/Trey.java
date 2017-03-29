package MyChess;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Trey extends KonOuk {

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
		//setCanMove =False
		setCanMove(false);
		ArrayList<PosKon> posKon = new ArrayList<PosKon>();
		// Move Forward
		if (typeKOn == TypeKonOuk.TREY_RED || typeKOn == TypeKonOuk.TREY_WHITE) {
			if (y - 1 >= 0 && typeKOn == TypeKonOuk.TREY_WHITE
					&& playerType == PlayerType.WHITE) {
				if (board[x][y - 1].getTypeKon() == TypeKonOuk.FREE) {
					// drawPlaceGo(x, y - 1, g);
					posKon.add(new PosKon(x, y - 1));
					setCanMove(true);
				}
			} else if (y + 1 >= 0 && typeKOn == TypeKonOuk.TREY_WHITE
					&& playerType == PlayerType.RED) {
				if (board[x][y + 1].getTypeKon() == TypeKonOuk.FREE) {
					// drawPlaceGo(x, y + 1, g);
					posKon.add(new PosKon(x, y + 1));
					setCanMove(true);
				}
			}
			if (y + 1 < 8 && typeKOn == TypeKonOuk.TREY_RED
					&& playerType == PlayerType.WHITE) {
				if (board[x][y + 1].getTypeKon() == TypeKonOuk.FREE) {
					// drawPlaceGo(x, y + 1, g);
					posKon.add(new PosKon(x, y + 1));
					setCanMove(true);
				}
			} else if (y - 1 < 8 && typeKOn == TypeKonOuk.TREY_RED
					&& playerType == PlayerType.RED) {
				if (board[x][y - 1].getTypeKon() == TypeKonOuk.FREE) {
					// drawPlaceGo(x, y - 1, g);
					posKon.add(new PosKon(x, y - 1));
					setCanMove(true);
				}
			}

			// Eatable.............
			if (y - 1 >= 0 && x - 1 >= 0 && typeKOn == TypeKonOuk.TREY_WHITE
					&& playerType == PlayerType.WHITE) {
				if (board[x - 1][y - 1].getTypeKon() != TypeKonOuk.FREE
						&& eatOrNot(x - 1, y - 1, board) == CheckMove.EAT) {
					// drawPlaceEat(x - 1, y - 1, g);
					posKon.add(new PosKon(x - 1, y - 1));
					setCanMove(true);
				}
			} else if (y + 1 >= 0 && x - 1 >= 0
					&& typeKOn == TypeKonOuk.TREY_WHITE
					&& playerType == PlayerType.RED) {
				if (board[x - 1][y + 1].getTypeKon() != TypeKonOuk.FREE
						&& eatOrNot(x - 1, y + 1, board) == CheckMove.EAT) {
					// drawPlaceEat(x - 1, y + 1, g);
					posKon.add(new PosKon(x - 1, y + 1));
					setCanMove(true);
				}
			}
			if (y - 1 >= 0 && x + 1 < 8 && typeKOn == TypeKonOuk.TREY_WHITE
					&& playerType == PlayerType.WHITE) {
				if (board[x + 1][y - 1].getTypeKon() != TypeKonOuk.FREE
						&& eatOrNot(x + 1, y - 1, board) == CheckMove.EAT) {
					// drawPlaceEat(x + 1, y - 1, g);
					posKon.add(new PosKon(x + 1, y - 1));
					setCanMove(true);
				}
			} else if (y + 1 >= 0 && x + 1 < 8
					&& typeKOn == TypeKonOuk.TREY_WHITE
					&& playerType == PlayerType.RED) {
				if (board[x + 1][y + 1].getTypeKon() != TypeKonOuk.FREE
						&& eatOrNot(x + 1, y + 1, board) == CheckMove.EAT) {
					// drawPlaceEat(x + 1, y + 1, g);
					posKon.add(new PosKon(x + 1, y + 1));
					setCanMove(true);
				}
			}
			if (y + 1 < 8 && x - 1 >= 0 && typeKOn == TypeKonOuk.TREY_RED
					&& playerType == PlayerType.WHITE) {
				if (board[x - 1][y + 1].getTypeKon() != TypeKonOuk.FREE
						&& eatOrNot(x - 1, y + 1, board) == CheckMove.EAT) {
					// drawPlaceEat(x - 1, y + 1, g);
					posKon.add(new PosKon(x - 1, y + 1));
					setCanMove(true);
				}
			} else if (y - 1 < 8 && x - 1 >= 0
					&& typeKOn == TypeKonOuk.TREY_RED
					&& playerType == PlayerType.RED) {
				if (board[x - 1][y - 1].getTypeKon() != TypeKonOuk.FREE
						&& eatOrNot(x - 1, y - 1, board) == CheckMove.EAT) {
					// drawPlaceEat(x - 1, y - 1, g);
					posKon.add(new PosKon(x - 1, y - 1));
					setCanMove(true);
				}
			}
			if (y + 1 < 8 && x + 1 < 8 && typeKOn == TypeKonOuk.TREY_RED
					&& playerType == PlayerType.WHITE) {
				if (board[x + 1][y + 1].getTypeKon() != TypeKonOuk.FREE
						&& eatOrNot(x + 1, y + 1, board) == CheckMove.EAT) {
					// drawPlaceEat(x + 1, y + 1, g);
					posKon.add(new PosKon(x + 1, y + 1));
					setCanMove(true);
				}
			} else if (y - 1 < 8 && x + 1 < 8 && typeKOn == TypeKonOuk.TREY_RED
					&& playerType == PlayerType.RED) {
				if (board[x + 1][y - 1].getTypeKon() != TypeKonOuk.FREE
						&& eatOrNot(x + 1, y - 1, board) == CheckMove.EAT) {
					// drawPlaceEat(x + 1, y - 1, g);
					posKon.add(new PosKon(x + 1, y - 1));
					setCanMove(true);
				}
			}

		} else if (typeKOn == TypeKonOuk.TREY_BORK_RED
				|| typeKOn == TypeKonOuk.TREY_BORK_WHITE) {
			if (x - 1 >= 0 && y - 1 >= 0) {
				if (board[x - 1][y - 1].getTypeKon() == TypeKonOuk.FREE) {
					// drawPlaceGo(x - 1, y - 1, g);
					posKon.add(new PosKon(x - 1, y - 1));
				}
			}
			if (x - 1 >= 0 && y + 1 < 8) {
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

		}

		return posKon;
	}

	private boolean isKonPress = false;

	public Trey(int x, int y, TypeKonOuk kon) {
		// TODO Auto-generated constructor stub
		super(x, y, kon);
	}

	@Override
	public void mouseReleased(MouseEvent e, Board[][] board) {
		// TODO Auto-generated method stub
		super.mouseReleased(e, board);
		// System.out.println("Kon Trey "+isMovable(board));
		if (!isKonPress)
			return;
		mouseReleaseKon(e, board);
		isKonPress = false;
		boolean isMove = false;
		// Not yet Bork
		if ((typeKOn == TypeKonOuk.TREY_RED && y <= 5 && playerType == PlayerType.WHITE)
				|| (typeKOn == TypeKonOuk.TREY_WHITE && y >= 2 && playerType == PlayerType.WHITE)
				|| (typeKOn == TypeKonOuk.TREY_RED && y >= 2 && playerType == PlayerType.RED)
				|| (typeKOn == TypeKonOuk.TREY_WHITE && y <= 5 && playerType == PlayerType.RED)) {
			if ((typeKOn == TypeKonOuk.TREY_RED && y <= 5 && playerType == PlayerType.WHITE)
					|| (typeKOn == TypeKonOuk.TREY_RED && y >= 2 && playerType == PlayerType.RED)) {
				if (x == oldX && y == oldY + 1
						&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)
						&& (eatOrNot(x, y, board) != CheckMove.EAT)
						&& playerType == PlayerType.WHITE) {
					isMove = true;
				} else if (x == oldX && y == oldY - 1
						&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)
						&& (eatOrNot(x, y, board) != CheckMove.EAT)
						&& playerType == PlayerType.RED) {
					isMove = true;
				} else if (x == oldX - 1 && y == oldY + 1
						&& (eatOrNot(x, y, board) == CheckMove.EAT)
						&& playerType == PlayerType.WHITE) {
					isMove = true;
				} else if (x == oldX - 1 && y == oldY - 1
						&& (eatOrNot(x, y, board) == CheckMove.EAT)
						&& playerType == PlayerType.RED) {
					isMove = true;
				} else if (x == oldX + 1 && y == oldY + 1
						&& (eatOrNot(x, y, board) == CheckMove.EAT)
						&& playerType == PlayerType.WHITE) {
					isMove = true;
				} else if (x == oldX + 1 && y == oldY - 1
						&& (eatOrNot(x, y, board) == CheckMove.EAT)
						&& playerType == PlayerType.RED) {
					isMove = true;
				}
			} else if ((typeKOn == TypeKonOuk.TREY_WHITE && y >= 2 && playerType == PlayerType.WHITE)
					|| (typeKOn == TypeKonOuk.TREY_WHITE && y <= 5 && playerType == PlayerType.RED)) {
				if (x == oldX && y == oldY - 1
						&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)
						&& (eatOrNot(x, y, board) != CheckMove.EAT)
						&& playerType == PlayerType.WHITE) {
					isMove = true;
				} else if (x == oldX && y == oldY + 1
						&& (eatOrNot(x, y, board) != CheckMove.NOTEAT)
						&& (eatOrNot(x, y, board) != CheckMove.EAT)
						&& playerType == PlayerType.RED) {
					isMove = true;

				} else if (x == oldX - 1 && y == oldY - 1
						&& (eatOrNot(x, y, board) == CheckMove.EAT)
						&& playerType == PlayerType.WHITE) {
					isMove = true;
				} else if (x == oldX - 1 && y == oldY + 1
						&& (eatOrNot(x, y, board) == CheckMove.EAT)
						&& playerType == PlayerType.RED) {
					isMove = true;
				} else if (x == oldX + 1 && y == oldY - 1
						&& (eatOrNot(x, y, board) == CheckMove.EAT)
						&& playerType == PlayerType.WHITE) {
					isMove = true;
				} else if (x == oldX + 1 && y == oldY + 1
						&& (eatOrNot(x, y, board) == CheckMove.EAT)
						&& playerType == PlayerType.RED) {
					isMove = true;
				}
			}

		}
		// Bork already
		else if (typeKOn == TypeKonOuk.TREY_BORK_RED
				|| typeKOn == TypeKonOuk.TREY_BORK_WHITE) {
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
		}
		if (!isMove) {
			setxPos(oldX);
			setyPos(oldY);
		} else {
			int temX = oldX, temY = oldY;
			TypeKonOuk temType = typeKOn;
			if ((y == 5 && typeKOn == TypeKonOuk.TREY_RED && playerType == PlayerType.WHITE)
					|| (y == 2 && typeKOn == TypeKonOuk.TREY_RED && playerType == PlayerType.RED)) {
				typeKOn = TypeKonOuk.TREY_BORK_RED;
			} else if ((y == 2 && typeKOn == TypeKonOuk.TREY_WHITE && playerType == PlayerType.WHITE)
					|| (y == 5 && typeKOn == TypeKonOuk.TREY_WHITE && playerType == PlayerType.RED)) {
				typeKOn = TypeKonOuk.TREY_BORK_WHITE;
			}
			OuKKing(board);
			if (temX == x && temY == y) {
				typeKOn = temType;
				board[x][y].setTypeKon(typeKOn);
			}
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

	private CheckMove eatOrNot(int x, int y, Board[][] board) {

		if (isRedSide(x, y, board)) {
			if (typeKOn == TypeKonOuk.TREY_RED
					|| typeKOn == TypeKonOuk.TREY_BORK_RED) {
				return CheckMove.NOTEAT;
			} else {
				return CheckMove.EAT;
			}

		} else if (isWhiteSide(x, y, board)) {
			if (typeKOn == TypeKonOuk.TREY_RED
					|| typeKOn == TypeKonOuk.TREY_BORK_RED) {
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
