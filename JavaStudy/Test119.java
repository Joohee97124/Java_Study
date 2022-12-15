/*==============================
■■■ 클래스 고급■■■
- 중첩클래스 
==============================*/

// 외부 클래스(outer)
class InnerOuterTest
{
	static int a=10;
	int b =20;
	

	// 내부 클래스(inner)
	class InnerNested
	{
		int c=30;
		
		// ▶ inner의 write() 메소드
		void write()
		{

			System.out.println("inner의 write()...");

			System.out.println("a : " + a);
			System.out.println("b : " + b);
			System.out.println("c : " + c);
		}
	}
	

	// ▶ outer의 write() 메소드
	void write()
	{
		System.out.println("outer의 write()...");

		// 내부 클래스의 인스턴스 생성
		InnerNested ob1 = new InnerNested();

		// inner의 write() 메소드 호출
		ob1.write();

	}
}


// main() 메소드를 포함하고 있는 외부의 다른 클래스
public class Test119
{
	public static void main(String[] args)
	{
		// 외부 클래스(outer)의 인스턴스 생성
		InnerOuterTest ob2 = new InnerOuterTest();
		
		// outer의 write() 메소드 호출
		ob2.write();
		//--==>> outer의 write()...
		//       inner의 write()...
		//       b : 20
		//       c : 30


		// InnerNested ob3 = new InnerNested();
		//--==>> 에러 발생(컴파일 에러)

		// InnerOuterTest.InnerNested ob4 = new InnerOuterTest.InnerNested();
		//--==>> 에러 발생 (컴파일 에러)
		// static 클래스가 아니니까

		// ※ 중첩 내부 클래스(static 내부 클래스) 와는 달리
		//	  외부 클래스의 인스턴스(객체)를 사용하지 않고
		//	  단독으로 내부 클래스의 인스턴스를 생성하는 것은
		//	  불가능하다.

		// ※ Test117.java와 비교할 것~!!!

		InnerOuterTest.InnerNested ob5 = ob2.new InnerNested();
		ob5.write();
		//--==>> inner의 write()...
		//       a : 10
		//       b : 20
		//       c : 30

		InnerOuterTest.InnerNested ob6 = new InnerOuterTest().new InnerNested();
		//--==>> inner의 write()...
		//       a : 10
		//       b : 20
		//       c : 30

		

	}
}
/*
[실행 결과]
outer의 write()...
inner의 write()...
a : 10
b : 20
c : 30
계속하려면 아무 키나 누르십시오 . . .
*/