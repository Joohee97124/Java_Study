
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CircleTest	
{
	// 내가 한 풀이
	/*

	// 반지름,파이 변수 선언
	int r;
	double pi = 3.141592;

	// 원의 반지름을 입력받는 메소드
	void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("반지름 입력 : ");
		r = sc.nextInt();
	}
	
	// 원의 넓이 연산 메소드
	double calArea()
	{
		// 반지름*반지름*3.141592
		double area;
		area = r*r*pi;
		return area;

		// return r*r*pi;

	}
	
	// 원의 둘레 연산 메소드
	double calLen()
	{
		// 반지름*2*3.141592
		
		//double length;
		//length = r * 2 * pi;
		//return length;
		

		return r*2*pi;
	}

	// 출력 메소드
	void print(double a, double l)
	{
		System.out.printf(">> 반지름이 %d인 원의\n",r);
		System.out.printf(">> 넓이 : %.2f\n",a);
		System.out.printf(">> 둘레 : %.2f\n",l);
	}
	*/

	
	// 함께 한 풀이

	int r;					//-- 반지름
	// double pi = 3.141592;
	final double PI = 3.141592;	//-- 원주율
	// 『final』 : 변수의 상수화

	void input()	throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("반지름 입력 : ");
		r = Integer.parseInt(br.readLine());
	}

	double calArea()
	{
		// 원의 넓이 = 반지름 * 반지름 * 3.141592

		double result;

		//result = 반지름 * 반지름 * 3.141592
		result = r*r*PI;

		return result;	// 뼈대 먼저 세우기
	}

	double calLength()
	{
		// 원의 둘레 = 반지름 * 2 * 3.141592
		double result;

		// result = 반지름 * 2 * 3.141592
		result = r*2*PI;

		return result;
	}

	void print(double a, double l)
	{
		System.out.printf("\n>> 반지름이 %d인 원의 \n",r);
		System.out.printf(">> 넓이 : %.2f\n", a);
		System.out.printf(">> 둘레 : %.2f\n", l);
	}

}
