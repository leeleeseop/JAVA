/*
	공지사항 상세보기 기능 서비스
*/

package com.webjjang.notice.service;

import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.notice.vo.NoticeVO;
import com.webjjang.main.service.Service;

public class NoticeViewService implements Service {
	
	@Override
	public NoticeVO service(Object obj) throws Exception {
		// DB 처리는 DAO에서 처리 - NoticeDAO.view() : obj == no
		// NoticeController - (Execute) - [NoticeViewService] - NoticeDAO.view()
		return new NoticeDAO().view((Long)obj);
  }
	
}
