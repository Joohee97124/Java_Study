/*======================================
■■■ 자바의 주요(중요) 클래스 ■■■
- Random 클래스
======================================*/

/*
○ java.util.Random 클래스는

   여러 형태의 난수를 발생시켜 제공하는 클래스이다..
   Math 클래스의 정적 메소드인 random() 메소드도 난수를 제공하는 메소드이지만
   0.0 ~ 1.0 사이의 실수 형태만 발생하게 되므로
   필요한 여러 형태의 난수를 만들어내기 위해서는 추가적인 연산들을 수행해야 한다.
   그래서 자바는 여러 형태의 난수를 발생시켜주는
   전용 클래스인 Random 클래스를 별도로 제공하고 있다.
*/

// 로또 번호 생성기 (난수 발생 프로그램)

// 프로그램이 실행되면 기본적으로 로또를 5게임 수행하는 프로그램을 구현한다.

// 실행 예)
// 1 4 17 23 44
// 1 2 8 16 28 42
//	:
// 계속하려면 아무 키나...


// 내가 한 풀이
/*
import java.util.Random;

class Lotto
{
	int[] lo = new int [6]; 
	
	// 난수 발생
	void cal()
	{
		Random rd = new Random();
		for (int i=0;i<=5 ;i++ )
		{
			lo[i] = rd.nextInt(45)+1;

			for (int j=0; j<i ; j++ )
			{
				if (j==0)
					continue;

				if (lo[j] == lo[i])
				{
					i--;
				}
			}
		}
	}
	
	// 오름차순으로 정리하기
	void seq()
	{
		for (int j=1; j<=lo.length ; j++ )
		{
			for (int k=0; k <lo.length-j ; k++ )
			{
				if (lo[k] > lo[k+1])
				{
					lo[k] = lo[k]^lo[k+1];
					lo[k+1] = lo[k+1]^lo[k];
					lo[k] = lo[k+1]^lo[k];
				}
			}
		}
	}

	// 출력하기
	void print()
	{
		for (int i=0; i<=5 ;i++ )
		{
			System.out.printf("%4d", lo[i]);
		}
	}


}


public class Test141
{
	public static void main(String[] args)
	{
		Lotto lotto = new Lotto();

		for (int i=1; i<=5 ; i++ )
		{
			lotto.cal();
			lotto.seq();
			lotto.print();
			System.out.println();
		}
	}
}
*/


// 함께 한 풀이

import java.util.Random;
import java.util.Arrays;

class Lotto
{
	// 배열 변수 선언 및 메모리 할당 → 로또 번호를 담아둘 배열방 6개
	private int[] num = new int[6];

	// getter
	public int[] getNum()
	{
		return num;
	}

	// 6개의 난수를 발생시키는 메소드 정의
	public void start()
	{
		int cnt = 0;		//-- 로또 배열의 인덱스
		Random rd = new Random();
		int n;				//-- 발생 된 난수
		

		jump:
		while (cnt<6)	// cnt → 0 1 2 3 4 5 
		{
			n = rd.nextInt(45)+1;	// 1 ~ 45	→ 27 3 14 (난수발생)

			for (int i=0 ; i<cnt ; i++ )
			{
				// 확인(테스트)
				//System.out.println("i : " + i + ", cnt : " + cnt);

				if (num[i] == n)
					continue jump;

			}

			num[cnt++] = n;	// num[0] 27  num[1] 3  num[2] 14 .... num[5] 30
			
		}
		// 정렬 메소드 호출
		sorting();

	}// end start()
	

	// 정렬 메소드 정의
	private void sorting()
	{
		Arrays.sort(num);
	}
}


public class Test141
{
	public static void main(String[] args)
	{
		Lotto lotto = new Lotto();
		

		for (int i=1; i<=5 ; i++ )
		{
			// 확인(테스트)
			lotto.start();
		
			// 결과 출력
			for (int n: lotto.getNum())
				System.out.printf("%4d",n);
			System.out.println();
		}

	}
}
/*
[실행 결과]
   5  12  18  29  32  37
   4  15  29  37  43  44
   8  18  21  28  41  43
   6  12  14  15  19  43
   2   7  34  35  36  40
계속하려면 아무 키나 누르십시오 . . .
*/