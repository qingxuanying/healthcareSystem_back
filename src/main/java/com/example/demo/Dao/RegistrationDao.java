package com.example.demo.Dao;

import com.example.demo.Bean.DoctorSchedule;
import com.example.demo.Bean.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface RegistrationDao extends JpaRepository<Registration,Integer> {
    @Query(value = " select * from registration where doctor_id = ?1", nativeQuery = true)
    List<Registration> findByDoctorId(int doctorId);

    @Query(value = " select * from registration where patient_id = ?1", nativeQuery = true)
    List<Registration> findByPatientId(int patientId);

    @Query(value = " select * from registration where registration_date = ?1", nativeQuery = true)
    List<Registration> findByRegistrationDate(Date date);
}
