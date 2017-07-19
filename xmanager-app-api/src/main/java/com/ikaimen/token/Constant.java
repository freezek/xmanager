package com.ikaimen.token;

/**
 * Created by Tom Chen on 2017/7/19.
 * 常量类
 */
public  class  Constant {

    /**
     * jwt
     *
     */
    public static final String JWT_ID = "jwt";
    public static final String JWT_SECRET = "ikaimen";
    public static final int JWT_TTL = 60*60*1000;  //millisecond
    public static final int JWT_REFRESH_INTERVAL = 55*60*1000;  //millisecond
    public static final int JWT_REFRESH_TTL = 12*60*60*1000;  //millisecond

}
