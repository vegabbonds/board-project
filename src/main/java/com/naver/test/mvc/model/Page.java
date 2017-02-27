package com.naver.test.mvc.model;

public class Page {
	private int page = 1;
	private int count = 10;
	private int offset = 0;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void setOffset() {
		this.offset = (this.page - 1) * this.count;
	}
}
