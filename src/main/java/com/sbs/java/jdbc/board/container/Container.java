package com.sbs.java.jdbc.board.container;

import com.sbs.java.jdbc.board.article.ArticleController;
import com.sbs.java.jdbc.board.article.ArticleService;

import java.util.Scanner;

public class Container {
  public static Scanner sc;

  public static ArticleService articleService;

  public static ArticleController articleController;

  static {
    sc = new Scanner(System.in);
    articleService = new ArticleService();
    articleController = new ArticleController();
  }
}
