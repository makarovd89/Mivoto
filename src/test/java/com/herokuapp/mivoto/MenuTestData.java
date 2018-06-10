package com.herokuapp.mivoto;

import com.herokuapp.mivoto.to.MenuTo;
import java.time.LocalDate;
import java.util.*;

import static com.herokuapp.mivoto.DishTestData.*;
import static com.herokuapp.mivoto.RestaurantTestData.RESTAURANT1_ID;
import static com.herokuapp.mivoto.model.AbstractBaseEntity.START_SEQ;
import static org.assertj.core.api.Assertions.assertThat;

public class MenuTestData {
    public static final int MENU1_ID = START_SEQ + 12; //next after 2 users, 10 restaurants
    public static final MenuTo MENU1 = new MenuTo(MENU1_ID, LocalDate.of(2017,12,30), new HashSet<>(Arrays.asList(SPAGHETTI, LASAGNE, TIRAMISU)), RESTAURANT1_ID);
    public static final MenuTo MENU2 = new MenuTo(MENU1_ID + 1, LocalDate.of(2017,12,30), new HashSet<>(Arrays.asList(CANNELLONI, CARBONARA)), RESTAURANT1_ID + 1);
    public static final MenuTo MENU3 = new MenuTo(MENU1_ID + 2, LocalDate.of(2017,12,30), new HashSet<>(Arrays.asList(RAVIOLI, CHICKEN)), RESTAURANT1_ID + 2);
    public static final MenuTo MENU4 = new MenuTo(MENU1_ID + 3, LocalDate.of(2017,12,30), new HashSet<>(Arrays.asList(POTATO_FRIES, THE_PORKIE)), RESTAURANT1_ID + 3);
    public static final MenuTo MENU5 = new MenuTo(MENU1_ID + 4, LocalDate.of(2017,12,30), Collections.singleton(THE_FUNGHI), RESTAURANT1_ID + 4);
    public static final MenuTo MENU6 = new MenuTo(MENU1_ID + 5, LocalDate.of(2017,12,30), Collections.singleton(THE_TUSCAN), RESTAURANT1_ID + 5);
    public static final MenuTo MENU7 = new MenuTo(MENU1_ID + 6, LocalDate.of(2017,12,30), new HashSet<>(Arrays.asList(THE_MEETBALL, THE_JULIETTA)), RESTAURANT1_ID + 6);
    public static final MenuTo MENU8 = new MenuTo(MENU1_ID + 7, LocalDate.of(2017,12,30), new HashSet<>(Arrays.asList(PUMPKIN_ARANCINI, MUSHROOM_FRITTI, ITALIAN_MEATBALLS)), RESTAURANT1_ID + 7);
    public static final MenuTo MENU9 = new MenuTo(MENU1_ID + 8, LocalDate.of(2017,12,31), new HashSet<>(Arrays.asList(MIXED_GRILL,AUBERGIN)), RESTAURANT1_ID);
    public static final MenuTo UPDATED_MENU1 = new MenuTo(MENU1_ID, LocalDate.of(2017,12,31), new HashSet<>(Arrays.asList(SPAGHETTI, LASAGNE, TIRAMISU, MUSHROOM_FRITTI)), RESTAURANT1_ID);

    public static MenuTo getCreated(){
      return new MenuTo(null, LocalDate.of(2017,12,31), new HashSet<>(Arrays.asList(CANNELLONI, CARBONARA)), RESTAURANT1_ID + 1);
    }

    public static void assertMatch(MenuTo actual, MenuTo expected){
        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }
}