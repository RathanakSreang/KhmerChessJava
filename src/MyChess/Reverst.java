package MyChess;

public class Reverst {
	public static TypeKonOuk reversSES(TypeKonOuk typ) {
		if (typ == TypeKonOuk.SES_RED_LEFT)
			return TypeKonOuk.SES_RED_RIGHT;
		if (typ == TypeKonOuk.SES_RED_RIGHT)
			return TypeKonOuk.SES_RED_LEFT;
		if (typ == TypeKonOuk.SES_WHITE_RIGHT)
			return TypeKonOuk.SES_WHITE_LEFT;
		if (typ == TypeKonOuk.SES_WHITE_LEFT)
			return TypeKonOuk.SES_WHITE_RIGHT;
		return null;
	}
	public static int reversPos(int num) {
		if (num == 0)
			return 7;
		else if (num == 1)
			return 6;
		else if (num == 2)
			return 5;
		else if (num == 3)
			return 4;
		else if (num == 4)
			return 3;
		else if (num == 5)
			return 2;
		else if (num == 6)
			return 1;
		else if (num == 7)
			return 0;
		return -1;
	}
	public static boolean isSES(TypeKonOuk typ) {
		if (typ == TypeKonOuk.SES_RED_LEFT || typ == TypeKonOuk.SES_RED_RIGHT
				|| typ == TypeKonOuk.SES_WHITE_LEFT
				|| typ == TypeKonOuk.SES_WHITE_RIGHT) {
			return true;
		}
		return false;
	}
	public static PlayerType reversPlayer(PlayerType player) {
		if (player == PlayerType.WHITE)
			return PlayerType.RED;
		return PlayerType.WHITE;
	}
}
