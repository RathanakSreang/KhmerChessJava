package MyChess;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class KonOuk implements Serializable {
	// protected boolean isOukking = false;
	// protected boolean isWasOukking = false;
	protected KingOuK kingOuk = KingOuK.NOTHING;
	protected boolean isCanMove = true;

	public boolean isCanMove() {
		return isCanMove;
	}

	public void setCanMove(boolean isCanMove) {
		this.isCanMove = isCanMove;
	}

	/*
	 * public boolean isOukking() { return isOukking; }
	 * 
	 * public void setOukking(boolean isOukking) { this.isOukking = isOukking; }
	 * 
	 * public boolean isWasOukking() { return isWasOukking; }
	 * 
	 * public void setWasOukking(boolean isWasOukking) { this.isWasOukking =
	 * isWasOukking; }
	 */
	public boolean isMove() {
		return isMove;
	}

	public void setMove(boolean isMove) {
		this.isMove = isMove;
	}

	public boolean isPressed() {
		return isPressed;
	}

	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}

	protected PlayerType playerType = PlayerType.WHITE;

	public PlayerType getPlayerType() {
		return playerType;
	}

	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}

	protected int xPos, x, oldX = -1;
	protected int yPos, y, oldY = -1;
	protected TypeKonOuk typeKOn;
	protected boolean isPressed = false;
	private boolean isMove = false;

	protected enum CheckMove {
		EAT, NOTEAT, MOVE, NOTMOVE
	};

	public KonOuk(int x, int y, TypeKonOuk kon) {
		// TODO Auto-generated constructor stub
		setxPos(x);
		setyPos(y);
		typeKOn = kon;
		oldX = x;
		oldY = y;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int x) {
		this.x = x;
		this.xPos = conVertPosX(x);
	}

	public int getX() {
		return x;

	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int y) {
		this.y = y;
		this.yPos = conVertPosY(y);
	}

	private int conVertPosX(int num) {
		return (int) (Component.START_X + num * Component.LENGTH_BOX + Component.LENGTH_BOX * 0.08);
	}

	private int conVertPosY(int num) {
		return (int) (Component.START_Y + num * Component.LENGTH_BOX + Component.LENGTH_BOX * 0.05);
	}

	public TypeKonOuk getTypeKOn() {
		return typeKOn;
	}

	public void setTypeKOn(TypeKonOuk typeKOn) {
		this.typeKOn = typeKOn;
	}

	public void drawKonOuk(Graphics g, Board[][] board) {
		if (isPressed) {
			BufferedImage img1 = null;

			try {
				img1 = ImageIO.read(new File(typeKOn.location));
			} catch (IOException e) {
				System.out.println("Swag not turned on");
				// System.exit(-1);
			}
			g.drawImage(img1, xPos, yPos, Component.KON_SIZE,
					Component.KON_SIZE, null);

		}

	}

	protected void drawPlaceEat(int x, int y, Graphics g) {
		BufferedImage img = null;

		try {
			img = ImageIO.read(new File(TypeKonOuk.EATABLE.location));
		} catch (IOException e) {
			System.out.println("Swag not turned on");
			// System.exit(-1);
		}
		int pX = (int) (Component.START_X + x * Component.LENGTH_BOX + Component.LENGTH_BOX * 0.08);
		int pY = (int) (Component.START_Y + y * Component.LENGTH_BOX + Component.LENGTH_BOX * 0.05);
		g.drawImage(img, pX, pY, Component.LENGTH_BOX, Component.LENGTH_BOX,
				null);
	}

	protected void drawPlaceGo(int x, int y, Graphics g) {
		BufferedImage img = null;

		try {
			img = ImageIO.read(new File(TypeKonOuk.MOUSE_CLICK.location));
		} catch (IOException e) {
			System.out.println("Swag not turned on");
			// System.exit(-1);
		}

		int pX = conVertPosX(x);// (int) (Component.START_X + x *
								// Component.LENGTH_BOX + Component.LENGTH_BOX *
								// 0.08);
		int pY = conVertPosY(y);// (int) (Component.START_Y + y *
								// Component.LENGTH_BOX + Component.LENGTH_BOX *
								// 0.05);
		g.drawImage(img, pX, pY, Component.LENGTH_BOX, Component.LENGTH_BOX,
				null);
	}

	public void mouseDragged(MouseEvent e, Board board[][]) {
		// TODO Auto-generated method stub
		if (isPressed) {
			xPos = e.getX() - Component.KON_SIZE / 2;
			yPos = e.getY() - Component.KON_SIZE / 2;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					board[i][j].onOverMe(e.getX(), e.getY());
				}
			}
		}
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getX() > conVertPosX(x)
				&& e.getX() < conVertPosX(x) + Component.KON_SIZE
				&& e.getY() > conVertPosY(y)
				&& e.getY() < conVertPosY(y) + Component.KON_SIZE) {
			isPressed = true;
		}
	}

	public void mouseReleased(MouseEvent e, Board board[][]) {
		// TODO Auto-generated method stub
		// if(isPressed){
		// isMovable(board);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j].setOnOver(false);
			}
		}
		// }
		if (!isPressed)
			return;
		isPressed = false;
		// mouseReleaseKon(e,board);
	}

	protected void mouseReleaseKon(MouseEvent e, Board board[][]) {
		boolean isHas = false;
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				if (board[i][j].isInBoard(e.getX(), e.getY())) {
					oldX = x;
					oldY = y;
					x = i;
					y = j;
					setxPos(i);
					setyPos(j);
					isHas = true;
					break;
				}
			}
		if (!isHas) {
			setxPos(oldX);
			setyPos(oldY);
		}
	}

	protected boolean isRedSide(int x, int y, Board[][] board) {
		if (CheckKon.redSide(board[x][y].getTypeKon())) {
			return true;
		}
		return false;
	}

	protected boolean isWhiteSide(int x, int y, Board[][] board) {
		if (CheckKon.whiteSide(board[x][y].getTypeKon())) {
			return true;
		}
		return false;
	}

	public ArrayList<PosKon> PostoGo(int x, int y, Board board[][]) {
		ArrayList<PosKon> posKon = new ArrayList<PosKon>();
		return posKon;
	}

	protected void OuKKing(Board[][] board) {
		TypeKonOuk temTyp = board[x][y].getTypeKon();
		board[oldX][oldY].setTypeKon(TypeKonOuk.FREE);
		board[x][y].setTypeKon(typeKOn);

		if (CheckKon.redSide(typeKOn)) {
			// System.out.println(CheckKing.isRedWalkable(board, playerType));
			if (CheckKing.isRedWalkable(board, playerType)) {
				board[oldX][oldY].setTypeKon(typeKOn);
				board[x][y].setTypeKon(temTyp);
				setxPos(oldX);
				setyPos(oldY);
				kingOuk = KingOuK.WASOUK;
			} else {
				oldX = x;
				oldY = y;

			}
			if (CheckKing.isWhiteWalkable(board, playerType)) {
				if (typeKOn == TypeKonOuk.TREY_BORK_RED
						|| typeKOn == TypeKonOuk.TREY_BORK_WHITE
						|| typeKOn == TypeKonOuk.TREY_RED
						|| typeKOn == TypeKonOuk.TREY_WHITE) {
					kingOuk = KingOuK.ROUK;
				} else {
					kingOuk = KingOuK.OUK;
				}

			}
			// System.out.println(kingOuk);
		} else if (CheckKon.whiteSide(typeKOn)) {
			if (CheckKing.isWhiteWalkable(board, playerType)) {
				board[oldX][oldY].setTypeKon(typeKOn);
				board[x][y].setTypeKon(temTyp);
				setxPos(oldX);
				setyPos(oldY);
				kingOuk = KingOuK.WASOUK;
			} else {
				oldX = x;
				oldY = y;
			}
			if (CheckKing.isRedWalkable(board, playerType)) {
				if (typeKOn == TypeKonOuk.TREY_BORK_RED
						|| typeKOn == TypeKonOuk.TREY_BORK_WHITE
						|| typeKOn == TypeKonOuk.TREY_RED
						|| typeKOn == TypeKonOuk.TREY_WHITE) {
					kingOuk = KingOuK.ROUK;
				} else {
					kingOuk = KingOuK.OUK;
				}
			}
		}
		// System.out.println(kingOuk);
	}

	public KingOuK getKingOuk() {
		return kingOuk;
	}

	public void setKingOuk(KingOuK kingOuk) {
		this.kingOuk = kingOuk;
	}
}
