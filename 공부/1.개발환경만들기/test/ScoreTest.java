package test;
// 점수가 있는 변수 score에 int 타입의 데이터 70을 넣고 
// 점수가 60 이상이면 “합격”을 미만이면 “불합격”을 
// 콘솔에 출력하는 test.ScoreTest라는 클래스의 main()에 작성하시오. 
public class ScoreTest {

	public static void main(String[] args) {
		// 정수형 변수 score를 선언하고 70으로 초기화
		int score = 70;

		// if-else를 사용하여 score가 60 이상인지 확인
		// 60이상이면 "합격" 출력
		// 그렇지 않으면 "불합격" 출력
		if(score >= 60) System.out.println("합격");
		else System.out.println("불합격");
	}
}
