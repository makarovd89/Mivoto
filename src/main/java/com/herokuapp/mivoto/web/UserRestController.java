package com.herokuapp.mivoto.web;

import com.herokuapp.mivoto.AuthorizedUser;
import com.herokuapp.mivoto.service.RestaurantService;
import com.herokuapp.mivoto.service.VoteService;
import com.herokuapp.mivoto.to.RestaurantWithMenuTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(UserRestController.REST_URL)
public class UserRestController {
    static final String REST_URL = "/rest/user";

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private VoteService voteService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/votes/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
    public void vote(@RequestParam int id) {
        LocalDate now = getCurrentDate();
        log.info("vote for restaurant {} date {}", id, now);
        voteService.vote(id, AuthorizedUser.id(), getCurrentTime(), now);
    }

    @GetMapping(value = "/restaurants/menu", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RestaurantWithMenuTo> getRestaurantsOnlyWithMenu() {
        LocalDate now = getCurrentDate();
        log.info("get restaurants with menu for date {}", now);
        return restaurantService.getAllOnlyWithMenuByDate(now);
    }

    protected LocalDate getCurrentDate(){
        return LocalDate.now();
    }

    protected LocalTime getCurrentTime(){
        return LocalTime.now();
    }
}
