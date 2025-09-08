public class CarExample {

	public static void main(String[] args) {
		
		// 1.생성자 호출
		Car car1 = new Car();
		System.out.println("car1.company : " + car1.company);
		System.out.println();
		
		// 2.생성자 호출
		Car car2 = new Car("자가용");
		System.out.println("car2.company : " + car2.company);
		System.out.println("car2.model : " + car2.model);
		System.out.println();
		
		// 3.생성자 호출
		Car car3 = new Car("자가용", "흰색");
		System.out.println("car3.company : " + car3.company);
		System.out.println("car3.model : " + car3.model);
		System.out.println("car3.color : " + car3.color);
		System.out.println();
		
		// 4.생성자 호출
		Car car4 = new Car("자가용", "흰색", 200);
		System.out.println("car4.company : " + car4.company);
		System.out.println("car4.model : " + car4.model);
		System.out.println("car4.color : " + car4.color);
		System.out.println("car4.maxSpeed : " + car4.maxSpeed);
		System.out.println();
	}
}
