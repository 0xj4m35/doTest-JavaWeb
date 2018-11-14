/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import controller.AuthenticationBaseController;
import controller.BaseController;
import dal.AdminDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Question;
import model.User;

/**
 *
 * @author Nguyen Thai Bao
 */
public class ListAllQuestionController extends AuthenticationBaseController {

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processReq(req, resp);
    }

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processReq(req, resp);
    }
    
    public void processReq(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user.getRole().equalsIgnoreCase("administrator")) {
            List<Question> questions = new AdminDAO().getAllQuestion();
            req.setAttribute("questions", questions);
            req.getRequestDispatcher("listQuestion.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("home");
        }
    }
}
