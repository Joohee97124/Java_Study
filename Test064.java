/*======================================
■■■ 실행 흐름의 컨트롤 (제어문) ■■■
- break
	→ 멈춘다 + (그리고 빠져나간다)
=======================================*/

// 다음과 같은 처리가 이루어지는 프로그램을 구현한다.
// 단, 입력받는 정수는 1 ~ 1000 범위 안에서만
// 가능하도록 작성한다.

// 실행 예)
// 임의의 정수 입력 (1~1000) : -10
// 임의의 정수 입력 (1~1000) : 0
// 임의의 정수 입력 (1~1000) : 2021
// 임의의 정수 입력 (1~1000) : 10
// >> 1 ~ 10 까지의 합 : 55
// 계속하시겠습니까?(Y/N) : y

// 임의의 정수 입력 (1~1000) : 100
// >> 1 ~ 100 까지의 합 : 5050
// 계속하시겠습니까?(Y/N) : N
// 계속하려면 아무 키나...
 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test064
{
	public static void main(String[] args) throws IOException
	{

		// 내가 (소현언니가) 한 풀이
		/*
		int n;
		int result =0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		do
		 {
         System.out.print("임의의 정수 입력(1~1000) : ");
         n = Integer.parseInt(br.readLine());
		 }
		 while (1000<=n || n<=1);

		int a=1;

		while (a<=n)
		{
			result += a;
			a++;
		}

		System.out.printf(" >> 1 ~ %d 까지의 합 : %d\n",n,result);
		System.out.printf(" 계속하시겠습니까?(Y/N) : ");
		
		int j;
		j = (char)System.in.read();
		
		if (j=='Y'||j=='y')
		{
			System.out.print("임의의 정수 입력 (1~1000) : ");
		}
		else
			return;
		*/
			


		// 함께 한 풀이


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n, s=0, i;		//-- 사용자 입력값, 누적합, 루프변수
		char ch;			//-- 계속 여부 입력값 
		

		while (true)		//-- 무한 루프(반복)
		{
			do
			{
				System.out.print("임의의 정수 입력 (1~1000) : ");
				n = Integer.parseInt(br.readLine());				// " \r  \n "
			}
			while (n<1 || n>1000);		// 반복을 수행할 조건 (OR) 
			
			// 초기화 위치 check~!!! (얘 없으면 똑같은 값 넣었을 떄 합이 2배가 됨)
			s=0; 

			for (i=1;i<=n;i++ )
			{
				s += i;
			}
			
			// 테스트
			// System.out.println("누적합 :"+ s);
			System.out.printf("\n >> 1 ~ %d 까지의 합 : %d\n",n,s);

			System.out.print("계속하시겠습니까?(Y/N) : ");
			ch = (char)System.in.read();		// y + \r + \n	(
			
			// 테스트
			// System.out.println("계속여부 : "+ch);

			
			// ch == 'n' ch == 'N' y가 아니냐 -> 어떤 키든지 중단 (y만 눌러야 ㄱㄱ)
			// 입력값이 소문자  y가 아니다. 입력값이 대문자 Y가 아니다.
			//	→ ch != 'y				    →	ch != 'Y'

			// SCE
			if (ch !='y' && ch !='Y')	// y도 아니면서 Y도 아니어야한다 (&&)
			{
				// 반복문 → 『while(true)』 을 빠져나갈 수 있는 코드 작성 필요
				//-- 위와 같은 의사 표현을 했다면
				// 그동안 수행했던 반복문을 멈추고 빠져나가야한다.
				break; 
				//-- 멈춘다 + (그리고 빠져나간다) check~!!

			}

			//  엔터값(\r + \n) 추가 처리
			System.in.skip(2);

		}//end while(true)
		
		
		
		


	}//end main()
}//end class Test064


/*
[실행 결과]

임의의 정수 입력 (1~1000) : -1
임의의 정수 입력 (1~1000) : 1200
임의의 정수 입력 (1~1000) : 100

 >> 1 ~ 100 까지의 합 : 5050
계속하시겠습니까?(Y/N) : y
임의의 정수 입력 (1~1000) : 100

 >> 1 ~ 100 까지의 합 : 5050
계속하시겠습니까?(Y/N) :
*/