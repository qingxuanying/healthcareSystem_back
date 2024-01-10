package com.example.demo.Controller;

import com.example.demo.Answer.RCFactory;
import com.example.demo.Answer.Result;
import com.example.demo.Bean.NurseSchedule;
import com.example.demo.Dao.NurseScheduleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/NurseSchedule")
public class NurseScheduleController {

    @Autowired
    private NurseScheduleDao nurseScheduleDao; // 假设有一个 AdmissionDao 负责数据库操作

    // 增加
    @PostMapping("/add")
    public String addNurseSchedule(@RequestBody NurseSchedule nurseSchedule) {
        nurseScheduleDao.save(nurseSchedule);
        return new Result<>(RCFactory.getSuccess(), "相关信息已存入数据库").toString();
    }

    // 删除
    @DeleteMapping("/delete/{nScheduleId}")
    public String deleteNurseSchedule(@PathVariable int nScheduleId) {
        nurseScheduleDao.deleteById(nScheduleId);
        return new Result<>(RCFactory.getSuccess(), "数据删除成功").toString();
    }

    // 更新
    @PutMapping("/update")
    public String updateNurseSchedule(@RequestBody NurseSchedule nurseSchedule) {
        nurseScheduleDao.save(nurseSchedule);
        return new Result<>(RCFactory.getSuccess(), "更改成功").toString();
    }

    // 主键查询
    @GetMapping("/get/{nScheduleId}")
    public String getNurseScheduleById(@PathVariable int nScheduleId) {
        return new Result<>(RCFactory.getSuccess(), nurseScheduleDao.findById(nScheduleId).toString()).toString();
    }

    // 显示所有
    @GetMapping("/nurseSchedules")
    public String findAll() {
        return new Result<>(RCFactory.getSuccess(),nurseScheduleDao.findAll().toString()).toString();
    }

    // 按护士查询
    @GetMapping("/get/nurseId/{nurseId}")
    public String getNurseScheduleByNurseId(@PathVariable int nurseId) {
        return new Result<>(RCFactory.getSuccess(), nurseScheduleDao.findByNurseId(nurseId).toString()).toString();
    }

    // 按科室查询
    @GetMapping("/get/deptId/{deptId}")
    public String getNurseScheduleByDeptId(@PathVariable int deptId) {
        return new Result<>(RCFactory.getSuccess(), nurseScheduleDao.findByDeptId(deptId).toString()).toString();
    }

    // 按时间查询
    @GetMapping("/get/date/{date}")
    public String getNurseScheduleByDate(@PathVariable Date date) {
        return new Result<>(RCFactory.getSuccess(), nurseScheduleDao.findByDate(date).toString()).toString();
    }
}

