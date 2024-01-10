package com.example.demo.Dao;

import com.example.demo.Bean.PrescriptionMedication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrescriptionMedicationDao extends JpaRepository<PrescriptionMedication,Integer> {
    @Query(value = " select * from prescription_medication where prescription_id = ?1", nativeQuery = true)
    List<PrescriptionMedication> findByPrescriptionId(int prescriptionId);


    @Query(value = " select * from prescription_medication where medication_id = ?1", nativeQuery = true)
    List<PrescriptionMedication> findByMedicationId(int medicationId);
}
