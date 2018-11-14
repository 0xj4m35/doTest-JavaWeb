/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.DoQuiz;
import model.Question;
import model.Quiz;

/**
 *
 * @author Nguyen Thai Bao
 */
public class MemberDAO extends BaseDAO {
    
    public List<DoQuiz> getDoneQuiz(String username) {
        List<DoQuiz> quizzes = new ArrayList<>();
        try {
            String query = "SELECT username, quiz_id, correct, incorrect, day_do_quiz "
                    + "FROM DoQuiz "
                    + "WHERE username = ? "
                    + "ORDER BY day_do_quiz DESC";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String uname = rs.getString("username");
                int quizId = rs.getInt("quiz_id");
                int corr = rs.getInt("correct");
                int incorr = rs.getInt("incorrect");
                java.sql.Date ddqSql = rs.getDate("day_do_quiz");
                Date ddq = new Date(ddqSql.getTime());
                Quiz quiz = getQuiz(quizId);
                quizzes.add(new DoQuiz(username, quizId, corr, incorr, ddq, quiz));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return quizzes;
    } 
    
    
    public Quiz getQuiz(int quizId) {
        Quiz quiz = null;
        try {
            String query = "SELECT quiz_id, title, number_question, author, day_created "
                    + "FROM Quizzes "
                    + "WHERE quiz_id = ? ";
            
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, quizId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int quiz_id = rs.getInt("quiz_id");
                String title = rs.getString("title");
                int number = rs.getInt("number_question");
                String author = rs.getString("author");
                java.sql.Date dcSql = rs.getDate("day_created");
                Date dayDoQuiz = new Date(dcSql.getTime());
                quiz = new Quiz(quizId, title, quiz_id, author, dayDoQuiz);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return quiz;
    }
    
    public boolean isDidQuiz(String username, int quizId) {
        boolean res = false;
        try {
            String query = "SELECT * FROM DoQuiz WHERE username = ? and quiz_id = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setInt(2, quizId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }
    
    public List<Question> getQuestionsInQuiz(int quizId) {
        List<Question> questions = new ArrayList<>();
        try {
            String query = "SELECT Q.ques_id, subject_id, question, right_answer, wrong_answer1, wrong_answer2, wrong_answer3 "
                    + "FROM Questions Q, QuizQuestion QQ "
                    + "WHERE Q.ques_id = QQ.ques_id and quiz_id = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, quizId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int ques_id = rs.getInt(1);
                int subj = rs.getInt(2);
                String ques = rs.getString(3);
                String right = rs.getString(4);
                String wrong1 = rs.getString(5);
                String wrong2 = rs.getString(6);
                String wrong3 = rs.getString(7);
                questions.add(new Question(ques_id, subj, ques, right, wrong1, wrong2, wrong3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return questions;
    }
    
    public void doneQuiz(String username, int quizId, int corr, int incorr, java.sql.Date ddq) {
        try {
            String query = "INSERT INTO DoQuiz(username, quiz_id, correct, incorrect, day_do_quiz) "
                    + "VALUES(?,?,?,?,?) ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setInt(2, quizId);
            ps.setInt(3, corr);
            ps.setInt(4, incorr);
            ps.setDate(5, ddq);
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
