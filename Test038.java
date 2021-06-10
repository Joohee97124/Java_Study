/*===============================
■■■ 실행 흐름의 컨트롤(제어문) ■■■
- if문 실습
===============================*/

// ○ 과제
//	  사용자로부터 임의의 알파벳 한 문자를 입력받아
//	  이를 판별하여 입력받은 알파벳이 모음일 경우만
//	  결과를 출력하는 프로그램을 구현한다.
//    단, 대소문자를 모두 적용할 수 있도록 처리한다.
//    또한, 알파벳 이외의 문자가 입력되었을 경우
//    입력 오류에 대한 내용을 사용자에게 안내해 줄 수 있도록 처리한다.

// 실행 예)
// 알파벳 한 문자 입력 : A
// >> 모음 OK~!!!
// 계속하시려면 아무 키나...

// 알파벳 한 문자 입력 : e
// >> 모음 OK~!!!
// 계속하시려면 아무 키나...

// 알파벳 한 문자 입력 : B
// 계속하시려면 아무 키나...
// 다른 전달내용 없이 그냥 프로그램 종료

// 알파벳 한 문자 입력 : 1
// >> 입력 오류~!!!
// 계속하시려면 아무 키나...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test038
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char ap;

		System.out.print("알파벳 한 문자 입력 : ");
		ap = (char)System.in.read();

		if(ap == 'A' || ap == 'a' ||
		   ap == 'E' || ap == 'e' ||
		   ap == 'U' || ap == 'u' ||
		   ap == 'O' || ap == 'o' ||
		   ap == 'I' || ap == 'i')							//-- 모음인 알파벳들
		{
			System.out.println("모음 OK~!!!!");
		}
		else if (ap>=65 && ap<=90 || ap>=97 && ap<=122)		//-- 모음이 아닌 알파벳들 
		{
			System.out.print("");							//-- 실행 종료
		}
		else 
		{
			System.out.println("입력 오류~!!!");
		}

	}
}

/*
[실행 결과]
알파벳 한 문자 입력 : e
모음 OK~!!!!
계속하려면 아무 키나 누르십시오 . . .
*/
