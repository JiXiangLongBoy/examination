package com.qfedu.examination.service.impl;

import com.qfedu.examination.dao.QuestionDao;
import com.qfedu.examination.service.QuestionService;
import com.qfedu.examination.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionDao questionDao;

    @Override
    public R showSubjectType() {
        return R.setOK("success",questionDao.showSubjectType());
    }


    @Override
    public R showQuestionType() {

        return R.setOK("success", questionDao.showQuestionType());
    }

    @Override
    public R choiceList(int subjectID) {
        return R.setOK("success",questionDao.choiceList(subjectID));
    }
}
