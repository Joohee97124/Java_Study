/*=============================
  ■■■ 배열(array) ■■■
  - 배열의 기본적인 활용
=============================*/

// ○ 과제
// 사용자로부터 임의의 정수를 임의의 갯수만큼 입력받아
// 입력받은 수 중에서 가장 큰 수를 출력하는 프로그램을 구현한다.
// 단, 배열을 활용하여 처리할 수 있도록 한다.

///주의 사항  
// 입력받는 과정에서는 크기를 확인하지말고 배열 구성만 하고
// 받아서 만든 배열 속에서 큰 수를 출력하는 컨트롤을 따로 만들 것

// 실행 예)
// 입력할 데이터의 갯수  : 10
// 데이터 입력(공백구분) : 47 92 73 11 2 61 23 62 88 15		// → 배열 구성
// >> 가장 큰 수 → 92
// 계속하려면 아무 키나...

import java.util.Scanner;
import java.util.Random;

public class Test084
{
	public static void main(String[] args)
	{
		// 변수 선언
		int n;
		
		// Scanner & 데이터 개수 입력받기
		Scanner sc = new Scanner(System.in);
	
		System.out.print("입력할 데이터의 갯수  :");
		n = sc.nextInt();
		
		// 입력 받은 데이터 개수로 배열 선언
		int [] arr = new int [n];
		
		
		// 배열 초기화 (배열 데이터 입력받기)
		System.out.print("데이터 입력(공백구분) :");
		for (int i=0;i<arr.length ;i++ )
		{
			arr[i] = sc.nextInt();
			System.out.printf("%2s",arr[i]);
		}
		System.out.println();

		// 그 중 가장 큰 수 알아내기
		int max ;		// 가장 큰 수를 담을 변수
		max = arr[0];	// 일단 임의의 배열 값을 넣어줌

		for (int i=0;i<arr.length ;i++ )
		{
			if (arr[i]>max)
			{
				max = arr[i];
			}
		}

		//출력하기
		System.out.printf(">> 가장 큰 수 → %d\n", max);

	}
}

/*
[실행 결과]
입력할 데이터의 갯수  :3
데이터 입력(공백구분) :3 5 8
 3 5 8
>> 가장 큰 수 → 8
계속하려면 아무 키나 누르십시오 . . .
*/