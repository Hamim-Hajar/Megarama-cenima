package com.Cenima.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Cenima.Classes.Film;
import com.Cenima.Classes.Reservation;
import com.Cenima.DAO.FilmsDAOImp;
import com.Cenima.DAO.ReservationDAOImp;

@WebServlet("/Details")
public class Details extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Details() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FilmsDAOImp flm = new FilmsDAOImp();
        int idFilm = Integer.valueOf(request.getParameter("id"));
        List<Film> list_Film = null;
        try {
            list_Film = flm.selectFilmById(idFilm);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("list_film", list_Film);


        request.getRequestDispatcher("/WEB-INF/details.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/details.jsp").forward(request, response);

    }

}
