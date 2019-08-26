package com.iroshana.recycleviewproject;

public class ExampleItem {
    private int mImageResourse;
    private String text1;
    private String text2;

    public ExampleItem(int mImageResourse, String text1, String text2) {
        this.mImageResourse = mImageResourse;
        this.text1 = text1;
        this.text2 = text2;
    }

    public void changeText1(String text) {
        text1 = text;
    }

    public int getmImageResourse() {
        return mImageResourse;
    }

    public void setmImageResourse(int mImageResourse) {
        this.mImageResourse = mImageResourse;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

}
