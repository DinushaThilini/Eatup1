package com.example.eatup.customerFoodPanel;

public class Food_detail {

    public String Dishes,Quantity,Price,Description,ImageURL,RandomUID,chefid;

    public Food_detail(String dishes, String quantity, String price, String description, String imageURL, String randomUID, String chefid) {
        Dishes = dishes;
        Quantity = quantity;
        Price = price;
        Description = description;
        ImageURL = imageURL;
        RandomUID = randomUID;
        this.chefid = chefid;
    }
}
