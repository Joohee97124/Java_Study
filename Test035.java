/*===============================
■■■ 실행 흐름의 컨트롤(제어문) ■■■
- if문 실습
===============================*/

// 사용자로부터 임의의 정수를 입력받아
// 입력받은 정수가 2의 배수인지, 3의 배수인지
// 2와 3의 배수인지, 2와 3의 배수가 아닌지 판별하여
// 결과를 출력하는 프로그램을 구현한다.

// 실행 예)
// 임의의 정수 입력 : 8
// >> 8 → 2의 배수~!!!
// 계속하려면 아무 키나...

// 임의의 정수 입력 : 9
// >> 9 → 3의 배수~!!!
// 계속하려면 아무 키나...

// 임의의 정수 입력 : 6
// >> 6 → 2와 3의 배수~!!!
// 계속하려면 아무 키나...

// 임의의 정수 입력 : 11
// >> 11 → 2와 3의 배수 아님~!!!
// 계속하려면 아무 키나...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test035
{
	public static void main(String[] args) throws IOException
	{
		// 내가 한 풀이
		/*
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

		int num; 

		System.out.print("임의의 정수 입력 : ");
		num = Integer.parseInt(br.readLine());

		if (num%6 == 0)
		{
			System.out.printf("%d → 2와 3의 배수~!!\n",num);
		}
		else if (num%3 == 0)
		{
			System.out.printf("%d → 3의 배수~!!\n",num);
		}
		else if (num%2 == 0)
		{
			System.out.printf("%d → 2의 배수~!!\n",num);
		}
		else 
		{
			System.out.printf("%d → 배수아님~!!\n",num);
		}
		*/

		// 함께 한 풀이
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

		int n;

		System.out.print("임의의 정수 입력 : ");
		n = Integer.parseInt(br.readLine());
		
		/* (X)
		if (n%2==0)
		{
			System.out.println(">>" + n + " → 2의 배수~!!!!");
		}
		else if (n%3 ==0)
		{
			System.out.println(">>" + n + " → 3의 배수~!!!!");
		}
		else if (n%2==0 && n%3 ==0)
		{
			System.out.println(">>" + n + " → 2와 3의 배수~!!!!");
		}
		else if (n!%2==0 && n!%3 ==0)
		{
			System.out.println(">>" + n + " → 2와 3의 배수가 아님~!!!!");
		}
		else
		{
			System.out.println(">>판별이 불가능한 상황");
		}
		//※ 위와 같은 상황에서는 2와 3의 배수라는 (공통 배수) 조건식에는
		//   만족하는 데이터가 분기 될 수 없는 상황이다. check~!!
		*/

		if (n%2==0 && n%3 ==0)
		{
			System.out.println(">>" + n + " → 2와 3의 배수~!!!!");
		}
		else if (n%2==0)
		{
			System.out.println(">>" + n + " → 2의 배수~!!!!");
		}else if (n%3 ==0)
		{
			System.out.println(">>" + n + " → 3의 배수~!!!!");
		}
		else if (n%2!=0 && n%3!=0)
		{
			System.out.println(">>" + n + "→ 2와 3의 배수 아님~!!!");
		}
		else
		{
			System.out.println(">>판별이 불가능한 상황");
		}



	}
}

/*
[실행 결과]
임의의 정수 입력 : 2
>>2 → 2의 배수~!!!!
계속하려면 아무 키나 누르십시오 . . .

임의의 정수 입력 : 6
>>6 → 2와 3의 배수~!!!!
계속하려면 아무 키나 누르십시오 . . .

임의의 정수 입력 : 3
>>3 → 3의 배수~!!!!
계속하려면 아무 키나 누르십시오 . . .

임의의 정수 입력 : 11
>>11→ 2와 3의 배수 아님~!!!
계속하려면 아무 키나 누르십시오 . . .
*/