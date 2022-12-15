/*======================================
■■■ 클래스와 인스턴스 ■■■
- 생성자 (Constructor)
=======================================*/

/*
○ 생성자(Constructor)의 역할
	1. 메모리 할당
	2. 초기화
	
○ 생성자(Constructor)의 특징
	1. 생성자는 메소드이지만, 일반 메소드처럼 호출될 수 없으며,
	   반환 자료형을 가질 수 없다.
	   ( 『void』 조차 가질 수 없으며 값을 반환할 수도 없다.)
	2. 생성자는 클래스의 이름과 동일한 이름을 가져야 한다.
	   (대소문자까지도 정확히 일치해야 한다.)
	3. 생성자는 객체를 생성하는 과정에서 (인스턴스 생성 과정) 
	   『new』 생성자()의 형태로 호출된다.
	   (인스턴스 생성 시 단 한 번만 호출된다.)
*/

class NumberTest
{
	int num;
	
	// 자동으로 삽입되는 default 생성자
	//-- 컴파일 과정에서 자동으로 생성되는 이 생성자는
	//   사용자 정의 생성자가 존재하지 않을 경우에만 만들어진다.

	/*
	NumberTest()
	{
		// 텅 비어있는 상태
	}	
	*/

	NumberTest()
	{
		num=10;
		System.out.println("사용자 정의 생성자 호출!");

	}

	int getNum()
	{
		return num;
	}
}

// ※ 모든 클래스에는 생성자가 존재한다,
//	  (사용자 정의 생성자를 따로 만들지 않을 경우...
//	  컴파일 과정에서 default 생성자가 자동으로 삽입된다.)


public class Test074
{
	public static void main(String[] args)
	{
		// NumberTest 클래스 기반 인스턴스 생성
		NumberTest nt1 = new NumberTest();
		//-- 인스턴스가 생성되는 시점에서 
		//   이와 동시에 생성자 호출이 이루어진다.
		
		/*
		NumberTest nt1 = new NumberTest
								+
							NumberTest();
		*/

		System.out.println(nt1.getNum());
		//--==>>10

		nt1.num = 100;
		System.out.println(nt1.getNum());
		//--==>>100

		System.out.println("---------------------------");

		NumberTest nt2 = new NumberTest();

		System.out.println(nt2.getNum());
		//--==>> 10

	}
}