package com.instagram.feature.service.content.story;

import com.instagram.feature.model.content.story.Story;

/**
 * <p>
 * managing story service operation.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public interface StoryService {

    boolean addStory(final Story story, final Integer userId);

    boolean removeStory(final int storyId, final Integer userId);
}
