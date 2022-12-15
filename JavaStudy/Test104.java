/*=========================================
■■■ 정렬(Sort) 알고리즘■■■
- 향상된 버블 정렬(Bubble Sort : 거품 정렬)
==========================================*/

/*
※ 앞서 공부한 Selection Sort나 Bubble Sort의 성능은 같다. (반복의 횟수로 추정)
   하지만, 향상된 Bubble Sort는 대상이 되는 데이터의 구조에 따라
   일반 Bubble Sort나 Selcetion Srot보다 성능이 좋을 수 있다.

원본 데이터 = 61 15 20 22 30
			  15 20 22 30 61	-- 1회전 (스왑 발생) → 다음 회전 ㅇ
			  15 20 22 30 61	-- 2회전 (스왑 발생 안함) → 다음 회전 x

==> 1회전 수행...2회전 수행...을 해보았더니...
	2회전을 수행하는 과정에서 스왑(자리바꿈)이 전혀 일어나지 않았기 때문에
	불필요한 추가 연산(회전:반복)을 수행하지 않는다.
	즉, 더 이상의 반복은 무의미한 것으로 판단한다.
*/


public class Test104
{
	public static void main(String[] args)
	{
		int[] a = {10, 50, 20, 33, 40};

		/*
		10, 50, 20, 33, 40		→ 0 1
		======

		10, 50, 20, 33, 40		→ 1 2
			======

		10, 20, 50, 33, 40		→ 2 3
				======

		10, 20, 33, 50, 40		→ 3 4
					======

		------------------------------- 1회전
	
		10, 20, 33, 40, 50		
		=======					→ 0 1
			======				→ 1 2
				=======			→ 2 3
	
		------------------------------- 2회전
		
		X (3회전)
		X (4회전)
		*/

		
		System.out.print("Source Data : ");
		for (int n : a )
			System.out.print(n + " ");
		System.out.println();

		//향상된 Bubble Sort 구현

		//내 풀이
		/*
		int i,j;
		boolean flag = false;
	
		for (j=1; j<4;j++ )
		{
			for (i=0;i<a.length-j ;i++ )
			{
				if (a[i] > a[i+1])
				{
					a[i] = a[i]^a[i+1];
					a[i+1] = a[i+1]^a[i];
					a[i] = a[i]^a[i+1];
				}
				else
					flag = true;
			}
			if (flag)
				{
					break;
				}
		}
		*/

		// 함께 한 풀이
		int pass=0;					// 아까의 i 역할
		boolean flag;		// 자리바꿈을 확인하기 위한 변수

		do
		{
			pass++;
			flag = false;	// 얘가 여기서 false가 되어야 1회전 한 다음에 다시 false로 초기화된다!
							// 초기화가 되어야 다음 회전에서 자리를 바꾸는지 확인할 수 있음

			for (int i=0; i<a.length-pass ; i++ )
			{
				if (a[i] > a[i+1])
				{
					// 자리 바꾸기
					a[i] = a[i]^a[i+1];
					a[i+1] = a[i+1]^a[i];
					a[i] = a[i]^a[i+1];

					flag = true;		// 자리 바꿈이 일어났다는 사실 확인
				}
			}
		}
		while (flag);
		// 회전이 구분적으로 발생하는 동안 (웅~) 스왑(자리바꿈)이 일어나지 않은 경우로
		// 더 이상의 반복문 수행은 무의미한 것으로 판단~!!



		System.out.print("Sorted Data : ");
		for (int n : a )
			System.out.print(n + " ");
		System.out.println();

	}
}