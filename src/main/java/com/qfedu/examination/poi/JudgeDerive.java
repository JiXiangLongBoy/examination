package com.qfedu.examination.poi;

import com.qfedu.examination.entity.ChoiceQuestion;
import com.qfedu.examination.entity.JudgeQuestion;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class JudgeDerive {
    public static void  createExcel(List<JudgeQuestion> judgeList, String filePath, String fileName) throws IOException {
        //1、创建文档对象
        SXSSFWorkbook workbook=new SXSSFWorkbook();
        //2、创建Sheet
        SXSSFSheet sxssfSheet=workbook.createSheet("判断题");
        //3、创建标题行
        SXSSFRow row=sxssfSheet.createRow(0);

        //创建单元格样式对象
        CellStyle cellStyle=workbook.createCellStyle();
        //创建字体对象
        Font font=workbook.createFont();
        font.setBold(true);
        font.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        cellStyle.setFont(font);

        //创建列
        SXSSFCell cell1=row.createCell(0);
        cell1.setCellValue("分值");
        cell1.setCellStyle(cellStyle);
        SXSSFCell cell2=row.createCell(1);
        cell2.setCellValue("题目");
        cell2.setCellStyle(cellStyle);
        SXSSFCell cell3=row.createCell(2);
        cell3.setCellValue("答案");
        cell3.setCellStyle(cellStyle);


        int i =0;
        for (JudgeQuestion choice:judgeList) {
            SXSSFRow r=sxssfSheet.createRow(i+1);

            SXSSFCell c01=r.createCell(0);
            c01.setCellValue(choice.getScore());

            SXSSFCell c02=r.createCell(1);
            c02.setCellValue(choice.getQuestion());

            SXSSFCell c03=r.createCell(2);
            if (choice.getAnswer()==1){
                c03.setCellValue("√");
            }else {
                c03.setCellValue("×");
            }
            i++;
        }

        //5、保存
        workbook.write(new FileOutputStream(filePath+"\\"+fileName+".xlsx"));
        workbook.close();
        System.out.println("生成成功");
    }
}
