package com.example.demo.Dao;

import com.example.demo.Bean.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminDao extends JpaRepository<Admin,Integer> {

    @Query(value = " select * from admin where admin_name = ?1", nativeQuery = true)
    List<Admin> findByAdminName(String adminName);


}
