package com.sbs.java.jdbc.board.member;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

//@AllArgsConstructor
//@Data
public class Member {
  private final int id;
  private final LocalDateTime regDate;
  private LocalDateTime updateDate;
  private String username;
  private String password;
  private String name;

  public Member(int id, LocalDateTime regDate, LocalDateTime updateDate, String username, String password, String name) {
    this.id = id;
    this.regDate = regDate;
    this.updateDate = updateDate;
    this.username = username;
    this.password = password;
    this.name = name;
  }

  public Member(Map<String, Object> articleMap) {
    this.id = (int) articleMap.get("id");
    this.regDate = (LocalDateTime) articleMap.get("regDate");
    this.updateDate = (LocalDateTime) articleMap.get("updateDate");;
    this.username = (String) articleMap.get("username");;
    this.password = (String) articleMap.get("password");;
    this.name = (String) articleMap.get("name");
  }

  public int getId() {
    return id;
  }

  public LocalDateTime getRegDate() {
    return regDate;
  }

  public LocalDateTime getUpdateDate() {
    return updateDate;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public void setUpdateDate(LocalDateTime updateDate) {
    this.updateDate = updateDate;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setName(String name) {
    this.name = name;
  }
}
