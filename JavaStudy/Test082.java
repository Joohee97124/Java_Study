/* ==========================
■■■ 배열(array) ■■■
- 배열의 선언과 초기화
- 배열의 기본적인 활용
=============================*/

// ○ 실습 문제
// 『char』자료형의 배열을 만들어 알파벳 대문자를 채우고
// 채워진 배열의 전체 요소를 출력하는 프로그램을 구현한다.

// 실행 예)
// A B C D ... W X Y Z
// 계속하려면 아무키나...

public class Test082
{
	public static void main(String[] args)
	{

		// 내가 한 풀이
		/*
		// char [] arr = new char [26];
		 char [] arr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q','R','S','T','U','V','W','X','Y','Z'};
		// char [] arr = {A,B, C, D, E, F};
		
		//System.out.println(arr.length);

		for (int i=0;i<arr.length ;i++ )
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		*/

		
		// 함께 한 풀이
		
		// 방법 ①
		char[] arr1;
		arr1 = new char[26];

		arr1[0] = 'A';
		// :


		// 방법 ②
		char [] arr2 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q','R','S','T','U','V','W','X','Y','Z'};


		// 방법 ③
		char [] arr3 = new char[26];
		for (int i=0,ch=65; i<arr3.length; i++,ch++ )	// 26회전
		{	
			arr3[i] = (char)ch;
			// arr3[0] = (char)65;
			// arr3[1] = (char)66;
			//  : 
			// arr3[25] = (char)90;
		}

		// 배열 요소 전체 출력
		for (int i=0; i<arr3.length ; i++)
			System.out.print(arr3[i]+ " ");
		System.out.println();
	
	}
}

/*
[실행 결과]
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
계속하려면 아무 키나 누르십시오 . . .
*/