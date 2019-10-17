package com.qfedu.examination.dao;

import com.qfedu.examination.entity.ExamTime;

import java.util.List;

public interface ExamTImeManageDao {
    List<ExamTime> queryAllExamTime();

    ExamTime queryOneExamTime(int id);

    int saveExamTime(ExamTime examTime);

    int updateExamTime(ExamTime examTime);
}
