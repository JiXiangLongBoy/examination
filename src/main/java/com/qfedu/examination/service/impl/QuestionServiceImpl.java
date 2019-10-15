package com.qfedu.examination.service.impl;

import com.qfedu.examination.dao.QuestionDao;
import com.qfedu.examination.entity.ChoiceQuestion;
import com.qfedu.examination.entity.JudgeQuestion;
import com.qfedu.examination.entity.ShortQuestion;
import com.qfedu.examination.poi.*;
import com.qfedu.examination.service.QuestionService;
import com.qfedu.examination.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionDao questionDao;

    @Override
    public R showSubjectType() {
        return R.setOK("success", questionDao.showSubjectType());
    }


    @Override
    public R showQuestionType() {

        return R.setOK("success", questionDao.showQuestionType());
    }

    @Override
    public R choiceList(int subjectID) {
        return R.setOK("success", questionDao.choiceList(subjectID));
    }

    @Override
    public R deriveChoice(int subjectID,String filePath,String fileName) {
        List<ChoiceQuestion> choiceQuestions = questionDao.choiceList(subjectID);
        try {
            ChoiceDerive.createExcel(choiceQuestions,filePath,fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.setOK("导出成功");
    }

    @Override
    public R toLeadChoice(String filePath) {
        List<ChoiceQuestion> toLead = ChoiceToLead.Tolead(filePath);
        if (toLead==null || toLead.equals("")|| toLead.size()==0) {
            return R.setERROR("文件不存在，导入失败");
        }
        for (ChoiceQuestion cq: toLead) {
            questionDao.choiceEntering(cq);
        }
        return R.setOK("导入成功");

    }


    @Override
    public R choiceDelete(int id) {
        int i = questionDao.choiceDelete(id);
        if (i == 1) {
            return R.setOK();
        } else {
            return R.setERROR();
        }
    }

    @Override
    public R choiceEntering(ChoiceQuestion choiceQuestion) {
        int count = questionDao.choiceEntering(choiceQuestion);
        if (count == 1) {
            return R.setOK("插入数据成功");
        } else {
            return R.setERROR("插入数据失败");
        }

    }

    @Override
    public R judgeList(int subjectID) {

        return R.setOK("success", questionDao.judgeList(subjectID));
    }

    @Override
    public R deriveJudge(int subjectID, String filePath, String fileName) {
        List<JudgeQuestion> judgeQuestions = questionDao.judgeList(subjectID);
        try {
            JudgeDerive.createExcel(judgeQuestions,filePath,fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.setOK("导出成功");
    }

    @Override
    public R toLeadJudge(String filePath) {
        List<JudgeQuestion> toLead = JudgeToLead.Tolead(filePath);
        if (toLead==null || toLead.equals("")|| toLead.size()==0) {
            return R.setERROR("文件不存在，导入失败");
        }
            for (JudgeQuestion jq: toLead) {
                questionDao.saveJudge(jq);
            }
            return R.setOK("导入成功");

    }

    @Override
    public R judgeDelete(int id) {
        int i = questionDao.judgeDelete(id);
        return i == 1 ? R.setOK() : R.setERROR();
    }

    @Override
    public R saveJudge(JudgeQuestion judgeQuestion) {
        int i = questionDao.saveJudge(judgeQuestion);
        return i == 1 ? R.setOK() : R.setERROR();
    }

    @Override
    public R queryShort(int subjectID) {
        return R.setOK("success", questionDao.queryShort(subjectID));
    }

    @Override
    public R deriveShort(int subjectID, String filePath, String fileName) {
        List<ShortQuestion> shortQuestions = questionDao.queryShort(subjectID);
        try {
            ShortDerive.createExcel(shortQuestions,filePath,fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.setOK("导出成功");
    }

    @Override
    public R toLeadShort(String filePath) {
        List<ShortQuestion> toLead = ShortToLead.Tolead(filePath);
        if (toLead==null ||toLead.equals("") || toLead.size()==0){
            return R.setERROR("文件不存在，导入失败");
        }

            for (ShortQuestion sq: toLead) {
                questionDao.saveShort(sq);
            }
            return R.setOK("导入成功");

    }

    @Override
    public R deleteShort(int id) {
        int i = questionDao.deleteShort(id);
        return i == 1 ? R.setOK() : R.setERROR();
    }

    @Override
    public R saveShort(ShortQuestion shortQuestion) {
        int i = questionDao.saveShort(shortQuestion);
        return i == 1 ? R.setOK() : R.setERROR();
    }


}
