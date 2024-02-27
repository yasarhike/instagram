package com.instagram.feature.model.content.story;

import com.instagram.feature.service.content.contentactivity.media.Media;

import java.time.Instant;

/**
 * <p>
 * Holds the story details of the user.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class Story {

    private boolean isPrivate;
    private int storyId;
    private Media media;
    private String music;
    private String text;
    private int userId;

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(final boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public void setStoryId(final int storyId) {
        this.storyId = storyId;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
