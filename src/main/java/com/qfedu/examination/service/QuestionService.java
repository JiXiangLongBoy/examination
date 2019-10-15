package com.qfedu.examination.service;


import com.qfedu.examination.vo.R;

public interface QuestionService {


    R showSubjectType();

    R showQuestionType();

    R choiceList(int subjectID);
}
