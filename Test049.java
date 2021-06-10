/*===============================
■■■ 실행 흐름의 컨트롤(제어문) ■■■
- 반복문 (while문) 실습
===============================*/

// 1 * 2 * 3 * 4 * ... * 10 → 누적곱


// 실행 예)
// 연산 결과 : xxxx
// 계속하려면 아무 키나....

public class Test049
{
	public static void main(String[] args)
	{
		// 내가 한 풀이
		/*
		int n=1, sum=1;

		while (n<=10)
		{
			sum *= n;
			n++;
		}

		System.out.printf("연산결과 : %d\n", sum);
		*/


		// 함께 한 풀이

		int n =0, result = 1;	// CHECK~!!!
								// 누적곱을 담을 변수 ... 1로 초기화~!!

		while (n<10)
		{
			n++;
			result *= n;	// 누적곱 연산
		}
		
		System.out.println("연산 결과 :" + result);

	}
}

/*
[실행 결과]
연산결과 : 3628800
계속하려면 아무 키나 누르십시오 . . .
*/