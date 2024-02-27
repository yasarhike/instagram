package com.instagram.feature.service.content.post.dao;

import com.instagram.feature.model.content.post.Post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostServiceDAOImpl implements PostServiceDAO{

    private static PostServiceDAOImpl postServiceDAOImpl;

    private PostServiceDAOImpl() {
    }

    public static PostServiceDAOImpl getInstance() {
        return postServiceDAOImpl == null ? postServiceDAOImpl = new PostServiceDAOImpl() : postServiceDAOImpl;
    }

    @Override
    public boolean addPost(final Post post) {
        try(final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/instagram",
                "postgres",
                "Yasar@123")) {

            final String query = String.join(" " , "INSERT INTO post (user_id, caption," +
                    " is_private, type) VALUES (?, ?, ?, ?)");

            final PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1,post.getUserId());
            preparedStatement.setString(2, post.getCaption());
            preparedStatement.setBoolean(3,post.isPrivate());
            preparedStatement.setInt(4, post.getType().getId());

            return preparedStatement.executeUpdate() >= 0;

        } catch (final SQLException ignored) {
        }
        System.out.println("Operation failed");
        return false;
    }

    @Override
    public boolean removePost(final int postId, final Integer userId) {
        try(final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/instagram",
                "postgres",
                "Yasar@123")) {

            final String query = String.join(" ", "DELETE FROM POST WHERE post.id = ?");
            final PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1,postId);

            return preparedStatement.executeUpdate() >=0;

        } catch (final SQLException ignored) {

        }
        return false;
    }

    public boolean updatePost(final Post post) {
        try(final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/instagram",
                "postgres",
                "Yasar@123")) {

            final StringBuilder query = new StringBuilder("UPDATE post");
            final List<Object> list = new ArrayList<>();

            if (post.getCaption() != null) {
                query.append("SET caption = ?");
                list.add(post.getPostId());
            } else {
                query.append("SET is_private = ?");
                list.add(post.isPrivate());
            }

            query.append("WHERE id = ?");

            final PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            for (int index = 1; index <= list.size(); index++) {
                preparedStatement.setObject(index, list.get(index - 1));
            }
        } catch (final SQLException exception) {
            System.out.println("Update failed");
        }
        return false;
    }
}
