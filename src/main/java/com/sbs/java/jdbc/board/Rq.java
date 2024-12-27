package com.sbs.java.jdbc.board;

import com.sbs.java.jdbc.board.util.Util;
import lombok.Getter;

import java.lang.reflect.Member;
import java.util.Map;

public class Rq {
  public String url;
  @Getter
  public Map<String, String> params;
  //@Getter   //lombok을 사용하면 컴팡일 에러가 나서 아래 getUrlPath 별도로 생섣
  public String urlPath;


  public String getUrlPath() {
    return urlPath;
  }

  public Rq(String url) {
    this.url = url;
    params = Util.getParamsFromUrl(this.url);
    urlPath = Util.getPathFromUrl(this.url);
  }

  public int getIntParam(String paramName, int defaultValue) {
    if(!params.containsKey(paramName)) {
      return defaultValue;
    }

    try {
      return Integer.parseInt(params.get(paramName));
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  public String getParam(String paramName, String defaultValue) {
    if(!params.containsKey(paramName)) {
      return defaultValue;
    }

    return params.get(paramName);
  }

}