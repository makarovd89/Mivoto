package com.herokuapp.mivoto.service;

import com.herokuapp.mivoto.model.Restaurant;
import com.herokuapp.mivoto.to.RestaurantTo;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.time.LocalDate;
import java.util.List;

import static com.herokuapp.mivoto.RestaurantTestData.*;
import static com.herokuapp.mivoto.util.RestaurantsUtil.fromTo;
import static org.junit.Assert.assertTrue;

public class RestaurantServiceTest extends AbstractServiceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void get() {
        assertMatch(restaurantService.get(RESTAURANT1_ID), TERRA_MARE);
    }

    @Test
    public void getNotFoundWithId() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Not found entity with id: 1");
        restaurantService.get(1);
    }

    @Test
    public void deleteNotFoundWithId() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Not found entity with id: 1");
        restaurantService.delete(1);
    }

    @Test
    public void updateNotFoundWithId() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Not found entity with id: 1");
        Restaurant notExist = getCreated();
        notExist.setId(1);
        restaurantService.update(notExist);
    }

    @Test
    public void update(){
        Restaurant updated = new Restaurant(RESTAURANT1_ID + 3,"BOSCO CAFE","Krasnaya Sq., 3","84956203182");
        restaurantService.update(updated);
        assertMatch(restaurantService.getAll(),updated,COFFEE_ROOM,DOLKABAR,SICILIANA,OSTERIA_ALBOROBELLO,OSTERIA_MARIO,PASTA_AND_BASTA,POROSELLO,SALOTTO,TERRA_MARE);
    }

    @Test
    public void create(){
        RestaurantTo created = restaurantService.create(getCreated());
        assertMatch(restaurantService.getAll(), BOSCO_CAFE,COFFEE_ROOM,DOLKABAR,SICILIANA,OSTERIA_ALBOROBELLO,OSTERIA_MARIO,PASTA_AND_BASTA,POROSELLO,SALOTTO,TERRA_MARE,
                fromTo(created));
    }

    @Test
    public void delete(){
        restaurantService.delete(RESTAURANT1_ID + 1); //delete SALOTTO
        assertMatch(restaurantService.getAll(), BOSCO_CAFE,COFFEE_ROOM,DOLKABAR,SICILIANA,OSTERIA_ALBOROBELLO,OSTERIA_MARIO,PASTA_AND_BASTA,POROSELLO,TERRA_MARE);
    }

    @Test
    public void getAll(){
        assertMatch(restaurantService.getAll(),RESTAURANTS);
    }

    @Test
    public void testCacheable(){
        restaurantService.getAllWithMenuByDate(LocalDate.of(2017,12,30));
        assertTrue(getCache().get(LocalDate.of(2017,12,30), List.class) != null);
    }

    @Test
    public void testCacheEvict(){
        restaurantService.getAllWithMenuByDate(LocalDate.of(2017,12,30));
        restaurantService.delete(RESTAURANT1_ID + 1);
        assertTrue(getCache().get(LocalDate.of(2017,12,30), List.class) == null);
    }
}