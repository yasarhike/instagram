package com.instagram.feature.view.content.story;

import com.instagram.authentication.model.User;
import com.instagram.feature.controller.content.story.StoryController;
import com.instagram.feature.model.content.story.Story;
import com.instagram.feature.view.content.Content;
import com.instagram.feature.view.content.post.userinputhandler.UserInformationHandler;
import com.instagram.feature.view.home.PostManager;

/**
 * <p>
 * Represents the view for managing story.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class StoryView extends Content {

    private static StoryView storyView;
    private final UserInformationHandler userInformationHandler;
    private final StoryController storyController;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private StoryView() {
        storyController = StoryController.getInstance();
        userInformationHandler = UserInformationHandler.getInstance();
    }

    /**
     * <p>
     * Returns the singleton instance of StoryView class.
     * </p>
     *
     * @return The singleton instance of StoryView class.
     */
    public static StoryView getInstance() {
        return storyView == null ? storyView = new StoryView() : storyView;
    }

    /**
     * <p>
     * Adds a new story.
     * </p>
     *
     * @param user Refers to the {@link User}.
     */
    public void add(User user) {

        final Story story = new Story();

        story.setAuthor(user.getName());
        story.setPrivate(userInformationHandler.getIsPrivate());

        if (storyController.addStory(story, user.getUserId())) {
            user.setStory(user.getStory() + 1);
            System.out.println("Story added successful");
            PostManager.getInstance().post(user);
        } else {
            System.out.println("Operation failed");
            PostManager.getInstance().post(user);
        }
    }

    /**
     * <p>
     * Deletes a story.
     * </p>
     *
     * @param user Refers to the {@link User}.
     */
    public void delete(User user) {
        final int storyId = userInformationHandler.getPostId();

        if (storyController.removeStory(storyId, user.getUserId())) {
            user.setStory(user.getStory() - 1);
            System.out.println("story removed successful");
            PostManager.getInstance().post(user);
        } else {
            System.out.println("operation failed");
            contentHomePage(user);
        }
    }
}
