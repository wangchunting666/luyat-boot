package com.ly.tls.baseclass;

/**
 * Created by Herdsric-M-003 on 2018/7/27.
 */
public class OToInt {
    public static int toInt(Object o){
        try {
            return Integer.valueOf(o.toString());
        }catch (Throwable t){
            throw new BaseClassException(-1,"对象转整形失败",t);
        }
    }
}
