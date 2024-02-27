package com.instagram.authentication.service.dao;

import com.instagram.authentication.model.User;

import java.sql.SQLException;

public interface UserAccountDAO {

    public boolean createProfile(final User user) throws SQLException;

    public User getProfile(final String mobileOrEmail, final int id, final String password, final String type);
}
