package com.mensarb.onboarder.models;

import android.support.annotation.ColorInt;
import android.support.annotation.FontRes;

/**
 * @author dkoller
 * @since 18.10.2017
 */

public class Page {

    @ColorInt private int backgroundColor;
    private int image;
    private int imageHeight;
    private String imageIcon;
    @ColorInt private int imageIconColor;
    private float imageIconTextSize;
    @FontRes private int imageIconTypefaceResource;
    private String imageIconTypefaceAsset;
    private String title;
    @ColorInt private int titleColor;
    private float titleTextSize;
    private String description;
    @ColorInt private int descriptionColor;
    private float descriptionTextSize;

    private Page(Builder builder){
        backgroundColor = builder.backgroundColor;
        image = builder.image;
        imageHeight = builder.imageHeight;
        imageIcon = builder.imageIcon;
        imageIconColor = builder.imageIconColor;
        imageIconTextSize = builder.imageIconTextSize;
        imageIconTypefaceResource = builder.imageIconTypefaceResource;
        imageIconTypefaceAsset = builder.imageIconTypefaceAsset;
        title = builder.title;
        titleColor = builder.titleColor;
        titleTextSize = builder.titleTextSize;
        description = builder.description;
        descriptionColor = builder.descriptionColor;
        descriptionTextSize = builder.descriptionTextSize;
    }

    @ColorInt
    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getImage() {
        return image;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public String getImageIcon() {
        return imageIcon;
    }

    @ColorInt
    public int getImageIconColor() {
        return imageIconColor;
    }

    public float getImageIconTextSize() {
        return imageIconTextSize;
    }

    @FontRes
    public int getImageIconTypefaceResource() {
        return imageIconTypefaceResource;
    }

    public String getImageIconTypefaceAsset() {
        return imageIconTypefaceAsset;
    }

    public String getTitle() {
        return title;
    }

    @ColorInt
    public int getTitleColor() {
        return titleColor;
    }

    public String getDescription() {
        return description;
    }

    @ColorInt
    public int getDescriptionColor() {
        return descriptionColor;
    }

    public float getTitleTextSize() {
        return titleTextSize;
    }

    public float getDescriptionTextSize() {
        return descriptionTextSize;
    }

    public static class Builder {

        @ColorInt private int backgroundColor;
        private int image;
        private int imageHeight;
        private String imageIcon;
        @ColorInt private int imageIconColor;
        private float imageIconTextSize;
        @FontRes private int imageIconTypefaceResource;
        private String imageIconTypefaceAsset;
        private String title;
        @ColorInt private int titleColor;
        private float titleTextSize;
        private String description;
        @ColorInt private int descriptionColor;
        private float descriptionTextSize;

        public Builder backgroundColor(@ColorInt int color){
            this.backgroundColor = color;
            return this;
        }

        public Builder image(int resourceId){
            this.image = resourceId;
            return this;
        }

        /**
         * @param height in [dp]
         */
        public Builder imageHeight(int height){
            this.imageHeight = height;
            return this;
        }

        /**
         * @param size in [sp]
         * @param fontRes id of typeface in font res folder
         */
        public Builder image(String icon, @ColorInt int color, float size, @FontRes int fontRes){
            this.imageIcon = icon;
            this.imageIconColor = color;
            this.imageIconTextSize = size;
            this.imageIconTypefaceResource = fontRes;
            return this;
        }

        /**
         * @param size in [sp]
         * @param fontName name of typeface in asset folder
         */
        public Builder image(String icon, @ColorInt int color, float size,String fontName){
            this.imageIcon = icon;
            this.imageIconColor = color;
            this.imageIconTextSize = size;
            this.imageIconTypefaceAsset = fontName;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder titleColor(@ColorInt int color){
            this.titleColor = color;
            return this;
        }

        /**
         * @param size in [sp]
         */
        public Builder titleTextSize(float size){
            this.titleTextSize = size;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder descriptionColor(@ColorInt int color){
            this.descriptionColor = color;
            return this;
        }

        /**
         * @param size in [sp]
         */
        public Builder descriptionTextSize(float size){
            this.descriptionTextSize = size;
            return this;
        }

        public Page build(){
            return new Page(this);
        }
    }
}
