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
 * Managing comments on reels. It provides methods for adding and removing comments on reels.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class ReelCommentView {

    private static ReelCommentView reelCommentView;
    private final Scanner scanner;
    private final ReelCommentController commentController;
    private final UserInformationHandler userInputHandler;
    private final Logger logger;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private ReelCommentView() {
        scanner = SingletonScanner.getInstance().getScanner();
        commentController = ReelCommentController.getInstance();
        userInputHandler = UserInformationHandler.getInstance();
        logger = Logger.getLogger(ReelCommentView.class);
    }

    /**
     * <p>
     * Returns the singleton instance of ReelCommentView class.
     * </p>
     *
     * @return The singleton instance of ReelCommentView class.
     */
    public static ReelCommentView getInstance() {
        return reelCommentView == null ? reelCommentView = new ReelCommentView() : reelCommentView;
    }

    /**
     * <p>
     * Allows the user to add or remove comments on a reels.
     * </p>
     *
     * @param user   Refers the user who is adding or removing the comment.
     * @param reelId Refers the ID of the post on which the comment operation is performed.
     */
    public void comment(final User user, final int reelId) {
        int userChoice = 0;

        try {
            logger.info("Press 1 - Add comment\nPress 2 - Remove comment");
            userChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            logger.error("Enter a valid input");
            comment(user, reelId);
        }

        switch (userChoice) {
            case 1:
                addComment(user, reelId);
                break;
            case 2:
                removeComment(user, reelId);
                break;
            default:
                logger.error("Enter a valid input");
        }
    }

    /**
     * <p>
     * Adds a comment on a reel.
     * </p>
     *
     * @param user   The user who is adding the comment.
     * @param reelId The ID of the reel on which the comment is added.
     */
    public void addComment(final User user, final int reelId) {
        final Comment comment = new Comment();

        comment.setAuthor(user.getName());
        comment.setContent(userInputHandler.getCaption());

        if (commentController.add(reelId, comment)) {
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
     * @param reelId The ID of the reel on which the comment is added.
     */
    public void removeComment(final User user, final int reelId) {
        if (commentController.remove(reelId)) {
            logger.debug("Comment removed successfully");
        } else {
            logger.debug("Operation failed");
        }
    }
}
