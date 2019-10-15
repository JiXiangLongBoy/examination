package com.qfedu.examination.poi;

import com.qfedu.examination.entity.ChoiceQuestion;
import com.qfedu.examination.entity.JudgeQuestion;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class JudgeToLead {
    public static List<JudgeQuestion> Tolead(String filePath) {
        List<JudgeQuestion> list = new ArrayList<>();
        int i =0;
        try {
            List<HashMap> hashMaps = JudgeToLead.readExcel(filePath);
            for (HashMap hm : hashMaps) {
                JudgeQuestion judgeQuestion = new JudgeQuestion();
                judgeQuestion.setScore(new Double(Double.parseDouble(hm.get("score").toString())).intValue());
                judgeQuestion.setQuestion(hm.get("question").toString());

                if (hm.get("answer").equals("√")){
                    judgeQuestion.setAnswer(1);
                }else {
                    judgeQuestion.setAnswer(0);
                }
               // judgeQuestion.setAnswer(new Double(Double.parseDouble(hm.get("answer").toString())).intValue());

                judgeQuestion.setSubjectID(new Double(Double.parseDouble(hm.get("subjectID").toString())).intValue());
                list.add(judgeQuestion);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    //读取
    private static List<HashMap> readExcel(String filePath) throws IOException {
        List<HashMap> list = new ArrayList<>();
        //1、验证文件是否存在
        File file = new File(filePath);
        if (file.exists()) {
            Workbook workbook = null;
            //2、根据后缀名选择指定对象
            workbook = new XSSFWorkbook(new FileInputStream(filePath));
            //3、验证是否为表格
            if (workbook != null) {
                //4、遍历文档的Sheet
                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    //5、获取Sheet
                    Sheet sheet = workbook.getSheetAt(i);
                    //获取内容
                    for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                        HashMap<String, Object> map = new LinkedHashMap<>();
                        Row row1 = sheet.getRow(j);
//                        row1.getLastCellNum();
                        map.put("score", getValue(row1.getCell(0)));
                        map.put("question", getValue(row1.getCell(1)));
                        map.put("answer", getValue(row1.getCell(2)));
                        map.put("subjectID", getValue(row1.getCell(3)));
                        list.add(map);
                    }
                }
            }
        }
        return list;
    }

    private static Object getValue(Cell cell) {
        Object obj = null;
        if (cell.getCellType().equals(CellType.STRING)) {
            obj = cell.getStringCellValue();
        } else if (cell.getCellType().equals(CellType.NUMERIC)) {
            obj = cell.getNumericCellValue();
        } else if (cell.getCellType().equals(CellType.BOOLEAN)) {
            obj = cell.getBooleanCellValue();
        }
        return obj;
    }

}
