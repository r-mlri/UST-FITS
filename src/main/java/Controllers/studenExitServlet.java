/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.studentLog;
import model.studentexitlog;

/**
 *
 * @author Thomas Jefferson Qiu
 */
@WebServlet(name = "studenExit.jsp", urlPatterns = {"/studenExit"})
public class studenExitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
        private studentexitlog insert;
        
        public void init() {
        insert = new studentexitlog();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
            String SN = request.getParameter("SN");
            
            if(SN != null)
            {   
                response.sendRedirect("Index.jsp");                             
            }
            else 
                {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/StudentExit.jsp");
			PrintWriter out = response.getWriter();
			if (SN == null) 
                        {
				response.sendRedirect("Index.jsp");
			}
			rd.include(request, response);
                }
                        studentLog student = new studentLog();
                        student.setSN(SN);
                        try {
                            insert.registerStudent(student);
                        } catch (ClassNotFoundException e) {
                        }
    }
}