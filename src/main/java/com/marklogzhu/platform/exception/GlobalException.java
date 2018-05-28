package com.marklogzhu.platform.exception;

import com.marklogzhu.platform.common.CodeMsg;

public class GlobalException  extends RuntimeException {
    /**
     * 异常信息对象
     */
    private CodeMsg msg;

    public GlobalException(CodeMsg msg) {
        super(msg.toString());
        this.msg = msg;
    }
    public CodeMsg getMsg() {
        return msg;
    }
}
