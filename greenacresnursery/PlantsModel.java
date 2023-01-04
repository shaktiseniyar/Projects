package com.example.greenacresnursery;

public class PlantsModel {
    public int image;
    public String plantName;
    public String price;
    public String description;
    public String sunlight;
    public String watering;

    PlantsModel(String plantName, String price, int image,String description,String sunlight,String watering) {
        this.plantName=plantName;
        this.price=price;
        this.image=image;
        this.description=description;
        this.sunlight=sunlight;
        this.watering=watering;
}

    public int getImage() {
        return image;
    }

    public String getPlantName() {
        return plantName;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getSunlight() {
        return sunlight;
    }

    public String getWatering() {
        return watering;
    }
}
