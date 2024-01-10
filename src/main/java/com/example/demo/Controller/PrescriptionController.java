package com.example.demo.Controller;

import com.example.demo.Answer.RCFactory;
import com.example.demo.Answer.Result;
import com.example.demo.Bean.Prescription;
import com.example.demo.Dao.PrescriptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionDao prescriptionDao; // 假设有一个 AdmissionDao 负责数据库操作

    // 增加
    @PostMapping("/add")
    public String addPrescription(@RequestBody Prescription prescription) {
        prescriptionDao.save(prescription);
        return new Result<>(RCFactory.getSuccess(), "相关信息已存入数据库").toString();
    }

    // 删除
    @DeleteMapping("/delete/{prescriptionId}")
    public String deletePrescription(@PathVariable int prescriptionId) {
        prescriptionDao.deleteById(prescriptionId);
        return new Result<>(RCFactory.getSuccess(), "数据删除成功").toString();
    }

    // 更新
    @PutMapping("/update")
    public String updatePrescription(@RequestBody Prescription prescription) {
        prescriptionDao.save(prescription);
        return new Result<>(RCFactory.getSuccess(), "更改成功").toString();
    }

    // 主键查询
    @GetMapping("/get/{prescriptionId}")
    public String getPrescriptionById(@PathVariable int prescriptionId) {
        return new Result<>(RCFactory.getSuccess(), prescriptionDao.findById(prescriptionId).toString()).toString();
    }

    // 显示所有
    @GetMapping("/prescriptions")
    public String findAll() {
        return new Result<>(RCFactory.getSuccess(),prescriptionDao.findAll().toString()).toString();
    }

    // 按医生查询
    @GetMapping("/get/doctorId/{doctorId}")
    public String getPrescriptionByDoctorId(@PathVariable int doctorId) {
        return new Result<>(RCFactory.getSuccess(), prescriptionDao.findByDoctorId(doctorId).toString()).toString();
    }

    // 按患者查询
    @GetMapping("/get/patientId/{patientId}")
    public String getPrescriptionByPatientId(@PathVariable int patientId) {
        return new Result<>(RCFactory.getSuccess(), prescriptionDao.findByPatientId(patientId).toString()).toString();
    }
    //
    @GetMapping("/get/registrationId")
    public List<Prescription> getPrescriptionByRegistrationId(@RequestParam int registrationId){
        return prescriptionDao.findByRegistrationId(registrationId);
    }
}