package edu.uml.project90308.persistence;

import java.util.List;
import java.util.ArrayList;

public class DAOUserInfo {

    public static List<UserInfo> getUserAccount(String username, String password) {
        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        UserInfo userInfo = new UserInfo(username, password);

        userInfoList.add(userInfo);
        return userInfoList;
    }
}
