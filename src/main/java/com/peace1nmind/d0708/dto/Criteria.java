/* 페이지당 글에 관한 DTO */

package com.peace1nmind.d0708.dto;

public class Criteria {
	
	private int amount = 10;		// 한 페이지 당 출력될 글의 개수
	private int pageNum = 1;		// 클라이언트가 클릭한 페이지 번호가 저장될 변수 (초기값은 1)
	private int startNum;			// 클라이언트가 선택한 페이지에서 시작할 글의 번호 (row number)
	
	public Criteria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Criteria(int amount, int pageNum, int startNum) {
		super();
		this.amount = amount;
		this.pageNum = pageNum;
		this.startNum = startNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	
}
