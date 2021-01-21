package com.ivoronline.springboot_security_authorization_authorities_db.config;

import com.ivoronline.springboot_security_authorization_authorities_db.entities.Account;
import com.ivoronline.springboot_security_authorization_authorities_db.repositories.AccountRepository;
import com.ivoronline.springboot_security_authorization_authorities_db.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Order(3)
public class AccountLoader implements CommandLineRunner {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private ProfileRepository profileRepository;

  @Override
  @Transactional
  public void run(String... args) throws Exception {

    //ADMIN: ANDREW
    Account andrew          = new Account();
            andrew.username = "john";
            andrew.password = "johnpassword";
            andrew.profile  = "ADMIN";

    //USER: URBAN
    Account urban          = new Account();
            urban.username = "urban";
            urban.password = "urbanpassword";
            urban.profile  = "USER";

    //STORE ACCOUNT INTO DB
    accountRepository.save(andrew);
    accountRepository.save(urban);

  }

}
