package com.instagram.authentication.view;

import com.instagram.authentication.controller.UserAccountController;
import com.instagram.authentication.model.User;
import com.instagram.authentication.view.inputhandler.UserInputHandler;
import org.apache.log4j.LogManager;
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
    private final UserAccountController userProfileController;

    /**
     * <p>
     * Private constructor to initialize necessary components for account creation.
     * </p>
     */
    private UserAccountView() {
        this.userProfileController = UserAccountController.getInstance();
        this.userInformationHandler = UserInputHandler.getInstance();
        this.scanner = new Scanner(System.in);
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
    public User createProfile() {
        final User user = new User();

        user.setName(userInformationHandler.getName());
        user.setPassword(userInformationHandler.getPassword());
        userInformationHandler.getMobileOrEmail(user);

        return userProfileController.createProfile(user) ? user : null;
    }

    /**
     * <p>
     * Allows the user to get the user profile.
     * </p>
     */
    public User getProfile() {
        int userChoice = 0;
        String password = "";

        try {
            logger.info("Press 1 - MobileOrEmail\nPress 2 - UserId");
            userChoice = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException exception) {
            logger.error("Enter the valid input");
            getProfile();
        }

        switch (userChoice) {
            case 1:
                logger.info("Enter the mobile or email");
                final String mobileOrEmail = scanner.nextLine();

                password = userInformationHandler.getPassword();

                return userProfileController.getProfile(mobileOrEmail, 0, password, "mobileOrEmail");
            case 2:
                logger.info("Enter the id :");
                final int id = Integer.parseInt(scanner.nextLine());

                password = userInformationHandler.getPassword();

                return userProfileController.getProfile(null, id, password, "mobileOrEmail");
            case 3:
                System.exit(0);
            default:
                getProfile();
        }
        return null;
    }

    /**
     * <p>
     * Allows the user to update the profile.
     * </p>
     */
    public void updateProfile(final User user) {
        int userChoice = 0;

        try {
            logger.info("Press 1 - Edit name\nPress 2 - Edit mobile\nPress 3 - Edit password\nPress 4 - Edit email");
            userChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            logger.error("Enter the valid input");
            updateProfile(user);
        }

        switch (userChoice) {
            case 1 -> {
                final String newName = userInformationHandler.getName();
                userProfileController.updateProfile("name", newName, user);
            }
            case 2 -> {
                final String newEmail = userInformationHandler.getEmail();
                userProfileController.updateProfile("email", newEmail, user);
            }
            case 3 -> {
                final String newPassword = userInformationHandler.getPassword();
                userProfileController.updateProfile("password", newPassword, user);
            }
            case 4 -> {
                final String newMobileNumber = userInformationHandler.getMobile(user);
                userProfileController.updateProfile("mobile", user.getMobileNumber(), user);
            }
            default -> {
            }
        }
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
