package com.instagram.feature.service.content.contentactivity.media;

public enum Media {
   IMAGE(1), VIDEO(2);

    private final int id;

    Media(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Media getMedia(final int id) {
        return switch (id) {
            case 1 -> IMAGE;
            case 2 -> VIDEO;
            default -> null;
        };
    }
}

