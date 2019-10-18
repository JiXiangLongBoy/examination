package com.qfedu.examination.service.impl;

import com.qfedu.examination.dao.ExamTImeManageDao;
import com.qfedu.examination.entity.ExamTime;
import com.qfedu.examination.service.ExamTimeManageService;
import com.qfedu.examination.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamTimeManageServiceImpl implements ExamTimeManageService {


    @Autowired
    ExamTImeManageDao examTImeManageDao;

    @Override
    public R queryAllExamTime() {

        List<ExamTime> examTimeList = examTImeManageDao.queryAllExamTime();

        return R.setOK(examTimeList);
    }

    @Override
    public R queryOneExamTime(int id) {
        ExamTime examTime = examTImeManageDao.queryOneExamTime(id);
        return R.setOK(examTime);
    }

    @Override
    public R saveExamTime(ExamTime examTime) {
        Integer id = examTime.getId();
        long begin = examTime.getBegins().getTime();
        long end =examTime.getEnds().getTime();
        long count =((end - begin)/1000/60);
        System.out.println(count+"分钟");
        int success = (int) count;
        examTime.setDuration(success);
        if (id == null || id == 0) {
            System.out.println(examTime.getBegins());
            System.out.println(examTime.getEnds());
            int result = examTImeManageDao.saveExamTime(examTime);

            return result == 1 ? R.setOK("保存成功") : R.setERROR("保存失败");
        } else {
            int result = examTImeManageDao.updateExamTime(examTime);
            return result == 1 ? R.setOK("修改成功") : R.setERROR("修改失败");
        }
    }

    @Override
    public R deleteExamTime(int id) {
        int result=examTImeManageDao.deleteExamTime(id);
        return R.setResult(result==1,"删除记录");
    }
}
