/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maya.registeration;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Maya.business.MayaUser;
import Maya.data.MayaUserDB;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jalpa
 */
@WebServlet(name = "RegisterationServlet", urlPatterns = {"/RegisterationServlet"})
public class RegisterationServlet extends HttpServlet 
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
        String url = "/register.jsp";
        String action = request.getParameter("action");
        
        if(action == null)
        {
            action = "submit";
        }
        
        if(action.equals("submit"))
        {
            url = "/register.jsp";
        }
        
        else if(action.equals("add"))
        {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");  
            String userName = request.getParameter ("userName");
            String passWord = request.getParameter("passWord");
            
            
            MayaUser user = new MayaUser(firstName, lastName, email, userName, passWord);
           
            String message;
            if (MayaUserDB.emailExists(user.getEmail()))
            {
                message = "This email address is already exist.<br>"
                         + "Try different email address.";
                url = "/register.jsp";
            }
            
            else
            {
                message = "";
                url = "/thankYou.jsp";
                MayaUserDB.insert(user);
            }
            request.setAttribute("user", user);
            request.setAttribute("message", message);
        }
        
         getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    
}
