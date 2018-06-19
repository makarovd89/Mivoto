package com.herokuapp.mivoto.to;

public class RestaurantWithMenuTo extends RestaurantTo {
    private MenuTo menu;

    public RestaurantWithMenuTo(RestaurantTo restaurantTo, MenuTo menu) {
        super(restaurantTo);
        this.menu = menu;
    }

    public MenuTo getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return "RestaurantWithMenuTo{" +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", menu=" + menu +
                '}';
    }
}
