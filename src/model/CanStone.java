package model;

import java.util.List;

public class CanStone {

    public static void main(String[] args) {
    }

    public boolean canRange(String stoneSelect, List<Integer> selectList) {
        boolean canRange =false;

        for (int select : selectList) {

            if(stoneSelect.equals("tri")) {//if①
                if(select==1 || select==2 || select==3 || select==4
                 || select==5 || select==10 || select==15 || select==20
                 || select==25){

                   canRange = false;
                } //if①

            }else if(stoneSelect=="twice") {//if②

                if(select==1 || select==2 || select==3 || select==4 || select==5){

                   canRange = false;
                }

            }else {
                   canRange = true;
            }

       }//for

       return canRange;
    }//canRange()


    public boolean canBlock(MatrixBeans matrixDB) {

        boolean canBlock = false;
        List<Integer> stoneAreaDB = (List<Integer>) matrixDB.getStoneAreaDB();
        List<Integer> colorDB = (List<Integer>) matrixDB.getColorDB();

        for(int i=1;i<=25;i++) {

            if((colorDB.get(i) == stoneAreaDB.get(i))  && (colorDB.get(i)==1)) {

                canBlock = false;

            }else {
                canBlock = true;

            }
        }//for

        return canBlock;
    }

}
