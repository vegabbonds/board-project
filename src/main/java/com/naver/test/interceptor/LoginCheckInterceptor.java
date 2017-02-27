package com.naver.test.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.naver.test.annotation.AuthCheck;

public class LoginCheckInterceptor implements HandlerInterceptor {

	final static Logger logger = LoggerFactory.getLogger(LoginCheckInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		try {
			if (!(handler instanceof HandlerMethod)) {
				return true;
			}

			AuthCheck authCheck = ((HandlerMethod) handler).getMethodAnnotation(AuthCheck.class);

			if (authCheck == null) {
				return true;
			}

			Cookie[] cookies = request.getCookies();

			for (Cookie c : cookies) {
				if (c.getName().equals("noticeAdmin") && c.getValue().equals("admin")) {
					logger.info("admin check success : " + c.getValue());
					return true;
				}
			}

			logger.info("admin check fail");
			response.sendRedirect("/login/form");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

}
