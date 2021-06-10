/*======================================
■■■ 클래스와 인스턴스 ■■■
=======================================*/

// ○ 실습 문제
// 원의 넓이와 둘레 구하기

// 원의 넓이와 둘레를 구할 수 있는 클래스를 독립적으로(별도로) 생성한다.
// (클래스 명 : CircleTest) → CircleTest.java

// 원의 넓이 = 반지름 * 반지름 * 3.141592
// 원의 둘레 = 반지름 * 2 * 3.141592

// 실행 예)
// 반지름 입력 : xx

// >> 반지름이 xx인 원의
// >> 넓이 : xxx.xx
// >> 둘레 : xxx.xx
// 계속하려면 아무 키나...

import java.io.IOException;

public class Test071
{
	public static void main(String[] args) throws IOException
	{

		// 내가 한 풀이
		/*
		CircleTest ob = new CircleTest();
		double a,b;

		ob.input();
		a = ob.calArea();
		b = ob.calLen();
		ob.print(a,b);
		*/

		// 함께 한 풀이
		
		CircleTest ob = new CircleTest();

		ob.input();	
		double area = ob.calArea();
		double length = ob.calLength();

		// System.out.println("area : " +area);
		// System.out.println("length : " + length);

		ob.print(area,length);

	}
}
/*
[실행 결과]
반지름 입력 : 5

>> 반지름이 5인 원의
>> 넓이 : 78.54
>> 둘레 : 31.42
계속하려면 아무 키나 누르십시오 . . .
*/
