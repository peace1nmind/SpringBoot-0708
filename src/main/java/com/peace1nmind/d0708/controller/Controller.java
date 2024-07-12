package com.peace1nmind.d0708.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peace1nmind.d0708.dao.BoardDao;
import com.peace1nmind.d0708.dao.CommentDao;
import com.peace1nmind.d0708.dao.MembersDao;
import com.peace1nmind.d0708.dto.BoardDto;
import com.peace1nmind.d0708.dto.CommentDto;
import com.peace1nmind.d0708.dto.Criteria;
import com.peace1nmind.d0708.dto.EmailDto;
import com.peace1nmind.d0708.dto.MembersDto;
import com.peace1nmind.d0708.dto.PageDto;
import com.peace1nmind.d0708.dto.PhoneDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
public class Controller {
	
	/*  */
	
	@Autowired
	SqlSession sqlSession;
	
	
	
	/* 기본 홈 */
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	
	
	/* 로그인 */
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
	
	
	
	/* 회원가입 */
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
	
	
	
	/* 로그아웃 */
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
	
	
	
	/* 회원정보 수정 */
	@GetMapping("/modify")
	public String modify(HttpSession session, Model model) {
		
		String sessionId = (String) session.getAttribute("sessionId");
		
		MembersDao mdao = sqlSession.getMapper(MembersDao.class);
		MembersDto mdto = mdao.getInfo(sessionId);
		
		model.addAttribute("mdto", mdto);
		
		String phone_all = mdto.getPhone();
		String phone1 = phone_all.substring(0, 4);
		String phone2 = phone_all.substring(3, 7);
		String phone3 = phone_all.substring(7);
		
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
	public String modifyOk(HttpServletRequest request, HttpSession session, Model model) {
		
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
		
		int modifyFlag = 1;
		
		model.addAttribute("modifyFlag", modifyFlag);
		
		return "login";
	}
	
	
	
	/* 프로필 */
	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
	
	
	
	/* 연락 */
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	
	
	/* 글 작성 */
	@GetMapping("/write")
	public String write(HttpSession session, Model model, HttpServletResponse response) {
		
		String sessionId = (String) session.getAttribute("sessionId");
		
		// 로그인하지 않은 회원이 글쓰기 버튼을 ㅡㅋㄹ릭한 경우
		if (sessionId == null) {
			// 컨트롤러에서 경고창 띄우기
			try {
				// 경고창 텍스트를 인코딩
				response.setContentType("text/html;charset=utf-8");
				// 다시 인코딩 해줘야함
				response.setCharacterEncoding("utf-8");
				PrintWriter printWriter = response.getWriter();
				printWriter.println("<script>alert('"+"로그인한 회원만 글을 쓸 수 있습니다."+"');location.href='"+"login"+"';</script>");
				printWriter.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			MembersDao mdao = sqlSession.getMapper(MembersDao.class);
			MembersDto mdto = mdao.getInfo(sessionId);
			
			model.addAttribute("mdto", mdto);
		}
		
		return "write";
	}
	
	
	@PostMapping("/writeOk")
	public String writeOk(HttpServletRequest request) {
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		bdao.write(request.getParameter("nickname"),
					request.getParameter("writer"),
					request.getParameter("title"),
					request.getParameter("content"));
		
		return "redirect:board";
	}
	
	
	
	/* 글 목록 */
	@GetMapping("/board")
	public String board(Model model, Criteria criteria, HttpServletRequest request) {
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		
		// 유저가 클릭한 페이지 번호
		String pageNum = request.getParameter("pageNum");
		
		if (pageNum != null) {
			// criteria의 pageNum을 유저가 클릭한 페이지 번호로 세팅
			criteria.setPageNum(Integer.parseInt(pageNum));
		}
		
		// 게시판 내 모든 글의 총 개수
		int total = bdao.boardTotalCount();
		
		PageDto pdto = new PageDto(total, criteria);
		
		ArrayList<BoardDto> blist = bdao.list(criteria.getAmount(), criteria.getPageNum());
		
		model.addAttribute("blist", blist);
		model.addAttribute("pdto", pdto);
		
		return "board";
	}
	
	
	
	/* 글 내용 */
	@SuppressWarnings({ "unchecked" })
	@GetMapping("/content")
	public String content(HttpServletRequest request, Model model, HttpSession session) {
		
		String boardnum = request.getParameter("boardnum");
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		CommentDao cdao = sqlSession.getMapper(CommentDao.class);
		
		ArrayList<String> viewList = (ArrayList<String>) session.getAttribute("viewList");
		
		// 조회수 증가 (중복 제거)
		if (!bdao.content(boardnum).getNickname().equals(session.getAttribute("sessionNickname"))) {
			
			if (viewList==null) {
				bdao.hitUp(boardnum);
				viewList = new ArrayList<>();
				viewList.add(boardnum);
				session.setAttribute("viewList", viewList);
				
				System.out.println("viewList:" + session.getAttribute("viewList"));
			} else {
				boolean containFlag = false;
				
				if (viewList.contains(boardnum)) {
					containFlag = true;
				}
				
				if (containFlag == false) {
					viewList.add(boardnum);
					session.setAttribute("viewList", viewList);
					bdao.hitUp(boardnum);
				}
			}
		}	
		
		BoardDto bdto = bdao.content(boardnum);
		ArrayList<CommentDto> clist = cdao.commentList(boardnum);
		
		model.addAttribute("bdto", bdto);
		model.addAttribute("clist", clist);
		
		return "content";
	}
	
	
	
	/* 글 수정 */
	// 글작성자가 아니면 글 수정을 못누르게 수정해야함
	@PostMapping("/editPost")
	public String editPost(HttpServletRequest request, Model model, HttpSession session) {
		
		String boardnum = request.getParameter("boardnum"); 
		String sessionNickname = (String) session.getAttribute("sessionNickname");
		boolean idCheckFlag = request.getParameter("nickname").equals(sessionNickname);
		
		if ("관리자".equals(sessionNickname)) {
			idCheckFlag = true;
		}
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		BoardDto bdto = bdao.content(boardnum);
		
		model.addAttribute("bdto", bdto);
		model.addAttribute("idCheckFlag", idCheckFlag);
		
		return "editPost";
	}
	
	
	@PostMapping("/editPostOk")
	public String editPostOk(HttpServletRequest request, Model model) {
		
		LocalDateTime localtime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String now = localtime.format(formatter);
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		bdao.editPost(request.getParameter("title"),
						request.getParameter("content"),
						now, 
						request.getParameter("boardnum"));
		
		model.addAttribute("boardnum", request.getParameter("boardnum"));
		
		return "redirect:/content?boardnum=" + request.getParameter("boardnum");
	}
	
	
	
	/* 글 삭제 */
	@RequestMapping("/deletePost")
	public String deletePost(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
		
		String boardnum = request.getParameter("boardnum"); 
		String sessionNickname = (String) session.getAttribute("sessionNickname");
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		
		boolean idCheckFlag = bdao.content(boardnum).getNickname().equals(sessionNickname);
		
		if (sessionNickname.equals("관리자")) {
			idCheckFlag = true;
		}
		
		if (idCheckFlag) {
			// 작성자인 경우
			bdao.delete(boardnum);
			
			// 컨트롤러에서 경고창 띄우기
			try {
				// 경고창 텍스트를 인코딩
				response.setContentType("text/html;charset=utf-8");
				// 다시 인코딩 해줘야함
				response.setCharacterEncoding("utf-8");
				PrintWriter printWriter = response.getWriter();
				printWriter.println("<script>alert('"+"글이 삭제되었습니다."+"');window.location.href="+"'board'"+";</script>");
				printWriter.flush();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return "redirect:board";
			
		} else {
			// 컨트롤러에서 경고창 띄우기
			try {
				// 경고창 텍스트를 인코딩
				response.setContentType("text/html;charset=utf-8");
				// 다시 인코딩 해줘야함
				response.setCharacterEncoding("utf-8");
				PrintWriter printWriter = response.getWriter();
				printWriter.println("<script>alert('"+"글 삭제는 작성자만 가능합니다."+"');history.back();</script>");
				printWriter.flush();
				
				return "redirect:/content?boardnum=" + boardnum;
			
			} catch (IOException e) {
				e.printStackTrace();
			
				return "redirect:/content?boardnum=" + boardnum;
			}
		}
	}
	
	
	
	/* 글 검색 */
	@GetMapping("/search")
	public String search(HttpServletRequest request, Model model) {
		
		String searchType = request.getParameter("searchType");
		String searchDetail = request.getParameter("searchDetail");
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> blist = new ArrayList<BoardDto>();
		
		if (searchType.equals("제목")) {
			blist = bdao.search_byTitle(searchDetail);
			model.addAttribute("blist", blist);
		} else if (searchType.equals("제목+내용")) {
			blist = bdao.search_byTitleContent(searchDetail);
			model.addAttribute("blist", blist);
		} else if (searchType.equals("닉네임")) {
			blist = bdao.search_byNickname(searchDetail);
			model.addAttribute("blist", blist);
		} else if (searchType.equals("작성자")) {
			blist = bdao.search_byWriter(searchDetail);
			model.addAttribute("blist", blist);
		} 
		
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchDetail", searchDetail);
		model.addAttribute("emptyFlag", blist.isEmpty());
		model.addAttribute("error", searchType + "에 " + 
							"'" +searchDetail + "'" + "가 포함된 게시물이 없습니다");
		
		return "search";
	}
	
	
	
	
}

