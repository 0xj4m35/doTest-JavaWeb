/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.auth;

import controller.BaseController;
import dal.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Nguyen Thai Bao
 */
public class AuthenticationController extends BaseController {

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        if (username == null || password == null || "".equalsIgnoreCase(username) || "".equals(password)) {
            req.setAttribute("fault", "incorrect");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            User user = new UserDAO().getUser(username);
            if (user == null) {
                req.setAttribute("fault", "user not found");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            } else {
                if (password.equals(user.getPassword())) {
                    req.getSession().setAttribute("user", user);
                    resp.sendRedirect("home");
                } else {
                    req.setAttribute("fault", "incorrect");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            }
        }
    }
}
