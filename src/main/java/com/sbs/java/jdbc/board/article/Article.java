package com.sbs.java.jdbc.board.article;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

//@Getter
//@Setter
//@ToString
@AllArgsConstructor
//@NoArgsConstructor  //final이 붙어있는 맴버 변수가 있으면 사용할 수 없다.
@Data
public class Article {
  private final int id;
  private final LocalDateTime regDate;
  private LocalDateTime updateDate;
  private String subject;
  private String content;

  public Article(Map<String, Object> articleMap) {
    this.id = (int) articleMap.get("id");
    this.regDate = (LocalDateTime) articleMap.get("regDate");
    this.updateDate = (LocalDateTime) articleMap.get("updateDate");;
    this.subject = (String) articleMap.get("subject");;
    this.content = (String) articleMap.get("content");;
  }
}
