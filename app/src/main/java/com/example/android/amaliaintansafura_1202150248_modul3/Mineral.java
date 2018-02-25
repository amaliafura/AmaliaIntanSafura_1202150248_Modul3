package com.example.android.amaliaintansafura_1202150248_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by Amalia Intan Safura on 2/25/2018.
 */

public class Mineral {
    private String title;
    private String info;
    private final int imageResource;

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "Image Resource";

    /**
     * Constructor for the Sport data model
     *
     * @param title         The name if the sport.
     * @param info          Information about the sport.
     * @param imageResource The resource for the sport image
     */
    Mineral(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }
    /**
     * Gets the title of the sport
     * @return The title of the sport.
     */
    String getTitle() {
        return title;
    }
    /**
     * Gets the info about the sport
     * @return The info about the sport.
     */
    String getInfo() {
        return info;
    }
    public static Intent starter(Context context, String title, @DrawableRes int imageResId) {
        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra(TITLE_KEY, title);
        detailIntent.putExtra(IMAGE_KEY, imageResId);
        return detailIntent;

    }
}
