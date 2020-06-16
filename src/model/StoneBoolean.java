package model;

public class StoneBoolean {
	public boolean execute(StoneBeans stb) {
		boolean hannbetu;
		Integer select=stb.getSelect();
		String stoneSelect=stb.getStoneSelect();
		if(stoneSelect=="tri") {//if①
			if(select==4||select==5||select==9||select==10//①
				||select==14||select==15||select==19||select==20
				||select==24||select==25)
			{
				hannbetu =false;
				return hannbetu;
			}//①
		}else if(stoneSelect=="twice") {
			if(select==5||select==10||select==15//②
				||select==20||select==25)
			{
				hannbetu =false;
				return hannbetu;
			}//②
		}else if(stoneSelect=="Sample"){
			if(select==1||select==2||select==3||select==4||select==5||//4
				select==10||select==15||select==20||select==25)
			{
				hannbetu =false;
				return hannbetu;

			}//4

		}else {
			hannbetu =true;
			return hannbetu;
		}//if①
		hannbetu =true;
		return hannbetu;
	}//execute

}//class
