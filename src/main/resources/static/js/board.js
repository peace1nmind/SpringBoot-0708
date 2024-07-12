/**
게시판 JS
 */


function writeCheck() {
	var form = document.writeForm;
	
	if (form.title.value.length == 0) {
		alert("제목은 입력해주세요.");
		form.title.focus();
		return false;
	}
	
	if (form.content.value.length == 0) {
		alert("내용을 입력해주세요.");
		form.content.focus();
		return false;
	}
	
	return true;
}

function titleCur() {
	var titleF = document.writeForm.title;
	setTimeout(function() {
		titleF.focus();
		titleF.setSelectionRange(titleF.value.length, titleF.value.length)
	}, 0);
}

// 줄바꿈 함수
function breakLines(content) {
    var result = '';
    var maxLength = 40;
    for (var i = 0; i < content.length; i += maxLength) {
        result += content.substring(i, i + maxLength) + '<br>';
    }
    return result;
}

// 최대 글자수 제한 함수
function limitText(field, maxChars) {
    if (field.value.length > maxChars) {
        field.value = field.value.substring(0, maxChars);
        alert('최대 ' + maxChars + '자까지 입력 가능합니다.');
    }
}
