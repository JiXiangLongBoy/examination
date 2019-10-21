package com.qfedu.examination.service;

import com.qfedu.examination.entity.ExamTime;
import com.qfedu.examination.vo.Page;
import com.qfedu.examination.vo.R;

public interface ExamTimeManageService {
    R queryAllExamTime(Page page);

    R queryOneExamTime(int id);

    R saveExamTime(ExamTime examTime);

    R deleteExamTime(int id);
}
