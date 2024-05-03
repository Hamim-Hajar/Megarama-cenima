package com.Cenima.DAO;

import com.Cenima.Classes.Rating;

import java.sql.SQLException;

public interface RatingDAO {
    void addRating(Rating rating) throws SQLException;
}
