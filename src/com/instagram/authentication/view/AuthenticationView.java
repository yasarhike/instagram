package com.instagram.authentication.view;

import com.instagram.authentication.model.User;
import com.instagram.feature.view.home.HomeView;
import com.instagram.scanner.SingletonScanner;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * <p>
 * Managing user authentication operations.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class AuthenticationView {

    private static AuthenticationView authenticationView;
    private final UserAccountView profileView;
    private final Scanner scanner;
    private final Logger logger;

    /**
     * <p>
     * Private constructor to initialize necessary components for authentication.
     * </p>
     */
    private AuthenticationView() {
        profileView = UserAccountView.getInstance();
        scanner = SingletonScanner.getInstance().getScanner();
        logger = Logger.getLogger(AuthenticationView.class);
    }

    /**
     * <p>
     * Create a singleton instance of Authentication class if it is not already created.
     * </p>
     *
     * @return Singleton instance of AuthenticationPage class.
     */
    public static AuthenticationView getInstance() {
        return authenticationView == null ? authenticationView = new AuthenticationView() : authenticationView;
    }

    /**
     * <p>
     * Displays the registration page and allows the user to register.
     * </p>
     */
    public void authentication() {
        int userChoice = 0;
        BasicConfigurator.configure();

        try {
            logger.info("Press 1 - create new account \nPress 2 - login\nPress 3 - exit");
            userChoice = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException exception) {
            logger.error("Enter the valid input");
            authentication();
        }

        switch (userChoice) {
            case 1:
                signUp();
            case 2:
                signIn();
            case 3:
                System.exit(0);
            default:
                authentication();
        }
    }

    /**
     * <p>
     * Displays the registration page and allows the user to register.
     * </p>
     */
    public void signUp() {
        final User user = profileView.createProfile();
        if (user != null) {
            logger.debug("Account creation successful");
            HomeView.getInstance().home(user);
        } else {
            signUp();
        }
    }

    /**
     * <p>
     * Displays the login page and allows the user to sign in.
     * </p>
     */
    public void signIn() {
        final User user = profileView.getProfile();

        if (user != null) {
            logger.debug("Login successful");
            HomeView.getInstance().home(user);
        } else {
            signIn();
        }
    }
}
