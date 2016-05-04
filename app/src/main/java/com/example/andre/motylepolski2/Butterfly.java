package com.example.andre.motylepolski2;

/**
 * Created by Andre on 2016-05-04.
 */
public class Butterfly {
    private int imageButterflyId;
    private String name;
    private String latinName;

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
}
