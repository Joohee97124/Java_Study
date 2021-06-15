/*========================================
 * Main.java
 * - main() 메소드가 포함된 테스트 클래스
========================================*/

package com.test.spr;

import java.lang.reflect.Proxy;

public class Main
{
	public static void main(String[] args)
	{
		// 주 업무 실행을 할 수 있는 객체 준비
		// 인터페이스 변수 = new 인터페이스 구현 클래스();
		Calculator cal = new CalculatorImpl();
		// List list = new ArrayList();와 같다! 
		// 정미가족타입으로 정미 객체를 구성하겠다~
	

		
		/*
		// 주 업무 실행에 대한 테스트 (AOP 기법 적용 전)
		int add = cal.add(10, 20);
		System.out.println(add);
		
		int sub = cal.sub(10, 20);
		System.out.println(sub);
		
		int multi = cal.multi(10, 20);
		System.out.println(multi);
		
		int div = cal.div(10, 20);
		System.out.println(div);
		*/
		

		
		// 주 업무 실행에 대한 테스트 (AOP 기법 적용 후 )
		// 지금 상태에서 위와 같이 실행하면 주 업무만 하게 된다!
		
		/*
		 * Proxy.newProxyInstance(
				주 업무 실행 클래스에 대한 정보 전달				→ 정미
				, 주업무 실행 클래스의 인터페이스에 대한 정보 전달	→ 정미 패밀리
				, 보조 업무 실행 클래스에 대한 정보 전달  			→ 가영이
				);
		*/
		
		Calculator proxy = (Calculator)Proxy.newProxyInstance(
												cal.getClass().getClassLoader()				//-- 정미의 설계도를 넘김
												, cal.getClass().getInterfaces()			//-- 정미 패밀리 
												, new CalculatorProxy(cal)					//-- 가영이 객체 
												);	
		// 반환하는 객체(proxy) = Object (정미인척 할 수 있는 Object)
		
		
		int add = proxy.add(10, 20);
		// proxy는 사실 가영이인데 위를 통해 정미인척할수있게되었음~
		System.out.println(add);
		
		int sub = proxy.sub(10, 20);
		System.out.println(sub);
		
		int multi = proxy.multi(10, 20);
		System.out.println(multi);
		
		int div = proxy.div(10, 20);
		System.out.println(div);
		
		
	}
}
