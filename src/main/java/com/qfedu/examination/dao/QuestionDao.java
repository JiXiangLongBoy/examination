package com.qfedu.examination.dao;

import com.qfedu.examination.entity.*;
import com.qfedu.examination.vo.R;

import java.util.List;

public interface QuestionDao {
    List<Subject> showSubjectType();

    List<QuestionType> showQuestionType();

    List<ChoiceQuestion> choiceList(int subjectID);

    int choiceDelete(int id);

    int choiceEntering(ChoiceQuestion choiceQuestion);

    List<JudgeQuestion> judgeList(int subjectID);

    int judgeDelete(int id);

    int saveJudge(JudgeQuestion judgeQuestion);

    List<ShortQuestion> queryShort(int subjectID);

    int deleteShort(int id);

    int saveShort(ShortQuestion shortQuestion);
}
