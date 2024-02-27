package com.instagram.authentication.view;

import com.instagram.authentication.controller.UserAccountController;
import com.instagram.authentication.model.User;
import com.instagram.authentication.view.inputhandler.UserInputHandler;
import com.instagram.scanner.SingletonScanner;
import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * <p>
 * Managing user account operations.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */

public class UserAccountView {

    private static UserAccountView profileView;
    private static Logger logger;
    private final UserInputHandler userInformationHandler;
    private final Scanner scanner;
    private final UserAccountController userAccountController;

    /**
     * <p>
     * Private constructor to initialize necessary components for account creation.
     * </p>
     */
    private UserAccountView() {
        userAccountController = UserAccountController.getInstance();
        userInformationHandler = UserInputHandler.getInstance();
        scanner = SingletonScanner.getInstance().getScanner();
        logger = Logger.getLogger(UserAccountView.class);
    }

    /**
     * <p>
     * Create a singleton instance of UserAccountView class if it is not already created.
     * </p>
     *
     * @return Singleton instance of UserAccountView class.
     */
    public static UserAccountView getInstance() {
        return profileView == null ? profileView = new UserAccountView() : profileView;
    }

    /**
     * <p>
     * Displays the account creation page and allows the user to create an account.
     * </p>
     */
    public User createProfile(){
        final User user = new User();

        user.setName(userInformationHandler.getName());
        user.setPassword(userInformationHandler.getPassword());
        userInformationHandler.getMobileOrEmail(user);

        return userAccountController.createProfile(user) ? user : null;
    }

    /**
     * <p>
     * Redirects to the authentication page if the back symbol is entered.
     * </p>
     */
    public void back(final String symbol) {
        if (symbol.matches("^#")) {
            AuthenticationView.getInstance().authentication();
        }
    }
}
