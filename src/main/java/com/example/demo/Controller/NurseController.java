package com.example.demo.Controller;


import com.example.demo.Answer.RCFactory;
import com.example.demo.Answer.Result;
import com.example.demo.Bean.Nurse;
import com.example.demo.Dao.NurseDao;
import com.example.demo.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Nurse")
public class NurseController {

    @Autowired
    private NurseDao nurseDao; // 假设有一个 NurseDao 负责数据库操作

    // 增加
    @PostMapping("/add")
    public String addNurse(@RequestBody Nurse nurse) {
        String password = Md5Util.getMD5(nurse.getNursePassword());
        nurse.setNursePassword(password);
        this.nurseDao.save(nurse);
        return new Result<>(RCFactory.getSuccess(), "相关信息已存入数据库").toString();
    }

    // 删除
    @DeleteMapping("/delete/{nurseId}")
    public String deleteNurse(@PathVariable int nurseId) {
        nurseDao.deleteById(nurseId);
        return new Result<>(RCFactory.getSuccess(),"数据删除成功").toString();
    }

    // 更新
    @PutMapping("/update")
    public String updateNurse(@RequestBody Nurse nurse) {
        String password = Md5Util.getMD5(nurse.getNursePassword());
        nurse.setNursePassword(password);
        nurseDao.save(nurse);
        return new Result<>(RCFactory.getSuccess(),"更改成功").toString();
    }

    // 主键查询
    @GetMapping("/get/{nurseId}")
    public String getNurseById(@PathVariable int nurseId) {
        return new Result<>(RCFactory.getSuccess(),nurseDao.findById(nurseId).toString()).toString();
    }

    //显示所有
    @GetMapping("/nurses")
    public String findAll() {
        return new Result<>(RCFactory.getSuccess(),nurseDao.findAll().toString()).toString();
    }

    //医生姓名查找
    @GetMapping("/get/nurseName/{nurseName}")
    public String getNurseByNurseName(@PathVariable String nurseName) {
        return new Result<>(RCFactory.getSuccess(), nurseDao.findByNurseName(nurseName).toString()).toString();
    }

    //科室id查找
    @GetMapping("/get/deptId/{deptId}")
    public String getNurseByDeptId(@PathVariable int deptId) {
        return new Result<>(RCFactory.getSuccess(), nurseDao.findByDeptId(deptId).toString()).toString();
    }

    //职称查找
    @GetMapping("/get/nurseTitle/{nurseTitle}")
    public String getNurseByPatientId(@PathVariable String nurseTitle) {
        return new Result<>(RCFactory.getSuccess(), nurseDao.findByNurseTitle(nurseTitle).toString()).toString();
    }

    // 注册
    @PostMapping("/register")
    @ResponseBody
    String Add_Nurse(@RequestBody Nurse nurse) {
        try {
            List<Nurse> tar = nurseDao.findByNurseName(nurse.getNurseName());
            if (tar.size() == 0) {
                String password = Md5Util.getMD5(nurse.getNursePassword());
                nurse.setNursePassword(password);
                this.nurseDao.save(nurse);
                return new Result<>(RCFactory.getSuccess(), "注册成功").toString();
            } else {
                return new Result<>(RCFactory.getExistErr(), "该用户已经注册过了，请更换用户名").toString();
            }
        } catch (Exception e) {
            return new Result<>(RCFactory.getNPE(), e.toString()).toString();
        }
    }


    // 登录
    @PostMapping("/nurseLogin")
    public String Nurse_login(@RequestParam(name = "nurseid") int NurseId, @RequestParam(name = "nursepassword") String NursePassword) {
        Nurse nurse = this.nurseDao.findById(NurseId).get();
        String password = Md5Util.getMD5(NursePassword);
        if (nurse == null) {
            return new Result<>(RCFactory.getFailed(), "用户名输入错误").toString();
        } else {
            if ((nurse.getNursePassword()).equals(password)) {
                return new Result<>(RCFactory.getSuccess(),"登录成功").toString();
            }
            else {
                return new Result<>(RCFactory.getFailed(), "用户名与密码不匹配").toString();
            }
        }
    }

    // 登出
    @PostMapping("/logout")
    public String logout() {
        return new Result<>(RCFactory.getSuccess(),"登出成功").toString();
    }
}
