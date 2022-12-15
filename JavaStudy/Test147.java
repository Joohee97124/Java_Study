/*======================================
■■■ 예외(Exception) 처리 ■■■
- 잡아낸 예외 다시 던지기
======================================*/


public class Test147
{
	public static void main(String[] args)
	{
		Test147 ob = new Test147();
		
		try
		{
			int a= ob.getValue(-3);
			System.out.println("a : " + a);
		}
		catch (Exception e)
		{
			System.out.println("printStackTrace...(main)");
			e.printStackTrace();
		}
	}


	public int getData(int data) throws Exception // 발생된 예외 던져주기
	{
		if (data<0)
			throw new Exception("data가 0보다 작습니다.");		// ① 예외 발생

		return data + 10;
	}


	public int getValue(int value) throws Exception // ⑤ 땜에 써줘야해
	{
		int a=0;
		
		try
		{
			a = getData(-2);									// ② 예외 발생
		}
		catch (Exception e)										// ③ 예외 잡아내기
		{
			// ④ 잡아낸 예외에 대한 처리
			System.out.println("printStackTrace...");
			e.printStackTrace();

			// ⑤ 잡아낸 예외를 다시 던지기 (→ 예외 다시 발생)
			throw e;
			//-- 3에서 잡아낸 예외를 다시 이 메소드를 호출한 지점으로 던지는 구문
			// 『throw e』 주석 처리 시
			// 즉, 잡아낸 예외를 다시 던지지 않을 경우
			// main() 메소드의 try~catch는 수행되지 않게 된다. + getValue에서도 다시 안던짐
		}

		return a;
	}
}
/*
[실행결과]
printStackTrace...
java.lang.Exception: data가 0보다 작습니다.
        at Test147.getData(Test147.java:29)
        at Test147.getValue(Test147.java:41)
        at Test147.main(Test147.java:15)
// → getValue에서의 예외처리
printStackTrace...(main)
java.lang.Exception: data가 0보다 작습니다.
        at Test147.getData(Test147.java:29)
        at Test147.getValue(Test147.java:41)
        at Test147.main(Test147.java:15)
// → main()에서의 예외처리
계속하려면 아무 키나 누르십시오 . . .
*/
