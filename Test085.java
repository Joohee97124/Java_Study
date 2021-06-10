/*=============================
  ■■■ 배열(array) ■■■
  - 배열의 기본적인 활용
=============================*/

// ○ 과제
// 사용자로부터 학생 수를 입력받고, 그 만큼의 점수(정수형태)를 입력받아
// 전체 학생 점수의 합, 평균, 편차를 구하여 결과를 출력하는 프로그램을 구현한다.
// 단, 배열을 활용하여 처리할 수 있도록 한다.
// 편차 = 평균 점수와의 편차

// 실행 예)
// 학생 수 입력 : 5
// 1번 학생의 점수 입력 : 90
// 2번 학생의 점수 입력 : 82
// 3번 학생의 점수 입력 : 64
// 4번 학생의 점수 입력 : 36
// 5번 학생의 점수 입력 : 98

// >> 합   : 370
// >> 평균 : 74.0
// >> 편차
// 90 : -16.0
// 82 : -8.0
// 64 : 10.0
// 36 : 38.0
// 98 : -24.0
// 계속하려면 아무 키나...

import java.util.Scanner;

public class Test085
{
	public static void main(String[] args)
	{
		// 변수 선언
		int n;					// 학생수 변수 선언
		double sum=0, avg=0, dev=0;		// 합, 평균, 편차 변수 선언
		
		// 학생 수 입력 받기
		Scanner sc = new Scanner(System.in);

		System.out.print("학생 수 입력 :");
		n = sc.nextInt();
		
		// 학생 점수 배열 생성
		int [] arrScore = new int [n];

		// 배열 초기화
		for (int i=0;i<arrScore.length ; i++)
		{
			System.out.printf("%d번 학생의 점수 입력 :",(i+1));
			arrScore[i] = sc.nextInt();
		}
	
		System.out.println();

		// 합 출력
		for (int i=0;i<arrScore.length ;i++ )
		{
			sum += arrScore[i];
		}
		System.out.printf(">> 합   : %.1f\n",sum);

		// 평균 출력
		for (int i=0;i<arrScore.length ;i++ )
		{
			avg = sum / (double) n;
		}
		System.out.printf(">> 평균 : %.1f\n",avg);


		// 편차 배열 생성 및 초기화 와 출력
		double [] arrDev = new double [n];
		
		System.out.println(">> 편차");
		for (int i=0;i<arrDev.length ;i++ )
		{
			arrDev[i] = avg - (double)arrScore[i];
			System.out.printf("%d : %.1f\n",arrScore[i], arrDev[i]);
		}
		

	}
}
/*
[실행 결과]
학생 수 입력 :3
1번 학생의 점수 입력 :100
2번 학생의 점수 입력 :20
3번 학생의 점수 입력 :35

>> 합   : 155.0
>> 평균 : 51.7
>> 편차
100 : -48.3
20 : 31.7
35 : 16.7
계속하려면 아무 키나 누르십시오 . . .
*/