/*
	공지시항 리스트 조회 기능 서비스
*/

package com.webjjang.notice.service;

import java.util.List;
import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.notice.vo.NoticeVO;
import com.webjjang.main.service.Service;

public class NoticeListService implements Service {

	@Override
	public List<NoticeVO> service(Object obj) throws Exception {
		//DB notice에서 리스트 쿼리 실행해서 데이터 가져오기 - 리턴
		//DB 처리는 DAO에서 처리 NoticeDAO.list()
		//NoticeController -> (Execute로그 출력) -> NoticeListService -> [NoticeDAO.list()]
		return new NoticeDAO().list();
	}//end of public List

}//end of class
