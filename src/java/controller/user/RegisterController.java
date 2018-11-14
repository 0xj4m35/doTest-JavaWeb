/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

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
public class RegisterController extends BaseController {

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        req.setAttribute("username", username);
        req.setAttribute("fullName", fullName);
        User user = new UserDAO().getUser(username);
        if ("".equals(user) || "".equals(password)) {
            req.setAttribute("fault", "blank input");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        } else {
            if (user == null) {
                if ((password != null) && password.equals(repassword)) {
                    new UserDAO().registerUser(username, password, fullName, "member");
                    resp.sendRedirect("login");
                } else {
                    req.setAttribute("fault", "password invalid");
                    req.getRequestDispatcher("register.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("fault", "user existed");
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            }
        }
        
    }
    
}
