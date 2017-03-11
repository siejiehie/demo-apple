package io.toya.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Higgs on 2017/3/11.
 */
public class InputProductController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return "/WEB-INF/classes/views/productForm.jsp";
    }

}
