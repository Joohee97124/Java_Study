/*======================================
■■■ 클래스와 인스턴스 ■■■
- 클래스 개념 적용 및 클래스 설계 실습
=======================================*/

// 사용자로부터 임의의 두 정수와 연산자를 입력받아
// 사칙 연산을 수행하는 프로그램을 구현한다.
// 단, 클래스와 인스턴스의 개념을 적용하여 작성할 수 있도록 한다.
// 편의상 정수 기반으로 처리한다.

// 실행 예)
// 임의의 두 정수 입력 (공백 구분) : 30 15
// 임의의 연산자 입력 (+ - * /) : +
// >> 30 + 15 = 45
// 계속하려면 아무 키나....

import java.util.Scanner;
import java.io.IOException;

class Calculate
{
	// ○ 주요 속성 구성
	int su1, su2;
	char op;

	// 내가 푼 풀이
	/*

	// 입력 메소드 (정수2, 연산자)
	void input() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.printf("임의의 두 정수 입력 (공백 구분) : %d %d",su1,su2);
		su1 = Integer.parseInt(br.readLine());
		su2 = Integer.parseInt(br.readLine());

		System.out.printf("임의의 연산자 입력 (+ - * /) : %c",op);
		op = (char)System.in.read();

	}

	// 연산 메소드
	int cal()
	{
		int result;

		if (op == '+')
		{
			result = su1+su2;
		}
		else if (op == '-')
		{
			result = su1 -su2;
		}
		else if (op =='*)
		{
			result = su1*su2;
		}
		else
		{
			result = su1/su2;
		}

		return result;
	}
	
	// 출력 메소드
	void print(int result)
	{
		System.out.printf("%d %c %d = %d \n", su1,op,su2,result);

	}
	*/

	// 함께 한 풀이

	// ○ 입력 메소드 정의
	void input () throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("임의의 두 정수 입력 (공백 구분): ");
		su1 = sc.nextInt();
		su2 = sc.nextInt();

		System.out.print("임의의 연산자 입력 (+ - * /) : ");
		op = (char)System.in.read();
	}

	// ○ 연산 메소드 정의
	int cal()
	{
		int result = 0;

		switch (op)
		{
			case '+' : result = su1+su2; break;
			case '-' : result = su1-su2; break;
			case '*' : result = su1*su2; break;
			case '/' : result = su1/su2; break;
		}

		return result;
	}

	// ○ 출력 메소드 정의
	// >> 30 + 15 = 45
	void print(int r)
	{
		System.out.printf(">> %d %c %d = %d \n",su1, op, su2, r);

	}
}


// main() 메소드를 포함하고 있는 외부의 다른 클래스 
public class Test073
{
	public static void main(String[] args) throws IOException
	{
		// Calculate 클래스 기반의 인스턴스 생성
		Carculate ob = new Carculate();
		
		// 생성한 인스턴스를 통한 입력 메소드 호출
		ob.input();

		// 생성한 인스턴스를 통한 연산 메소드 호출
		int result = ob.cal();

		// 생성한 인스턴스를 통한 출력 메소드 호출
		ob.print(result);
	}
}