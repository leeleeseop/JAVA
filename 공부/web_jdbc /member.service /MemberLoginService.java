package com.webjjang.member.service;

import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.vo.LoginVO;
import com.webjjang.main.service.Service;

// 회원 로그인 처리 서비스
public class MemberLoginService implements Service {

	@Override
	public LoginVO service(Object obj) throws Exception {
		// DB 처리는 DAO에서 처리 - MemberDAO.login()
		// MemberController - (Execute) - [MemberLoginService] - MemberDAO.login()
		return new MemberDAO().login((LoginVO)obj);
  }//end of public Login
	
}//end of class
