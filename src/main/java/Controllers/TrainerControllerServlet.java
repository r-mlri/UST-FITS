/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Trainer;
import model.TrainerDAO;

@WebServlet("/")
public class TrainerControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TrainerDAO trainerDAO;

 public void init() {

        String jdbcURL = "jdbc:derby://localhost:1527/Trainer";
        String jdbcUsername = "app";
        String jdbcPassword = "app";
        trainerDAO = new TrainerDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertTrainer(request, response);
                break;
            case "/delete":
                deleteTrainer(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateTrainer(request, response);
                break;
            default:
                listTrainers(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void listTrainers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Trainer> trainers = trainerDAO.getAllTrainers();
        request.setAttribute("trainers", trainers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listTrainers.jsp");   //List of all trainers
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("trainerForm.jsp");    //edit form
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Trainer existingTrainer = trainerDAO.getTrainer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("trainerForm.jsp");    //edit form
        request.setAttribute("trainer", existingTrainer);
        dispatcher.forward(request, response);

    }

    private void insertTrainer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String specialty = request.getParameter("specialty");
        String sports = request.getParameter("sports");
        Trainer newTrainer = new Trainer(name, specialty, sports);
        trainerDAO.saveTrainer(newTrainer);
        response.sendRedirect("list");
    }

    private void updateTrainer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String specialty = request.getParameter("specialty");
        String sports = request.getParameter("sports");

        Trainer trainer = new Trainer(id, name, specialty, sports);
        trainerDAO.updateTrainer(trainer);
        response.sendRedirect("list");
    }

    private void deleteTrainer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        trainerDAO.deleteTrainer(id);
        response.sendRedirect("list");
    }
}