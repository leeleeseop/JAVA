package com.webjjang.util.io;

import java.util.List;
import com.webjjang.notice.vo.NoticeVO;

public class NoticePrint {
	//공지사항  출력메서드  
	public void print(List<NoticeVO> list) {
		System.out.println();
		System.out.println("<<-------------공지사항 리스트 ----------->>>");
		System.out.println("<<----------------------------------------------->>>");
		System.out.println("글번호  /       제목       /  작석장  /  작성일  /  수정일 ");
		System.out.println("<<----------------------------------------------->>>");
		if(list == null) {//데이터가 없으면 null이 된다.
			System.out.println("***데이터가 존재하지 않습니다***");
		}else {
			for(NoticeVO vo : list) {
				System.out.print(" " + vo.getNo());
				System.out.print(" / " + vo.getTitle());
				System.out.print(" / " + vo.getStartDate());
				System.out.print(" / " + vo.getEndDate());
				System.out.print(" / " + vo.getUpdateDate());
				System.out.println();
			}//end of for
		}//end of else
		System.out.println("<<----------------------------------------------->>>");
	}//end of public class print
	
	public void print(NoticeVO vo) {
		System.out.println();
		System.out.println("<<-------------공지사항 리스트 ----------->>>");
		System.out.println("<<----------------------------------------------->>>");
		System.out.println("+ 글번호 : " + vo.getNo());
		System.out.println("+ 제목 : " + vo.getTitle());
		System.out.println("+ 내용 : " + vo.getContent());
		System.out.println("+ 시작일 : " + vo.getStartDate());
		System.out.println("+ 종료일 : " + vo.getEndDate());
		System.out.println("+ 수정일 : " + vo.getUpdateDate());
		System.out.println("+ 작성일 : " + vo.getWriteDate());
		System.out.println("<<----------------------------------------------->>>");
	}//end of public void print
}//end of class
