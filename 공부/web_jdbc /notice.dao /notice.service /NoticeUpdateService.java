package com.webjjang.notice.service;

import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.notice.vo.NoticeVO;
import com.webjjang.main.service.Service;

public class NoticeUpdateService implements Service {

	@Override
	public Integer service(Object obj) throws Exception {
		
		//DB 처리는 DAO에서 처리 NoticeDAO.update()
		//NoticeController -> (Execute로그 출력) -> NoticeUpdateService -> [NoticeDAO.update()]
		return new NoticeDAO().update((NoticeVO)obj);
	}

}
