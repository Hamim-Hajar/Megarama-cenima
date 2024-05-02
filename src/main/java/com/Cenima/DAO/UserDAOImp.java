package com.Cenima.DAO;

import com.Cenima.Classes.Film;
import com.Cenima.Classes.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImp implements UserDAO {

    @Override
    public User getUser(String username, String password) throws SQLException {
        User user=null;
        Connection con = DataBaseManager.getConnection();
        PreparedStatement ps = con.prepareStatement("select user_id , role from user1 where email=? and passwrd=?");
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setRole(rs.getString("role"));

        }
        return user;
    }

    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO user1 (username , email, passwrd, role) VALUES (?, ?, ?, ?)";
        Connection connection = DataBaseManager.getConnection();
        System.out.println("***** Add User *************");
        PreparedStatement statement =connection.prepareStatement(sql);
        statement.setString(1, user.getUserName());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPassword());
        statement.setString(4, "user");
        statement.executeUpdate();
    }

}
