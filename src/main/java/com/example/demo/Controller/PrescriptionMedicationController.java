package com.example.demo.Controller;

import com.example.demo.Answer.RCFactory;
import com.example.demo.Answer.Result;
import com.example.demo.Bean.Medication;
import com.example.demo.Bean.PrescriptionMedication;
import com.example.demo.Dao.MedicationDao;
import com.example.demo.Dao.PrescriptionMedicationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/prescriptionMedication")
public class PrescriptionMedicationController {

    @Autowired
    private PrescriptionMedicationDao prescriptionMedicationDao; // 假设有一个 AdmissionDao 负责数据库操作

    @Autowired
    private MedicationDao medicationDao;

    // 增加
    @PostMapping("/add")
    public String addPrescriptionMedication(@RequestBody PrescriptionMedication prescriptionMedication) {
        List<Medication> items = medicationDao.findByMedicationName(prescriptionMedication.getMedicationname());
        for(Medication i : items){
            prescriptionMedication.setMedicationId(i.getMedicationId());
        }
        prescriptionMedicationDao.save(prescriptionMedication);
        return new Result<>(RCFactory.getSuccess(), "相关信息已存入数据库").toString();
    }

    // 删除
    @DeleteMapping("/delete")
    public String deletePrescriptionMedication(@RequestParam int pMId) {
        prescriptionMedicationDao.deleteById(pMId);
        return new Result<>(RCFactory.getSuccess(), "数据删除成功").toString();
    }

    // 更新
    @PutMapping("/update")
    public String updatePrescriptionMedication(@RequestBody PrescriptionMedication prescriptionMedication) {
        prescriptionMedicationDao.save(prescriptionMedication);
        return new Result<>(RCFactory.getSuccess(), "更改成功").toString();
    }

    // 主键查询
    @GetMapping("/get/{pMId}")
    public String getPrescriptionMedicationById(@PathVariable int pMId) {
        return new Result<>(RCFactory.getSuccess(), prescriptionMedicationDao.findById(pMId).toString()).toString();
    }

    // 显示所有
    @GetMapping("/prescriptionMedications")
    public String findAll() {
        return new Result<>(RCFactory.getSuccess(), prescriptionMedicationDao.findAll().toString()).toString();
    }

    // 按取单id查询
    @GetMapping("/get/prescriptionId")
    public List<PrescriptionMedication> getPrescriptionMedicationByPrescriptionId(@RequestParam int prescriptionId) {
        return prescriptionMedicationDao.findByPrescriptionId(prescriptionId);
    }

    // 按药品id查询
    @GetMapping("/get/medicationId/{medicationId}")
    public String getPrescriptionMedicationByMedicationId(@PathVariable int medicationId) {
        return new Result<>(RCFactory.getSuccess(), prescriptionMedicationDao.findByMedicationId(medicationId).toString()).toString();
    }
}