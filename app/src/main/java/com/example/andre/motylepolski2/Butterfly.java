package com.example.andre.motylepolski2;

/**
 * Created by Andre on 2016-05-04.
 */
public class Butterfly {
    private int imageButterflyId;
    private String name;
    private String latinName;
    String colorTag1;

    private int imageGalleryOne;
    private int imageGalleryTwo;
    private int imageGalleryThree;




    public String getColorTag1() {
        return colorTag1;
    }

    public void setColorTag1(String colorTag1) {
        this.colorTag1 = colorTag1;
    }


    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageButterflyId() {
        return imageButterflyId;
    }

    public void setImageButterflyId(int imageButterflyId) {
        this.imageButterflyId = imageButterflyId;
    }

    public Butterfly(int imageButterflyId, String name, String latinName) {
        this.imageButterflyId = imageButterflyId;
        this.name = name;
        this.latinName = latinName;
    }


    public Butterfly(int imageButterflyId, String name, String latinName, String colorTag1) {
        this.imageButterflyId = imageButterflyId;
        this.name = name;
        this.latinName = latinName;
        this.colorTag1 = colorTag1;

    }

    public Butterfly(int imageButterflyId, String name, String latinName, String colorTag1, int imageGalleryOne, int imageGalleryTwo, int imageGalleryThree) {
        this.imageButterflyId = imageButterflyId;
        this.name = name;
        this.latinName = latinName;
        this.colorTag1 = colorTag1;

        this.imageGalleryOne = imageGalleryOne;
        this.imageGalleryTwo = imageGalleryTwo;
        this.imageGalleryThree = imageGalleryThree;
    }

    @Override
    public String toString() {
        return getName() + "";
    }
}
