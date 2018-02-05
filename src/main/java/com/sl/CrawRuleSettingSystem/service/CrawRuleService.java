package com.sl.CrawRuleSettingSystem.service;

import java.util.List;

import com.sl.CrawRuleSettingSystem.model.CrawRuleInfoVo;

/**
 * 爬虫规则服务层
 * @author Administrator
 *
 */
public interface CrawRuleService {
	/**
	 * 根据条件查询爬虫规则
	 * @param crawInfo
	 * @return
	 */
	public List<CrawRuleInfoVo> findAllByCondition(CrawRuleInfoVo crawInfo);
	
	/**
	 * 添加爬虫规则
	 * @param crawInfo
	 * @return
	 */
	public int addCrawRule(CrawRuleInfoVo crawInfo);
	
	/**
	 * 删除爬虫规则
	 * @param keyid
	 * @return
	 */
	public int delCrawRule(String keyid);
	
	/**
	 * 更新爬虫规则
	 * @param crawInfo
	 * @return
	 */
	public int updateCrawRule(CrawRuleInfoVo crawInfo);
}
