package com.instagram.feature.service.content.reel;

import com.instagram.feature.model.content.reel.Reel;

/**
 * <p>
 * Managing reels service operation.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public interface ReelService {

    boolean addReel(final Reel reel, final Integer userId);

    boolean removeReel(final int reelId, final Integer userId);
}
