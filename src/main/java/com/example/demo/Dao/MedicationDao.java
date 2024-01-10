package com.example.demo.Dao;

import com.example.demo.Bean.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicationDao extends JpaRepository<Medication,Integer> {
    @Query(value = " select * from medication where category = ?1", nativeQuery = true)
    List<Medication> findByCategory(String category);

    @Query(value = " select * from medication where medication_name = ?1", nativeQuery = true)
    List<Medication> findByMedicationName(String medicationName);

    @Query(value = " select * from medication where manufacturer = ?1", nativeQuery = true)
    List<Medication> findByManufacturer(String manufacturer);
}
