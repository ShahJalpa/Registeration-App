/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maya.signIn;

import Maya.business.MayaUser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Maya.data.MayaUserDB;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jalpa
 */
@WebServlet(name = "SignInServlet", urlPatterns = {"/SignInServlet"})
public class SignInServlet extends HttpServlet
{   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        System.out.println("Entering Post Method");
        String url = "/signIn.jsp";
        String action = request.getParameter("action");
      
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        
       String User = getServletConfig().getInitParameter("userName");
       String pass = getServletConfig().getInitParameter("passWord");
        
       log("User=" + userName + "::pass=" + passWord);
        
        //if(User.equals(userName)&& pass.equals(passWord))
            
        if (MayaUserDB.validate(userName, passWord))
        {
            System.out.println("Inside validate Method");
            url = "/lessons.jsp";
        }
        
        else
        {
            System.out.println("Inside else to go for sigin jsp");
            url = "/signIn.jsp";
            
            String message;
            message = "Either user name or password is wrong.";
        }
        
        
         getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        
        /*HttpSession session = request.getSession(false);
        
        if (session != null)
        {
            session.setAttribute ("userName", userName);
        }
        
        if (MayaUserDB.validate(userName, passWord))
        {
            url = "/lessons.jsp";
        }
        
        else
        {
            String message = "Either user name or password is wrong.";
            url = "/singIn.jsp";
        }*/
        
         
         /*getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);*/                                        
    }
}
