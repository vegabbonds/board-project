package com.naver.test.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.naver.test.mvc.model.Page;
import com.naver.test.orm.entity.Notice;
import com.naver.test.orm.mapper.NoticeMapper;

@RestController
@RequestMapping(value = "notice/json")
public class NoticeJsonController {
	
	@Autowired
	private NoticeMapper noticeMapper;

	@RequestMapping(value = "/list")
	public List<Notice> getUserList(Model model, Page page) {
		page.setOffset();
		return noticeMapper.getNoticeListByPage(page);
	}

	@RequestMapping(value = "/list/{sequence}", method = RequestMethod.GET)
	public List<Notice> getCustomerById(@PathVariable int sequence) {
		return noticeMapper.getNoticeListBySequence(sequence);
	}
}
