package com.in.fashion.ui.home;

public class row_gridview {
    private  int image;
    private String text,textview,text1;

    public row_gridview(int image, String text, String textview, String text1) {

        this.image = image;
        this.text = text;
        this.textview = textview;
        this.text1 = text1;
    }

    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }

    public String getTextview() {
        return textview;
    }

    public String getText1() {
        return text1;
    }
}
