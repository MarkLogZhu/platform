package com.marklogzhu.platform.exception;

import com.marklogzhu.platform.common.CodeMsg;

/**
 * 参数检验异常
 */
public class ParamException extends GlobalException {

    public ParamException(String msgStr) {
        super(CodeMsg.PARAM_CHECK_ERROR.fillArgs(msgStr));
    }

}
