package com.example.fashion.ui.gallery;

public class histoey_row_design {
    private int image;
    private String textview,text,text1,text2;

    public histoey_row_design(int image, String textview, String text, String text1, String text2) {
        this.image = image;
        this.textview = textview;
        this.text = text;
        this.text1 = text1;
        this.text2 = text2;
    }

    public int getImage() {
        return image;
    }

    public String getTextview() {
        return textview;
    }

    public String getText() {
        return text;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }
}
