package com.instagram;

import com.instagram.authentication.view.AuthenticationView;

/**
 * <p>
 * Initaiates the application.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.82 6 Feb 2024
 */
public class Main {

    /**
     * <p>
     * Invoking the authentication page and start the application.
     * </p>
     */
    public static void main(String[] args) {
        AuthenticationView.getInstance().authentication();
    }
}