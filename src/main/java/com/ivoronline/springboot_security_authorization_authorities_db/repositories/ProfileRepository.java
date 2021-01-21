package com.ivoronline.springboot_security_authorization_authorities_db.repositories;

import com.ivoronline.springboot_security_authorization_authorities_db.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, String> { }
