package io.toya.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Higgs on 2017/3/11.
 */
public interface Controller {

    String handleRequest(HttpServletRequest request, HttpServletResponse response);

}
