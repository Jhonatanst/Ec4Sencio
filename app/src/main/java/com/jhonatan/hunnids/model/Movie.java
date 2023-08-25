package com.jhonatan.hunnids.model;

public class Movie extends Shows {

    private String Saganame;
    public Movie(String name, String imgUrl,String Saganame) {
        super(name, imgUrl);
        this.Saganame = Saganame;
    }

    public String getSaganame() {
        return Saganame;
    }

    public void setSaganame(String saganame) {
        Saganame = saganame;
    }
}
