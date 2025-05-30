package ch06class;

public class BoardExample {

	public static void main(String[] args) {
		
		// Board 객체 사용해 보기 - 일반 게시판의 데이터를 한꺼번에 처리하고자 할 때
		Board board = new Board();
		System.out.println(board);

		// Board 객체에 데이터를 설정
		// 데이터 no =10, title = 자바란?, content = "프로그래밍 언어", writer ="이이섭"
		board.setNo(10);
		board.setTitle("자바란?");
		board.setContent("프로그래밍 언어");
		board.setWriter("이이섭");

		// 데이터가 설정된 board 객체를 출력
		System.out.println(board);
		
		// board 데이터 출력 - 항목을 하나씩 꺼내서 출력
		System.out.println("글번호 : " + board.getNo());
		System.out.println("제목 : " + board.getTitle());
		System.out.println("내용 : " + board.getContent());
		System.out.println("작성자 : " + board.getWriter());
	} //end of main()
} // end of class
