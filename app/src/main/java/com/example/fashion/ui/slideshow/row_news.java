package com.example.fashion.ui.slideshow;

public class row_news {

    private int image;
    private String text,text1;

    public row_news(int image, String text, String text1) {
        this.image = image;
        this.text = text;
        this.text1 = text1;
    }

    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }

    public String getText1() {
        return text1;
    }
}
