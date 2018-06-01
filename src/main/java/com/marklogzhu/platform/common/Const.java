package com.marklogzhu.platform.common;

public class Const {


    /**
     * redis 缓存时间
     */
    public interface RedisCacheExtime{
        /**
         * session 缓存时间
          */
        int REDIS_SESSION_EXTIME = 60 * 30;//30分钟
    }

    public interface UserStatus{
        /**
         * 冻结状态
         */
        int FREEZE = 0;
        /**
         * 正常
         */
        int NORMAL = 1;
        /**
         * 删除
         */
        int DELETE = 2;
    }

}
