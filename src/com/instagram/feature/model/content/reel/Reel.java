package com.instagram.feature.model.content.reel;

import java.time.Instant;

/**
 * <p>
 * Hold the reel details of the user.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class Reel {

    public int likes;
    private String author;
    private String caption;
    private boolean isPrivate;
    private int reelId;
    private Instant timeStamp;
    private int views;
    private int comments;
    private int share;

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

    public int getReelId() {
        return reelId;
    }

    public void setReelId(int reelId) {
        this.reelId = reelId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp() {
        this.timeStamp = Instant.now();
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(final int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(final int comments) {
        this.comments = comments;
    }

    public int getShare() {
        return share;
    }

    public void setShare(final int share) {
        this.share = share;
    }
}
