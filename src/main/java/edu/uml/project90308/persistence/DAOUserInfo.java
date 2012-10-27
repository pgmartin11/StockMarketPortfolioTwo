package edu.uml.project90308.persistence;

import java.util.List;
import java.util.ArrayList;

import java.io.IOException;
import org.xml.sax.SAXException;

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
    public static List<UserInfo> getUserAccount(String username, String password) throws CouldNotReadDataException {
        List<UserInfo> accountList = new ArrayList<UserInfo>();
        List<UserInfo> userInfoList;

        try {
            userInfoList = UserHandlerXML.parse();
        }
        catch (SAXException sxe) {
            throw new CouldNotReadDataException("XML parser error: " + sxe.getMessage());
        }
        catch (IOException ioe) {
            throw new CouldNotReadDataException("IO Error: " + ioe.getMessage());
        }

        for (UserInfo account : userInfoList) {
            if (username.equals(account.getUserName()) && password.equals(account.getPassword())){
                    accountList.add(account);
            }
        }

        return accountList;
    }
}
