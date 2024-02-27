package com.instagram.feature.service.content.story.dao;

import com.instagram.feature.model.content.story.Story;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoryServiceDAOImpl implements StoryServiceDAO{

    private static StoryServiceDAOImpl storyServiceDAOImpl;

    private StoryServiceDAOImpl() {
    }

    public static StoryServiceDAOImpl getInstance() {
        return storyServiceDAOImpl == null ? storyServiceDAOImpl = new StoryServiceDAOImpl() : storyServiceDAOImpl;
    }
    @Override
    public boolean addStory(Story story, Integer userId) {
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/instagram",
                "postgres",
                "Yasar@123")) {
            final String query = String.join(" ", "INSERT INTO STORY  (user_id, text," +
                    "is_private, music, type) VALUES (?, ?, ?, ?, ?)");
            final PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, story.getUserId());
            preparedStatement.setString(2, story.getText());
            preparedStatement.setBoolean(3, story.isPrivate());
            preparedStatement.setString(4, story.getMusic());
            preparedStatement.setInt(5, story.getMedia().getId());

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException exception) {
            System.out.println("Operation failed");
            exception.printStackTrace();
        }
        return false;
    }
}
