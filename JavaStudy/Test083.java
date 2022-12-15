/*=====================================
     ■■■ 배열 (array) ■■■
     - 배열의 선언과 초기화
	 - 배열의 기본적인 활용
=====================================*/

// ○ 실습 문제
// 사용자로부터 인원 수를 입력받고
// 이렇게 입력받은 인원 수 만큼의 학생 이름과 전화번호를 입력받아
// 입력받은 내용을 전체 출력하는 프로그램을 구현한다.
// 단, 배열을 활용하여 처리할 수 있도록 한다.

// 실행 예)
// 입력 처리할 학생 수 입력(명, 1~10) : 3
// 이름 전화번호 입력[1](공백 구분) : 이정헌 010-1111-1111
// 이름 전화번호 입력[2](공백 구분) : 이희주 010-2222-2222
// 이름 전화번호 입력[3](공백 구분) : 소서현 010-3333-3333

// ---------------------
// 전체 학생 수 : 3명
// ---------------------
// 이름	       전화번호
// 이정헌 010-1111-1111
// 이희주 010-2222-2222
// 소서현 010-3333-3333
// ---------------------
// 계속하려면 아무 키나 …

import java.util.Scanner;

public class Test083
{
	public static void main(String[] args)
	{
		//Scanner 클래스 기반 인스턴스 생성
		Scanner sc = new Scanner(System.in);
		
		/* [내가 한 풀이]

		int n;
		
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.print("입력 처리할 학생 수 입력 (명, 1~10) :");
			n = sc.nextInt();
		}
		while (n<1||n>10);
		
		String [] arrName = new String [n];
		String [] arrTel = new String [n];

		for (int i=0;i<arrName.length ;i++ )
		{
			System.out.printf("이름 전화번호 입력[%d] (공백구분) :",(i+1));
			arrName[i] = sc.next();
			arrTel[i] = sc.next();
			//System.out.println();
		}

		System.out.println("-------------------");
		System.out.printf(" 전체 학생 수 : %d명\n",n);
		System.out.println("-------------------");
		System.out.println(" 이름		전화번호 ");
		for (int j=0;j<=arrName.length ;j++ )
		{
			System.out.printf("%s	%s\n",arrName[j],arrTel[j]);
		}
		*/
		

		// [같이 풀이]
		
		// 사용자가 입력하는 학생수를 담아둘 변수
		int memCount = 0;

		// ○ 사용자 입력값 받아오기
		do
		{
			System.out.print("입력 처리할 학생 수 입력(명, 1~10) : ");
			memCount = sc.nextInt();
		}
		while (memCount<1 || memCount>10);

		// 테스트 ☆ 다시 체크 ☆
		//System.out.println("사용자가 입력한 인원 수 : " + memCount);
		

		// ○ 이름 저장 배열 구성 → 입력받은 인원 수 만큼의 배열방 갯수
		String[] names = new String[memCount];

		// ○ 전화번호 저장 배열 구성 → 입력받은 인원 수 만큼의 배열방 갯수
		String[] tels = new String[memCount];	
		// String[] tels = new String[names.length];

		// ○ 반복문을 활용하여 사용자의 입력 데이터를 배열에 담아내기
		for (int n=0;n<memCount; n++ )	// memCount == names.length == tels.length
		{
			System.out.printf("이름 전화번호 입력[%d](공백 구분) : ", (n+1));
			// 이정헌 010-1111-1111
			names[n] = sc.next();
			tels[n] = sc.next();
		}

		// ○ 최종 결과 (이름, 전화번호) 출력
		System.out.println("---------------------");
		System.out.printf("전체 학생 수 : %d명\n", memCount);
		System.out.println("---------------------");
		System.out.println("이름     전화번호");
		
		for (int m=0;m<memCount;m++ )
		{
			System.out.printf("%3s %14s\n", names[m], tels[m]);
		}

		System.out.println("---------------------");
	}
}

/* [실행 결과]
입력 처리할 학생 수 입력(명, 1~10) : 4
이름 전화번호 입력[1](공백 구분) : 김가영 010-1111-1111
이름 전화번호 입력[2](공백 구분) : 유민희 010-2222-2222
이름 전화번호 입력[3](공백 구분) : 신서현 010-2222-2222
이름 전화번호 입력[4](공백 구분) : 이정헌 010-3333-3333
---------------------
전체 학생 수 : 4명
---------------------
이름     전화번호
김가영  010-1111-1111
유민희  010-2222-2222
신서현  010-2222-2222
이정헌  010-3333-3333
---------------------
계속하려면 아무 키나 누르십시오 . . .
*/