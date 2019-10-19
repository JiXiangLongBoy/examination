package com.qfedu.examination.controller;

import com.qfedu.examination.common.J;
import com.qfedu.examination.common.OutPut;
import com.qfedu.examination.entity.*;
import com.qfedu.examination.model.RandomCreateQuestionModel;
import com.qfedu.examination.service.QuestionService;
import com.qfedu.examination.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@Api(value = "考试管理接口",tags = "考试管理接口")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @ApiOperation(value = "展示所有学科",notes = "展示所有的学科")
    @GetMapping("/question/showSubjectType")
    public R showSubjectType(){
        return questionService.showSubjectType();
    }

    @ApiOperation(value = "展示题目类型",notes = "展示所有的题目类型")
    @GetMapping("/question/showQuestionType")
    public J showQuestionType(){
        return questionService.showQuestionType();
    }

    @ApiOperation(value = "展示单个试题的分类详情",notes = "展示单个试题的分类详情")
    @GetMapping("/question/queryonequestiontype")
    public R queryOneQuestionType(int id){
        return questionService.queryOneQuestionType(id);
    }

    @ApiOperation(value = "保存(修改)试题分类",notes = "保存(修改)试题分类")
    @PostMapping("/question/savequestiontype")
    public R saveQuestionType(QuestionType questionType){
        return questionService.saveQuestionType(questionType);
    }

    @ApiOperation(value = "删除试题分类",notes = "删除试题分类接口")
    @GetMapping("/question/delquestiontype")
    public R delQuestionType(int id){
        return questionService.delQuestionType(id);
    }


    @ApiOperation(value = "展示对应科目的选择题",notes = "展示对应科目的选择题")
    @GetMapping("/question/choiceList")
    public R choiceList(int subjectID){
        return questionService.choiceList(subjectID);
    }

    @ApiOperation(value = "导出对应科目的选择题",notes = "导出对应科目的选择题")
    @GetMapping("/question/deriveChoice")
    public void deriveChoice(HttpServletResponse response, int subjectID){
       Subject subject =  questionService.queryOneSubjectType(subjectID);
        R r = questionService.deriveChoice(subjectID);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = simpleDateFormat.format(new Date());

        String fileName = subject.getSname()+"选择题"+format+".xlsx";
        OutPut.setResponseHeader(response,fileName);
        SXSSFWorkbook wb = (SXSSFWorkbook) r.getData();
        OutPut.setResponseHeader(response,fileName);
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "导入对应科目的选择题",notes = "导入对应科目的选择题")
    @PostMapping("/question/toLeadChoice")
    public R toLeadChoice(MultipartFile file, HttpServletRequest request){
        return questionService.toLeadChoice(file,request);
    }

    @ApiOperation(value = "删除对应科目的选择题",notes = "删除对应科目的选择题")
    @GetMapping("/question/choiceDelete")
    public R choiceDelete(int id){
        return questionService.choiceDelete(id);
    }

    @ApiOperation(value = "根据题目id展示单个选择题的详细信息",notes = "根据题目id展示单个选择题的详细信息")
    @GetMapping("/question/choiceListByID")
    public R choiceByListByID(int id){
        return questionService.choiceListByID(id);
    }

    @ApiOperation(value = "录入(修改)对应科目的选择题",notes = "录入(修改)对应科目的选择题")
    @PostMapping("/question/choiceEntering")
    public R choiceEntering(ChoiceQuestion choiceQuestion){
        return questionService.choiceEntering(choiceQuestion);
    }







    @ApiOperation(value = "对应科目的判断题",notes = "展示对应科目的判断题")
    @GetMapping("/question/judgeList")
    public R judgeList(int subjectID){
        return questionService.judgeList(subjectID);
    }

    @ApiOperation(value = "根据题目id展示单个判断题的详细信息",notes = "根据题目id展示单个判断题的详细信息")
    @GetMapping("/question/judgeListByID")
    public R judgeListByID(int id){
        return questionService.judgeListByID(id);
    }

    @ApiOperation(value = "导出对应科目的判断题",notes = "导出对应科目的判断题")
    @GetMapping("/question/deriveJudge")
    public R deriveJudge(int subjectID,String filePath,String fileName){
        return questionService.deriveJudge(subjectID,filePath,fileName);
    }

    @ApiOperation(value = "导入对应科目的判断题",notes = "导入对应科目的判断题")
    @GetMapping("/question/toLeadJudge")
    public R toLeadJudge(String filePath){
        return questionService.toLeadJudge(filePath);
    }

    @ApiOperation(value = "删除对应科目的判断题",notes = "删除对应科目的判断题")
    @GetMapping("/question/judgeDelete")
    public R judgeDelete(int id){
        return questionService.judgeDelete(id);
    }

    @ApiOperation(value = "录入(修改)对应科目的判断题",notes = "录入(修改)对应科目的判断题")
    @PostMapping("/question/judgeEntering")
    public R saveJudge(JudgeQuestion judgeQuestion){
        return questionService.saveJudge(judgeQuestion);
    }








    @ApiOperation(value = "展示对应科目的简答题",notes = "展示对应科目的简答题")
    @GetMapping("/question/shortList")
    public R queryShort(int subjectID){
        return questionService.queryShort(subjectID);
    }

    @ApiOperation(value = "导出对应科目的简答",notes = "导出对应科目的简答题")
    @GetMapping("/question/deriveShort")
    public R deriveShort(int subjectID,String filePath,String fileName){
        return questionService.deriveShort(subjectID,filePath,fileName);
    }

    @ApiOperation(value = "根据题目id展示单个简答题的详细信息",notes = "根据题目id展示单个简答题的详细信息")
    @GetMapping("/question/shortListByID")
    public R shortListByID(int id){
        return questionService.shortListByID(id);
    }

    @ApiOperation(value = "导入对应科目的简答题",notes = "导入对应科目的简答题")
    @GetMapping("/question/toLeadShort")
    public R toLeadShort(String filePath){
        return questionService.toLeadShort(filePath);
    }


    @ApiOperation(value = "删除对应科目的简答题",notes = "删除对应科目的简答题")
    @GetMapping("/question/shortDelete")
    public R deleteShort(int id){
        return questionService.deleteShort(id);
    }

    @ApiOperation(value = "录入(修改)对应科目的简答题",notes = "对应科目的简答题")
    @PostMapping("/question/shortEntering")
    public R saveShort(ShortQuestion shortQuestion){
        return questionService.saveShort(shortQuestion);
    }



    @ApiOperation(value = "根据课程id展示所有已经生成的对应课程试卷列表",notes = "展示所有已经生成的试卷")
    @GetMapping("/question/queryallrandomquestion")
    public R queryAllRandomQuestion(int subID){
        return questionService.queryAllRandomQuestion(subID);
    }

    @ApiOperation(value = "随机生成试卷",notes = "随机生成试卷接口")
    @PostMapping("/question/randomcreatequestion")
    public R randomCreateQuestion(String name,int choiceCount,int judgeCount,int shortCount,int subjectID){
        return questionService.randomCreateQuestion(name,choiceCount,judgeCount,shortCount,subjectID);
    }

    @ApiOperation(value = "删除已经生成的试卷",notes = "删除已经生成的试卷")
    @GetMapping("/question/delrandomquestion")
    public R delRandomQuestion(int id){
        return questionService.delRandomQuestion(id);
    }

    @ApiOperation(value = "根据单个试卷ID展示试卷的信息",notes = "修改时输入框自动填充已存在数据")
    @GetMapping("/question/queryonerandomquestion")
    public R queryOneRandomQuestion(int id){
        return questionService.queryOneRandomQuestion(id);
    }

    @ApiOperation(value = "修改试卷的信息",notes = "根据单个试卷ID修改试卷的信息")
    @GetMapping("/question/updaterandomquestion")
    public R updateRandomQuestion(RandomCreateQuestionModel randomCreateQuestionModel){
        return questionService.updateRandomQuestion(randomCreateQuestionModel);
    }
}
