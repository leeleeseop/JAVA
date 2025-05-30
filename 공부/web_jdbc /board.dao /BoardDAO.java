package com.webjjang.board.dao;

import java.util.ArrayList;
import java.util.List;
import com.webjjang.board.vo.BoardVO;
import com.webjjang.main.dao.DAO;
import com.webjjang.util.db.DB;

public class BoardDAO extends DAO {

	//필요한 객체 선언 - 상속 받아서 사용하자
	// 접속 정보 - DB 사용 - connection를 가져오게 하는 메서드
	
	//1.리스트 처리
	//BoardController -> (Execute로그 출력) -> BoardListService -> [BoardDAO.list()]
	public List<BoardVO> list()  throws Exception{
		//결과를 저장할 수 있는 변수 선언
		List<BoardVO> list = null;
		try {
			//1. 드라이버 확인
			
			//2. 연결
			con = DB.getConnection();
			
			//3. sql - list
			
			//4. 실행객체 & 데이터 세팅
			pstmt = con.prepareStatement(LIST);
			
			//5. 실행
			rs = pstmt.executeQuery();
			
			//6. 표시 또는 담기
			if(rs != null) {
				while(rs.next()) {
					// rs -> vo -> list
					// list가 null이면 생성해서 저장할 수 있게 해줘야한다 
					if(list == null) list = new ArrayList<>();
					// rs - vo 
					BoardVO vo = new BoardVO();
					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setWriter(rs.getString("Writer"));
					vo.setWriteDate(rs.getString("WriteDate"));
					vo.setHit(rs.getLong("Hit"));
					//vo - > list에 담는다
					list.add(vo);
				} // end of while 
			} // end of if
		}catch(Exception e ) {
			e.printStackTrace();
			throw e;
		}finally {	
			//7. 닫기
			DB.close(con, pstmt, rs);
		}//end of finally
		//결과 데이터를 리턴해 준다.
		return list;
	}//end of public List<BoardVO> list()
	
	
	//2-1 글보기 조회수 1증가 처리
	//BoardController -> (Execute로그 출력) -> BoardViewService -> [BoardDAO.view()]
	public int increase(Long no)  throws Exception{
		//결과를 저장할 수 있는 변수 선언.
		int result = 0;
		try {
			//1. 드라이버 확인
			
			//2. 연결
			con = DB.getConnection();
			
			//3. sql - increase
			
			//4. 실행객체 & 데이터 세팅
			pstmt = con.prepareStatement(INCREASE);
			pstmt.setLong(1, no);
			
			//5. 실행 실행 update : sxecuteUpdate() - int 결과가 나옴
			result = pstmt.executeUpdate();
			
			//6. 표시 또는 담기
			if(result == 0) {  //글번호가 존재하지 않는다 -> 예외로 처리한다
				throw new Exception("예외 발생 : 글번호가 존재하지 않습니다. 글번호를 확인해 주세요");
			}//end of if
		}catch(Exception e ) {
			e.printStackTrace();
			//특별한 예외는 그냥 전달한다
			if(e.getMessage().indexOf("예외발생") >= 0) throw e;
			//그외 처리 중 나타나는 오류에 대해서 시용자가 볼수 있는 예외로 만들어 전달한다.
			else throw new Exception("예외 발생: 게시판 글보기 조회수 DB처리 중 예외가 발생했습니다");
		}finally {	
			//7. 닫기
			DB.close(con, pstmt);
		}//end of finally
		//결과 데이터를 리턴해 준다.
		return result;
	}// end of public int increase
	
	//2-2 글보기에 대한 처리
	//BoardController -> (Execute로그 출력) -> BoardViewService -> [BoardDAO.view()]
		public BoardVO view(Long no) throws Exception{
			//결과를 저장할 수 있는 변수 선언
			BoardVO vo = null;
			try {
				//1. 드라이버 확인
				
				//2. 연결
				con = DB.getConnection();
				
				//3. sql - view
				
				//4. 실행객체 & 데이터 세팅
				pstmt = con.prepareStatement(VIEW);
				pstmt.setLong(1, no);
				
				//5. 실행
				rs = pstmt.executeQuery();
				
				//6. 표시 또는 담기
				if(rs != null && rs.next()) {
						// rs -> vo -> list
						// list가 null이면 생성해서 저장할 수 있게 해줘야한다 
						// rs - vo 
						vo= new  BoardVO();
						vo.setNo(rs.getLong("no"));
						vo.setTitle(rs.getString("title"));
						vo.setContent(rs.getString("content"));
						vo.setWriter(rs.getString("writer"));
						vo.setWriteDate(rs.getString("writeDate"));
						vo.setHit(rs.getLong("Hit"));
					}//end of if
				}catch(Exception e ) {
				  e.printStackTrace();
				  throw e;
			}finally {
			}//7. 닫기
				DB.close(con, pstmt, rs);	
			//결과 데이터를 리턴해 준다.
			return vo;
		}//end of public view
		
		
	//3.글등록
	//BoardController -> (Execute로그 출력) -> BoardWriteService -> [BoardDAO.write()]
	public BoardVO write(Object vo)  throws Exception{
		//결과를 저장할 수 있는 변수 선언.
		int result = 0;
		try {
			//1. 드라이버 확인
			
			//2. 연결
			con = DB.getConnection();
			
			//3. sql - 아래 write
			
			//4. 실행객체 & 데이터 세팅
			pstmt = con.prepareStatement(WRITE);
			pstmt.setString(1, ((BoardVO) vo).getTitle());
			pstmt.setString(2, ((BoardVO) vo).getContent());
			pstmt.setString(3, ((BoardVO) vo).getWriter());
			pstmt.setString(4, ((BoardVO) vo).getPw());
			
			//5. 실행 실행 update : sxecuteUpdate() - int 결과가 나옴
			result = pstmt.executeUpdate();
			
			//6. 표시 또는 담기
			if(result == 0) {  //글번호가 존재하지 않는다 -> 예외로 처리한다
				throw new Exception("글등록에 실패했습니다");
			}//end of if
		}catch(Exception e ){
			e.printStackTrace();
			//특별한 예외는 그냥 전달한다
			if(e.getMessage().indexOf("예외발생") >= 0) throw e;
			//그외 처리 중 나타나는 오류에 대해서 시용자가 볼수 있는 예외로 만들어 전달한다.
			else throw new Exception("예외 발생: 게시판 글보기 조회수 DB처리 중 예외가 발생했습니다");
		}finally {	
			//7. 닫기
			DB.close(con, pstmt);
		}
		//결과 데이터를 리턴해 준다.
		return  null;
	}// end of public write
		
	//4.업데이트
	//BoardController -> (Execute로그 출력) -> BoardUpdateService -> [BoardDAO.update()]
	public int update (BoardVO vo)  throws Exception{
		//결과를 저장할 수 있는 변수 선언
		int result = 0;
		try {
			//1. 드라이버 확인
			
			//2. 연결
			con = DB.getConnection();
			
			//3. sql - 아래 update
			
			//4. 실행객체 & 데이터 세팅
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			pstmt.setLong(4, vo.getNo());
			pstmt.setString(5, vo.getPw());
			
			//5. 실행
			result = pstmt.executeUpdate();
			
			//6. 표시 또는 담기
			if(result == 0){	
				throw new Exception("예외 발생 : 글번호나 비밀번호가 맞지 않습니다. 정보를 확인해 주세요");
				}//end of if
			}catch(Exception e ){
			  e.printStackTrace();
			  throw e;
		}finally {
		}//7. 닫기
			DB.close(con, pstmt, rs);	
		//결과 데이터를 리턴해 준다.
		return result;
	}//end of public update
						
	//5. 삭제
	//BoardController -> (Execute로그 출력) -> BoardDeleteService -> [BoardDAO.delete()]
	public int delete (BoardVO vo)  throws Exception{
		//결과를 저장할 수 있는 변수 선언
		int result = 0;
		try {
			//1. 드라이버 확인
			
			//2. 연결
			con = DB.getConnection();
			
			//3. sql - 아래 delete
			
			//4. 실행객체 & 데이터 세팅
			pstmt = con.prepareStatement(DELETE);
			pstmt.setLong(1, vo.getNo());
			pstmt.setString(2, vo.getPw());
			
			//5. 실행
			result = pstmt.executeUpdate();
			
			//6. 표시 또는 담기
			if(result == 0) {	//글번호가 존재하지 않거나 비번 틀림 -> 예외로 처리한다 
				throw new Exception("예외 발생 : 글번호나 비밀번호가 맞지 않습니다. 정보를 확인해 주세요");
				}//end of if
			}catch(Exception e ) {
			  e.printStackTrace();
			  if(e.getMessage().indexOf("예외발생") >= 0 ) throw e;
			  else throw new Exception("에외 발생 : 게시판 글삭제 DB 처리 중 예외가 발생했씁니다");
		}finally {
		}//7. 닫기
			DB.close(con, pstmt);	
		//결과 데이터를 리턴해 준다.
		return result;
	}//end of public delete
								
	//실행할 쿼리를 정의해 놓은 변수 선언
	final String LIST = " select no, title, writer, writeDate, "  
			+ " to_char(writeDate, 'yyyy-mm-dd') writeDate, hit "
			+ " from board "
			+ " order by no desc ";
	
	final String INCREASE = "update board set hit = hit + 1"
			+ " where no = ? " ;
	
	final String VIEW = " select no, title, content, writer, writeDate, "
			+ " to_char(writeDate, 'yyyy-mm-dd') writeDate, hit "
			+ " from board "
			+ " where no = ? ";
	
	final String WRITE = "insert into board("
			+ "no, title, content, writer, pw)"
			+ "values(board_seq.nextval, ?, ?, ?, ?)";
	
	final String UPDATE = "update board set "
			+ " title = ?, content = ?, writer = ? "
			+ " where no = ? and pw = ? ";
	
	final String DELETE = "delete from board "
			+ " where no = ?  and pw = ? ";
	
}//end of class
