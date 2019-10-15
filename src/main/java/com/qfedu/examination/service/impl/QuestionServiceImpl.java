package com.qfedu.examination.service.impl;

import com.qfedu.examination.dao.QuestionDao;
import com.qfedu.examination.entity.ChoiceQuestion;
import com.qfedu.examination.entity.JudgeQuestion;
import com.qfedu.examination.entity.ShortQuestion;
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

    @Override
    public R choiceDelete(int id) {
        int i = questionDao.choiceDelete(id);
        if (i==1){
            return R.setOK();
        }else {
            return R.setERROR();
        }
    }

    @Override
    public R choiceEntering(ChoiceQuestion choiceQuestion) {
       int count = questionDao.choiceEntering(choiceQuestion);
       if (count == 1){
           return R.setOK("插入数据成功");
       }else {
          return R.setERROR("插入数据失败");
       }

    }

    @Override
    public R judgeList(int subjectID) {

        return R.setOK("success",questionDao.judgeList(subjectID));
    }

    @Override
    public R judgeDelete(int id) {
        int i = questionDao.judgeDelete(id);
        return i==1 ? R.setOK() : R.setERROR();
    }

    @Override
    public R saveJudge(JudgeQuestion judgeQuestion) {
        int i = questionDao.saveJudge(judgeQuestion);
        return i==1?R.setOK():R.setERROR();
    }

    @Override
    public R queryShort(int subjectID) {
        return R.setOK("success",questionDao.queryShort(subjectID));
    }

    @Override
    public R deleteShort(int id) {
        int i = questionDao.deleteShort(id);
        return i==1 ? R.setOK() : R.setERROR();
    }

    @Override
    public R saveShort(ShortQuestion shortQuestion) {
        int i = questionDao.saveShort(shortQuestion);
        return i==1?R.setOK():R.setERROR();
    }


}
