public class Car {

	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	
	// 생성자 선언
	// 1.생성자 - 매개변수 없는 기본 생성자
	Car() {} 
	
	// 2.생성자 - model만 받는 생성자
	Car(String model){
		this.model = model;
	}
	
	// 3.생성자 - model + color를 받은 생성자
	Car(String model, String color){
		this.model = model;
		this.color = color;
	}
	
	// 4.생성자 - model + color + maxSpeed를 받은 생성자
	Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
