
package controllers;

import Encryption.Encryption;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import model.loginUser;

/**
 *
 * @author Thomas Jefferson Qiu, Ezekiel Giron
 */

@WebServlet("/Login")
public class loginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");   
        String role = request.getParameter("role");    
        String depassword = request.getParameter("password");
                
   
        loginUser user = new loginUser();
        
        //Encryption
        password = Encryption.encrypt(password);
        //Decryption
        depassword = Encryption.decrypt(password);
        
        try {
            if(user.check(username, password, role) && role.equals("Admin"))
            {
                
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                session.setAttribute("depassword", depassword);
                response.sendRedirect("*");
                
                
            }
            else if(user.check(username, password, role) && role.equals("SS"))
            {
                
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                session.setAttribute("depassword", depassword);
                response.sendRedirect("*");
                       
            }
            else
            {
                RequestDispatcher rd = getServletContext().getRequestDispatcher(
                        "/Login.html");
                PrintWriter out = response.getWriter();
                
                out.println("<font color=red>wrong username/password</font>");
                
                rd.include(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}