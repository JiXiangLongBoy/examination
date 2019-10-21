package com.qfedu.examination.dao;

import com.qfedu.examination.entity.ExamTime;
import com.qfedu.examination.vo.Page;

import java.util.List;

public interface ExamTImeManageDao {
    List<ExamTime> queryAllExamTime(Page page);

    ExamTime queryOneExamTime(int id);

    int saveExamTime(ExamTime examTime);

    int updateExamTime(ExamTime examTime);

    int deleteExamTime(int id);
}
