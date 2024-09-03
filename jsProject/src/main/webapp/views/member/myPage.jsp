<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.outer {
		background-color: rgb(74, 210, 255);
		color: white;
		width: 1000px;
		margin: auto;
		margin-top: 50px;
	}

	#enroll-form table { margin: auto; }
	#enroll-form input { margin: 5px; }
</style>

</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
		<br>
		<h2  align="center">마이페이지</h2>

		<form id="enroll-form" action="<%= contextPath %>/update.me" method="post">
			<!-- table>(tr>td*2)*8 -->
			<table>
				<tr>
					<td>* 아이디</td>
					<td>
						<input type="text" name="userId" maxlength="12" value="${ loginUser.userId }" readonly>
					</td>
				</tr>
				</tr>
				<tr>
					<td>* 이름</td>
					<td>
						<input type="text" name="userName" maxlength="6" value="${ loginUser.userName}" required>
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>
						<input type="tel" name="phone" value="${ loginUser.phone }">
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="email" name="email" value="${ loginUser.email }">
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" name="address" value="${ loginUser.address }">
						
					</td>
				</tr>
				<tr>
					<td>취미</td>
					<td>
						<!-- (input:checkbox[name=interest]+label)*5 -->
						<input type="checkbox" name="interest" id="baseball" value="야구">
						<label for="baseball">야구</label>

						<input type="checkbox" name="interest" id="cartoon" value="만화">
						<label for="cartoon">만화</label>

						<input type="checkbox" name="interest" id="soccer" value="축구">
						<label for="soccer">축구</label>

						<br>

						<input type="checkbox" name="interest" id="study" value="공부">
						<label for="study">공부</label>

						<input type="checkbox" name="interest" id="game" value="게임">
						<label for="game">게임</label>
					</td>
				</tr>
			</table>

		<br><br>

		<div align="center">
		<button class="btn btn-sm btn-info" type="submit">정보 수정</button>
		<button class="btn btn-sm btn-warning" type="button" data-toggle="modal" data-target="#updatePwdModal">비밀번호 변경</button>
		<button class="btn btn-sm btn-danger" type="button" data-toggle="modal" data-target="#delMemberModal">회원 탈퇴</button>
		</div>

		<br><br>
	</form>
	</div>

	<!-- 비밀번호 변경용 모달 -->
	<div class="modal fade" id="updatePwdModal" tabindex="-1" aria-labelledby="updatePwdModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- 모달 헤더 부분 -->
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="updatePwdModalLabel">비밀번호 변경</h1>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">&times;</button>
			</div>
			<!-- 모달 바디 부분 -->
			<div class="modal-body">

				<form action="<%= contextPath %>/updatePwd.me" method="post">

					<div class="mb-3">
						<label for="userPwd" class="col-form-label">현재 비밀번호:</label>
						<input type="password" class="form-control" id="userPwd" name="userPwd">
					</div>

					<div class="mb-3">
						<label for="newPassword" class="col-form-label">변경할 비밀번호:</label>
						<input type="password" class="form-control" id="newPassword" name="newPassword"></textarea>
					</div>

					<div class="mb-3">
						<label for="newPasswordCheck" class="col-form-label">변경할 비밀번호 확인:</label>
						<input type="password" class="form-control" id="newPasswordCheck" name="newPasswordCheck"></textarea>
					</div>

					<button class="btn btn-sm btn-info" onclick="return pwdCheck">비밀번호 변경</button>

				</form>

			</div>
			<!-- 모달 푸터 부분 -->
			<!-- <div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Send message</button>
			</div> -->
			</div>
		</div>
		</div>

		<!-- 회원 탈퇴용 모달 -->
		<div class="modal fade" id="delMemberModal" tabindex="-1" aria-labelledby="delMemberModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- 모달 헤더 부분 -->
				<div class="modal-header">
					<h2 class="modal-title fs-5" id="delMemberModalLabel">회원 탈퇴</h2>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">&times;</button>
				</div>

				<!-- 모달 바디 부분 -->
				<div class="modal-body">
	
					<form action="<%= contextPath %>/delete.me" method="post">
						<input type="hidden" name="userId" value="${ loginUser.userId }">
						<b>
							탈퇴 후 복구 불가능합니다. <br>
							그래도 탈퇴하시겠습니까?
						</b>

						<div class="mb-3">
							<label for="userPwd" class="col-form-label">비밀번호:</label>
							<input type="password" class="form-control" id="userPwd" name="userPwd" required>
						</div>
	
						<button type="submit" class="btn btn-sm btn-danger" onclick="return pwdCheck">탈퇴하기</button>
	
					</form>
	
				</div>
				</div>
			</div>
			</div>

	<script>
		// onload = function() {}
		$(function() {
			const interest = "${ loginUser.interest }";
			const checkArr = $("input[name=interest]");	// [input, input, input, ..]

			console.log(interest);
			console.log(checkArr);

			for(let check of checkArr) {	// checkbox 요소에 하나씩 접근
				// check => js 방식으로 접근 요소로 인식됨!
				if (interest.includes(check.value )) {
					// check.prop("checked", true);		// x
					check.checked = true;	// js 방식
				}
			}
		});

		function pwdCheck() {
			const pwd = document.querySelector("#updatePwdModal input[name=newPassword]").value;
			const pwdCheck = document.querySelector("#updatePwdModal input[name=newPasswordCheck]").value;

			if (pwd != pwdCheck) {
				alert("비밀번호와 비밀번호 확인 입력 값이 다릅니다.");
				return false;
			}
		};
	</script>
</body>
</html>