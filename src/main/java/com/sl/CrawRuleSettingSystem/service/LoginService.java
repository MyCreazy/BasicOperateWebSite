package com.sl.CrawRuleSettingSystem.service;

import com.sl.CrawRuleSettingSystem.model.UserInfoVo;

/**
 * 登录服务
 * @author Administrator
 *
 */
public interface LoginService {
	/**
	 * 获取用户信息
	 * @param userName
	 * @return
	 */
	public UserInfoVo getUserInfo(String userName);
}
