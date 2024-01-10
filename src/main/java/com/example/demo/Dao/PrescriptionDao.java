package com.example.demo.Dao;

import com.example.demo.Bean.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrescriptionDao extends JpaRepository<Prescription,Integer> {
    @Query(value = " select * from prescription where doctor_id = ?1", nativeQuery = true)
    List<Prescription> findByDoctorId(int doctorId);


    @Query(value = " select * from prescription where patient_id = ?1", nativeQuery = true)
    List<Prescription> findByPatientId(int patientId);

    @Query(value = " select * from prescription where registration_id = ?1", nativeQuery = true)
    List<Prescription> findByRegistrationId(int registrationId);
}
