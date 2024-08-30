package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class JqAjax3Controller
 */
@WebServlet("/jqAjax3.do")
public class JqAjax3Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjax3Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Member m = new MemberService().selectMember(userNo);
		
		// 요청 시 전달된 데이터 추출 => 회원번호
		String no = request.getParameter("userNo");
		
		Member m = new Member(Integer.parseInt(no), "아이유", "iu1004", "서울");
		
		// response.getWriter().print(m);
		// => m.toString() 의 값이 전달됨.
		
		// => vo 객체를 전달하고자 할 경우, JSONObject 타입으로 전달해줘야 함!
		/*
		JSONObject jsonObj = new JSONObject();	// {}
		jsonObj.put("userNo", m.getUserNo());	// {userNo: 150}	
		jsonObj.put("userName", m.getUserName());	// {userNo: 150, userName: "아이유"}
		jsonObj.put("userId", m.getUserId());	 // {userNo: 150, userName: "아이유", userId: "iu1004"}
		jsonObj.put("address", m.getAddress());		// {userNo: 150, userName: "아이유", userId: "iu1004", address: "서울"}
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jsonObj);
		*/
		
		// => 좀 더 간단한 방법으로 응답하기 (GSON: Google JSON)
		Gson gson = new Gson();
		
		response.setContentType("application/json; charset=UTF-8");
		
		// Gson객체.toJson(vo객체, 응답할 스트림);
		gson.toJson(m, response.getWriter());
		/**
		 * Gson 사용 시 vo 객체를 응답하는 경우 JSONObject 형태로 전달
		 * 		이때, key값은 vo객체의 필드명으로 전달
		 * 
		 * ArrayList/배열 데이터를 응답하는 경우 JSONArray 형태로 전달
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
