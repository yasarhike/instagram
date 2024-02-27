package com.instagram.feature.service.content.post;

import com.instagram.feature.model.content.post.Post;

/**
 * <p>
 * Managing post service operations.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public interface PostService {

    boolean addPost(final Post post, final Integer userId);

    boolean removePost(final int postId, final Integer userId);
}
