package com.peace1nmind.d0708.dao;


import com.peace1nmind.d0708.dto.MembersDto;

public interface MembersDao {
	
	// 회원가입
	public void join(String id, String pw, String name, String nickname, String phone, String email);
	
	// 아이디 중복확인
	public int idCheck(String id);
	
	// 닉네임 중복확인
	public int nicknameCheck(String nickname);
	
	// 로그인 체크
	public int login(String id, String pw);
	
	// 회원정보
	public MembersDto getInfo(String id);
	
	// 회원정보 수정
	public void modify(String id, String pw, String name, String nickname, String phone, String email);

}
