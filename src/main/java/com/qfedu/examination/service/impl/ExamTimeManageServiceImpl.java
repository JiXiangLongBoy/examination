package com.qfedu.examination.service.impl;

import com.qfedu.examination.dao.ExamTImeManageDao;
import com.qfedu.examination.entity.ExamTime;
import com.qfedu.examination.service.ExamTimeManageService;
import com.qfedu.examination.vo.R;
import net.bytebuddy.asm.Advice;
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
}
