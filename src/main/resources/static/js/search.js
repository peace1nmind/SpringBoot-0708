/**
검색 기능에 대한 js
 */



// var search = document.searchForm.searchDetail;

// 검색어에 대한 validation
function searchCheck() {
	var search = document.searchForm.searchDetail;
	
	if (search.value.length == 0) {
		alert("검색어를 입력해주세요");
		search.focus();
		return false;
	}
	
	return true;	
}


// 검색 창 커서
function searchCur() {
	var search = document.searchForm.searchDetail;
	
	setTimeout(function() {
		search.focus();
		search.setSelectionRange(search.value.length, search.value.length);
	}, 0);
}

