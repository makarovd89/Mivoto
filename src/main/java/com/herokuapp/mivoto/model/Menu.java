package com.herokuapp.mivoto.model;

import java.time.LocalDate;
import java.util.Set;

public class Menu extends AbstractBaseEntity{

    private Restaurant restaurant;

    private LocalDate date;

    private Set<Dish> dishes;

    public Menu() {}

    public Menu(Integer id) {
        super(id);
    }

    public Menu(Menu menu) {
        this(menu.getId(), menu.getDate(), menu.getDishes());
    }

    public Menu(LocalDate date, Set<Dish> dishes) {
        this.date = date;
        this.dishes = dishes;
    }

    public Menu(Integer id, LocalDate date, Set<Dish> dishes) {
        super(id);
        this.date = date;
        this.dishes = dishes;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "date=" + date +
                ", id=" + id +
                ", dishes=\n" + dishes.toString().replaceAll("},", "},\n") +
                '}';
    }
}
