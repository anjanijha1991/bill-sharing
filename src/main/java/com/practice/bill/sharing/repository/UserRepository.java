package com.practice.bill.sharing.repository;

import com.practice.bill.sharing.entity.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepository {

    private final Map<String, User> userMap;

    UserRepository() {
        userMap = new HashMap<>();
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(User user) {
        // TODO duplicate check
        userMap.putIfAbsent(user.getId(), user);
    }

    public User getUser(String emailId) {
        return userMap.get(emailId);
    }

    public void printUsers() {
        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            User user = entry.getValue();
            System.out.println(user.getId() + " " + user.getName());
        }
    }
}
