package com.Cenima.Servlets;
import com.Cenima.Classes.Film;
import com.Cenima.Classes.Rating;
import com.Cenima.DAO.FilmsDAO;
import com.Cenima.DAO.FilmsDAOImp;
import com.Cenima.DAO.RatingDAO;
import com.Cenima.DAO.RatingDAOimp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

public class RatingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int score = Integer.parseInt(request.getParameter("score"));
        int filmId = Integer.parseInt(request.getParameter("filmId"));


        Rating rating = new Rating();
        rating.setScore(score);


        FilmsDAO filmDAO = new FilmsDAOImp();
        Film film = filmDAO.addFilm(filmId); // Supposons que vous avez une méthode getFilmById dans votre FilmDAO


        rating.setFilm(film);


        RatingDAO ratingDAO = new RatingDAOimp();
        try {
            ratingDAO.addRating(rating);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Rediriger l'utilisateur vers une page de confirmation ou une autre page appropriée
        response.sendRedirect("confirmation.jsp");
    }
}
