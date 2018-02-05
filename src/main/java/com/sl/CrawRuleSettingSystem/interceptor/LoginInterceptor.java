package com.sl.CrawRuleSettingSystem.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录认证拦截实现
 * 
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	/**
	 * 请求完成
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * post请求
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	/**
	 * 用于身份认证、身份授权 比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// 获取请求的url
		String url = request.getRequestURI();
		System.out.println("进入拦截：" + url);
		// 判断url是否是公开 地址（实际使用时将公开 地址配置配置文件中）
		// 这里公开地址是登陆提交的地址
		if (url.indexOf("validateLogin") >= 0) {
			// 如果进行登陆提交，放行
			return true;
		}

		// 判断session
		HttpSession session = request.getSession();
		// 从session中取出用户身份信息
		String username = (String) session.getAttribute("loginName");
		System.out.println(username);
		if (username != null) {
			// 身份存在，放行
			return true;
		}

		// 执行这里表示用户身份需要认证，跳转登陆页面
		request.getRequestDispatcher("index.jsp").forward(request, response);
		// response.sendRedirect(redicturl);
		// return false表示拦截，不向下执行
		// return true表示放行
		return false;
	}
}
