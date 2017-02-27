package com.naver.test.orm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.naver.test.mvc.model.Page;
import com.naver.test.orm.entity.Notice;

@Repository
public interface NoticeMapper {
	List<Notice> getNoticeList();

	List<Notice> getNoticeListByPage(Page page);

	List<Notice> getNoticeListBySequence(int seq);

	void saveNotice(Notice notice);

	void modifyNotice(Notice notice);
}
