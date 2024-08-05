package com.pp.repository;

import com.pp.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TouristRepository extends JpaRepository<Tourist, Long> {

    List<Tourist> findByName(String name);

//    @Query(value = "SELECT * FROM tourist WHERE name = :name", nativeQuery = true)
//    List<Tourist> findByName(@Param("name") String name);
}
