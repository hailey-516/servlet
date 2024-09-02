package com.kh.member.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class UpdateMemberController
 */
@WebServlet("/update.me")
public class UpdateMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		// 전달된 데이터 추출
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		String[] interArr = request.getParameterValues("interest");	// ["야구", "게임"] || null
		
//		데이터 잘 전달되었는지 확인
//		System.out.println(userId);
//		System.out.println(userName);
//		System.out.println(phone);
//		System.out.println(email);
//		System.out.println(address);
//		System.out.println(Arrays.toString(interArr));
		
		// 문자열배열(String[]) -> 문자열(String)
		String interest="";
		if(interArr != null) {
			interest = String.join(",", interArr);
		}
		
		Member m = new Member(userId, userName, phone, email, address, interest);
		
		// 변경한 내용도 보여줘야 하고, 세션에 있는 내용도 바꿔 줘야 하기 때문에 멤버 타입으로 받음
		Member updateMem = new MemberService().updateMember(m);
		
		if (updateMem == null) {	// 정보 수정 실패
			// 정보 수정 실패 메시지와 함께 에러 페이지로 응답
			request.setAttribute("errorMsg", "정보 수정 실패!");
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		} else {	// 정보 수정 성공
			// 세션 영역에 변경된 사용자 정보를 저장
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updateMem);
			
			// 수정 성공했다는 메시지를 알림창을 띄울 수 있도록 세션 영역에 저장
			session.setAttribute("alertMsg", "정보 수정에 성공했습니다!");
			
			// 마이페이지로 url 재요청(/jsp/myPage.me)
			response.sendRedirect(request.getContextPath() + "/myPage.me");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
