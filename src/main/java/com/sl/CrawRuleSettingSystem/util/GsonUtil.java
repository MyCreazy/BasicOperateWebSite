package com.sl.CrawRuleSettingSystem.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
	/**
	 * GSON.
	 */
	private static final Gson GSON;

	/**
	 * json序列化工具 .
	 *
	 */
	private static String formatDefault = "yyyy-MM-dd HH:mm:ss";

	/**
	 * json序列化工具 .
	 *
	 */
	private static String formatYmd = "yyyy-MM-dd";

	/**
	 * json序列化工具 .
	 *
	 */
	private static String formatYmdSlash = "yyyy/MM/dd HH:mm:ss";

	/**
	 * 构造函数.
	 * 
	 */
	private GsonUtil() {
		throw new RuntimeException("工具类不允许实例化!");
	}

	static {
		GSON = new GsonBuilder().setDateFormat(formatDefault).create(); // 避免本地环境不同导致模式字符串不同引发Date错乱
	}

	/**
	 * 获取GSON.
	 * 
	 * @return GSON
	 */
	public static Gson getGson() {
		return GSON;
	}

	/**
	 * 获取自定义日期格式的GSON.
	 * 
	 * @param format
	 *            .
	 * @return GSON
	 */
	public static Gson getGson(String format) {
		return new GsonBuilder().setDateFormat(format).create();
	}

	/**
	 * 
	 * TODO 添加方法注释.
	 * 
	 * @param json
	 *            .
	 * @param raw
	 *            .
	 * @param actual
	 *            .
	 * @param <T>
	 *            .
	 * @return .
	 */
	public static <T> T fromJson(String json, Class raw, Class actual) {
		return GSON.fromJson(json, new SpecialParameterizedType(raw, actual));
	}

	/**
	 * toJson,避免String再次被转义.
	 * 
	 * @param obj
	 *            obj
	 * @return String
	 */
	public static String toJson(Object obj) {
		if (obj instanceof String) {
			return obj.toString();
		} else {
			return GSON.toJson(obj);
		}
	}
}
