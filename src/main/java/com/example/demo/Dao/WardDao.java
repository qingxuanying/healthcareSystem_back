package com.example.demo.Dao;

import com.example.demo.Bean.Doctor;
import com.example.demo.Bean.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WardDao extends JpaRepository<Ward,Integer> {
    @Query(value = " select * from ward where ward_name = ?1", nativeQuery = true)
    List<Ward> findByWardName(String wardName);

    @Query(value = " select * from ward where dept_id = ?1", nativeQuery = true)
    List<Ward> findByDeptId(int deptId);

    @Query(value = " select * from ward where ward_number = ?1", nativeQuery = true)
    List<Ward> findByWardNumber(String wardnumber);
}
