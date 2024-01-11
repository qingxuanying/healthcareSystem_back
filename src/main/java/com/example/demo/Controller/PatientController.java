package com.example.demo.Controller;

import com.example.demo.Answer.RCFactory;
import com.example.demo.Answer.Result;
import com.example.demo.Bean.Patient;
import com.example.demo.Dao.PatientDao;
import com.example.demo.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientDao patientDao; // 假设有一个 PatientDao 负责数据库操作

    // 增加
    @PostMapping("/add")
    public String addPatient(@RequestBody Patient patient) {
        String password = Md5Util.getMD5(patient.getPatientPassword());
        patient.setPatientPassword(password);
        this.patientDao.save(patient);
        return new Result<>(RCFactory.getSuccess(), "相关信息已存入数据库").toString();
    }

    // 删除
    @DeleteMapping("/delete/{patientId}")
    public String deletePatient(@PathVariable int patientId) {
        patientDao.deleteById(patientId);
        return new Result<>(RCFactory.getSuccess(),"数据删除成功").toString();
    }

    // 更新
    @PutMapping("/update")
    public String updatePatient(@RequestBody Patient patient) {
//        String password = Md5Util.getMD5(patient.getPatientPassword());
//        patient.setPatientPassword(password);
        Patient patient1 = patientDao.findById(patient.getPatientId()).get();
//        System.out.println((patient1.getPatientPassword()));
        patient1.setPatientName(patient.getPatientName());
        patient1.setPatientAge(patient.getPatientAge());
        patient1.setPatientPhone(patient.getPatientPhone());
        patient1.setPatientGender(patient.getPatientGender());
//        patient1.setPatientPassword(patient.getPatientPassword());
        patientDao.save(patient1);
        return new Result<>(RCFactory.getSuccess(),"更改成功").toString();
    }

    // 主键查询
    @PostMapping("/get")
    public Optional<Patient> getPatientById(@RequestBody Patient patient) {
        return patientDao.findById(patient.getPatientId());
    }

    //显示所有
    @GetMapping("/patients")
    public String findAll() {
        return new Result<>(RCFactory.getSuccess(),patientDao.findAll().toString()).toString();
    }

    // 注册
    @PostMapping("/register")
    @ResponseBody
    String Add_Patient(@RequestBody Patient patient) {
        try {
            List<Patient> tar = patientDao.findByPatientName(patient.getPatientName());
            List<Patient> tar1 = patientDao.findAllByPatient_certificates_no(patient.getPatientCertificatesNo());
//            System.out.println(tar1);
            if (tar1.size() == 0) {
//                System.out.println(patient.getPatientPassword());
                String password = Md5Util.getMD5(patient.getPatientPassword());
//                System.out.println(password);
                patient.setPatientPassword(password);
                this.patientDao.save(patient);
                return new Result<>(RCFactory.getSuccess(), "注册成功").toString();
            } else {
                return new Result<>(RCFactory.getExistErr(), "该身份证已经注册过了，请直接登录").toString();
            }
        } catch (Exception e) {
            return new Result<>(RCFactory.getNPE(), e.toString()).toString();
        }
    }


    // 登录
    @PostMapping("/patientlogin")
    public String Patient_login(@RequestBody Patient patient) {
        List<Patient> patients = this.patientDao.findByPatientName(patient.getPatientName());
        String password = Md5Util.getMD5(patient.getPatientPassword());
        System.out.println(password);
//        System.out.println(patients);
        for (Patient item : patients) {
            // 执行对patient的操作
//            System.out.println(item.getPatientPassword());
            if(item.getPatientPassword().equals(password)){
                return new Result<>(RCFactory.getSuccess(),item.getPatientId()).toString();
            }
        }
        return new Result<>(RCFactory.getFailed(), "用户名与密码不匹配").toString();

    }

    // 登出
    @PostMapping("/logout")
    public String logout() {
        return new Result<>(RCFactory.getSuccess(),"登出成功").toString();
    }


    //文件上传
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("photo") MultipartFile file, @RequestParam("patientid") int patientid) {
        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            Patient patient = patientDao.findById(patientid).get();

            Path uploadPath = Paths.get("C:\\Users\\59770\\Desktop\\2023_winter_class\\Code\\back\\health_sys\\demo\\imgs");
            Files.copy(file.getInputStream(), uploadPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);

            patient.setPhoto(fileName);
            patientDao.save(patient);
            return new Result<>(RCFactory.getSuccess(),"success upload").toString();
        } catch (Exception e) {
            return new Result<>(RCFactory.getFailed(),e.toString()).toString();
        }
    }

//    文件显示
    @GetMapping("/getphoto")
    public ResponseEntity<Resource> readFile(@RequestParam int patientid) {
        // 构建文件的绝对路径
        Path filePath = Paths.get("C:\\Users\\59770\\Desktop\\2023_winter_class\\Code\\back\\health_sys\\demo\\imgs").
                resolve(patientDao.findById(patientid).get().getPhoto()).normalize();
        try {
            // 加载文件作为资源
            Resource resource = new FileSystemResource(filePath.toFile());
            // 获取文件的MIME类型
            String contentType = Files.probeContentType(filePath);
            // 构建响应
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

}

