/*======================================
■■■ 실행 흐름의 컨트롤 (제어문) ■■■
- continue
	→ (뒷부분 무시하고) + 계속해라
=======================================*/

// 실행 예)
/*
1 : 1
3 : 4
5 : 9
7 : 16
	:
	:
99 : 2500
결과 : 2500
*/

public class Test065
{
	public static void main(String[] args)
	{
		// 내가 한 풀이
		/*
		int n1,n2, sum=0;		// 변수1, 변수2, 누적합
		n1 = n2 = 1;

		while (n1<100)
		{
			System.out.printf("%d : %d\n", n1, n2);
			
			n1 += 2;
			n2 += n1;

		}
		
		int n=1, s=1, sum =0;
		
		do
		{
			System.out.printf("%d : %d\n", n, s);
			n += 2;
			s += n;
			continue;

		}
		while (n<100);
		*/


		// 함께 한 풀이
		int n=0 , s=0;		//-- 변수 누적합

		while (n<100)		// 0 ~ 99
		{
			n++;			// 1 ~ 100

			if (n%2==0)		// 짝수라면
				continue;	// (뒷부분 무시하고) + 계속해라
			
			s += n;							// 뒷부분
			System.out.println(n+":"+s);	// 뒷부분
		}
		System.out.println("결과 : "+s);
	

	

		
	}
}
/*
[실행결과]

*/
