package com.example.demo.Dao;

import com.example.demo.Bean.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NurseDao extends JpaRepository<Nurse, Integer> {
    @Query(value = " select * from nurse where nurse_name = ?1", nativeQuery = true)
    List<Nurse> findByNurseName(String nurseName);

    @Query(value = " select * from nurse where dept_id = ?1", nativeQuery = true)
    List<Nurse> findByDeptId(int deptId);

    @Query(value = " select * from nurse where nurse_title = ?1", nativeQuery = true)
    List<Nurse> findByNurseTitle(String nurseTitle);
}
