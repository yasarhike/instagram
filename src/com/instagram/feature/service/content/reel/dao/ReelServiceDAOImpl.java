package com.instagram.feature.service.content.reel.dao;

import com.instagram.feature.model.content.reel.Reel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReelServiceDAOImpl implements ReelServiceDAO{

    private static ReelServiceDAOImpl reelServiceDAOImpl;

    private ReelServiceDAOImpl() {
    }

    public static ReelServiceDAOImpl getInstance() {
        return reelServiceDAOImpl == null ? reelServiceDAOImpl = new ReelServiceDAOImpl() : reelServiceDAOImpl;
    }

    @Override
    public boolean addReel(Reel reel, Integer userId) {
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/instagram",
                "postgres",
                "Yasar@123")) {
            final String query = String.join(" ", "INSERT INTO REELS  (user_id, caption," +
                    "duration) VALUES (?, ?, ?)");
            final PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, reel.getUserId());
            preparedStatement.setString(2, reel.getCaption());
            preparedStatement.setString(3, reel.getDuration());

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException exception) {
            System.out.println("Operation failed");
        }
        return false;
    }
}
