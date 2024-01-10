package com.example.demo.Dao;

import com.example.demo.Bean.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientDao extends JpaRepository<Patient,Integer> {
    @Query(value = " select * from patient where patient_name = ?1", nativeQuery = true)
    List<Patient> findByPatientName(String patientName);

    @Query(value = "select * from patient where patient_certificates_no=?1",nativeQuery = true)
    List<Patient> findAllByPatient_certificates_no(String patient_certificates_no);
}
