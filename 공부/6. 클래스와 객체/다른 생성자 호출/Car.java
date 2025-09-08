public class Car {

	// 필드선언
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	// 1. 생성자
	Car(String model) {
		// 세번째 생성자 호출
		this(model, "흰색", 250);
	}
	
	// 2. 생성자
	Car(String model, String color) {
		// 세번째 생성자 호출
		this(model, color, 250);
	}
	
	// 3. 생성자
	Car(String model, String color, int maxSpeed) {
    // 공통 초기화 코드
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
