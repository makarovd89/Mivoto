package com.herokuapp.mivoto;

import com.herokuapp.mivoto.model.Menu;
import java.time.LocalDate;
import java.util.*;

import static com.herokuapp.mivoto.DishTestData.*;
import static com.herokuapp.mivoto.model.AbstractBaseEntity.START_SEQ;
import static org.assertj.core.api.Assertions.assertThat;

public class MenuTestData {
    public static final int MENU1_ID = START_SEQ + 12; //next after 2 users, 10 restaurants
    public static final Menu MENU1 = new Menu(MENU1_ID, LocalDate.of(2017,12,30), new HashSet<>(Arrays.asList(SPAGHETTI, LASAGNE, TIRAMISU)));
    public static final Menu MENU2 = new Menu(MENU1_ID + 1, LocalDate.of(2017,12,30), new HashSet<>(Arrays.asList(CANNELLONI, CARBONARA)));
    public static final Menu MENU3 = new Menu(MENU1_ID + 2, LocalDate.of(2017,12,30), new HashSet<>(Arrays.asList(RAVIOLI, CHICKEN)));
    public static final Menu MENU4 = new Menu(MENU1_ID + 3, LocalDate.of(2017,12,30), new HashSet<>(Arrays.asList(POTATO_FRIES, THE_PORKIE)));
    public static final Menu MENU5 = new Menu(MENU1_ID + 4, LocalDate.of(2017,12,30), Collections.singleton(THE_FUNGHI));
    public static final Menu MENU6 = new Menu(MENU1_ID + 5, LocalDate.of(2017,12,30), Collections.singleton(THE_TUSCAN));
    public static final Menu MENU7 = new Menu(MENU1_ID + 6, LocalDate.of(2017,12,30), new HashSet<>(Arrays.asList(THE_MEETBALL, THE_JULIETTA)));
    public static final Menu MENU8 = new Menu(MENU1_ID + 7, LocalDate.of(2017,12,30), new HashSet<>(Arrays.asList(PUMPKIN_ARANCINI, MUSHROOM_FRITTI, ITALIAN_MEATBALLS)));
    public static final Menu MENU9 = new Menu(MENU1_ID + 8, LocalDate.of(2017,12,31), new HashSet<>(Arrays.asList(MIXED_GRILL,AUBERGIN)));
    public static final Menu UPDATED_MENU1 = new Menu(MENU1_ID, LocalDate.of(2017,12,31), new HashSet<>(Arrays.asList(SPAGHETTI, LASAGNE, TIRAMISU, MUSHROOM_FRITTI)));

    public static Menu getCreated(){
      return new Menu(null, LocalDate.of(2017,12,31), new HashSet<>(Arrays.asList(CANNELLONI, CARBONARA)));
    }

    public static void assertMatch(Menu actual, Menu expected){
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "restaurant");
    }
}