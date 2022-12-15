/*=================================
■■■ 자바의 기본 입출력(I/O) ■■■
==================================*/

// Reader 실습
// Test166.java 와 비교~!!!

import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test168
{
	public static void main(String[] args) throws IOException
	{
		int data;
		char ch;

		// System.in		 : 자바의 표준 입력 스트림(객체) → 바이트 기반 스트림 
		// InputStreamReader : 바이트 기반 스트림을 문자 기반 스트림으로 변환
		//						(변환기, 번역기 역할 수행)
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// Reader			 : 문자 기반 스트림 객체
		Reader rd = new InputStreamReader(System.in);
		// 입력 스트림의 물줄기를 열었다.


		System.out.println("문자열 입력(종료:Ctrl+z) " );
		
		while ((data = rd.read()) != -1)	// 문자 기반 스트림을 읽어들여옴 (Reader rd)
		{
			ch = (char)data;
			System.out.print(ch);			//-- 한글 안깨짐
			//--==>>
			/*
			[실행 결과]
			문자열 입력(종료:Ctrl+z)
			1234
			1234
			abcd
			abcd
			ABCD
			ABCD
			가나다라
			가나다라
			^Z
			*/
			
			// write() : OutputStream 클래스의 대표적 메소드 (→ 바이트 스트림)
			System.out.write(ch);			//-- 한글 깨짐
			//--==>>
			/*
			문자열 입력(종료:Ctrl+z)
			1234
			1234
			abd
			abd
			ABCD
			ABCD
			가나다라
			 섆|
			^Z
			*/
		}


	}
}
