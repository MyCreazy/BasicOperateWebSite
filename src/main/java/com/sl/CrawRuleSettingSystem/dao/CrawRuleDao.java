package com.sl.CrawRuleSettingSystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sl.CrawRuleSettingSystem.model.CrawRuleInfoVo;

/**
 * 爬虫规则dao层
 * 
 * @author Administrator
 *
 */
public interface CrawRuleDao {
	/**
	 * 根据条件获取规则
	 * 
	 * @param crawRule
	 * @return 返回爬虫规则
	 */
	public List<CrawRuleInfoVo> findAllByCondition(CrawRuleInfoVo crawRule);

	/**
	 * 添加爬虫规则
	 * 
	 * @param crawInfo
	 * @return
	 */
	public int addCrawRule(CrawRuleInfoVo crawInfo);

	/**
	 * 删除爬虫规则
	 * 
	 * @param keyid
	 * @return
	 */
	public int delCrawRule(String keyid);

	/**
	 * 更新爬虫规则
	 * 
	 * @param crawInfo
	 * @return
	 */
	public int updateCrawRule(CrawRuleInfoVo crawInfo);
}
