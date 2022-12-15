/* ====================================
■■■ 클래스와 인스턴스 ■■■
- 클래스와 인스턴스 활용
======================================*/

// ○ 실습 문제
// 1 ~ 3 사이의 정수 형태의 난수를 발생시켜
// 가위, 바위, 보 게임 프로그램을 구현한다.
// 단, 클래스의 개념을 활용하여 처리할 수 있도록 한다.
// 또한, 배열을 활용하여 처리할 수 있도록 한다,

// 기준 데이터 → 1:가위, 2:바위, 3:보

// 실행 예)
// 1:가위, 2:바위, 3:보 중 입력(1~3) : 4
// 1:가위, 2:바위, 3:보 중 입력(1~3) : -10
// 1:가위, 2:바위, 3:보 중 입력(1~3) : 2
// - 유저 : 바위
// - 컴퓨터 : 보
// >> 승부최종결과 : 컴퓨터가 이겼습니다~!!!
// 계속하려면 아무 키나...

import java.util.Scanner;
import java.util.Random;

/*
class Data
{
	int num;
	String gap;
}

class RpsGame
{
	int user;
	int com;

	int n;				//-- 입력 값
	Data [] arrGame;	//-- 배열 선언
	int i;				//-- 루프 변수
	int nan;			//-- 난수 값 
	String winner;		//-- 이긴 사람
	String [] ops = {"가위","바위","보"};


	public void input()
	{
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.print("1:가위, 2:바위, 3:보 중 입력(1~3) :");
			n = sc.nextInt();

		}
		while (n<1 || n>3);

		arrGame = new Data [3];
	}

	public void cal()
	{
		// arrGame[] 배열에 가위바위보 넣기
		for (int i=0;i<3 ; i++)
		{
			arrGame [i] = new Data();
			
			arrGame[i].num = (i+1);
			arrGame[i].gap = ops[i];

		}

		
		// 컴퓨터에서 난수 발생 시키기
		Random rd = new Random();
		do
		{
			nan = rd.nextInt(3)+1;
		}
		while (nan==0);
		// nan = rd.nextInt(3)+1;


		// 유저에 - 컴터에 - 넣기
		user = n;
		com = nan;

	}

	public void print()
	{
		System.out.println("유저 : "+ arrGame[n-1].gap);
		System.out.println("컴퓨터 : "+arrGame[nan-1].gap);

		if (nan>n)
		{
			if (nan==3&&n==1)
			{
				System.out.print(">> 승부 최종 결과 : 유저가 이겼습니다~\n");
			}
			System.out.print(">> 승부 최종 결과 : 컴퓨터가 이겼습니다~\n");
		}
		else if (n>nan)
		{
			if (nan==1&&n==3)
			{
				System.out.print(">> 승부 최종 결과 : 컴퓨터가 이겼습니다~\n");
			}
			System.out.print(">> 승부 최종 결과 : 유저가 이겼습니다~\n"); 
		}
		else
			System.out.print(">> 승부 최종 결과 : 비겼습니다~\n"); 
	}



}
*/

import java.util.Random;
import java.util.Scanner;

class RpsGame
{
	int user;
	int com;


	private void runCom()		 //-- 컴퓨터가 난수 생성하는 메소드
	{
		Random rd = new Random();
		com = rd.nextInt(3) + 1;		// 0 1 2 → 0 1 2 3
	}


	public void input()			//-- 숫자 입력받는 메소드
	{
		runCom();				 //-- 컴터 난수생성 메소드 호출 

		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.print(" 1:가위, 2:바위, 3:보 중 입력(1~3) :");
			user = sc.nextInt();
		}
		while (user<1 || user>3);
	}


	public void middleCalc()	//-- 번호를 가지고 배열 구성 메소드 (유저컴터 뭐냈는지)
	{
		String [] str = {"가위","바위","보"};

		System.out.println("- 유저 : " + str[user-1]);
		System.out.println("- 컴퓨터 : " + str[com-1]);
	}


	public String resultCalc()	//-- 승부에 대한 결과 확인 메소드
	{
		String result = "무승부";

		if ((user==1&&com==3) || (user==2&&com==1) || (user==3&&com==2))
			result = "당신이 승리했습니다~!";


		if ((user==1&&com==2) || (user==2&&com==3) || (user==3&&com==1))
			result = "컴퓨터가 승리했습니다~!";
		// 논리적으로 if두개는 각각의 if문 -> else if문으로 묶야도 값을 잘 나오지만 논리적으로 틀림 ㅠ


		return result;
	}


	public void print(String result)	//-- 출력 메소드
	{
		System.out.println(">> 승부 최종결과 : " + result);
	}


}

public class Test095
{
	public static void main(String[] args)
	{
		// 내가 한 풀이
		/*
		RpsGame ob = new RpsGame();
		ob.input();
		ob.cal();
		ob.print();
		*/

		// 함게 한 풀이
		RpsGame ob = new RpsGame();
		ob.input();
		ob.middleCalc();
		String result = ob.resultCalc();
		ob.print(result);

	}
}
/*
[실행결과]
 1:가위, 2:바위, 3:보 중 입력(1~3) :2
- 유저 : 바위
- 컴퓨터 : 바위
>> 승부 최종결과 : 무승부
계속하려면 아무 키나 누르십시오 . . .

1:가위, 2:바위, 3:보 중 입력(1~3) :1
- 유저 : 가위
- 컴퓨터 : 보
>> 승부 최종결과 : 당신이 승리했습니다~!
계속하려면 아무 키나 누르십시오 . . .

 1:가위, 2:바위, 3:보 중 입력(1~3) :3
- 유저 : 보
- 컴퓨터 : 가위
>> 승부 최종결과 : 컴퓨터가 승리했습니다~!
계속하려면 아무 키나 누르십시오 . . .
*/