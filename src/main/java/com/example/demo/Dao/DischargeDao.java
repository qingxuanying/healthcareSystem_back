package com.example.demo.Dao;

import com.example.demo.Bean.Discharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DischargeDao extends JpaRepository<Discharge,Integer> {
    @Query(value = " select * from discharge where patient_id = ?1", nativeQuery = true)
    List<Discharge> findByPatientId(int patientId);

    @Query(value = " select * from discharge where doctor_id = ?1", nativeQuery = true)
    List<Discharge> findByDoctorId(int doctorId);

    @Query(value = " select * from discharge where dept_id = ?1", nativeQuery = true)
    List<Discharge> findByDeptId(int deptId);

    @Query(value = " select * from discharge where ward_id = ?1", nativeQuery = true)
    List<Discharge> findByWardId(int wardId);
}
