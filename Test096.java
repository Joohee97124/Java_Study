/* ===============================================
■■■ 메소드 중복정의(Method Oberloading) ■■■
- 메소드 오버로딩이 가능한 형태와 불가능한 형태
================================================*/


public class Test096
{
	public static void main(String[] args)
	{
		print();
		print(10);

		double result = print(10.1);
		print(10.1);
	}

	public static void print(){}
	public static void print(int i){}
	// public static void print(int j){}					 //-- (X)
	public static void print(char c){}						 //-- ※ 자동 형 변환 규칙 check~!!!
	public static void print(int i, int j){}
	public static void print(int i, double d){}				 //-- ※ 자동 형 변환 규칙 check~!!!
	public static void print(double d, int k){}				 //-- ※ 자동 형 변환 규칙 check~!!!
	public static double print(double d){return 3.14}	
	public static void print(double d){}					//-- (X)
	// 25,26 을 자바는 구분/이해 못해,, 머부르는지 알 수가 없음
	// 왼쪽항은 보지도 않아 자바는 ㅠ print메소드 호출 할 때 자바는 
	// 오른쪽 항만 보는데 오른쪽 항이 똑같네,,? 자바는 못찾음,,								

	public static String print(double d){}

}