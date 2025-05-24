package com.webjjang.member.service;

import java.util.List;
import com.webjjang.main.service.Service;
import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.vo.MemberVO;

//회원 상세정보 조회 서비스
public class MemberViewService implements Service {

	@Override
	public MemberVO service(Object obj) throws Exception {
		// MemberDAO 객체 생성
		// MemberDAO의 view 메서드 호출하여 결과를 반환
		return new MemberDAO().view((String)obj);
		//DB Member에서 리스트 쿼리 실행해서 데이터 가져오기 - 리턴
		//DB 처리는 DAO에서 처리 MemberDAO.view()
		//MemberController -> (Execute로그 출력) -> MemberViewService -> [MemberDAO.view()]
		//if(inc == 1) newdao.increase(no);
		//return new MemberDAO().view((String)obj);
	}//end of public MemberVO
	
}//end of class
