/*=========================================
■■■ 정렬(Sort) 알고리즘■■■
- 향상된 버블 정렬(Bubble Sort : 거품 정렬)
==========================================*/

// ○ 실습 문제
//	  사용자로부터 여러 학생의 성적 데이터를 정수 형태로 입력받아
//	  정수가 높은 순으로 등수를 부여하여 결과를 출력하는 프로그램을 구현한다.
//	  단, 배열과 정렬 알고리즘을 활용하여 작성할 수 있도록 한다.

// 실행 예)
// 인원 수 입력 : 5
// 이름 점수 입력(1) : 박정준 90
// 이름 점수 입력(2) : 선혜연 80
// 이름 점수 입력(3) : 소서현 85
// 이름 점수 입력(4) : 심혜진 75
// 이름 점수 입력(5) : 안정미 95

// ================
// 1등 안정미 95
// 2등 박정준 90
// 3등 소서현 85
// 4등 선혜연 80
// 5등 심혜진 75
// ================
// 계속하려면 아무 키나...


import java.util.Scanner;

class Record
{
	String name;
	int score;
}

public class Test105
{
	public static void main(String[] args)
	{
		// 변수 및 배열 선언
		int n;	// 입력받을 인원 수
		Record[] arrStu;	// Record타입 배열 선언
		
		
		// 인원 수 입력 받기
		Scanner sc = new Scanner(System.in);

		do				
		{
			System.out.print("인원 수 입력 :");
			n = sc.nextInt();
		}
		while (n<1);
		

		// 배열 생성
		arrStu = new Record [n];	
		
		// 이름 및 점수 입력 받기
		for (int i=0;i<arrStu.length; i++)
		{
			arrStu[i] = new Record();	// 인스턴스 생성

			System.out.printf("이름 점수 입력(%d) :",(i+1));

			arrStu[i].name = sc.next();
			arrStu[i].score = sc.nextInt();
		}

		
		// 내림차순 정렬 (선택정렬)
		// 빈 배열 만들기
		int[] temp = new int [n];
		for (int i=0; i<temp.length;i++ )
			temp[i] = arrStu[i].score;


		int i,j;

		for (i=0;i<arrStu.length-1 ;i++ )
		{
			for (j=i+1;j<arrStu.length;j++ )
			{
				if (temp[i] < temp[j])
				{
					// 자리 바꾸기
					temp[i] = temp[i]^temp[j];
					temp[j] = temp[j]^temp[i];
					temp[i] = temp[i]^temp[j];
				}
			}
		}

		// 테스트
		// for (int k=0;k<temp.length ; k++)
			// System.out.print(temp[k] + " ");

		
		// 출력하기
		System.out.println("================");
		
		for (i =0 ; i<temp.length; i++)
		{
			for (j=0; j<arrStu.length; j++ )
			{
				if (temp[i] == arrStu[j].score)
				{
					System.out.printf("%d등  ",(j+1));
					System.out.printf("%s  ",arrStu[j].name);
					System.out.printf("%d  ",arrStu[j].score);
				}
			}
			System.out.println();

		}

		System.out.println("================");

	}
}

// 각각 배열에 담는 방법으로도 풀어보기

