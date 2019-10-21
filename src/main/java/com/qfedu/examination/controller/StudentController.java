package com.qfedu.examination.controller;

import com.github.pagehelper.Page;
import com.qfedu.examination.common.JsonResult;
import com.qfedu.examination.entity.Student;
import com.qfedu.examination.service.StudentService;
import com.qfedu.examination.utils.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/stulogin")
    public String stulogin(){
        return "stuLogin";
    }

    @RequestMapping("/StuLogin")
    @ResponseBody
    public JsonResult StuLogin(String email, String password, HttpSession session){
        Student student = studentService.StuLogin(email, password);
        if (student == null){
            return new JsonResult(1,"未登录");
        }
        session.setAttribute(StrUtil.LONGIN_STUDENT,student);
        return new JsonResult(0,null);
    }

    @RequestMapping("/studentManage")
    public String studentlist(){
        return "studentManage";
    }

    @RequestMapping("/studentList")
    @ResponseBody
    public Map<String,Object> findAllStudent(Integer page, Integer limit,String sname){

        List<Student> students = studentService.findAllStudent(page,limit,sname);
        long total = ((Page) students).getTotal();
        Map<String,Object> map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",students);
        return map;
    }

    @RequestMapping("/addstudent")
    public String addstudent(){
        return "addStudent";
    }

    @RequestMapping("/addStudent")
    @ResponseBody
    public JsonResult addStudent(Student student){
        studentService.addStudent(student);
        return new JsonResult(0, null);
    }

    @RequestMapping("/findStudentById")
    public String findStudentById(Integer sid, Model model) {
        Student student = studentService.findStudentById(sid);
        model.addAttribute("student",student);
        return "updateStudent";
    }

    @RequestMapping("/updatestu")
    public String updatestu(){
        return "updateStudent";
    }

    @RequestMapping("/updateStudent")
    @ResponseBody
    public JsonResult updateStudent(Student student){
        studentService.updateStudent(student);
        return new JsonResult(0,null);
    }

    @RequestMapping("/deleteStudent")
    @ResponseBody
    public JsonResult deleteStudent(Integer sid){
        studentService.deleteStudent(sid);
        return new JsonResult(0,null);
    }

    @RequestMapping("/deleteMany")
    @ResponseBody
    public JsonResult deleteMany(Integer[] sids){
        studentService.deleteMany(sids);
        return new JsonResult(0,null);
    }
}
