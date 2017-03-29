package MyChess;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Board {
	private int x, y;
	private BufferedImage img;
	private TypeKonOuk typeKon;
	private int xPos, yPos;
	private boolean onOver = false;

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		xPos = (int) (Component.START_X + x * Component.LENGTH_BOX + Component.LENGTH_BOX * 0.08);
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		yPos = (int) (Component.START_Y + y * Component.LENGTH_BOX + Component.LENGTH_BOX * 0.05);
	}

	public TypeKonOuk getTypeKon() {
		return typeKon;
	}

	public void setTypeKon(TypeKonOuk typeKon) {
		this.typeKon = typeKon;
	}

	public Board(int x, int y) {
		// TODO Auto-generated constructor stub
		setX(x);
		setY(y);
		typeKon = TypeKonOuk.FREE;
		// img = new ImageIcon("res\\square.jpg").getImage();
		try {
			img = ImageIO.read(new File("res/square.jpg"));
		} catch (IOException e) {
			System.out.println("Swag not turned on");
			// System.exit(-1);
		}
	}

	public void draw(Graphics g) {
		g.drawImage(img, x * Component.LENGTH_BOX + Component.START_X, y
				* Component.LENGTH_BOX + Component.START_Y,
				Component.LENGTH_BOX, Component.LENGTH_BOX, null);
		if (typeKon != TypeKonOuk.FREE) {
			Image img1 = new ImageIcon(typeKon.location).getImage();
			g.drawImage(img1, xPos, yPos, Component.KON_SIZE,
					Component.KON_SIZE, null);
		}
		if (onOver) {
			Image img1 = new ImageIcon(TypeKonOuk.MOUSE_OVER.location)
					.getImage();
			g.drawImage(img1, x * Component.LENGTH_BOX + Component.START_X, y
					* Component.LENGTH_BOX + Component.START_Y,
					Component.LENGTH_BOX, Component.LENGTH_BOX, null);
		}
	}

	public boolean isInBoard(int x, int y) {
		boolean isIn = false;
		if (x > xPos && x < xPos + Component.KON_SIZE && y > yPos
				&& y < yPos + Component.KON_SIZE) {
			isIn = true;
		}
		return isIn;
	}

	public void onOverMe(int x, int y) {
		if (isInBoard(x, y)) {
			onOver = true;
		} else {
			onOver = false;
		}
	}

	public boolean isOnOver() {
		return onOver;
	}

	public void setOnOver(boolean onOver) {
		this.onOver = onOver;
	}
}
