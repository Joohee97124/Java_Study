/*======================================
■■■ 클래스와 인스턴스 ■■■
- 클래스 개념 적용 및 클래스 설계 실습
=======================================*/

// 사용자로부터 임의의 정수를 입력받아
// 1부터 입력받은 수 까지의 합을 연산하여
// 결과를 출력하는 프로그램을 구현한다.

// 단, 클래스와 인스턴스의 개념을 활용하여 처리할 수 있도록 한다.
// 또한, 입력 처리 과정에서 BufferedReader의 readLine()을 사용하며,
// 입력받은 데이터가 1보다 작거나 1000보다 큰 경우
// 다시 입력받을 수 있는 처리를 포함하여 프로그램을 구성할 수 있도록 한다.

// 실행 예)
// 임의의 정수 입력 (1~1000) : 1002
// 임의의 정수 입력 (1~1000) : -20
// 임의의 정수 입력 (1~1000) : 100
// >> 1~100까지의 합 : 5050
// 계속하려면 아무 키나...

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Hap
{
	// 내가 한 풀이
	/*

	// 입력 받는 변수 선언
	int n, i=0;
	int sum=0;

	// 정수 입력 받는 메소드
	void input()
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("임의의 정수 입력 (1~1000) :");
		n = sc.nextInt();
	}

	// 반복하는 메소드
	void again()
	{
		Scanner sc = new Scanner(System.in);

		while (true)
		{
			if (n<0 || n>1000)
			{
			System.out.print("임의의 정수 입력 (1~1000) :");
			n = sc.nextInt();
			}
			else
				return;		//-- 메소드 종료
		}
	}
	
	

	// 누적합 연산 메소드
	void add()
	{
		while (i<=n)
		{
			sum += i;
			i++;
		}
	}


	// 출력 메소드
	void print()
	{
		System.out.printf("<< 1 ~ %d 까지의 합 : %d\n",n,sum);
	}
	*/


	// 함께 한 풀이
	
	// ○ 주요 변수 선언 (사용자의 입력값을 담아둘 변수)
	int su;

	// ○ 입력 메소드 정의
	void input() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do
		{
			System.out.print("임의의 정수 입력(1~1000):");
			su = Integer.parseInt(br.readLine());
		}
		while (su<1||su>1000);
	}

	// ○ 연산 메소드 정의
	int calculate()
	{
		int result =0;
		
		for (int i=1;i<=su;i++ )
			result += i;

		return result;
	}

	// ○ 결과 출력 메소드 정의
	// >> 1 ~ 100 까지의 합 : 5050
	void print(int sum)
	{
		System.out.printf(">> 1 ~ %d 까지의 합 : %d\n", su, sum);
	}

}


public class Test072
{
	public static void main(String[] args) throws IOException
	{
		// 내가 한 풀이
		/*

		Hap ob = new Hap();
		int a;

		ob.input();		//-- 맨 처음에 정수를 입력받고
		ob.again();		//-- 정수가 범위안에 들어오지 않으면 무한으로 입력받기 , 
						//	 범위 안에 들어오면 메소드 종료
		ob.add();		//-- 범위 안에 들어올 때 누적합 연산
		ob.print();		//-- 누적합 출력
		*/


		// 함께 한 풀이

		// Hap 클래스 인스턴스 생성
		Hap ob = new Hap();
		
		// 생성한 인스턴스를 통해 입력 메소드 호출! → throws IOException 처리
		ob.input();
		
		// 생성한 인스턴스를 통해 연산 메소드 호출! → int형 결과값 반환 → 받아낼 수 있는 처리 !
		int s = ob.calculate();
		
		// 생성한 인스턴스를 통해 출력 메소드 호출! → 매개변수 전달 (=누적합)
		ob.print(s);
		


	}
}