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
@RequestMapping("/bed")
public class BedController {

    @Autowired
    private BedDao bedDao; // 假设有一个 AdmissionDao 负责数据库操作

    @Autowired
    private WardDao wardDao;

    // 增加
    @PostMapping("/add")
    public String addBed(@RequestBody Bed bed) {
        bedDao.save(bed);
        return new Result<>(RCFactory.getSuccess(), "相关信息已存入数据库").toString();
    }

    // 删除
    @DeleteMapping("/delete/{bedId}")
    public String deleteBed(@PathVariable int bedId) {
        bedDao.deleteById(bedId);
        return new Result<>(RCFactory.getSuccess(), "数据删除成功").toString();
    }

    // 更新
    @PutMapping("/update")
    public String updateBed(@RequestBody Bed bed) {
        System.out.println(bed.getBedId());
        System.out.println((bed.getWardId()));
        bed.setBedStatus(1);

        Ward ward = wardDao.findById(bed.getWardId()).get();
        String str = ward.getStatus();

        StringBuilder stringBuilder = new StringBuilder(str);
        int indexToModify = bed.getBedId()-1; // 修改位置的索引（从0开始）
        char newChar = '1';    // 新的字符
        stringBuilder.setCharAt(indexToModify, newChar);

        String str1 = stringBuilder.toString();
        ward.setStatus(str1);
        wardDao.save(ward);

        bedDao.save(bed);
        return new Result<>(RCFactory.getSuccess(), "更改成功").toString();
    }

    // 主键查询
    @GetMapping("/get/{bedId}")
    public String getBedById(@PathVariable int bedId) {
        return new Result<>(RCFactory.getSuccess(), bedDao.findById(bedId).toString()).toString();
    }

    //显示所有
    @GetMapping("/beds")
    public String findAll() {
        return new Result<>(RCFactory.getSuccess(),bedDao.findAll().toString()).toString();
    }

    //病房id查询
    @PostMapping("/get/wardId")
    public List<Bed> getBedByWardId(@RequestBody Bed bed) {
        return bedDao.findByWardId(bed.getWardId());
    }

}
