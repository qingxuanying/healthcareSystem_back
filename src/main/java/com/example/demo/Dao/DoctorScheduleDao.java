package com.example.demo.Dao;

import com.example.demo.Bean.DoctorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface DoctorScheduleDao extends JpaRepository<DoctorSchedule,Integer> {
    @Query(value = " select * from doctor_schedule where doctor_id = ?1", nativeQuery = true)
    List<DoctorSchedule> findByDoctorId(int doctorId);

    @Query(value = " select * from doctor_schedule where dept_id = ?1", nativeQuery = true)
    List<DoctorSchedule> findByDeptId(int deptId);

    @Query(value = " select * from doctor_schedule where date = ?1", nativeQuery = true)
    List<DoctorSchedule> findByDate(Date date);
}
