package com.instagram.feature.view.contentactivity;

import com.instagram.authentication.model.User;
import com.instagram.feature.controller.contentactivity.ReelCommentController;
import com.instagram.feature.model.content.contentactivity.Comment;
import com.instagram.feature.view.content.post.userinputhandler.UserInformationHandler;
import com.instagram.scanner.SingletonScanner;
import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * <p>
 * Managing comments on posts. It provides methods for adding and removing comments on posts.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class PostCommentView {

    private static PostCommentView postCommentView;
    private final Scanner scanner;
    private final ReelCommentController commentController;
    private final UserInformationHandler userInputHandler;
    private final Logger logger;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private PostCommentView() {
        scanner = SingletonScanner.getInstance().getScanner();
        commentController = ReelCommentController.getInstance();
        userInputHandler = UserInformationHandler.getInstance();
        logger = Logger.getLogger(PostCommentView.class);
    }

    /**
     * <p>
     * Returns the singleton instance of PostCommentView class.
     * </p>
     *
     * @return The singleton instance of PostCommentView class.
     */
    public static PostCommentView getInstance() {
        return postCommentView == null ? postCommentView = new PostCommentView() : postCommentView;
    }

    /**
     * <p>
     * Allows the user to add or remove comments on a post.
     * </p>
     *
     * @param user   Refers the user who is adding or removing the comment.
     * @param postId Refers the ID of the post on which the comment operation is performed.
     */
    public void comment(final User user, final int postId) {
        int userChoice = 0;

        try {
            logger.info("Press 1 - Add comment\nPress 2 - Remove comment");
            userChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            System.err.println("Enter a valid input");
            comment(user, postId);
        }

        switch (userChoice) {
            case 1:
                addComment(user, postId);
            case 2:
                removeComment(user, postId);
            default:
                logger.error("Enter a valid input");
        }
    }

    /**
     * <p>
     * Adds a comment on a post.
     * </p>
     *
     * @param user   The user who is adding the comment.
     * @param postId The ID of the post on which the comment is added.
     */
    public void addComment(final User user, final int postId) {
        final Comment comment = new Comment();

        comment.setAuthor(user.getName());
        comment.setContent(userInputHandler.getCaption());

        if (commentController.add(postId, comment)) {
            logger.debug("Comment added successfully");
        } else {
            logger.debug("operation failed");
        }
    }

    /**
     * <p>
     * Removes a comment on a post.
     * </p>
     *
     * @param user   The user who is adding the comment.
     * @param postId The ID of the post on which the comment is added.
     */
    public void removeComment(final User user, final int postId) {
        if (commentController.remove(postId)) {
            logger.debug("Comment removed successfully");
        } else {
            logger.debug("Operation failed");
        }
    }
}
