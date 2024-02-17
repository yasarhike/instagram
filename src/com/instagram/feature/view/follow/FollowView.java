package com.instagram.feature.view.follow;

import com.instagram.feature.controller.follow.FollowController;
import com.instagram.scanner.SingletonScanner;
import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * <p>
 * Represents the view for managing followers.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class FollowView {

    private static FollowView followView;
    private final Scanner scanner;
    private final FollowController followController;
    private final Logger logger;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private FollowView() {
        scanner = SingletonScanner.getInstance().getScanner();
        followController = FollowController.getInstance();
        logger = Logger.getLogger(FollowView.class);
    }

    /**
     * <p>
     * Returns the singleton instance of FollowView class.
     * </p>
     *
     * @return The singleton instance of FollowView class.
     */
    public static FollowView getInstance() {
        return followView == null ? followView = new FollowView() : followView;
    }

    /**
     * <p>
     * Displays the follow page and handles user actions
     * </p>
     *
     * @param userId Username of the user to follow.
     */
    public void followPage(final int userId) {
        int userChoice = 0;

        try {
            logger.info("Press 1 - Follow\nPress 2 - Unfollow");
            userChoice = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException exception) {
            logger.error("Enter a valid input");
            followPage(userId);
        }

        switch (userChoice) {
            case 1:
                follow(userId);
                break;
            case 2:
                unFollow(userId);
                break;
            default:
                System.exit(0);
        }
    }

    /**
     * <p>
     * Handles the follow operation.
     * </p>
     *
     * @param userId Username of the user to follow.
     */
    private void follow(final int userId) {
        final int followerId = getFollower();

        if (followController.addFollower(userId, followerId)) {
            logger.debug("Followed successful");
        } else {
            logger.debug("Operation failed");
        }
    }

    /**
     * <p>
     * Handles the Unfollow operation.
     * </p>
     *
     * @param userId Username of the user to unfollow.
     */
    private void unFollow(final int userId) {
        final int followerId = getFollower();

        if (followController.removeFollower(userId, followerId)) {
            logger.debug("Unfollowed successful");
        } else {
            logger.debug("Operation failed");
        }
    }

    /**
     * <p>
     * Get the name of the follower.
     * </p>
     *
     * @return The follower name.
     */
    private int getFollower() {
        logger.info("Enter the follower id :");
        return scanner.nextInt();
    }
}
