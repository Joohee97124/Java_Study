/*===================================
 ■■■ 자바 기본 프로그래밍 ■■■
 - 자바 소스 코드 입력 및 컴파일 실습
 - println() 과 print()
 ==================================*/

public class Test002 
{
	public static void main(String[] args)
	{
		System.out.println("첫 번째 구문...");
		System.out.print("두 번째 구문...\n");
		System.out.print("세 번째 구문...\n\n");
		System.out.print("네 번째 구문...\n\n\n");
		System.out.print(12 + "\n\n\n");
		/* == 『println()』 메소드와 『print()』 메소드의 차이는
		 라인 스킵 (줄바꿈, 개행) 유무에 있다
		 『\n』 을 문자열("")에 포함하면 라인 스킵이 가능하다. (문자열에 꼭 들어가야한다.)
		 여러 번 사용하는 것도 가능하다.*/

		System.out.println(7);
		System.out.println('7');
		System.out.println("7");

		System.out.println(7+7);
		// 정수 7+7=14
		System.out.println('7'+'7');
		// 문자 7+7 = 110? → 숫자들끼리 덧셈이 되어버린거ㅠㅠ 7의 고유숫자 = 55 (클립텍스트 함 보기)
		// 문자는 코드형태로 저장됨 (고유숫자=아스키코드 가 있음) 
		System.out.println("7"+"7");
		// 문자열 7+7 = 77 (칠십칠x, 칠칠)


	}
}

/*
[실행 결과]
첫 번째 구문...
두 번째 구문...
세 번째 구문...

네 번째 구문...


12


7
7
7
14
110
77
계속하려면 아무 키나 누르십시오 . . .
*/


/*
println --> Ststem.out.print("십이 :" + 12);
print ----> System.out.print("십이 :" + 12);
printf ---> System.out.printf("십이 : %d",12);
둘 다 \n을 하면 개행된다~
*/