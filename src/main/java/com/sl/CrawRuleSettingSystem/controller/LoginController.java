package com.sl.CrawRuleSettingSystem.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONObject;
import com.sl.CrawRuleSettingSystem.model.UserInfoVo;
import com.sl.CrawRuleSettingSystem.service.CrawRuleService;
import com.sl.CrawRuleSettingSystem.service.LoginService;
import com.sl.CrawRuleSettingSystem.util.RequestUtils;
import com.sl.CrawRuleSettingSystem.util.ResponseUtils;

@Controller
@RequestMapping("/login")
public class LoginController {
	/**
	 * 获取登录服务层对象
	 */
	@Resource(name = "loginService")
	private LoginService loginService;

	/**
	 * 登陆表单校验
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/validateLogin")
	public void login(HttpSession session,HttpServletRequest request, HttpServletResponse response) {
		// 获取form表单数据
		String loginObj = RequestUtils.getString(request, "loginObj");
		JSONObject result = new JSONObject();
		// JSON字符串序列化成JSON对象
		JSONObject loginJosn = JSONObject.parseObject(loginObj);
		String accountNo = loginJosn.getString("accountNo").trim();
		String pwd = loginJosn.getString("pwd").trim();
		UserInfoVo userinfo = loginService.getUserInfo(accountNo);

		if (userinfo == null) {
			result.put("accountMsg", "账号不存在");
		} else {
			//// 账号密码
			String username = userinfo.getUserName();
			String password = userinfo.getPassWord();
			if (!accountNo.equals(username) && !pwd.equals(password)) {
				result.put("pwdMsg", "用户密码错误");
			} else {
				result.put("user", "登录成功");
			}
		}

		String resultStr = result.toJSONString();
		ResponseUtils.send(response, resultStr);
	}

	/**
	 * 登陆跳转
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/successLogin")
	public String login(HttpSession session, HttpServletRequest request, HttpServletResponse response,RedirectAttributes attributes) throws IOException {
		String accountNo = RequestUtils.getString(request, "accountNo");
		session.setAttribute("loginName", accountNo);
//		response.sendRedirect("/CrawRuleSettingSystem/jsp/rulesetting.jsp");
//		model.addObject("user", accountNo);
//		model.setViewName("redirect:/jsp/rulesetting.jsp");
//		return model;
//		attributes.addFlashAttribute("user", accountNo);
		return "redirect:/jsp/rulesetting.jsp";
	}

	/**
	 * 登录退出
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public void logout(HttpSession session,String userName) throws Exception {
		// 清除session
		session.removeAttribute("loginName");
	}
}
