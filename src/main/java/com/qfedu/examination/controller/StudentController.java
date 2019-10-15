package com.qfedu.examination.controller;

import com.github.pagehelper.Page;
import com.qfedu.examination.common.JsonResult;
import com.qfedu.examination.entity.Student;
import com.qfedu.examination.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/findAllStudent")
    public Map<String,Object> findAllStudent(Integer page, Integer limit){
        List<Student> students = studentService.findAllStudent(page,limit);
        long total = ((Page) students).getTotal();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",students);
        return map;
    }

    @RequestMapping("/addStudent")
    public JsonResult addStudent(Student student){
        studentService.addStudent(student);
        return new JsonResult(0, null);
    }

    @RequestMapping("/findStudentById")
    public JsonResult findStudentById(Integer sid) {
        Student student = studentService.findStudentById(sid);
        return new JsonResult(0, student);
    }

    @RequestMapping("/updateStudent")
    public JsonResult updateStudent(Student student){
        studentService.updateStudent(student);
        return new JsonResult(0,null);
    }

    @RequestMapping("/deleteStudent")
    public JsonResult deleteStudent(Integer sid){
        studentService.deleteStudent(sid);
        return new JsonResult(0,null);
    }

    @RequestMapping("/deleteMany")
    public JsonResult deleteMany(Integer[] sids){
        studentService.deleteMany(sids);
        return new JsonResult(0,null);
    }
}
