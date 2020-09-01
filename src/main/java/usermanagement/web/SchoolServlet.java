package usermanagement.web;

import school.model.School;

import usermanagement.dao.SchoolDao;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the school.

 */

@WebServlet("/")
public class SchoolServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SchoolDao schoolDao;

    public void init() {

        schoolDao = new SchoolDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertSchool(request, response);
                    break;
                case "/delete":
                    deleteSchool(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateSchool(request, response);
                    break;
                default:
                    listSchool(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listSchool(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<School> listSchool = schoolDao.selectAllSchools();
        request.setAttribute("listSchool", listSchool);
        RequestDispatcher dispatcher = request.getRequestDispatcher("school-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("school-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        School existingSchool = schoolDao.getSchool(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("school-form.jsp");
        request.setAttribute("school", existingSchool);
        dispatcher.forward(request, response);

    }

    private void insertSchool(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");


        School newSchool=  new School(name, phoneNo, email);
        schoolDao.saveSchool(newSchool);
        response.sendRedirect("list");
    }

    private void updateSchool(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");


        School  schools =  new School(id,name, phoneNo, email);
        schoolDao.updateSchool(schools);
        response.sendRedirect("list");
    }

    private void deleteSchool(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        schoolDao.deleteSchool(id);
        response.sendRedirect("list");
    }
}


