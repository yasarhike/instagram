package com.instagram.feature.controller.content.story;

import com.instagram.feature.model.content.story.Story;
import com.instagram.feature.service.content.story.StoryServiceImpl;
import com.instagram.feature.service.content.story.dao.StoryServiceDAOImpl;

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
    private final StoryServiceDAOImpl storyServiceDAOImpl;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private StoryController() {
        storyServiceDAOImpl = StoryServiceDAOImpl.getInstance();
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
        return storyServiceDAOImpl.addStory(story, userId);
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
        return false;
    }

}
