/*===============================
■■■ 실행 흐름의 컨트롤(제어문) ■■■
- 반복문 (while문) 실습
===============================*/

// 사용자로부터 임의의 두 정수를 입력받아
// 작은 수 부터 큰 수 까지의 합을 구하여
// 결과를 출력하는 프로그램을 구현한다.

// 실행 예)
// 첫 번째 정수 입력 : 10
// 두 번째 정수 입력 : 20
// >> 10 - 20 까지의 합 : xxxx
// 계속하려면 아무 키나...

// 첫 번째 정수 입력 : 10
// 두 번째 정수 입력 : 2
// >> 2 - 10 까지의 합 : xxxx
// 계속하려면 아무 키나...


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test051
{
	public static void main(String[] args) throws IOException
	{

		// 나의 인터넷이 한 풀이
		/*
		int num1, num2, n, result=0;
	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫 번째 정수 입력 : ");
		num1 = Integer.parseInt(br.readLine());

		System.out.print("두 번째 정수 입력 : ");
		num2 = Integer.parseInt(br.readLine());

		
		if (num1>num2)		// 작은 수를 앞으로 가져온다
		{
			num1 = num1^num2;
			num2 = num2^num1;
			num1 = num1^num2;
		}
		
		n = num1;			// 누적합 연산을 위해 빈공간에 num1값을 만들어준다

		while (n<=num2)
		{
			result += n;
			n++;
		}
		
		System.out.printf("%d - %d의 합 : %d\n ",num1,num2,result);

		// 한번 더 내 방식대로 풀어보기
		*/
			

	
		// 함께 한 풀이

		// ○ 주요 변수 선언

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n, su1, su2, result=0;
		//-- 루프변수, 첫번째 입력값, 두번째 입력값, 결과값(누적합 연산 결과)

		// ○ 연산 및 처리
		// ·사용자에게 안내 메세지 출력 및 입력값 담아내기
		System.out.print("첫 번째 정수 입력 : ");
		su1 = Integer.parseInt(br.readLine());

		System.out.print("두 번째 정수 입력 : ");
		su2 = Integer.parseInt(br.readLine());
		
		// ·누적합 연산에 들어가기 앞서
		//	 입력 받은 두 수의 크기 비교 및 자리 바꿈
		//	 즉, su1이 su2 보다 클 경우 두 수의 자리를 바꿀 수 있도록 처리
		if (su1>su2)
		{
			// 두 수의 자리 바꿈
			su1 = su1^su2;
			su2 = su2^su1;
			su1 = su1^su2;
		}
		
		n = su1;	// 위치 중요 (크기비교하고 자리바꾼 이후에 넣어!)

		while (n<=su2)
		{
			result += n;
			n++;
		}

		// ○ 결과 출력
		System.out.printf(">> %d - %d 까지의 합 : %d\n", su1,su2,result);
		
	}
}

/*
[실행결과]
첫 번째 정수 입력 : 50
두 번째 정수 입력 : 2
>> 2 - 50 까지의 합 : 1274
계속하려면 아무 키나 누르십시오 . . .

첫 번째 정수 입력 : 2
두 번째 정수 입력 : 5
>> 2 - 5 까지의 합 : 14
계속하려면 아무 키나 누르십시오 . . .
*/