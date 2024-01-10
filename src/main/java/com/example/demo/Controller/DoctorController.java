package com.example.demo.Controller;

import com.example.demo.Answer.RCFactory;
import com.example.demo.Answer.Result;
import com.example.demo.Bean.Admin;
import com.example.demo.Bean.Doctor;
import com.example.demo.Dao.DoctorDao;
import com.example.demo.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorDao doctorDao; // 假设有一个 doctorDao 负责数据库操作

    // 增加
    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor) {
        String password = Md5Util.getMD5(doctor.getDoctorPassword());
        doctor.setDoctorPassword(password);
        this.doctorDao.save(doctor);
        return new Result<>(RCFactory.getSuccess(), "相关信息已存入数据库").toString();
    }
    // 删除
    @DeleteMapping ("/delete")
    public String deleteDoctor(@RequestBody Doctor doctor) {
        doctorDao.deleteById(doctor.getDoctorId());
        return new Result<>(RCFactory.getSuccess(),"数据删除成功").toString();
    }

    // 更新
    @PutMapping("/update")
    public String updateDoctor(@RequestBody Doctor doctor) {
        String password = Md5Util.getMD5(doctor.getDoctorPassword());
        doctor.setDoctorPassword(password);
        doctorDao.save(doctor);
        return new Result<>(RCFactory.getSuccess(),"更改成功").toString();
    }

    // 主键查询
//    @GetMapping("/get")
//    public String getDoctorById(@PathVariable int doctorId) {
//        return new Result<>(RCFactory.getSuccess(),doctorDao.findById(doctorId).toString()).toString();
//    }

    @PostMapping("/get")
    public Optional<Doctor> getDoctorById(@RequestBody Doctor doctor){
        return  doctorDao.findById(doctor.getDoctorId());
    }

    //显示所有
    @GetMapping("/doctors")
    public List<Doctor> findAll() {
        return doctorDao.findAll();
    }

    //医生姓名查找
    @PostMapping("/get/doctorName")
    public List<Doctor> getDoctorByDoctorName(@RequestBody Doctor doctor) {
        return doctorDao.findByDoctorName(doctor.getDoctorName());
    }

    //科室id查找
    @GetMapping("/get/deptId/{deptId}")
    public String getDoctorByDeptId(@PathVariable int deptId) {
        return new Result<>(RCFactory.getSuccess(), doctorDao.findByDeptId(deptId).toString()).toString();
    }

    //职称查找
    @GetMapping("/get/doctorTitle/{doctorTitle}")
    public String getDoctorByPatientId(@PathVariable String doctorTitle) {
        return new Result<>(RCFactory.getSuccess(), doctorDao.findByDoctorTitle(doctorTitle).toString()).toString();
    }

    // 注册
    @PostMapping("/register")
    @ResponseBody
    String Add_doctor(@RequestBody Doctor doctor) {
        try {
            List<Doctor> tar = doctorDao.findByDoctorName(doctor.getDoctorName());
            if (tar.size() == 0) {
                String password = Md5Util.getMD5(doctor.getDoctorPassword());
                doctor.setDoctorPassword(password);
                this.doctorDao.save(doctor);
                return new Result<>(RCFactory.getSuccess(), "注册成功").toString();
            } else {
                return new Result<>(RCFactory.getExistErr(), "该用户已经注册过了，请更换用户名").toString();
            }
        } catch (Exception e) {
            return new Result<>(RCFactory.getNPE(), e.toString()).toString();
        }
    }


    // 登录
    @PostMapping("/doctorLogin")
    public String doctor_login(@RequestBody Doctor doctor) {
//        System.out.println(doctor.getDoctorName());
//        System.out.println(doctor.getDoctorPassword());
        String password = Md5Util.getMD5((doctor.getDoctorPassword()));
        List<Doctor> doctors = this.doctorDao.findByDoctorName(doctor.getDoctorName());
        for (Doctor item : doctors) {
            if (item.getDoctorPassword().equals(password)) {
                return new Result<>(RCFactory.getSuccess(), item.getDoctorId()).toString();
            }
        }
        return new Result<>(RCFactory.getFailed(), "用户名和密码不匹配").toString();
    }

    // 登出
    @PostMapping("/logout")
    public String logout() {
        return new Result<>(RCFactory.getSuccess(),"登出成功").toString();
    }
}

