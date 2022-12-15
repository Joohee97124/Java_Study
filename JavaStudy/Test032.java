/*===============================
■■■ 실행 흐름의 컨트롤(제어문) ■■■
- if문 실습
===============================*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test032
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n;

		System.out.print("임의의 정수 입력 : ");
		n = Integer.parseInt(br.readLine());
		
		// (X) 0나누기2 의 나머지도 0,,
		/*
		if (n%2==0)
		{
			System.out.println(n + " → 짝수");
		}
		else if (n==0)
		{
			System.out.println(n + " → 영");
		}
		else
		{
			System.out.println(n + " → 홀수");
		}
		*/
		
		// (O) 
		/*
		if (n%2!=0)
		{
			System.out.println(n + " → 홀수");
		}
		else if (n==0)
		{
			System.out.println(n + " → 영");
		}
		else
		{
			System.out.println(n + " → 짝수");
		}
		*/

		/*
		if (n==0)
		{
			System.out.println(n + " → 영");
		}
		else if (n%2==0)
		{
			System.out.println(n + " → 짝수");
		}
		else
		{
			System.out.println(n + " → 홀수");
		}
		// 짝수의 조건보다 영의 조건이 먼저 와야한다.
		// else 홀수 부분이 빠져도 문법적으로느 문제가 없음 (홀수가 빠질 뿐)
		*/
		
		/* (O) 
		if (n==0)
		{
			System.out.println(n + " → 영");
		}
		else if (n%2==0)
		{
			System.out.println(n + " → 짝수");
		}
		else if (n%2 != 0 )
		{
			System.out.println(n + " → 홀수");
		}
		{
			System.out.println("판정이 불가능한 상황입니다");
		}
		*/


		System.out.print("아이스크림 종류 선택 (1.딸기, 2.포도) : ");
		n = Integer.parseInt(br.readLine());
		
		/* (O) 하지만 ...
		if (n==1)
		{
			System.out.println("딸기 아이스크림을 선택하셨습니다~");
		}
		else
		{
			System.out.println("포도 아이스크림을 선택하셨습니다~");
		}
		*/

		if (n==1)
		{
			System.out.println("딸기 아이스크림을 선택하셨습니다~");
		}
		else if(n==2)
		{
			System.out.println("포도 아이스크림을 선택하셨습니다~");
		}
		else
		{
			System.out.println("포도 딸기 이외의 아이스크림 선택 불가~");
		}


	}
}
