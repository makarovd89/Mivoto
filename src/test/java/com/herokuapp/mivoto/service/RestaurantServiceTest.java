package com.herokuapp.mivoto.service;

import com.herokuapp.mivoto.model.Restaurant;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import static com.herokuapp.mivoto.RestaurantTestData.*;

public class RestaurantServiceTest extends AbstractServiceTest {
    @Autowired
    private RestaurantService service;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void get() {
        assertMatch(service.get(RESTAURANT1_ID), TERRA_MARE);
    }

    @Test
    public void getNotFoundWithId() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Not found entity with id: 1");
        service.get(1);
    }

    @Test
    public void deleteNotFoundWithId() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Not found entity with id: 1");
        service.delete(1);
    }

    @Test
    public void updateNotFoundWithId() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Not found entity with id: 1");
        Restaurant notExist = getCreated();
        notExist.setId(1);
        service.update(notExist);
    }

    @Test
    public void update(){
        Restaurant updated = new Restaurant(RESTAURANT1_ID + 3,"BOSCO CAFE","Krasnaya Sq., 3","84956203182");
        service.update(updated);
        assertMatch(service.getAll(),updated,COFFEE_ROOM,DOLKABAR,SICILIANA,OSTERIA_ALBOROBELLO,OSTERIA_MARIO,PASTA_AND_BASTA,POROSELLO,SALOTTO,TERRA_MARE);
    }

    @Test
    public void create(){
        Restaurant created = service.create(getCreated());
        assertMatch(service.getAll(), BOSCO_CAFE,COFFEE_ROOM,DOLKABAR,SICILIANA,OSTERIA_ALBOROBELLO,OSTERIA_MARIO,PASTA_AND_BASTA,POROSELLO,SALOTTO,TERRA_MARE,
                created);
    }

    @Test
    public void delete(){
        service.delete(RESTAURANT1_ID + 1); //delete SALOTTO
        assertMatch(service.getAll(), BOSCO_CAFE,COFFEE_ROOM,DOLKABAR,SICILIANA,OSTERIA_ALBOROBELLO,OSTERIA_MARIO,PASTA_AND_BASTA,POROSELLO,TERRA_MARE);
    }

    @Test
    public void getAll(){
        assertMatch(service.getAll(),RESTAURANTS);
    }

}
