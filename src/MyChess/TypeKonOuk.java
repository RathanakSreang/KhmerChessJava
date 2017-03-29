package MyChess;

public enum TypeKonOuk {
	FREE(""), ANG_WHITE("res/white/king_white.png"), ANG_RED(
			"res/red/king_red.png"), NEANG_WHITE(
			"res/white/neang_white.png"), NEANG_RED("res/red/neang_red.png"), KOUL_WHITE(
			"res/white/koul_white.png"), KOUL_RED("res/red/koul_red.png"), SES_WHITE_LEFT(
			"res/white/horse_left_white.png"), SES_WHITE_RIGHT(
			"res/white/horse_right_white.png"), SES_RED_LEFT(
			"res/red/horse_left_red.png"), SES_RED_RIGHT(
			"res/red/horse_right_red.png"), TOUK_WHITE(
			"res/white/touk_white.png"), TOUK_RED("res/red/touk_red.png"), TREY_WHITE(
			"res/white/trey.png"), TREY_RED("res/red/trey.png"), TREY_BORK_WHITE(
			"res/white/trey_bork.png"), TREY_BORK_RED(
			"res/red/trey_bork.png"), MOUSE_OVER("res/Over.png"), MOUSE_CLICK(
			"res/Clicked.png"), EATABLE("res/caneat.png");

	public final String location;

	private TypeKonOuk(String location) {
		// TODO Auto-generated constructor stub
		this.location = location;
	}
}
