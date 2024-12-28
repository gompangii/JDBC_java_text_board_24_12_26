package com.sbs.java.jdbc.board.article;

import com.sbs.java.jdbc.board.Rq;
import com.sbs.java.jdbc.board.container.Container;
import com.sbs.java.jdbc.board.dbUtil.MysqlUtil;
import com.sbs.java.jdbc.board.dbUtil.SecSql;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ArticleController {
  private final ArticleService articleService;
  public Scanner sc;

  public  ArticleController() {
    articleService = Container.articleService;
    sc = Container.sc;
  }

  public void doWrite() {
    System.out.println("== 게시물 작성 ==");

    System.out.print("제목 : ");
    String subject = sc.nextLine();

    if(subject.trim().isEmpty()) {
      System.out.println("제목을 입력해주세요.");
      return;
    }

    System.out.print("내용 : ");
    String content = sc.nextLine();

    if(content.trim().isEmpty()) {
      System.out.println("내용을 입력해주세요.");
      return;
    }

    int id = articleService.write(subject, content);

    System.out.printf("%d번 게시물이 생성되었습니다.\n", id);
  }

  public void showList() {

    List<Article> articleList = articleService.getArticles();

    if(articleList == null) {
      System.out.println("게시물이 존재하지 않습니다.");
      return;
    }

    System.out.println("== 게시물 리스트 ==");
    System.out.println("번호  |  제목");

    articleList.forEach(article ->
        System.out.printf("%d | %s\n", article.getId(), article.getSubject()));
  }

  public void showDetail(Rq rq) {
    int id = rq.getIntParam("id", 0);

    if (id == 0) {
      System.out.println("id를 올바르게 입력해주세요.");
    }

    Article article = articleService.findById(id);

    if(article == null) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    System.out.printf("== %d번 게시물 상세보기 ==\n", id);
    System.out.printf("번호 : %d\n",article.getId());
    System.out.printf("작성날짜 : %s\n", article.getRegDate());
    System.out.printf("수정날짜 : %s\n",article.getUpdateDate());
    System.out.printf("제목 : %s\n", article.getSubject());
    System.out.printf("내용 : %s\n", article.getContent());
  }

  public void doModify(Rq rq) {

    int id = rq.getIntParam("id", 0);
    if (id == 0) {
      System.out.println("id를 올바르게 입력해주세요.");

    }

    Article article = articleService.findById(id);

    if(article == null) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    System.out.println("== 게시물 수정 ==");
    System.out.print("제목 : ");
    String subject = sc.nextLine();

    if(subject.trim().isEmpty()) {
      System.out.println("제목을 입력해주세요.");
      return;
    }

    System.out.print("내용 : ");
    String content = sc.nextLine();

    if(content.trim().isEmpty()) {
      System.out.println("내용을 입력해주세요.");
      return;
    }

    articleService.update(id, subject, content);

    System.out.printf("%d번 게시물이 수정되었습니다.\n", id);
  }

  public void doDelete(Rq rq) {
    int id = rq.getIntParam("id", 0);
    if (id == 0) {
      System.out.println("id를 올바르게 입력해주세요.");

    }

    Article article = articleService.findById(id);

    if(article == null) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    articleService.delete(id);

    System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);
  }

}
