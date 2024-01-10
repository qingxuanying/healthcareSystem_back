package com.example.demo.Controller;

import com.example.demo.Answer.RCFactory;
import com.example.demo.Answer.Result;
import com.example.demo.Bean.Medication;
import com.example.demo.Dao.MedicationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Medication")
public class MedicationController {

    @Autowired
    private MedicationDao medicationDao; // 假设有一个 AdmissionDao 负责数据库操作

    // 增加
    @PostMapping("/add")
    public String addMedication(@RequestBody Medication medication) {
        medicationDao.save(medication);
        return new Result<>(RCFactory.getSuccess(), "相关信息已存入数据库").toString();
    }

    // 删除
    @DeleteMapping("/delete/{medicationId}")
    public String deleteMedication(@PathVariable int medicationId) {
        medicationDao.deleteById(medicationId);
        return new Result<>(RCFactory.getSuccess(), "数据删除成功").toString();
    }

    // 更新
    @PutMapping("/update")
    public String updateMedication(@RequestBody Medication medication) {
        medicationDao.save(medication);
        return new Result<>(RCFactory.getSuccess(), "更改成功").toString();
    }

    // 主键查询
    @PostMapping("/get")
    public Optional<Medication> getMedicationById(@RequestBody Medication medication) {
        return medicationDao.findById(medication.getMedicationId());
    }

    // 显示所有
    @GetMapping("/medications")
    public List<Medication> findAll() {
        return medicationDao.findAll();
    }

    // 按种类查询
    @GetMapping("/get/category/{category}")
    public String getMedicationByCategory(@PathVariable String category) {
        return new Result<>(RCFactory.getSuccess(), medicationDao.findByCategory(category).toString()).toString();
    }

    // 按药品名称查询
    @GetMapping("/get/medicationName/{medicationName}")
    public String getMedicationByMedicationName(@PathVariable String medicationName) {
        return new Result<>(RCFactory.getSuccess(), medicationDao.findByMedicationName(medicationName).toString()).toString();
    }

    // 按生产厂商查询
    @GetMapping("/get/manufacturer/{manufacturer}")
    public String getMedicationByManufacturer(@PathVariable String manufacturer) {
        return new Result<>(RCFactory.getSuccess(), medicationDao.findByManufacturer(manufacturer).toString()).toString();
    }
}