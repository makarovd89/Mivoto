package com.herokuapp.mivoto.service;

import com.herokuapp.mivoto.DishTestData;
import com.herokuapp.mivoto.to.MenuTo;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static com.herokuapp.mivoto.DishTestData.THE_PORKIE;
import static com.herokuapp.mivoto.MenuTestData.*;
import static com.herokuapp.mivoto.RestaurantTestData.RESTAURANT1_ID;
import static org.junit.Assert.assertTrue;

public class MenuServiceTest extends AbstractServiceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void get(){
        MenuTo menu = menuService.get(MENU1_ID);
        assertMatch(menu, MENU1);
    }

    @Test
    public void getByDateAndRestaurantId(){
        assertMatch(menuService.get(LocalDate.of(2017, 12, 30), RESTAURANT1_ID), MENU1);
    }

    @Test
    public void create(){
        MenuTo menu = menuService.create(getCreated());
        assertMatch(menuService.get(menu.getId()), menu);
    }

    @Test
    public void update(){
        menuService.update(UPDATED_MENU1);
        MenuTo menu = menuService.get(UPDATED_MENU1.getId());
        assertMatch(menu, UPDATED_MENU1);
    }

    @Test
    public void getNotFoundWithId(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Not found entity with id: 1");
        menuService.get(1);
    }

    @Test
    public void deleteNotFoundWithId(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Not found entity with id: 1");
        menuService.delete(1);
    }

    @Test
    public void updateNotFoundWithId(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Not found entity with id: 1");
        menuService.update(new MenuTo( 1, LocalDate.of(2017,12,25), Collections.singleton(THE_PORKIE), RESTAURANT1_ID + 4));
    }

    @Test
    public void testCacheEvict(){
        restaurantService.getAllWithMenuByDate(LocalDate.of(2017,12,30));
        menuService.create(getCreated());
        assertTrue(getCache().get(LocalDate.of(2017,12,30), List.class) == null);
    }
}