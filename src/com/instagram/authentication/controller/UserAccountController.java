package com.instagram.authentication.controller;

import com.instagram.authentication.model.User;
import com.instagram.authentication.service.UserAccountServiceImplementation;

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
    private final UserAccountServiceImplementation profileServiceImplementation;

    /**
     * <p>
     * Private constructor to restrict object creation outside the class.
     * </p>
     */
    private UserAccountController() {
        profileServiceImplementation = UserAccountServiceImplementation.getInstance();
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
        return profileServiceImplementation.createProfile(user);
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
    public User getProfile(final String mobileOrEmail, final int id, final String password, final String type) {
        return profileServiceImplementation.getProfile(mobileOrEmail, id, password, type);
    }

    /**
     * <p>
     * Updates the specified type of information for the given user profile.
     * </p>
     *
     * @param type     Refers to the type of information to be updated (e.g., "email", "password", etc.).
     * @param newValue Refers to the new value to be set for the specified type of information.
     * @param user     Refers to the {@link User} whose profile information is to be updated.
     */
    public void updateProfile(final String type, final String newValue, final User user) {
        profileServiceImplementation.updateProfile(type, newValue, user);
    }
}
