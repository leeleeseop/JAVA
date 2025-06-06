package com.webjjang.util.exe;

import java.util.Arrays;
import com.webjjang.main.controller.Main;
import com.webjjang.main.service.Service;
import com.webjjang.member.service.MemberConUpdateService;
import com.webjjang.util.auth.Authority;

public class Execute {
	//서비를 실행 시키고 로그를 출력하는 매소드
	public static Object execute(Service service, Object obj) throws Exception{
		//권한처리
		Authority.checkAuth(service);
		// 처리된 결과를 저장하는 변수 -> 리턴한다.
		Object result = null;
		System.out.println();
		System.out.println("<<---------------- 실행 로그 출력 ---------------->>");
		
		
		//시작시간 저장
		Long start = System.nanoTime();
		//실행객체 정보를 출력
		//service 객체를 클래스로 바꾸자 -> service.getClass()
		//클래스의 이름을 패키지와 함께 가져오자 ->getName()
		//패키지 생략하고 getsimpleName
		System.out.println("실행 객체 이름 : " + service.getClass().getName());
		
		//넘어오는 데이터 출력
		//배열인지 물어보자 : obj instanceof objcet []
		//배열이면 배열 출력하는 Arrays.toString() 사용하고 아니면 obj를 그냥 출력한다.
		System.out.println("넘어가는 데이터 : " + ((obj instanceof Object[])?Arrays.toString((Object[]) obj):obj));
		
		//service를 실행한다.
		result = service.service(obj);
		
		//결과데이터 출력 
		System.out.println("결과 데이터 : " + result);
		
		// 끝나는 시간 저장
		Long end = System.nanoTime();
		
		// 실행시간 출력 (끝나는 시간 - 시작 시간)
		System.out.println("실행시간(ns) : " + (end - start));
		System.out.println("--------------------------------------------------");
		
		//최근접속일 수정 - 로그인이 되어 있는 경우 
		if(Main.login != null) {
			new MemberConUpdateService().service(Main.login.getId());
		}

		System.out.println("<<------------------------------------------------->>");
		//처리된 결과를 리턴한다
		return result;
	}
}
