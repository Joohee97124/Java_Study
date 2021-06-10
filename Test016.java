/*===========================================
■■■ 자바 기본 프로그래밍 ■■■
- 자바의 기본 입출력 : printf()
===========================================*/

public class Test016 
{
	public static void main(String[] args)
	{
		System.out.print("AAA");
		System.out.print("BBB");
		System.out.print("CCC\n");		//-- \n 개행

		// 서식 출력 메소드
		System.out.printf("12345678901234567890");
		System.out.printf("12345678901234567890\n");	//-- \n 개행
		System.out.printf("12345678901234567890%n");	//-- %n 개행
		System.out.printf("%d + %d = %d\n", 10, 20, 30);
	
		//--==>> AABBCC
		//		 123456789012345678901234567890
		//		 1234567890
		//		 10 + 20 = 30
		//		 계속하려면 아무 키나 누르십시오...

		System.out.printf("%d\n", 123);
		System.out.printf("%7d\n", 123);
		System.out.printf("%10d\n", 123);	// 10의 위치를 잘 기억해놓기 %10d
		System.out.printf("%010d\n", 123);
		//--==>> (0칸)123
		//--==>>    (4칸)123    (총7칸을 쓰는거)
		//				(7칸)123 (우측부터 10칸의 공백을 확보하고 오른쪽으로 123을 넣어, 좌측에는 빈칸이 7칸 -> 총10칸을 쓰는거)
		//		0000000123 (총 10칸 사용하는데 123이 오른쪽으로 입력되고 나머지 빈칸에 0을 넣어줌)

		System.out.printf("%d\n", 365);
		System.out.printf("%+d\n", 365);		// 가능
		System.out.printf("+%d\n", 365);
		//--==>> 365
		//		 +365
		//		 +365

		System.out.printf("%d\n", +365);	// 양수 형태로 안나옴
		//--==>> 365
		System.out.printf("%d\n", -365);	// 음수 형태로 나옴
		//--==>> -365

		// System.out.printf("%-d\n", 365); 런타임 에러 발생
		// --==>> 에러 발생 (런타임 에러)
		// printf 안에서 쓰이는 애들 (옵션오류) 은 런타임에러! (컴파일과정에서 자바가 확인 안해) 옵션 잘 확인하기!
		
		System.out.printf("-%d\n", 365);
		//--==>> -365

		
		System.out.println(); // 개행
		
		System.out.printf("%(d\n", -365);	// check~!!!
		System.out.printf("%(d\n", 365);		// check~!!!
		//--==>> (365)
		//		 365


		// System.out.printf("%d\n",'A');
		//--==>> 에러 발생 (런타임 에러)
		System.out.printf("%c\n",'A');

		// System.out.printf("%c\n","ABCD");
		//--==>> 에러 발생 (런타임 에러)
		System.out.printf("%s\n","ABCD");
		//--==>> A
		//		 ABCD

	
		System.out.println();	// 개행

		System.out.printf("%h\n", 365);
		System.out.printf("%o\n", 24);
		//--==>> 16d (16진수로 정수 365 를 표현)
 		//		 30	 (8진수로 정수 24 를 표현)		 

		System.out.println();	// 개행

		System.out.printf("%s\n", "true");
		System.out.printf("%b\n", true);
		//--==>> true (문자열)
		//		 true (boolean형)

		System.out.printf("%s\n", true);
		// 자동형변환! (자바가 그냥 해줌)
		// 출력 된 모든 결과물은 %d,s,b,f 상관없이 모두~ 문자열! 이야!
		
		
		System.out.println();	// 개행

		System.out.printf("%f\n", 123.23);
		System.out.printf("%.2f\n", 123.23);
		System.out.printf("%.2f\n", 123.236);	//-- 소수점 3번째 자리에서 반올림 
		System.out.printf("%.2f\n", 123.231);	
		System.out.printf("%8.2f\n", 123.236);	//-- 8: 전체 다 (점까지 포함해서) 8자리를 줌 -> 앞에 공백 2칸 생겨
		System.out.printf("%2.2f\n", 123.1234); //-- 2: 2칸 안에 123.12가 나올 수 없기에 그냥 123.12 모두 출력되고 끝나
		//--==> 123.230000
		//		123.23	check~!!!
		//		123.24	check~!!!
		//		  123.24	check~!!!
		//		123.12	check~!!!


	}
}


/*
[실행 결과]
AAABBBCCC
1234567890123456789012345678901234567890
12345678901234567890
10 + 20 = 30
123
    123
       123
0000000123
365
+365
+365
365
-365
-365

(365)
365
A
ABCD

16d
30

true
true
true

123.230000
123.23
123.24
123.23
  123.24
123.12
계속하려면 아무 키나 누르십시오 . . .
*/