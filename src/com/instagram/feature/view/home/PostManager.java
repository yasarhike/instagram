package com.instagram.feature.view.home;

import com.instagram.authentication.model.User;
import com.instagram.feature.view.content.post.PostView;
import com.instagram.feature.view.content.reel.ReelView;
import com.instagram.feature.view.content.story.StoryView;
import com.instagram.scanner.SingletonScanner;
import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * <p>
 * Manages different types of posts (posts, reels, stories) and navigation between them.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class PostManager {

    private static PostManager postManager;
    private final PostView postView;
    private final ReelView reelView;
    private final StoryView storyView;
    private final Scanner scanner;
    private final Logger logger;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private PostManager() {
        postView = PostView.getInstance();
        reelView = ReelView.getInstance();
        storyView = StoryView.getInstance();
        scanner = SingletonScanner.getInstance().getScanner();
        logger = Logger.getLogger(PostManager.class);
    }

    /**
     * <p>
     * Returns the singleton instance of PostManager class.
     * </p>
     *
     * @return The singleton instance of PostManager class.
     */
    public static PostManager getInstance() {
        return postManager == null ? postManager = new PostManager() : postManager;
    }

    /**
     * <p>
     * Displays the post management options and handles user actions.
     * </p>
     *
     * @param user Refers to the {@link User}
     */
    public void post(final User user) {
        int userChoice = 0;

        try {
            logger.info("Press 1 - Post\nPress 2 - Reel\nPress 3 - Story\nPress 4 - Back");
            userChoice = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException exception) {
            logger.error("Enter a valid input");
            post(user);
        }

        switch (userChoice) {
            case 1:
                postView.contentHomePage(user);
                break;
            case 2:
                reelView.contentHomePage(user);
                break;
            case 3:
                storyView.contentHomePage(user);
                break;
            case 4:
                HomeView.getInstance().home(user);
                break;
            default:
                post(user);
        }
    }
}
