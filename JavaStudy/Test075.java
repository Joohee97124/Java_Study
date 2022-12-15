/*======================================
■■■ 클래스와 인스턴스 ■■■
- 생성자 (Constructor)
=======================================*/


class NumberTest2
{
	int num;
	
	/* 사용자 정의 생성자가 없을 때
	NumberTest2()
	{
	}
	*/
	
	// 사용자 정의 생성자 → 인자를 전달받는 생성자
	NumberTest2(int n)
	{
		num = n;
		
		// 시각적인 확인을 위한 출력 구문 삽입
		System.out.println("인자전달 : " + num);
	}

	int getNum()
	{
		return num;
	}

}

public class Test075
{
	public static void main(String[] args)
	{
		// NumberTest2 클래스 기반의 인스턴스 생성
		// NumberTest2 ob = new NumberTest2();
		//-- 사용자 정의 생성자를 정의한 이후 컴파일 에러 발생
		//  NumberTest2  클래스에는
		// 사용자 정의 생성자가 존재하고 있는 상황이기 때문에
		// 『default 생성자가』 (→NumberTest2())가 자동으로 생성되지(삽입되지) 않는다.

		// NumberTest2 클래스 기반의 인스턴스 생성

		NumberTest2 ob = new NumberTest2(10);
		//--==>> 인자전달 : 10
		//-- 인스턴스 생성과 동시에 인자값이 있는 사용자 정의 생성자 호출~!
		
		System.out.println("메소드 반환 값 : " + ob.getNum());
		//--==>> 메소드 반환 값 : 10

		// NumberTest2 클래스 기반의 인스턴스 생성
		NumberTest2 ob2 = new NumberTest2(2456);
		//--==>> 인자전달 : 2456

		System.out.println("메소드 반환 값 : " + ob2.getNum());
		//--==>> 메소드 반환 값 : 2456

	}
}