package com.herokuapp.mivoto.repository.restaurant;

import com.herokuapp.mivoto.model.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private final CrudRestaurantRepository crudRepository;

    private static final Sort SORT = new Sort(Sort.Direction.ASC, "name", "address", "phone");

    @Autowired
    public RestaurantRepositoryImpl(CrudRestaurantRepository restaurantRepository) {
        this.crudRepository = restaurantRepository;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        return crudRepository.save(restaurant);
    }

    @Override
    public Restaurant update(Restaurant r) {
        return crudRepository.update(r.getName(), r.getAddress(), r.getPhone(), r.getId()) != 0 ? r : null;
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    @Override
    public Restaurant get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    public List<Restaurant> getAll(){
        return crudRepository.findAll(SORT);
    }
}
