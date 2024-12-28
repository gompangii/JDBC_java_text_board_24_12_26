package com.sbs.java.jdbc.board.container;

import com.sbs.java.jdbc.board.article.ArticleController;
import com.sbs.java.jdbc.board.article.ArticleRepository;
import com.sbs.java.jdbc.board.article.ArticleService;
import com.sbs.java.jdbc.board.member.MemberController;
import com.sbs.java.jdbc.board.member.MemberRepository;
import com.sbs.java.jdbc.board.member.MemberService;

import java.util.Scanner;

public class Container {
  public static Scanner sc;

  public static MemberRepository memberRepository;
  public static ArticleRepository articleRepository;

  public static MemberService memberService;
  public static ArticleService articleService;

  public static MemberController memberController;

  public static ArticleController articleController;

  static {
    sc = new Scanner(System.in);

    memberRepository = new MemberRepository();
    articleRepository = new ArticleRepository();

    memberService = new MemberService();
    articleService = new ArticleService();

    memberController = new MemberController();
    articleController = new ArticleController();
  }
}
