function queryCrawRule() {
	// //查询,先不做分页,后面有时间再做
	var dataflag = $("#dataflag").val();
	var obj = document.getElementById("selectExecuteStatu");
	var executeStatuindex = obj.selectedIndex;
	var queryObj = {};
	queryObj.dataFlag = dataflag;
	queryObj.excuteStatu = executeStatuindex;
	$.ajax({
		url : "/CrawRuleSettingSystem/crawrule/queryCrawRule",
		type : "post",
		data : queryObj,
		async : false,
		cache : false,
		success : function(data) {
			data = $.parseJSON(data);
			var html = $("#crawruleJSTemplate").render(data);
			$("#dataListView").html(html);
			layer.msg('查询爬虫规则成功!', {
				time : 2000,
				icon : 6
			});
		},
		error : function(data) {
			layer.msg('查询爬虫规则失败!', {
				time : 2000,
				icon : 2
			});
		}
	});
}

/**
 * 退出
 * @param username
 */
function loginExit(username) {
	$.ajax({
		url : "/CrawRuleSettingSystem/login/logout",
		type : "post",
		data : {
			"userName" : username
		},
		async : false,
		cache : false,
		success : function(data) {
		},
		error : function(data) {
		}
	});
	window.location.href = "/CrawRuleSettingSystem/index.jsp";
}

function addCrawRule() {
	layer.open({
		type : 1,
		title : "添加爬虫规则",
		area : [ '450px', '80%' ],
		shadeClose : true,
		skin : 'layui-layer-lan',
		content : $("#formAddCrawRule"),
		btn : [ '保存', '取消' ],
		btn1 : function(index, layero) {
			var addObj = {};
			addObj.WebSiteName = $("#addWebSiteName").val();
			addObj.DataFlag = $("#addDataFlag").val();
			addObj.RuleSerial = $("#addRuleSerial").val();
			addObj.RequestUrl = $("#addRequestUrl").val();
			addObj.RequestProtocolFlag = $("#addRequestProtocolFlag").val();
			addObj.CompressFormatFlag = $("#addCompressFormatFlag").val();
			addObj.RequestHead = $("#addRequestHead").val();
			addObj.IsNeedCookie = $("#addIsNeedCookie").val();
			addObj.Cookie = $("#addCookie").val();
			addObj.RequestActionFlag = $("#addRequestActionFlag").val();
			addObj.ReferAddress = $("#addReferAddress").val();
			addObj.RequestPageNumbers = $("#addRequestPageNumbers").val();
			addObj.AnalysisWayFlag = $("#addAnalysisWayFlag").val();
			addObj.IsRelyLastResult = $("#addIsRelyLastResult").val();
			addObj.AnalysisExpress = $("#addAnalysisExpress").val();
			addObj.SleepTime = $("#addSleepTime").val();
			addObj.RetryNumber = $("#addRetryNumber").val();
			addObj.TimeOut = $("#addTimeOut").val();
			addObj.RuleExcuteTime = $("#addRuleExcuteTime").val();
			addObj.NextIntervalTime = $("#addNextIntervalTime").val();
			addObj.IsUseProxyIP = $("#addIsUseProxyIP").val();
			$.ajax({
				url : "/CrawRuleSettingSystem/crawrule/addCrawRule",
				type : "post",
				data : addObj,
				async : false,
				cache : false,
				success : function(data) {
					layer.msg(data, {
						time : 2000,
						icon : 6
					});
				},
				error : function(data) {
					layer.msg('添加爬虫规则失败!', {
						time : 2000,
						icon : 2
					});
				}
			});
		},
		btn2 : function(index, layero) {
			layer.close(index);
		}
	});
}

/**
 * 删除爬虫规则
 * 
 * @param keyid
 */
function delCrawRule(keyid) {
	$.ajax({
		url : "/CrawRuleSettingSystem/crawrule/delCrawRule",
		type : "post",
		data : {
			"keyid" : keyid
		},
		async : false,
		cache : false,
		success : function(data) {
			layer.msg(data, {
				time : 2000,
				icon : 6
			});
		},
		error : function(data) {
			layer.msg('添加爬虫规则失败!', {
				time : 2000,
				icon : 2
			});
		}
	});
}

/**
 * 修改爬虫规则
 * @param keyid
 */
function modifyCrawRule(keyid) {
	var queryObj = {};
	queryObj.KeyID = keyid;
	$.ajax({
		url : "/CrawRuleSettingSystem/crawrule/queryCrawRule",
		type : "post",
		data : queryObj,
		async : false,
		cache : false,
		success : function(data) {
			data= $.parseJSON(data);
		////绑定json数据到修改界面
			$("#modifyWebSiteName").val(data[0].WebSiteName);
			$("#modifyDataFlag").val(data[0].DataFlag);
			$("#modifyRuleSerial").val(data[0].RuleSerial);
			$("#modifyRequestUrl").val(data[0].RequestUrl);
			$("#modifyRequestProtocolFlag").val(data[0].RequestProtocolFlag);
			$("#modifyCompressFormatFlag").val(data[0].CompressFormatFlag);
			$("#modifyRequestHead").val(data[0].RequestHead);
			$("#modifyIsNeedCookie").val(data[0].IsNeedCookie);
			$("#modifyCookie").val(data[0].Cookie);
			$("#modifyRequestActionFlag").val(data[0].RequestActionFlag);
			$("#modifyReferAddress").val(data[0].ReferAddress);
			$("#modifyRequestPageNumbers").val(data[0].RequestPageNumbers);
			$("#modifyAnalysisWayFlag").val(data[0].AnalysisWayFlag);
			$("#modifyIsRelyLastResult").val(data[0].IsRelyLastResult);
			$("#modifyAnalysisExpress").val(data[0].AnalysisExpress);
			$("#modifySleepTime").val(data[0].SleepTime);
			$("#modifyRetryNumber").val(data[0].RetryNumber);
			$("#modifyTimeOut").val(data[0].TimeOut);
			$("#modifyRuleExcuteTime").val(data[0].RuleExcuteTime);
			$("#modifyNextIntervalTime").val(data[0].NextIntervalTime);
			$("#modifyIsUseProxyIP").val(data[0].IsUseProxyIP);
		},
		error : function(data) {
			layer.msg('修改爬虫规则失败!', {
				time : 2000,
				icon : 2
			});
		}
	});
	
	layer.open({
		type : 1,
		title : "修改爬虫规则",
		area : [ '450px', '80%' ],
		shadeClose : true,
		skin : 'layui-layer-lan',
		content : $("#modiflyCrawRuleDiv"),
		btn : [ '保存', '取消' ],
		btn1 : function(index, layero) {
			var updateObj = {};
			updateObj.KeyID=keyid;
			////点击保存后，获取标签的值存入数据库
			updateObj.WebSiteName=$("#modifyWebSiteName").val();
			updateObj.DataFlag=$("#modifyDataFlag").val();
			updateObj.RuleSerial=$("#modifyRuleSerial").val();
			updateObj.RequestUrl=$("#modifyRequestUrl").val();
			updateObj.RequestProtocolFlag=$("#modifyRequestProtocolFlag").val();
			updateObj.CompressFormatFlag=$("#modifyCompressFormatFlag").val();
			updateObj.RequestHead=$("#modifyRequestHead").val();
			updateObj.IsNeedCookie=$("#modifyIsNeedCookie").val();
			updateObj.Cookie=$("#modifyCookie").val();
			updateObj.RequestActionFlag=$("#modifyRequestActionFlag").val();
			updateObj.ReferAddress=$("#modifyReferAddress").val();
			updateObj.RequestPageNumbers=$("#modifyRequestPageNumbers").val();
			updateObj.AnalysisWayFlag=$("#modifyAnalysisWayFlag").val();
			updateObj.IsRelyLastResult=$("#modifyIsRelyLastResult").val();
			updateObj.AnalysisExpress=$("#modifyAnalysisExpress").val();
			updateObj.SleepTime=$("#modifySleepTime").val();
			updateObj.RetryNumber=$("#modifyRetryNumber").val();
			updateObj.TimeOut=$("#modifyTimeOut").val();
			updateObj.RuleExcuteTime=$("#modifyRuleExcuteTime").val();
			updateObj.NextIntervalTime=$("#modifyNextIntervalTime").val();
			updateObj.IsUseProxyIP=$("#modifyIsUseProxyIP").val();
			$.ajax({
				url : "/CrawRuleSettingSystem/crawrule/updateCrawRule",
				type : "post",
				data : updateObj,
				async : false,
				cache : false,
				success : function(data) {
					layer.msg(data, {
						time : 1000,
						icon : 6
					});
				},
				error : function(data) {
					layer.msg('更新爬虫规则失败!', {
						time : 1000,
						icon : 2
					});
				}
			});
		},
		btn2 : function(index, layero) {
			layer.close(index);
		}
	});
}
