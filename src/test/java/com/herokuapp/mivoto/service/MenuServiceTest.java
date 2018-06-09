package com.herokuapp.mivoto.service;

import com.herokuapp.mivoto.DishTestData;
import com.herokuapp.mivoto.model.Menu;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.Collections;

import static com.herokuapp.mivoto.DishTestData.THE_PORKIE;
import static com.herokuapp.mivoto.MenuTestData.*;
import static com.herokuapp.mivoto.RestaurantTestData.RESTAURANT1_ID;

public class MenuServiceTest extends AbstractServiceTest {
    @Autowired
    private MenuService menuService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void get(){
        Menu menu = menuService.get(MENU1_ID);
        assertMatch(menu, MENU1);
        DishTestData.assertMatch(menu.getDishes(), MENU1.getDishes());
    }

    @Test
    public void getByDateAndRestaurantId(){
        assertMatch(menuService.get(LocalDate.of(2017, 12, 30), RESTAURANT1_ID), MENU1);
    }

    @Test
    public void create(){
        Menu menu = menuService.create(getCreated(), RESTAURANT1_ID + 1);
        assertMatch(menuService.get(menu.getId()), menu);
    }

    @Test
    public void update(){
        menuService.update(UPDATED_MENU1, RESTAURANT1_ID + 1);
        Menu menu = menuService.get(UPDATED_MENU1.getId());
        assertMatch(menu, UPDATED_MENU1);
        DishTestData.assertMatch(menu.getDishes(), UPDATED_MENU1.getDishes());
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
        menuService.update(new Menu( 1, LocalDate.of(2017,12,25), Collections.singleton(THE_PORKIE)), RESTAURANT1_ID + 4);
    }
}