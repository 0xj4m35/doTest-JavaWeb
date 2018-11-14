/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import controller.AuthenticationBaseController;
import dal.AdminDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Question;
import model.Subject;
import model.User;

/**
 *
 * @author Nguyen Thai Bao
 */
public class MakeQuizController extends AuthenticationBaseController {

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user.getRole().equalsIgnoreCase("administrator")) {
            List<Subject> subs = new AdminDAO().getAllSubject();
            int maxId = new AdminDAO().getMaxQuizId();
            int newQuizId = maxId + 1; 
            req.setAttribute("newQuizId", newQuizId);
            req.setAttribute("subs", subs);
            req.getRequestDispatcher("makeQuiz.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("home");
        }
    }

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int subId = Integer.parseInt(req.getParameter("subject"));
        int totalQues = Integer.parseInt(req.getParameter("totalQues"));
        String title = req.getParameter("title");
        int quizId = new AdminDAO().getMaxQuizId() + 1;
        
        // new Quiz
        User user = (User) req.getSession().getAttribute("user");
        java.util.Date currTime = new java.util.Date();
        java.sql.Date dcr = new java.sql.Date(currTime.getTime());
        new AdminDAO().addQuiz(title, totalQues, user.getUsername(), dcr);
        
        // Add Questions
        List<Question> allQues = new AdminDAO().getAllQuestionBySubjectID(subId);
        List<Question> randQues = new ArrayList<>();
        Random rand = new Random();
        while ( totalQues > 0 ) {
            int rIndex = rand.nextInt(allQues.size() - 1) + 0;
            Question ques = allQues.get(rIndex);
            randQues.add(ques);
            allQues.remove(rIndex);
            totalQues--;
        }
        for (Question ques : randQues) {
            new AdminDAO().addQuestionToQuiz(ques.getQuesId(), quizId);
        }
        resp.sendRedirect("home");
    }
    
}
