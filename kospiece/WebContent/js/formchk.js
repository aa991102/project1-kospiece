function formChk(){
	frm = document.join;
	
	if(frm.mid.value.length<1){
		alert('아이디를 입력하세요.')
		frm.mid.focus();
		return flase;
	}
	
	if(frm.mpw.value != frm.mpw2.value){
		alert('비밀번호가 일치하지 않습니다.')
		frm.mpw.focus();
		return false;
	}
	
	if(frm.mname.value.length<1){
		alert('이름을 입력하세요.')
		frm.mid.focus();
		return flase;
	}
	
	if(frm.mnick.value.length<1){
		alert('nickname을 입력하세요.')
		frm.mid.focus();
		return flase;
	}
	
	if(frm.mmail.value.length<1){
		alert('mmail을 입력하세요.')
		frm.mid.focus();
		return flase;
	}
	
	if(frm.mphone.value.length<1){
		alert('mphone을 입력하세요.')
		frm.mid.focus();
		return flase;
	}
	
	
}