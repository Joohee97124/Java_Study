/*=================================================
■■■ 자바 기본 프로그래밍 ■■■
- 변수와 자료형
- 자바의 기본 입출력 
=================================================*/

// ※ 삼각형의 넓이 = 밑변 * 높이 / 2

// 삼각형의 밑변의 길이와 높이를 사용자로부터 입력 받아
// 삼각형의 넓이를 구하는 프로그램을 구현한다.

// 실행 예)
// ■ 삼각형의 넓이 구하기 ■
// - 삼각형의 밑변 입력 : 3
// - 삼각형의 높이 입력 : 5
// >> 밑변이 3, 높이가 5인 삼각형의 넓이 : xxxx
// 계속하려면 아무 키나 누르세요...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Test013
{
	public static void main(String[] args) throws IOException
	{
		
		// 내가 풀이 한 내용
		/*
		System.out.println("■ 삼각형의 넓이 구하기 ■");

		

		System.out.print("- 삼각형의 밑변 입력 : " );
		BufferedReader br1 = new BufferedReader (new InputStreamReader(System.in));

		int a;		//-- a = 밑변
		a = Integer.parseInt(br1.readLine());

		

		System.out.print("- 삼각형의 높이 입력 : " );
		BufferedReader br2 = new BufferedReader (new InputStreamReader(System.in));

		int b;		//-- b = 높이
		b = Integer.parseInt(br2.readLine());

		

		int area;	//-- c = 넓이
		area = (a*b)/2;

	

		System.out.printf(">>> 밑변이 %d, 높이가  %d인 삼각형의 넓이 : %d\n", a, b, area);



		
		// 1 밑변과 높이 입력받기
		// 2 입력받은거 변수로 저장하기
		// 3 삼각형 넓이 식 구하기 (변수로)
		// 4 >>에 2번 대입하기
		*/



		// 함께 한 풀이 내용


		// 외부로부터 데이터를 입력받도록 처리하기 위해서
		// BufferedReader 인스턴스 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// import 구문 & throw IOE 잊지말자

		// 주요 변수 선언
		int underLength, height;		//-- 밑변, 높이
		double area;					//-- 넓이 check~!!
	

		// 연산 및 처리
		// ① 사용자에게 안내 메세지 출력
		System.out.println("■ 삼각형의 넓이 구하기 ■");
		System.out.print("- 삼각형의 밑변 입력 : ");			// ln 아니다

		// ② 사용자가 입력한 데이터(밑변)를 
		//    정수 형태로 변환한 후 
		//    변수 underLength 에 담아내기
		underLength = Integer.parseInt(br.readLine());

		// ③ 다시 사용자에게 안내 메세지 출력
		System.out.print("- 삼각형의 높이 입력 : ");
		
		// ④ 사용자가 입력한 데이터(높이)를
		//    정수 형태로 변환한 후
		//    변수 height에 담아내기
		height = Integer.parseInt(br.readLine());		// readLine() : 개행을 해줌
		//							"1200"			"홍길동"은 에러 (Integer.parseInt , int형으로 복원하기 때문)
		//		---------------------------------
		//			1200
		
		// ⑤ 삼각형의 넓이를 구하는 연산 처리
		// 삼각형의 넓이 = 밑변 * 높이 / 2
		// area = underLength * height / 2
		//		정수형		 정수형
		//				정수		/ 2
		// → 7이 area에서 7.0 으로 됨 (7.5가 아니라ㅠ)
		area = underLength * height / 2.0;
		//-- 실수 자료형이 결과값으로 나오는 과정에서
		//   실수 기반의 연산이 필요한 상황이다.
		//   정수형 『2』가 아닌 실수형 『2.0』으로 나눗셈 연산을 수행하게 되면
		//   이 연산은 실수 기반으로 처리된다.


		// 결과 출력
		System.out.println();	// ()를 비워두고 쓰면 개행시켜준다.
		// System.out.print();	// 이건 오류,,
		System.out.printf(">> 밑변이 %d, 높이가 %d인 삼각형의 넓이 : %.2f\n",underLength, height, area);


	}
}

/*
[실행 결과]
■ 삼각형의 넓이 구하기 ■
- 삼각형의 밑변 입력 : 3
- 삼각형의 높이 입력 : 5

>> 밑변이 3, 높이가 5인 삼각형의 넓이 : 7.50
계속하려면 아무 키나 누르십시오 . . .
*/