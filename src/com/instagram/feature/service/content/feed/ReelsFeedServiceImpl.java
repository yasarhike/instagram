package com.instagram.feature.service.content.feed;

import com.instagram.feature.model.content.contentactivity.Comment;
import com.instagram.feature.model.content.reel.Reel;
import com.instagram.feature.service.content.reel.ReelServiceImpl;
import com.instagram.feature.service.content.contentactivity.ReelCommentServiceImpl;

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
public class ReelsFeedServiceImpl {

    private static ReelsFeedServiceImpl reelsManagerService;
    private final ReelServiceImpl reelServiceImpl;
    private final ReelCommentServiceImpl reelCommentService;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private ReelsFeedServiceImpl() {
        reelServiceImpl = ReelServiceImpl.getInstance();
        reelCommentService = ReelCommentServiceImpl.getInstance();
    }

    /**
     * <p>
     * Returns the singleton instance of ReelFeedController class.
     * </p>
     *
     * @return The singleton instance of ReelFeedController class.
     */
    public static ReelsFeedServiceImpl getInstance() {
        return reelsManagerService == null ? reelsManagerService = new ReelsFeedServiceImpl() : reelsManagerService;
    }

    /**
     * <p>
     * Retrieves all reels from the reel service.
     * </p>
     *
     * @return A map containing reels, where the key is the post ID and the value is a map containing comments, where the key is the comment ID and the value is the comment object.
     */
    public Map<Integer, Map<Integer, Reel>> getReels() {
        return reelServiceImpl.getReel();
    }

    /**
     * <p>
     * Retrieves comments associated with the specified post ID from the reel comment service.
     * </p>
     *
     * @param postId The ID of the post for which comments are to be retrieved.
     * @return A list of comments associated with the specified post ID.
     */
    public List<Comment> getComment(final int postId) {
        return reelCommentService.get(postId);
    }
}
