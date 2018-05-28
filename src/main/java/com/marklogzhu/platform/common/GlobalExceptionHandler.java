package com.marklogzhu.platform.common;

import com.marklogzhu.platform.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义全局异常处理器
 */
@Slf4j
public class GlobalExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception ex) {
        ModelAndView mv;
        String url = request.getRequestURL().toString();
        if (url.endsWith(".json")) {// 这里我们要求项目中所有请求json数据，都使用.json结尾
            if (ex instanceof GlobalException) {
                JsonData result = JsonData.createByErrorMessage(((GlobalException) ex).getMsg());
                mv = new ModelAndView("jsonView", result.toMap());
            } else {
                // 关键位置需要做好日志记录功能，方便项目上线后追溯
                log.error("未定义 json 请求格式异常, url:" + url, ex);
                JsonData result = JsonData.createByErrorMessage(CodeMsg.UNKNOWN_JSON_ERROR.fillArgs(ex));
                mv = new ModelAndView("jsonView", result.toMap());
            }
        } else if (url.endsWith(".page")) { // 这里我们要求项目中所有请求page页面，都使用.page结尾
            log.error("未定义 page 请求格式异常, url:" + url, ex);
            JsonData result = JsonData.createByErrorMessage(CodeMsg.PAGE_ERROR.fillArgs(ex));
            mv = new ModelAndView("exception", result.toMap());
        } else {
            log.error("未定义异常, url:" + url, ex);
            JsonData result = JsonData.createByErrorMessage(CodeMsg.UNKNOWN_ERROR.fillArgs(ex));
            mv = new ModelAndView("jsonView", result.toMap());
        }
        return mv;
    }
}
