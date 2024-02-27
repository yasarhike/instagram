package com.instagram.feature.model.content.post;

import com.instagram.feature.service.content.contentactivity.media.Media;

/**
 * <p>
 * Holds the post details of the user.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class Post {

    private String caption;
    private Media type;
    private boolean isPrivate;
    private int postId;
    private int userId;

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(final boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(final String caption) {
        this.caption = caption;
    }

    public Media getType() {
        return type;
    }

    public void setType(final Media type) {
        this.type = type;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(final int postId) {
        this.postId = postId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
}
