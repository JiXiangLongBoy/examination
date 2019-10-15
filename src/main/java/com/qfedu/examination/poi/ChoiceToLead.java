package com.qfedu.examination.poi;

import com.qfedu.examination.entity.ChoiceQuestion;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class ChoiceToLead {


    public static void main(String[] args) throws IOException {
        List<HashMap> maps =ChoiceToLead.readExcel("Question.xlsx");
                maps.get(0);
        ChoiceQuestion choiceQuestion = null;
        for (HashMap sd : maps) {
            choiceQuestion = new ChoiceQuestion();
            choiceQuestion.setAnswer(sd.get("answer").toString());
        }
        System.out.println(choiceQuestion);
    }

    public static List<ChoiceQuestion> Tolead(String filePath) {
        List<ChoiceQuestion> list = new ArrayList<>();
        int i =0;
        try {
            List<HashMap> hashMaps = ChoiceToLead.readExcel(filePath);
            for (HashMap hm : hashMaps) {
                ChoiceQuestion choiceQuestion = new ChoiceQuestion();
                choiceQuestion.setScore(new Double(Double.parseDouble(hm.get("score").toString())).intValue());
                choiceQuestion.setQuestion(hm.get("question").toString());
                choiceQuestion.setChoiceA(hm.get("choiceA").toString());
                choiceQuestion.setChoiceB(hm.get("choiceB").toString());
                choiceQuestion.setChoiceC(hm.get("choiceC").toString());
                choiceQuestion.setChoiceD(hm.get("choiceD").toString());
                choiceQuestion.setAnswer(hm.get("answer").toString());
                choiceQuestion.setSubjectId(new Double(Double.parseDouble(hm.get("subjectID").toString())).intValue());
                list.add(choiceQuestion);
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
                        map.put("choiceA", getValue(row1.getCell(2)));
                        map.put("choiceB", getValue(row1.getCell(3)));
                        map.put("choiceC", getValue(row1.getCell(4)));
                        map.put("choiceD", getValue(row1.getCell(5)));
                        map.put("answer", getValue(row1.getCell(6)));
                        map.put("subjectID", getValue(row1.getCell(7)));
                        list.add(map);
                    }
                }
            }
            workbook.close();
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
