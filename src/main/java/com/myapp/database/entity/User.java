package com.myapp.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by istomin.a on 16.11.2016.
 */
@Entity(name = "USER")
public class User {
 @Id
 @Column
 private Long id;
 @Column
 private String email;

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }
}
