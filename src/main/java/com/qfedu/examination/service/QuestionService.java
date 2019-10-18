package com.qfedu.examination.service;


import com.qfedu.examination.entity.ChoiceQuestion;
import com.qfedu.examination.entity.JudgeQuestion;
import com.qfedu.examination.entity.QuestionType;
import com.qfedu.examination.entity.ShortQuestion;
import com.qfedu.examination.vo.R;

public interface QuestionService {


    R showSubjectType();

    R showQuestionType();

    R choiceList(int subjectID);

    R deriveChoice(int subjectID,String filePath,String fileName);

    R toLeadChoice(String filePath);


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

    R randomCreateQuestion(int choiceCount,int judgeCount,int shortCount);
}
