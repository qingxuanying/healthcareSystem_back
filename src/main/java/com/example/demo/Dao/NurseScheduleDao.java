package com.example.demo.Dao;

import com.example.demo.Bean.NurseSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface NurseScheduleDao extends JpaRepository<NurseSchedule,Integer> {
    @Query(value = " select * from nurse_schedule where nurse_id = ?1", nativeQuery = true)
    List<NurseSchedule> findByNurseId(int doctorId);

    @Query(value = " select * from nurse_schedule where dept_id = ?1", nativeQuery = true)
    List<NurseSchedule> findByDeptId(int deptId);

    @Query(value = " select * from nurse_schedule where date = ?1", nativeQuery = true)
    List<NurseSchedule> findByDate(Date date);
}
