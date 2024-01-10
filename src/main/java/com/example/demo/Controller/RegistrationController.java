package com.example.demo.Controller;

import com.example.demo.Answer.RCFactory;
import com.example.demo.Answer.Result;
import com.example.demo.Bean.*;
import com.example.demo.Dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationDao registrationDao; // 假设有一个 AdmissionDao 负责数据库操作

    @Autowired
    private PrescriptionDao prescriptionDao;//取药

    @Autowired
    private MedicalRecordDao medicalRecordDao;//诊断

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private PatientDao patientDao;

    // 增加
    @PostMapping("/add")
    public String addRegistration(@RequestBody Registration registration) {
        registration.setPatientname(patientDao.findById(registration.getPatientId()).get().getPatientName());
        registrationDao.save(registration);

        Prescription prescription = new Prescription();
        prescription.setPatientId(registration.getPatientId());
        prescription.setDoctorId(registration.getDoctorId());
        prescription.setRegistrationid(registration.getRegistrationId());
        prescriptionDao.save(prescription);

        MedicalRecord medicalRecord = new MedicalRecord();
        Doctor doctor = doctorDao.findById(registration.getDoctorId()).get();
        medicalRecord.setDoctorId(registration.getDoctorId());
        medicalRecord.setDeptId(doctor.getDeptId());
        medicalRecord.setPatientId(registration.getPatientId());
        medicalRecord.setRegistrationid(registration.getRegistrationId());
        medicalRecordDao.save(medicalRecord);


        return new Result<>(RCFactory.getSuccess(), "相关信息已存入数据库").toString();
    }

    // 删除
    @DeleteMapping("/delete/{registrationId}")
    public String deleteRegistration(@PathVariable int registrationId) {
        registrationDao.deleteById(registrationId);
        return new Result<>(RCFactory.getSuccess(), "数据删除成功").toString();
    }

    // 更新
    @PutMapping("/update")
    public String updateRegistration(@RequestBody Registration registration) {
        registrationDao.save(registration);
        return new Result<>(RCFactory.getSuccess(), "更改成功").toString();
    }

    // 主键查询
    @GetMapping("/get/{registrationId}")
    public String getRegistrationById(@PathVariable int registrationId) {
        return new Result<>(RCFactory.getSuccess(), registrationDao.findById(registrationId).toString()).toString();
    }

    // 显示所有
    @GetMapping("/registrations")
    public String findAll() {
        return new Result<>(RCFactory.getSuccess(), registrationDao.findAll().toString()).toString();
    }

    // 按取医生id查询
    @GetMapping("/get/doctorId")
    public List<Registration> getRegistrationByDoctorId(@RequestParam int doctorId) {
        return registrationDao.findByDoctorId(doctorId);
    }

    // 按病人id查询
    @GetMapping("/get/patientId")
    public List<Registration> getRegistrationByPatientId(@RequestParam int patientId) {
        return registrationDao.findByPatientId(patientId);
    }
}