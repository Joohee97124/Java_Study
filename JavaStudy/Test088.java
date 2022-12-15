/*=====================================
     ■■■ 배열 (array) ■■■
	 - 배열의 배열 (2차원 배열)
=====================================*/

// 배열의 배열(다차원 배열)을 활용하여
// 다음과 같은 데이터를 요소로 취하는 배열(5x5)을 구성하고
// 그 결과를 출력하는 프로그램을 구현한다.

// 실행 예)
/* 
 1  2  3  4  5		→ i=0
 2  3  4  5  6		→ i=1
 3  4  5  6  7		→ i=2
 4  5  6  7  8		→ i=3
 5  6  7  8  9		→ i=4
계속하려면 아무 키나 …
*/

public class Test088
{ 
	public static void main(String[] args)
	{
		/* [내가 한 풀이]
	
		int n=5;								// 변수 선언

		int [][] arr1 = new int [5][5];			// 2차원 배열 선언 

		// 배열초기화
			
		for (int i=0;i<arr1.length ;i++ )
		{
			n = n-4;

			for (int j=0;j<arr1.length ; j++)
			{
				arr1[i][j] = n;
				n++;
			}
		}

		// 출력구문

		for (int i=0;i<arr1.length; i++)
		{
			for (int j=0;j<arr1.length ; j++ )
			{
				System.out.printf("%s", arr1[i][j]);
			}
			System.out.println();
		}
		*/

		// [같이 풀이]
		// 배열의 배열 선언 및 메모리 할당
		int [][] arr = new int[5][5];

		int n;
		
		// 단 구성
		for (int i=0; i<arr.length; i++ )		 // i → 0 1 2 3 4
		{	
			n = i + 1;

			// 내용 구성
			for (int j=0; j<arr[i].length; j++ ) // j → 0 1 2 3 4
			{
				arr[i][j] = n;
				n++;
			}
		}

		// 배열의 배열 요소 전체 출력
		for (int i=0; i<arr.length; i++ )
		{
			for (int j=0; j<arr[i].length; j++ )
			{
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}

	}
}

/* [실행 결과]
  1  2  3  4  5
  2  3  4  5  6
  3  4  5  6  7
  4  5  6  7  8
  5  6  7  8  9
계속하려면 아무 키나 누르십시오 . . .
*/