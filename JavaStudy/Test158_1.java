/*=================================
 ■■■ 컬렉션 (Collection) ■■■
==================================*/

// ○ 실습문제
//	  현재 작성중인 Test158 클래스를 완성하여
//	  다음 기능을 가진 프로그램을 구현한다.

/*
실행 예)
	
	[메뉴 선택]
	1. 요소 추가
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료
	>> 메뉴 선택 (1~6) : 1
	
	1번째 요소 입력 : 이유림
	1번째 요소 입력 성공 ~!!!
	요소 입력 계속(Y/N) : y

	2 번째 요소 입력 : 한혜림
	2번째 요소 입력 성공~!!!
	요소 입력 계속(Y/N) : n

		[메뉴 선택]
	1. 요소 추가
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료
	>> 메뉴 선택 (1~6) : 2

	[벡터 전체 출력]
		이유림
		한혜림

	벡터 전체 출력 완료~!!!

	[메뉴 선택]
	1. 요소 추가
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료
	>> 메뉴 선택 (1~6) : 3

	검색할 요소 입력 : 이유림

	[검색 결과 출력]
	항목이 존재합니다.

		[메뉴 선택]
	1. 요소 추가
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료
	>> 메뉴 선택 (1~6) : 4

	삭제할 요소 입력 : 이희주

	[삭제 결과 출력]
	항목이 존재하지 않아 삭제할 수 없습니다.
	정상적으로 삭제가 완료되었습니다.

		[메뉴 선택]
	1. 요소 추가
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료
	>> 메뉴 선택 (1~6) : 5

	변경할 대상 입력 : 한혜림
	수정할 내용 입력 : 두혜림

	[변경 결과 출력]
	변경이 완료되었씁니다.
	
		[메뉴 선택]
	1. 요소 추가
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료
	>> 메뉴 선택 (1~6) : 6
	
	프로그램 종료
	>> 계속하려면 아무 키나...

*/

import java.util.Vector;
import java.util.Scanner;
import java.io.IOException;

public class Test158_1
{
	public static void main(String[] args) throws IOException
	{
		int n;				//-- 입력 받는 메뉴 번호
		Vector<String> v = new Vector<String>();		//-- 벡터 자료구조 인스턴스 생성

		String str;			//-- 입력 받는 요소들
		char yn;			//-- y/n 입력
		int i=1;			//-- 요소 입력 시 출력되는 번호
		String daum;		//-- 검색 시 입력 받을 요소
		String rem;			//-- 삭제 시 입력 받을 요소
		int in;				//-- 삭제 시 확인 할 인덱스
		String change;		//-- 변경 시 입력 받을 요소
		String change2;		//-- 변경 시 수정할 값

		Scanner sc = new Scanner(System.in);

		while(true)
		{
			do
			{
				System.out.println("\t [메뉴 선택]");
				System.out.println("1. 요소 추가");
				System.out.println("2. 요소 출력");
				System.out.println("3. 요소 검색");
				System.out.println("4. 요소 삭제");
				System.out.println("5. 요소 변경");
				System.out.println("6. 종료");
				System.out.print(">> 메뉴 선택 (1~6) :");
				n = sc.nextInt();
				System.out.println();
					


				if (n==1)
				{
					do
					{
						System.out.printf("%d번째 요소 입력 :",(i));
						str = sc.next();
						v.add(str);
						System.out.printf("%d번째 요소 입력 성공 ~!!!\n",i);
						System.out.print("요소 입력 계속(Y/N) : ");
						yn = (char)System.in.read();
						i++;
					}
					while (yn == 'y' || yn == 'Y');
				}

				if (n==2)
				{
					System.out.println("	[벡터 전체 출력]");
					for (String yoso : v)
						System.out.printf("%s\n",yoso);
				}

				if (n==3)
				{
					System.out.print("검색할 요소 입력 : ");
					daum = sc.next();

					System.out.println("\t[검색 결과 출력]");
					if (v.contains(daum))
						System.out.println("항목이 존재합니다.");
					else
						System.out.println("항목이 존재하지 않습니다.");
				}

				if (n==4)
				{
					System.out.print("\t[삭제 결과 출력] : \n");

					
					System.out.print("삭제할 요소 입력 : ");
					rem = sc.next();

					if (v.contains(rem))
					{
						in = v.indexOf(rem);
						v.remove(in);
						System.out.println("정상적으로 삭제가 완료되었습니다.");
					}
					else
						System.out.println("항목이 존재하지 않아 삭제할 수 없습니다.");
				}

				if (n==5)
				{
					System.out.print("변경할 대상 입력 :");
					change = sc.next();

					if (v.contains(change))
					{
						in = v.indexOf(change);
						System.out.print("수정할 내용 입력 :");
						change2 = sc.next();

						v.set(in,change2);
						System.out.println("\t[변경 결과 출력]");
						System.out.println("변경이 완료되었습니다.");
					}
					else
						System.out.println("변경 대상이 존재하지 않습니다.");
				}

				if (n==6)
					return;

			
			}
			while (n<0 || n>5);
		}


	}
	
	
	
}