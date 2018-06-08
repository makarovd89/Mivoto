package com.herokuapp.mivoto.repository.restaurant;

import com.herokuapp.mivoto.model.Restaurant;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer>{

    @Modifying
    @Query("UPDATE Restaurant r SET r.name=?1, r.address=?2, r.phone=?3 WHERE r.id=?4")
    int update(String name, String address, String phone, Integer id);

    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id = :id")
    int delete(@Param("id") int id);

    @Query("SELECT r FROM Restaurant r LEFT JOIN r.menu AS m WHERE (m.date = :date)")
    @EntityGraph(attributePaths = {"menu"}, type = EntityGraph.EntityGraphType.LOAD)
    List<Restaurant> getAllWithMenuByDate(@Param("date") LocalDate date, Sort sort);
}