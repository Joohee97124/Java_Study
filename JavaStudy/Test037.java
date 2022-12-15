/*===============================
■■■ 실행 흐름의 컨트롤(제어문) ■■■
- if문 실습
===============================*/

// 사용자로부터 임의의 정수를 세 개 입력받아
// 작은 수 부터 큰 수 순으로 출력하는 프로그램을 구현한다.
// 단, 입력 데이터를 한 번에 처리할 수 있도록 구성하며 (Scanner 사용)
// 『xor』 연산자를 활용하여 스왑 처리를 할 수 있도록 한다.

// 실행 예)
// 임의의 세 정수 입력 (공백 구분) : 54 23 31

// >> 정렬 결과 : 23 31 54
// 계속하려면 아무 키나...

import java.util.Scanner;

public class Test037
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		// 내가 짠 코드
		/*
		int n1,n2,n3;

		System.out.print("임의의 세 정수 입력 (공백 기준) : ");
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		n3 = sc.nextInt(); 

		if (n1<n2)	// 작을 때가 아니라 n1이 n2보다 클때 여야함!!!!!
		{
			// 두 정수 자리 바꿔주기
			n1 = n1^n2;
			n2 = n2^n1;
			n1 = n1^n2;

		}

		if (n2<n3)
		{
			// 두 정수 자리 바꿔주기
			n2 = n2^n3;
			n3 = n3^n2;
			n2 = n2^n3;

		}

		if (n1<n2)
		{
			// 두 정수 자리 바꿔주기
			n1 = n1^n2;
			n2 = n2^n1;
			n1 = n1^n2;
		}
		
		System.out.printf(">> 정렬 결과 : %d %d %d\n", n1,n2,n3);
		*/


		// 함께 한 풀이

		int a, b, c;

		System.out.print("임의의 세 정수 입력 (공백 기준) : ");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();

		if (a>b)
		{
			a = a^b;
			b = b^a;
			a = a^b;
		}

		if (b>c)
		{
			b = b^c;
			c = c^b;
			b = b^c;
		}
		
		if (a>b)
		{
			a = a^b;
			b = b^a;
			a = a^b;
		}

		System.out.printf("\n>> 정렬 결과 : %d %d %d\n",a,b,c);

	}
}

/*
[실행 결과]
임의의 세 정수 입력 (공백 기준) : 11 12 13

>> 정렬 결과 : 11 12 13
계속하려면 아무 키나 누르십시오 . . .
*/