/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Nguyen Thai Bao
 */
public class DoQuiz extends BaseModel {
    private String username;
    private int quizId;
    private int correct;
    private int incorrect;
    private Date dayDoQuiz;
    private Quiz quiz;
    private User user;
    
    public DoQuiz() {
    }

    public DoQuiz(String username, int quizId, int correct, int incorrect, Date dayDoQuiz,Quiz quiz) {
        this.username = username;
        this.quizId = quizId;
        this.correct = correct;
        this.incorrect = incorrect;
        this.dayDoQuiz = dayDoQuiz;
        this.quiz = quiz;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Date getDayDoQuiz() {
        return dayDoQuiz;
    }

    public void setDayDoQuiz(Date dayDoQuiz) {
        this.dayDoQuiz = dayDoQuiz;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
}
