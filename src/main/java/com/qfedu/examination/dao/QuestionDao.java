package com.qfedu.examination.dao;

import com.qfedu.examination.entity.ChoiceQuestion;
import com.qfedu.examination.entity.QuestionType;
import com.qfedu.examination.entity.Subject;
import com.qfedu.examination.vo.R;

import java.util.List;

public interface QuestionDao {
    List<Subject> showSubjectType();

    List<QuestionType> showQuestionType();

    List<ChoiceQuestion> choiceList(int subjectID);
}
