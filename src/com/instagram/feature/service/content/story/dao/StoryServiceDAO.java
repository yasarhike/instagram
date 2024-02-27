package com.instagram.feature.service.content.story.dao;

import com.instagram.feature.model.content.story.Story;

public interface StoryServiceDAO {
    boolean addStory(final Story story, final Integer userId);
}
