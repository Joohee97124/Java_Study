/*===============================
■■■ 실행 흐름의 컨트롤(제어문) ■■■
- if문 실습
===============================*/

// ○ 과제
//    사용자로부터 임의의 알파벳 한 문자를 입력받아서 이를 판별하여
//	  소문자를 입력받았을 경우.... 대문자로 변환하고
//    대문자를 입력받았을 경우.... 소문자로 변환하는
//    프로그램을 구현한다.

// 실행 예)
// 알파벳 한 문자 입력 : T
// >> t
// 계속하려면 아무 키나...

// 알파벳 한 문자 입력 : c
// >> C
// 계속하려면 아무 키나...

// 알파벳 한 문자 입력 : 6
// >> 입력 오류~!!!
// 계속하려면 아무 키나...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test039
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

		char ap1 , ap2;
		ap2 = 'a';

		System.out.print("알파벳 한 문자 입력 : ");
		ap1 = (char)System.in.read();

		if (ap1>=65 && ap1<=90)						//-- 대문자일 경우
		{
			ap2 = (char)( ap1+32) ;					//-- 대문자의 아스키코드 +32 = 소문자의 아스키코드
			System.out.printf(">> %c\n",ap2);
			
		}
		else if (ap1>=97 && ap1<=122)				//-- 소문자
		{
			ap2 = (char)( ap1-32 );					//-- 소문자의 아스키코드 -32 = 대문자의 아스키코드
			System.out.printf(">> %c\n",ap2);
		}
		else 
		{
			System.out.println("입력 오류~!!!");	//-- 알파벳이 아닌 경우
		}

	}
}

/*
[실행 결과]
알파벳 한 문자 입력 : A
>> a
계속하려면 아무 키나 누르십시오 . . .
*/