<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String name =(String) session.getAttribute("loginName");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Language" content="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>规则设置系统</title>
<link href="<%=basePath%>css/bootstrap/bootstrap.min.css"
	rel="stylesheet">
<script src="<%=basePath%>js/bootstrap/jquery-3.3.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap/bootstrap.min.js"></script>
<script src="<%=basePath%>js/rulesetting/crawrule.js"></script>
<script src="<%=basePath%>js/layer/layer.js"></script>
<script src="<%=basePath%>js/jsrender/jsrender.js"></script>

</head>

<body>
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<!-- 	<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#example-navbar-collapse">
					<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button> -->
				<a class="navbar-brand" href="#"> <img
					src="<%=basePath%>image/rule/logo.jpg" height="100%" />
				</a>
			</div>
			<div class="collapse navbar-collapse" id="example-navbar-collapse">
				<!--菜单导航暂时不要  -->
				<ul class="nav navbar-nav">
					<!--    <li class="active"><a class="icon-bar" href="#">网站设置</a>
                        </li> -->

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a>欢迎您,<%=name%></a></li>
					<li><a href="#" id="securityExit"
						onclick="loginExit('<%=name%>')">安全退出</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2">
				<a href="#" class="list-group-item active">规则管理</a>
				<!-- 发出查询请求，默认为20条 -->
				<a href="#" class="list-group-item" id="crawRuleQuery"
					onclick="queryCrawRule()"> 爬虫规则管理</a>
			</div>
			<div class="col-sm-10">
				<ol class="breadcrumb">
					<li class="active">规则管理</li>
					<li class="active">爬虫规则管理</li>
				</ol>

				<div class="panel panel-default">
					<!-- 					<div class="panel-heading">搜索</div> -->
					<div class="panel-body">
						<form role="form" class="form-inline">
							<div class="form-group">
								<label for="name">数据标志</label> <input type="text"
									class="form-control" id="dataflag" placeholder="请输入标志">
							</div>
							<div class="form-group">
								<label for="name">执行状态</label> <select class="form-control"
									id="selectExecuteStatu">
									<option>全部</option>
									<option>未执行</option>
									<option>执行中</option>
									<option>执行完成</option>
								</select>
							</div>
							<div class="form-group">
								<a class="btn btn-default" onclick="queryCrawRule()">查询</a> <a
									class="btn btn-default" id="addCrawRule"
									onclick="addCrawRule()">添加爬虫规则</a>
							</div>
						</form>
					</div>
				</div>
				<!--
                        列表展示
                    -->
				<div class="table-responsive" id="dataShowTable">
					<table class="table table-striped"  style="table-layout:fixed;word-break:break-all;word-wrap:break-word">
						<thead>
							<tr>
								<th>网站名称</th>
								<th>数据标志</th>
								<th>规则序号</th>
								<th>URL</th>
								<th>需要cookie</th>
								<th>请求页数</th>
								<th>解析方式</th>
								<th>重试次数</th>
								<th>超时时间</th>
								<th>规则执行时间</th>
								<th>间隔时间</th>
								<th>使用代理IP</th>
								<th>执行状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="dataListView">
							<!-- <tr>
								<td>15</td>
								<td>
									<div class="btn-group">
										<a href="" class="btn btn-default" id="updateCrawRule">修改</a>
										<a href="" class="btn btn-danger" id="delCrawRule">删除</a>
									</div>
								</td>
							</tr> -->

						</tbody>
					</table>
				</div>
				<!-- 	<ul class="pagination" style="float: right;">
					<li><a href="#">&laquo;</a></li>
					<li class="active"><a href="#">1</a></li>
					<li class="disabled"><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">&raquo;</a></li>
				</ul> -->
			</div>
		</div>
	</div>

	<!-- 添加爬虫规则 -->
	<div class="row"
		style="width: 420px; margin-left: 7px; margin-top: 10px; display: none"
		id="formAddCrawRule">
		<div class="col-sm-12">
			<div class="input-group">
				<span class="input-group-addon"> 网站名称 :</span> <input
					id="addWebSiteName" type="text" class="form-control"
					placeholder="请输入网站名称">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">数据标志:</span> <input id="addDataFlag"
					type="text" class="form-control" placeholder="请输入数据标志">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">规则序号:</span> <input
					id="addRuleSerial" type="text" class="form-control"
					placeholder="请输入规则序号">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">URL地址:</span> <input
					id="addRequestUrl" type="text" class="form-control"
					placeholder="请输入URL">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">请求协议:</span> <input
					id="addRequestProtocolFlag" type="text" class="form-control"
					placeholder="0:http请求 / 1:https请求">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">压缩格式:</span> <input
					id="addCompressFormatFlag" type="text" class="form-control"
					placeholder="0:代表未压缩 / 1:Gzip压缩">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">请求头:</span> <input
					id="addRequestHead" type="text" class="form-control"
					placeholder="选填">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">是否需要Cookie:</span> <input
					id="addIsNeedCookie" type="text" class="form-control"
					placeholder="0:不需要 / 1:需要">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">Cookie:</span> <input id="addCookie"
					type="text" class="form-control" placeholder="选填">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">请求动作:</span> <input
					id="addRequestActionFlag" type="text" class="form-control"
					placeholder="0：get请求 / 1：post请求">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">Refer地址:</span> <input
					id="addReferAddress" type="text" class="form-control"
					placeholder="选填">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">请求页数:</span> <input
					id="addRequestPageNumbers" type="text" class="form-control"
					placeholder="默认为1">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">解析方式:</span> <input
					id="addAnalysisWayFlag" type="text" class="form-control"
					placeholder="(0：正则 / 1：xpath)">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">是否依赖上一结果:</span> <input
					id="addIsRelyLastResult" type="text" class="form-control"
					placeholder="(0:不依赖 / 1:依赖)">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">解析表达式:</span> <input
					id="addAnalysisExpress" type="text" class="form-control"
					placeholder="正则表达式/Xpath">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">休眠时间:</span> <input
					id="addSleepTime" type="text" class="form-control"
					placeholder="单位毫秒">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">重试次数:</span> <input
					id="addRetryNumber" type="text" class="form-control"
					placeholder="默认1次">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">超时时间:</span> <input id="addTimeOut"
					type="text" class="form-control" placeholder="单位毫秒">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">规则执行时间:</span> <input
					id="addRuleExcuteTime" type="text" class="form-control"
					placeholder="按照yyyy-MM-dd HH:mm:ss格式填写">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">执行间隔时间:</span> <input
					id="addNextIntervalTime" type="text" class="form-control"
					placeholder="每一轮任务间隔时间">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">是否使用代理IP:</span> <input
					id="addIsUseProxyIP" type="text" class="form-control"
					placeholder="0：代表不使用 / 1:代表使用">
			</div>
		</div>
	</div>

	<!-- 修改爬虫规则 -->
	<div class="row"
		style="width: 420px; margin-left: 7px; margin-top: 10px; display: none"
		id="modiflyCrawRuleDiv">
		<div class="col-sm-12">
			<div class="input-group">
				<span class="input-group-addon"> 网站名称 :</span> <input
					id="modifyWebSiteName" type="text" class="form-control"
					placeholder="请输入网站名称">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">数据标志:</span> <input
					id="modifyDataFlag" type="text" class="form-control"
					placeholder="请输入数据标志">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">规则序号:</span> <input
					id="modifyRuleSerial" type="text" class="form-control"
					placeholder="请输入规则序号">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">URL地址:</span> <input
					id="modifyRequestUrl" type="text" class="form-control"
					placeholder="请输入URL">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">请求协议:</span> <input
					id="modifyRequestProtocolFlag" type="text" class="form-control"
					placeholder="0:http请求 / 1:https请求">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">压缩格式:</span> <input
					id="modifyCompressFormatFlag" type="text" class="form-control"
					placeholder="0:代表未压缩 / 1:Gzip压缩">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">请求头:</span> <input
					id="modifyRequestHead" type="text" class="form-control"
					placeholder="选填">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">是否需要Cookie:</span> <input
					id="modifyIsNeedCookie" type="text" class="form-control"
					placeholder="0:不需要 / 1:需要">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">Cookie:</span> <input
					id="modifyCookie" type="text" class="form-control" placeholder="选填">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">请求动作:</span> <input
					id="modifyRequestActionFlag" type="text" class="form-control"
					placeholder="0：get请求 / 1：post请求">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">Refer地址:</span> <input
					id="modifyReferAddress" type="text" class="form-control"
					placeholder="选填">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">请求页数:</span> <input
					id="modifyRequestPageNumbers" type="text" class="form-control"
					placeholder="默认为1">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">解析方式:</span> <input
					id="modifyAnalysisWayFlag" type="text" class="form-control"
					placeholder="(0：正则 / 1：xpath)">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">是否依赖上一结果:</span> <input
					id="modifyIsRelyLastResult" type="text" class="form-control"
					placeholder="(0:不依赖 / 1:依赖)">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">解析表达式:</span> <input
					id="modifyAnalysisExpress" type="text" class="form-control"
					placeholder="正则表达式/Xpath">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">休眠时间:</span> <input
					id="modifySleepTime" type="text" class="form-control"
					placeholder="单位毫秒">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">重试次数:</span> <input
					id="modifyRetryNumber" type="text" class="form-control"
					placeholder="默认1次">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">超时时间:</span> <input
					id="modifyTimeOut" type="text" class="form-control"
					placeholder="单位毫秒">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">规则执行时间:</span> <input
					id="modifyRuleExcuteTime" type="text" class="form-control"
					placeholder="按照yyyy-MM-dd HH:mm:ss格式填写">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">执行间隔时间:</span> <input
					id="modifyNextIntervalTime" type="text" class="form-control"
					placeholder="每一轮任务间隔时间">
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 10px">
			<div class="input-group">
				<span class="input-group-addon">是否使用代理IP:</span> <input
					id="modifyIsUseProxyIP" type="text" class="form-control"
					placeholder="0：代表不使用 / 1:代表使用">
			</div>
		</div>
	</div>

	<!-- 定义JsRender模版 -->
	<script id="crawruleJSTemplate" type="text/x-jsrender">
{{for}}
      <tr>
        <td>{{:WebSiteName}}</td>
        <td>{{:DataFlag}}</td>
<td>{{:RuleSerial}}</td>
<td>{{:RequestUrl}}</td>
<td>{{:IsNeedCookie}}</td>
<td>{{:RequestPageNumbers}}</td>
<td>{{:AnalysisWayFlag}}</td>
<td>{{:RetryNumber}}</td>
<td>{{:TimeOut}}</td>
<td>{{:RuleExcuteTime}}</td>
<td>{{:NextIntervalTime}}</td>
<td>{{:IsUseProxyIP}}</td>
<td>{{:ExcuteStatu}}</td>
<td><div class="btn-group">
										<a href="javascript:;" class="btn btn-default" id="updateCrawRule"  value="{{:KeyID}}"  onclick="modifyCrawRule('{{:KeyID}}')">修改</a>
										<a href="javascript:;" class="btn btn-danger" id="delCrawRule" value="{{:KeyID}}" onclick="delCrawRule('{{:KeyID}}')">删除</a>
									</div></td>
      </tr>
{{/for}}
    </script>
</body>
</html>