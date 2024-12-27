package com.sbs.java.jdbc.board.container;

import com.sbs.java.jdbc.board.article.ArticleController;

import java.util.Scanner;

public class Container {
  public static Scanner sc;

  public static ArticleController articleController;

  static {
    sc = new Scanner(System.in);
    articleController = new ArticleController();
  }
}
