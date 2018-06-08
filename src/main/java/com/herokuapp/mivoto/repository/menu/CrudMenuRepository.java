package com.herokuapp.mivoto.repository.menu;

import com.herokuapp.mivoto.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;

public interface CrudMenuRepository extends JpaRepository<Menu, Integer>{
    @Modifying
    @Query("DELETE FROM Menu m WHERE m.id = :id")
    int delete(@Param("id") int id);

    @Query("SELECT m FROM Menu m WHERE m.restaurant.id = ?1 AND m.date = ?2")
    Menu getByRestaurantId(Integer restaurantId, LocalDate date);
}
