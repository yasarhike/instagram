package com.instagram.feature.service.follow;

/**
 * <p>
 * Interface for managing user followers.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public interface Follow {

    /**
     * <p>
     * Adds a follower for the specified user.
     * </p>
     *
     * @param userId     Refers the userId of the user to follow.
     * @param followerId Refers the followerId of the follower.
     * @return True if the follower is added successfully, otherwise false.
     */
    public boolean addFollower(final Integer userId, final Integer followerId);

    /**
     * <p>
     * Removes a follower for the specified user.
     * </p>
     *
     * @param userId     Refers the userId of the user to unfollow.
     * @param followerId Refers the followerId of the follower to be removed.
     * @return True if the follower is removed successfully, otherwise false.
     */
    public boolean removeFollower(final Integer userId, final Integer followerId);
}
