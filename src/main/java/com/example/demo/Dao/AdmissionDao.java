package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Bean.Admission;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdmissionDao extends JpaRepository<Admission,Integer> {
    @Query(value = " select * from admission where patient_id = ?1", nativeQuery = true)
    List<Admission> findByPatientId(int patientId);

    @Query(value = " select * from admission where doctor_id = ?1", nativeQuery = true)
    List<Admission> findByDoctorId(int doctorId);

    @Query(value = " select * from admission where dept_id = ?1", nativeQuery = true)
    List<Admission> findByDeptId(int deptId);

    @Query(value = " select * from admission where ward_id = ?1", nativeQuery = true)
    List<Admission> findByWardId(int wardId);
}
