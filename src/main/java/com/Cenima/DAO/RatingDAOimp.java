package com.Cenima.DAO;

import com.Cenima.Classes.Rating;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;

public class RatingDAOimp implements RatingDAO{
    @Override
    public void addRating(Rating rating) throws SQLException {
        // Code pour insurer une nouvelle notation dans la base de données
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(rating);
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
