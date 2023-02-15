package Controllers;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.studententrylog;
import model.studentLog;
import model.studentselectlog;

/**
 *
 * @author Thomas Jefferson Qiu, Ezekiel Giron
 */


@WebServlet(name = "StudentLog.jsp")
public class studentLogServlet extends HttpServlet {
        Connection conn;
        private static final long serialVersionUID = 1L;
        private studententrylog insert;
        
        public void init(ServletConfig config) throws ServletException{
            super.init(config);

        try {
            Class.forName(config.getInitParameter("jdbcClassName"));
            //System.out.println("jdbcClassName: " + config.getInitParameter("jdbcClassName"));
            String username = config.getInitParameter("dbUserName");
            String password = config.getInitParameter("dbPassword");
            String url = config.getInitParameter("jdbcDriverURL");
            conn = DriverManager.getConnection(url, username, password);
            } 
            catch (SQLException sqle) 
            {
            System.out.println("SQLException error occured - " + sqle.getMessage());
            }   
            catch (ClassNotFoundException nfe) 
            {
            System.out.println("ClassNotFoundException error occured - " + nfe.getMessage());
            }
        insert = new studententrylog();
    }
        
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            
            if("Entry".equals(request.getParameter("hidden"))){

                int ID = Integer.parseInt(request.getParameter("ID"));

                if(conn != null){
                    studententrylog model = new studententrylog();
                    studentselectlog model2 = new studentselectlog();
                    boolean error = model.insertData(ID, conn);
                    
                    if(error != false){
                         ResultSet records = model2.retrieveData(conn);

                         if(records != null){
                             request.setAttribute("results", records);
                             request.getRequestDispatcher("index.jsp").forward(request, response);
                         }
                         else{
                             request.getRequestDispatcher("error2.jsp").forward(request, response);
                         }
                    }
                    else{
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                }
                else{
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }    
            }
 /*             
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
             LocalTime localTime = LocalTime.now();
             System.out.println(dtf.format(localTime));  
        
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
                        }*/
        }
}
            