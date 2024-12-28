package com.sbs.java.jdbc.board.container;

import com.sbs.java.jdbc.board.article.ArticleController;
import com.sbs.java.jdbc.board.article.ArticleRepository;
import com.sbs.java.jdbc.board.article.ArticleService;
import com.sbs.java.jdbc.board.member.MemberController;

import java.util.Scanner;

public class Container {
  public static Scanner sc;

  public static ArticleRepository articleRepository;

  public static ArticleService articleService;

  public static MemberController memberController;

  public static ArticleController articleController;

  static {
    sc = new Scanner(System.in);
    articleRepository = new ArticleRepository();
    articleService = new ArticleService();
    memberController = new MemberController();
    articleController = new ArticleController();
  }
}
