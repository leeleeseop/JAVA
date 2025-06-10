package java_02_var;

public class DigitVar {

	// 초기 값 세팅
	// 전역 변수 - 모든 메서드에서 사용 가능하다.
	// static 변수인 경우 사용할 때 클래스이름. 변수이름으로 사용
	static int score;
	
	public static void main(String[] args) {
		// 메서드에서 처리되는 변수를 선언할 수 있다.
		// 지역변수
		int score;
		score = 0;
		// 지역 변수 값 출력 - 초기 값이 없으면 오류가 난다.
		System.out.println(score);
		
		// 전역 변수 값 출력 - 클래스와 함께 올라간다. 초기값을 넣어준다. 숫자인 경우 0
		System.out.println(DigitVar.score);
		
		byte a = 10;
		// 정수 기본 타입 int이므로 연산을 하면 int 된다.
		a = (byte) (a + 5);
		
		System.out.println(a);
		
		//int 타입의 최대 입력 할 수 있는 숫자? : 랩퍼 클래스
		System.out.println(Integer.MAX_VALUE);
		
		long l = 10000000000L;
		
		// 현재 나이가 25세 이상이면
		boolean over = true;
		System.out.println(over);
		
		// 본인 이름은 변수 name에 넣고 콘솔에 출력하시오 
		String name = "이이섭";
		System.out.println(name);
		
		// + : 숫자 더하기, 
		// 문자에서도 + : 문자열 이어 붙이기 -> 다른 타입의 데이터와 + 연산 하면 문자열로 만들어서 이어 붙인다.
		System.out.println(name + l + (123+5));
	}
	
}
