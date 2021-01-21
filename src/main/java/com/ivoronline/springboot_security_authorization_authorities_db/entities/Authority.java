package com.ivoronline.springboot_security_authorization_authorities_db.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Authority {

  @Id
  public String name;

  //CONSTRUCTORS
  public Authority() { }                               //Forced by @Entity
  public Authority(String name) { this.name = name; }  //To simplify AuthorityLoader

}
