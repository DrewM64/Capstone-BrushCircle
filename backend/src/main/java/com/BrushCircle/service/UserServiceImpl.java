package com.BrushCircle.service;

import com.BrushCircle.model.User;
import com.BrushCircle.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

//    public User registerUser(User newUser) throws Exception {
//        log.info("Running RegisterUser");
//        userRepository.save(newUser);
//        User registeredUser = userRepository.findByEmail(newUser.getEmail());
//        try {
//            if (newUser == null) {
//                throw new Exception();
//            } else {
//                return registeredUser;
//            }
//        } catch (Exception e) {
//            log.info("\n[Error Found] User Email was not found..."
//                    + "\n Email Expected:   " + newUser.getEmail());
//        }
//        return null;
//    }

        public User registerUser(String email, String password) throws Exception {
        log.info("Running RegisterUser");
        User newUser = new User(email, password);
        userRepository.save(newUser);
        User registeredUser = userRepository.findByEmail(newUser.getEmail());
        try {
            if (newUser == null) {
                throw new Exception();
            }
            return registeredUser;
        } catch (Exception e) {
            log.info("\n[Error Found] User Email was not found..."
                    + "\n Email Expected:   " + newUser.getEmail());
        }
        return null;
    }

    public User login(User loginUser) throws Exception {
        log.info("Running Login");
        User existingUser = userRepository.findByEmail(loginUser.getEmail());
        try {
            if (loginUser == null) {
                throw new Exception();
            } else if (existingUser == null) {
                throw new Exception();
            } else {
                return existingUser;
            }
        } catch (Exception e) {
            log.info("\n[Error Found] User Email was not found..."
                    + "\n Email Expected for loginUser:     " + loginUser.getEmail()
                    + "\n Email Expected for currentUser:   " + existingUser.getEmail());
        }
        return null;
    }

    public User addProfPic(User currentUser) throws Exception {
        log.info("Add Profile Picture");
        User existing = userRepository.findByEmail(currentUser.getEmail());
        existing.setProfileImageName(currentUser.getProfileImageName());
        userRepository.save(existing);
        return existing;
    }

    public User resetProfPic(User currentUser) throws Exception {
        log.info("Reset Profile Picture");
        User existing = userRepository.findByEmail(currentUser.getEmail());
        existing.setProfileImageName(null);
        userRepository.save(existing);
        return existing;
    }

    public User update(User currentUser) throws Exception {
        log.info("Updating Current User Info");
        User existing = userRepository.findByEmail(currentUser.getEmail());
        copyNonNullProperties(currentUser, existing);
        userRepository.save(existing);
        return existing;
    }

    public User getUserInfo(String email) throws Exception {
        log.info("Getting User Info");
        User existing = userRepository.findByEmail(email);
        return existing;
    }

    public static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
