package com.instagram.authentication.controller;

import com.instagram.authentication.model.User;
import com.instagram.authentication.service.UserAccountServiceImplementation;
import com.instagram.authentication.service.dao.UserAccountDAOImpl;

/**
 * <p>
 * Represents the controller for managing user accounts.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class UserAccountController {

    private static UserAccountController profileController;
    private final UserAccountDAOImpl userAccountDAOImpl;

    /**
     * <p>
     * Private constructor to restrict object creation outside the class.
     * </p>
     */
    private UserAccountController() {
        userAccountDAOImpl = UserAccountDAOImpl.getInstance();
    }

    /**
     * <p>
     * Returns the singleton instance of UserAccountController class.
     * </p>
     *
     * @return Singleton instance of UseAccountController class.
     */
    public static UserAccountController getInstance() {
        return profileController == null ? profileController = new UserAccountController() : profileController;
    }

    /**
     * <p>
     * Invokes the service createProfile method to create a new user profile.
     * </p>
     *
     * @param user Refers the {@link User} object representing the user profile to be created.
     * @return True if the user profile is successfully created, otherwise false.
     */
    public boolean createProfile(final User user) {
        return userAccountDAOImpl.createProfile(user);
    }

    /**
     * <p>
     * Invokes the service to get a user.
     * </p>
     *
     * @param mobileOrEmail Refers to the mobile number, email of the user.
     * @param id            Refers to the ID of the user.
     * @param password      Refers to the password of the user.
     * @param type          Refers to the type of key (e.g., "mobile", "userId", etc.).
     * @return {@link User} Return the user profile if the data is correct, otherwise null.
     */

}
