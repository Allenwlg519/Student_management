CREATE DATABASE IF NOT EXISTS student_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE student_db;

CREATE TABLE IF NOT EXISTS student (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '学生ID，主键自增',
    student_no VARCHAR(50) NOT NULL UNIQUE COMMENT '学号，唯一标识',
    name VARCHAR(100) NOT NULL COMMENT '学生姓名',
    gender TINYINT NOT NULL COMMENT '性别：1-男，2-女',
    age INT NOT NULL COMMENT '年龄',
    class_name VARCHAR(100) COMMENT '班级名称',
    major VARCHAR(100) COMMENT '专业名称',
    phone VARCHAR(20) COMMENT '联系电话',
    email VARCHAR(100) COMMENT '电子邮箱',
    address VARCHAR(500) COMMENT '家庭住址',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_student_no (student_no),
    INDEX idx_class_name (class_name),
    INDEX idx_name (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='学生信息表';
