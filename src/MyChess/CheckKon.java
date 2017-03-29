package MyChess;

public class CheckKon {
	public static boolean whiteSide(TypeKonOuk typeK){
		if (typeK == TypeKonOuk.ANG_WHITE
				|| typeK == TypeKonOuk.KOUL_WHITE
				|| typeK == TypeKonOuk.NEANG_WHITE
				|| typeK == TypeKonOuk.SES_WHITE_LEFT
				|| typeK == TypeKonOuk.SES_WHITE_RIGHT
				|| typeK == TypeKonOuk.TOUK_WHITE
				|| typeK == TypeKonOuk.TREY_WHITE
				|| typeK == TypeKonOuk.TREY_BORK_WHITE) {
			return true;
		}
		return false;
	}
	public static boolean redSide(TypeKonOuk typeK){
		if (typeK == TypeKonOuk.ANG_RED
				|| typeK == TypeKonOuk.KOUL_RED
				|| typeK == TypeKonOuk.NEANG_RED
				|| typeK == TypeKonOuk.SES_RED_LEFT
				|| typeK == TypeKonOuk.SES_RED_RIGHT
				|| typeK == TypeKonOuk.TOUK_RED
				|| typeK == TypeKonOuk.TREY_RED
				|| typeK == TypeKonOuk.TREY_BORK_RED) {
			return true;
		}
		return false;
	}
}
