package model;

import java.util.ArrayList;
import java.util.List;

public class StoneMove {

    List<Integer> movedSelectList = new ArrayList<>();

    public List<Integer> stoneMove(String stoneMove, List<Integer> selectList, List<Integer> stoneAreaDB, MatrixBeans matrixDB) {

        //---- moved select put stoneAreaDB ----
        for (int select : selectList) {

            stoneAreaDB.set(select, 0);

            // ---- stoneMove Logic by MKM----
            if(stoneMove.equals("up")) {
                select -= 5;
            }else if(stoneMove.equals("down")) {
                select += 5;
            }else if(stoneMove.equals("left")) {
                select -= 1;
            }else if(stoneMove.equals("right")) {
                select += 1;
            }

            stoneAreaDB.set(select, 1);
            movedSelectList = buildMoved(select);

        }//for
        selectList.clear();
        selectList.addAll(movedSelectList);

        return stoneAreaDB;

    }//StoneMove()


    private List<Integer> buildMoved(int select) {

        movedSelectList.add(select);

        return movedSelectList;

    }

}//class
