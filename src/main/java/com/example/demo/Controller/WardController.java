package com.example.demo.Controller;

import com.example.demo.Answer.RCFactory;
import com.example.demo.Answer.Result;
import com.example.demo.Bean.Bed;
import com.example.demo.Bean.Ward;
import com.example.demo.Dao.BedDao;
import com.example.demo.Dao.WardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ward")
public class WardController {

    @Autowired
    private WardDao wardDao; // 假设有一个 WardDao 负责数据库操作

    @Autowired
    private BedDao bedDao;

    // 增加
    @PostMapping("/add")
    public String addWard(@RequestBody Ward ward) {
        wardDao.save(ward);
        for(int i=1;i<=6;i++){
            Bed bed = new Bed();
            bed.setWardId(ward.getWardId());
            bed.setBedNumber(i);
            bed.setBedStatus(0);
            bedDao.save(bed);
        }

        return new Result<>(RCFactory.getSuccess(), "相关信息已存入数据库").toString();
    }

    // 删除
    @DeleteMapping("/delete/{wardId}")
    public String deleteWard(@PathVariable int wardId) {
        wardDao.deleteById(wardId);
        return new Result<>(RCFactory.getSuccess(), "数据删除成功").toString();
    }

    // 更新
    @PutMapping("/update")
    public String updateWard(@RequestBody Ward ward) {
        wardDao.save(ward);
        return new Result<>(RCFactory.getSuccess(), "更改成功").toString();
    }

    // 主键查询
    @GetMapping("/get/{wardId}")
    public String getWardById(@PathVariable int wardId) {
        return new Result<>(RCFactory.getSuccess(), wardDao.findById(wardId).toString()).toString();
    }

    //显示所有
    @GetMapping("/wards")
    public List<Ward> findAll() {
        return wardDao.findAll();
    }

    //病房名查找
    @GetMapping("/get/wardName/{wardName}")
    public String getWardByWardName(@PathVariable String wardName) {
        return new Result<>(RCFactory.getSuccess(), wardDao.findByWardName(wardName).toString()).toString();
    }

    //科室id查找
    @GetMapping("/get/deptId/{deptId}")
    public String getWardByDeptId(@PathVariable int deptId) {
        return new Result<>(RCFactory.getSuccess(), wardDao.findByDeptId(deptId).toString()).toString();
    }

    //病房号查找
    @GetMapping("/get/wardNumber/{wardNumber}")
    public String getWardByWardNumber(@PathVariable String wardNumber) {
        return new Result<>(RCFactory.getSuccess(), wardDao.findByWardNumber(wardNumber).toString()).toString();
    }
}

