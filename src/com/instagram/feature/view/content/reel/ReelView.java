package com.instagram.feature.view.content.reel;

import com.instagram.authentication.model.User;
import com.instagram.feature.controller.content.reel.ReelController;
import com.instagram.feature.model.content.reel.Reel;
import com.instagram.feature.view.content.Content;
import com.instagram.feature.view.content.post.userinputhandler.UserInformationHandler;
import com.instagram.feature.view.home.PostManager;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * <p>
 * Represents the view for managing reels.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class ReelView extends Content {

    private static ReelView reelView;
    private final UserInformationHandler userInformationHandler;
    private final ReelController reelController;
    private final Logger logger;

    /**
     * <p>
     * Private constructor to restrict the object creation outside of the class.
     * </p>
     */
    private ReelView() {
        reelController = ReelController.getInstance();
        userInformationHandler = UserInformationHandler.getInstance();
        logger = Logger.getLogger(ReelView.class);
    }

    /**
     * <p>
     * Returns the singleton instance of ReelView class.
     * </p>
     *
     * @return The singleton instance of ReelView class.
     */
    public static ReelView getInstance() {
        return reelView == null ? reelView = new ReelView() : reelView;
    }

    /**
     * <p>
     * Adds a new reel.
     * </p>
     *
     * @param user Refers to the {@link User}.
     */
    public void add(User user) {
        final Reel reel = new Reel();

        reel.setAuthor(user.getName());
        reel.setCaption(userInformationHandler.getCaption());
        reel.setPrivate(userInformationHandler.getIsPrivate());

        if (reelController.addReel(reel, user.getUserId())) {
            user.setReels(user.getReels() + 1);

            logger.debug("Reel added successful");
            PostManager.getInstance().post(user);
        } else {

            logger.debug("Operation failed");
            PostManager.getInstance().post(user);
        }
    }

    /**
     * <p>
     * Deletes a new post.
     * </p>
     *
     * @param user Refers to the {@link User}.
     */
    public void delete(User user) {
        final int postId = userInformationHandler.getPostId();

        if (reelController.removeReel(postId, user.getUserId())) {
            user.setReels(user.getReels() - 1);

            logger.debug("Post removed successful");
            PostManager.getInstance().post(user);
        } else {
            logger.debug("operation failed");
            PostManager.getInstance().post(user);
        }
    }
}
