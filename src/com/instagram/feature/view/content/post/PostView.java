package com.instagram.feature.view.content.post;

import com.instagram.authentication.model.User;
import com.instagram.feature.controller.content.post.PostController;
import com.instagram.feature.model.content.post.Post;
import com.instagram.feature.view.content.Content;
import com.instagram.feature.view.content.post.userinputhandler.UserInformationHandler;
import com.instagram.feature.view.home.PostManager;
import org.apache.log4j.Logger;

/**
 * <p>
 * Represents the view for managing posts.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class PostView extends Content {

    private static PostView postView;
    private final UserInformationHandler userInformationHandler;
    private final PostController postController;
    private final Logger logger;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private PostView() {
        postController = PostController.getInstance();
        userInformationHandler = UserInformationHandler.getInstance();
        logger = Logger.getLogger(PostView.class);
    }

    /**
     * <p>
     * Returns the singleton instance of PostView class.
     * </p>
     *
     * @return The singleton instance of PostView class.
     */
    public static PostView getInstance() {
        return postView == null ? postView = new PostView() : postView;
    }

    /**
     * <p>
     * Adds a new post.
     * </p>
     *
     * @param user Refers to the {@link User}.
     */
    public void add(final User user) {
        final Post post = new Post();

        post.setAuthor(user.getName());
        userInformationHandler.getUserDetails(post);

        if (postController.addPost(post, user.getUserId())) {
            user.setPost(user.getPost() + 1);

            logger.debug("posted successfully");
            PostManager.getInstance().post(user);
        } else {
            logger.debug("operation failed");
            PostManager.getInstance().post(user);
        }
    }

    /**
     * <p>
     * Deletes a post.
     * </p>
     *
     * @param user Refers to the {@link User}.
     */
    public void delete(final User user) {
        final int postId = userInformationHandler.getPostId();

        if (postController.removePost(postId, user.getUserId())) {
            user.setPost(user.getPost() - 1);

            logger.debug("Post removed successful");
            PostManager.getInstance().post(user);
        } else {
            logger.debug("operation failed");
            PostManager.getInstance().post(user);
        }
    }
}
