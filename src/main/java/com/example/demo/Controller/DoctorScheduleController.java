package com.example.demo.Controller;

import com.example.demo.Answer.RCFactory;
import com.example.demo.Answer.Result;
import com.example.demo.Bean.Dept;
import com.example.demo.Bean.DoctorSchedule;
import com.example.demo.Dao.DeptDao;
import com.example.demo.Dao.DoctorScheduleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/doctorSchedule")
public class DoctorScheduleController {

    @Autowired
    private DoctorScheduleDao doctorScheduleDao; // 假设有一个 AdmissionDao 负责数据库操作

    @Autowired
    private DeptDao deptDao;

    // 增加
    @PostMapping("/add")
    public String addDoctorSchedule(@RequestBody DoctorSchedule doctorSchedule) {
        doctorScheduleDao.save(doctorSchedule);
        return new Result<>(RCFactory.getSuccess(), "相关信息已存入数据库").toString();
    }

    // 删除
    @DeleteMapping("/delete/{doctorScheduleId}")
    public String deleteDoctorSchedule(@PathVariable int doctorScheduleId) {
        doctorScheduleDao.deleteById(doctorScheduleId);
        return new Result<>(RCFactory.getSuccess(), "数据删除成功").toString();
    }

    // 更新
    @PutMapping("/update")
    public String updateDoctorSchedule(@RequestBody DoctorSchedule doctorSchedule) {

        Dept dept = deptDao.findById(doctorSchedule.getDeptId()).get();
        String str = dept.getState();
//        int week = doctorSchedule.getweek();
        DoctorSchedule tm = doctorScheduleDao.findById(doctorSchedule.getdoctorScheduleId()).get();
        int week = tm.getweek();
        StringBuilder stringBuilder = new StringBuilder(str);
        int indexToModify = week-1; // 修改位置的索引（从0开始）
        char newChar = '1';    // 新的字符
        stringBuilder.setCharAt(indexToModify, newChar);

        String str1 = stringBuilder.toString();
        System.out.println(str1);
        dept.setState(str1);
        doctorScheduleDao.save(doctorSchedule);
        deptDao.save(dept);
        return new Result<>(RCFactory.getSuccess(), "更改成功").toString();
    }

    // 主键查询
    @GetMapping("/get/{doctorScheduleId}")
    public String getDoctorScheduleById(@PathVariable int doctorScheduleId) {
        return new Result<>(RCFactory.getSuccess(), doctorScheduleDao.findById(doctorScheduleId).toString()).toString();
    }

    // 显示所有
    @GetMapping("/doctorSchedules")
    public String findAll() {
        return new Result<>(RCFactory.getSuccess(),doctorScheduleDao.findAll().toString()).toString();
    }

    // 按医生查询
    @PostMapping("/get/doctorId")
    public List<DoctorSchedule> getDoctorScheduleByDoctorId(@RequestBody DoctorSchedule doctorSchedule) {
        return doctorScheduleDao.findByDoctorId(doctorSchedule.getDoctorId());
    }

    // 按科室查询
    @PostMapping("/get/deptId")
    public List<DoctorSchedule> getDoctorScheduleByDeptId(@RequestBody DoctorSchedule doctorSchedule) {
        return doctorScheduleDao.findByDeptId(doctorSchedule.getDeptId());
    }

    // 按时间查询
    @GetMapping("/get/date/{date}")
    public String getDoctorScheduleByDate(@PathVariable Date date) {
        return new Result<>(RCFactory.getSuccess(), doctorScheduleDao.findByDate(date).toString()).toString();
    }
}

