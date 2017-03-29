package MyChess;

import java.util.ArrayList;

public class CheckKing {
	public static boolean isWalkable(Board[][]board,PlayerType playT,TypeKonOuk typeK){
		if(CheckKon.redSide(typeK)){
			return isRedWalkable(board, playT);
		}else if(CheckKon.whiteSide(typeK)){
			return isWhiteWalkable(board, playT);
		}
		return false;
	}
	public static boolean isRedWalkable(Board[][]board,PlayerType playT){
		PosKon kingPos=new PosKon();
		ArrayList<PosKon>konPos=new ArrayList<PosKon>();
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++){
				if(board[i][j].getTypeKon()==TypeKonOuk.ANG_RED){
					kingPos.setX(i);
					kingPos.setY(j);
					//break;
				}else if(board[i][j].getTypeKon()==TypeKonOuk.ANG_WHITE){
					konPos.addAll(kingWalk(i, j));
					//System.out.println("King="+konPos.size());
				}else if(board[i][j].getTypeKon()==TypeKonOuk.NEANG_WHITE){
					konPos.addAll(neangWalk(i, j));
					//System.out.println("NEANG="+konPos.size());
				}else if(board[i][j].getTypeKon()==TypeKonOuk.KOUL_WHITE){
					konPos.addAll(koulWalk(i, j, board[i][j].getTypeKon(), playT));
					//System.out.println("KOUL="+konPos.size());
				}else if(board[i][j].getTypeKon()==TypeKonOuk.SES_WHITE_LEFT||board[i][j].getTypeKon()==TypeKonOuk.SES_WHITE_RIGHT){
					konPos.addAll(sesWalk(i, j));
					//System.out.println("SES="+konPos.size());
				}else if(board[i][j].getTypeKon()==TypeKonOuk.TOUK_WHITE){
					konPos.addAll(toukWalk(i, j, board, board[i][j].getTypeKon()));
					//System.out.println("Touk="+konPos.size());
				}else if(board[i][j].getTypeKon()==TypeKonOuk.TREY_BORK_WHITE||board[i][j].getTypeKon()==TypeKonOuk.TREY_WHITE){
					konPos.addAll(treyWalk(i, j, board[i][j].getTypeKon(), playT, board));
					//System.out.println("TREY="+konPos.size());
				}
			}
		//System.out.println(konPos.size());
		//System.out.println("King"+kingPos.getX()+","+kingPos.getY());
		/*for(int i=0;i<konPos.size();i++){
			System.out.println(konPos.get(i).getX()+","+konPos.get(i).getY());
		}*/
		for(int i=0;i<konPos.size();i++){
			if(kingPos.getX()==konPos.get(i).getX()&&kingPos.getY()==konPos.get(i).getY()){
				return true;
			}
		}
		return false;

	}
	public static boolean isWhiteWalkable(Board[][]board,PlayerType playT){
		PosKon kingPos=new PosKon();
		ArrayList<PosKon>konPos=new ArrayList<PosKon>();
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++){
				if(board[i][j].getTypeKon()==TypeKonOuk.ANG_WHITE){
					kingPos.setX(i);
					kingPos.setY(j);
					//break;
				}else if(board[i][j].getTypeKon()==TypeKonOuk.ANG_RED){
					konPos.addAll(kingWalk(i, j));
				}else if(board[i][j].getTypeKon()==TypeKonOuk.NEANG_RED){
					konPos.addAll(neangWalk(i, j));
				}else if(board[i][j].getTypeKon()==TypeKonOuk.KOUL_RED){
					konPos.addAll(koulWalk(i, j, board[i][j].getTypeKon(), playT));
				}else if(board[i][j].getTypeKon()==TypeKonOuk.SES_RED_LEFT||board[i][j].getTypeKon()==TypeKonOuk.SES_RED_RIGHT){
					konPos.addAll(sesWalk(i, j));
				}else if(board[i][j].getTypeKon()==TypeKonOuk.TOUK_RED){
					konPos.addAll(toukWalk(i, j, board, board[i][j].getTypeKon()));
				}else if(board[i][j].getTypeKon()==TypeKonOuk.TREY_BORK_RED||board[i][j].getTypeKon()==TypeKonOuk.TREY_RED){
					konPos.addAll(treyWalk(i, j, board[i][j].getTypeKon(), playT, board));
				}
			}
		for(int i=0;i<konPos.size();i++){
			if(kingPos.getX()==konPos.get(i).getX()&&kingPos.getY()==konPos.get(i).getY()){
				return true;
			}
		}
		return false;
	}
	private static ArrayList<PosKon> kingWalk(int x,int y){
		ArrayList<PosKon> posKon=new ArrayList<PosKon>();
			if(x+1<8)posKon.add(new PosKon(x+1,y));
			if(y+1<8)posKon.add(new PosKon(x,y+1));
			if(x-1>=0)posKon.add(new PosKon(x-1,y));
			if(y-1>=0)posKon.add(new PosKon(x,y-1));
			
			if(x+1<8&&y+1<8)posKon.add(new PosKon(x+1,y+1));
			if(x-1>=0&&y+1<8)posKon.add(new PosKon(x-1,y+1));
			if(x-1>=0&&y-1>=0)posKon.add(new PosKon(x-1,y-1));
			if(x+1<8&&y-1>=0)posKon.add(new PosKon(x+1,y-1));
		return posKon;
	}
	private static ArrayList<PosKon> neangWalk(int x,int y){
		ArrayList<PosKon> posKon=new ArrayList<PosKon>();
			
			if(x+1<8&&y+1<8)posKon.add(new PosKon(x+1,y+1));
			if(x-1>=0&&y+1<8)posKon.add(new PosKon(x-1,y+1));
			if(x-1>=0&&y-1>=0)posKon.add(new PosKon(x-1,y-1));
			if(x+1<8&&y-1>=0)posKon.add(new PosKon(x+1,y-1));
		return posKon;
	}
	private static ArrayList<PosKon> sesWalk(int x,int y){
		ArrayList<PosKon> posKon=new ArrayList<PosKon>();
		if(x+1<8&&y+2<8)posKon.add(new PosKon(x+1,y+2));
		if(x-1>=0&&y+2<8)posKon.add(new PosKon(x-1,y+2));
		if(x-1>=0&&y-2>=0)posKon.add(new PosKon(x-1,y-2));
		if(x+1<8&&y-2>=0)posKon.add(new PosKon(x+1,y-2));

			if(x+2<8&&y+1<8)posKon.add(new PosKon(x+2,y+1));
			if(x-2>=0&&y+1<8)posKon.add(new PosKon(x-2,y+1));
			if(x-2>=0&&y-1>=0)posKon.add(new PosKon(x-2,y-1));
			if(x+2<8&&y-1>=0)posKon.add(new PosKon(x+2,y-1));
		return posKon;
	}
	private static ArrayList<PosKon> toukWalk(int x,int y,Board[][]board,TypeKonOuk typeK){
		ArrayList<PosKon> posKon=new ArrayList<PosKon>();
			for(int i=x+1;i<8;i++){
				if(board[i][y].getTypeKon()==TypeKonOuk.FREE){
					posKon.add(new PosKon(i,y));
				}else if(CheckKon.redSide(typeK)&&CheckKon.whiteSide(board[i][y].getTypeKon())){
					posKon.add(new PosKon(i,y));
					break;
				}else if(CheckKon.whiteSide(typeK)&&CheckKon.redSide(board[i][y].getTypeKon())){
					posKon.add(new PosKon(i,y));
					break;
				}else{
					break;
				}
			}	
			for(int i=x-1;i>=0;i--){
				if(board[i][y].getTypeKon()==TypeKonOuk.FREE){
					posKon.add(new PosKon(i,y));
				}else if(CheckKon.redSide(typeK)&&CheckKon.whiteSide(board[i][y].getTypeKon())){
					posKon.add(new PosKon(i,y));
					break;
				}else if(CheckKon.whiteSide(typeK)&&CheckKon.redSide(board[i][y].getTypeKon())){
					posKon.add(new PosKon(i,y));
					break;
				}else{
					break;
				}
			}
			for(int j=y+1;j<8;j++){
				if(board[x][j].getTypeKon()==TypeKonOuk.FREE){
					posKon.add(new PosKon(x,j));
				}else if(CheckKon.redSide(typeK)&&CheckKon.whiteSide(board[x][j].getTypeKon())){
					posKon.add(new PosKon(x,j));
					break;
				}else if(CheckKon.whiteSide(typeK)&&CheckKon.redSide(board[x][j].getTypeKon())){
					posKon.add(new PosKon(x,j));
					break;
				}else{
					break;
				}
			}
			for(int j=y-1;j>=0;j--){
				if(board[x][j].getTypeKon()==TypeKonOuk.FREE){
					posKon.add(new PosKon(x,j));
				}else if(CheckKon.redSide(typeK)&&CheckKon.whiteSide(board[x][j].getTypeKon())){
					posKon.add(new PosKon(x,j));
					break;
				}else if(CheckKon.whiteSide(typeK)&&CheckKon.redSide(board[x][j].getTypeKon())){
					posKon.add(new PosKon(x,j));
					break;
				}else{
					break;
				}
			}
			
		return posKon;
	}
	private static ArrayList<PosKon> koulWalk(int x,int y,TypeKonOuk typeK,PlayerType play){
		ArrayList<PosKon> posKon=new ArrayList<PosKon>();
			
			if(x+1<8&&y+1<8)posKon.add(new PosKon(x+1,y+1));
			if(x-1>=0&&y+1<8)posKon.add(new PosKon(x-1,y+1));
			if(x-1>=0&&y-1>=0)posKon.add(new PosKon(x-1,y-1));
			if(x+1<8&&y-1>=0)posKon.add(new PosKon(x+1,y-1));
			if(play==PlayerType.WHITE){
				if(typeK==TypeKonOuk.KOUL_RED){
					if(y+1<8)posKon.add(new PosKon(x,y+1));
				}else if(typeK==TypeKonOuk.KOUL_WHITE){
					if(y-1>=0)posKon.add(new PosKon(x,y-1));
				}
			}else if(play==PlayerType.WHITE){
				if(typeK==TypeKonOuk.KOUL_RED){
					if(y-1>=0)posKon.add(new PosKon(x,y-1));
				}else if(typeK==TypeKonOuk.KOUL_WHITE){
					if(y+1<8)posKon.add(new PosKon(x,y+1));
				}				
			}
			
		return posKon;
	}
	private static ArrayList<PosKon> treyWalk(int x,int y,TypeKonOuk typeK,PlayerType play,Board[][]board){
		ArrayList<PosKon> posKon=new ArrayList<PosKon>();
		if(play==PlayerType.WHITE){
			if(typeK==TypeKonOuk.TREY_RED){
				if(y+1<8){
					if(board[x][y+1].getTypeKon()==TypeKonOuk.FREE)posKon.add(new PosKon(x,y+1));	
				}
				if(y+1<8&&x+1<8){
					if(CheckKon.whiteSide(board[x+1][y+1].getTypeKon()))posKon.add(new PosKon(x+1,y+1));	
				}
				if(y+1<8&&x-1>=0){
					if(CheckKon.whiteSide(board[x-1][y+1].getTypeKon()))posKon.add(new PosKon(x-1,y+1));	
				}
				
			}else if(typeK==TypeKonOuk.TREY_WHITE){				
				if(y-1>=0){
					if(board[x][y-1].getTypeKon()==TypeKonOuk.FREE)posKon.add(new PosKon(x,y-1));	
				}
				if(y-1>=0&&x+1<8){
					if(CheckKon.redSide(board[x+1][y-1].getTypeKon()))posKon.add(new PosKon(x+1,y-1));	
				}
				if(y-1>=0&&x-1>=0){
					if(CheckKon.redSide(board[x-1][y-1].getTypeKon()))posKon.add(new PosKon(x-1,y-1));	
				}
			}
		}else if(play==PlayerType.RED){
			if(typeK==TypeKonOuk.TREY_RED){				
				if(y-1>=0){
					if(board[x][y-1].getTypeKon()==TypeKonOuk.FREE)posKon.add(new PosKon(x,y-1));	
				}
				if(y-1>=0&&x+1<8){
					if(CheckKon.whiteSide(board[x+1][y-1].getTypeKon()))posKon.add(new PosKon(x+1,y-1));	
				}
				if(y-1>=0&&x-1>=0){
					if(CheckKon.whiteSide(board[x-1][y-1].getTypeKon()))posKon.add(new PosKon(x-1,y-1));	
				}
			}else if(typeK==TypeKonOuk.TREY_WHITE){
				if(y+1<8){
					if(board[x][y+1].getTypeKon()==TypeKonOuk.FREE)posKon.add(new PosKon(x,y+1));	
				}
				if(y+1<8&&x+1<8){
					if(CheckKon.redSide(board[x+1][y+1].getTypeKon()))posKon.add(new PosKon(x+1,y+1));	
				}
				if(y+1<8&&x-1>=0){
					if(CheckKon.redSide(board[x-1][y+1].getTypeKon()))posKon.add(new PosKon(x-1,y+1));	
				}
			}				
		}
		
		
		
		if(typeK==TypeKonOuk.TREY_BORK_RED||typeK==TypeKonOuk.TREY_BORK_WHITE){
			posKon.addAll(neangWalk(x, y));
		}
		
		return posKon;
	}
	
}
