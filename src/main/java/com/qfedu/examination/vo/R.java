package com.qfedu.examination.vo;

import lombok.Data;

@Data
public class R {
    private int code;
    private String msg;
    private Object data;

    public static R setOK(String msg,Object obj){
        R r=new R();
        r.setCode(0);
        r.setMsg(msg);
        r.setData(obj);
        return r;
    }

    public static R setOK(Object obj){
        R r=new R();
        r.setCode(0);
        r.setMsg("success");
        r.setData(obj);
        return r;
    }

    public static R setOK(String msg){
        R r=new R();
        r.setCode(0);
        r.setMsg(msg);
        r.setData(null);
        return r;
    }
    public static R setOK(){
        R r=new R();
        r.setCode(0);
        r.setMsg("OK");
        r.setData(null);
        return r;
    }
    public static R setERROR(String msg,Object obj){
        R r=new R();
        r.setCode(1);
        r.setMsg(msg);
        r.setData(obj);
        return r;
    }
    public static R setERROR(String msg){
        R r=new R();
        r.setCode(1);
        r.setMsg(msg);
        r.setData(null);
        return r;
    }
    public static R setERROR(){
        R r=new R();
        r.setCode(1);
        r.setMsg("Error");
        r.setData(null);
        return r;
    }
    public static R setResult(boolean issuccess,String msg){
        R r=new R();
        r.setCode(issuccess?0:1);
        r.setMsg(msg);
        r.setData(null);
        return r;
    }


}
