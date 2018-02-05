package com.sl.CrawRuleSettingSystem.util;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;


/**
 * 请求辅助工具
 * @author Administrator
 *
 */
public class RequestUtils {
	/**
     * 返回字符串,删除了首尾空格,如果不存在则返回null
     * 
     * @param request
     * @param key
     * @return
     */
    public static String getString(HttpServletRequest request, String key) {
        String value = request.getParameter(key);
        if (StringUtils.isEmpty(value)) {
            return StringUtils.trimWhitespace(value);
        }
        return value;
    }
}
