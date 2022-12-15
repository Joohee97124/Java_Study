/*======================================
■■■ 자바의 주요(중요) 클래스 ■■■
- Wrapper 클래스
======================================*/


public class Test129
{
	public static void main(String[] args)
	{
		byte b = 3;
		int i = 256;

		Byte b2 = new Byte(b);				//-- boxing
		Integer i2 = new Integer(i);		//-- boxing

		System.out.println(b2);				//-- 3
		System.out.println(i2);				//-- 256

		print(b2);
		print(i2);

	}
	
	/*
	// 오버로딩
	static void print(Byte b)
	{
		//...
	}

	static void print(Integer i)
	{
		//...
	}
	*/
	

	// Object : 써도 ㄱㅊ 넘겨받은 n이 객체형식이면 다 돼~~
	// 어떤 객체를 넘겨주던지 ㄱㅊㄱㅊ => 데이터의 안정성이 확보 X
	// 아무거나 들어있는 통 = 머가 들었는지 확인하기 전까지는 주의사항도 아 ㄹ수 없음,,

	// Number : 

	// ※ java.lang.Number 클래스(추상클래스) 는
	//	  모든 Wrapper 클래스의 부모 클래스 (슈퍼클래스, 상위클래스)이다.
	//	  b2, i2 자료형이 Number n에 넘어오면서
	//	  업 캐스팅이 자동적으로 일어나게 된다. (Auto-Boxing 선행)

	// static void print(데이터타입 변수이름)
	static void print(Number n)
	{
		System.out.println(n);
	}

}