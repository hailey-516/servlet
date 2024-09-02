package com.kh.member.model.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {
	
	public Member loginMember(String id, String pwd) {
		// Connection 객체를 생성하여 Dao에게 전달
		Connection conn = getConnection();
		
		// Dao 객체에게 DB에 아이디, 비밀번호에 해당하는 데이터가 있는지 확인 요청
		Member m = new MemberDao().loginMember(conn, id, pwd);
		
		// Connection 객체 반납(close)
		close(conn);
		
		return m;
	}
	
	public int insertMember(Member m) {
		Connection conn = getConnection();
		
		// insert(DDL) --> int --> 트랜잭션처리(commit, rollback)
		int result = new MemberDao().insertMember(conn, m);
		
		if(result > 0) {	// 회원 데이터 추가 성공
			commit(conn);
		} else {	// 회원 데이터 추가 실패
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int idCheck(String userId) {
		// Connection 객체 생성
		Connection conn = getConnection();
		
		// Dao에게 Connection 객체와 데이터 전달
		int count = new MemberDao().idCheck(conn, userId);
		
		// DQL(Select) => Connection 객체 반납(close)
		close(conn);

		// 결과를 반환(return)
		return count;
	}
	
	public Member updateMember(Member m) {
		// Connection 객체 생성
		Connection conn = getConnection();
		
		// Dao에게 Connection, Member 객체 전달하면서 수정 요청
		// update(DML) -> 트랜잭션 처리
		int result  = new MemberDao().updateMember(conn, m);
		
		Member updateMem = null;
		// 결과에 따라 트랜잭션 처리
		if(result > 0) {
			commit(conn);
			
			// 변경된 사용자 정보 조회
			updateMem = new MemberDao().selectMember(conn, m.getUserId());
		} else {
			rollback(conn);
		}
		
		// Connection 객체 반납(close)
		close(conn);
		// Member 객체 반환
		// * 수정 성공했다면 변경된 내용이 저장된 Member객체 반환
		// * 실패했다면 null이 반환될 것임
		return updateMem;
	}

}
