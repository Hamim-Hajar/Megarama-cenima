package com.Cenima.Servlets;
import com.Cenima.Classes.Film;
import com.Cenima.Classes.Rating;
import com.Cenima.DAO.FilmsDAO;
import com.Cenima.DAO.FilmsDAOImp;
import com.Cenima.DAO.RatingDAO;
import com.Cenima.DAO.RatingDAOimp;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet(name = "RatingServlet", value = "/RatingServlet")
public class RatingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filmIdString = request.getParameter("filmId");
        if (filmIdString != null && !filmIdString.isEmpty()) {
            int filmId = Integer.parseInt(filmIdString);
            FilmsDAO filmDAO = new FilmsDAOImp();
            Film film = null;
            try {
                film = filmDAO.selectFilmById(filmId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            request.setAttribute("film", film);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("details.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int score = Integer.parseInt(request.getParameter("score"));
        int filmId = Integer.parseInt(request.getParameter("filmId"));
        Rating rating = new Rating();
        rating.setScore(score);
        FilmsDAO filmDAO = new FilmsDAOImp();
        Film film = null;
        try {
            film = filmDAO.selectFilmById(filmId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        rating.setFilm(film);
        RatingDAO ratingDAO = new RatingDAOimp();
        try {
            ratingDAO.addRating(rating);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("details.jsp");
    }

}
