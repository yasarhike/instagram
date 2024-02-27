package com.instagram.feature.view;

import com.instagram.authentication.model.User;
import com.instagram.feature.controller.ReelsFeedController;
import com.instagram.feature.model.content.contentactivity.Comment;
import com.instagram.feature.model.content.reel.Reel;
import com.instagram.feature.view.contentactivity.ReelCommentView;
import com.instagram.feature.view.home.HomeView;
import com.instagram.scanner.SingletonScanner;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * <p>
 * Managing reels feed.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class ReelsFeedView {

    private static ReelsFeedView reelsManager;
    private final ReelsFeedController reelsManagerController;
    private final Scanner scanner;
    private final Logger logger;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private ReelsFeedView() {
        reelsManagerController = ReelsFeedController.getInstance();
        scanner = SingletonScanner.getInstance().getScanner();
        logger = Logger.getLogger(ReelsFeedView.class);
    }

    /**
     * <p>
     * Returns the singleton instance of ReelsFeedView class.
     * </p>
     *
     * @return The singleton instance of ReelsFeedView class.
     */
    public static ReelsFeedView getInstance() {
        return reelsManager == null ? reelsManager = new ReelsFeedView() : reelsManager;
    }

    /**
     * <p>
     * Displays reels to the user and manages user interactions with reel content.
     * </p>
     *
     * @param user The user for whom reels are displayed.
     */
    public void displayReels(final User user) {
        Map<Integer, Map<Integer, Reel>> reel = reelsManagerController.getReels();

        if (reel.isEmpty()) {
            logger.debug("No reels found");
            HomeView.getInstance().home(user);
        }
        for (final Integer element : reel.keySet()) {
            final Map<Integer, Reel> innerMap = reel.get(element);

            if (user.getUserId() != element) {
                for (final int innerElement : innerMap.keySet()) {

                    if (!innerMap.get(innerElement).isPrivate()) {
                        displayReelContent(innerMap.get(innerElement), user);
                    }
                }
            }
        }
        HomeView.getInstance().home(user);
    }

    public void displayReelContent(final Reel reel, final User user) {
        logger.info(
                "Reel id         : " + reel.getReelId() +
                        "\nCaption       : " + reel.getCaption() +
                        "\nComments :"
        );
        displayComments(reelsManagerController.getComment(reel.getReelId()));

        if (getUserChoice(user, reel)) {
            displayReelContent(reel, user);
        }
    }

    public void displayComments(final List<Comment> comments) {
        for (int index = 0; comments != null && index < comments.size(); index++) {
            displayComment(comments.get(index));
        }
    }

    public void displayComment(final Comment comment) {
        logger.info(
                "\nAuthor        : " + comment.getAuthor() +
                        "\nContent       : " + comment.getContent() +
                        "\nLikes         : " + comment.getLikes()
        );
    }

    public boolean getUserChoice(final User user, final Reel reel) {
        logger.info("Press 1 - Like\nPress 2 - Comment\nPress 3 - Next reel");
        final int userChoice = Integer.parseInt(scanner.nextLine());

        return switch (userChoice) {
            case 1 -> true;
            case 2 -> {
                ReelCommentView.getInstance().comment(user, reel.getReelId());
                yield true;
            }
            case 3 -> false;
            default -> true;
        };
    }
}
