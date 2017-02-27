package com.naver.test.mvc.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.test.orm.entity.User;
import com.naver.test.orm.mapper.UserMapper;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	final static Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Autowired
	private UserMapper userMapper;

	@RequestMapping(value = "/form")
	public String getForm(@CookieValue(value = "noticeAdmin", required = false) String c) {
		if (c == null) {
			return "user/loginForm";
		} else {
			return "redirect:/notice/list";
		}
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String login(HttpServletResponse res, User loginUser) {

		List<User> allUser = userMapper.getUserList();
		User adminUser = userMapper.getUserListById("admin");

		if (adminUser.getId().equals(loginUser.getId()) && adminUser.getPasswd().equals(loginUser.getPasswd())) {
			Cookie cookie = new Cookie("noticeAdmin", adminUser.getId());
			cookie.setMaxAge(3600);
			cookie.setPath("/");
			res.addCookie(cookie);

		}

		for (User user : allUser) {
			if (user.getId().equals(loginUser.getId()) && user.getPasswd().equals(user.getPasswd())) {
				return "redirect:/login/success";
			}
		}

		return "redirect:/login/fail";
	}

	@RequestMapping(value = "/success")
	public String success() {
		return "redirect:/notice/list";
	}

	@RequestMapping(value = "/fail")
	public String fail() {
		return "user/loginForm";
	}

}
