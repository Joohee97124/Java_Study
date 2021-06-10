/* ================================
■■■ 배열(Array) ■■■
- 배열의 복사
==================================*/

// ○ 실습 문제
// 임의의 배열 (a, b)에 들어있는 숫자들의 합집합을 출력하는 프로그램을 구현한다,.
// 단, 중복이 제거된 상태의 합집합을 출력할 수 있도록 한다.
// 또한, 배열 복사 개념을 적용시켜 처리할 수 있도록 한다.

// ex) 임의의 두 배열을 만들어놓기
// int[] a = {2, 3, 7, 10, 11}
// int[] b = {3,6,10,14}

// 실행 예)
/*
// 첫 번째 배열 요소를 입력하세요(공백 구분) : 2 3 7 10 11
// 두 번째 배열 요소를 입력하세요(공백 구분) : 3 6 10 14
*/

// 2 3 5 7 10 11 6 14


// 내가 한 풀이

class Cal
{
	int n=0;			//-- 중복되는 값의 개수
	int m;


	int [] a = {2, 3, 7, 10, 11};
	int [] b = {3, 6, 10, 14};
	int [] c ;
	int index;
	

	public void arrSum()						//-- 중복되는 값이 있으면 n++ 
	{
		for (int i=0; i<a.length ; i++ )
		{
			for (int j=0;j<b.length ;j++ )
			{
				if (a[i] == b[j])
				{
					n++;						
				}
			}
		}

		c = new int[a.length + b.length - n];	//-- 배열 c (합치는) 생성

		
		for (m=0;m<a.length ;m++ )
			c[m] = a[m];

		
		for (int j=0; j<b.length ; j++ )
		{
			boolean flag = false;

			for (int k=0; k<c.length; k++)
			{
				if (b[j]==c[k])					//-- 중복되는 값이 있으면 break;
				{
					flag = true;
					break;
				}
			}

			if (flag)
			{
				continue;
			}

			c[m] = b[j];
			m++;
		}

		

	}

	public void print()
	{
		for (int i=0; i<c.length; i++)
		{
			System.out.print(c[i]+" ");
		}

		
	}

}


public class Test099
{
	public static void main(String[] args)
	{
		// 내가 한 풀이
		Cal ob = new Cal();
		ob.arrSum();
		ob.print();


/*
		// 함께 한 풀이

		// 임의의 두 배열
		int[] a = {2, 3, 7, 10, 11};
		int[] b = {3,6,10,14};

		// 방법 ①
		// - 집합  a의 전체 요소 출력
		for (int i=0; i<a.length ; i++ )
			System.out.printf("%3d",a[i]);

		// - 집합  b의 요소 출력
		//   단, 집합 b는 집합 a의 요소와 중복되는 데이터를
		//   제거하면서 출력
		for (int i=0; i<b.length ; i++ )			// 4회전 (b.length=4) → 3 6 10 14(선택적 출력)
		{
			boolean flag = false;					// a의 것과 같지 않다고 가정

			for (int j=0; j<a.length ; j++ )		// 5회전(a의 요소들과 비교) → 2 3 7 10 11
			{
				if (b[i]==a[j])						// b웅 
				{
					flag = true;
					break;							// 멈춘다 그리고 빠져나간다 
													// (j 관련 반복문 탈출 + 중복되면 뒤의 것들은 비교 안해봐도 ㄱㅊ → i 반복문도 탈출)
				}
			}

			if (flag)								// flag가 true라면 ....
				continue;							// 뒷부분 무시하고 ... 계속해라...

			System.out.printf("%3d",b[i]);			// 뒷부분 (출력 구문)

		}
		System.out.println();




		// 방법 ②
		// - 임시 배열을 만들고
		// int [] temp = new int[???];
		int [] temp = new int[a.length + b.length];

		// - 만들어진 임시 배열에 중복되지 않은 배열 요소를 채운 다음
		//check~!!!
		int n;							//-- 변수 선언 위치 중요~!!!

		for (n=0; n<a.length ; n++ )
			temp[n] = a[n];

		// 테스트
		// System.out.println(n);
		//--==>> 5


		for (int k=0; k<b.length ; k++)
		{
			boolean flag = false;

			for (int m=0 ; m<a.length ; m++ )
			{
				if (b[k] == a[m])
				{
					flag = true;
					break;			
				}
			}

			if (flag)
				continue;

			temp[n] = b[k];			//-- 뒷부분
			n++;					//-- 뒷부분

			// 테스트
			// System.out.println(n);
			//--==>> 7

		}

		// - 그렇게 구성된 임시 배열을 출력 (채워진만큼...)
		for (int h=0; h<n ; h++ )
		{
			System.out.printf("%3d",temp[h]);
		}
		System.out.println();
*/		

	}
}