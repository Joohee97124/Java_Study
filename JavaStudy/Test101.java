/*==========================================
■■■ 주민등록번호 유효성 검사■■■
==========================================*/

/*
○ 주민번호 검증 공식

	① 마지막 자리를 제외한 앞자리 수를 규칙에 맞게 곱한다.

		123456 - 1234567 (→ 주민번호)
		****** - ******
		234567 - 892345  (→ 각 자리에 곱해질 수)

	② 규칙에 맞게 곱셈 연산을 수행한 결과를 모두 더한다.
		
		ex) 7 5 0 6 1 5 - 1 8 6 2 1 3 3
			* * * * * *   * * * * * * *
			2 3 4 5 6 7   8 9 2 3 4 5 
		----------------------------------
		→ 14 + 15 + 0 + 30 + 6 + 35 + 8 + 72 + 12 + 6 + 4 + 15 

		   == 217

	③ 더해진 결과물을 11로 나누어서 『나머지』를 구한다.
		
		217 % 11 →  나머지=8

	④ 11에서 나머지를 뺀 결과값을 구한다.

	    11 - 8 → 3

	○ 추가
		④를 수행한 결과 11이나 10이 나오게 되었을 경우...
		즉, ③의 수행 결과 나머지가 0이나 1일 경우...
		해당 값을 10으로 나눈 나머지를 얻어낸다.

	⑤ ④에서 처리한 연산 결과가 주민번호를 구성하는 마지막 숫자와 
		일치하는지 비교한다.

		11 - 8 → 3	 ==	주민번호 마지막 숫자 3
	
	※ 마지막 숫자와 같은 경우 유효한 주민등록번호~!!!

*/

// 실행 예)
// 주민번호 입력(xxxxxx-xxxxxxx) : 750615-1862133
// >> 정확한 주민번호~!!
// 계속하려면 아무 키나...

// 주민번호 입력(xxxxxx-xxxxxxx) : 750615-1234567
// >> 잘못된 주민번호~!!
// 계속하려면 아무 키나...

// 주민번호 입력(xxxxxx-xxxxxxx) : 750615-12345	// → 자릿수 부적합
// >> 입력 오류~!!
// 계속하려면 아무 키나...

// 배열.length → 배열방의 길이(크기, 갯수)
// -> 메소드 X, 속성

// ※ 문자열.length() → 문자열의 길이 반환	(속성X,메소드ㅇ)
//	  문자열.substring() → 문자열 추출

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test101
{
	public static void main(String[] args) throws IOException
	{
		// 테스트
		// String strTemp = "동해물과백두산이 마르고닳도록";
		// System.out.println(strTemp.length());
		//--==>> 15

		// 테스트
		// System.out.println("남산위의 저 소나무".length());
		//--==>> 10

		// 테스트
		// System.out.println("abcdefghijklmnopqrstuvwxyz".substring(3,5));
		//--==>> de (3~4(=5-1))까지 문자열 반환
		// substring(m, n) → 문자열 인덱스 m번째부터 n-1 번 째까지 추출
		//					  인덱스는 0부터...

		// 테스트
		// System.out.println("abcdefghijklmnopqrstuvwxyz".substring(3,24));
		//--==>> defghijklmnopqrstuvwx

		// System.out.println("abcdefghijklmnopqrstuvwxyz".substring(3,25));
		//--==>> defghijklmnopqrstuvwxy

		// System.out.println("abcdefghijklmnopqrstuvwxyz".substring(3,26));
		//--==>> defghijklmnopqrstuvwxyz

		// System.out.println("abcdefghijklmnopqrstuvwxyz".substring(3,27));
		//--==>> 에러 발생 (런타임 에러)
		//		 java.lang.StringIndexOutOfBoundsException

		//테스트
		// System.out.println("봄이오니졸려죽겠네".substring(4,9));
		// → System.out.println("졸려죽겠네");
		//--==>> 졸려죽겠네

		// 테스트
		// System.out.println("졸려도좀참자".substring(3));
		// System.out.println("졸려도좀참자".substring(3, "졸려도좀참자".length()));
		// System.out.println("졸려도좀참자".substring(3, 6));
		// System.out.println("좀참자");
		//--==>> 좀참자
		
		
		//내가 한 풀이
		/*
		String numbers;			// 주민번호를 입력받을 문자

		int [] numbers2 = new int [14];
		int [] cal = {2,3,4,5,6,7};
		int [] cal2 = {8,9,2,3,4,5};

		int sum1=0;					// 계산 할 변수
		int sum2=0;					


		Scanner sc = new Scanner(System.in);

		System.out.print("주민번호 입력(xxxxxx-xxxxxxx) :");	// 주민번호 입력받기
		numbers = sc.next();									// String 형태로 저장

		if (numbers.length() != 14)						// 길이를 통한 입력오류 확인
		{
			System.out.println("입력 오류~!!!");
		}

		// Int형으로 형변환 (앞)
		for (int i=0;i<6 ;i++ )									
		{
			numbers2[i] = Integer.parseInt(numbers.substring(i,(i+1)));
			// System.out.print(numbers.substring(i,(i+1)));
		}
		
		// Int형으로 형변환 (뒤)
		for (int i=7; i<14 ;i++ )								
		{
			numbers2[i] = Integer.parseInt(numbers.substring(i,(i+1)));
			 //System.out.print(numbers.substring(i,(i+1)));
		}
		
		// ①번과 ②번 연산
		for (int i=0; i<6; i++ )
		{
			sum1 += numbers2[i] * cal[i];
		}
		//System.out.print(sum1);

		for (int i=7,j=0; i<13; i++,j++)
		{
			sum2 += numbers2[i] * cal2[j];
		}
		// System.out.print(sum2);
		

		int result = sum1 + sum2;		//  ①,②번의 최종 합
		int nan = result%11 ;			// 을 11로 나눈 나머지
		int k = 11 - nan;
		int real=0;

		if (k==10 || k==11)
		{
			real = k%10;
		}

		if (k==numbers2[13] || real == numbers2[13])
		{
			System.out.println(">> 정확한 주민번호~!!");
		}
		else
			System.out.println(">> 잘못된 주민번호~!!");
		*/


		// 함께 한 풀이
		
		// BufferedReader 클래스 인스턴스 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// 입력받은 주민번호
		String str;

		// 주민번호를 대상으로 곱해지는 수 배열 구성	// 123456-1234567
		int[] chk = {2, 3, 4, 5, 6, 7, 0, 8, 9, 2, 3, 4, 5};
		//						    __check~!!

		
		// 곱셈 연산 후 누적합
		// int tot = 1; 누적합이니까 1로 초기화되면 +에 지장이 간다 ! 0으로 초기화~
		int tot = 0;
		
		// 사용자에게 안내 메세지 출력 및 주민번호 입력받기
		System.out.print("주민번호 입력(xxxxxx-xxxxxxx) :");
		str = br.readLine();
		
		if (str.length() != 14)
		{
			System.out.println(">> 입력오류~!!");
			return;	// 메소드 종료 → 프로그램 종료
		}
		
		// 확인 테스트
		// System.out.println(">>자릿수가 적합한 상황~!!!");
		
		// 1 2 3 4 5 6 - 1 2 3 4 5 6   7 
		// 2 3 4 5 6 7 0 8 9 2 3 4 5
		for (int i=0; i<13 ; i++ )	// i → 0 1 2 3 4 5 6 7 8 9 10 11 12 
									// chk의 길이만큼 반복  
		{
			if (i==6)
				continue;			// 뒷부분 무시하고 계속해라...

			tot += chk[i] * Integer.parseInt(str.substring(i,(i+1)));	//뒷부분

			// chk[0] * Integer.parseInt(주민번호 0번째 자리 추출)
			// chk[0] * Integer.parseInt(str.substring(0,1))
			// chk[i] * Integer.parseInt(str.substring(i,(i+1)))
		
			// tot += chk[6] * Integer.parseInt(str.substring(6,7));
			// tot += chk[6] * Integer.parseInt("123456-1234567".substring(6,7));
			// tot += chk[6] * Integer.parseInt("-");
			//				  ---------------------------- Error

		}

		//-- 여기까지 수행하면 ①과 ② 를 모두 끝낸 상황이며
		//	 규칙에 맞게 곱셈연산을 수행한 결과를 모두 더한 값은
		//	 변수 tot에 담겨있는 상태가 된다.

		
		int su = 11 - tot % 11;
		//            ----------
		//      ----------------

		// 테스트 (확인)
		// System.out.println(su);
		//--==>>
		
		// 최종 결과 출력 이전에 추가 연산 필요~!!
		// → su 에 대한 연산 결과가 두 자리로 나올 경우
		//	  주민번호 마지막 자릿수와 비교할 수 없는 상황
		su = su % 10;	// su %= 10;
		
		//-- 여기까지 수행하면 ③과 ④와 추가까지 모두 끝낸 상황이며
		//   최종 연산 결과는 변수 su에 담겨있는 상황이 된다.

		// 최종결과 출력
		// if (su == Integer.parseInt(//주민번호마지막자리 하나 추출)
		// if (su == Integer.parseInt(str.마지막자리 하나 추출)
		if (su == Integer.parseInt(str.substring(13)))
			System.out.println(">> 정확한 주민번호~!!");

		else
			System.out.println(">> 잘못된 주민번호~!");
	}
}
/*
[실행결과]
주민번호 입력(xxxxxx-xxxxxxx) :861212-1234567
>> 잘못된 주민번호~!
계속하려면 아무 키나 누르십시오 . . .

주민번호 입력(xxxxxx-xxxxxxx) :750615-1862133
>> 정확한 주민번호~!!
계속하려면 아무 키나 누르십시오 . . .

주민번호 입력(xxxxxx-xxxxxxx) :1234
>> 입력오류~!!
계속하려면 아무 키나 누르십시오 . . .
*/