/*==============================
■■■ 클래스 고급■■■
- 중첩클래스 
==============================*/

/*
○ Annonymous 클래스(익명의 클래스, 무명 클래스)
   
   - AWT 나 안드로이드 이벤트 처리에서 일반적으로 사용
   - 상위 클래스 메소드를 하나 정도 재정의할 필요성이 있을 때 사용
   - 클래스의 객체가 필요하면 또 다시 클래스를 생성해야 하는 
     번거로움 때문에 익명의 클래스를 생성하여 처리한다.


○ 형식 및 구조

	new 상위클래스의생성자()
	{
		접근제어지시자 자료형 메소드()
		{
			//...;
		}
	};	// ← 반드시 세미콜론 필요함~!!!

*/

// import java.lang.Object;
// import java.lang.*;


// 외부 클래스
class Test	//extends Object
{ 
	// super...; 가능


	public Object getString()
	{
		// 익명의 클래스
		return new Object()
		{
			@Override
			public String toString()
			{
				return "익명의 클래스...";
			}
		};	// ← 세미콜론(미 작성 시 에러 발생)
	}
}

// main() 메소드를 포함하는 외부의 다른 클래스
public class Test120
{
	public static void main(String[] args)
	{
		Test ob1 = new Test();
		Test ob2 = new Test();

		System.out.println(ob1.toString());
		//--==>> Test@15db9742

		System.out.println(ob1.getString());
		//--==>> 익명의 클래스...
	}
}