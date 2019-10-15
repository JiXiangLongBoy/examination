package com.qfedu.examination.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.examination.dao.StudentDao;
import com.qfedu.examination.entity.Student;
import com.qfedu.examination.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAllStudent(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Student> students = studentDao.findAllStudent();
        return students;
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);

    }

    @Override
    public Student findStudentById(Integer sid) {
        return studentDao.findStudentById(sid);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);

    }

    @Override
    public void deleteStudent(Integer sid) {
        studentDao.deleteStudent(sid);

    }

    @Override
    public void deleteMany(Integer[] sids) {
        studentDao.deleteMany(sids);
    }
}
