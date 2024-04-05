package com.example.projecteanime;

public class Anime {

    int id;
    String name;
    String description;
    String type;
    int year;
    String image;
    String image2;
    String originalname;
    String rating;
    String demography;
    String genre;
    boolean active;
    String favorite;

    public Anime(int id, String name, String description, String type, int year, String image, String image2, String originalname, String rating, String demography, String genre, boolean active, String favorite) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.year = year;
        this.image = image;
        this.image2 = image2;
        this.originalname = originalname;
        this.rating = rating;
        this.demography = demography;
        this.genre = genre;
        this.active = active;
        this.favorite = favorite;
    }

    public Anime() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getOriginalname() {
        return originalname;
    }

    public void setOriginalname(String originalname) {
        this.originalname = originalname;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDemography() {
        return demography;
    }

    public void setDemography(String demography) {
        this.demography = demography;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }
}
