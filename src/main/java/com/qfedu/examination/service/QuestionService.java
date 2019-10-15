package com.qfedu.examination.service;


import com.qfedu.examination.entity.ChoiceQuestion;
import com.qfedu.examination.entity.JudgeQuestion;
import com.qfedu.examination.entity.ShortQuestion;
import com.qfedu.examination.vo.R;

public interface QuestionService {


    R showSubjectType();

    R showQuestionType();

    R choiceList(int subjectID);

    R deriveChoice(int subjectID,String filePath,String fileName);

    R toLeadChoice(String filePath);

    R choiceDelete(int id);

    R choiceEntering(ChoiceQuestion choiceQuestion);

    R judgeList(int subjectID);

    R deriveJudge(int subjectID, String filePath, String fileName);

    R toLeadJudge(String filePath);

    R judgeDelete(int id);

    R saveJudge(JudgeQuestion judgeQuestion);

    R queryShort(int subjectID);

    R deriveShort(int subjectID, String filePath, String fileName);

    R toLeadShort(String filePath);

    R deleteShort(int id);

    R saveShort(ShortQuestion shortQuestion);

}
