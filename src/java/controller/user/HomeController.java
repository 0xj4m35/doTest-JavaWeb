/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import controller.AuthenticationBaseController;
import dal.AdminDAO;
import dal.MemberDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DoQuiz;
import model.Quiz;
import model.User;

/**
 *
 * @author Nguyen Thai Bao
 */
public class HomeController extends AuthenticationBaseController {

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccessReq(req, resp);
    }

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccessReq(req, resp);
    }
    
    protected void proccessReq(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        if (user.getRole().equalsIgnoreCase("administrator")) {
            List<Quiz> quizzes = new AdminDAO().getAllQuiz();
            req.setAttribute("quizzes", quizzes);
            req.getRequestDispatcher("adminHome.jsp").forward(req, resp);
        } else {
            List<DoQuiz> quizzes = new MemberDAO().getDoneQuiz(user.getUsername());
            req.setAttribute("quizzes", quizzes);
            req.getRequestDispatcher("memberHome.jsp").forward(req, resp);
        }
    }
    
}
