package model;

import java.util.List;

public class StoneMove {

    public List<Integer> judgeStoneMove(String stoneMove, List<Integer> selectList) {

        for (int select : selectList) {
            selectList.set(select, 0);

            // ---- MKM stoneMove Logic ----
            if(stoneMove.equals("up")) {
                select = -5;
            }else if(stoneMove.equals("down")) {
                select = +5;
            }else if(stoneMove.equals("left")) {
                select = -1;
            }else if(stoneMove.equals("right")) {
                select = +1;
            }else if(stoneMove.equals("enter")) {

            }

            selectList.set(select, 1);

        }//for

        return selectList;

    }//judgeStoneMove()

}//class
