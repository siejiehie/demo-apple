package io.toya.servlet;

import io.toya.controller.InputProductController;
import io.toya.controller.SaveProductController;
import io.toya.domain.Product;
import io.toya.form.ProductForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Higgs on 2017/3/11.
 */
@WebServlet(name = "DispatcherServlet", urlPatterns = {"/product_input.action", "/product_save.action"})
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);

        String dispatcherUrl = null;
        if (action.equals("product_input.action")) {
            InputProductController controller = new InputProductController();
            dispatcherUrl = controller.handleRequest(request, response);
        } else if (action.equals("product_save.action")) {
            SaveProductController controller = new SaveProductController();
            dispatcherUrl = controller.handleRequest(request, response);
        }

        if (dispatcherUrl != null) {
            request.getRequestDispatcher(dispatcherUrl).forward(request, response);
        }
    }

}
