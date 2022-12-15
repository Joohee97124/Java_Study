/*===========================================
■■■ 자바 기본 프로그래밍 ■■■
- 변수와 자료형
- 자바의 기본 입출력
===========================================*/

// 사용자로부터 이름과 국어점수, 영어점수, 수학점수를 입력받아
// 이름과 총점을 출력하는 프로그램을 구현한다.

// 실행 예)
// 이름을 입력하세요 : 박나현
// 국어 점수 입력 : 90
// 영어 점수 입력 : 80
// 수학 점수 입력 : 70

// ====[결과]====
// 이름 : 박나현
// 총점 : 240
// ==============
// 계속하려면 아무 키나 누르세요...

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
*/

import java.io.*;				//  이거보다 위에꺼 써라,, (우리는 3개만 쓰는데 안쓰는 나머지 애들이 다 메모리에 적재 돼ㅠ)

public class Test014 
{
	public static void main(String[] args) throws IOException
	{
		// 내가 한 풀이
		/*
		String name;
		int k,e,m,total;

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

		System.out.print("이름을 입력하세요 : ");
		name = br.readLine();	// 문자열은 Integer.parseInt 같은거 쓸 필요x 그냥 원래 문자열로 저장 되니까~

		System.out.print("국어 점수 입력 : ");
		k = Integer.parseInt(br.readLine());

		System.out.print("영어 점수 입력 : ");
		e = Integer.parseInt(br.readLine());

		System.out.print("수학 점수 입력 : ");
		m = Integer.parseInt(br.readLine());

		total = k+e+m ; // 얘는 여기서 초기화 해줘야 해! (연산을 위해 k,e,m이 초기화 되고 나서)

		System.out.println();

		System.out.println("=====[결과]=====");
		// System.out.printf("이름 : %s\n" , name);
		// System.out.printf("총점 : %d\n", total);
		System.out.println("이름 : "+ name);
		System.out.println("총점 : "+ total);
		System.out.println("=================");

	
		// 0. BufferedReader 및 변수
		// 1 이름
		// 2 국어점수
		// 3 영어
		// 4 수학
		// 5 총점
		// 6 결과
		*/

		// 함께 본 풀이
		InputStreamReader isr = new InputStreamReader(System.in);	// 번역기만 만든 상태(InputStreamReader) + 메모리 저장(System.in)
		BufferedReader br = new BufferedReader(isr);				// BufferedReader에 값(isr)만 건네주면 돼

		// 주요 변수 선언
		String strName;			//-- 이름 변수
		int nKor, nEng, nMat, nTot;	//-- 국어, 영어, 수학, 총점 변수
		
		// 추가 변수 선언
		String strTemp;			//-- 문자열 데이터 임시 저장 변수

		// 연산 및 처리
		// ． 사용자에게 안내 메세지 출력 (이름 입력 안내)
		System.out.print("이름을 입력하세요 : ");
		
		// ·사용자가 입력한 값(외부 데이터)를 변수에 담아내기
		strName = br.readLine();
		// strName(문자열) = br.readLine() (입력값을 문자열로 받아냄) 
		//-- 유형이 동일하니까 형변환 필요 없어
		
		// ·사용자에게 안내 메세지 출력 (국어점수 입력 안내)
		System.out.print("국어 점수 입력 : ");

		// ·사용자가 입력한 값(외부 데이터)를 변수에 담아내기
		strTemp = br.readLine();			//-- 문자열 임시 저장 "90"
		nKor = Integer.parseInt(strTemp);	//-- 임시저장 데이터 형 변환 후 (문자열→정수혐)
											//   국어점수 변수에 담아내기
		
		// ·사용자에게 안내 메세지 출력 (영어점수 입력 안내)
		System.out.print("영어 점수 입력 : ");
	
		// ·사용자가 입력한 값 (외부 데이터) 를 변수에 담아내기
		strTemp = br.readLine();				//-- 문자열 임시 저장 "80"
		nEng = Integer.parseInt(strTemp);		//-- 국어점수 위에 영어점수를 덮어쓰게된다
												//-- 임시저장 데이터 형 변환 후
												//   영어 점수 변수에 담아내기

		
		// ·사용자에게 안내 메세지 출력 (수학점수 입력 안내)
		System.out.print("수학 점수 입력 : ");

		// ·사용자가 입력한 값 (외부 데이터) 를 변수에 담아내기
		strTemp = br.readLine();			//-- 문자열 임시저장 "70"
		nMat = Integer.parseInt(strTemp);	//-- 임시저장 데이터 형 변환 후
											//   수학점수 변수에 담아내기

		// ·입력된 데이터들 (nkor, nEng, nMat)을 종합하여 총점 산출하기
		nTot = nKor + nEng + nMat;



		// 결과 출력
		System.out.println();	// 개행
		System.out.println("=====[결과]=====");
		System.out.println("이름 : " + strName);
		System.out.println("총점 : " + nTot);
		System.out.println("================");


	}
}