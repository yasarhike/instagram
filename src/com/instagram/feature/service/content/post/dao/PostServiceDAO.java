package com.instagram.feature.service.content.post.dao;

import com.instagram.feature.model.content.post.Post;

public interface PostServiceDAO {

    boolean addPost(final Post post);
    boolean removePost(final int postId, final Integer userId);
}
