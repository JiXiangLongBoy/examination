package com.qfedu.examination.controller;

import com.qfedu.examination.service.ExamTimeManageService;
import com.qfedu.examination.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Api(value = "考试场次管理",tags = "考试场次管理接口")
public class ExamTimeManageController {

    @Autowired
    ExamTimeManageService examTimeManageService;

    @GetMapping("/queryExamTimeList")
    public R queryAllExamTime(){

        return examTimeManageService.queryAllExamTime();

    }

}
