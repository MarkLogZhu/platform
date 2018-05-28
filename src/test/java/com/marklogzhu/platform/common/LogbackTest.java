package com.marklogzhu.platform.common;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogbackTest {

    // 定义一个全局的记录器，通过 LoggerFactory 获取
    private static final Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void testLog() {
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
}
