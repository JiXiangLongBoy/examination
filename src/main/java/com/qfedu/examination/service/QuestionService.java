package com.qfedu.examination.service;


import com.qfedu.examination.common.J;
import com.qfedu.examination.entity.*;
import com.qfedu.examination.model.RandomCreateQuestionModel;
import com.qfedu.examination.vo.R;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface QuestionService {


    R showSubjectType();

    J showQuestionType();

    R choiceList(int subjectID);

    R deriveChoice(int subjectID);

    R toLeadChoice(MultipartFile multipartFile, HttpServletRequest request);


    R choiceListByID(int id);


    R choiceDelete(int id);

    R choiceEntering(ChoiceQuestion choiceQuestion);

    R judgeList(int subjectID);

    R judgeListByID(int id);


    R deriveJudge(int subjectID, String filePath, String fileName);

    R toLeadJudge(String filePath);

    R judgeDelete(int id);

    R saveJudge(JudgeQuestion judgeQuestion);

    R queryShort(int subjectID);

    R deriveShort(int subjectID, String filePath, String fileName);

    R toLeadShort(String filePath);

    R deleteShort(int id);

    R saveShort(ShortQuestion shortQuestion);

    R shortListByID(int id);

    R queryOneQuestionType(int id);

    R saveQuestionType(QuestionType questionType);

    R delQuestionType(int id);

    R randomCreateQuestion(String name,int choiceCount,int judgeCount,int shortCount,int subjectID);

    R queryAllRandomQuestion(int subID);

    R delRandomQuestion(int id);

    R queryOneRandomQuestion(int id);

    R updateRandomQuestion(RandomCreateQuestionModel randomCreateQuestionModel);

    Subject queryOneSubjectType(int subjectID);
}
