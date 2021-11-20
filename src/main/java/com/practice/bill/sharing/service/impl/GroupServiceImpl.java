package com.practice.bill.sharing.service.impl;

import com.practice.bill.sharing.entity.Group;
import com.practice.bill.sharing.entity.User;
import com.practice.bill.sharing.repository.GroupRepository;
import com.practice.bill.sharing.service.GroupService;
import com.practice.bill.sharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    UserService userService;

    @Autowired
    GroupRepository groupRepository;

    @Override
    public void addGroup(String groupId, String groupName, List<String> emailIds) {
        Group group = new Group();
        group.setId(groupId);
        group.setGroupName(groupName);
        List<User> users = new ArrayList<>();
        for (String emailId : emailIds) {
            users.add(userService.getUser(emailId));
        }
        group.setGroupMembers(users);
        groupRepository.setGroupMap(group);
    }
}
