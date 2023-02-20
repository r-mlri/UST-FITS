/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Insert;
import model.Trainer;


@WebServlet("/register")
public class InsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Insert insert;

    public void init() {
        insert = new Insert();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String name = request.getParameter("name");
        String specialty = request.getParameter("specialty");
        String sports = request.getParameter("sports");
        
                        
                        
        if(name != null)
            {                

                response.sendRedirect("Successful.jsp");       

            }
            else 
                {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/error500.jsp");
			PrintWriter out = response.getWriter();
			if (name == null) 
                        {
				out.println("<font color=red>Please fill up the form.</font>");
			} 
                        else 
                        {
				out.println("<font color=red>You missed the Captcha.</font>");
			}
			rd.include(request, response);
                }    
        
                Trainer trainer = new Trainer();
                
                trainer.setName(name);
                trainer.setSpecialty(specialty);
                trainer.setSports(sports);

        try {
            insert.insertTrainers(trainer);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}