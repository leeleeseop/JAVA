package com.webjjang.member.service;

import com.webjjang.main.service.Service;
import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.vo.MemberVO;

//회원정보 수정 기능 서비스
public class MemberUpdateService implements Service {

	@Override
	public Integer service(Object obj) throws Exception {
		// DB 처리는 DAO에서 처리 - MemberDAO.update()
		// MemberController - (Execute) - [MemberUpdateService] - MemberDAO.update()
		return new MemberDAO().update((MemberVO)obj);
	}//end of public Integer

}//end of class
