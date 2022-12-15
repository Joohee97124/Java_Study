/*=========================================
■■■ 클래스 고급■■■
- 상속 (Inheritance)
==========================================*/

// ○ 실습 문제
//	  다음과 같은 프로그램을 구현한다.
//	  단, 상속의 개념을 적용하여 작성할 수 있도록 한다.

// 실행 예)
// 임의의 두 정수 입력(공백 구분) : 20 15
// 연산자 입력 ( + - * / ) : -
// >> 20 - 15 = 5
// 계속하려면 아무 키나...

import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


// super class
class AClass
{
	/*
	protected int x,y;
	protected char op;

	AClass()
	{

	}

	void write(double result)
	{
		System.out.printf(">> %d %c %d = %.2f\n",x, op, y, result);
	}


	public void input() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("임의의 두 정수 입력(공백 구분) : ");
		x = sc.nextInt();
		y = sc.nextInt();

		System.out.print("연산자 입력 ( + - * / ) : ");
		op = (char)System.in.read();
	}
	*/

	protected int x,y;
	protected char op;

	AClass()
	{
	}

	void write(double result)
	{
		System.out.printf(">> %d %c %d = %.2f\n",x, op, y, result);
	}

}



// sub class
class BClass extends AClass 
{
	/*
	double result;

	public void calc() throws IOException
	{
		super.input();	// 부모클래스에서 입력 메소드 가져오기

		// 연산하기
		switch (op)
		{
		case '+' : result = x+y; break;
		case '-' : result = x-y; break;
		case '*' : result = x*y; break;
		case '/' : result = (double) x/y; 
		}

		 super.write(result);
	}
	*/

	BClass()
	{
	}
	
	boolean input() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("임의의 두 정수 입력 (공백 구분):");		// 20 15
		String temp = br.readLine();								// "20 15"

		String[] str = temp.split("\\s");	// 구분자 → 공백

		// ※ 문자열.split("구분자");
		//	  ex) "사과 딸기 바나나 포도 수박".split(공백);
		//		  반환 → 배열 → {"사과", "딸기", "바나나", "포도", "수박"}
		//	  ex) "1 23 456 7".split(공백);
		//	      반환 → 배열 → {"1, "23", "456", "7"}

		//==>> String[] str = {"20", "15"};
	
		if (str.length != 2)	// 입력값 개수가 2개가 아니라면~
			return false;		// input()메ㅗ드의 자리에 값의 반환 → false 그리고.. 메소드 종료~!!
								// false (거짓)를 반환하며 input() 메소드 종료 (main메소드 종료 X)
		
		// ※ 이 조건문을 수행할 경우 아래에 코드가 남아있는 상황이더라도
		//	  더 이상 수행하지 않고 결과값을 반환하며 메소드는 종료된다.

		x = Integer.parseInt(str[0]);
		y = Integer.parseInt(str[1]);


		System.out.print("연산자 입력 ( + - */ ) : ");
		op = (char)System.in.read();
		
		/*
		if (op!='+' && op!='-' && op!='*' && op!='/')
			return false;

		return true;
		*/

		if (op=='+' || op=='-' || op=='*' || op=='/')
			return true;

		return false;

	}//end input()

	
	double calc()
	{
		double result = 0;
		
		switch (op)
		{
		case '+': result = x+y; break;
		case '-': result = x-y; break;
		case '*': result = x*y; break;
		case '/': result = (double)x/y; break;
		}


		return result;
	}

}


// main() 메소드를 포함하고 있는 외부의 다른 class
public class Test108
{
	public static void main(String[] args) throws IOException
	{
		/*
		BClass ob = new BClass();

		ob.calc();
		*/

		BClass ob = new BClass();

		if (!ob.input())
		{
			System.out.println("Error...");
			return;			// main() 메소드 종료
		}

		double result = ob.calc();
		ob.write(result);
	}
}
/*
[실행 결과]
임의의 두 정수 입력 (공백 구분):20 15
연산자 입력 ( + - * / ) : -
>> 20 - 15 = 5.00
계속하려면 아무 키나 누르십시오 . . .
*/