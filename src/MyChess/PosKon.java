package MyChess;

public class PosKon {
	private int x, y;

	public PosKon() {
		x = 0;
		y = 0;
	}

	public PosKon(int x1, int y1) {
		x = x1;
		y = y1;
	}
	public void setPosKon(int x1,int y1){
		x = x1;
		y = y1;
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

}
