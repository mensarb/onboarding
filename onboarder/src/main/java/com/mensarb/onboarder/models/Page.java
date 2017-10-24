package com.mensarb.onboarder.models;

/**
 * @author dkoller
 * @since 18.10.2017
 */

public class Page {

    private int backgroundColor;
    private int image;
    private int imageHeight;
    private String imageIcon;
    private int imageIconColor;
    private float imageIconTextSize;
    private String imageIconTypeface;
    private String title;
    private int titleColor;
    private float titleTextSize;
    private String description;
    private int descriptionColor;
    private float descriptionTextSize;

    private Page(Builder builder){
        backgroundColor = builder.backgroundColor;
        image = builder.image;
        imageHeight = builder.imageHeight;
        imageIcon = builder.imageIcon;
        imageIconColor = builder.imageIconColor;
        imageIconTextSize = builder.imageIconTextSize;
        imageIconTypeface = builder.imageIconTypeface;
        title = builder.title;
        titleColor = builder.titleColor;
        titleTextSize = builder.titleTextSize;
        description = builder.description;
        descriptionColor = builder.descriptionColor;
        descriptionTextSize = builder.descriptionTextSize;
    }

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

    public int getImageIconColor() {
        return imageIconColor;
    }

    public float getImageIconTextSize() {
        return imageIconTextSize;
    }

    public String getImageIconTypeface() {
        return imageIconTypeface;
    }

    public String getTitle() {
        return title;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public String getDescription() {
        return description;
    }

    public int getDescriptionColor() {
        return descriptionColor;
    }

    public float getTitleTextSize() {
        return titleTextSize;
    }

    public float getDescriptionTextSize() {
        return descriptionTextSize;
    }

    public static class Builder{

        private int backgroundColor;
        private int image;
        private int imageHeight;
        private String imageIcon;
        private int imageIconColor;
        private float imageIconTextSize;
        private String imageIconTypeface;
        private String title;
        private int titleColor;
        private float titleTextSize;
        private String description;
        private int descriptionColor;
        private float descriptionTextSize;

        public Builder backgroundColor(int color){
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
         * @param typeface name of typeface in assets folder
         */
        public Builder image(String icon, int color, float size, String typeface){
            this.imageIcon = icon;
            this.imageIconColor = color;
            this.imageIconTextSize = size;
            this.imageIconTypeface = typeface;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder titleColor(int color){
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

        public Builder descriptionColor(int color){
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
