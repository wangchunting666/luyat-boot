package com.ly.tls.throwable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Herdsric-M-003 on 2018/7/27.
 */
public class ServiceException extends RuntimeException{
    protected Logger logger = LogManager.getLogger(this.getClass());
    private int code;
    private String msg;

    public ServiceException(int code, String msg){
        super();
        logger.error("code:"+code+","+"msg:"+msg);
    }

    public ServiceException(int code, String msg, Throwable t){
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
