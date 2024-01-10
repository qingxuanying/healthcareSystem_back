package com.example.demo.Dao;

import com.example.demo.Bean.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeptDao extends JpaRepository<Dept,Integer> {

    @Query(value = " select * from dept where duty_doctor = ?1", nativeQuery = true)
    List<Dept> findByDutyDoctor(int dutyDoctor);
}
