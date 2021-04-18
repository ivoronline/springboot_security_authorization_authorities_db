package com.ivoronline.springboot_security_authorization_authorities_db.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @PreAuthorize("hasAuthority('book.create')")
  @RequestMapping("/CreateBook")
  public String createBook() {
    return "Only ADMIN can create Book";
  }

  @PreAuthorize("hasAuthority('book.read')")
  @RequestMapping("/ReadBook")
  public String readBook() {
    return "ADMIN and USER can read Book";
  }

  @PreAuthorize("hasAuthority('book.update')")
  @RequestMapping("/UpdateBook")
  public String updateBook() {
    return "Only ADMIN can update Book";
  }

  @PreAuthorize("hasAuthority('book.delete')")
  @RequestMapping("/DeleteBook")
  public String deleteBook() {
    return "Only ADMIN can delete Book";
  }

}
