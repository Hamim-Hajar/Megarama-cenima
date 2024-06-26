package com.Cenima.Servlets;

import com.Cenima.Classes.User;
import com.Cenima.DAO.FilmsDAOImp;
import com.Cenima.DAO.UserDAOImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Inscription", value = "/Inscription")
public class Inscription extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FilmsDAOImp films = new FilmsDAOImp();
        request.setAttribute("listFilms", films.selectAllFilms());
        System.out.println(films.selectAllFilms());
        this.getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FilmsDAOImp films = new FilmsDAOImp();
        UserDAOImp InscUser = new UserDAOImp();

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = "user";
        User user = new User(username, email , password , role);
        InscUser.addUser(user);

        HttpSession session = request.getSession();
        session.setAttribute("NewUser" , user);
        request.setAttribute("listFilms", films.selectAllFilms());

        this.getServletContext().getRequestDispatcher("/WEB-INF/ShowFilms.jsp").forward(request , response);
    }
}