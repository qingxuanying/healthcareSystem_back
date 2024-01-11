package com.example.demo.Controller;


import com.example.demo.Answer.RCFactory;
import com.example.demo.Answer.Result;
import com.example.demo.Bean.Admin;
import com.example.demo.Bean.Admission;
import com.example.demo.Bean.Patient;
import com.example.demo.Dao.AdminDao;
import com.example.demo.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminDao adminDao; // 假设有一个 AdminDao 负责数据库操作

    // 增加
    @PostMapping("/add")
    public String addAdmin(@RequestBody Admin admin) {

        String password = Md5Util.getMD5(admin.getAdminPassword());
        admin.setAdminPassword(password);
        this.adminDao.save(admin);
        return new Result<>(RCFactory.getSuccess(), "相关信息已存入数据库").toString();
    }

    // 删除
    @DeleteMapping("/delete/{adminId}")
    public String deleteAdmin(@PathVariable int adminId) {
        adminDao.deleteById(adminId);
        return new Result<>(RCFactory.getSuccess(),"数据删除成功").toString();
    }

    // 更新
    @PutMapping("/update")
    public String updateAdmin(@RequestBody Admin admin) {
        String password = Md5Util.getMD5(admin.getAdminPassword());
        admin.setAdminPassword(password);
        adminDao.save(admin);
        return new Result<>(RCFactory.getSuccess(),"更改成功").toString();
    }

    // 主键查询
    @GetMapping("/get/{adminId}")
    public String getAdminById(@PathVariable int adminId) {
        return new Result<>(RCFactory.getSuccess(),adminDao.findById(adminId).toString()).toString();
    }

    //显示所有
    @GetMapping("/admins")
    public String findAll() {
        return new Result<>(RCFactory.getSuccess(),adminDao.findAll().toString()).toString();
    }

    // 注册
    @PostMapping("/register")
    @ResponseBody
    String Add_admin(@RequestBody Admin admin) {
        try {
            List<Admin> tar = adminDao.findByAdminName(admin.getAdminName());
            if (tar.size() == 0) {
                String password = Md5Util.getMD5(admin.getAdminPassword());
                admin.setAdminPassword(password);
                this.adminDao.save(admin);
                return new Result<>(RCFactory.getSuccess(), "注册成功").toString();
            } else {
                return new Result<>(RCFactory.getExistErr(), "该用户已经注册过了，请更换用户名").toString();
            }
        } catch (Exception e) {
            return new Result<>(RCFactory.getNPE(), e.toString()).toString();
        }
    }


    // 登录
    @PostMapping("/adminlogin")
    public String admin_login(@RequestBody Admin admin) {
//        Admin admin = this.adminDao.findById(adminId).get();
        String password = Md5Util.getMD5(admin.getAdminPassword());
        List<Admin> admins = this.adminDao.findByAdminName(admin.getAdminName());
        for (Admin item : admins ){
            System.out.println(password);
            if(item.getAdminPassword().equals(password)){
                return new Result<>(RCFactory.getSuccess(),item.getAdminId()).toString();
            }
        }
        return new Result<>(RCFactory.getFailed(), "用户名输入错误").toString();
        
    }

    // 登出
    @PostMapping("/logout")
    public String logout() {
        return new Result<>(RCFactory.getSuccess(),"登出成功").toString();
    }
}
