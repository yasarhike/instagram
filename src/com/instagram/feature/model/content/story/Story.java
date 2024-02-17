package com.instagram.feature.model.content.story;

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

    private String author;
    private boolean isPrivate;
    private int storyId;
    private Instant timeStamp;

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(final boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public int isStoryId() {
        return storyId;
    }

    public void setStoryId(final int storyId) {
        this.storyId = storyId;
    }

    public void setTimeStamp() {
        this.timeStamp = Instant.now();
    }
}
