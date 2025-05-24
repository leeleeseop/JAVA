package com.webjjang.member.service;

import com.webjjang.main.service.Service;
import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.vo.MemberVO;

//회원기능 삭제 서비스
public class MemberDeleteService implements Service {

	@Override
	public Integer service(Object obj) throws Exception {
		return new MemberDAO().delete((MemberVO)obj);
	}//end of public Integer

}//end of class
