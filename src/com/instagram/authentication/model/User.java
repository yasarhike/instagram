package com.instagram.authentication.model;

/**
 * <p>
 * Hold the information about the user.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class User {

    private int userId;
    private String name;
    private String mobileNumber;
    private String email;
    private String password;
    private Address address;
    private int follows;
    private int followed;
    private int post;
    private int reels;
    private int story;

    public User() {
        this.address = new Address();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(final String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String userName) {
        this.name = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public int getFollowed() {
        return followed;
    }

    public void setFollowed(final int followed) {
        this.followed = followed;
    }

    public int getFollows() {
        return follows;
    }

    public void setFollows(final int follows) {
        this.follows = follows;
    }

    public int getPost() {
        return post;
    }

    public void setPost(final int post) {
        this.post = post;
    }

    public int getReels() {
        return reels;
    }

    public void setReels(final int reels) {
        this.reels = reels;
    }

    public int getStory() {
        return story;
    }

    public void setStory(final int story) {
        this.story = story;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(final int userId) {
        this.userId = userId;
    }
}
