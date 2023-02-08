package Controllers;



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.studententrylog;

/**
 *
 * @author Thomas Jefferson Qiu, Ezekiel Giron
 */


@WebServlet(name = "StudentLog.jsp")
public class studentLogServlet extends HttpServlet {
        
        
        
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            
        
            String SN = request.getParameter("SN");
            
            if(SN != null)
            {                
                response.sendRedirect("success.jsp");                             
            }
            else 
                {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/StudentLog.jsp");
			PrintWriter out = response.getWriter();
			if (SN == null) 
                        {
				response.sendRedirect("fail.jsp");
			} 
                        else 
                        {
				response.sendRedirect("error.jsp");
			}
			rd.include(request, response);
                }
        }
}
            