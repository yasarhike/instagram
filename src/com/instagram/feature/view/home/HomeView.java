package com.instagram.feature.view.home;

import com.instagram.authentication.model.User;
import com.instagram.authentication.view.AuthenticationView;
import com.instagram.feature.view.ReelsFeedView;
import com.instagram.scanner.SingletonScanner;
import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * <p>
 * Represents the view for home page.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class HomeView {

    private static HomeView homeView;
    private final Scanner scanner;
    private final PostManager postManager;
    private final Logger logger;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private HomeView() {
        scanner = SingletonScanner.getInstance().getScanner();
        postManager = PostManager.getInstance();
        logger = Logger.getLogger(HomeView.class);
    }

    /**
     * <p>
     * Returns the singleton instance of HomeView class.
     * </p>
     *
     * @return The singleton instance of HomeView class.
     */
    public static HomeView getInstance() {

        return homeView == null ? homeView = new HomeView() : homeView;
    }

    /**
     * <p>
     * Displays the home screen and handles user actions.
     * </p>
     *
     * @param user Refers to the {@link User}.
     */
    public void home(final User user) {
        int userChoice = 0;

        try {
            logger.info("Press 1 - Feed\nPress 2 - Search\nPress 3 - Upload\nPress 4 - Reels\nPress 5 - Profile\nPress 6 - Logout");
            userChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            logger.error("Enter a valid input");
            home(user);
        }

        switch (userChoice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                postManager.post(user);
                break;
            case 4:
                ReelsFeedView.getInstance().displayReels(user);
                break;
            case 5:
                break;
            case 6:
                AuthenticationView.getInstance().authentication();
                break;
            default:
                logger.error("Enter a valid input");
                home(user);
        }
    }
}
