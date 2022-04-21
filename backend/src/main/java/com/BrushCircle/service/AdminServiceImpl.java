package com.BrushCircle.service;

import com.BrushCircle.model.User;
import com.BrushCircle.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUsers(User admin) throws Exception {
        log.info("Running Admin getUsers");

//        List<User> userList = userRepository.getAllRegUsers(); //TODO Fix
        List<User> userList = new ArrayList<>(userRepository.findAllByRole("USER"));
        try {
            for (User user: userList)
            {
                log.info("\nUser Info:  " + user.toString());
            }
            if (admin == null || admin.getRole().equals("USER")) {
                throw new Exception();
            } else if (userList.isEmpty()) {
                throw new Exception();
            } else {
                return userList;
            }
        } catch (Exception e) {
            log.info("\n[Error Found] Admin was not found..."
                    + "\n Admin Expected:   " + admin.getEmail()
                    + "\n Users Retrieved:  " + userList);
        }
        return null;
    }

}
