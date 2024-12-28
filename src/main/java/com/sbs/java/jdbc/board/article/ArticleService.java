package com.sbs.java.jdbc.board.article;

import com.sbs.java.jdbc.board.container.Container;
import com.sbs.java.jdbc.board.dbUtil.MysqlUtil;
import com.sbs.java.jdbc.board.dbUtil.SecSql;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleService {
  private final ArticleRepository articleRepository;

  public ArticleService() {
    articleRepository = Container.articleRepository;
  }
  public int write(String subject, String content) {
    return articleRepository.write(subject, content);
  }

  public List<Article> getArticles() {
    return articleRepository.getArticles();
  }

  public Article findById(int id) {
    return articleRepository.findById(id);
  }

  public void update(int id, String subject, String content) {
    articleRepository.update(id, subject, content);
  }

  public void delete(int id) {
    articleRepository.delete(id);
  }
}
