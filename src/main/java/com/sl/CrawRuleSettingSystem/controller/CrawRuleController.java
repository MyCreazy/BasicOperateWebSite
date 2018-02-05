package com.sl.CrawRuleSettingSystem.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sl.CrawRuleSettingSystem.model.CrawRuleInfoVo;
import com.sl.CrawRuleSettingSystem.model.UserInfoVo;
import com.sl.CrawRuleSettingSystem.service.CrawRuleService;
import com.sl.CrawRuleSettingSystem.util.GsonUtil;
import com.sl.CrawRuleSettingSystem.util.IdWorker;

/**
 * 爬虫相关规则管理
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/crawrule")
public class CrawRuleController {
	/**
	 * 获取服务层对象
	 */
	@Resource(name = "crawRuleService")
	private CrawRuleService crawRuleService;

	/**
	 * 时间格式
	 */
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 
	 * @param dataFlag
	 * @param excuteStatu
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/queryCrawRule", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String queryCrawRule(CrawRuleInfoVo crawInfo) throws ServletException, IOException {
		String resultjson = "";
		String tempstatu = "";
		//// 判断一下状态
		if (crawInfo.getExcuteStatu().equals("0")) {
			tempstatu = "-1";
		} else if (crawInfo.getExcuteStatu().equals("1")) {
			tempstatu = "0";
		} else if (crawInfo.getExcuteStatu().equals("2")) {
			tempstatu = "1";
		} else if (crawInfo.getExcuteStatu().equals("3")) {
			tempstatu = "2";
		}

		crawInfo.setExcuteStatu(tempstatu);
		//// 使用mybatis向数据库发出查询
		List<CrawRuleInfoVo> result = crawRuleService.findAllByCondition(crawInfo);
		if (result != null) {
			//// 判断一下是否是绑定数据发出的查询
			if ("".equals(crawInfo.getKeyID())) {
				//// 处理一下数据
				Iterator iter = result.iterator();
				while (iter.hasNext()) {
					CrawRuleInfoVo tempruleInfo = (CrawRuleInfoVo) iter.next();
					if ("0".equals(tempruleInfo.getRequestProtocolFlag())) {
						tempruleInfo.setRequestProtocolFlag("http");
					} else if ("1".equals(tempruleInfo.getRequestProtocolFlag())) {
						tempruleInfo.setRequestProtocolFlag("https");
					}

					if ("0".equals(tempruleInfo.getCompressFormatFlag())) {
						tempruleInfo.setCompressFormatFlag("未压缩");
					} else if ("1".equals(tempruleInfo.getCompressFormatFlag())) {
						tempruleInfo.setCompressFormatFlag("Gzip压缩");
					}

					if ("0".equals(tempruleInfo.getIsNeedCookie())) {
						tempruleInfo.setIsNeedCookie("无需Cookie");
					} else if ("1".equals(tempruleInfo.getIsNeedCookie())) {
						tempruleInfo.setIsNeedCookie("需要Cookie");
					}

					if ("0".equals(tempruleInfo.getRequestActionFlag())) {
						tempruleInfo.setRequestActionFlag("get");
					} else if ("1".equals(tempruleInfo.getRequestActionFlag())) {
						tempruleInfo.setRequestActionFlag("post");
					}

					if ("0".equals(tempruleInfo.getAnalysisWayFlag())) {
						tempruleInfo.setAnalysisWayFlag("正则");
					} else if ("1".equals(tempruleInfo.getAnalysisWayFlag())) {
						tempruleInfo.setAnalysisWayFlag("Xpath");
					}

					if ("0".equals(tempruleInfo.getIsRelyLastResult())) {
						tempruleInfo.setIsRelyLastResult("不依赖");
					} else if ("1".equals(tempruleInfo.getIsRelyLastResult())) {
						tempruleInfo.setIsRelyLastResult("依赖");
					}

					tempruleInfo.setIsUseProxyIP(tempruleInfo.getIsUseProxyIP().equals("0") ? "不使用" : "使用");
					tempruleInfo.setExcuteStatu(tempruleInfo.getExcuteStatu().equals("0") ? "未执行"
							: tempruleInfo.getExcuteStatu().equals("1") ? "执行中" : "执行完成");
				}
			}
			//// 序列化对象
			resultjson = GsonUtil.toJson(result);
		}

		return resultjson;
	}

	/**
	 * 添加爬虫规则
	 * 
	 * @param crawRuleInfo
	 * @return
	 */
	@RequestMapping(value = "/addCrawRule", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String addCrawRule(CrawRuleInfoVo crawRuleInfo) {
		String result = "";
		crawRuleInfo.setKeyID(new IdWorker(26).getKeyID(true));
		crawRuleInfo.setModifyTime(df.format(new Date()));
		if ("".equals(crawRuleInfo.getRuleSerial())) {
			crawRuleInfo.setRuleSerial("0");
		}

		if ("".equals(crawRuleInfo.getRequestProtocolFlag())) {
			crawRuleInfo.setRequestProtocolFlag("0");
		}

		if ("".equals(crawRuleInfo.getCompressFormatFlag())) {
			crawRuleInfo.setCompressFormatFlag("0");
		}

		if ("".equals(crawRuleInfo.getIsNeedCookie())) {
			crawRuleInfo.setIsNeedCookie("0");
		}

		if ("".equals(crawRuleInfo.getRequestActionFlag())) {
			crawRuleInfo.setRequestActionFlag("0");
		}

		if ("".equals(crawRuleInfo.getRequestPageNumbers())) {
			crawRuleInfo.setRequestPageNumbers("1");
		}

		if ("".equals(crawRuleInfo.getAnalysisWayFlag())) {
			crawRuleInfo.setAnalysisWayFlag("0");
		}

		if ("".equals(crawRuleInfo.getIsRelyLastResult())) {
			crawRuleInfo.setIsRelyLastResult("0");
		}

		if ("".equals(crawRuleInfo.getSleepTime())) {
			crawRuleInfo.setSleepTime("0");
		}

		if ("".equals(crawRuleInfo.getRetryNumber())) {
			crawRuleInfo.setRetryNumber("0");
		}

		if ("".equals(crawRuleInfo.getTimeOut())) {
			crawRuleInfo.setTimeOut("0");
		}

		if ("".equals(crawRuleInfo.getRuleExcuteTime())) {
			crawRuleInfo.setRuleExcuteTime("1999-01-01 00:00:00");
		}

		if ("".equals(crawRuleInfo.getNextIntervalTime())) {
			crawRuleInfo.setNextIntervalTime("0");
		}

		if ("".equals(crawRuleInfo.getIsUseProxyIP())) {
			crawRuleInfo.setIsUseProxyIP("0");
		}

		if ("".equals(crawRuleInfo.getExcuteStatu())) {
			crawRuleInfo.setExcuteStatu("0");
		}

		crawRuleInfo.setIsDelete("0");
		int temp = crawRuleService.addCrawRule(crawRuleInfo);
		if (temp > 0) {
			result = "添加爬虫规则成功!";
		} else {
			result = "添加爬虫规则失败!";
		}

		return result;
	}

	/**
	 * 添加爬虫规则
	 * 
	 * @param crawRuleInfo
	 * @return
	 */
	@RequestMapping(value = "/delCrawRule", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String delCrawRule(String keyid) {
		String result = "";
		int temp = crawRuleService.delCrawRule(keyid);
		if (temp > 0) {
			result = "删除爬虫规则成功";
		} else {
			result = "删除爬虫规则失败";
		}

		return result;
	}

	/**
	 * 更新爬虫规则
	 * 
	 * @param crawRuleInfo
	 * @return
	 */
	@RequestMapping(value = "/updateCrawRule", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String updateCrawRule(CrawRuleInfoVo crawRuleInfo) {
		String result = "";
		int temp = crawRuleService.updateCrawRule(crawRuleInfo);
		if (temp > 0) {
			result = "更新爬虫规则成功";
		} else {
			result = "更新爬虫规则失败";
		}
		return result;
	}
}
