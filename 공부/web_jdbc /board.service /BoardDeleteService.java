package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.vo.BoardVO;
import com.webjjang.main.service.Service;

// 게시판 글 삭제 처리를 담당
public class BoardDeleteService implements Service {
	
	@Override
	public Integer service(Object obj) throws Exception {
		
		//넘어오는 데이터의 구조 obj - long[] : obj[0] - no, obj[1] - inc
		//DB 처리는 DAO에서 처리 BoardDAO.delet()
		//BoardController -> (Execute로그 출력) -> BoardDeleteService -> [BoardDAO.delet()]
		return new BoardDAO().delete((BoardVO)obj);
	}//end of public Integer
	
}//end of class
