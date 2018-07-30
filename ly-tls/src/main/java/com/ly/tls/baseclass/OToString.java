package com.ly.tls.baseclass;

/**
 * Created by Herdsric-M-003 on 2018/7/27.
 */
public class OToString {
    public static String toString(Object o){
        try {
            return String.valueOf(o);
        }catch (Throwable t){
            throw new BaseClassException(-1,"对象转字符串失败",t);
        }
    }

    public static String toBlank(Object o){
        if(o==null) return "";
        return String.valueOf(o);
    }
}
