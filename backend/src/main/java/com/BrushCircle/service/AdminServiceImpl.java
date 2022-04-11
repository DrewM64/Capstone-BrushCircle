package com.BrushCircle.service;

import com.BrushCircle.model.User;
import com.BrushCircle.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AdminServiceImpl {

    @Autowired
    UserRepository userRepository;

    public
    List<User> getUsers(User admin) throws Exception {
        log.info("Running Admin getUsers");

        List<User> userList = userRepository.getAllRegUsers();

        try {
            if (admin == null) {
                throw new Exception();
            }
            if (userList.contains(admin)) {
                throw new Exception();
            } else {
                return userList;
            }
            } catch(Exception e) {
            log.info("\n[Error Found] Admin was not found..."
                    + "\n Admin Expected:   " + admin.getEmail()
                    + "\n Users Retrieved:  " + userList);
        }
        return null;
    }

}
