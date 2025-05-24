package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.vo.BoardVO;
import com.webjjang.main.service.Service;

// BoardWriteService: 게시글 등록 처리를 담당
public class BoardWriteService implements Service {

	@Override
	public BoardVO service(Object obj) throws Exception {
		//넘어오는 데이터의 구조 obj - long[] : obj[0] - no, obj[1] - inc
		//DB 처리는 DAO에서 처리 BoardDAO.write()
		//BoardController -> (Execute로그 출력) -> BoardWriteService -> [BoardDAO.write()]
		return new BoardDAO().write((BoardVO)obj);
	}//end of public BoardVO

}//end of class
