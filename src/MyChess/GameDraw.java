package MyChess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameDraw extends JPanel implements KeyListener,
		MouseMotionListener, MouseListener {
	private BufferedImage background;
	private BufferedImage boarder;
	private Board board[][];
	private ArrayList<KonOuk> konOuk;
	private ReadWriteFile readWrite;
	private LanguageType langType = LanguageType.KHMER;
	private PlayerType player = PlayerType.WHITE;

	public GameDraw() {
		// TODO Auto-generated constructor stub
		try {
			background = ImageIO.read(new File("res/GameBack.jpg"));
			boarder = ImageIO.read(new File("res/Boarder.png"));
		} catch (IOException e) {
			System.out.println("Swag not turned on");
			// System.exit(-1);
		}
		readWrite = new ReadWriteFile("temFile");
		konOuk = new ArrayList<KonOuk>();
		board = new Board[8][8];
		initBoard();
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	private void initBoard() {

		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Board(i, j);
			}
		freeBoard();
		initKon();
		setBoard();
		try {
			readWrite.writeKokOuk(konOuk);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(readWrite.readKokOuk().size());
	}

	private void freeBoard() {
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				board[i][j].setTypeKon(TypeKonOuk.FREE);
			}
	}

	private void setBoard() {
		for (int i = 0; i < konOuk.size(); i++) {
			board[konOuk.get(i).getX()][konOuk.get(i).getY()].setTypeKon(konOuk
					.get(i).getTypeKOn());
		}
	}

	private void initKon() {

		konOuk.add(new King(4, 0, TypeKonOuk.ANG_RED));
		konOuk.add(new Neang(3, 0, TypeKonOuk.NEANG_RED));
		konOuk.add(new Koul(5, 0, TypeKonOuk.KOUL_RED));
		konOuk.add(new Koul(2, 0, TypeKonOuk.KOUL_RED));
		konOuk.add(new SES(1, 0, TypeKonOuk.SES_RED_LEFT));
		konOuk.add(new SES(6, 0, TypeKonOuk.SES_RED_RIGHT));
		konOuk.add(new Touk(0, 0, TypeKonOuk.TOUK_RED));
		konOuk.add(new Touk(7, 0, TypeKonOuk.TOUK_RED));
		for (int i = 0; i < 8; i++) {
			konOuk.add(new Trey(i, 2, TypeKonOuk.TREY_RED));
		}
		// White//////////////
		konOuk.add(new King(3, 7, TypeKonOuk.ANG_WHITE));
		konOuk.add(new Neang(4, 7, TypeKonOuk.NEANG_WHITE));
		konOuk.add(new Koul(5, 7, TypeKonOuk.KOUL_WHITE));
		konOuk.add(new Koul(2, 7, TypeKonOuk.KOUL_WHITE));
		konOuk.add(new SES(1, 7, TypeKonOuk.SES_WHITE_LEFT));
		konOuk.add(new SES(6, 7, TypeKonOuk.SES_WHITE_RIGHT));
		konOuk.add(new Touk(0, 7, TypeKonOuk.TOUK_WHITE));
		konOuk.add(new Touk(7, 7, TypeKonOuk.TOUK_WHITE));
		for (int i = 0; i < 8; i++) {
			konOuk.add(new Trey(i, 5, TypeKonOuk.TREY_WHITE));
		}
	}

	public void draw(Graphics g) {

		super.paintComponents(g);
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.drawImage(background, 0, 0, Component.WIDTH, Component.HEIGHT, null);
		g.drawImage(boarder, Component.START_X - 25, Component.START_Y - 25,
				Component.LENGTH_BOX * 8 + 50, Component.LENGTH_BOX * 8 + 50,
				null);
		drawBoard(g);
		drawKonOuk(g);
		// g.drawString(checkWin(board), Component.WIDTH/2, Component.HEIGHT/2);

	}

	private void drawKonOuk(Graphics g) {
		for (int i = 0; i < konOuk.size(); i++) {
			konOuk.get(i).drawKonOuk(g, board);
		}
	}

	private void drawBoard(Graphics g) {
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				board[i][j].draw(g);
			}
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		g.setColor(Color.GREEN);
		g.fillOval(250, 250, 100, 100);
		// paintComponent(g);
		draw(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		if (e.getModifiers() == KeyEvent.CTRL_MASK
				&& e.getKeyCode() == KeyEvent.VK_Z) {
			changePos();

		}
		if (e.getModifiers() == KeyEvent.CTRL_MASK
				&& e.getKeyCode() == KeyEvent.VK_N) {
			reNew();

		}
		repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("Mouse is draggging");
		konMouseDragged(e);

		repaint();
	}

	private void konMouseDragged(MouseEvent e) {
		for (int i = 0; i < konOuk.size(); i++) {
			konOuk.get(i).mouseDragged(e, board);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		// clearClicked();

		repaint();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("Mouse is Press");

		konMousePressed(e);

		repaint();
	}

	private void konMousePressed(MouseEvent e) {
		for (int i = 0; i < konOuk.size(); i++) {
			if (player == PlayerType.WHITE) {
				if (CheckKon.whiteSide(konOuk.get(i).getTypeKOn())) {
					konOuk.get(i).mousePressed(e);
				}
			} else if (player == PlayerType.RED) {
				if (CheckKon.redSide(konOuk.get(i).getTypeKOn())) {
					konOuk.get(i).mousePressed(e);
				}
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

		konMouseReleased(e);
		// checkOtherCanNotWalk();
		checkOukKing();
		checkWin(board);
		checkIsKonMove();

		repaint();
	}

	private void checkIsKonMove() {
		for (int i = 0; i < konOuk.size(); i++) {
			// System.out.println(konOuk.get(i).isMove());
			if (konOuk.get(i).isMove()) {
				konOuk.get(i).setMove(false);
				saveFile();
				changePos();
				break;
			}

		}

	}

	private void saveFile() {
		for (int i = 0; i < konOuk.size(); i++) {
			konOuk.get(i).setPressed(false);
		}
		try {
			readWrite.writeKokOuk(konOuk);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void konMouseReleased(MouseEvent e) {
		for (int i = 0; i < konOuk.size(); i++) {
			konOuk.get(i).mouseReleased(e, board);

		}
		removeKon();
	}

	private void removeKon() {
		// board
		int num = konOuk.size();
		for (int n = 0; n < num; n++) {
			boolean isHas = false;
			for (int i = 0; i < 8; i++)
				for (int j = 0; j < 8; j++) {
					if (konOuk.get(n).getTypeKOn() == board[i][j].getTypeKon()
							&& (konOuk.get(n).getX() == board[i][j].getX() && konOuk
									.get(n).getY() == board[i][j].getY())) {
						isHas = true;
					}
				}
			if (!isHas) {
				konOuk.remove(n);
				n = n - 1;
				num = num - 1;
			}
		}

	}

	private void changePos() {
		for (int i = 0; i < konOuk.size(); i++) {
			konOuk.get(i).setxPos(Reverst.reversPos(konOuk.get(i).getX()));
			konOuk.get(i).setyPos(Reverst.reversPos(konOuk.get(i).getY()));
			konOuk.get(i).setPlayerType(
					Reverst.reversPlayer(konOuk.get(i).getPlayerType()));
		}
		for (int i = 0; i < konOuk.size(); i++) {
			if (Reverst.isSES(konOuk.get(i).getTypeKOn())) {
				konOuk.get(i).setTypeKOn(
						Reverst.reversSES(konOuk.get(i).getTypeKOn()));
			}
		}
		player = konOuk.get(0).getPlayerType();
		freeBoard();
		setBoard();
	}

	private void checkWin(Board[][] board) {
		boolean kingWhite = false;
		boolean kingRed = false;
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				if (board[i][j].getTypeKon() == TypeKonOuk.ANG_RED) {
					kingRed = true;
				}
				if (board[i][j].getTypeKon() == TypeKonOuk.ANG_WHITE) {
					kingWhite = true;
				}
			}
		if (!kingRed) {
			int option;
			if (langType == LanguageType.KHMER) {
				option = Message.showInfoYesNo("ក្រុមក្រហមចាញ់!ចាប់ផ្ដើមថ្មី?",
						TypeKonOuk.FREE, langType);
			} else {
				option = Message.showInfoYesNo("Red Group IS Lost!start new?",
						TypeKonOuk.FREE, langType);
			}
			if (option == JOptionPane.YES_OPTION) {
				reNew();
			} else if (option == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
		} else if (!kingWhite) {
			int option;
			if (langType == LanguageType.KHMER) {
				option = Message.showInfoYesNo("ក្រុមសរចាញ់!ចាប់ផ្ដើមថ្មី?",
						TypeKonOuk.FREE, langType);
			} else {
				option = Message.showInfoYesNo("White Group IS Lost",
						TypeKonOuk.FREE, langType);
			}
			if (option == JOptionPane.YES_OPTION) {
				reNew();
			} else if (option == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
		}

	}

	private void reNew() {
		freeBoard();
		konOuk.removeAll(konOuk);
		initKon();
		setBoard();
		player = PlayerType.WHITE;
	}

	private void checkOukKing() {
		for (int i = 0; i < konOuk.size(); i++) {
			if (konOuk.get(i).getKingOuk() == KingOuK.WASOUK) {
				if (langType == LanguageType.KHMER) {
					Message.showInfo("មិនអាចដើរ ជាប់អង្គ!", konOuk.get(i)
							.getTypeKOn(), langType);
				} else {
					Message.showInfo("Can not Move King was Ouk", konOuk.get(i)
							.getTypeKOn(), langType);
				}
				setAllMove(false);
				konOuk.get(i).setKingOuk(KingOuK.NOTHING);
			} else if (konOuk.get(i).getKingOuk() == KingOuK.OUK) {
				if (langType == LanguageType.KHMER) {
					Message.showInfo("អុកស្ដេច", konOuk.get(i).getTypeKOn(),
							langType);
				} else {
					Message.showInfo("OUK King", konOuk.get(i).getTypeKOn(),
							langType);
				}
				konOuk.get(i).setKingOuk(KingOuK.NOTHING);
			} else if (konOuk.get(i).getKingOuk() == KingOuK.ROUK) {
				if (langType == LanguageType.KHMER) {
					Message.showInfo("រុកស្ដេច", konOuk.get(i).getTypeKOn(),
							langType);
				} else {
					Message.showInfo("Rouk King", konOuk.get(i).getTypeKOn(),
							langType);
				}

				konOuk.get(i).setKingOuk(KingOuK.NOTHING);
			}
		}

	}

	public LanguageType getLangType() {
		return langType;
	}

	public void setLangType(LanguageType langType) {
		this.langType = langType;
	}

	private void setAllMove(boolean isMove) {
		for (int i = 0; i < konOuk.size(); i++) {
			konOuk.get(i).setMove(isMove);
		}
	}
}
