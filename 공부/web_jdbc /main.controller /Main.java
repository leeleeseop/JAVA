package com.webjjang.main.controller;

import com.webjjang.board.controller.BoardController;
import com.webjjang.member.controller.MemberController;
import com.webjjang.member.vo.LoginVO;
import com.webjjang.notice.controller.NoticeController;
import com.webjjang.util.io.In;

public class Main {
	
	//longin 변수 안에 데이터 있으면 (null이 아니면) 로그린 한 상태
	//longin 변수 안에 데이터 없으면 (null이면) 로그린 안한 상태
	public static LoginVO login = null;

	// 로그인 상태에 따라 로그인 정보를 출력력
	public static void loginInto() {
		System.out.println();
		System.out.println("<<<--- Longin Infromation --->>>");
		System.out.println("/////////////////////////////////");
		if(login == null) {
			System.out.println("// 로그인이 되어있지 않습니다.");
			System.out.println("// 로그인을 하려면 5. 회원관리 1. 로그인 메뉴를 선택하세요");
		}else {//로그인 인 된경우
			System.out.println("// " + login.getName() + "(" + login.getId()
			+ ")남은 ");
			System.out.println("// " + login.getGradeName()+"-" + login.getGradeNo() + "(으)로 로그인 되었습니다.");
			System.out.println("// 당신에게 온 메시지는" + login.getNewMsgCnt() + "개 입니다");
		}//end of else		
		System.out.println("/////////////////////////////////");
	}//end of public static void loginInto

	//프로젝트 시작되는 지점.
	public static void main(String[] args) throws ClassNotFoundException {
		
		// 인사
		System.out.println("==============================");
		System.out.println("  웹짱닷컴에 오신것을 환영합니다.  ");
		System.out.println("==============================");
		
		//드라이버 확인 -> DB 관련  static 프로그램이 로딩된다
		Class.forName("com.webjjang.util.db.DB");
		
		// 무한 반복 - 메뉴
		while(true) {
			Main.loginInto();
			System.out.println();
			System.out.println("<<<-----------[메인메뉴]----------->>>");
			//메뉴 출력 - 공지사항, 쇼핑몰, 일반게시판, 사진게시판, 회원게시판, 회원관리
			System.out.println("********************************");
			System.out.println("**1.공지사항, 2.쇼핑몰, 3.일반게시판**");
			System.out.println("**4.사진게시판, 5.회원관리, 0.종료**");
			System.out.println("********************************");
			//메뉴 선택 입력
			String menu = In.getStr("메뉴");
			//메뉴 처리 -> BoardController로 이동. execute() 호출
			// - 0을 입력하면 종료 인사 -> 종료
			
			switch (menu) {
			case "1": 
				System.out.println("1. 공지사항");
				//생성하고 호출한다
				new NoticeController().excute();
				break;
			
			case "2": 
				System.out.println("2. 쇼핑몰");
				break;
			
			case "3": 
				System.out.println("3.일반게시판");
				//생성하고 호출한다 - 1번만 실행한다.: 변수 사용하지 않아도 된다. new하고 바로실행
				new BoardController().excute();
				break;
			
			case "4": 
				System.out.println("4.사진게시판");
				break;
			
			case "5": 
				System.out.println("5.회원관리");
				new MemberController().excute();
				break;
			
			case "0": 
				System.out.println("0.종료");
				//종료인사
				System.out.println("==============================");
				System.out.println("=======좋은 시간 되셨나요?.=======");
				System.out.println("=======시스템을 종료합니다.=======");
				System.out.println("==============================");
				System.exit(0);;

			default:
				System.out.println("#######################################");
				System.out.println("##잘못된 메뉴를 선택하셨습니다.##");
				System.out.println("##[0~5, 0] 중에서 입력하셔야 합니다.##");				
				System.out.println("#######################################");
			}//end of wsitch
		}//end of while
		
	}//end of main
}//end of class
