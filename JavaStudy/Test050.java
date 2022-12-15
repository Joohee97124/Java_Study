/*===============================
■■■ 실행 흐름의 컨트롤(제어문) ■■■
- 반복문 (while문) 실습
===============================*/

// 사용자로부터 임의의 정수를 입력받아
// 입력받은 정수가... 소수인지 아닌지를 판별하여
// 결과를 출력하는 프로그램을 구현한다.

// 실행 예)
// 임의의 정수 입력 : 10
// 10 → 소수 아님
// 계속하려면 아무 키나...

// 임의의 정수 입력 : 11
// 11 → 소수 
// 계속하려면 아무 키나...

// ※ 소수  = 1 또는 자기 자신의 값 이외의 어떤 수로도 나눌 수 없는 값
//			  단, 1은 소수가 아님


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test050
{
	public static void main(String[] args) throws IOException
	{
		// 내가 한 풀이
		/*
		int n;

		while (true)
		{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("임의의 정수 입력 : ");
		n = Integer.parseInt(br.readLine());
		
		if (n ==2 || n==3 || n==5 || n==7)
		{
			System.out.printf("%d → 소수\n",n);
		}
		else if (n%2 == 0)
		{
			System.out.printf("%d → 소수 아님\n", n);
		}
		else if (n%3 == 0)
		{
			System.out.printf("%d → 소수 아님\n", n);
		}
		else if (n%5 == 0)
		{
			System.out.printf("%d → 소수 아님\n", n);
		}
		else if (n%7 == 0)
		{
			System.out.printf("%d → 소수 아님\n", n);
		}

		else
			System.out.printf("%d → 소수\n",n);

		break;

		}
		*/


		// 함께 한 풀이
		
		// ○ 주요 변수 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num;		//-- 사용자가 입력하는 임의의 정수를 담아 둘 변수
		
		// ○ 연산 및 처리
		System.out.print("임의의 정수 입력 : ");
		num = Integer.parseInt(br.readLine());		//89

		// 2  3 4 5 ... 88 까지 나눠보기
		// ↑           

		int n = 2;		//-- 사용자의 입력값을 대상으로
						//   나눗셈 연산을 수행할 변수 (1씩 증가 예정)

		// String temp = "소수다~";
		boolean flag = true;		//-- 소수다

		while (n<num)		// n이 num이 되는게 들어가면 안돼
		{
			if (num%n==0)
			{
				flag = false;		//-- 소수 아니다
				// System.out.println(n);
				// break;			//-- while문 탈출
			}

			n++;

		}

		// temp = "소수 아님";
		//flag = flalse;


		// ○ 결과 출력
		// (출력 전에 수행해야 할 추가 확인 → 1인지 여부에 대한 확인
		//	소수다 && 1이 아니다
		//	→ 최종적인 결론으로 소수다
		//  그렇지 않으면
		//	→ 최종적인 결론으로 소수 아니다

		if (flag && num!=1)				//-- flag는 이미 true
		{
			System.out.printf("%d → 소수!\n", num);

		}
		else
		{
			System.out.printf("%d → 소수아님!\n",num);
		

		}

	}
}

/*
[실행 결과]
임의의 정수 입력 : 2
2 → 소수!
계속하려면 아무 키나 누르십시오 . . .

임의의 정수 입력 : 10
10 → 소수아님!
계속하려면 아무 키나 누르십시오 . . .
*/