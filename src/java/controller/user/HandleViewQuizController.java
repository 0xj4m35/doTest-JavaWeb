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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DoQuiz;
import model.Question;
import model.Quiz;
import model.User;

/**
 *
 * @author Nguyen Thai Bao
 */
public class HandleViewQuizController extends AuthenticationBaseController {
    
    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int quizId = Integer.parseInt(req.getParameter("quizId"));
        User user = (User) req.getSession().getAttribute("user");
        if (user.getRole().equalsIgnoreCase("administrator")) {
            List<DoQuiz> mems = new AdminDAO().getAllMemberDidQuiz(quizId);
            Quiz quiz = new MemberDAO().getQuiz(quizId);
            req.setAttribute("mems", mems);
            req.setAttribute("quiz", quiz);
            req.getRequestDispatcher("memDoQuiz.jsp").forward(req, resp);
        } else {
            if (new MemberDAO().isDidQuiz(user.getUsername(), quizId)) {
                resp.sendRedirect("home");
            } else {
                List<Question> questions = new MemberDAO().getQuestionsInQuiz(quizId);
                req.getSession().setAttribute("quizId", quizId);
                for (Question ques : questions) {
                    List<String> data = new ArrayList<>();
                    data.add(ques.getCorrectAnswer());
                    data.add(ques.getIncorrectAnswer1());
                    data.add(ques.getIncorrectAnswer2());
                    data.add(ques.getIncorrectAnswer3());
                    Collections.shuffle(data);
                    ques.setCorrectAnswer(data.get(0));
                    ques.setIncorrectAnswer1(data.get(1));
                    ques.setIncorrectAnswer2(data.get(2));
                    ques.setIncorrectAnswer3(data.get(3));
                }
                Quiz quiz = new MemberDAO().getQuiz(quizId);
                req.setAttribute("quiz", quiz);
                req.setAttribute("questions", questions);
                req.getRequestDispatcher("doQuiz.jsp").forward(req, resp);
            }
        }
        
    }

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int corr = 0;
        int incorr = 0;
        User user = (User) req.getSession().getAttribute("user");
        int quizId = (int) req.getSession().getAttribute("quizId");
        List<Question> questions = new MemberDAO().getQuestionsInQuiz(quizId);
        for (Question ques : questions) {
            String userChoose = req.getParameter("ques-" + ques.getQuesId());
            if (userChoose == null) {
                userChoose = "";
            } else {
                userChoose = userChoose.trim();
            }
            String rightAns = ques.getCorrectAnswer().trim();
            if (rightAns.equalsIgnoreCase(userChoose)) {
                corr++;
            } else {
                incorr++;
            }
        }
        java.sql.Date ddq = new java.sql.Date(new java.util.Date().getTime());
        new MemberDAO().doneQuiz(user.getUsername(), quizId, corr, incorr, ddq);
        resp.sendRedirect("home");
    }
    
}
