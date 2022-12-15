/*===============================
■■■ 실행 흐름의 컨트롤(제어문) ■■■
- 반복문 (for문) 실습
===============================*/

// 1부터 100까지의 정수 중에서
// 4의 배수만 출력하는 프로그램을 구현한다.
// 단, for 반복문을 활용할 수 있도록 한다.
// 한 라인에 5개씩 출력할 수 있도록 한다.

// 실행 예)
//	4   8 12  16  20 
//  24 28 32  36  40
// ...
// 계속하려면 아무 키나..

public class Test057
{
	public static void main(String[] args)
	{	

		// 내가 한 풀이
		/*
		int n ;

		for (n=1; n<=100 ; n++)
		{
			if (n%4 == 0)
			{
				System.out.printf("%d ",n);
			}
			else if (n%20 == 0 )
			{
			}
			System.out.println();
		}
		*/


		// 함께 한 풀이
		
		for (int n=4; n<=100 ; n+=4 )		// n의 시작이 4니까 100이하
		{
			System.out.printf("%4d",n);
			if (n%(4*5)==0)					//-- n이 (4*5)의 배수일 때
			{
				System.out.println();		//-- 개행해라
			}
			// System.out.printf("%4d ",n);	//-- 얘가 여기오면 20,40...이 개행되서 내려감
		}

	}
}
/*
[실행 결과]
  4   8  12  16  20
  24  28  32  36  40
  44  48  52  56  60
  64  68  72  76  80
  84  88  92  96 100
계속하려면 아무 키나 누르십시오 . . .
*/