/*======================================
■■■ 클래스 고급■■■
- 인터페이스(Interface)
======================================*/

// 인터페이스
interface ADemo
{
	public void write();
}


// 인터페이스
interface BDemo
{
	public void print();
}


// 클래스
// class DemoImpl
// ↓
// 두 인터페이스를 구현하는 추상 클래스
// abstract class DemoImpl implements ADemo, BDemo
// ↓
// 두 인터페이스를 구현하는 클래스
class DemoImpl implements ADemo, BDemo
{
	// JDK 1.5(5.0)에서는 인터페이스 메소드를 오버라이딩(Overriding) 할 때
	// 『@Override』 어노테이션(annotation)을 사용할 수 없다.
	// JDK 1.6 이후부터 적용 가능한 문법이다.
	// 단, 상속받은 클래스의 메소드를 오버라이딩(Overriding) 할 때에는
	// JDK 1.5에서도 『@Override』 어노테이션(annotation) 사용이 가능하다.
	@Override
	public void write()
	{
		System.out.println("ADemo 인터페이스 메소드...");
	}

	@Override
	public void print()
	{
		System.out.println("BDemo 인터페이스 메소드...");
	}
}



// main() 메소드를 포함하는 외부 클래스
public class Test113
{
	public static void main(String[] args)
	{
	
		// ADemo ob = new ADemo();		//-- 인터페이스 → 인스턴스 생성 불가
		// BDemo ob = new BDemo();		//-- 인터페이스 → 인스턴스 생성 불가
		
		// ADemo, BDemo 인터페이스를 구현(implements) 한 클래스 (→ DemoImpl)
		// 기반의 인스턴스 생성
		DemoImpl ob1 = new DemoImpl();

		ob1.write();
		ob1.print();
		//--==>> ADemo 인터페이스 메소드...
		//		 BDemo 인터페이스 메소드...


		ADemo ob2 = new DemoImpl();		//-- 업 캐스팅
		BDemo ob3 = new DemoImpl();		//-- 업 캐스팅

		// ob2.print();
		// ob3.write();
		//--==>> 에러 발생(컴파일 에러)

		((BDemo)ob2).print();
		((ADemo)ob3).write();
		// DemoImpl이 ADemo와 BDemo 모두 implements 할 때만 이 구문이 가능!
		//--==>> BDemo 인터페이스 메소드...
		//		 ADemo 인터페이스 메소드...

		// ※ DemoImpl 클래스가 ADemo, BDemo 두 인터페이스를
		//	  모두 구현했기 때문에 가능하다.
		//	  만약, DemoImpl 클래스가 두 인터페이스 중 하나만
		//	  구현한 상황이라면 처리할 수 없는 구문이 된다.
		//	  얘는 다운 캐스팅이 아니다!
		

		((DemoImpl)ob2).print();			//-- 다운 캐스팅
		((DemoImpl)ob3).write();			//-- 다운 캐스팅
		//--==>> BDemo 인터페이스 메소드...
		//		 ADemo 인터페이스 메소드...

	}
}

/*
[실행결과]
ADemo 인터페이스 메소드...
BDemo 인터페이스 메소드...
BDemo 인터페이스 메소드...
ADemo 인터페이스 메소드...
BDemo 인터페이스 메소드...
ADemo 인터페이스 메소드...
계속하려면 아무 키나 누르십시오 . . .
*/