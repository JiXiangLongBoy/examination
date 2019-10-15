package com.qfedu.examination.controller;

import com.qfedu.examination.entity.Subject;
import com.qfedu.examination.service.QuestionService;
import com.qfedu.examination.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "考试管理接口",tags = "考试管理接口")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @ApiOperation(value = "展示学科",notes = "展示所有的学科")
    @GetMapping("/question/showSubjectType")
    public R showSubjectType(){
        return questionService.showSubjectType();
    }

    //展示所有的题目类型
    @GetMapping("/question/showQuestionType")
    public R showQuestionType(){
        return questionService.showQuestionType();
    }

    //展示对应科目的所有的选择题
    @GetMapping("/question/choiceList")
    public R choiceList(int subjectID){
        return questionService.choiceList(subjectID);
    }
    //删除对应的选择题
    @GetMapping("/question/choiceDelete")
    public R choiceDelete(int id){
        System.out.println(id);
        return R.setOK();
    }
    //修改对应的选择题
    @PostMapping("/question/choiceUpdate")
    public R choiceUpdate(){
        return R.setOK();
    }

    //录入对应的选择题
    @PostMapping("/question/choiceEntering")
    public R choiceEntering(){
        return R.setOK();
    }

}
