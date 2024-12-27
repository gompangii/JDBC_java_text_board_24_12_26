package com.sbs.java.jdbc.board;

import com.sbs.java.jdbc.board.article.Article;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
  public int articleLastId;
  public List<Article> articleList;

  // JDBC URL, 사용자명, 비밀번호를 설정합니다.
  private  static  final String DB_URL = "jdbc:mysql://mariadb.mypc.myvbox:3306/text_board";
  private  static  final String DB_USER = "root"; // MariaDB 사용자 이름
  private  static  final String DB_PASSWORD = "mariadb"; // MariaDB 비밀번호

  public App() {
    articleLastId = 0;
    articleList = new ArrayList<>();

  }

  // 로직의 시작점
  public void run(){
    Scanner sc = new Scanner(System.in);
    int articleLastId = 0;

    System.out.println("== 자바 텍스트 게시판 시작 ==");


    while(true) {
      System.out.print("명령) ");
      String cmd = sc.nextLine();

      if(cmd.equals("/usr/article/write")) {
        System.out.println("== 게시물 작성 ==");

        System.out.print("제목 : ");
        String subject = sc.nextLine();

        System.out.print("내용 : ");
        String content = sc.nextLine();

        int id = ++articleLastId;

        Article article = new Article(id, subject, content);
        articleList.add(article);

        Connection conn = null;
        PreparedStatement pstat = null;

        try {
          // JDBC 드라이버 로드
          Class.forName("com.mysql.cj.jdbc.Driver");

          conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

          System.out.println("데이터 베이스 연결 성공!");

          String sql = "INSERT INTO article " ;
            sql += "SET regDate = NOW()";
            sql += ", updateDate = NOW()";
            sql += ", `subject` = '%s'".formatted(subject);
            sql += ", content = '%s';".formatted(content);

          System.out.println(sql);

          pstat = conn.prepareStatement(sql);
          // 쿼리 실행
          int affectedRow = pstat.executeUpdate();
          System.out.println("데이터 삽일 성공! 삽입된 행 수: " + affectedRow);

          System.out.printf("%d번 게시물이 생성되었습니다.\n", article.getId());

        } catch (ClassNotFoundException e) {
          System.err.println("JDBC 드라이버를 찾지 못했습니다.");
          e.printStackTrace();
        } catch (SQLException e) {
          System.out.println("데이터 베이스 연결 실패");
          e.printStackTrace();
        } finally {
          try {
            if(pstat != null && !pstat.isClosed()) pstat.close();
            if(conn != null && !conn.isClosed()) {
              conn.close();  // 데이터 베이스 연결 해제
              System.out.println("데이터베이스 연결이 해제되었습니다.");
            }
          } catch (SQLException e) {
            e.printStackTrace();
          }
        }


      }
      else if(cmd.equals("/usr/article/list")) {
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;

        try {
          // JDBC 드라이버 로드
          Class.forName("com.mysql.cj.jdbc.Driver");

          conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

          System.out.println("데이터 베이스 연결 성공!");

          String sql = "SELECT *" ;
          sql += " FROM article";
          sql += " ORDER BY id DESC;";

          pstat = conn.prepareStatement(sql);

          rs = pstat.executeQuery();

          while (rs.next()) {
            int id = rs.getInt("id");
            LocalDateTime regDate = rs.getTimestamp("regDate").toLocalDateTime();
            LocalDateTime updateDate = rs.getTimestamp("updateDate").toLocalDateTime();
            String subject = rs.getString("subject");
            String content = rs.getString("content");

            Article article = new Article(id, regDate, updateDate, subject, content);
            articleList.add(article);
          }
        } catch (ClassNotFoundException e) {
          System.err.println("JDBC 드라이버를 찾지 못했습니다.");
          e.printStackTrace();
        } catch (SQLException e) {
          System.out.println("데이터 베이스 연결 실패");
          e.printStackTrace();
        } finally {
          try {
            if(rs != null && !rs.isClosed()) rs.close();
            if(pstat != null && !pstat.isClosed()) pstat.close();
            if(conn != null && !conn.isClosed()) {
              conn.close();  // 데이터 베이스 연결 해제
              System.out.println("데이터베이스 연결이 해제되었습니다.");
            }
          } catch (SQLException e) {
            e.printStackTrace();
          }
        }

        System.out.println("== 게시물 리스트 ==");
        System.out.println("번호  |  제목");

        articleList.forEach(article ->
            System.out.printf("%d | %s\n", article.getId(), article.getSubject()));

      }
      else if(cmd.equals("break")) {
        System.out.println("프로그램을 종료 합니다.");
        break;
      }
      else {
        System.out.println("잘못된 명령어입니다.");
      }
    }

    System.out.println("== 자바 텍스트 게시판 종료 ==");
    sc.close();

  }
}
