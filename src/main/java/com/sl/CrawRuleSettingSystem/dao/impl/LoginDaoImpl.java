package com.sl.CrawRuleSettingSystem.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sl.CrawRuleSettingSystem.dao.LoginDao;
import com.sl.CrawRuleSettingSystem.model.CrawRuleInfoVo;
import com.sl.CrawRuleSettingSystem.model.UserInfoVo;

/**
 * 登录数据操作实现层
 * 
 * @author Administrator
 *
 */
@Repository(value = "loginDao")
public class LoginDaoImpl implements LoginDao {
	/**
	 * sql对象
	 */
	@Resource(name = "sqlSessionTemplate")
	private SqlSession sqlsession;

	/**
	 * 获取用户信息
	 */
	@Override
	public UserInfoVo getUserInfo(String userName) {
		// TODO Auto-generated method stub
		UserInfoVo result = null;
		try {
			Map<String,String> map=new HashMap<String,String>(); 
			map.put("UserName", userName);
			result = sqlsession.selectOne("loginDBOperate.findbyCondition",map);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return result;
	}
}
