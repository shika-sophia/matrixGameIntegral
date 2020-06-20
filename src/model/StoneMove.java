package model;

import java.util.List;

public class StoneMove {

    public List<Integer> stoneMove(String stoneMove,
                                    List<Integer> stoneAreaDB,
                                    List<Integer> selectList) {

        for (int select : selectList) {
            stoneAreaDB.set(select, 0);

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

            stoneAreaDB.set(select, 1);

        }//for

        selectList.clear();
        return stoneAreaDB;

    }//StoneMove()

}//class
