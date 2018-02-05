package com.sl.CrawRuleSettingSystem.dao;

import com.sl.CrawRuleSettingSystem.model.UserInfoVo;

/**
 * 登录数据操作接口层
 * @author Administrator
 *
 */
public interface LoginDao {
	/**
	 * 根据用户名获取用户信息
	 * @param userName
	 * @return
	 */
	public UserInfoVo getUserInfo(String userName);
}
