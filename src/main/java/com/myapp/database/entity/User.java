package com.myapp.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by istomin.a on 16.11.2016.
 */
@Entity(name = "USER")
public class User {
 @Id
 @GeneratedValue
 @Column
 private Long id;

 @Column
 private String email;

 @Column
 private String login;

 @Column
 private String password;

 @Column(name = "reg_date")
 private Date regDate = new Date();

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

 public String getLogin() {
  return login;
 }

 public void setLogin(String login) {
  this.login = login;
 }

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public Date getRegDate() {
  return regDate;
 }
}
