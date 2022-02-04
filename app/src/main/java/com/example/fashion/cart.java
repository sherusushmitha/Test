package com.example.fashion;

public class cart {
    private int image;
    private String text,text1,text2;

    public cart(int image, String text, String text1, String text2) {
        this.image = image;
        this.text = text;
        this.text1 = text1;
        this.text2 = text2;
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
}
