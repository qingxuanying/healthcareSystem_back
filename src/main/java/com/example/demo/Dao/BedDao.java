package com.example.demo.Dao;

import com.example.demo.Bean.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BedDao extends JpaRepository<Bed,Integer> {

    @Query(value = " select * from bed where ward_id = ?1", nativeQuery = true)
    List<Bed> findByWardId(int wardId);
}
