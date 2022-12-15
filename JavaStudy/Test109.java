/*=========================================
■■■ 클래스 고급■■■
- 상속 (Inheritance)
==========================================*/
/*
※ 메소드 오버라이딩(Method Overriding)의 특징
	
	- 메소드 이름, 리턴 타입, 파라미터 수나 타입이 완전히 일치해야 한다.
	- 반드시 상속 관계가 있어야 한다.
	- 재정의된 하위 클래스의 메소드 접근제어지시자는
	  상위 클래스의 메소드 접근제어지시자보다 범위가 크거나 같아야 한다.
	  예를 들어, 상위 클래스 메소드의 접근제어지시지사가 『protected』인 경우
	  하위 클래스가 이 메소드를 오버라이딩(Overriding)하는 경우
	  접근제어지시자는 『protected』 또는 『public』 이어야 한다.
	- 『static』, 『final』, 『private』 메소드는 오버라이딩 (Overriding) 할 수 없다.
	- Exception의 추가가 불가능하다.
	  즉, 상위 클래스의 메소드가 가지고 있는 기존의 예외 사항에
	  새로운 Exception 을 추가하는 것은 불가능하다.
*/


// 상위 클래스, 부모 클래스, super class
class SuperTest109
{
	private int a=5;
	protected int b=10;
	public int c=20;

	public void write()
	{
		System.out.println("Super write() 메소드 : " + a + " : " + b + " : " + c);
	}
}

// 하위 클래스, 자식 클래스, sub class
class SubTest109 extends SuperTest109
{
	/*
	protected int b=10;
	pulic int c=20;

	public void write()
	{
		System.out.println("Super write() 메소드 : " + a + " : " + b + " : " + c);
	}
	*/

	protected int b=100;

	public void print()
	{
		// System.out.println("Sub print() 메소드 : " + a +" : " + b + " : " + c);
		//--==>> 에러 발생 (컴파일 에러)
		//-- 슈퍼 클래스(SuperTest109)에서 선언된 변수 a에는 접근할 수 없다.
		//	 → private 변수이기 때문에...

		System.out.println("Sub print() 메소드 : " + b + ":" + c);
		//--==>> Sub print() 메소드 : 100:20

		System.out.println("Sub print() 메소드 : " + super.b +":" + c);
		//--==>> Sub print() 메소드 : 10:20
		//-- 슈퍼클래스 (SuperTest09)에서 선언된 변수 b에 접근하기 위해서는
		//	 『super』 키워드를 사용하면된다.

		System.out.println("Sub print() 메소드 : " + c);
		System.out.println("Sub print() 메소드 : " + this.c);
		System.out.println("Sub print() 메소드 : " + super.c);
		//--==>>
		/*
		Sub print() 메소드 : 20
		Sub print() 메소드 : 20
		Sub print() 메소드 : 20
		*/
		//-- 슈퍼클래스 (SuperTset109)에서 선언된 변수 c 에 접근하는 데에는
		//	 아무런 제약이나 제한이 없다.
	}
	
	@Override
	public void write()
	{
		// System.out.println("Sub write() 메소드 : " + a + ":" + b + ":" + c);
		System.out.println("Sub write()메소드 : " +b+":"+c);
	}
}

// main() 메소드를 포함하고 있는 외부의 다른 클래스
public class Test109
{
	public static void main(String[] args)
	{
		// 하위 클래스 (Test109)인스턴스 생성
		SubTest109 ob = new SubTest109();

		ob.print();
		//--==>> Sub print() 메소드 : 100:20

		ob.write();
		//--==>> Super write() 메소드 : 5 : 10 : 20
		// ※ write() 메소드 오버라이딩 후...
		//--==>> Sub write()메소드 : 100:20
		//--  슈퍼클래스 (SuperTest109) 에서 선언된 변수 a에 접근할 수 없다.
		// → private 변수이기 때문에...
		//	  또한, 이 때 접근한 변수 b는 부모로부터 물려받은 b가 아닌
		//	  자신의 변수 b인 것을 확인 할 수 있다.

		//===================================================================

		System.out.println("---------------------------------------------------구분선");
		
		// 메소드
		ob.write();
		((SuperTest109)ob).write();				// check~!!
		//--==>> Sub write()메소드 : 100:20
		

		// 변수
		System.out.println(ob.b);
		//--==>> 100
		System.out.println(((SuperTest109)ob).b);	// check~!!
		//--==>> 10

		// ※ 슈퍼 부름 (변수만 가능)

		// ※ 메소드와 변수를 꼭 구분하여 정리해 둘 것~!!




	}
}