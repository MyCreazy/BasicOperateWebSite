package com.sl.CrawRuleSettingSystem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sl.CrawRuleSettingSystem.dao.CrawRuleDao;
import com.sl.CrawRuleSettingSystem.dao.LoginDao;
import com.sl.CrawRuleSettingSystem.model.UserInfoVo;
import com.sl.CrawRuleSettingSystem.service.LoginService;

/**
 * 登录服务实现层
 * @author Administrator
 *
 */
@Service(value="loginService")
public class LoginServiceImpl  implements LoginService{
	/**
	 * 获取dao层对象
	 */
	@Resource(name = "loginDao")
	private LoginDao loginDao;
	
	/**
	 * 获取用户信息
	 */
	@Override
	public UserInfoVo getUserInfo(String userName) {
		// TODO Auto-generated method stub
		return loginDao.getUserInfo(userName);
	}
}
