/*======================================================
■■■ 변수와 자료형 ■■■
- Test010 클래스의 내용을 참고하여
  직사각형의 넓이와 둘레를 구하는 프로그램을 구현한다.
  · 가로 : 10, 세로 : 20
======================================================*/

// ※ 문제 인식 및 분석
//	  직사각형의 넓이 = 가로 * 세로
//	  직사각형의 둘레 = (가로 + 세로) * 2;

// 실행 예)
// 넓이 : xxxxx
// 둘레 : xxxxx
// 계속하려면 아무 키나 누르세요...


public class Test011{
	public static void main(String[] args)
	{
		// 내가 풀이한 내용
		/* 
		int a = 10;
		int b = 20;

		int area = a*b;
		int length = 2*(a+b);
	
		System.out.println("넓이 : " + area);
		System.out.println("둘레 : " + length);


		// System.out.println("넓이 : " + area + "\n둘레 : " + length);
		// System.out.printf("넓이 : %d\n둘레 : %d\n", area, length);
		*/

		
		// 함께 풀이한 내용

		// 주요 변수 선언
		int w = 10, h = 20;		//-- 가로 10, 세로 20
		int a, b;				//-- 넓이, 둘레

		// 연산 및 처리
		// 직사각형의 넓이 = 가로 * 세로
		a = w * h;
		// 직사각형의 둘레 = (가로 + 세로) * 2;
		b = (w + h) * 2;

		System.out.println("넓이 : " + a);
		System.out.println("둘레 : " + b);

	}
}

/* 
[실행 결과]
넓이 : 200
둘레 : 60
계속하려면 아무 키나 누르십시오 . . .
*/