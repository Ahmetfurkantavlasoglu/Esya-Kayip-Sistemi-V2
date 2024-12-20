package com.vx.esyakayipsistemi;

public class Item {
    private String name;
    private String category;
    private String date;
    private String imagePath;

    public Item(String name, String category, String date, String imagePath) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String getImagePath() {
        return imagePath;
    }
}
