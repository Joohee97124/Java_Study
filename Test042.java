/*===============================
■■■ 실행 흐름의 컨트롤(제어문) ■■■
- switch문 실습
===============================*/

// 사용자로부터 임의의 두 정수와 연산자를 입력받아
// 해당 연산의 처리 결과를 출력하는 프로그램을 구현한다.
// 단, switch 문을 활용하여 처리할 수 있도록 하며,
// 연산 결과는 편의상 정수 형태로 처리한다.

// 실행 예)
// 첫 번째 정수 입력 : 10
// 두 번째 정수 입력 : 31
// 연산자 입력 (+ - * /) : +

// >> 10 + 31 = 41
// 계속하려면 아무 키나 누르세요...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test042
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 내가 한 풀이
		/*
		int n1, n2, result;
		result = 0;
		char op;

		System.out.print("첫 번째 정수 입력 : ");
		n1 = Integer.parseInt(br.readLine());

		System.out.print("두 번째 정수 입력 : ");
		n2 = Integer.parseInt(br.readLine());

		System.out.print("연산자 입력 (+ - * /) : ");
		op = (char)System.in.read();

		switch (op)
		{
			case '+' : op = '+';
					   result = n1 + n2; break;
			case '-' : op = '-';
				       result = n1 - n2; break;
			case '*' : op = '*';
					   result = n1 * n2; break;
			case '/' : op = '/'; 
					   result = n1 / n2; break;
			default : System.out.println("잘못 입력하셨습니다.");
		}

		System.out.printf(">> %d %c %d = %d\n",n1,op,n2,result);
		*/


		// 함께 한 풀이
		
		int a, b, result;
		char op;

		System.out.print("첫 번째 정수 입력 : ");
		a = Integer.parseInt(br.readLine());

		System.out.print("두 번째 정수 입력 : ");
		b = Integer.parseInt(br.readLine());

		System.out.print("연산자 입력 (+ - * /) : ");
		op = (char)System.in.read();
		

		/*
		if (op == '+')
		{...
		}
		*/

	
		// jdk 1.5 부터 조건에 문자타입 (char) 이 들어갈 수 있도록 지원된다.
		// jdk 1.7 부터는 문자열 (String) 까지 들어갈 수 있음
		switch (op)
		{
			case '+' : result = a+b; break;
			case '-' : result = a-b; break;
			case '*' : result = a*b; break;
			case '/' : result = a/b; break;
			
			default : return;	//-- 메소드 종료 → main()메소드 종료 의미 → 프로그램 종료 
		}


		// ※ 『return』 : 1. 값의 반환 ex) return 10; 
		//				   2. 메소드의 종료
		

		System.out.println();
		System.out.printf(">> %d %c %d = %d\n",a,op,b,result);

	}
}
/*
[실행 결과]
첫 번째 정수 입력 : 5
두 번째 정수 입력 : 3
연산자 입력 (+ - * /) : +

>> 5 + 3 = 8
계속하려면 아무 키나 누르십시오 . . .

첫 번째 정수 입력 : 5
두 번째 정수 입력 : 3
연산자 입력 (+ - * /) : ;
계속하려면 아무 키나 누르십시오 . . .
*/