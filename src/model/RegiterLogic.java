package model;

public class RegiterLogic {

	public boolean execute(User user) {

		RegiterDAO dao = new RegiterDAO();

		User user = dao.findByLogin(user);

		return true;
	}

}
