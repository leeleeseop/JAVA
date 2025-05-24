package com.webjjang.member.service;

import java.util.List;
import com.webjjang.main.service.Service;
import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.vo.MemberVO;

//회원가입(등록) 기능 서비스
public class MemberWriteService implements Service {

	@Override
	public Integer service(Object obj) throws Exception {
		// MemberDAO 객체 생성
		// MemberDAO의 write 메서드 호출하여 결과를 반환
		return new MemberDAO().write((MemberVO)obj);
		//DB Member에서 리스트 쿼리 실행해서 데이터 가져오기 - 리턴
		//DB 처리는 DAO에서 처리 MemberDAO.Write()
		//MemberController -> (Execute로그 출력) -> MemberWriteService -> [MemberDAO.write()]
	}//end of public Integer
	
}//end of class
