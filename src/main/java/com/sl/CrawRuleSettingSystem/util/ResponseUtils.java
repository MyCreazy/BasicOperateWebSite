package com.sl.CrawRuleSettingSystem.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Administrator
 *
 */
public class ResponseUtils {
	/**
	 * 日志对象
	 */
	private static Logger logger = LogManager.getLogger(RequestUtils.class);
	 /**
     * 发送json格式数据到页面
     * 
     * @param response
     * @param content
     */
    public static void send(HttpServletResponse response, String content) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            //若发送数据为null 则默认为""
            if(content == null){
                content = "";
            }
            out.write(content);
        }
        catch (IOException e) {
        	logger.error(e.getLocalizedMessage(), e);
        }
        finally {
            if (out != null){
                out.close();
            }
        }
    }
}
