/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Nguyen Thai Bao
 */
public abstract class AuthenticationBaseController extends BaseController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!isAuthenticated(req)) {
            resp.sendRedirect("login");
        } else {
            super.doGet(req, resp); 
        }       
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!isAuthenticated(req)) {
            resp.sendRedirect("login");
        } else {
            super.doPost(req, resp); 
        } 
    }
    
    private boolean isAuthenticated(HttpServletRequest req)
    {
        User user = (User) req.getSession().getAttribute("user");
        if( user != null )
            return true;
        else
            return false;
    }
}
