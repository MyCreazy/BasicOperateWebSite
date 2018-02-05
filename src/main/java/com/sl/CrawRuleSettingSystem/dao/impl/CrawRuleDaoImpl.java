package com.sl.CrawRuleSettingSystem.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sl.CrawRuleSettingSystem.dao.CrawRuleDao;
import com.sl.CrawRuleSettingSystem.model.CrawRuleInfoVo;

/**
 * 爬虫规则数据库操作实现层
 * 
 * @author Administrator
 *
 */
@Repository(value = "crawRuleDao")
public class CrawRuleDaoImpl implements CrawRuleDao {
	/**
	 * sql对象
	 */
	@Resource(name = "sqlSessionTemplate")
	private SqlSession sqlsession;

	/**
	 * 根据条件获取爬虫规则
	 */
	public List<CrawRuleInfoVo> findAllByCondition(CrawRuleInfoVo crawRule) {
		// TODO Auto-generated method stub
		List<CrawRuleInfoVo> result = null;
		try {
			result = sqlsession.selectList("crawruleDBOperate.findbyCondition",crawRule);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return result;
	}

	/**
	 * 添加爬虫规则
	 */
	public int addCrawRule(CrawRuleInfoVo crawInfo) {
		int result = 0;
		try {
			result = sqlsession.insert("crawruleDBOperate.insertCrawRule", crawInfo);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return result;
	}
	
	/**
	 * 删除爬虫规则
	 * @param keyid
	 * @return
	 */
	public int delCrawRule(String keyid)
	{
		int result = 0;
		try {
			result = sqlsession.update("crawruleDBOperate.delCrawRule", keyid);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return result;
	}
	
	/**
	 * 更新爬虫规则
	 * 
	 * @param crawInfo
	 * @return
	 */
	public int updateCrawRule(CrawRuleInfoVo crawInfo)
	{
		int result = 0;
		try {
			result = sqlsession.update("crawruleDBOperate.updatelCrawRule", crawInfo);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return result;
	}
}
