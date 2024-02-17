package com.instagram.feature.controller.content.reel;

import com.instagram.feature.model.content.reel.Reel;
import com.instagram.feature.service.content.reel.ReelServiceImplementation;

import java.util.Map;


/**
 * <p>
 * Implementation of the ReelController class for managing reels.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class ReelController {

    private static ReelController reelController;
    private final ReelServiceImplementation reelService;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private ReelController() {
        reelService = ReelServiceImplementation.getInstance();
    }

    /**
     * <p>
     * Returns the singleton instance of ReelController class.
     * </p>
     *
     * @return The singleton instance of ReelController class.
     */
    public static ReelController getInstance() {
        return reelController == null ? reelController = new ReelController() : reelController;
    }

    /**
     * <p>
     * Adds a reel for the specified user.
     * </p>
     *
     * @param reel   Refer to the {@link Reel} of the user.
     * @param userId The userId of the user adding the post.
     * @return True if the reel is added successfully, otherwise false.
     */
    public boolean addReel(final Reel reel, final Integer userId) {
        return reelService.addReel(reel, userId);
    }

    /**
     * <p>
     * Removes a reel with the specified ID for the specified user.
     * </P>
     *
     * @param reelId Refer to reelId of the reel.
     * @param userId The userId of the user removing the reel.
     * @return True if the reel is removed successfully, otherwise false.
     */
    public boolean removeReel(final Integer reelId, final Integer userId) {
        return reelService.removeReel(reelId, userId);
    }

    /**
     * <p>
     * Retrieves all reels.
     * </p>
     *
     * @return Map contains the user reels.
     */
    public Map<Integer, Map<Integer, Reel>> getReel() {
        return reelService.getReel();
    }
}
