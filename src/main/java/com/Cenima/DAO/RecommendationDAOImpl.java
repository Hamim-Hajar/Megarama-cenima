package com.Cenima.DAO;

import com.Cenima.Classes.Film;
import com.Cenima.DAO.HibernateUtil;
import com.Cenima.DAO.RecommendationDAO;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class RecommendationDAOImpl extends RecommendationDAO {

    @Override
    public List<Film> ShowRecommendation() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Execute the query to get the top five films with the most reservations
        Query query = session.createSQLQuery("SELECT film_id, COUNT(*) as total FROM reservation GROUP BY film_id ORDER BY total DESC");
        query.setMaxResults(5); // Fetch top five results
        List<Object[]> results = query.list();

        List<Integer> mostReservedFilmIds = new ArrayList<>();
        for (Object[] result : results) {
            mostReservedFilmIds.add((Integer) result[0]);
        }

        // Retrieve the details of the top five most reserved films
        Query query1 = session.createQuery("FROM Film f WHERE film_id IN :film_ids");
        query1.setParameterList("film_ids", mostReservedFilmIds);
        List<Film> films = query1.list();

        session.getTransaction().commit();
        session.close();

        System.out.println(films);
        return films;
    }

}