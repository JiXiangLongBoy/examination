package com.qfedu.examination.controller;

import com.qfedu.examination.entity.ExamTime;
import com.qfedu.examination.service.ExamTimeManageService;
import com.qfedu.examination.vo.Page;
import com.qfedu.examination.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Api(value = "考试场次管理",tags = "考试场次管理接口")
public class ExamTimeManageController {

    @Autowired
    ExamTimeManageService examTimeManageService;

    @ApiOperation(value = "展示所有考试时间",notes = "不需要参数")
    @GetMapping("/queryAllExamTimeList")
    public R queryAllExamTime(Page page){
        return examTimeManageService.queryAllExamTime(page);
    }

    @ApiOperation(value = "展示单条考试时间的接口",notes = "点击修改编辑考试时间调用的接口")
    @GetMapping("/queryOneExamTime")
    public R queryOneExamTime(int id){
        return examTimeManageService.queryOneExamTime(id);
    }

    @ApiOperation(value = "保存考试时间",notes = "保存已经编辑好的考试时间接口")
    @PostMapping("/saveexamtime")
    public R saveExamTime(ExamTime examTime){
        System.out.println(examTime.getBeginTime());
        System.out.println(examTime.getEndTime());
        return examTimeManageService.saveExamTime(examTime);
    }


    @ApiOperation(value = "删除考试时间记录",notes = "删除考试时间记录接口")
    @GetMapping("deleteexamtime")
    public R deleteExamTime(int id){
        return examTimeManageService.deleteExamTime(id);
    }
}
