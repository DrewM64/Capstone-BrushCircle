package com.BrushCircle.service;

import com.BrushCircle.dto.LoginFormDTO;
import com.BrushCircle.dto.ProfilePhotoDTO;
import com.BrushCircle.dto.UserDTO;
import com.BrushCircle.model.User;
import com.BrushCircle.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    public static String uploadDirectory = System.getProperty("user.dir") + "/BrushCircleUploads";

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

    public User login(LoginFormDTO loginForm) throws Exception {
        log.info("Running Login");
        User existingUser = userRepository.findByEmail(loginForm.getEmail());
        try {
            if (loginForm == null) {
                throw new Exception();
            } else if (existingUser == null) {
                throw new Exception();
            } else {
                return existingUser;
            }
        } catch (Exception e) {
            log.info("\n[Error Found] User Email was not found..."
                    + "\n Email Expected for loginUser:     " + loginForm.getEmail()
                    + "\n Email Expected for currentUser:   " + existingUser.getEmail());
        }
        return null;
    }

    public User addProfPic(User user, MultipartFile file) throws Exception {
        log.info("\nAdd Profile Picture");
        log.info("\nUser Info:      " + user.toString());
        log.info("\nFile Info:      "
                + "\n" + file.getOriginalFilename()
                + "\n" + file.getContentType()
                + "\n" + Arrays.toString(file.getBytes()));
        User existing = userRepository.findByEmail(user.getEmail());
        existing.setProfileImageName(file.getOriginalFilename());
        userRepository.save(existing);
        Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        return existing;
    }

    public User resetProfPic(User currentUser) throws Exception {
        log.info("Reset Profile Picture");
        User existing = userRepository.findByEmail(currentUser.getEmail());
        Path fileNameAndPath = Paths.get(uploadDirectory, existing.getProfileImageName());
        Files.delete(fileNameAndPath);
        existing.setProfileImageName(null);
        userRepository.save(existing);
        return existing;
    }

    public User update(User currentUser) throws Exception {
        log.info("Updating Current User Info");
        log.info("User Object provided: " + currentUser.toString());
        User existing = userRepository.findByEmail(currentUser.getEmail());
        copyNonNullProperties(currentUser, existing);
        userRepository.save(existing);
        return existing;
    }

    public UserDTO getUserInfo(String email) throws Exception {
        log.info("Getting User Info");
        log.info("Email received:   " + email);
        User existing = userRepository.findByEmail(email);
        UserDTO userDTO = new UserDTO();
        userDTO.setUser(existing);
        userDTO.setProduct(existing.getProducts());
        return userDTO;
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
