/*======================================
■■■ 실행 흐름의 컨트롤 (제어문) ■■■
- 반복문 (for문) 실습
- 별찍기 연습
=======================================*/

// ○ 과제
// 다음과 같은 내용이 출력될 수 있도록
// 반복문의 중첩 구문을 작성하여 프로그램을 구현한다.

/*

	*
   **
  ***
 ****
*****

*/


public class Test060
{
	public static void main(String[] args)
	{
		int i,j,k;
		
		for (i=1; i<=5 ; i++)					// 줄
		{
			for (j=5; j>i ; j--)				// 빈칸 출력 (4→3→2→1)
			{
				System.out.print(" ");
			}
			for (k=1;k<=i ; k++)				// * 출력 (1→2→3→4→5)
			{
				System.out.print("*");
			}
			System.out.println();				// 한 줄이 끝나면 개행	
		}

	}
}