package com.instagram.feature.model.content.post;

import java.time.Instant;

/**
 * <p>
 * Holds the post details of the user.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class Post {

    private String author;
    private String caption;
    private String type;
    private boolean isPrivate;
    private Instant timestamp;
    private int postId;
    private int likes;
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

    public String getCaption() {
        return caption;
    }

    public void setCaption(final String caption) {
        this.caption = caption;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp() {
        this.timestamp = Instant.now();
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(final int postId) {
        this.postId = postId;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(final int comments) {
        this.comments = comments;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(final int likes) {
        this.likes = likes;
    }

    public int getShare() {
        return share;
    }

    public void setShare(final int share) {
        this.share = share;
    }
}
