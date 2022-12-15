/* ====================================
■■■ 클래스와 인스턴스 ■■■
- 클래스 설계
- 배열 활용
======================================*/

// ○ 실습 문제
// 아래의 클래스 (WeekDay)를 완성한다.
// 사용자로부터 년, 월, 일을 입력받아
// 해당 날짜의 요일을 출력하는 프로그램을 구현한다.
// 단, 달력 클래스 (Calendar) 는 사용하지 않는다.
// 또한, 클래스의 개념을 활용하여 작성할 수 있도록 한다.
// 그리고, 배열의 개념도 적용시켜 작성할 수 있도록 한다.

// 실행 예)
// 년 월 일 입력(공백 구분) : 1997 10 6

// >> 1997년 10월 6일 → 월요일
// 계속하시려면 아무 키나 ...

// ※ 문제 인식 및 분석
//	  - 윤년 및 평년의 개념 적용
//	  - 1년 1월 1일 → 월요일 
//    며칠지났는지 카운팅 → 나누기 7

import java.util.Scanner;

class WeekDay
{
	// 내가 한 풀이
	/*

	// 주요 변수 선언 (속성 구성)
	private int y, m, d;
	private String yoil;
	
	// 메소드 정의 (입력받기)
	void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("년 월 일 입력(공백 구분) :");
		y = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();
	}

	// 메소드 정의 (요일 산출하기)
	String week()
	{
		String [] arrDay = {"월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"};
		
		int count=0,year=0,month=0,fin=0;
	
		for (int i =1 ; i< y ; i++)
		{
			if (i%4==0 && i%100!=0 || i%400==0)
			{
				year += 366;
			}
			else
				year += 365;
		}
		System.out.printf("year : %d\n",year);
		

		for (int j=1;j<m ;j++ )
		{
			if (j==2)
			{
					if (y%4==0 && y%100!=0 || y%400==0)
					{
						month += 29;
					}
					else 
						month += 28;
			}

			else if (j==4||j==6||j==9||j==11)
			{
				month += 30;
			}

			else
				month += 31;
			
		}
		System.out.printf("month : %d\n",month);


		int date = d*1;
		
		count = year + month + date;
		System.out.println(count);
		fin = count%7;
		// System.out.println(fin);
		
		
		switch (fin)
		{
		case 0 : yoil = arrDay[6]; break;
		case 1 : yoil = arrDay[0]; break;
		case 2 : yoil = arrDay[1]; break;
		case 3 : yoil = arrDay[2]; break;
		case 4 : yoil = arrDay[3]; break;
		case 5 : yoil = arrDay[4]; break;
		case 6 : yoil = arrDay[5]; break;
		
		}	

		return yoil;

	}

	// 메소드 정의 (결과 출력하기)
	void print(String day)
	{
		System.out.printf(">> %d년 %d월 %d일 → %s\n",y,m,d,yoil);
	}
	*/

	// 주요 변수 선언 (속성 구성)
	private int y, m, d;
	
	// 메소드 정의 (입력받기)
	void input()
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("년 월 일 입력(공백 구분) :");
		y = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();
	}

	// 메소드 정의 (요일 산출하기)
	String week()
	{
		// 각 월의 마지막 날짜 (각 월의 최대값)을 배열 형태로 구성
		int [] months = {31,0,31,30,31,30,31,31,30,31,30,31};			//-- 2월꺼 비워두면 안돼 (값을 머라도 넣어놔!)

		// 요일명에 대한 배열 구성
		String [] weekNames = {"일","월","화","수","목","금","토"};
		
		// 날 수를 종합할 변수, 루프 변수, 요일 변수
		int nalsu, i, w;
		
		// 윤년에 따른 2월의 날 수 계산
		// 윤년이라면... 2월의 마지막 날짜를 29일로 설정 → month[1] = 29;
		// 평년이라면... 2월의 마지막 날짜를 28일로 설정 → month[1] = 28;
		if (y%4==0 && y%100!=0 || y%400==0)	//-- 입력한 년도가 윤년이라면...
		{
			// 2월의 마지막 날짜를 29일로 설정
			months[1] = 29;
		}
		else								//-- 입력한 년도가 평년이라면...
		{
			// 2월의 마지막 날짜를 28일로 설정
			months[1] = 28;
		}


		// ① 1년 1월 1일 부터 입력받은 년도의 이전 년도 12월 31일 까지의 날 수 계산
		nalsu = (y-1)*365 + (y-1)/4 - (y-1)/100 + (y-1)/400;
		
		//테스트
		// System.out.println(nalsu);
		// 1.1.1 ~ 1996.12.31
		

		// ② 해당 년도의 1월 1일 부터 입력 받은 월의 이전 월까지의 
		//    날 수 계산 후 1번 결과에 더하는 연산
		for (i=0; i<(m-1) ;i++ )
		{
			nalsu += months[i];
		}
		
		//테스트
		// System.out.println(nalsu);
		// 1.1.1 ~ 1997.9.30


		// ③ 입력받은 일의 날짜만큼 날 수 계산 후
		//	  2번 결과에 더하는 연산
		nalsu += d;			//-- 날 수를 d만큼 증가시켜라~

		//테스트
		// System.out.println(nalsu);
		// 1.1.1 ~ 1997.10.6


		//------------------------------------------------여기까지 수행하면 날 수 연산 끝~!!

		
		// 무슨 요일이지 확인하기 위한 연산
		w = nalsu % 7;			// 전체 날 수 % 7 == 0 → 일요일
								// 전체 날 수 % 7 == 1 → 월요일
								// 전체 날 수 % 7 == 2 → 화요일
								//				:
								
		//테스트
		// System.out.println(w);
		// --1997 10 6 --==>> 1 → 월요일
		//	 2021 02 22--==>> 1 → 월요일

		return weekNames[w];
	}

	// 메소드 정의 (결과 출력하기)
	void print(String day)
	{
		System.out.printf("\n >> %d년 %d월 %d일은 → %s요일\n",y,m,d,day);
		
	}


}


public class Test092
{
	public static void main(String[] args)
	{
		WeekDay wd = new WeekDay();

		wd.input();						//-- 입력메소드 호출
		String result = wd.week();		//-- 요일 산출 메소드 호출
		wd.print(result);				//-- 결과 출력 메소드 호출
	}
}

/*
1. 입력받기
2. 요일 산출하기
-> 
1년1월1일 월요일 : 요일 배열 만들기
~ 며칠 지났는지(날짜를) 카운팅 : 
y-1 * 365 + m-1 *  d*1
==>> 윤년인경우 , 30.31일 
나누기 7 : 나머지가 요일이 돌아가는 날짜
3. 결과 출력
*/