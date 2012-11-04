package edu.uml.project90308.businesslogic;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import edu.uml.project90308.persistence.*;

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
	public static UserInfo processLogin(String uname, String passwd) throws UnableToObtainAccountsException, UserNotFoundException, MoreThanOneUserFoundException {
        List<UserInfo> userInfoList;

        try {
            userInfoList = DAOUserInfo.getUserAccount(uname, passwd);
        }
        catch (CouldNotReadDataException cnrde) {
            throw new UnableToObtainAccountsException("Unable to access the account XML file:" + cnrde.getMessage());
        }

        if (userInfoList.isEmpty())
            throw new UserNotFoundException("No user account found for that username and password");

        if (userInfoList.size() > 1)
            throw new MoreThanOneUserFoundException("Multiple user accounts found for that username and password");

        return userInfoList.get(0);
 	}

    /**
     * Logout a user from an existing session
     *
     * @param user UserInfo object for account
     */
	public static void processLogout(HttpSession session) {
        session.invalidate();
		return;
	}
	
}