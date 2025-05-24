/*
	공지사항 등록 기능 서비스 
*/

package com.webjjang.notice.service;

import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.notice.vo.NoticeVO;
import com.webjjang.main.service.Service;

public class NoticeWriteService implements Service {
	
	@Override
	public NoticeVO service(Object obj) throws Exception {
		//DB 처리는 DAO에서 처리 NoticeDAO.write()
		//NoticeController -> (Execute로그 출력) -> NoticeWriteService -> [NoticeDAO.write()]
		return new NoticeDAO().write((NoticeVO)obj);
	}
	
}
