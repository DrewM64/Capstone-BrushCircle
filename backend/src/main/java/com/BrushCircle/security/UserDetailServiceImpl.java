package com.BrushCircle.security;

import com.BrushCircle.model.User;
import com.BrushCircle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
  @Autowired
  private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    { 
      User currentUser = repository.findByEmail(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, currentUser.getPassword()
        , true, true, true, true, AuthorityUtils.createAuthorityList(String.valueOf(currentUser.getRole())));
        return user;
    }
}