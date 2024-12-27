package com.sbs.java.jdbc.board;

import com.sbs.java.jdbc.board.article.Article;
import com.sbs.java.jdbc.board.article.ArticleController;
import com.sbs.java.jdbc.board.container.Container;
import com.sbs.java.jdbc.board.dbUtil.MysqlUtil;
import com.sbs.java.jdbc.board.dbUtil.SecSql;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

  public ArticleController articleController;

  public App() {

    articleController = Container.articleController;
  }

  private static boolean isDevMode() {
    // 이 부분을 false로 바꾸면 production 몯드 이다.
    // true는 개발자 모드이다.(개발할 때 좋다.)
    return true;
  }

  // 로직의 시작점
  public void run(){
    Scanner sc = new Scanner(System.in);

    System.out.println("== 자바 텍스트 게시판 시작 ==");

    try {
      while(true) {
        System.out.print("명령) ");
        String cmd = sc.nextLine();

        Rq rq = new Rq(cmd);

        // DB 세팅
        MysqlUtil.setDBInfo("mariadb.mypc.myvbox", "root", "mariadb", "text_board");
        MysqlUtil.setDevMode(isDevMode());
        // DB 세팅 끝

        // 액션 메서드 시작
        doAction(rq);
      }
    } finally {
      System.out.println("== 자바 텍스트 게시판 종료 ==");
      sc.close();
    }

  }

  private void doAction(Rq rq) {
    if(rq.getUrlPath().equals("/usr/article/write")) {
      articleController.doWrite();
    } else if(rq.getUrlPath().equals("/usr/article/list")) {
      articleController.showList();
    } else if(rq.getUrlPath().equals("/usr/article/detail")) {
      articleController.showDetail(rq);
    } else if(rq.getUrlPath().equals("/usr/article/modify")) {
      articleController.doModify(rq);
    } else if(rq.getUrlPath().equals("/usr/article/delete")) {
      articleController.doDelete(rq);
    } else if(rq.getUrlPath().equals("exit")) {
      System.out.println("프로그램을 종료 합니다.");
      System.exit(0);  // 프로그램 강제종료
    } else {
      System.out.println("잘못된 명령어입니다.");
    }
  }
}
