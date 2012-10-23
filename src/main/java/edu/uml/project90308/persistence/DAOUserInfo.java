package edu.uml.project90308.persistence;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Peter G. Martin
 *
 * A static class which contains methods for retrieving and persistihg user account information
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
        List<UserInfo> accountList = new ArrayList<UserInfo>();

        List<UserInfo> userInfoList = UserHandlerXML.parse();
        if (!userInfoList.isEmpty()) {
            for (UserInfo account : userInfoList) {
                if (username.equals(account.getUserName()) && password.equals(account.getPassword())){
                    accountList.add(account);
                }
            }
        }
        else
            accountList = userInfoList;

        return accountList;
    }
}
