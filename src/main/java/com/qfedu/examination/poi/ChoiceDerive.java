package com.qfedu.examination.poi;

import com.qfedu.examination.entity.ChoiceQuestion;
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

public class ChoiceDerive {
    public static SXSSFWorkbook  createExcel(List<ChoiceQuestion> choiceList) throws IOException {
        //1、创建文档对象
        SXSSFWorkbook workbook=new SXSSFWorkbook();
        //2、创建Sheet
        SXSSFSheet sxssfSheet=workbook.createSheet("选择题");
        //3、创建标题行
        SXSSFRow row=sxssfSheet.createRow(0);

        //创建单元格样式对象
        CellStyle cellStyle=workbook.createCellStyle();
        //创建字体对象
        Font font=workbook.createFont();
        font.setBold(true);
        font.setColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
        cellStyle.setFont(font);

        //创建列
        SXSSFCell cell1=row.createCell(0);
        cell1.setCellValue("分值");
        cell1.setCellStyle(cellStyle);
        SXSSFCell cell2=row.createCell(1);
        cell2.setCellValue("题目");
        cell2.setCellStyle(cellStyle);
        SXSSFCell cell3=row.createCell(2);
        cell3.setCellValue("选项A");
        cell3.setCellStyle(cellStyle);
        SXSSFCell cell4=row.createCell(3);
        cell4.setCellValue("选项B");
        cell4.setCellStyle(cellStyle);
        SXSSFCell cell5=row.createCell(4);
        cell5.setCellValue("选项C");
        cell5.setCellStyle(cellStyle);
        SXSSFCell cell6=row.createCell(5);
        cell6.setCellValue("选项D");
        cell6.setCellStyle(cellStyle);
        SXSSFCell cell7=row.createCell(6);
        cell7.setCellValue("正确答案");
        cell7.setCellStyle(cellStyle);


        int i =0;
        for (ChoiceQuestion choice:choiceList) {
            SXSSFRow r=sxssfSheet.createRow(i+1);

            SXSSFCell c01=r.createCell(0);
            c01.setCellValue(choice.getScore());

            SXSSFCell c02=r.createCell(1);
            c02.setCellValue(choice.getQuestion());

            SXSSFCell c03=r.createCell(2);
            c03.setCellValue(choice.getChoiceA());

            SXSSFCell c04=r.createCell(3);
            c04.setCellValue(choice.getChoiceB());

            SXSSFCell c05=r.createCell(4);
            c05.setCellValue(choice.getChoiceC());

            SXSSFCell c06=r.createCell(5);
            c06.setCellValue(choice.getChoiceD());

            SXSSFCell c07=r.createCell(6);
            c07.setCellValue(choice.getAnswer());
            i++;
        }

        //5、保存x
//        workbook.write(new FileOutputStream(filePath+"\\"+fileName+".xlsx"));
        return workbook;
    }
}
