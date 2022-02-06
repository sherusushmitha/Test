package com.in.fashion.ui.gallery;

public class draft_row_design {
    private int image;
    private String text,text1,text2,text3;

    public draft_row_design(int image, String text, String text1, String text2, String text3) {
        this.image = image;
        this.text = text;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
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

    public String getText2() {
        return text2;
    }

    public String getText3() {
        return text3;
    }
}
