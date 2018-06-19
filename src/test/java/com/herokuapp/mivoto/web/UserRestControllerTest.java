package com.herokuapp.mivoto.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import java.time.LocalDate;

import static com.herokuapp.mivoto.RestaurantTestData.RESTAURANTS2;
import static com.herokuapp.mivoto.RestaurantTestData.RESTAURANTS3;
import static com.herokuapp.mivoto.TestUtil.contentJson;
import static com.herokuapp.mivoto.TestUtil.userHttpBasic;
import static com.herokuapp.mivoto.UserTestData.USER;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserRestControllerTest extends AbstractControllerTest {
    private static final String REST_URL = UserRestController.REST_URL + '/';

    @Autowired
    private ApplicationContext context;

    private UserRestController controller;

    @Override
    protected String getRestUrl() {
        return REST_URL;
    }

    @Before
    public void setUp() {
        controller = context.getBean(UserRestController.class);
    }


    @Test
    public void testRestaurantsOnlyWithMenu() throws Exception {
        controller.setDate(() -> LocalDate.of(2017,12,30));
        mockMvc.perform(get(REST_URL + "restaurants/menu")
                .with(userHttpBasic(USER)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(contentJson(RESTAURANTS2));
    }

    @Test
    public void testRestaurantsOnlyWithMenu2() throws Exception {
        controller.setDate(() -> LocalDate.of(2017,12,31));
        mockMvc.perform(get(REST_URL + "restaurants/menu")
                .with(userHttpBasic(USER)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(contentJson(RESTAURANTS3));
    }
}
