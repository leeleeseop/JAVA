package ch07defferent;

import ch07basic.Super;

public class Sub extends Super {

	public void print() {
		
		// public 변수 다른 패키지에서 상속 성공
		System.out.println(publicVar);
		
		// protected 변수  다른 패키지에서 상속 성공
		System.out.println(protectedVar);
		
		// default 변수  다른 패키지에서 상속 안됨.
		// System.out.println(defaultVar);
		
		// privateV 변수 같은 패키에서 상속 안됨.
		// System.out.println(privateVar);
	}
	
}
