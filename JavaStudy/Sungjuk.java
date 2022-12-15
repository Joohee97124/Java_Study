import java.util.Scanner;

public class Sungjuk
{
	// 내가 한 풀이
	/*
	int n;
	Record[] objArr;								// Record 형태의 배열 선언 (배열 이름 : objArr)


	void input()									// 인원수 입력받는 메소드
	{
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.print("인원 수 입력 (1~100) :");
			n = sc.nextInt();
		}
		while (n<1 || n>100);
	}


	void student()									// 이름, 국영수 점수 입력받는 메소드
	{
		Scanner sc = new Scanner(System.in);
		

		objArr = new Record[n];						// 배열 초기화 해주기 (n명)

		for (int i=0; i<n ;i++ )
		{
			objArr[i] = new Record();				// 배열 인스턴스 생성해주기-> 배열 초기화 하기 위해!

			System.out.printf("%d번째 학생의 이름 입력 :",(i+1));
			objArr[i].name = sc.next();
	
			System.out.print("국어점수 : ");
			objArr[i].kor = sc.nextInt();

			System.out.print("영어점수 : ");
			objArr[i].eng = sc.nextInt();
			
			System.out.print("수학점수 : ");
			objArr[i].mat = sc.nextInt();

			objArr[i].tot = objArr[i].kor + objArr[i].eng + objArr[i].mat ;	// 총점
			int total = objArr[i].tot;

			objArr[i].avg = (double) total/n;								// 평균
			double avger = objArr[i].avg;	
		}
	}


	void print()									// 출력하는 메소드
	{
		for (int i=0;i<n ;i++ )
		{
			System.out.printf("%s %d %d %d %d %.2f\n", objArr[i].name, objArr[i].kor, objArr[i].eng , objArr[i].mat , objArr[i].tot, objArr[i].avg);
		}
	}	
	*/



	// 함께 한 풀이
	//	- 속성 : 인원수, Record 형태의 배열 
	// 주요 속성 구성
	private int inwon;				//-- 인원 수
	private Record [] recArr;		//-- Record 형태의 배열
									//	 (학생 1명 당 Record 배열방 1개 활용)

	//	- 기능 : 인원수 입력, 상세 데이터 입력, 총점/평균 산출, 결과 출력
	// 메소드 정의
	// ① 인원 수 입력
	public void set()
	{
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.print("인원 수 입력 (1~100) :");
			inwon = sc.nextInt();
		}
		while (inwon<1 || inwon>100);
		
		// check~!!
		// Record 클래스를 기반으로 생성된 객체(인스턴스)를 담을 수 있는
		// 배열방을 inwon 만큼 생성한 것이지,
		// Record 클래스의 인스턴스를 생성한 것은 아니다. (인스턴스생성구문X 배열O)
		recArr = new Record[inwon];		//-- 인원만큼 "배열" 생성
	}
	
	//	- 기능 : 상세 데이터 입력, 총점/평균 산출, 결과 출력
	// 메소드 정의
	// ② 상세 데이터 입력 + ③ 총점/평균 산출
	public void input()
	{
		Scanner sc = new Scanner(System.in);

		String[] subTitle = {"국어 점수 : ", "영어 점수 ", "수학 점수 :"};

		for (int i=0; i<inwon ; i++ )	// 인원 수 만큼 반복~!! (inwon == recArr.length)
		{
			// 각각의 입력값들을 recArr 배열의 i번째 배열방에 담아내기
			// → Record 클래스 기반의 인스턴스 생성
			recArr[i] = new Record();

			System.out.printf("%d번째 학생의 이름 입력 : ", (i+1));
			recArr[i].name = sc.next();
			
			/*
			System.out.print("국어 점수 : ");
			recArr[i].score[0] = sc.nextInt();
			recArr[i].tot += rec.Arr[i].score[0];

			System.out.print("영어 점수 : ");
			recArr[i].score[1] = sc.nextInt();
			recArr[i].tot += recArr[i].score[1];

			System.out.print("수학 점수 : ");
			recArr[i].score[2] = sc.nextInt();
			recArr[i].tot += recArr[i].score[2];
			*/

			for (int j=0;j<subTitle.length ;j++ )	// 0 1 2
			{
				// 안내 메세지 출력
				System.out.print(subTitle[j]);
				
				// 사용자가 입력한 데이터를 스코어(score) 배열에 담아내기
				recArr[i].score[j] = sc.nextInt();

				// 국어, 영어, 수학 점수 데이터를 반복적으로 입력받는 동안
				// 그 과정에서 총점 누적하기
				recArr[i].tot += recArr[i].score[j];
			}


			// 평균 산출하기
			recArr[i].avg = recArr[i].tot / 3.0;
		}

	}//end input()


	//	- 기능 : 결과 출력
	// 메소드 정의
	// ④ 결과 출력
	public void print()
	{
		// 석차 산출 메소드 호출 구문 추가~!!!
		ranking();

		// 개행
		System.out.println();

		// 학생 1인 당 반복 출력 구문
		for (int i=0; i<inwon ; i++ )		//-- 학생 인원 수 만큼 반복~!!
		{
			// 이름 출력
			System.out.printf("%5s", recArr[i].name);

			// 성적(국어, 영어, 수학) 반복 출력
			for (int j=0; j<3 ; j++ )	// 0 1 2 → 국어 영어 수학
				System.out.printf("%4d", recArr[i].score[j]);
			
			// 총점 평균 출력
			System.out.printf("%5d", recArr[i].tot);
			System.out.printf("%8.2f", recArr[i].avg);

			// 석차 출력 구문 추가~!!!
			System.out.printf("%5d",recArr[i].rank);

			// 개행
			System.out.println();
		}

	}//end print()

	// 메소드 추가 정의
	// ⑤ 석차 산출
    private void ranking()
	{
		// 루프 변수
		int i,j;
		// 모든 학생들의 등수(석차)를 1로 초기화
		for (i=0; i<inwon ; i++ )

			recArr[i].rank = 1;
		
		// 등수 (석차) 산출
		for (i=0; i<inwon-1 ; i++ )		//-- i → 비교기준을 설정하는 인덱스 (마지막번 째까지 갈 필요X)
		{
			for (j=i+1;j<inwon ;j++ )	//-- j → 비교대상을 설정하는 인덱스 (끝까지 다 비교대상이 되어야해 + 비교기준보다 +1 커야하고 ,)
			{
				if (recArr[i].avg > recArr[j].avg)	// 기준데이터가 비교 데이터보다 크다면...
				{
					// 비교데이터의 rank를 1만큼 증가
					recArr[j].rank ++;
				}
				else if (recArr[j].avg > recArr[i].avg)	// 비교데이터가 기준데이터보다 크다면...
				{
					// 기준데이터의 rank를 1만큼 증가
					recArr[i].rank ++;
				}
			}
		}
	}



}