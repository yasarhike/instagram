package com.instagram.feature.service.content.contentactivity;

import com.instagram.feature.model.content.contentactivity.Comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 * Implemented class for managing post comment operations.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class PostCommentService {

    private static PostCommentService commentService;
    private static int commentId;
    private final Map<Integer, List<Comment>> comments;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private PostCommentService() {
        comments = new HashMap<>();
    }

    /**
     * <p>
     * Returns the singleton instance of PostCommentService class.
     * </p>
     *
     * @return The singleton instance of PostCommentService class.
     */
    public static PostCommentService getInstance() {
        return commentService == null ? commentService = new PostCommentService() : commentService;
    }

    /**
     * <p>
     * Adds an object to the commentService for the specified user.
     * </p>
     *
     * @param comment Refers the object to be added.
     * @param postId  Refers the contentId of the user adding the object.
     * @return True if the object is added successfully, otherwise false.
     */
    public boolean add(final int postId, final Comment comment) {
        final List<Comment> elements = comments.computeIfAbsent(postId, k -> new ArrayList<>());
        return elements.add(comment);
    }

    /**
     * <p>
     * removes an object to the service for the specified user.
     * </p>
     *
     * @param postId Refers the object to be removed.
     * @return True if the object is added successfully, otherwise false.
     */
    public boolean remove(final int postId) {
        if (comments.containsKey(postId)) {
            comments.remove(postId);
            return true;
        }
        return false;
    }
}
