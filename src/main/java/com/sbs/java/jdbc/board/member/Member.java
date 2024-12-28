package com.sbs.java.jdbc.board.member;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@Data
public class Member {
  private final int id;
  private final LocalDateTime regDate;
  private LocalDateTime updateDate;
  private String username;
  private String content;
  private String name;

  public Member(Map<String, Object> articleMap) {
    this.id = (int) articleMap.get("id");
    this.regDate = (LocalDateTime) articleMap.get("regDate");
    this.updateDate = (LocalDateTime) articleMap.get("updateDate");;
    this.username = (String) articleMap.get("username");;
    this.content = (String) articleMap.get("content");;
    this.name = (String) articleMap.get("name");
  }
}
