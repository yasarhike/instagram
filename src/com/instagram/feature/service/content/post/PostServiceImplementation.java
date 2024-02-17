package com.instagram.feature.service.content.post;

import com.instagram.feature.model.content.post.Post;
import com.instagram.feature.service.content.ContentServiceImplementation;

import java.util.Map;

/**
 * <p>
 * Implementation class for managing posts.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class PostServiceImplementation {

    private static PostServiceImplementation postServiceImplementation;
    private final ContentServiceImplementation<Post> postService;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private PostServiceImplementation() {
        postService = new ContentServiceImplementation<>();
    }

    /**
     * <p>
     * Returns the singleton instance of PostServiceImplementation class.
     * </p>
     *
     * @return The singleton instance of PostServiceImplementation class.
     */
    public static PostServiceImplementation getInstance() {
        return postServiceImplementation == null ? postServiceImplementation = new PostServiceImplementation()
                : postServiceImplementation;
    }

    /**
     * <p>
     * Adds a post for the specified user.
     * </p>
     *
     * @param post   Refer to the post to the user.
     * @param userId Refer the userId of the user adding the post.
     * @return True if the post is added successfully, otherwise false.
     */
    public boolean addPost(final Post post, final Integer userId) {
        post.setTimestamp();
        post.setPostId(ContentServiceImplementation.getContentCount());

        return postService.add(post, userId);
    }

    /**
     * <p>
     * Removes a post with the specified ID for the specified user.
     * </P>
     *
     * @param postId Refer to id of the post.
     * @param userId The userId of the user removing the post.
     * @return True if the post is removed successfully, otherwise false.
     */
    public boolean removePost(final int postId, final Integer userId) {
        return postService.remove(postId, userId);
    }

    /**
     * <p>
     * Retrieves all post.
     * </p>
     *
     * @return Map contains the user story.
     */
    public Map<Integer, Map<Integer, Post>> getPost() {
        return postService.getContent();
    }
}