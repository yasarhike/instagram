package com.instagram.feature.view.content;

import com.instagram.authentication.model.User;
import com.instagram.feature.view.home.PostManager;
import com.instagram.scanner.SingletonScanner;
import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * <p>
 * Abstract class representing content management functionality.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public abstract class Content {

    private final Scanner scanner = SingletonScanner.getInstance().getScanner();
    private final Logger logger = Logger.getLogger(Content.class);

    /**
     * <p>
     * Displays the content home page and handles user actions.
     * </p>
     *
     * @param user Refers to the {@link User}.
     */
    public void contentHomePage(final User user) {
        int userChoice = 0;

        try {
            logger.info("Press 1 - Add\nPress 2 - Delete\nPress 3 - Back");
            userChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            logger.error("Enter a valid input");
            contentHomePage(user);
        }

        switch (userChoice) {
            case 1:
                add(user);
                break;
            case 2:
                delete(user);
                break;
            case 3:
                PostManager.getInstance().post(user);
            default:
                logger.error("Enter a valid input");
                contentHomePage(user);
        }
    }

    /**
     * <p>
     * Abstract method to add content.
     * </p>
     *
     * @param user Refers to the {@link User}.
     */
    abstract public void add(final User user);

    /**
     * <p>
     * Abstract method to delete content.
     * </p>
     *
     * @param user Refers to the {@link User}.
     */
    abstract public void delete(final User user);
}
