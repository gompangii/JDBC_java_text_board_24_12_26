package com.sbs.java.jdbc.board.member;

import com.sbs.java.jdbc.board.container.Container;

public class MemberService {
  private final MemberRepository memberRepository;

  public MemberService() {
    memberRepository = Container.memberRepository;
  }
  public void join(String username, String password, String name) {
    memberRepository.join(username, password, name);
  }
}
