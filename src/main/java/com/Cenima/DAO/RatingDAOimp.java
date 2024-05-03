package com.Cenima.DAO;
import java.util.List;
import com.Cenima.Classes.Film;
import com.Cenima.Classes.Rating;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.sql.SQLException;

public class RatingDAOimp implements RatingDAO{
    @Override
    public void addRating(Rating rating) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(rating);
            Query query = session.createQuery("SELECT r.score FROM Rating r WHERE r.film = :film");
            query.setParameter("film", rating.getFilm());
            List<Integer> scores = query.list();
            double averageScore = 0.0;
            int totalScores = scores.size();
            if (totalScores > 0) {
                int sum = 0;
                for (Integer score : scores) {
                    sum += score;
                }
                averageScore = (double) sum / totalScores;
            }
            Film film = rating.getFilm();
            film.setAverageRating(averageScore);
            session.update(film);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }




}
