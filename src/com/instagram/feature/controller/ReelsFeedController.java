package com.instagram.feature.controller;

import com.instagram.feature.model.content.contentactivity.Comment;
import com.instagram.feature.model.content.reel.Reel;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Controller class responsible for managing reels feed.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class ReelsFeedController {

    private static ReelsFeedController reelsManagerController;
    private final com.instagram.feature.service.ReelsFeedController reelsManagerService;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private ReelsFeedController() {
        reelsManagerService = com.instagram.feature.service.ReelsFeedController.getInstance();
    }

    /**
     * <p>
     * Returns the singleton instance of ReelFeedController class.
     * </p>
     *
     * @return The singleton instance of ReelFeedController class.
     */
    public static ReelsFeedController getInstance() {
        return reelsManagerController == null ? reelsManagerController = new ReelsFeedController() : reelsManagerController;
    }

    /**
     * <p>
     * Gets the reels for all user.
     * </p>
     */
    public Map<Integer, Map<Integer, Reel>> getReels() {
        return reelsManagerService.getReels();
    }


    /**
     * <p>
     * Gets the comments for all user.
     * </p>
     */
    public List<Comment> getComment(final int postId) {
        return reelsManagerService.getComment(postId);
    }
}
