/*==================================================
■■■ 변수와 자료형 ■■■
- 변수와 자료형 실습 및 테스트 : char
===================================================*/

public class Test008
{
	public static void main(String[] args)
	{
		// 주요 변수 선언
		char ch1, ch2, ch3;
		int a;

		// 연산 및 처리
		ch1 = 'A';
		ch2 = '\n';		// 개행(1), \n은 하나의 문자로 인식 (뭐가 출력되지는 않고 그냥 개행됨)
		ch3 = '대';		// '대' : 한글도 하나의 문자

		a = (int)'A'; // char → int 로 자동형변환 가능, A로 나오지는 않고 아스키코드 값을 출력
		// 자동형변환 가능한데, int를 써주는 게 바람직, 권장 (나의 의도를 나타내줘서)
		

		// 결과 출력
		System.out.println("ch1 : " + ch1);
		System.out.println("ch2 : " + ch2);		//개행(2) → 총 2줄 개행
		System.out.println("ch3 : " + ch3);
		System.out.println("a : " + a);


	}
}

/*
[실행 결과]
ch1 : A
ch2 :

ch3 : 대
a : 65
계속하려면 아무 키나 누르십시오 . . .
*/