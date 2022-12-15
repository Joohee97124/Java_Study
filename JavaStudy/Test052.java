/*===============================
■■■ 실행 흐름의 컨트롤(제어문) ■■■
- 반복문 (while문) 실습
===============================*/

// ○ 과제
// 사용자로부터 임의의 정수를 입력받아
// 1부터 그 수까지의 전체 합과, 짝수의 합과, 홀수의 합을
// 각각 결과값으로 출력하는 프로그램을 구현한다.

// 실행 예)
// 임의의 정수 입력 : 284
// >> 1 ~ 284 까지 정수의 합 : xxxx
// >> 1 ~ 284 까지 짝수의 합 : xxxx
// >> 1 ~ 284 까지 홀수의 합 : xxxx
// 계속하려면 아무 키나...


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test052
{
	public static void main(String[] args) throws IOException
	{
		int n, result, even, odd;
		result = even = odd =0;

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

		System.out.print("임의의 정수 입력 : ");
		n = Integer.parseInt(br.readLine());
		

		int m =0;			// 빈 공간 m 선언 후 0으로 초기화

		while (m<=n)		// m<n이면 (n까지)
		{
			result += m;	// 정수 누적합
			
			if (m%2 == 0)	// 짝수 누적합
			{
				even += m;
			}
			else			// 홀수 누적합
			{
				odd += m;
			}

			m++;			// m++ 
			
		}


		System.out.printf(" >> 1 ~ %d 까지 정수의 합 : %d \n", n, result);
		System.out.printf(" >> 1 ~ %d 까지 짝수의 합 : %d \n",n,even);
		System.out.printf(" >> 1 ~ %d 까지 홀수의 합 : %d \n",n, odd);

		
	}
}
/*
[실행 결과]
임의의 정수 입력 : 17
 >> 1 ~ 17 까지 정수의 합 : 153
 >> 1 ~ 17 까지 짝수의 합 : 72
 >> 1 ~ 17 까지 홀수의 합 : 81
계속하려면 아무 키나 누르십시오 . . .
*/