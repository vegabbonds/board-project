package com.naver.test.mvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.test.annotation.AuthCheck;
import com.naver.test.mvc.model.Page;
import com.naver.test.orm.entity.Notice;
import com.naver.test.orm.mapper.NoticeMapper;

@Controller
@RequestMapping(value = "/notice")
public class NoticeController {

	final static Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Autowired
	private NoticeMapper noticeMapper;

	@RequestMapping(value = "/list")
	public String getUserList(Model model, Page page) {
		page.setOffset();
		List<Notice> noticeList = noticeMapper.getNoticeListByPage(page);

		model.addAttribute("noticeList", noticeList);
		return "notice/list";
	}

	@RequestMapping(value = "/form")
	public String getForm() {
		return "notice/addForm";
	}

	@RequestMapping(value = "/{sequence}")
	public String detailView(Model model, int sequence) {
		List<Notice> detailNotice = noticeMapper.getNoticeListBySequence(sequence);
		model.addAttribute("detailNotice", detailNotice);
		return "notice/detail";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@AuthCheck
	public String addNotice(Notice notice) {
		notice.setUserId("admin");
		if (notice.getSeq() == null) {
			noticeMapper.saveNotice(notice);
		} else {
			noticeMapper.modifyNotice(notice);
		}
		return "redirect:/notice/list";
	}

}
