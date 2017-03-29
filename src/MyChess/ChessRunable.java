package MyChess;

import javax.swing.JFrame;
@SuppressWarnings("serial")
public class ChessRunable extends JFrame {
	private GameDraw game;
	LanguageType langType=LanguageType.KHMER;
	public ChessRunable() {
					if(langType==LanguageType.KHMER){
			setTitle("អុកចត្រង្គ");
		}else{
			setTitle("Ouk Chaktrung");
		}
		
		setSize(Component.WIDTH, Component.HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		game = new GameDraw();
		game.setLangType(langType);
		add(game);
		addKeyListener(game);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChessRunable();
	}

}
