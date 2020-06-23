package model;

import java.util.List;

import DAO.RegisterDAO;

public class RegisterLogic {

	public void execute(User user) {

		RegisterDAO dao = new RegisterDAO();

		dao.insertRegister(user);
	}

	public boolean existRegister(User user) {

		RegisterDAO dao = new RegisterDAO();
        List<String> accountDB = dao.selectRegister(user);

        boolean existAccountId = existAccoutId(user, accountDB);

        return existAccountId;
	}//execute()


    private boolean existAccoutId(User user, List<String> accountDB) {
    	boolean existAccountId = false;

    	String accountId = user.getAccountId();

		for(String str : accountDB) {
		  if (accountId.equals(str)) {
			  existAccountId = true;
			  break;
		  } else {
			  existAccountId = false;
		  }
		}// for
		return existAccountId;
	}

}//class
