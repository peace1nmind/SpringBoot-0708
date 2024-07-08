/**
 * 
 */

function idCur() {
	setTimeout(function() {
		document.loginForm.id.focus();
	}
	, 0)
}

function loginCheck() {
	var form = document.loginForm;
	
	if (form.id.value.length==0) {
		alert("아이디를 입력해주세요.");
		form.id.focus();
		return false;
	}
	
	if (form.pw.value.length==0) {
		alert("비밀번호를 입력해주세요.");
		form.pw.focus();
		return false;
	}
	
	// submit
	return true;
}