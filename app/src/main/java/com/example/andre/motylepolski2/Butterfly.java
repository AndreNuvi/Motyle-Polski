package com.example.andre.motylepolski2;

/**
 * Created by Andre on 2016-05-04.
 */
public class Butterfly {
    String name;
    String latinName;
    String colorTag1;
    int butterflyIcon;
    int butterflyImago1;
    int butterflyImago2;
    int butterflyImago3;
    int butterflyCaterpillar;
    int butterflyCocoon;
    int butterflyEgg;
    int butterflyArea;
    String nutrition;
    String detailInfo;
    String link1;
    String link2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatinName() {
        return latinName;
    }

    public String getColorTag1() {
        return colorTag1;
    }

    public int getButterflyIcon() {
        return butterflyIcon;
    }

    public int getButterflyImago1() {
        return butterflyImago1;
    }

    public int getButterflyImago2() {
        return butterflyImago2;
    }

    public int getButterflyImago3() {
        return butterflyImago3;
    }

    public int getButterflyCaterpillar() {
        return butterflyCaterpillar;
    }

    public int getButterflyCocoon() {
        return butterflyCocoon;
    }

    public int getButterflyEgg() {
        return butterflyEgg;
    }

    public int getButterflyArea() {
        return butterflyArea;
    }


    public String getDetailInfo() {
        return detailInfo;
    }

    public Butterfly(String name, String latinName, String colorTag1, int butterflyIcon, int butterflyImago1, int butterflyImago2, int butterflyImago3, int butterflyCaterpillar, int butterflyCocoon, int butterflyEgg, int butterflyArea, String detailInfo) {
        this.name = name;
        this.latinName = latinName;
        this.colorTag1 = colorTag1;
        this.butterflyIcon = butterflyIcon;
        this.butterflyImago1 = butterflyImago1;
        this.butterflyImago2 = butterflyImago2;
        this.butterflyImago3 = butterflyImago3;
        this.butterflyCaterpillar = butterflyCaterpillar;
        this.butterflyCocoon = butterflyCocoon;
        this.butterflyEgg = butterflyEgg;
        this.butterflyArea = butterflyArea;
        this.detailInfo = detailInfo;
    }
}
