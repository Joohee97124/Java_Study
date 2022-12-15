/*======================================
■■■ 자바의 주요(중요) 클래스 ■■■
- StringBuffer 클래스
======================================*/

/*
○ StringBuffer 클래스는
   문자열을 처리하는 클래스로 String 클래스와의 차이점은
   String 클래스는 내부 문자열 데이터의 수정이 불가능하지만
   StringBuffer 클래스는 문자열을 사용할 때
   내부 문자열을 실행 단계에서 변경할수 있다는 점이다.

   즉, StringBuffer 객체는 가변적인 길이를 가지므로
   객체를 생성하는 시점에서 미리 그 크기나 값을 지정하거나
   실행 시점에 버퍼 크기를 바꿀 수 있는 기능을 제공하는 것이다.

   또한 JDK 1.5 이후부터는
   문자열을 처리하는 StringBuilder 라는 클래스도 제공한다.
   StringBuilder 클래스의 기능은 StringBuffer 클래스와 동일하지만
   가장 큰 차이점은 multi-thread unsafe 라는 점이다.
   즉, Syncronization 이 없기 때문에 
   StringBuffer 보다 빠르며 동시성(동기화) 문제가 없다면
   StringBuilder 를 사용하는 것이 성능을 향상시킬 수 있다.

*/

// import java.lang.*;

public class Test133
{
	public static void main(String[] args)
	{
		StringBuffer sb1 = new StringBuffer("korea");
		StringBuffer sb2 = new StringBuffer("korea");
		
		System.out.println(sb1==sb2);			//--==>> false
		System.out.println(sb1.equals(sb2));	//--==>> false

		System.out.println(sb1.toString().equals(sb2.toString()));
		//--==>> true

		/*
		String str1 = sb1.toString();
		String str2 = sb2.toString();

		Sytem.out.println(str.equals(str2));
		*/


		StringBuffer sb3 = new StringBuffer();
		//-- StringBuffer 기본 생성자 호출 시(인스턴스 생성 과정)
		//	 기본적으로 생성되는 버퍼 크기 『16』

		System.out.println("버퍼 크기 : " + sb3.capacity());
		//--==>> 버퍼 크기 : 16


		////////////////////////////////////////////////////////////////////////////

		System.out.println(sb3);
		//--==>> 無 

		sb3.append("seoul");			// sb3 += "seoul"; → sb3 = sb3 + "seoul"; → sb3 = "" + "seoul"; → sb3 = "seoul";
		sb3.append("korea");
		sb3.append("우리나라");
		sb3.append("대한민국");

		System.out.println(sb3);
		//--==>> seoulkorea우리나라대한민국

		System.out.println(sb3.toString());
		//--==>> seoulkorea우리나라대한민국

		System.out.println("버퍼 크기 : " + sb3.capacity());
		//--==>> 버퍼 크기 : 34

		
		////////////////////////////////////////////////////////////////////////////

		String temp1 = "java and oracle";
		System.out.println(temp1.toUpperCase());
		//--==>> JAVA AND ORACLE

		String temp2 = "JAVA AND ORACLE";
		System.out.println(temp2.toLowerCase());
		//--==>> java and oracle 
		
		// System.out.println(sb3.toUpperCase());
		// System.out.println(sb3.toLowerCase());

		String temp3 = sb3.toString();
		System.out.println(temp3.toUpperCase());
		System.out.println(temp3.toLowerCase());
		System.out.println(sb3.toString().toUpperCase());
		//--==>> SEOULKOREA우리나라대한민국
		//       seoulkorea우리나라대한민국
		//		 SEOULKOREA우리나라대한민국
		// sb3의 값이 바뀐 것은 X


		//       seoulkorea우리나라대한민국
		
		// ○ 대상문자열(sb3) 중 seoul 문자열 앞에
		//	  『한국』이라는 문자열 추가
		sb3.insert(0, "한국");
		System.out.println("seoul 앞에 『한국』 추가 : " + sb3.toString());
		//--==>> seoul 앞에 『한국』 추가 : 한국seoulkorea우리나라대한민국

		// 한국seoulkorea우리나라대한민국

		// ○ 대상 문자열(sb3) 중 seoul 문자열 뒤에 
		//	  『사랑』이라는 문자열 추가
		//	  단, 대상 문자열의 인덱스를 직접 확인하지 말고...
		
		/*
		// 1. insert() 메소드 사용하기
		sb3.insert (sb3.indexOf("seoul")+5, "사랑");
		System.out.println("seoul 뒤에 『사랑』 추가 : " +sb3.toString());

		
		// 2. append() 메소드 사용하기 → append("추가할 문자열" , 들어갈 인덱스, 추가할 문자열 길이);
		sb3.append("사랑", sb3.indexOf("seoul"), 2);
		System.out.println("seoul 뒤에 『사랑』 추가 : " +sb3.toString());
		//-- sb3.indexOf("seoul"); → 2
		*/

		
		// step 1
		System.out.println(sb3.toString());
		//--==>> 한국seoulkorea우리나라대한민국

		// step 2
		// sb3.insert(7, "사랑");
		// System.out.println("seoul 뒤에 『사랑』 추가 : " + sb3.toString());
		//--==>> seoul 뒤에 『사랑』 추가 : 한국seoul사랑korea우리나라대한민국

		// step 3
		System.out.println(sb3.indexOf("seoul"));	
		//--==>> 2


		// step 4
		// sb3.insert(sb3.indexOf("seoul"), "사랑");
		// System.out.println(sb3.toString());
		//--==>> 한국seoulkorea우리나라대한민국

		// step 5
		// sb3.insert(sb3.indexOf("seoul")+5, "사랑");
		// System.out.println(sb3.toString());
		//--==>> 한국seoul사랑korea우리나라대한민국

		// step 6
		// sb.insert(sb3.indexOf("seoul")+(("seoul"의 길이), "사랑");
		// System.out.println(sb3.toString());
		
		// step 7
		sb3.insert(sb3.indexOf("seoul") + "seoul".length(), "사랑");
		System.out.println(sb3.toString());
		//--==>> 한국seoul사랑korea우리나라대한민국


		// ○ 『우리나라』 문자열 삭제
		// sb3.delete(14, 18);
		// System.out.println(sb3.toString());
		//--==>> 한국seoul사랑korea대한민국
		

		sb3.delete(sb3.indexOf("우리나라") , sb3.indexOf("우리나라")+"우리나라".length() );
		System.out.println(sb3.toString());
		//--==>> 한국seoul사랑korea대한민국
		

		
		// ○ 대상 문자열(sb3)에서
		//	  『korea』 부터 문자열 삭제
		// sb3.delete(sb3.indexOf("korea") , sb3.indexOf("korea") + "korea대한민국".length() );
		// System.out.println(sb3.toString());
		//--==>> 한국seoul사랑


		// sb3.delete(sb3의"korea"문자열시작위치 , sb3의문자열길이 );
		sb3.delete(sb3.indexOf("korea") , sb3.length() );
		System.out.println(sb3.toString());
		//--==>> 한국seoul사랑


		// ○ 대상 문자열(sb3) 에서
		//	  『seoul』 이후 문자열 삭제 (seoul 제외)
		sb3.delete(sb3.indexOf("seoul")+"seoul".length() , sb3.length());
		System.out.println(sb3.toString());
		//--==>> 한국seoul

		
		///////////////////////////////////////////////////////////////////////////////////

		// 버퍼 크기 확인
		System.out.println("버퍼 크기 : " + sb3.capacity());
		//--==>> 버퍼 크기 : 34
		
		// 문자열 (sb3)의 길이 확인
		System.out.println("문자열의 길이 : " + sb3.length() );
		//--==>> 문자열의 길이 : 7

		// 버퍼 크기 조절 → 현재 문자열을 담아둘 수 있는 버퍼 크기로....
		sb3.trimToSize();
		
		// 버퍼 크기 조절 이후 다시 버퍼 크기 확인
		System.out.println("버퍼 크기 : " + sb3.capacity());
		//--==>> 버퍼 크기 : 7



		
	}
}
