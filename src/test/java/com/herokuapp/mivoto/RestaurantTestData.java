package com.herokuapp.mivoto;

import com.herokuapp.mivoto.model.Restaurant;
import java.util.Arrays;

import static com.herokuapp.mivoto.model.AbstractBaseEntity.START_SEQ;
import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantTestData {
    public static final int RESTAURANT1_ID = START_SEQ + 2; // next after 2 users

    public static final Restaurant TERRA_MARE = new Restaurant(RESTAURANT1_ID,"TerraMare", "Tsvetnoi Blvd., 20/1","+74956081519");
    public static final Restaurant SALOTTO = new Restaurant(RESTAURANT1_ID + 1,"Salotto","Staropimenovskiy Ln., 11/6","+79100000920");
    public static final Restaurant SICILIANA = new Restaurant(RESTAURANT1_ID + 2,"La Bottega Siciliana","Okhotny Ryad, 2","+74956600383");
    public static final Restaurant BOSCO_CAFE = new Restaurant(RESTAURANT1_ID + 3,"Bosco Cafe","Krasnaya Sq., 3","+74956203182");
    public static final Restaurant DOLKABAR = new Restaurant(RESTAURANT1_ID + 4,"Dolkabar","Krasina St., 7","+74992547908");
    public static final Restaurant OSTERIA_ALBOROBELLO = new Restaurant(RESTAURANT1_ID + 5,"Osteria Alberobello","Leninskiy Ave., 75A","+74991343524");
    public static final Restaurant POROSELLO = new Restaurant(RESTAURANT1_ID + 6,"Porosello","Lubyanskiy Drive, 25/2","+74956235969");
    public static final Restaurant PASTA_AND_BASTA = new Restaurant(RESTAURANT1_ID + 7,"Pasta and Basta","Sretenskiy bulvar, 4 | Metro Chistye Prudi","+74956245252");
    public static final Restaurant OSTERIA_MARIO = new Restaurant(RESTAURANT1_ID + 8,"Osteria Mario","Baltiyskaya St., 9","+74957907090");
    public static final Restaurant COFFEE_ROOM = new Restaurant(RESTAURANT1_ID + 9,"Coffee Room","Arbat St., 13","+74956973553");

    public static final Restaurant[] RESTAURANTS = {BOSCO_CAFE,COFFEE_ROOM,DOLKABAR,SICILIANA,OSTERIA_ALBOROBELLO,OSTERIA_MARIO,PASTA_AND_BASTA,POROSELLO,SALOTTO,TERRA_MARE};

    public static Restaurant getCreated(){
        return new Restaurant(null, "Via Romano", "Lavochkina St., 34, Moscow 125581, Russia", "+74955453480");
    }

    public static void assertMatch(Restaurant actual, Restaurant expected){
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    public static void assertMatch(Iterable<Restaurant> actual, Iterable<Restaurant> expected){
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Restaurant> actual, Restaurant... expected){
        assertMatch(actual, Arrays.asList(expected));
    }
}
