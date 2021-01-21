package com.ivoronline.springboot_security_authorization_authorities_db.repositories;

import com.ivoronline.springboot_security_authorization_authorities_db.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
  Account findByUsername(String Username);
}
