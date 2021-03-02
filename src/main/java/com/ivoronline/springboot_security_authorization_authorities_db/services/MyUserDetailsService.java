package com.ivoronline.springboot_security_authorization_authorities_db.services;

import com.ivoronline.springboot_security_authorization_authorities_db.entities.Account;
import com.ivoronline.springboot_security_authorization_authorities_db.entities.Authority;
import com.ivoronline.springboot_security_authorization_authorities_db.entities.Profile;
import com.ivoronline.springboot_security_authorization_authorities_db.repositories.AccountRepository;
import com.ivoronline.springboot_security_authorization_authorities_db.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  AccountRepository accountRepository;

  @Autowired
  private ProfileRepository profileRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    //GET ACCOUNT
    Account account = accountRepository.findByUsername(username);

    //GET PROFILE (WITH AUTHORITIES)
    Profile profile = profileRepository.findById(account.profile).get();

    //CREATE AUTHORITIES (TO CREATE USER)
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    for(Authority authority : profile.authorities) {
      authorities.add(new SimpleGrantedAuthority(authority.name));
    }

    //CREATE USER
    User user = new User(account.username, account.password, true, true, true, true, authorities);

    //RETURN USER
    return user;

  }

}
