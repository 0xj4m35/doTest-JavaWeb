/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dal.UserDAO;
import java.util.Date;

/**
 *
 * @author Nguyen Thai Bao
 */
public class Quiz extends BaseModel {
    private int quizID;
    private String title;
    private int quesNum;
    private String author;
    private Date dayCreated; 

    
    public Quiz() {
    }

    public Quiz(int quizID, String title, int quesNum, String author, Date dayCreated) {
        this.quizID = quizID;
        this.title = title;
        this.quesNum = quesNum;
        this.author = author;
        this.dayCreated = dayCreated;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuesNum() {
        return quesNum;
    }

    public void setQuesNum(int quesNum) {
        this.quesNum = quesNum;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDayCreated() {
        return dayCreated;
    }

    public void setDayCreated(Date dayCreated) {
        this.dayCreated = dayCreated;
    }
    
        
    private String fullNameOfAuthor;
    
    public String getFullNameOfAuthor() {
        User user =  new UserDAO().getUser(this.author);
        return user.getFullname();
    }
   
}
