package com.qfedu.examination.service;

import com.qfedu.examination.entity.Student;

import java.util.List;

public interface StudentService {

    public Student StuLogin(String email,String password);

    //查询所有的学生信息
    public List<Student> findAllStudent(Integer page, Integer limit,String sname);

    //添加学生信息
    public void addStudent(Student student);

    //通过id查找学生信息
    public Student findStudentById(Integer sid);

    //修改学生信息
    public void updateStudent(Student student);
    //删除学生信息
    public void deleteStudent(Integer sid);
    //批量删除
    public void deleteMany(Integer[] sids);
}
