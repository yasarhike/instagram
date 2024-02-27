package com.instagram.feature.controller.contentactivity;

import com.instagram.feature.model.content.contentactivity.Comment;
import com.instagram.feature.service.content.contentactivity.PostCommentServiceImpl;

/**
 * <p>
 * Controller class responsible for managing comments on posts.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class PostCommentController {

    private static PostCommentController postCommentController;
    private final PostCommentServiceImpl commentService;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private PostCommentController() {
        commentService = PostCommentServiceImpl.getInstance();
    }

    /**
     * <p>
     * Creates a singleton instance of the PostCommentController class if it is not already created.
     * </p>
     *
     * @return Singleton instance of PostCommentController class.
     */
    public static PostCommentController getInstance() {
        return postCommentController == null ? postCommentController = new PostCommentController() : postCommentController;
    }

    /**
     * <p>
     * Adds a comment to the specified post.
     * </p>
     *
     * @param postId  The ID of the post to which the comment will be added.
     * @param comment The comment to be added.
     * @return True if the comment is successfully added, false otherwise.
     */
    public boolean add(final int postId, final Comment comment) {
        return commentService.add(postId, comment);
    }

    /**
     * <p>
     * Removes comments associated with the specified post.
     * </p>
     *
     * @param postId The ID of the post from which comments will be removed.
     * @return True if comments are successfully removed, otherwise false.
     */
    public boolean remove(final int postId) {
        return commentService.remove(postId);
    }
}
