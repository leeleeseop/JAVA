package com.webjjang.member.service;

import java.util.List;

import com.webjjang.main.service.Service;
import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.vo.MemberVO;

public class MemberListService implements Service {

	@Override
	public List<MemberVO> service(Object obj) throws Exception {
		
		//DB notice에서 리스트 쿼리 실행해서 데이터 가져오기 - 리턴
		//DB 처리는 DAO에서 처리 MemberDAO.list()
		//MemberController -> (Execute로그 출력) -> MemberListService -> [MemberDAO.list()]
		return new MemberDAO().list();
	}

}
