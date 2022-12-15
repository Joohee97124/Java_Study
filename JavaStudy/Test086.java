/*=====================================
     ■■■ 배열 (array) ■■■
	 - 배열의 배열 (2차원 배열)
=====================================*/

public class Test086
{
	public static void main(String[] args)
	{
		// 배열의 배열 선언과 초기화
		// 방법 ① 
		//int[] arr1 = new int[3];
		int[][] arr1 = new int[3][3];

		//arr1[0] = 1;
		arr1[0][0] = 1;
		arr1[0][1] = 2;
		arr1[0][2] = 3;
		arr1[1][0] = 4;
		arr1[1][1] = 5;
		arr1[1][2] = 6;
		arr1[2][0] = 7;
		arr1[2][1] = 8;
		arr1[2][2] = 9;

		// 방법 ②
		//int[] arr2 = {1, 2, 3};
		int[][] arr2 = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};

		
		// 방법 ③
		int[][] arr3 = new int[3][3];
		int n=1;
		for (int i=0; i<arr3.length; i++ )		// arr3.length == 3층
		{
			for (int j=0; j<arr3[i].length; j++)	// arr[0].length == 3 (0번 층에 방 3개)
			{										// arr[1].length == 3 (1번 층에 방 3개)
				arr3[i][j] = n;						// arr[2].length == 3 (2번 층에 방 3개)
				n++;
			}
		}
		
		// 배열의 배열 요소 전체 출력
		for (int i=0 ;i<arr3.length; i++ )
		{
			for (int j=0; j<arr3[i].length; j++ )
			{
				System.out.printf("%2d", arr3[i][j]);
			}
			System.out.println();
		}

	}
}

/* [실행 결과]
 1 2 3
 4 5 6
 7 8 9
계속하려면 아무 키나 누르십시오 . . .
*/