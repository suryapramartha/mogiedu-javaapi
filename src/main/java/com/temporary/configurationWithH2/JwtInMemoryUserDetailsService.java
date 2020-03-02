/*
 * 
 * IMPLEMENTING USERDETAILSSERVICE FROM SPRING TO PROVIDE DATA FOR AUTHENTICATE THE CREATED USER
 * 
 * 
 * */
package com.temporary.configurationWithH2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "suryapramartha",
        "$2a$10$voF8FVJ.U0C6c5MgMe4J8uvhb./SREXId6j4augr5/pEFtwTkMwKu", "ROLE_ADMIN"));
    inMemoryUserList.add(new JwtUserDetails(1L, "gde",
            "$2a$10$voF8FVJ.U0C6c5MgMe4J8uvhb./SREXId6j4augr5/pEFtwTkMwKu", "ROLE_ROLE_1"));
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}


