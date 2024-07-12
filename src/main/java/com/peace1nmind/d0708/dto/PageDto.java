/* 화면 하단 페이지 번호에 관련된 DTO */

package com.peace1nmind.d0708.dto;

public class PageDto {
	
	private double perPage = 10.0;		// 페이지 분할 개수
	private int startPage;		// 화면에 보여질 하단 페이지 번호 중 시작 페이지 번호
	private int endPage;		// 화면에 보여질 하단 페이지 번호 중 마지막 페이지 번호
	private boolean next;		// 현재 보여지고 있는 페이지 이상으로 페이지가 더 있는지 여부
	private boolean prev;		// 현재 보여지고 있는 페이지 이하로 페이지가 더 있는지 여부
	private int total;			// 총 글의 개수
	
	private Criteria criteria;	// Criteria 내의 변수 값들을 불러오기 위한 객체 선언

	
	public PageDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PageDto(double perPage, int startPage, int endPage, boolean next, boolean prev, int total,
			Criteria criteria) {
		super();
		this.perPage = perPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.next = next;
		this.prev = prev;
		this.total = total;
		this.criteria = criteria;
	}

	public PageDto(int startPage, int endPage, boolean next, boolean prev, int total, Criteria criteria) {
		super();
		this.startPage = startPage;
		this.endPage = endPage;
		this.next = next;
		this.prev = prev;
		this.total = total;
		this.criteria = criteria;
	}
	
	/* 중요★ 페이지 개수 계산  */
	// 시작페이지와 끝의 페이지를 계산
	public PageDto(int total, Criteria criteria) {
		super();
		this.total = total;
		this.criteria = criteria;
		
		// Math.ceil 함수를 통해서 올림
		this.endPage = (int) (Math.ceil(criteria.getPageNum() / this.perPage) * 10);
		this.startPage = this.endPage - 9;
		
		// 총 글 수로 계산한 마지막 페이지 (ex - 총 글의 개수 128개면 13이 나게끔)
		int lastPage = (int) Math.ceil(this.total*1.0 / criteria.getAmount()) ;
		
		// endPage가 lastPage보다 크면 빈 페이지가 생기므로 lastPage로 만들어줌
		if (endPage > lastPage) {
			this.endPage = lastPage;
		}
		
		this.prev = this.startPage > 1;
		this.next = endPage >= lastPage;
		
	}

	public double getPerPage() {
		return perPage;
	}

	public void setPerPage(double perPage) {
		this.perPage = perPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

}
