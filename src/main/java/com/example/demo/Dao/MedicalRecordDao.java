package com.example.demo.Dao;

import com.example.demo.Bean.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicalRecordDao extends JpaRepository<MedicalRecord,Integer> {
    @Query(value = " select * from medical_record where doctor_id = ?1", nativeQuery = true)
    List<MedicalRecord> findByDoctorId(int doctorId);

    @Query(value = " select * from medical_record where dept_id = ?1", nativeQuery = true)
    List<MedicalRecord> findByDeptId(int deptId);

    @Query(value = " select * from medical_record where patient_id = ?1", nativeQuery = true)
    List<MedicalRecord> findByPatientId(int patientId);

    @Query(value = " select * from medical_record where registration_id = ?1", nativeQuery = true)
    List<MedicalRecord> findByRegistrationId(int registrationId);
}
