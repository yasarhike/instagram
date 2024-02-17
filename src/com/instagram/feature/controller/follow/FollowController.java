package com.instagram.feature.controller.follow;

import com.instagram.feature.service.follow.FollowService;

/**
 * <p>
 * Controller class for managing user followers.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class FollowController {

    private static FollowController followController;
    private static FollowService followService;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private FollowController() {
        followService = FollowService.getInstance();
    }

    /**
     * <p>
     * Returns the singleton instance of FollowController class.
     * </p>
     *
     * @return The singleton instance of FollowController class.
     */
    public static FollowController getInstance() {
        return followController == null ? followController = new FollowController() : followController;
    }

    /**
     * <p>
     * Adds a follower for the specified user.
     * </p>
     *
     * @param followerId Refer to the follower name.
     * @param userId     Refer the userId of the user adding the story.
     * @return True if the follower is added successfully, otherwise false.
     */
    public boolean addFollower(final int userId, final int followerId) {
        return followService.addFollower(userId, followerId);
    }

    /**
     * <p>
     * Removes a follower with the specified ID for the specified user.
     * </P>
     *
     * @param followerId Refer to name of the follower.
     * @param userId     Refer the userId of the user removing the story.
     * @return True if the follower is removed successfully, otherwise false.
     */
    public boolean removeFollower(final Integer userId, final Integer followerId) {
        return followService.removeFollower(userId, followerId);
    }
}
