package com.sl.CrawRuleSettingSystem.model;

/**
 * 抓取规则实体文件
 * 
 * @author Administrator
 *
 */
public class CrawRuleInfoVo {
	/**
	 * 主键
	 */
	private String KeyID = "";

	/**
	 * 网站名称
	 */
	private String WebSiteName = "";

	/**
	 * 数据标志
	 */
	private String DataFlag = "";

	/**
	 * 规则序号
	 */
	private String RuleSerial = "0";

	/**
	 * 请求的url
	 */
	private String RequestUrl = "";

	/**
	 * 请求协议标志(0:http请求 / 1:https请求)
	 */
	private String RequestProtocolFlag = "0";

	/**
	 * 压缩格式标志(0:代表未压缩 / 1:Gzip压缩)
	 */
	private String CompressFormatFlag = "0";

	/**
	 * 请求头(多个头之间用|隔开)
	 */
	private String RequestHead = "";

	/**
	 * 是否需要cookie(0:不需要 / 1:需要)
	 */
	private String IsNeedCookie = "0";

	/**
	 * Cookie(有的请求可能cookie就一直不变，这里设置一个参数)
	 */
	private String Cookie = "";

	/**
	 * 请求动作标志(0：get请求 / 1：post请求)
	 */
	private String RequestActionFlag = "0";

	/**
	 * Refer地址
	 */
	private String ReferAddress = "";

	/**
	 * 请求页数
	 */
	private String RequestPageNumbers = "1";

	/**
	 * 解析方式标识(0：正则 / 1：xpath)
	 */
	private String AnalysisWayFlag = "0";

	/**
	 * 是否依赖上一结果(0:不依赖 / 1:依赖)
	 */
	private String IsRelyLastResult = "0";

	/**
	 * 解析表达式(多个表达式用|隔开)
	 */
	private String AnalysisExpress = "";

	/**
	 * 休眠时间(单位毫秒)
	 */
	private String SleepTime = "500";

	/**
	 * 重试次数
	 */
	private String RetryNumber = "1";

	/**
	 * 超时时间(单位毫秒)
	 */
	private String TimeOut = "6000";

	/**
	 * 规则执行时间
	 */
	private String RuleExcuteTime = "";

	/**
	 * 下一次执行间隔时间(单位分钟，每次执行完成后，就更新这个)
	 */
	private String NextIntervalTime = "";

	/**
	 * 是否使用代理IP(0：代表不使用 / 1:代表使用)
	 */
	private String IsUseProxyIP = "0";

	/**
	 * 执行状态(0:代表未执行 / 1:执行中 / 2:执行完成)
	 */
	private String ExcuteStatu = "0";

	/**
	 * 是否删除(0:未删除 / 1:删除)
	 */
	private String IsDelete = "0";

	/**
	 * 修改时间戳(CURRENT_TIMESTAMP)
	 */
	private String ModifyTime = "";

	public String getKeyID() {
		return KeyID;
	}

	public void setKeyID(String keyID) {
		KeyID = keyID;
	}

	public String getWebSiteName() {
		return WebSiteName;
	}

	public void setWebSiteName(String webSiteName) {
		WebSiteName = webSiteName;
	}

	public String getDataFlag() {
		return DataFlag;
	}

	public void setDataFlag(String dataFlag) {
		DataFlag = dataFlag;
	}

	public String getRuleSerial() {
		return RuleSerial;
	}

	public void setRuleSerial(String ruleSerial) {
		RuleSerial = ruleSerial;
	}

	public String getRequestUrl() {
		return RequestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		RequestUrl = requestUrl;
	}

	public String getRequestProtocolFlag() {
		return RequestProtocolFlag;
	}

	public void setRequestProtocolFlag(String requestProtocolFlag) {
		RequestProtocolFlag = requestProtocolFlag;
	}

	public String getCompressFormatFlag() {
		return CompressFormatFlag;
	}

	public void setCompressFormatFlag(String compressFormatFlag) {
		CompressFormatFlag = compressFormatFlag;
	}

	public String getRequestHead() {
		return RequestHead;
	}

	public void setRequestHead(String requestHead) {
		RequestHead = requestHead;
	}

	public String getIsNeedCookie() {
		return IsNeedCookie;
	}

	public void setIsNeedCookie(String isNeedCookie) {
		IsNeedCookie = isNeedCookie;
	}

	public String getCookie() {
		return Cookie;
	}

	public void setCookie(String cookie) {
		Cookie = cookie;
	}

	public String getRequestActionFlag() {
		return RequestActionFlag;
	}

	public void setRequestActionFlag(String requestActionFlag) {
		RequestActionFlag = requestActionFlag;
	}

	public String getReferAddress() {
		return ReferAddress;
	}

	public void setReferAddress(String referAddress) {
		ReferAddress = referAddress;
	}

	public String getRequestPageNumbers() {
		return RequestPageNumbers;
	}

	public void setRequestPageNumbers(String requestPageNumbers) {
		RequestPageNumbers = requestPageNumbers;
	}

	public String getAnalysisWayFlag() {
		return AnalysisWayFlag;
	}

	public void setAnalysisWayFlag(String analysisWayFlag) {
		AnalysisWayFlag = analysisWayFlag;
	}

	public String getIsRelyLastResult() {
		return IsRelyLastResult;
	}

	public void setIsRelyLastResult(String isRelyLastResult) {
		IsRelyLastResult = isRelyLastResult;
	}

	public String getAnalysisExpress() {
		return AnalysisExpress;
	}

	public void setAnalysisExpress(String analysisExpress) {
		AnalysisExpress = analysisExpress;
	}

	public String getSleepTime() {
		return SleepTime;
	}

	public void setSleepTime(String sleepTime) {
		SleepTime = sleepTime;
	}

	public String getRetryNumber() {
		return RetryNumber;
	}

	public void setRetryNumber(String retryNumber) {
		RetryNumber = retryNumber;
	}

	public String getTimeOut() {
		return TimeOut;
	}

	public void setTimeOut(String timeOut) {
		TimeOut = timeOut;
	}

	public String getRuleExcuteTime() {
		return RuleExcuteTime;
	}

	public void setRuleExcuteTime(String ruleExcuteTime) {
		RuleExcuteTime = ruleExcuteTime;
	}

	public String getNextIntervalTime() {
		return NextIntervalTime;
	}

	public void setNextIntervalTime(String nextIntervalTime) {
		NextIntervalTime = nextIntervalTime;
	}

	public String getIsUseProxyIP() {
		return IsUseProxyIP;
	}

	public void setIsUseProxyIP(String isUseProxyIP) {
		IsUseProxyIP = isUseProxyIP;
	}

	public String getExcuteStatu() {
		return ExcuteStatu;
	}

	public void setExcuteStatu(String excuteStatu) {
		ExcuteStatu = excuteStatu;
	}

	public String getIsDelete() {
		return IsDelete;
	}

	public void setIsDelete(String isDelete) {
		IsDelete = isDelete;
	}

	public String getModifyTime() {
		return ModifyTime;
	}

	public void setModifyTime(String modifyTime) {
		ModifyTime = modifyTime;
	}
}
