package com.marklogzhu.platform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Map;

@Configuration
@EnableWebMvc
public class CaseInsensitivePathMatcher extends AntPathMatcher {

    protected boolean doMatch(String pattern, String path, boolean fullMatch, Map uriTemplateVariables) {
        return super.doMatch(pattern.toLowerCase(), path.toLowerCase(), fullMatch, uriTemplateVariables);
    }
}
