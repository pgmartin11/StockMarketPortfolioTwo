package edu.uml.project90308.businesslogic;// Business logic tier


import edu.uml.project90308.persistence.Person;

public class Authenticate {

	public Authenticate() {
 	}

	public UserInfo processLogin(String uname, String passwd) {
        if (true)
		    return new UserInfo(uname, passwd);
        else
            return null;
	}

	public void processLogout(UserInfo user) {
		return;
	}
	
}