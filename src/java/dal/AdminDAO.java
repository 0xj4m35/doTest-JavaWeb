/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DoQuiz;
import model.Question;
import model.Quiz;
import model.Subject;
import model.User;

/**
 *
 * @author Nguyen Thai Bao
 */
public class AdminDAO extends BaseDAO {
    
    public List<Subject> getAllSubject() {
        List<Subject> subjects = new ArrayList<>();
        try {
            String query = "SELECT subject_id, subject_name "
                    + "FROM Subjects";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("subject_id");
                String name = rs.getString("subject_name");
                subjects.add(new Subject(id, name));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return subjects;
    }
    
    public void addQuestion(int subjectId, String question, String rightAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3) {
        try {
            String query = "INSERT INTO Questions(subject_id, question, right_answer, wrong_answer1, wrong_answer2, wrong_answer3) "
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, subjectId);
            ps.setString(2, question);
            ps.setString(3, rightAnswer);
            ps.setString(4, wrongAnswer1);
            ps.setString(5, wrongAnswer2);
            ps.setString(6, wrongAnswer3);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public List<Quiz> getAllQuiz() {
        List<Quiz> quizzes = new ArrayList<>();
        try {
            String query = "SELECT quiz_id, title, number_question, author, day_created "
                    + "FROM Quizzes "
                    + "ORDER BY day_created DESC";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("quiz_id");
                String title = rs.getString("title");
                int num = rs.getInt("number_question");
                String author = rs.getString("author");
                java.sql.Date dc = rs.getDate("day_created");
                java.util.Date day_cre = new java.util.Date(dc.getTime());
                quizzes.add(new Quiz(id, title, num, author, day_cre));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return quizzes;
    }
    
    public List<DoQuiz> getAllMemberDidQuiz(int quizId) {
        List<DoQuiz> mems = new ArrayList<>();
        try {
            String query = "SELECT username, quiz_id, correct, incorrect, day_do_quiz "
                    + "FROM DoQuiz "
                    + "WHERE quiz_id = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, quizId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String username = rs.getString(1);
                int quizIdx = rs.getInt(2);
                int corr = rs.getInt(3);
                int incorr = rs.getInt(4);
                java.sql.Date ddq = rs.getDate(5);
                java.util.Date daydq = new java.util.Date(ddq.getTime());
                DoQuiz doQuiz = new DoQuiz();
                doQuiz.setCorrect(corr);
                doQuiz.setIncorrect(incorr);
                doQuiz.setUsername(username);
                doQuiz.setQuizId(quizIdx);
                doQuiz.setDayDoQuiz(daydq);
                doQuiz.setUser(new UserDAO().getUser(username));
                mems.add(doQuiz);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return mems;
    }
    
    public List<Question> getAllQuestion() {
        List<Question> questions = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM Questions";
            PreparedStatement ps =connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int qid = rs.getInt("ques_id");
                int sid = rs.getInt("subject_id");
                String ques = rs.getString("question");
                String rans = rs.getString("right_answer");
                String wans1 = rs.getString("wrong_answer1");
                String wans2 = rs.getString("wrong_answer2");
                String wans3 = rs.getString("wrong_answer3");
                questions.add(new Question(qid, sid, ques, rans, wans1, wans2, wans3));
            }
        } catch ( Exception e) {
            System.out.println(e);
        }
        
        return questions;
        
    }
    
    public int getMaxQuizId() {
        int maxId = -1;
        try {
            String query = "Select MAX(quiz_id) as [quiz_id]\n" +
                            "FROM Quizzes";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                maxId = rs.getInt("quiz_id");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return maxId;
    }
    
    public List<Question> getAllQuestionBySubjectID(int subId) {
        List<Question> allQ = new ArrayList<>();
        try {
            String query = "Select * FROM Questions where subject_id = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, subId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int qid = rs.getInt("ques_id");
                int sid = rs.getInt("subject_id");
                String ques = rs.getString("question");
                String rans = rs.getString("right_answer");
                String wans1 = rs.getString("wrong_answer1");
                String wans2 = rs.getString("wrong_answer2");
                String wans3 = rs.getString("wrong_answer3");
                allQ.add(new Question(qid, sid, ques, rans, wans1, wans2, wans3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return allQ;
    }
    
    public void addQuestionToQuiz(int quesId, int quizId) {
        try {
            String query = "INSERT INTO QuizQuestion(ques_id, quiz_id) VALUES(?,?) ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, quesId);
            ps.setInt(2, quizId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void addQuiz(String title, int numQues, String author, java.sql.Date dcr) {
        try {
            String query = "INSERT INTO Quizzes(title, number_question, author, day_created) "
                    + "VALUES(?,?,?,?) ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, title);
            ps.setInt(2, numQues);
            ps.setString(3, author);
            ps.setDate(4, dcr);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
