package com.sl.CrawRuleSettingSystem.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class SpecialParameterizedType implements ParameterizedType {
	/**
	 * clz.
	 */
	private Class clz;

	/**
	 * actualType.
	 */
	private Class actualType;

	/**
	 * 构造函数.
	 * 
	 * @param clz
	 *            clz
	 * @param actualType
	 *            s
	 */
	public SpecialParameterizedType(Class clz, Class actualType) {
		super();
		if (null == clz || null == actualType) {
			throw new RuntimeException("cla or actualType can not null");
		}
		this.clz = clz;
		this.actualType = actualType;
	}

	public Type[] getActualTypeArguments() {
		// TODO Auto-generated method stub
		return new Type[] { actualType };
	}

	public Type getOwnerType() {
		// TODO Auto-generated method stub
		return clz;
	}

	public Type getRawType() {
		// TODO Auto-generated method stub
		return null;
	}

}
