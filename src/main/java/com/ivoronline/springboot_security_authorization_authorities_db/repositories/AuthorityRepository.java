package com.ivoronline.springboot_security_authorization_authorities_db.repositories;

import com.ivoronline.springboot_security_authorization_authorities_db.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> { }
