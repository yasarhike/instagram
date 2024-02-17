package com.instagram.authentication.view.inputhandler;

import com.instagram.authentication.model.User;
import com.instagram.authentication.view.UserAccountView;
import com.instagram.authentication.model.Country;
import com.instagram.scanner.SingletonScanner;
import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * <p>
 * Contains methods for handling user input related to user information.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class UserInputHandler {

    private static UserInputHandler userInformationHandler;
    public final Logger logger;
    private final Scanner scanner;

    /**
     * <p>
     * Private constructor to initialize the scanner for user input handling.
     * </P>
     */
    private UserInputHandler() {
        scanner = SingletonScanner.getInstance().getScanner();
        logger = Logger.getLogger(UserInputHandler.class);
    }

    /**
     * <p>
     * Returns the singleton instance of UserInformationHandler class.
     * </P>
     *
     * @return The singleton instance of UserInformationHandler class.
     */
    public static UserInputHandler getInstance() {
        return userInformationHandler == null
                ? userInformationHandler = new UserInputHandler() : userInformationHandler;
    }

    /**
     * <p>
     * Checks if the country code exists in the provided mobile number.
     * </p>
     *
     * @param mobile The mobile number to check for the existence of the country code.
     * @return The country code if found in the mobile number, otherwise null.
     */
    public static String isCodeExists(final String mobile) {
        int index = 0;

        while (index < mobile.length() && index < 13) {
            if (Country.country.containsKey(mobile.substring(0, index))) {
                if (mobile.substring(index).matches(Country.country.get(mobile.substring(0, index)).getCode())) {
                    return mobile.substring(0, index);
                }
            }
            index++;
        }
        return null;
    }

    /**
     * <p>
     * Gets the user name and validates it.
     * </p>
     *
     * @return Name of the user.
     */
    public String getName() {
        logger.info("Enter the name (name length should between 1-30 and symbols like !@#$% are not allowed) - (enter # for back)");
        final String name = scanner.nextLine().trim();

        UserAccountView.getInstance().back(name);

        return name.matches("^[a-zA-Z0-9]+(?: [a-zA-Z0-9]+)*$") ? name : getName();
    }

    /**
     * <p>
     * Gets the user email and validate it.
     *
     * @return Email of the user.
     */
    public String getPassword() {
        logger.info("Enter the password (password should contain atleast one Uppercase, lowercase and digits) - (enter # for back)");
        final String password = scanner.nextLine().trim();

        UserAccountView.getInstance().back(password);

        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$") || password.equals("#")
                ? password : getPassword();
    }

    /**
     * <p>
     * Gets the user password and validate it.
     * </p>
     *
     * @return Password of the user.
     */
    private String getCountry() {
        logger.info("Enter the country : (available country are india, australia and algeria) - (enter # for back)");
        final String country = scanner.nextLine().trim().toLowerCase();

        UserAccountView.getInstance().back(country);

        return Country.country.get(country).getName().equalsIgnoreCase(country)
                && country.matches("[A-Za-z]{2,30}") ? country : getCountry();
    }

    /**
     * <p>
     * Gets the country code and validate it.
     * </p>
     *
     * @return Door number of the user.
     */

    private String getDoorNumber() {
        logger.info("Enter the door number  - (enter # for back)");
        final String doorNumber = scanner.nextLine();

        UserAccountView.getInstance().back(doorNumber);

        return doorNumber.matches("[0-9]{1,4}") ? doorNumber : getDoorNumber();
    }

    /**
     * <p>
     * Gets the user state and validate it.
     * </p>
     *
     * @param code Refers the country code of the user.
     * @return State of the user.
     */
    private String getState(final String code) {
        logger.info("Enter the state :  - (enter # for back)");
        System.out.println(Country.country.get(code).getState());
        final String state = scanner.nextLine().trim().toLowerCase();

        UserAccountView.getInstance().back(state);

        return Country.country.get(code).getState().contains(state)
                && state.matches("[a-zA-Z]{2,30}") ? state : getState(code);
    }

    /**
     * <p>
     * Gets the user street name and validate it.
     * </p>
     *
     * @param code Refers the country code of the user.
     * @return Street name of the user.
     */
    private String getStreetName(final String code) {
        logger.info("Enter the street name : (Empty value is not allowed)  - (enter # for back)");
        final String street = scanner.nextLine().trim().toLowerCase();

        UserAccountView.getInstance().back(street);

        return street.matches("[a-zA-Z]+") ? street : getStreetName(code);
    }

    /**
     * <p>
     * Gets the user country.
     * </p>
     *
     * @param code Country code of the user.
     * @return Country of the user.
     */
    private String getCountry(final String code) {

        return Country.country.containsKey(code) ? Country.country.get(code).getName() : getCountry();
    }

    /**
     * <p>
     * Gets all the detail of the user if the user choice is mobile.
     * </p>
     *
     * @param user Refers the {@link User}
     */

    public void getDetailsForMobile(final User user) {
        user.getAddress().setCountry(getCountry(user.getAddress().getCountryCode()));
        user.getAddress().setState(getState(user.getAddress().getCountryCode()));
        user.getAddress().setDoorNumber(getDoorNumber());
        user.getAddress().setStreetName(getStreetName(user.getAddress().getCountryCode()));
    }

    /**
     * <p>
     * Gets all the detail of the user if the user choice is mail.
     * </p>
     *
     * @param user Refers the {@link User}.
     */
    public void getDetailsForEmail(final User user) {
        user.getAddress().setCountry(getCountry());
        user.getAddress().setState(getState(user.getAddress().getCountry()));
        user.getAddress().setDoorNumber(getDoorNumber());
        user.getAddress().setStreetName(getStreetName(user.getAddress().getCountry()));
    }

    /**
     * <p>
     * Gets the user choice to enter either a mobile number or an email and directs to appropriate actions.
     * </p>
     *
     * @param user The user for whom the mobile number or email is being entered.
     */
    public void getMobileOrEmail(final User user) {
        logger.info("Enter the mobile or email (Note: for mobile enter with country code available are india(91) australia(61) algeria(213) )");
        final String mobileOrEmail = scanner.nextLine();

        if (isInputEmail(mobileOrEmail, user)) {
            getDetailsForEmail(user);
        } else if (isInputMobile(mobileOrEmail, user)) {
            getDetailsForMobile(user);
        } else {
            getMobileOrEmail(user);
        }
    }

    /**
     * Checks if the input string matches the format of an email and sets it for the user if so.
     *
     * @param mobileOrEmail The input string to be checked.
     * @param user          The user for whom the email is being set.
     * @return True if the input string is in email format, otherwise false.
     */
    public boolean isInputEmail(final String mobileOrEmail, final User user) {
        if (mobileOrEmail.matches("[a-zA-Z0-9.]+@[a-zA-Z0-9]+([.][a-zA-Z]+)+")) {
            user.setEmail(mobileOrEmail);
            return true;
        }
        return false;
    }

    /**
     * Checks if the input string matches the format of a mobile number, sets it for the user along with the country code if so.
     *
     * @param mobileOrEmail The input string to be checked.
     * @param user          The user for whom the mobile number is being set.
     * @return True if the input string is in mobile number format, otherwise false.
     */
    public boolean isInputMobile(final String mobileOrEmail, final User user) {

        if (mobileOrEmail.matches("\\d+")) {
            final String element = isCodeExists(mobileOrEmail);
            if (element == null) {
                return false;
            } else {
                final String mobileNumber = mobileOrEmail.substring(element.length());
                user.setMobileNumber(mobileNumber);
                user.getAddress().setCountryCode(element);
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the email address and validates it.
     *
     * @return The validated email address.
     */
    public String getEmail() {
        logger.info("Enter the mail :  - (enter # for back)");
        final String newEmail = scanner.nextLine();

        return newEmail.matches("[a-zA-Z0-9.]+@[a-zA-Z0-9]+([.][a-zA-Z]+)+") ? newEmail : getEmail();
    }

    /**
     * <p>
     * Gets the  mobile number and validates it against the country code.
     * </p>
     *
     * @param user The user for whom the mobile number is being entered.
     * @return The validated mobile number.
     */
    public String getMobile(final User user) {
        logger.info("Enter the mobile :  - (enter # for back)");
        final String newMobile = scanner.nextLine();

        return newMobile.matches(Country.country.get(user.getAddress().getCountryCode()).getCode()) ? newMobile
                : getMobile(user);
    }
}


