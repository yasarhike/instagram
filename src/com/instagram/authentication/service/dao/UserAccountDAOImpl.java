package com.instagram.authentication.service.dao;

import com.instagram.authentication.model.User;

import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

public class UserAccountDAOImpl {

    private static UserAccountDAOImpl userAccountDAOImpl;

    private UserAccountDAOImpl() {
    }

    public static UserAccountDAOImpl getInstance() {
        return userAccountDAOImpl == null ? userAccountDAOImpl = new UserAccountDAOImpl() : userAccountDAOImpl;
    }


    public boolean createProfile(final User user) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/instagram",
                "postgres",
                "Yasar@123")) {
            final String query = String.join(" ","WITH inserted_user AS (",
                    "    INSERT INTO account (name, mobile, email, password) VALUES (?, ?, ?, ?) RETURNING id", ")",
                    "INSERT INTO address (door_no, state, userId) VALUES (?, ?, (SELECT id FROM inserted_user))"
            );

            final PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getMobileNumber());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getAddress().getDoorNumber());
            preparedStatement.setString(6, user.getAddress().getState());

            if (preparedStatement.executeUpdate() > 0) {
                return setUserId(preparedStatement, user);
            }
        } catch (SQLException ignored) {
        }

        System.out.println("Account creation failed");
        return false;
    }

    private boolean setUserId(final PreparedStatement preparedStatement, final User user) throws SQLException {
        final ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if (resultSet != null && resultSet.next()) {
            user.setUserId(resultSet.getInt("id"));

            System.out.println("Account creation successful");
            return true;
        } else {
            System.out.println("Account creation failed");
            return false;
        }
    }
}
