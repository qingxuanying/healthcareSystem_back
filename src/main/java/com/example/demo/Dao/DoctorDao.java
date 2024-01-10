package com.example.demo.Dao;

import com.example.demo.Bean.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorDao extends JpaRepository<Doctor,Integer> {
    @Query(value = " select * from doctor where doctor_name = ?1", nativeQuery = true)
    List<Doctor> findByDoctorName(String doctorName);

    @Query(value = " select * from doctor where dept_id = ?1", nativeQuery = true)
    List<Doctor> findByDeptId(int deptId);

    @Query(value = " select * from doctor where doctor_title = ?1", nativeQuery = true)
    List<Doctor> findByDoctorTitle(String doctorTitle);
}
