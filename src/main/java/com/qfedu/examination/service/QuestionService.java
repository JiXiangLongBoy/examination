package com.qfedu.examination.service;


import com.qfedu.examination.entity.ChoiceQuestion;
import com.qfedu.examination.entity.JudgeQuestion;
import com.qfedu.examination.entity.ShortQuestion;
import com.qfedu.examination.vo.R;

public interface QuestionService {


    R showSubjectType();

    R showQuestionType();

    R choiceList(int subjectID);

    R choiceDelete(int id);

    R choiceEntering(ChoiceQuestion choiceQuestion);

    R judgeList(int subjectID);

    R judgeDelete(int id);

    R saveJudge(JudgeQuestion judgeQuestion);

    R queryShort(int subjectID);

    R deleteShort(int id);

    R saveShort(ShortQuestion shortQuestion);
}
