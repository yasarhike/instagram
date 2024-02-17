package com.instagram.feature.controller.content.story;

import com.instagram.feature.model.content.story.Story;
import com.instagram.feature.service.content.story.StoryServiceImplementation;

import java.util.Map;

/**
 * <p>
 * Implementation of the StoryController class for managing story.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class StoryController {

    private static StoryController storyController;
    private final StoryServiceImplementation storyService;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private StoryController() {
        storyService = StoryServiceImplementation.getInstance();
    }

    /**
     * <p>
     * Returns the singleton instance of StoryController class.
     * </p>
     *
     * @return The singleton instance of StoryController class.
     */
    public static StoryController getInstance() {
        return storyController == null ? storyController = new StoryController() : storyController;
    }

    /**
     * <p>
     * Adds a story for the specified user.
     * </p>
     *
     * @param story  Refer to the {@link Story} of the user.
     * @param userId The userId of the user adding the story.
     * @return True if the story is added successfully, otherwise false.
     */
    public boolean addStory(final Story story, final Integer userId) {
        return storyService.addStory(story, userId);
    }

    /**
     * <p>
     * Removes a reel with the specified ID for the specified user.
     * </P>
     *
     * @param storyId Refer to id of the story.
     * @param userId  The userId of the user removing the story.
     * @return True if the story is removed successfully, otherwise false.
     */
    public boolean removeStory(final Integer storyId, final Integer userId) {
        return storyService.removeStory(storyId, userId);
    }

    /**
     * <p>
     * Retrieves all story.
     * </p>
     *
     * @return Map contains the user story.
     */
    public Map<Integer, Map<Integer, Story>> getStory() {
        return storyService.getStory();
    }
}
