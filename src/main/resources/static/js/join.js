/**
 * 
 */

function idCur() {
	setTimeout(function() {
		document.joinForm.id.focus();
	}
	, 0)
}

function pwCur() {
	setTimeout(function() {
			var pwF = document.joinForm.pw;
			pwF.focus();
			pwF.setSelectionRange(pwF.value.length, pwF.value.length);
		}
		, 0)
}

function joinCheck() {
	var form = document.joinForm;
	
	if (form.id.value.length==0) {
		alert("아이디는 필수 입력사항입니다.\n다시 확인해 주세요.");
		form.id.focus();
		return false;
	}
	
	if (form.pw.value.length==0) {
		alert("비밀번호는 필수 입력사항입니다.\n다시 확인해 주세요.");
		form.pw.focus();
		return false;
	}
	
	if (form.pw.value != form.pwOk.value) {
		alert("비밀번호가 일치하지 않습니다.\n다시 확인해 주세요.")
		form.pwOk.focus();
		return false;
	}
		
	if (form.name.value.length==0) {
		alert("이름은 필수 입력사항입니다.\n다시 확인해 주세요.");
		form.name.focus();
		return false;
	}
	
	if (form.nickname.value.length==0) {
		alert("닉네임은 필수 입력사항입니다.\n다시 확인해 주세요.");
		form.nickname.focus();
		return false;
	}
	
	if (form.email.value.length==0) {
		alert("이메일은 필수 입력사항입니다.\n다시 확인해 주세요.");
		form.email.focus();
		return false;
	}
	
	// submit
	return true;
}