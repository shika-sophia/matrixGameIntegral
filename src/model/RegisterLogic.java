package model;

import java.util.List;

import DAO.RegisterDAO;

public class RegisterLogic {

	public boolean execute(User user) {

		RegisterDAO dao = new RegisterDAO();
        List<String> accountDB = dao.selectRegister();

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
