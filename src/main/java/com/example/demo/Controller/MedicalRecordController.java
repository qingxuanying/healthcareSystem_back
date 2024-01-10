package com.example.demo.Controller;

import com.example.demo.Answer.RCFactory;
import com.example.demo.Answer.Result;
import com.example.demo.Bean.MedicalRecord;
import com.example.demo.Bean.Registration;
import com.example.demo.Dao.MedicalRecordDao;
import com.example.demo.Dao.RegistrationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordDao medicalRecordDao; // 假设有一个 AdmissionDao 负责数据库操作

    @Autowired
    private RegistrationDao registrationDao;

    // 增加
    @PostMapping("/add")
    public String addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        medicalRecordDao.save(medicalRecord);
        return new Result<>(RCFactory.getSuccess(), "相关信息已存入数据库").toString();
    }

    // 删除
    @DeleteMapping("/delete/{rId}")
    public String deleteMedicalRecord(@PathVariable int rId) {
        medicalRecordDao.deleteById(rId);
        return new Result<>(RCFactory.getSuccess(), "数据删除成功").toString();
    }

    // 更新
    @PutMapping("/update")
    public String updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        List<MedicalRecord> medicalRecords = medicalRecordDao.findByRegistrationId(medicalRecord.getRegistrationid());
        for(MedicalRecord item : medicalRecords){
            item.setPreliminaryDiagnosis(medicalRecord.getPreliminaryDiagnosis());
            item.setTreatmentAdvice(medicalRecord.getTreatmentAdvice());
            medicalRecordDao.save(item);
        }
        Registration registrations = registrationDao.findById(medicalRecord.getRegistrationid()).get();
        registrations.setStatus(1);
        registrationDao.save(registrations);

        return new Result<>(RCFactory.getSuccess(), "更改成功").toString();
    }

    // 主键查询
    @GetMapping("/get/{rId}")
    public String getMedicalRecordById(@PathVariable int rId) {
        return new Result<>(RCFactory.getSuccess(), medicalRecordDao.findById(rId).toString()).toString();
    }

    // 显示所有
    @GetMapping("/medicalRecords")
    public String findAll() {
        return new Result<>(RCFactory.getSuccess(),medicalRecordDao.findAll().toString()).toString();
    }

    // 按医生查询
    @GetMapping("/get/doctorId/{doctorId}")
    public String getMedicalRecordByDoctorId(@PathVariable int doctorId) {
        return new Result<>(RCFactory.getSuccess(), medicalRecordDao.findByDoctorId(doctorId).toString()).toString();
    }

//    // 按科室查询
//    @GetMapping("/get/deptId/{deptId}")
//    public String getMedicalRecordByDeptId(@PathVariable int deptId) {
//        return new Result<>(RCFactory.getSuccess(), medicalRecordDao.findByDeptId(deptId).toString()).toString();
//    }

    // 按挂号单id查询
    @GetMapping("/get/registrationId")
    public List<MedicalRecord> getMedicalRecordByRegistrationId(@RequestParam int registrationId) {
        return medicalRecordDao.findByRegistrationId(registrationId);
    }

    // 按患者查询
    @GetMapping("/get/patientId")
    public List<MedicalRecord> getMedicalRecordByPatientId(@RequestParam int patientId) {
        return medicalRecordDao.findByPatientId(patientId);
    }
}