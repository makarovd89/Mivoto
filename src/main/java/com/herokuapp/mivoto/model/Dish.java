package com.herokuapp.mivoto.model;

import java.math.BigDecimal;

public class Dish {
    private BigDecimal price;

    private String description;

    public Dish() {}

    public Dish(Dish dish) {
        this(dish.getDescription(), dish.getPrice());
    }

    public Dish(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}