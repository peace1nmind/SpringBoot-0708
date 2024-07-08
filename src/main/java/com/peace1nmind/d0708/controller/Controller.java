package com.peace1nmind.d0708.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.peace1nmind.d0708.dao.BoardDao;
import com.peace1nmind.d0708.dao.MembersDao;
import com.peace1nmind.d0708.dto.EmailDto;
import com.peace1nmind.d0708.dto.MembersDto;
import com.peace1nmind.d0708.dto.PhoneDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	SqlSession sqlSession;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/loginOk")
	public String loginOk(HttpServletRequest request, Model model, HttpSession session) {
		
		MembersDao mdao = sqlSession.getMapper(MembersDao.class);
		MembersDto mdto = null;
		
		int loginCheckFlag = mdao.login(request.getParameter("id"), request.getParameter("pw"));
		
		if (loginCheckFlag != 1) {
			// 로그인 실패
			model.addAttribute("loginCheckFlag", loginCheckFlag);
		} else {
			// 로그인 성공
			model.addAttribute("loginCheckFlag", loginCheckFlag);
			session.setAttribute("sessionId", request.getParameter("id"));
			mdto = mdao.getInfo(request.getParameter("id"));
			session.setAttribute("sessionNickname", mdto.getNickname());
			model.addAttribute("mdto", mdto);
		}
		
		return "loginOk";
	
	}
	
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	
	@PostMapping("/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String phone = (request.getParameter("phone1") + 
						request.getParameter("phone2") + 
						request.getParameter("phone3"));
		String email = (request.getParameter("emailUser") +
						request.getParameter("emailDomain"));
		
		MembersDao mdao = sqlSession.getMapper(MembersDao.class);
		
		int idCheckFlag = mdao.idCheck(id);
		int nicknameCheckFlag = mdao.nicknameCheck(nickname);
		
		if (idCheckFlag == 0 && nicknameCheckFlag == 0) {
			
			// 가입 성공
			mdao.join(id, pw, name, nickname, phone, email);
			
			model.addAttribute("id", id);
			model.addAttribute("name", name);
			model.addAttribute("nickname", nickname);
			model.addAttribute("idCheckFlag", idCheckFlag);
			model.addAttribute("nicknameCheckFlag", nicknameCheckFlag);
			
		} else {
			
			model.addAttribute("idCheckFlag", idCheckFlag);
			model.addAttribute("nicknameCheckFlag", nicknameCheckFlag);
			
		}
		
		return "joinOk";
		
	}
	
	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/write")
	public String write(HttpSession session, Model model) {
		
		String sessionId = (String) session.getAttribute("sessionId");
		
		MembersDao mdao = sqlSession.getMapper(MembersDao.class);
		MembersDto mdto = mdao.getInfo(sessionId);
		
		model.addAttribute("mdto", mdto);
		
		return "write";
	}
	
	@PostMapping("/writeOk")
	public String writeOk(HttpServletRequest request) {
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		bdao.write(request.getParameter("nickname"),
					request.getParameter("writer"),
					request.getParameter("title"),
					request.getParameter("content"));
		
		return "board";
	}
	
	@GetMapping("/board")
	public String board() {
		return "board";
	}
	
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session, HttpServletResponse response) {
		
		// 컨트롤러에서 경고창 띄우기
		try {
			// 경고창 텍스트를 인코딩
			response.setContentType("text/html;charset=utf-8");
			// 다시 인코딩 해줘야함
			response.setCharacterEncoding("utf-8");
			PrintWriter printWriter = response.getWriter();
			printWriter.println("<script>alert('"+"로그아웃 하시겠습니까?"+"');location.href='"+"login"+"';</script>");
			printWriter.flush();
			
			// 로그아웃
			session.invalidate();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "login";
	}
	
	@GetMapping("/modify")
	public String modify(HttpSession session, Model model) {
		
		String sessionId = (String) session.getAttribute("sessionId");
		
		MembersDao mdao = sqlSession.getMapper(MembersDao.class);
		MembersDto mdto = mdao.getInfo(sessionId);
		
		model.addAttribute("mdto", mdto);
		
		String phone_all = mdto.getPhone();
		String phone1 = phone_all.substring(0, 4);
		String phone2 = phone_all.substring(4, 8);
		String phone3 = phone_all.substring(8);
		
		PhoneDto phone = new PhoneDto(phone1, phone2, phone3);
		
		String email_all = mdto.getEmail();
		String[] email_part = email_all.split("@");
		String emailUser = email_part[0];
		String emailDomain = "@" + email_part[1];
		
		EmailDto email = new EmailDto(emailUser, emailDomain);
		
		model.addAttribute("phone", phone);
		model.addAttribute("email", email);
		
		return "modify";
	}
	
	@PostMapping("/modifyOk")
	public String modifyOk(HttpServletRequest request, HttpSession session) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String phone = (request.getParameter("phone1") + 
						request.getParameter("phone2") + 
						request.getParameter("phone3"));
		String email = (request.getParameter("emailUser") +
						request.getParameter("emailDomain"));
		
		// 정보수정하면 로그아웃하고 다시 로그인하게
		MembersDao mdao = sqlSession.getMapper(MembersDao.class);
		mdao.modify(id, pw, name, nickname, phone, email);
		
		// 로그아웃 시킴
		session.invalidate();
		
		return "login";
	}
}
