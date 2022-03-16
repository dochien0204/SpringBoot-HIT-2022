package com.example.btvnb3;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static List<User> listUser = new ArrayList<>();

    static {
        listUser.add(new User(1, "dochien1","dochien123","Do Chien 1"));
        listUser.add(new User(2, "dochien1","dochien123","Do Chien 1"));
        listUser.add(new User(3, "dochien1","dochien123","Do Chien 1"));
        listUser.add(new User(4, "dochien1","dochien123","Do Chien 1"));
        listUser.add(new User(5, "dochien1","dochien123","Do Chien 1"));
        listUser.add(new User(6, "dochien1","dochien123","Do Chien 1"));
        listUser.add(new User(7, "dochien1","dochien123","Do Chien 1"));

    }

    public static List<User> getListUser() {
        return listUser;
    }

    public static void setListUser(List<User> listUser) {
        Store.listUser = listUser;
    }

    public static boolean check(User user)
    {
        for(User u : listUser)
        {
            if(user.equals(u))
            {
                return  true;
            }

        }
        return false;
    }


}
