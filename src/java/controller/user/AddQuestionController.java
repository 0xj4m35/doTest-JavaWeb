/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import controller.AuthenticationBaseController;
import dal.AdminDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Subject;
import model.User;

/**
 *
 * @author Nguyen Thai Bao
 */
public class AddQuestionController extends AuthenticationBaseController {

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user.getRole().equalsIgnoreCase("administrator")) {
            List<Subject> subs = new AdminDAO().getAllSubject();
            req.setAttribute("subs", subs);
            req.getRequestDispatcher("addQuestion.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("home");
        }
        
    }

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int subId = Integer.parseInt(req.getParameter("subjectId"));
        String ques = req.getParameter("question");
        String corr = req.getParameter("corr");
        String incorr1 = req.getParameter("incorr1");
        String incorr2 = req.getParameter("incorr2");
        String incorr3 = req.getParameter("incorr3");
        new AdminDAO().addQuestion(subId, ques, corr, incorr1, incorr2, incorr3);
        resp.sendRedirect("list");
    }
    
}
