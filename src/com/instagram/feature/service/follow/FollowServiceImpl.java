package com.instagram.feature.service.follow;

import com.instagram.authentication.service.UserAccountServiceImplementation;

import java.util.*;

/**
 * <p>
 * Service class for managing user followers.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class FollowServiceImpl implements Follow {

    private static FollowServiceImpl followServiceImpl;
    private final Map<Integer, List<Integer>> followers;
    private final UserAccountServiceImplementation userServiceImplementation;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private FollowServiceImpl() {
        followers = new HashMap<>();
        userServiceImplementation = UserAccountServiceImplementation.getInstance();
    }

    /**
     * <p>
     * Returns the singleton instance of FollowService class.
     * </p>
     *
     * @return The singleton instance of FollowService class.
     */
    public static FollowServiceImpl getInstance() {
        return followServiceImpl == null ? followServiceImpl = new FollowServiceImpl() : followServiceImpl;
    }

    /**
     * <p>
     * Adds a follower for the specified user.
     * </p>
     *
     * @param userId     Refers the userUd of the user to follow.
     * @param followerId Refers the followerId of the follower.
     * @return True if the follower is added successfully, otherwise false.
     */
    public boolean addFollower(final Integer userId, final Integer followerId) {
        if (!userServiceImplementation.isUserExists(followerId) || Objects.equals(userId, followerId)
                || followers.containsKey(userId) && !followers.get(userId).contains(followerId)) {
            return false;
        }

        return followers.computeIfAbsent(userId, k -> new ArrayList<>()).add(followerId);

    }

    /**
     * <p>
     * Removes a follower for the specified user.
     * </p>
     *
     * @param userId     Refers the userId of the user to unfollow.
     * @param followerId Refers the followerId of the follower to be removed.
     * @return True if the follower is removed successfully, otherwise false.
     */
    public boolean removeFollower(final Integer userId, final Integer followerId) {
        return userServiceImplementation.isUserExists(followerId) && (followers.containsKey(followerId) &&
                followers.get(userId).contains(followerId)) && followers.get(userId).remove(followerId);
    }
}
