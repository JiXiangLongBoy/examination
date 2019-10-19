package com.qfedu.examination.common;

import com.qfedu.examination.vo.R;
import lombok.Data;

@Data
public class J {
    private int code; //0成功  1失败
    private Object data;

    public static J setOK(){
        J j=new J();
        j.setCode(0);
        j.setData(null);
        return j;
    }
    public static J setOK(Object info){
        J j=new J();
        j.setCode(0);
        j.setData(info);
        return j;
    }
   public static J setError(){
       J j=new J();
       j.setCode(1);
       j.setData(null);
       return j;
   }
    public static J setError(Object info){
        J j=new J();
        j.setCode(1);
        j.setData(info);
        return j;
    }


}
