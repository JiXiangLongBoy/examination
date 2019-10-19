package com.qfedu.examination.dao;

import com.qfedu.examination.entity.*;
import com.qfedu.examination.model.RandomCreateQuestionModel;
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

    ChoiceQuestion choiceListByID(int id);

    JudgeQuestion judgeListByID(int id);

    ShortQuestion shortListByID(int id);

    int updateChoice(ChoiceQuestion choiceQuestion);

    int updateJudge(JudgeQuestion judgeQuestion);

    int updateShort(ShortQuestion shortQuestion);

    QuestionType queryOneQuestionType(int id);

    int saveQuestionType(QuestionType questionType);

    int updateQuestionType(QuestionType questionType);

    int delQuestionType(int id);

    int queryChoiceCount();

    int queryJudgeCount();

    int queryShortCount();

    int saveRandomQuestion(RandomCreateQuestion randomCreateQuestion);

    List<RandomCreateQuestionModel> queryAllRandomQuestion(int subID);

    void delRandomQuestion(int id);

    RandomCreateQuestionModel queryOneRandomQuestion(int id);

    int updateRandomQuestion(RandomCreateQuestionModel randomCreateQuestionModel);

    Subject queryOneSubjectType(int subjectID);
}