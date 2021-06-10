/* ================================
■■■ 만년 달력 ■■■
==================================*/

// ○ 다음과 같은 프로그램을 구현한다.

// 실행 예)
// 『연도』를 입력하세요 : 2021
// 『월』을 입력하세요 : 7
/*
	[ 2021년 7월 ]

  일 월 화 수 목 금 토
=========================
			   1  2  3
   4  5  6  7  8  9 10
  11 12 13 14 15 16 17
  18 19 20 21 22 23 24
  25 26 27 28 29 30 31
=========================
계속하려면 아무키나...
*/


// 내가 한 풀이
/*
import java.util.Scanner;

class MakeCaledar
{
	private int y,m;		// 입력받는 연도, 월
	private String [] yoil = {"일", "월", "화","수","목","금","토"};
	private int [] month = {31,0,31,30,31,30,31,31,30,31,30,31};
	private int count;				// 총 날짜 세는 변수
	private int nan;				// count%7
	//int [] calendar = new int [35];			// 한 달의 달력 모든 일 수 배열 생성
	int [] calendar;
	int value=1;						// 달력에 출력 되는 값
	private int a;						// 요일-1 인덱스의 값을 넣을 변수

	public void input()				// 연도와 월 입력받기
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("『연도』를 입력하세요 : ");
		y = sc.nextInt();

		System.out.print("『월』을 입력하세요 :");
		m = sc.nextInt();
	}

	public void set()				// 2월 윤년 배열에 값 넣기
	{
		if (y%4==0 && y%100!=0 || y%400==0)
		{
			month[1] = 29;
		}
		else
			month[1] = 28;
	}

	public void cal()				// 입력받은 달의 1일이 무슨 요일 인지 찾기
	{
		count += y*365 + y/4 - y/100 + y/400;
	
		for (int i=0;i<m-1 ; i++ )
		{
			count += month[i];
		}

		count += 1;				// 입력받은 달의 1일

		nan = count%7;			// 요일을 찾기 위해 7로 나눠준 나머지 값을 nan에 대입
		
		System.out.printf("%s\n",yoil[nan-1]);
		a = nan-1;
		System.out.println(a);
	}


	public void preprint()		// 7개씩 맞춰서 날짜를 출력하기 위한 준비 (값 넣기)
	{
			calendar = new int[month[m]];
			
			for (int i=a; i< month[m]  ; i++)
			{				
				calendar[i] = value;
				value++;

			}
	}
	

	public void print()
	{
		System.out.printf("[ %d년 %d월 ]\n",y,m);
		System.out.println();
		
		for (int i=0; i<yoil.length ; i++ )
			System.out.print(yoil[i] + "	");
			

		System.out.println();
		System.out.println("=================================================");
		
		
		for (int i=0;i<a ;i++ )
		{
			System.out.print("	");	
		}

		for (int i=a; i<7; i++ )
		{
			System.out.print(calendar[i] + "	");
		}
		System.out.println();

		for (int i=7; i<14 ; i++ )
		{
			System.out.print(calendar[i] + "	");
		}
		System.out.println();

		for (int i=14; i<21 ; i++ )
		{
			System.out.print(calendar[i] + "	");
		}
		System.out.println();

		for (int i=21; i<28 ; i++ )
		{
			System.out.print(calendar[i] + "	");
		}
		System.out.println();

		for (int i=28; i<calendar.length  ; i++ )
		{
			System.out.print(calendar[i] + "	");
		}
		System.out.println();

		System.out.println("================================================");
	}
}

*/

// 함께 한 풀이
/*
※ 문제 인식 및 분석

	- 서기 1년 1월 1일 : 월요일
	- 연도가 4의 배수이면서 100의 배수가 아니거나,
	  400의 배수이면 2월은 29일(윤년),
	  나머지 2월은 28일(평년)

	- 2021년 7월의 달력을 그린다고 가정하면
	  1. 1. 1 ~ 2021.6.30 까지의 전체 날 수를 구한다.
	  그 날 수에 +1 연산을 수행하면...(2021년 7월 1일의 요일 확인)
	  7월의 달력을 그릴 준비 끝~!!

	- 요일 = 전체 날 수 % 7
	  요일 = 0 → 일요일
			 1 → 월요일
			 	 :
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test100
{
	public static void main(String[] args) throws IOException
	{

		// 내가 한 풀이
		/*
		MakeCaledar ob = new MakeCaledar();

		ob.input();
		ob.set();
		ob.cal();
		ob.preprint();
		ob.print();
		*/


		// 함께 한 풀이

		// BufferedReader 클래스 인스턴스 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 배열 선언 및 초기화
		// 각 달이 담고있는 마지막 날짜 (매 월의 최대 날짜)
		int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

		// 확인
		// System.out.println(days.length);
		//--==>> 12

		// 주요 변수 선언
		int nalsu, y, m, w;			//-- 날수, 년, 월, 요일

		do
		{
			System.out.print("『연도』를 입력하세요 :");
			y = Integer.parseInt(br.readLine());
		}
		while (y<1);

		do
		{
			System.out.print("『월』을 입력하세요 :");
			m = Integer.parseInt(br.readLine());
		}
		while (m<1 || m>12);

		//----------------------------- 여기까지 수행하면 유효한 연도, 월 입력한 상태~!!

		// 입력받은 년도에 해당하는 2월의 마지막 날 계산
		if ((y%4==0 && y%100!=0 || y%400==0))				//-- 윤년이라면....
		{	
			days[1] = 29;
		}
		else
		{
			days[1] = 28;
		}
		//-- else 구문은
		//	 현재  days 배열의 1번째 요소가 기본적으로 28로 입력되어 있는
		//	 상태이기 때문에 생략이 가능한 구문이 된다.

		// 1년 1월 1일 ~ 입력받은 년도의 이전년도의 12월 31일 까지의
		// 날 수 계산
		nalsu = (y-1)*365 + (y-1)/4 - (y-1)/100 + (y-1)/400;

		// 확인
		// System.out.println(nalsu);
		/*
		『연도』를 입력하세요 :2021
		『월』을 입력하세요 :7
		737790						→ 1.1.1 ~ 2018.12.31
		계속하려면 아무 키나 누르십시오 . . .
		*/

		// 입력받은년도 (해당년도) 1월 1일 ~ 입력한 월의 이전 월까지의
		// 날 수 누적 연산
		// 즉, 위의 예에 따르면...
		// 2019년 1월 1일 ~ 2019년 4월 30일 까지의 날 수 누적하여
		// 기존 nalsu에 누적
		for (int i=0; i<(m-1) ; i++ )			// i<(m-1) check~!!!
			nalsu += days[i];

		// 확인
		// System.out.println(nalsu);
		/*
		『연도』를 입력하세요 :2019
		『월』을 입력하세요 :5
		737179						→ 1.1.1 ~ 2019.4.30
		계속하려면 아무 키나 누르십시오 . . .
		*/

		// 입력받은 월의 1일
		nalsu += 1;				// ++nalsu;

		// 확인
		// System.out.println(nalsu);
		//--==>>737180
		/*
		『연도』를 입력하세요 :2019
		『월』을 입력하세요 :5
		737180			→ 1.1.1 ~ 2019.5.1
		계속하려면 아무 키나 누르십시오 . . .
		*/
		
		//--------------------------------여기까지 수행하면 모든 날 수에 대한 종합 완료~

		// 요일 산출
		// : 입력받은 월의 1일이 무슨 요일인지 확인하기 위한 연산
		w = nalsu % 7;		//-- 0:일요일, 1:월요일, 2:화요일 ...

		// 확인
		// System.out.println(w);
		//--==>>
		/*
		『연도』를 입력하세요 :2019
		『월』을 입력하세요 :5
		3							→ 2019년 5월 1일 → 수요일
		계속하려면 아무 키나 누르십시오 . . .
		*/


		// 출력 (달력 그리기)
		System.out.println();
		System.out.println("\t [ " +y + "년" + m + "월 ]");
		System.out.println("  일  월  화  수  목  금  토");	// 두칸 공백
		System.out.println("==============================");
		
		// 특정 요일부터 1일이 출발 할 수 있도록 공백 발생(지정)
		for (int i=1; i<=w ; i++ )
			System.out.print("    ");							// 네 칸 공색
		
		// 확인  
		// System.out.printf("%4d",1);

		// 해당 월(입력한 월)의 날짜만 출력될 수 있도록 반복문 구성
		for (int i=1; i<= days[m-1] ; i++ )
		{
			System.out.printf("%4d",i);
			w++;

			if (w%7 == 0)	// 일요일마다
			{
				System.out.println();	// 개행
			}
		}
		
		// 달의 마지막 날짜가 출력 형식을 모두 채웠을 경우
		// 이미 일요일 개행이 이루어졌기 때문에
		// 이 경우에는 추가 개행을 하지 않도록 처리
		if (w%7!=0)
			System.out.println();

		System.out.println("==============================");
	}
}