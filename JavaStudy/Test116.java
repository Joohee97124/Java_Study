/*======================================
■■■ 클래스 고급■■■
- 인터페이스(Interface)
======================================*/

// ○ 실습 문제
//	  성적 처리 프로그램을 구현한다.
//	  단, 인터페이스를 활용할 수 있도록 한다.

// 실행 예)
// 인원 수 입력(1~10) : 2
// 1번 째 학생의 학번 이름 입력 (공백 구분) : 2104256 박민지 
// 국어 영어 수학 점수 입력 (공백구분) : 90 100 85
// 2번 째 학생의 학번 이름 입력 (공백 구분) : 2104257 김서현
// 국어 영어 수학 점수 입력 (공백구분) : 85 70 65

// 2104256 박민지	90 100  85	275 91 
//					수  수  우 
// 2104257 김서형	85  70  65	220 73
//					우  미  양

// 계속하려면 아무 키나...

// 90 ~ 100 : 수
// 80 ~ 89 : 우
// 70 ~ 79 : 미
// 60 ~ 69 : 양
// 나머지  : 가

// 속성만 존재하는 클래스 → 자료형 활용

import java.util.Scanner;

class Record
{
	String hak, name;		//-- 학번, 이름
	int kor, eng, mat;		//-- 국어, 영어, 수학 점수
	// int[] score = new int[3];	//-- 국어, 영어, 수학 점수를 배열로 처리
	int tot, avg;			//-- 총점, 평균(편의상 정수 처리)
}

// 인터페이스
interface Sungjuk
{
	public void set();
	public void input();
	public void print();
}

// 문제 해결 과정에서 설계해야 할 클래스
class SungjukImpl implements Sungjuk
{
	int n;				//-- 입력받을 인원 수
	Record[] arrStu;	//-- Record 타입의 배열 선언

	public void set()
	{
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.print("인원 수 입력(1~10) :");
			n = sc.nextInt();
			arrStu = new Record[n];
		}
		while (n<1 || n>10);
	}


	public void input() 
	{
		Scanner sc = new Scanner(System.in);

		for (int i=0; i<arrStu.length ; i++ )
		{
			arrStu[i] = new Record();

			System.out.printf("%d번 째 학생의 학번 이름 입력 (공백 구분) :",(i+1));
			arrStu[i].hak = sc.next();
			arrStu[i].name = sc.next();

			System.out.print("국어 영어 수학 점수 입력 (공백구분) :");
			arrStu[i].kor = sc.nextInt();
			arrStu[i].eng = sc.nextInt();
			arrStu[i].mat = sc.nextInt();

			arrStu[i].tot = arrStu[i].kor + arrStu[i].eng + arrStu[i].mat;
			
			arrStu[i].avg = arrStu[i].tot / n;
		}
	}

	public void print()
	{
		for (int i=0; i<arrStu.length ; i++ )
		{
			System.out.print(arrStu[i].hak + " ");
			System.out.print(arrStu[i].name + " ");

			System.out.print("    ");
			System.out.print(arrStu[i].kor  + " ");
			System.out.print(arrStu[i].eng + " ");
			System.out.print(arrStu[i].mat + " ");

			System.out.print("    ");
			System.out.print(arrStu[i].tot + " ");
			System.out.print(arrStu[i].avg + " ");
		

			System.out.println();

			/*
			// 국어,영어,수학 점수를 배열로 처리 한 경우 수우미양가 출력
			for (int j=0 ; j<3 ; j++ )
			{
				int a = arrStu[i].score[j] /10;

				switch (a)
				{
				case 10 : System.out.print("수  "); break;
				case 9 : System.out.print("수  "); break;
				case 8 : System.out.print("우  "); break;
				case 7 : System.out.print("미  "); break;
				case 6 : System.out.print("양  "); break;
				default : System.out.print("가  ");
				}
			}
			*/


			int a = arrStu[i].kor / 10;
			int b = arrStu[i].eng / 10;
			int c = arrStu[i].mat / 10;

			System.out.print("\t");

			switch (a)
			{
			case 10 : System.out.print("수  "); break;
			case 9 : System.out.print("수  "); break;
			case 8 : System.out.print("우  "); break;
			case 7 : System.out.print("미  "); break;
			case 6 : System.out.print("양  "); break;
			default : System.out.print("가  ");
			}

			switch (b)
			{
			case 10 : System.out.print("수  "); break;
			case 9 : System.out.print("수  "); break;
			case 8 : System.out.print("우  "); break;
			case 7 : System.out.print("미  "); break;
			case 6 : System.out.print("양  "); break;
			default : System.out.print("가  ");
			}

			switch (c)
			{
			case 10 : System.out.print("수  "); break;
			case 9 : System.out.print("수  "); break;
			case 8 : System.out.print("우  "); break;
			case 7 : System.out.print("미  "); break;
			case 6 : System.out.print("양  "); break;
			default : System.out.print("가  ");
			}

			System.out.println();

		}
	}

}



public class Test116
{
	public static void main(String[] args)
	{
		SungjukImpl ob0 = new SungjukImpl();
		// check~!!
		// Sungjuk 은 인터페이스
		Sungjuk ob = (Sungjuk)ob0;
		
		// 문제 해결 과정에서 작성해야 할 ob 구성

		ob.set();
		ob.input();
		ob.print();
	}
}