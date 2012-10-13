package edu.uml.project90308.businesslogic;// Business logic tier

import java.util.List;
import java.util.ArrayList;

import edu.uml.project90308.persistence.DAOUserInfo;
import edu.uml.project90308.persistence.UserInfo;

/**
 * @author Peter G. Martin
 *
 * A static class which contains methods for peforming authentication during a login attempt and logging out
 * an existing session
 */
public class Authenticate {

    /**
     * Attempt to create a session for the supplied username and password
     *
     * @param uname userName of account
     * @param passwd password of account    /**
     * verifies the userName only contains letters and white space, then sets the userName
     *
     * @throws UserNotFoundException
     */
	public static UserInfo processLogin(String uname, String passwd) throws UserNotFoundException {
        List<UserInfo> userInfoList = DAOUserInfo.getUserAccount(uname, passwd);
        if (!userInfoList.isEmpty())
            return userInfoList.get(0);
        else
            throw new UserNotFoundException("No user account found for that username and password");
	}

    /**
     * Logout a user from an existing session
     *
     * @param user UserInfo object for account
     */
	public static void processLogout(UserInfo user) {
		return;
	}
	
}