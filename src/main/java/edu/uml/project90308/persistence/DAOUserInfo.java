package edu.uml.project90308.persistence;

import java.util.List;
import java.util.ArrayList;


/**
 * @author Peter G. Martin
 *
 * A static class which contains methods for persistihg user account information for an exising session
 */
public class DAOUserInfo {

    /**
     * Verify existence of the user account for the provided username and password
     *
     * @param username username entered
     * @param password password entered
     *
     * @return A list containing a UserInfo object for the user account or an empty list if no valid user account found
     */
    public static List<UserInfo> getUserAccount(String username, String password) {
        // simulate returning a user
        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        UserInfo userInfo = new UserInfo(username, password);

        userInfoList.add(userInfo);
        return userInfoList;
    }
}
