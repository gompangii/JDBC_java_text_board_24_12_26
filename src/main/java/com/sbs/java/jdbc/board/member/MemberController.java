package com.sbs.java.jdbc.board.member;

import com.sbs.java.jdbc.board.Rq;
import com.sbs.java.jdbc.board.container.Container;
import com.sbs.java.jdbc.board.dbUtil.MysqlUtil;
import com.sbs.java.jdbc.board.dbUtil.SecSql;

import java.util.Scanner;

public class MemberController {
  public Scanner sc;
  private final MemberService memberService;

  public MemberController() {
    sc = Container.sc;
    memberService = Container.memberService;
  }
  public void doJoin(Rq rq) {
    String username;
    String password;
    String passwordConfirm;
    String name;
    Member member;

    // 아이디 입력
    while (true) {
      System.out.print("로그인 아이디 : ");
      username = sc.nextLine();

      if(username.trim().isEmpty()) {
        System.out.println("로그인 아이디를 입력해주세요.");
        continue;
      }
      member = memberService.findByUsername(username);
      if(member != null) {
        System.out.printf("\"%s\" 회원은 존재합니다.\n", username);
      }
      break;
    }

    // 비밀번호 입력
    while (true) {
      System.out.print("로그인 비밀번호 : ");
      password = sc.nextLine();

      if(password.trim().isEmpty()) {
        System.out.println("로그인 비밀번호를 입력해주세요.");
        continue;
      }
      while (true) {
        System.out.print("로그인 비밀번호 확인 : ");
        passwordConfirm = sc.nextLine();

        if(passwordConfirm.trim().isEmpty()) {
          System.out.println("로그인 비밀번호 확인을 입력해주세요.");
          continue;
        }
        if(!passwordConfirm.equals(password)) {
          System.out.println("비밀번호가 일치하지 않습니다.");
          continue;
        }
        break;
      }

      break;
    }

    // 이름 입력
    while (true) {
      System.out.print("이름 : ");
      name = sc.nextLine();

      if(name.trim().isEmpty()) {
        System.out.println("이름을 입력해주세요.");
        continue;
      }
      break;
    }

    memberService.join(username, password, name);

    System.out.printf("\"%s\"님 회원가입이 완료되었습니다.\n", username);
  }
}
