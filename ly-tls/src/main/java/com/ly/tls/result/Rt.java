package com.ly.tls.result;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Herdsric-M-003 on 2018/5/3.
 */
public class Rt {
    /**
     * @param code code < 0:失败，数值表示错误编码，=0：成功
     * @param data 消息或数据
     * @param <T>
     * @return
     */
    public static <T> Map<String,Object> result(int code,T data){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",code);
        map.put("data",data);
        return map;
    }

}
