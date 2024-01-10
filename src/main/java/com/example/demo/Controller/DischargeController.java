package com.example.demo.Controller;

import com.example.demo.Answer.RCFactory;
import com.example.demo.Answer.Result;
import com.example.demo.Bean.Discharge;
import com.example.demo.Dao.DischargeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discharge")
public class DischargeController {

    @Autowired
    private DischargeDao dischargeDao; // 假设有一个 dischargeDao 负责数据库操作

    // 增加
    @PostMapping("/add")
    public String adddischarge(@RequestBody Discharge discharge) {
        dischargeDao.save(discharge);
        return new Result<>(RCFactory.getSuccess(), "相关信息已存入数据库").toString();
    }

    // 删除
    @DeleteMapping("/delete/{dischargeId}")
    public String deleteAdmin(@PathVariable int dischargeId) {
        dischargeDao.deleteById(dischargeId);
        return new Result<>(RCFactory.getSuccess(), "数据删除成功").toString();
    }

    // 更新
    @PutMapping("/update")
    public String updateAdmin(@RequestBody Discharge discharge) {
        dischargeDao.save(discharge);
        return new Result<>(RCFactory.getSuccess(), "更改成功").toString();
    }

    // 主键查询
    @GetMapping("/get/{dischargeId}")
    public String getAdminById(@PathVariable int dischargeId) {
        return new Result<>(RCFactory.getSuccess(), dischargeDao.findById(dischargeId).toString()).toString();
    }

    //显示所有
    @GetMapping("/discharges")
    public String findAll() {
        return new Result<>(RCFactory.getSuccess(),dischargeDao.findAll().toString()).toString();
    }

    //患者id查询
    @GetMapping("/get/patient/{patientId}")
    public String getDischargeByPatientId(@PathVariable int patientId) {
        return new Result<>(RCFactory.getSuccess(), dischargeDao.findByPatientId(patientId).toString()).toString();
    }

    //医生id查询
    @GetMapping("/get/doctorId/{doctorId}")
    public String getDischargeByDoctorId(@PathVariable int doctorId) {
        return new Result<>(RCFactory.getSuccess(), dischargeDao.findByDoctorId(doctorId).toString()).toString();
    }

    //科室id查询
    @GetMapping("/get/deptId/{deptId}")
    public String getDischargeByDeptId(@PathVariable int deptId) {
        return new Result<>(RCFactory.getSuccess(), dischargeDao.findByDeptId(deptId).toString()).toString();
    }

    //病房id查询
    @GetMapping("/get/wardId/{wardId}")
    public String getDischargeByWardId(@PathVariable int wardId) {
        return new Result<>(RCFactory.getSuccess(), dischargeDao.findByWardId(wardId).toString()).toString();
    }

}
