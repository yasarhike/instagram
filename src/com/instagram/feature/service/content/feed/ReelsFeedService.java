package com.instagram.feature.service.content.feed;

import com.instagram.feature.model.content.contentactivity.Comment;
import com.instagram.feature.model.content.reel.Reel;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Interface for managing generic service operations.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public interface ReelsFeedService {

    Map<Integer, Map<Integer, Reel>> getReels();
    List<Comment> getComment(final int postId);
}
