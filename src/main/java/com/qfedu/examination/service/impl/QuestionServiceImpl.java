package com.qfedu.examination.service.impl;

import com.qfedu.examination.dao.QuestionDao;
import com.qfedu.examination.entity.*;
import com.qfedu.examination.model.RandomCreateQuestionModel;
import com.qfedu.examination.poi.*;
import com.qfedu.examination.random.RandomCreateQuestionID;
import com.qfedu.examination.service.QuestionService;
import com.qfedu.examination.vo.R;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

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
    public R deriveChoice(int subjectID, String filePath, String fileName) {
        List<ChoiceQuestion> choiceQuestions = questionDao.choiceList(subjectID);
        try {
            ChoiceDerive.createExcel(choiceQuestions, filePath, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.setOK("导出成功");
    }

    @Override
    public R toLeadChoice(String filePath) {
        List<ChoiceQuestion> toLead = ChoiceToLead.Tolead(filePath);
        if (toLead == null || toLead.equals("") || toLead.size() == 0) {
            return R.setERROR("文件不存在，导入失败");
        }
        for (ChoiceQuestion cq : toLead) {
            questionDao.choiceEntering(cq);
        }
        return R.setOK("导入成功");

    }

    @Override
    public R choiceListByID(int id) {

        ChoiceQuestion oneChoice = questionDao.choiceListByID(id);
        return R.setOK("success", oneChoice);
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

        if (choiceQuestion.getId() == null || choiceQuestion.getId() == 0) {
            int count = questionDao.choiceEntering(choiceQuestion);
            if (count == 1) {
                return R.setOK("插入数据成功");
            } else {
                return R.setERROR("插入数据失败");
            }
        } else {
            int count = questionDao.updateChoice(choiceQuestion);
            if (count == 1) {
                return R.setOK("修改数据成功");
            } else {
                return R.setERROR("修改数据失败");
            }
        }


    }

    @Override
    public R judgeList(int subjectID) {

        return R.setOK("success", questionDao.judgeList(subjectID));
    }

    @Override
    public R judgeListByID(int id) {

        return R.setOK("success", questionDao.judgeListByID(id));
    }

    @Override
    public R deriveJudge(int subjectID, String filePath, String fileName) {
        List<JudgeQuestion> judgeQuestions = questionDao.judgeList(subjectID);
        try {
            JudgeDerive.createExcel(judgeQuestions, filePath, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.setOK("导出成功");
    }

    @Override
    public R toLeadJudge(String filePath) {
        List<JudgeQuestion> toLead = JudgeToLead.Tolead(filePath);
        if (toLead == null || toLead.equals("") || toLead.size() == 0) {
            return R.setERROR("文件不存在，导入失败");
        }
        for (JudgeQuestion jq : toLead) {
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

        if (judgeQuestion.getId() == null || judgeQuestion.getId() == 0) {
            int i = questionDao.saveJudge(judgeQuestion);
            return R.setResult(i == 1, "录入判断题");
        } else {
            int i = questionDao.updateJudge(judgeQuestion);
            return R.setResult(i == 1, "修改判断题");
        }


    }

    @Override
    public R queryShort(int subjectID) {
        return R.setOK("success", questionDao.queryShort(subjectID));
    }

    @Override
    public R deriveShort(int subjectID, String filePath, String fileName) {
        List<ShortQuestion> shortQuestions = questionDao.queryShort(subjectID);
        try {
            ShortDerive.createExcel(shortQuestions, filePath, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.setOK("导出成功");
    }

    @Override
    public R toLeadShort(String filePath) {
        List<ShortQuestion> toLead = ShortToLead.Tolead(filePath);
        if (toLead == null || toLead.equals("") || toLead.size() == 0) {
            return R.setERROR("文件不存在，导入失败");
        }

        for (ShortQuestion sq : toLead) {
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

        if (shortQuestion.getId() == null || shortQuestion.getId() == 0) {
            int i = questionDao.saveShort(shortQuestion);
            return i == 1 ? R.setOK("录入简答题成功") : R.setERROR("录入简答题失败");
        } else {
            int i = questionDao.updateShort(shortQuestion);
            return i == 1 ? R.setOK("修改简答题成功") : R.setERROR("修改简答题失败");
        }


    }

    @Override
    public R shortListByID(int id) {
        return R.setOK("success", questionDao.shortListByID(id));
    }

    @Override
    public R queryOneQuestionType(int id) {
        QuestionType questionType = questionDao.queryOneQuestionType(id);
        return R.setOK(questionType);
    }

    @Override
    public R saveQuestionType(QuestionType questionType) {
        Integer result = questionType.getId();
        if (result == null || result == 0) {
            int count = questionDao.saveQuestionType(questionType);
            return count == 1 ? R.setOK("保存成功") : R.setERROR("保存失败");
        } else {
            int count = questionDao.updateQuestionType(questionType);
            return count == 1 ? R.setOK("修改成功") : R.setERROR("修改失败");
        }
    }

    @Override
    public R delQuestionType(int id) {
        int i = questionDao.delQuestionType(id);
        return R.setResult(i == 1, "200：成功，400:失败");
    }

    /*@Override     //死递归代码
    public R randomCreateQuestion(int choiceCount, int judgeCount, int shortCount) {
        int[] ints = randomCreateQuestionID.randomChoiceId(choiceCount);
        for (int s:ints) {
            System.out.println(s+"~~~");
        }
        List<ChoiceQuestion> choiceList = new ArrayList<>();
        for (int c : ints) {
            ChoiceQuestion choiceQuestion = randomCreateQuestionID.forChoice(c);
            choiceList.add(choiceQuestion);
        }

        System.out.println(choiceList.size());

        return null;
    }*/


    @Override
    public R randomCreateQuestion(String name, int choiceCount, int judgeCount, int shortCount, int subjectID) {

        RandomCreateQuestion randomCreateQuestion = new RandomCreateQuestion();
        randomCreateQuestion.setName(name);
        randomCreateQuestion.setSubID(subjectID);
        StringBuffer str = new StringBuffer();

        List<ChoiceQuestion> choiceList = questionDao.choiceList(subjectID);


        int choiceNum = choiceList.size();
        if (choiceCount > choiceNum) {
            return R.setERROR("生成选择题数量超出范围");
        }
        int[] choiceRandoms = RandomCreateQuestionID.Randoms(choiceNum, choiceCount);

        for (int s : choiceRandoms) {
            str.append(choiceList.get(s).getId() + ",");
        }
        str.delete(str.lastIndexOf(","), str.lastIndexOf(",") + 1);
        randomCreateQuestion.setCid(str.toString());
        str.delete(0, str.length() + 1);

        List<JudgeQuestion> judgeList = questionDao.judgeList(subjectID);
        int judgeNum = judgeList.size();
        if (judgeCount > judgeNum) {
            return R.setERROR("生成判断题数量超出范围");
        }

        int[] judgeRandoms = RandomCreateQuestionID.Randoms(judgeNum, judgeCount);

        for (int j : judgeRandoms) {
            str.append(judgeList.get(j).getId() + ",");
        }
        str.delete(str.lastIndexOf(","), str.lastIndexOf(",") + 1);
        randomCreateQuestion.setJid(str.toString());
        str.delete(0, str.length() + 1);

        List<ShortQuestion> shortList = questionDao.queryShort(subjectID);
        int shortNum = shortList.size();
        if (shortCount > shortNum) {
            return R.setERROR("生成简答题长度超出范围");
        }
        int[] shortRandoms = RandomCreateQuestionID.Randoms(shortNum, shortCount);
        for (int s : shortRandoms) {
            str.append(shortList.get(s).getId() + ",");
        }
        str.delete(str.lastIndexOf(","), str.lastIndexOf(",") + 1);
        randomCreateQuestion.setShid(str.toString());
        str.delete(0, str.length() + 1);
        randomCreateQuestion.setCreateTime(new Date());
        int result = questionDao.saveRandomQuestion(randomCreateQuestion);
        return result == 1 ? R.setOK("随机生成试卷成功") : R.setERROR("随机生成试卷失败");
    }

    @Override
    public R queryAllRandomQuestion(int subID) {
        List<RandomCreateQuestionModel> list = questionDao.queryAllRandomQuestion(subID);
        return list!=null?R.setOK(list):R.setOK("对应课程的试卷为空");
    }

    @Override
    public R delRandomQuestion(int id) {
        questionDao.delRandomQuestion(id);
        return R.setOK("删除记录");
    }

    @Override
    public R queryOneRandomQuestion(int id) {
        RandomCreateQuestionModel randomCreateQuestionModel = questionDao.queryOneRandomQuestion(id);
        return R.setOK(randomCreateQuestionModel);
    }

    @Override
    public R updateRandomQuestion(RandomCreateQuestionModel randomCreateQuestionModel) {
       int result = questionDao.updateRandomQuestion(randomCreateQuestionModel);
        return result==1?R.setOK("修改成功"):R.setERROR("修改失败");
    }
}