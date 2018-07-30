package com.ly.tls.baseclass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Herdsric-M-003 on 2018/7/27.
 */
public class BaseClassException extends RuntimeException{
    protected Logger logger = LogManager.getLogger(this.getClass());
    private int code;
    private String msg;

    public BaseClassException(int code,String msg){
        super();
        logger.error("code:"+code+","+"msg:"+msg);
    }

    public BaseClassException(int code,String msg,Throwable t){
        super(t);
        logger.error("code:"+code+","+"msg:"+msg,t);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
