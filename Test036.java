/*===============================
■■■ 실행 흐름의 컨트롤(제어문) ■■■
- if문 실습
===============================*/

// 사용자로부터 임의의 정수를 세 개 입력받아
// 작은 수 부터 큰 수 순으로 출력하는 프로그램을 구현한다.

// 실행 예)
// 첫 번째 정수 입력 : 45
// 두 번째 정수 입력 : 81
// 세 번째 정수 입력 : 13

// >> 정렬 결과 : 13 45 81
// 계속하려면 아무 키나...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test036
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		

		/*
		// 내가 한 풀이

		int n1,n2,n3;

		System.out.print("첫 번째 정수 입력 : ");
		n1 = Integer.parseInt(br.readLine());

		System.out.print("두 번째 정수 입력 : ");
		n2 = Integer.parseInt(br.readLine());

		System.out.print("세 번째 정수 입력 : ");
		n3 = Integer.parseInt(br.readLine());
		
		
		// 작은 수를 중심으로 찾기
		if (n1<n2 && n1<n3)
		{
			if(n2<n3)
				System.out.printf("%d %d %d\n",n1,n2,n3);
			else
				System.out.printf("%d %d %d\n",n1,n3,n2);
		}
		else if (n2<n1 && n2<n3)
		{
			if(n1<n3)
				System.out.printf("%d %d %d\n",n2,n1,n3);
			else
				System.out.printf("%d %d %d\n", n2,n3,n1);
		}
		else if (n3<n1 && n3<n2)
		{
			if (n1<n2)
				System.out.printf("%d %d %d\n",n3,n1,n2);		
			else
				System.out.printf("%d %d %d\n",n3,n2,n1);
		}
		else
			System.out.printf("잘못 입력하셨습니다.");
		*/


		// 함께 한 풀이

		int a, b, c;		//-- 사용자가 입력하는 임의의 정수를 담을 변수
		int temp;			//- 임시 저장 변수 (빈 컵)

		System.out.print("첫 번째 정수 입력 : ");
		a = Integer.parseInt(br.readLine());

		System.out.print("두 번째 정수 입력 : ");
		b = Integer.parseInt(br.readLine());

		System.out.print("세 번째 정수 입력 : ");
		c = Integer.parseInt(br.readLine());
		

		// 2 2 2 | 3 2 1	| 2 1 3	 | 3 1 2	| 1 3 2	| 1 2 3 
		//		 | 2 3 1	| 1 2 3	 | 1 3 2	| 1 2 3
		//       | 2 1 3			 | 1 2 3 
		//		 | 1 2 3	

		
		if (a>b)		// ① 첫 번째 정수가 두 번째 정수보다 크다면....
		{
			// 두 정수(a와 b)의 자리를 바꾼다. 
			temp = a;
			a = b;
			b = temp;
		}

		if(b>c)	// ② 두 번째 정수가 세 번째 정수보다 크다면...
		{
			// 두 정수(b와 c)의 자리를 바꾼다.
			temp = b;
			b = c;
			c = temp;
		}

		if (a>b)	// ③ 첫 번째 정수가 두 번째 정수보다 크다면...
		{
			// 두 정수(a와 b)의 자리를 바꾼다.
			temp = a;
			a = b;
			b = temp;
		}
		// 이는 각각의 독립적인 단독 if여야 함 (else if로 묶이면 3개 전체를 수행하지 않기 때문)

		System.out.printf(">> 정렬 결과 : %d %d %d\n", a, b, c);	
		// if문에서 자리를 바꿔주니까 그냥 abc순서대로 넣으면 돼
	}
}
/* 
[실행 결과]
첫 번째 정수 입력 : 45
두 번째 정수 입력 : 8
세 번째 정수 입력 : 13
>> 정렬 결과 : 8 13 45
계속하려면 아무 키나 누르십시오 . . .
*/