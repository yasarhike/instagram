package com.instagram.feature.view.content.post.userinputhandler;

import com.instagram.feature.model.content.post.Post;
import com.instagram.feature.service.content.contentactivity.media.Media;
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
public class UserInformationHandler {

    private static UserInformationHandler userInformationHandler;
    private final Scanner scanner;
    private final Logger logger;

    /**
     * <p>
     * Private constructor to initialize the scanner for user input handling.
     * </P>
     */
    private UserInformationHandler() {
        scanner = SingletonScanner.getInstance().getScanner();
        logger = Logger.getLogger(UserInformationHandler.class);
    }

    /**
     * <p>
     * Returns the singleton instance of UserInformationHandler class.
     * </P>
     *
     * @return The singleton instance of UserInformationHandler class.
     */
    public static UserInformationHandler getInstance() {
        return userInformationHandler == null ? userInformationHandler = new UserInformationHandler()
                : userInformationHandler;
    }

    /**
     * <p>
     * Get the caption and returns it.
     * </p>
     *
     * @return Caption of the post.
     */
    public String getCaption() {
        logger.info("Enter the caption :");
        return scanner.nextLine().trim();
    }

    /**
     * <p>
     * Get the type of the post.
     * </p>
     *
     * @return Type of the post.
     */
    public Media getType() {
        logger.info("Enter the type :(Press - 1 for image, Press 2 for video)");
        final Media media = Media.getMedia(Integer.parseInt(scanner.nextLine()));

        return media != null
                ? media : getType();
    }

    /**
     * <p>
     * Get the user choice to make the post private of public.
     * </p>
     *
     * @return Access of the post.
     */
    public boolean getIsPrivate() {
        logger.info("Do you want the post to be private enter yes to make it private if not press any key");
        final String isPrivate = scanner.nextLine();

        return isPrivate.equalsIgnoreCase("yes");
    }

    /**
     * <p>
     * Get the post id.
     * </p>
     *
     * @return the name of the user.
     */
    public int getPostId() {
        logger.info("Enter the post id");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getDuration() {
        logger.info("Enter the duration");
        return scanner.nextLine();
    }

    public String getMusic() {
        logger.info("Enter the music :");
        return scanner.nextLine();
    }
    /**
     * <p>
     * Get the user details.
     * </p>
     */
    public void getUserDetails(final Post post) {
        post.setCaption(getCaption());
        post.setType(getType());
        post.setPrivate(getIsPrivate());
    }
}
