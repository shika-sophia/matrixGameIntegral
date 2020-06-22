package model;

import java.util.ArrayList;
import java.util.List;

import DAO.LoadDAO;

public class LoadLogic {
  public MatrixBeans loadSetting(User user) {

	  int puzzleId = user.getPuzzleId();

	  MatrixBeans matrixDB = new MatrixBeans();
	  List<Integer> colorDB = new ArrayList<>(32);

	  LoadDAO dao = new LoadDAO();
	  matrixDB = dao.loadData(puzzleId, colorDB, matrixDB);


	  return matrixDB;
  }//existData()

}//class
