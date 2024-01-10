package com.example.demo.Controller;


import com.example.demo.Answer.RCFactory;
import com.example.demo.Answer.Result;
import com.example.demo.Bean.Admission;
import com.example.demo.Dao.AdmissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/admission")
public class AdmissionController {

    @Autowired
    private AdmissionDao admissionDao; // 假设有一个 AdmissionDao 负责数据库操作

    // 增加
    @PostMapping("/add")
    public String addAdmission(@RequestBody Admission admission) {
        admissionDao.save(admission);
        return new Result<>(RCFactory.getSuccess(), "相关信息已存入数据库").toString();
    }

    // 删除
    @DeleteMapping("/delete/{admissionId}")
    public String deleteAdmission(@PathVariable int admissionId) {
        admissionDao.deleteById(admissionId);
        return new Result<>(RCFactory.getSuccess(), "数据删除成功").toString();
    }

    // 更新
    @PutMapping("/update")
    public String updateAdmission(@RequestBody Admission admission) {
        admissionDao.save(admission);
        return new Result<>(RCFactory.getSuccess(), "更改成功").toString();
    }

    // 主键查询
    @GetMapping("/get/{admissionId}")
    public String getAdmissionById(@PathVariable int admissionId) {
        return new Result<>(RCFactory.getSuccess(), admissionDao.findById(admissionId).toString()).toString();
    }

    //显示所有
    @GetMapping("/admissions")
    public String findAll() {
        return new Result<>(RCFactory.getSuccess(),admissionDao.findAll().toString()).toString();
    }

    //患者id查询
    @GetMapping("/get/patientId/{patientId}")
    public String getAdmissionByPatientId(@PathVariable int patientId) {
        return new Result<>(RCFactory.getSuccess(), admissionDao.findByPatientId(patientId).toString()).toString();
    }

    //医生id查询
    @GetMapping("/get/doctorId/{doctorId}")
    public String getAdmissionByDoctorId(@PathVariable int doctorId) {
        return new Result<>(RCFactory.getSuccess(), admissionDao.findByDoctorId(doctorId).toString()).toString();
    }

    //科室id查询
    @GetMapping("/get/deptId/{deptId}")
    public String getAdmissionByDeptId(@PathVariable int deptId) {
        return new Result<>(RCFactory.getSuccess(), admissionDao.findByDeptId(deptId).toString()).toString();
    }

    //病房id查询
    @GetMapping("/get/wardId/{wardId}")
    public String getAdmissionByWardId(@PathVariable int wardId) {
        return new Result<>(RCFactory.getSuccess(), admissionDao.findByWardId(wardId).toString()).toString();
    }

}