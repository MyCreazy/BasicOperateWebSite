package com.sl.CrawRuleSettingSystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sl.CrawRuleSettingSystem.dao.CrawRuleDao;
import com.sl.CrawRuleSettingSystem.model.CrawRuleInfoVo;
import com.sl.CrawRuleSettingSystem.service.CrawRuleService;

/**
 * 爬虫规则服务实现层
 * @author Administrator
 *
 */
@Service(value = "crawRuleService")
public class CrawRuleServiceImpl implements CrawRuleService {
	/**
	 * 获取dao层对象
	 */
	@Resource(name = "crawRuleDao")
	private CrawRuleDao crawRuleDao;

	/**
	 * 根据条件查询爬虫规则
	 */
	public List<CrawRuleInfoVo> findAllByCondition(CrawRuleInfoVo crawRule) {
		// TODO Auto-generated method stub
		return crawRuleDao.findAllByCondition(crawRule);
	}
	
	/**
	 * 添加爬虫规则
	 */
	public int addCrawRule(CrawRuleInfoVo crawInfo)
	{
		int result=0;
		result=crawRuleDao.addCrawRule(crawInfo);
		return result;
	}
	
	/**
	 * 删除爬虫规则
	 * @param keyid
	 * @return
	 */
	public int delCrawRule(String keyid)
	{
		int result=0;
		result=crawRuleDao.delCrawRule(keyid);
		return result;
	}
	
	/**
	 * 更新爬虫规则
	 */
	public int updateCrawRule(CrawRuleInfoVo crawInfo)
	{
		int result=0;
		result=crawRuleDao.updateCrawRule(crawInfo);
		return result;
	}
}
