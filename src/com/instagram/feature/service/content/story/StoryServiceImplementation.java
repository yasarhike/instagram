package com.instagram.feature.service.content.story;

import com.instagram.feature.model.content.story.Story;
import com.instagram.feature.service.content.ContentServiceImplementation;

import java.util.Map;

/**
 * <p>
 * Implementation class for managing story.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class StoryServiceImplementation {

    private static StoryServiceImplementation storyServiceImplementation;
    private final ContentServiceImplementation<Story> storyService;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private StoryServiceImplementation() {
        storyService = new ContentServiceImplementation<>();
    }

    /**
     * <p>
     * Returns the singleton instance of StoryServiceImplementation class.
     * </p>
     *
     * @return The singleton instance of StoryServiceImplementation class.
     */
    public static StoryServiceImplementation getInstance() {
        return storyServiceImplementation == null ? storyServiceImplementation = new StoryServiceImplementation()
                : storyServiceImplementation;
    }

    /**
     * <p>
     * Adds a story for the specified user.
     * </p>
     *
     * @param story  Refer to the {@link Story} of the user.
     * @param userId Refer the userId of the user adding the story.
     * @return True if the story is added successfully, otherwise false.
     */
    public boolean addStory(final Story story, final Integer userId) {
        story.setTimeStamp();
        story.setStoryId(ContentServiceImplementation.getContentCount());
        return storyService.add(story, userId);
    }

    /**
     * <p>
     * Removes a reel with the specified ID for the specified user.
     * </P>
     *
     * @param storyId Refer to id of the story.
     * @param userId  Refer the userId of the user removing the story.
     * @return True if the story is removed successfully, otherwise false.
     */
    public boolean removeStory(final int storyId, final Integer userId) {
        return storyService.remove(storyId, userId);
    }

    /**
     * <p>
     * Retrieves all story.
     * </p>
     *
     * @return Map contains the user story.
     */
    public Map<Integer, Map<Integer, Story>> getStory() {
        return storyService.getContent();
    }
}
