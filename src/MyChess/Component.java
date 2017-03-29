package MyChess;

import java.awt.Toolkit;

public class Component {
	public final static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public final static int HEIGHT = Toolkit.getDefaultToolkit()
			.getScreenSize().height - 40;
	public final static int LENGTH_BOX = (int) ((HEIGHT - HEIGHT*0.1) / 8);
	public final static int START_X = (WIDTH - LENGTH_BOX * 8) / 2;
	public final static int START_Y = 35;
	public final static int KON_SIZE =(int) (LENGTH_BOX- LENGTH_BOX*0.15);
	
	public Component() {
		// TODO Auto-generated constructor stub
	}

}
