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
import model.studentLog;

/**
 *
 * @author Thomas Jefferson Qiu, Ezekiel Giron
 */


@WebServlet(name = "StudentLog.jsp")
public class studentLogServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private studententrylog insert;
        
        public void init() {
        insert = new studententrylog();
    }
        
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
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
					"/StudentLog.jsp");
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
            