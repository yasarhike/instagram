package com.instagram.feature.controller.content.post;

import com.instagram.feature.model.content.post.Post;
import com.instagram.feature.service.content.post.PostServiceImplementation;

import java.util.Map;

/**
 * <p>
 * Implementation of the PostController class for managing posts.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class PostController {

    private static PostController postController;
    private final PostServiceImplementation postService;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private PostController() {
        postService = PostServiceImplementation.getInstance();
    }

    /**
     * <p>
     * Returns the singleton instance of PostController class.
     * </p>
     *
     * @return The singleton instance of PostController class.
     */
    public static PostController getInstance() {
        return postController == null ? postController = new PostController() : postController;
    }

    /**
     * <p>
     * Adds a post for the specified user.
     * </p>
     *
     * @param post   Refer to the {@link Post} of the user.
     * @param userId The userId of the user adding the post.
     * @return True if the post is added successfully, otherwise false.
     */
    public boolean addPost(final Post post, final Integer userId) {
        return postService.addPost(post, userId);
    }

    /**
     * <p>
     * Removes a post with the specified ID for the specified user.
     * </P>
     *
     * @param postId Refer to postId of the post.
     * @param userId The userId of the user removing the post.
     * @return True if the post is removed successfully, otherwise false.
     */
    public boolean removePost(final Integer postId, final Integer userId) {
        return postService.removePost(postId, userId);
    }

    /**
     * <p>
     * Retrieves all posts.
     * </p>
     *
     * @return Map contains the user post.
     */
    public Map<Integer, Map<Integer, Post>> getPost() {
        return postService.getPost();
    }
}
