/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80034 (8.0.34)
 Source Host           : localhost:3306
 Source Schema         : sims_db

 Target Server Type    : MySQL
 Target Server Version : 80034 (8.0.34)
 File Encoding         : 65001

 Date: 31/12/2023 00:05:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
drop database if exists sims_db;
create database sims_db;
use sims_db;
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int NOT NULL AUTO_INCREMENT COMMENT '管理员ID,主键',
  `admin_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员姓名',
  `admin_password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for admission
-- ----------------------------
DROP TABLE IF EXISTS `admission`;
CREATE TABLE `admission`  (
  `admission_id` int NOT NULL AUTO_INCREMENT COMMENT '入院ID，主键自增',
  `patient_id` int NOT NULL COMMENT '患者ID，外键参考患者表',
  `doctor_id` int NOT NULL COMMENT '主治医师ID，外键参考医生表',
  `dept_id` int NOT NULL COMMENT '科室ID，外键参考科室表',
  `diagnosis` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '入院诊断',
  `ward_id` int NOT NULL COMMENT '病房ID，外键参考病房表',
  `bed_id` int NOT NULL COMMENT '床位ID，外键参考床位表',
  `admission_fee` decimal(10, 2) NOT NULL COMMENT '预交金',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`admission_id`) USING BTREE,
  INDEX `patient_id`(`patient_id` ASC) USING BTREE,
  INDEX `doctor_id`(`doctor_id` ASC) USING BTREE,
  INDEX `dept_id`(`dept_id` ASC) USING BTREE,
  INDEX `ward_id`(`ward_id` ASC) USING BTREE,
  INDEX `bed_id`(`bed_id` ASC) USING BTREE,
  CONSTRAINT `admission_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `admission_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `admission_ibfk_3` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `admission_ibfk_4` FOREIGN KEY (`ward_id`) REFERENCES `ward` (`ward_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `admission_ibfk_5` FOREIGN KEY (`bed_id`) REFERENCES `bed` (`bed_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '入院信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admission
-- ----------------------------

-- ----------------------------
-- Table structure for bed
-- ----------------------------
DROP TABLE IF EXISTS `bed`;
CREATE TABLE `bed`  (
  `bed_id` int NOT NULL auto_increment COMMENT '床位ID，主键自增',
  `ward_id` int NOT NULL COMMENT '病房ID，外键参考病房表',
  `bed_number` int NOT NULL COMMENT '床位号',
  `bed_statu` int NULL DEFAULT 0 COMMENT '床位状态，0表示空，1表示占用',
  `patient_id` int default null COMMENT '患者ID',
  `patient_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '患者姓名',
  `patient_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci default '未知' COMMENT '患者状态',
  PRIMARY KEY (`bed_id`,`ward_id`) USING BTREE,
  INDEX `ward_id`(`ward_id` ASC) USING BTREE,
  CONSTRAINT `bed_ibfk_1` FOREIGN KEY (`ward_id`) REFERENCES `ward` (`ward_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '床位表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bed
-- ----------------------------

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `dept_id` int NOT NULL AUTO_INCREMENT COMMENT '科室ID',
  `dept_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '科室名称',
  `duty_doctor` int DEFAULT 0 COMMENT '值班医生ID,默认为null',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除，默认为false',
  `state` varchar(7) NOT NULL default '0000000' comment '状态',
  PRIMARY KEY (`dept_id`) USING BTREE,
  INDEX `duty_doctor`(`duty_doctor` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '科室表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------

-- ----------------------------
-- Table structure for discharge
-- ----------------------------
DROP TABLE IF EXISTS `discharge`;
CREATE TABLE `discharge`  (
  `discharge_id` int NOT NULL AUTO_INCREMENT COMMENT '出院表ID，主键自增',
  `patient_id` int NOT NULL COMMENT '患者ID，外键参考患者表',
  `doctor_id` int NOT NULL COMMENT '主治医师ID，外键参考医生表',
  `dept_id` int NOT NULL COMMENT '科室ID，外键参考科室表',
  `ward_id` int NOT NULL COMMENT '病房ID，外键参考病房表',
  `bed_id` int NOT NULL COMMENT '床位ID，外键参考床位表',
  `discharge_date` date NOT NULL COMMENT '出院日期',
  `discharge_reason` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '出院原因',
  `settlement_info` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '结算信息',
  `remarks` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '备注信息',
  PRIMARY KEY (`discharge_id`) USING BTREE,
  INDEX `patient_id`(`patient_id` ASC) USING BTREE,
  INDEX `doctor_id`(`doctor_id` ASC) USING BTREE,
  INDEX `dept_id`(`dept_id` ASC) USING BTREE,
  INDEX `ward_id`(`ward_id` ASC) USING BTREE,
  INDEX `bed_id`(`bed_id` ASC) USING BTREE,
  CONSTRAINT `discharge_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `discharge_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `discharge_ibfk_3` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `discharge_ibfk_4` FOREIGN KEY (`ward_id`) REFERENCES `ward` (`ward_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `discharge_ibfk_5` FOREIGN KEY (`bed_id`) REFERENCES `bed` (`bed_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '出院信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of discharge
-- ----------------------------

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `doctor_id` int NOT NULL AUTO_INCREMENT COMMENT '医生ID',
  `doctor_password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '医生密码',
  `doctor_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '医生姓名',
  `doctor_age` int NOT NULL DEFAULT 0 COMMENT '医生年龄，默认为0',
  `doctor_gender` int NOT NULL DEFAULT 0 COMMENT '医生性别，0为未知，1为男，2为女',
  `doctor_photo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '医生照片，存文件路径或者base64编码',
  `doctor_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '医生联系方式',
  `doctor_certificates_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '医生身份证号',
  `doctor_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '医生职称',
  `dept_id` int NULL DEFAULT NULL COMMENT '医生科室，外键依赖dept表',
  `dept_name` varchar(50) default null COMMENT '医生科室名',
  `fee` int not null default 5 comment '挂号费',
  `doctor_introduction` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '医生介绍',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除，默认为false',
  `version` int default null,
   PRIMARY KEY (`doctor_id`) USING BTREE,
   CONSTRAINT `doctor_ibfk_2` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '医生表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctor
-- ----------------------------

-- ----------------------------
-- Table structure for doctor_schedule
-- ----------------------------
DROP TABLE IF EXISTS `doctor_schedule`;
CREATE TABLE `doctor_schedule`  (
  `d_schedule_id` int NOT NULL AUTO_INCREMENT COMMENT '排班ID，主键自增',
  `doctor_id` int NOT NULL COMMENT '医生ID，外键参考医生表',
  `dept_id` int NOT NULL COMMENT '科室ID，外键参考科室表',
  `date` date NULL DEFAULT NULL COMMENT '排班日期',
  `week` int NOT NULL COMMENT '周几',
  `state` int NOT NULL COMMENT '状态',
  `doctor_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '医生姓名',
  PRIMARY KEY (`d_schedule_id`) USING BTREE,
  INDEX `doctor_id`(`doctor_id` ASC) USING BTREE,
  INDEX `dept_id`(`dept_id` ASC) USING BTREE,
  CONSTRAINT `doctor_schedule_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `doctor_schedule_ibfk_2` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '医生排班表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctor_schedule
-- ----------------------------

-- ----------------------------
-- Table structure for medical_record
-- ----------------------------
DROP TABLE IF EXISTS `medical_record`;
CREATE TABLE `medical_record` (
    `rid` INT NOT NULL AUTO_INCREMENT,
    `patient_id` INT NOT NULL COMMENT '患者ID，外键参考患者表',
    dept_id INT NOT NULL COMMENT '就诊部门ID，外键参考部门表',
    registration_id INT,
    visit_time VARCHAR(50) COMMENT '就诊的时间',
    medical_history VARCHAR(255) NULL COMMENT '病史',
    preliminary_diagnosis VARCHAR(255) NULL COMMENT '初步诊断',
    treatment_advice VARCHAR(255) NULL COMMENT '治疗意见',
    doctor_id INT NOT NULL COMMENT '医生ID，外键参考医生表',
    is_delete TINYINT(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除标志，非空，默认为0（未删除）',
    PRIMARY KEY (rid) USING BTREE,
    INDEX patient_id (patient_id ASC) USING BTREE,
    INDEX doctor_id (doctor_id ASC) USING BTREE,
    INDEX medical_record_ibfk_2 (dept_id ASC) USING BTREE,
    CONSTRAINT medical_record_ibfk_1 FOREIGN KEY (patient_id)
        REFERENCES patient (patient_id)
        ON DELETE CASCADE ON UPDATE RESTRICT,
    CONSTRAINT medical_record_ibfk_3 FOREIGN KEY (doctor_id)
        REFERENCES doctor (doctor_id)
        ON DELETE CASCADE ON UPDATE RESTRICT,
    CONSTRAINT medical_record_ibfk_2 FOREIGN KEY (dept_id)
        REFERENCES dept (dept_id)
        ON DELETE CASCADE ON UPDATE RESTRICT
)  ENGINE=INNODB CHARACTER SET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI COMMENT='病历表' ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of medical_record
-- ----------------------------

-- ----------------------------
-- Table structure for medication
-- ----------------------------
DROP TABLE IF EXISTS `medication`;
CREATE TABLE `medication`  (
  `medication_id` int NOT NULL AUTO_INCREMENT COMMENT '药品ID，自增主键',
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '药品类别',
  `medication_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '药品名称，非空',
  `purchase_price` decimal(10, 2) NOT NULL COMMENT '药品进价，非空',
  `selling_price` decimal(10, 2) NOT NULL COMMENT '药品售价，非空',
  `manufacturer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '生产厂商',
  `inventory` int NOT NULL DEFAULT 0 COMMENT '库存量，非空，默认为0',
  `expiration_date` date NULL DEFAULT NULL COMMENT '有效期',
  PRIMARY KEY (`medication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '药品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of medication
-- ----------------------------

-- ----------------------------
-- Table structure for nurse
-- ----------------------------
DROP TABLE IF EXISTS `nurse`;
CREATE TABLE `nurse`  (
  `nurse_id` int NOT NULL AUTO_INCREMENT COMMENT '护士ID',
  `nurse_password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '护士密码',
  `nurse_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '护士姓名',
  `nurse_age` int NOT NULL DEFAULT 0 COMMENT '护士年龄，默认为0',
  `nurse_gender` int NOT NULL DEFAULT 0 COMMENT '护士性别，0为未知，1为男，2为女',
  `nurse_photo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '护士照片',
  `nurse_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '护士联系方式',
  `nurse_certificates_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '护士身份证号',
  `nurse_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '护士职称',
  `dept_id` int NULL DEFAULT NULL COMMENT '护士科室',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除，默认为false',
  PRIMARY KEY (`nurse_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '护士表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nurse
-- ----------------------------

-- ----------------------------
-- Table structure for nurse_schedule
-- ----------------------------
DROP TABLE IF EXISTS `nurse_schedule`;
CREATE TABLE `nurse_schedule`  (
  `n_schedule_id` int NOT NULL AUTO_INCREMENT COMMENT '排班ID，主键自增',
  `nurse_id` int NOT NULL COMMENT '护士ID，外键参考护士表',
  `dept_id` int NOT NULL COMMENT '科室ID，外键参考科室表',
  `date` date NULL DEFAULT NULL COMMENT '排班日期',
  `start_time` time NULL DEFAULT NULL COMMENT '上班时间',
  `end_time` time NULL DEFAULT NULL COMMENT '下班时间',
  PRIMARY KEY (`n_schedule_id`) USING BTREE,
  INDEX `nurse_id`(`nurse_id` ASC) USING BTREE,
  INDEX `dept_id`(`dept_id` ASC) USING BTREE,
  CONSTRAINT `nurse_schedule_ibfk_1` FOREIGN KEY (`nurse_id`) REFERENCES `nurse` (`nurse_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `nurse_schedule_ibfk_2` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '护士排班表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nurse_schedule
-- ----------------------------

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`  (
  `patient_id` int NOT NULL auto_increment COMMENT '患者ID，主键',
  `patient_password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '患者密码',
  `patient_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '患者姓名',
  `photo` varchar(50) default null ,
  `patient_age` int NOT NULL DEFAULT 0 COMMENT '患者年龄，默认为0',
  `patient_gender` int NOT NULL DEFAULT 0 COMMENT '患者性别，0为未知，1为男，2为女',
  `patient_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '患者联系方式',
  `patient_certificates_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '患者身份证号',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除，默认为false',
  PRIMARY KEY (`patient_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '患者表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of patient
-- ----------------------------

-- ----------------------------
-- Table structure for prescription
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription`  (
  `prescription_id` int NOT NULL AUTO_INCREMENT COMMENT '取药单ID',
  `patient_id` int NOT NULL COMMENT '患者ID，外键参考患者表',
  `registration_id` int,
  `doctor_id` int NOT NULL COMMENT '医生ID，外键参考医生表',
  `prescription_date` varchar(50) NOT NULL COMMENT '开单时间',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '待取药' COMMENT '是否取了药，非空，默认值为\"待取药\"',
  PRIMARY KEY (`prescription_id`) USING BTREE,
  INDEX `patient_id`(`patient_id` ASC) USING BTREE,
  INDEX `doctor_id`(`doctor_id` ASC) USING BTREE,
  CONSTRAINT `prescription_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `prescription_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '取药单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of prescription
-- ----------------------------

-- ----------------------------
-- Table structure for prescription_medication
-- ----------------------------
DROP TABLE IF EXISTS `prescription_medication`;
CREATE TABLE `prescription_medication`  (
  `p_m_id` int NOT NULL AUTO_INCREMENT COMMENT '关联ID，主键自增',
  `prescription_id` int NOT NULL COMMENT '取药单ID，外键参考取药单表',
  `medication_id` int NOT NULL COMMENT '药品ID，外键参考药品表,随药品名自动形成',
  `medication_name` varchar(50) comment '药品名，外键参考药品表',
  `dosage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '服药剂量',
  `frequency` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '服药频率',
  `number` int NOT NULL DEFAULT 0 COMMENT '取药数量，非空，默认为0',
  PRIMARY KEY (`p_m_id`) USING BTREE,
  INDEX `prescription_id`(`prescription_id` ASC) USING BTREE,
  INDEX `medication_id`(`medication_id` ASC) USING BTREE,
  CONSTRAINT `prescription_medication_ibfk_1` FOREIGN KEY (`prescription_id`) REFERENCES `prescription` (`prescription_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `prescription_medication_ibfk_2` FOREIGN KEY (`medication_id`) REFERENCES `medication` (`medication_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '取药单药品关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of prescription_medication
-- ----------------------------

-- ----------------------------
-- Table structure for registration
-- ----------------------------
DROP TABLE IF EXISTS `registration`;
CREATE TABLE `registration`  (
  `registration_id` int NOT NULL AUTO_INCREMENT COMMENT '挂号记录ID，主键自增',
  `patient_id` int NOT NULL COMMENT '患者ID，外键参考患者表',
  `patient_name` varchar(20)  default null comment '患者姓名，由id自动插入',
  `doctor_id` int NOT NULL COMMENT '医生ID，外键参考医生表',
  `status` int default 0 COMMENT '该挂号就诊状态',
  `available_slots` int NOT NULL COMMENT '号码余量',
  `registration_date` varchar(50) NULL DEFAULT NULL COMMENT '挂号日期',
  `fee` int NULL DEFAULT NULL COMMENT '挂号费用',
  `decrept` varchar(50) default null,
  PRIMARY KEY (`registration_id`) USING BTREE,
  INDEX `patient_id`(`patient_id` ASC) USING BTREE,
  INDEX `doctor_id`(`doctor_id` ASC) USING BTREE,
  CONSTRAINT `registration_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `registration_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '挂号表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of registration
-- ----------------------------

-- ----------------------------
-- Table structure for ward
-- ----------------------------
DROP TABLE IF EXISTS `ward`;
CREATE TABLE `ward`  (
  `ward_id` int NOT NULL AUTO_INCREMENT COMMENT '病房ID，主键自增',
  `ward_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '病房号',
  `ward_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '病房名',
  `ward_capacity` int NOT NULL COMMENT '病房容量',
  `available_bed` int NOT NULL COMMENT '可用床位数',
  `status` varchar(6) not NULL default '000000' comment '床位状态',
  `dept_id` int NOT NULL COMMENT '所属科室ID，外键参考科室表',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '病房描述',
  PRIMARY KEY (`ward_id`) USING BTREE,
  INDEX `dept_id`(`dept_id` ASC) USING BTREE,
  CONSTRAINT `ward_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '病房管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ward
-- ----------------------------

INSERT INTO `dept` (`dept_name`, `duty_doctor`, `is_delete`, `state`)
VALUES ('精神科', 0, 0, '0000000'),
       ('外科', 0, 0, '0000000'),
       ('内科', 0, 0, '0000000'),
       ('消化内科', 0, 0, '0000000'),
       ('皮肤科', 0, 0, '0000000'),
       ('儿科', 0, 0, '0000000'),
       ('肛肠科', 0, 0, '0000000'),
       ('心理科', 0, 0, '0000000'),
       ('康复科', 0, 0, '0000000'),
       ('其他科', 0, 0, '0000000'),
       ('耳鼻喉科', 0, 0, '0000000'),
       ('眼科', 0, 0, '0000000');
INSERT INTO `admin` (`admin_name`, `admin_password`)
VALUES ('root', '96c275481f2317ca59ba818c17364479');


INSERT INTO `doctor` (`doctor_password`, `doctor_name`, `doctor_age`, `doctor_gender`, `doctor_photo`, `doctor_phone`, `doctor_certificates_no`, `doctor_title`, `dept_id`, `doctor_introduction`, `is_delete`, `version`)
VALUES
('96c275481f2317ca59ba818c17364479', '派大星', 25, 1, '', '1234567890', 'ID1', '主治医生', 1, '派大星主刀，保证你有来无回', 0, 1),
('96c275481f2317ca59ba818c17364479', '李世民', 30, 2, '', '2345678901', 'ID2', '主任医生', 2, '医生介绍2', 0, 1),
('96c275481f2317ca59ba818c17364479', '刘邦', 35, 1, '', '3456789012', 'ID3', '副主任医生', 3, '医生介绍3', 0, 1),
('96c275481f2317ca59ba818c17364479', '刘恒', 40, 2, '', '4567890123', 'ID4', '主治医生', 4, '医生介绍4', 0, 1),
('96c275481f2317ca59ba818c17364479', '刘秀', 45, 1, '', '5678901234', 'ID5', '主任医生', 5, '医生介绍5', 0, 1),
('96c275481f2317ca59ba818c17364479', '刘彻', 50, 2, '', '6789012345', 'ID6', '副主任医生', 6, '医生介绍6', 0, 1),
('96c275481f2317ca59ba818c17364479', '关羽', 28, 1, '', '7890123456', 'ID7', '主治医生', 7, '医生介绍7', 0, 1),
('96c275481f2317ca59ba818c17364479', '张飞', 32, 2, '', '8901234567', 'ID8', '主任医生', 8, '医生介绍8', 0, 1),
('96c275481f2317ca59ba818c17364479', '赵云', 37, 1, '', '9012345678', 'ID9', '副主任医生', 9, '医生介绍9', 0, 1),
('96c275481f2317ca59ba818c17364479', '诸葛亮', 42, 2, '', '0123456789', 'ID10', '主治医生', 10, '医生介绍10', 0, 1),
('96c275481f2317ca59ba818c17364479', '曹操', 33, 1, '', '1234509876', 'ID11', '主任医生', 1, '医生介绍11', 0, 1),
('96c275481f2317ca59ba818c17364479', '孙策', 38, 2, '', '2345098765', 'ID12', '副主任医生', 2, '医生介绍12', 0, 1),
('96c275481f2317ca59ba818c17364479', '朱元璋', 47, 1, '', '3450987654', 'ID13', '主治医生', 3, '医生介绍13', 0, 1),
('96c275481f2317ca59ba818c17364479', '朱棣', 41, 2, '', '4509876543', 'ID14', '主任医生', 4, '医生介绍14', 0, 1),
('96c275481f2317ca59ba818c17364479', '朱瞻基', 29, 1, '', '5098765432', 'ID15', '副主任医生', 5, '医生介绍15', 0, 1),
('96c275481f2317ca59ba818c17364479', '韩信', 36, 2, '', '0987654321', 'ID16', '主治医生', 6, '医生介绍16', 0, 1),
('96c275481f2317ca59ba818c17364479', '孙膑', 44, 1, '', '9876543210', 'ID17', '主任医生', 7, '医生介绍17', 0, 1),
('96c275481f2317ca59ba818c17364479', '猪猪侠', 31, 2, '', '8765432109', 'ID18', '副主任医生', 8, '医生介绍18', 0, 1),
('96c275481f2317ca59ba818c17364479', '猪八戒', 48, 1, '', '7654321098', 'ID19', '主治医生', 9, '医生介绍19', 0, 1),
('96c275481f2317ca59ba818c17364479', '张百忍', 50, 2, '', '6543210987', 'ID20', '实习医生', 10, '医生介绍20', 0, 1);


INSERT INTO `doctor_schedule` (`doctor_id`, `dept_id`, `date`, `week`, `state`, `doctor_name`)
VALUES
(1, 1, '2024-01-10', 1, 0, ''), -- 周一
(1, 1, '2024-01-11', 2, 0, ''), -- 周二
(1, 1, '2024-01-12', 3, 0, ''), -- 周三
(1, 1, '2024-01-13', 4, 0, ''), -- 周四
(1, 1, '2024-01-14', 5, 0, ''), -- 周五
(1, 1, '2024-01-15', 6, 0, ''), -- 周六
(1, 1, '2024-01-16', 7, 0, ''); -- 周日

INSERT INTO `doctor_schedule` (`doctor_id`, `dept_id`, `date`, `week`, `state`, `doctor_name`)
VALUES
(1, 2, '2024-01-10', 1, 0, ''), -- 周一
(1, 2, '2024-01-11', 2, 0, ''), -- 周二
(1, 2, '2024-01-12', 3, 0, ''), -- 周三
(1, 2, '2024-01-13', 4, 0, ''), -- 周四
(1, 2, '2024-01-14', 5, 0, ''), -- 周五
(1, 2, '2024-01-15', 6, 0, ''), -- 周六
(1, 2, '2024-01-16', 7, 0, ''); -- 周日

INSERT INTO `doctor_schedule` (`doctor_id`, `dept_id`, `date`, `week`, `state`, `doctor_name`)
VALUES
(1, 3, '2024-01-10', 1, 0, ''), -- 周一
(1, 3, '2024-01-11', 2, 0, ''), -- 周二
(1, 3, '2024-01-12', 3, 0, ''), -- 周三
(1, 3, '2024-01-13', 4, 0, ''), -- 周四
(1, 3, '2024-01-14', 5, 0, ''), -- 周五
(1, 3, '2024-01-15', 6, 0, ''), -- 周六
(1, 3, '2024-01-16', 7, 0, ''); -- 周日
INSERT INTO `doctor_schedule` (`doctor_id`, `dept_id`, `date`, `week`, `state`, `doctor_name`)
VALUES
(1, 4, '2024-01-10', 1, 0, ''), -- 周一
(1, 4, '2024-01-11', 2, 0, ''), -- 周二
(1, 4, '2024-01-12', 3, 0, ''), -- 周三
(1, 4, '2024-01-13', 4, 0, ''), -- 周四
(1, 4, '2024-01-14', 5, 0, ''), -- 周五
(1, 4, '2024-01-15', 6, 0, ''), -- 周六
(1, 4, '2024-01-16', 7, 0, ''); -- 周日
INSERT INTO `doctor_schedule` (`doctor_id`, `dept_id`, `date`, `week`, `state`, `doctor_name`)
VALUES
(1, 5, '2024-01-10', 1, 0, ''), -- 周一
(1, 5, '2024-01-11', 2, 0, ''), -- 周二
(1, 5, '2024-01-12', 3, 0, ''), -- 周三
(1, 5, '2024-01-13', 4, 0, ''), -- 周四
(1, 5, '2024-01-14', 5, 0, ''), -- 周五
(1, 5, '2024-01-15', 6, 0, ''), -- 周六
(1, 5, '2024-01-16', 7, 0, ''); -- 周日
INSERT INTO `doctor_schedule` (`doctor_id`, `dept_id`, `date`, `week`, `state`, `doctor_name`)
VALUES
(1, 6, '2024-01-10', 1, 0, ''), -- 周一
(1, 6, '2024-01-11', 2, 0, ''), -- 周二
(1, 6, '2024-01-12', 3, 0, ''), -- 周三
(1, 6, '2024-01-13', 4, 0, ''), -- 周四
(1, 6, '2024-01-14', 5, 0, ''), -- 周五
(1, 6, '2024-01-15', 6, 0, ''), -- 周六
(1, 6, '2024-01-16', 7, 0, ''); -- 周日
INSERT INTO `doctor_schedule` (`doctor_id`, `dept_id`, `date`, `week`, `state`, `doctor_name`)
VALUES
(1, 7, '2024-01-10', 1, 0, ''), -- 周一
(1, 7, '2024-01-11', 2, 0, ''), -- 周二
(1, 7, '2024-01-12', 3, 0, ''), -- 周三
(1, 7, '2024-01-13', 4, 0, ''), -- 周四
(1, 7, '2024-01-14', 5, 0, ''), -- 周五
(1, 7, '2024-01-15', 6, 0, ''), -- 周六
(1, 7, '2024-01-16', 7, 0, ''); -- 周日
INSERT INTO `doctor_schedule` (`doctor_id`, `dept_id`, `date`, `week`, `state`, `doctor_name`)
VALUES
(1, 8, '2024-01-10', 1, 0, ''), -- 周一
(1, 8, '2024-01-11', 2, 0, ''), -- 周二
(1, 8, '2024-01-12', 3, 0, ''), -- 周三
(1, 8, '2024-01-13', 4, 0, ''), -- 周四
(1, 8, '2024-01-14', 5, 0, ''), -- 周五
(1, 8, '2024-01-15', 6, 0, ''), -- 周六
(1, 8, '2024-01-16', 7, 0, ''); -- 周日
INSERT INTO `doctor_schedule` (`doctor_id`, `dept_id`, `date`, `week`, `state`, `doctor_name`)
VALUES
(1, 9, '2024-01-10', 1, 0, ''), -- 周一
(1, 9, '2024-01-11', 2, 0, ''), -- 周二
(1, 9, '2024-01-12', 3, 0, ''), -- 周三
(1, 9, '2024-01-13', 4, 0, ''), -- 周四
(1, 9, '2024-01-14', 5, 0, ''), -- 周五
(1, 9, '2024-01-15', 6, 0, ''), -- 周六
(1, 9, '2024-01-16', 7, 0, ''); -- 周日
INSERT INTO `doctor_schedule` (`doctor_id`, `dept_id`, `date`, `week`, `state`, `doctor_name`)
VALUES
(1, 10, '2024-01-10', 1, 0, ''), -- 周一
(1, 10, '2024-01-11', 2, 0, ''), -- 周二
(1, 10, '2024-01-12', 3, 0, ''), -- 周三
(1, 10, '2024-01-13', 4, 0, ''), -- 周四
(1, 10, '2024-01-14', 5, 0, ''), -- 周五
(1, 10, '2024-01-15', 6, 0, ''), -- 周六
(1, 10, '2024-01-16', 7, 0, ''); -- 周日
INSERT INTO `doctor_schedule` (`doctor_id`, `dept_id`, `date`, `week`, `state`, `doctor_name`)
VALUES
(1, 11, '2024-01-10', 1, 0, ''), -- 周一
(1, 11, '2024-01-11', 2, 0, ''), -- 周二
(1, 11, '2024-01-12', 3, 0, ''), -- 周三
(1, 11, '2024-01-13', 4, 0, ''), -- 周四
(1, 11, '2024-01-14', 5, 0, ''), -- 周五
(1, 11, '2024-01-15', 6, 0, ''), -- 周六
(1, 11, '2024-01-16', 7, 0, ''); -- 周日
INSERT INTO `doctor_schedule` (`doctor_id`, `dept_id`, `date`, `week`, `state`, `doctor_name`)
VALUES
(1, 12, '2024-01-10', 1, 0, ''), -- 周一
(1, 12, '2024-01-11', 2, 0, ''), -- 周二
(1, 12, '2024-01-12', 3, 0, ''), -- 周三
(1, 12, '2024-01-13', 4, 0, ''), -- 周四
(1, 12, '2024-01-14', 5, 0, ''), -- 周五
(1, 12, '2024-01-15', 6, 0, ''), -- 周六
(1, 12, '2024-01-16', 7, 0, ''); -- 周日

SET FOREIGN_KEY_CHECKS = 1;
