package model;

public class StoneMove {

	public int execute(StoneBeans stb) {
		String stM=stb.getStoneMove();
		int select=stb.getSelect();
		if(stM=="up") {
			select=-5;
		}else if(stM=="down") {
			select=+5;
		}else if(stM=="left") {
			select=-1;
		}else if(stM=="right") {
			select=+1;
		}else if(stM=="enter") {
			return select;
		}
		return select;
	}

}
