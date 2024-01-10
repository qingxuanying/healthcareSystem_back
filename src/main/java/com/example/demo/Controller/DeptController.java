package com.example.demo.Controller;

import com.example.demo.Answer.RCFactory;
import com.example.demo.Answer.Result;
import com.example.demo.Bean.Dept;
import com.example.demo.Bean.DoctorSchedule;
import com.example.demo.Dao.DeptDao;
import com.example.demo.Dao.DoctorDao;
import com.example.demo.Dao.DoctorScheduleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptDao deptDao; // 假设有一个 AdmissionDao 负责数据库操作

    @Autowired
    private  DoctorScheduleDao doctorScheduleDao;

    @Autowired
    private DoctorDao doctorDao;

    // 增加
    @PostMapping("/add")
    public String addDept(@RequestBody Dept dept) {
        deptDao.save(dept);
        for(int i=1;i<=7;i++){
            DoctorSchedule schedule = new DoctorSchedule();
            schedule.setDoctorId(dept.getDutyDoctor());
            schedule.setDeptId(dept.getDeptId());
            schedule.setWeek(i);
            schedule.setState(0);
            schedule.setDoctorName(doctorDao.findById(dept.getDutyDoctor()).get().getDoctorName());
            doctorScheduleDao.save(schedule);
        }
        return new Result<>(RCFactory.getSuccess(), "相关信息已存入数据库").toString();
    }

    // 删除
    @DeleteMapping("/delete/{deptId}")
    public String deleteDept(@PathVariable int deptId) {
        deptDao.deleteById(deptId);
        return new Result<>(RCFactory.getSuccess(), "数据删除成功").toString();
    }

    // 更新
    @PutMapping("/update")
    public String updateDept(@RequestBody Dept dept) {
        deptDao.save(dept);
        return new Result<>(RCFactory.getSuccess(), "更改成功").toString();
    }

    // 主键查询
    @GetMapping("/get")
    public Optional<Dept> getDeptById(@RequestParam int deptId) {
        return deptDao.findById(deptId);
    }

    //显示所有
    @GetMapping("/depts")
    public List<Dept> findAll() {
        return deptDao.findAll();
    }

    //值班医生查询
    @GetMapping("/get/dutyDoctor/{dutyDoctor}")
    public String getDeptByDutyDoctor(@PathVariable int dutyDoctor) {
        return new Result<>(RCFactory.getSuccess(), deptDao.findByDutyDoctor(dutyDoctor).toString()).toString();
    }
}

