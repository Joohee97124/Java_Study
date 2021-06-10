
import java.util.Scanner;
import java.util.Calendar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;


class SalesManagement extends Cash
{
	String buyer;								// MemberInfo정보를 받기 위해 메인에서 일치시키는 이름
	String select;								// 사용자로부터 입력받은 메뉴 선택
	Calendar now = Calendar.getInstance();

	int arrTotal;								// 정렬 시 확인할 수 있는 총 매출액

	SalesManagement() throws IOException
	{
		
	}

	// 매출현황 확인 or 시재 확인, 입력 메뉴 선택
	public void showChoice() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		// 메뉴 선택
		try
		{
			System.out.println();
			System.out.println();
			System.out.println("\t======================================================================================");	
			System.out.println();
			System.out.println("\t\t1. 매출 현황 확인");
			System.out.println("\t\t2. 시재 확인 및 입력");
			System.out.println();
			System.out.println("\t======================================================================================");	
			System.out.print("\t    원하시는 메뉴를 선택해주세요 : ");
			select = sc.next();

			if (!select.equals("1") && !select.equals("2"))
				throw new choiceException(select);
		}//try문 닫기
		catch (choiceException e)
		{
			e.showWrongChoice();
			System.out.println("\t선택을 처음부터 다시 진행합니다.");
			this.choiceMenu();
		}//catch 문 닫기

		switch (select)
		{
			case "1": this.choiceMenu(); break;
			case "2": this.choiceMoney(); break;
		}
		
	}//showChoice 끝
	

	// 매출현황 정렬 방식 선택 메뉴
	public void choiceMenu() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		// 메뉴 선택
		try
		{
			System.out.println();
			System.out.println();
			System.out.println("\t=========================================================================================================");
			System.out.println();
			System.out.println("\t\t1. 일자별 매출현황");
			System.out.println("\t\t2. 메뉴별 매출현황");
			System.out.println("\t\t3. 회원별 결제내역");
			System.out.println("\t\t4. 결제수단별 매출현황");
			System.out.println("\t\t5. 목표매출액과 달성률");
			System.out.println("\t\t6. 관리자 메인 화면으로 돌아가기");
			System.out.println();
			System.out.println("\t=========================================================================================================");
			System.out.print("\t    원하시는 메뉴를 선택해주세요 : ");
			select = sc.next();

			if (!select.equals("1") && !select.equals("2") && !select.equals("3") && !select.equals("4") && !select.equals("5") && !select.equals("6"))
				throw new choiceException(select);
		}//try문 닫기
		catch (choiceException e)
		{
			e.showWrongChoice();
			System.out.println("\t선택을 처음부터 다시 진행합니다.");
			this.choiceMenu();
		}//catch 문 닫기

		switch (select)
		{
			case "1": this.dateArray(); break;
			case "2": this.menuArray(); break;
			case "3": this.memberArray(); break;
			case "4": this.cardCashArray(); break;
			case "5": this.goalArray(); break;
			case "6": managerMenu(); break;
		}
	} //choiceMenu 끝

	// MemberInfo자료형을 가지는 ArrayList 자료구조를 사용해서
	// 매출현황 출력 시 필요한 데이터들을 한번에 담고, 원하는 방식대로 정렬해서 출력하기 위한 클래스
	//→ 일자별 / 메뉴별 / 회원별 / 결제수단별로 <클래스>를 나눠, 정렬 기준을 다르게 오버라이딩함

	// 정렬 출력 시 확인하기 위한 임의 데이터 추가
	public void defaultData()
	{

		list.add(new MemberInfo(2021, 3, 15, "전혜림", "발렌시아", 1, 20000, "카드"));
		list.add(new MemberInfo(2021, 3, 16, "전혜림", "블루 하와이", 1, 10000, "카드"));
		list.add(new MemberInfo(2021, 3, 17, "전혜림", "마가리타", 1, 10000, "현금"));
		list.add(new MemberInfo(2021, 3, 18, "전혜림", "진 라임", 1, 10000, "현금"));

		list.add(new MemberInfo(2021, 3, 15, "김가영", "데킬라 사워", 1, 10000, "카드"));
		list.add(new MemberInfo(2021, 3, 16, "김가영", "코스모폴리탄", 1, 18000, "카드"));
		list.add(new MemberInfo(2021, 3, 17, "김가영", "선 번", 1, 10000, "현금"));
		list.add(new MemberInfo(2021, 3, 18, "김가영", "허니문", 1, 20000, "현금"));

		list.add(new MemberInfo(2021, 3, 15, "정주희", "클로버 클럽", 1, 10000, "카드"));
		list.add(new MemberInfo(2021, 3, 16, "정주희", "피냐 콜라다", 1, 15000, "카드"));
		list.add(new MemberInfo(2021, 3, 17, "정주희", "발렌시아", 1, 20000, "현금"));
		list.add(new MemberInfo(2021, 3, 18, "정주희", "크래커", 4, 12000, "현금"));

		list.add(new MemberInfo(2021, 3, 15, "안정미", "아몬드", 5, 10000, "카드"));
		list.add(new MemberInfo(2021, 3, 16, "안정미", "블루 하와이", 1, 15000, "카드"));
		list.add(new MemberInfo(2021, 3, 17, "안정미", "발렌시아", 1, 20000, "현금"));
		list.add(new MemberInfo(2021, 3, 18, "안정미", "데킬라 사워", 1, 10000, "현금"));

		list.add(new MemberInfo(2021, 3, 15, "박정준", "마가리타", 1, 10000, "카드"));
		list.add(new MemberInfo(2021, 3, 16, "박정준", "코스모폴리탄", 1, 18000, "카드"));
		list.add(new MemberInfo(2021, 3, 17, "박정준", "블루 하와이", 1, 10000, "현금"));
		list.add(new MemberInfo(2021, 3, 18, "박정준", "크래커", 5, 15000, "현금"));
	}

	// 일자별 매출현황
	public void dateArray() throws IOException
	{
		DateArray dateArray = new DateArray();
		int arrTot1 = 0;
			
		Collections.sort(list, dateArray);

		System.out.println();
		System.out.println();

		System.out.println();
		System.out.println("\t========================================= [ 일자별 매출현황 ] ===========================================");	
		System.out.println();
		System.out.println("\t  No   \t\t결제시각\t\t  결제메뉴\t구매자\t 수량\t결제금액\t결제수단");
		System.out.println("\t=========================================================================================================");	
		
		ListIterator it = list.listIterator();
		int num=0;

		while (it.hasNext())
		{
			MemberInfo obj = (MemberInfo)it.next();

			if (obj.getD()!=0)
			{
				num++;
				System.out.printf("\t  %2d\t\t%4d년 %2d월 %2d일\t%6s\t%3s\t%d개\t%,d\t\t%s\n",
				num, obj.getY(), obj.getM(), obj.getD(), obj.getMainMenu(),
				obj.getName(), obj.getMainCount(), obj.getEveryTotal(), obj.getStrHow());
			}
			arrTot1 += obj.getEveryTotal();
		}
		System.out.println();	
		
		System.out.println("\t=========================================================================================================");	
		System.out.printf("\t  총 매출액: %,d원\n", arrTot1);
		System.out.println("\t=========================================================================================================");	
		
		choiceMenu();
	}


	// 메뉴별 매출현황>>> 결제 메뉴 기준 오름차순 정렬
	public void menuArray() throws IOException
	{
		
		// 메뉴 기준으로 오름차순 정렬하기 위해 정렬 기준 오버라이딩한 클래스 인스턴스 생성
		MenuArray menuArray = new MenuArray();
		int arrTot2 = 0;

		// 메뉴기준 오름차순 정렬 후 출력
		Collections.sort(list, menuArray);
		
		System.out.println();
		System.out.println();
		System.out.println("\t========================================= [ 메뉴별 매출현황 ] ===========================================");	
		System.out.println();
		System.out.println("\t  No   \t 결제메뉴\t\t  결제시각\t\t구매자\t 수량\t결제금액\t결제수단");
		System.out.println("\t=========================================================================================================");
		
		ListIterator it = list.listIterator();
		int num=0;

		while (it.hasNext())
		{
			MemberInfo obj = (MemberInfo)it.next();

			if (obj.getMainMenu()!="없음")
			{
				num++;
				System.out.printf("\t  %2d   \t%6s\t\t%4d년 %2d월 %2d일\t%3s\t%d개\t%,d\t\t%s\n",
				num, obj.getMainMenu(), obj.getY(), obj.getM(), obj.getD(), 
				obj.getName(), obj.getMainCount(), obj.getEveryTotal(), obj.getStrHow());
			}
			arrTot2 += obj.getEveryTotal();

		}
		
		System.out.println();	
		
		System.out.println("\t=========================================================================================================");	
		System.out.printf("\t  총 매출액: %,d원\n", arrTot2);
		System.out.println("\t=========================================================================================================");	
		
		choiceMenu();
	}


	// 회원별 매출현황 >>>이름 기준 오름차순정렬
	public void memberArray() throws IOException
	{
		MemberArray memberArray = new MemberArray();
		int arrTot3 = 0;

		Collections.sort(list, memberArray);

		System.out.println();
		System.out.println();
		System.out.println("\t========================================= [ 회원별 매출현황 ] ===========================================");
		System.out.println();
		System.out.println("\t  No   \t구매자\t\t  결제시각\t\t결제메뉴\t 수량\t결제금액\t결제수단");
		System.out.println("\t=========================================================================================================");

		ListIterator it = list.listIterator();
		int num=0;

	
		while (it.hasNext())
		{
			MemberInfo obj = (MemberInfo)it.next();

			if (obj.getY()!=0)
			{
				num++;
				System.out.printf("\t  %2d   \t%3s\t\t%4d년 %2d월 %2d일\t%6s\t%d개\t%,d\t\t%s\n",
				num, obj.getName(), obj.getY(), obj.getM(), obj.getD(), 
				obj.getMainMenu(), obj.getMainCount(), obj.getEveryTotal(), obj.getStrHow());
			}
			arrTot3 += obj.getEveryTotal();

		}
		System.out.println();	
		
		System.out.println("\t=========================================================================================================");	
		System.out.printf("\t  총 매출액: %,d원\n", arrTot3);
		System.out.println("\t=========================================================================================================");	

		choiceMenu();
	}

	// 결제수단별 매출현황 >>>결제수단 기준 오름차순 정렬 or 검색기능: 카드 or 현금
	public void cardCashArray() throws IOException
	{
		CardCashArray ccArray = new CardCashArray();
		int arrTot4 = 0;

		Collections.sort(list, ccArray);

		System.out.println();
		System.out.println();
		System.out.println("\t===================================== [ 결제수단별 매출현황 ] ===========================================");
		System.out.println();
		System.out.println("\t  No   \t 결제수단\t  결제시각\t\t결제메뉴\t구매자\t 수량\t결제금액");
		System.out.println("\t=========================================================================================================");
		
		ListIterator it = list.listIterator();
		int num=0;
		while (it.hasNext())
		{
			MemberInfo obj = (MemberInfo)it.next();

			if (obj.getStrHow()!="없음")
			{
				num++;
				System.out.printf("\t  %2d   \t%s\t\t%4d년 %2d월 %2d일\t%6s\t%3s\t%d개\t%,d\n",
				num, obj.getStrHow(), obj.getY(), obj.getM(), obj.getD(), 
				obj.getMainMenu(), obj.getName(), obj.getMainCount(), obj.getEveryTotal());
			}
			arrTot4 += obj.getEveryTotal();
		}
		System.out.println();	
		
		System.out.println("\t=========================================================================================================");	
		System.out.printf("\t  총 매출액: %,d원\n", arrTot4);
		System.out.println("\t=========================================================================================================");	
		choiceMenu();
	}


	// 목표매출액과 달성률
	public void goalArray() throws IOException
	{
		int arrTotal=0;
		ListIterator it = list.listIterator();
		while (it.hasNext())
		{
			MemberInfo obj = (MemberInfo)it.next();
			arrTotal += obj.getEveryTotal();
		}
		double goal = arrTotal/10000;					// 달성률 계산

		System.out.println();
		System.out.println();
		System.out.println("\t====================================== [ 목표 매출액과 달성률 ] ========================================");
		System.out.println();
		System.out.println("\t\t   목표 매출액: 1,000,000원");
		System.out.printf("\t\t     총 매출액: %,d원\n", arrTotal);
		System.out.printf("\t\t        달성률: %.2f%%\n", goal);
		System.out.println();
		System.out.println("\t=========================================================================================================");
		
		choiceMenu();
	}



	// 거스름돈 현황 확인(권종별) 및 시재 추가 입력

	// 메뉴선택 1. 시재 확인 2. 시재 추가 입력
	public void choiceMoney() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		// 메뉴 선택
		try
		{
			System.out.println();
			System.out.println();
			System.out.println("\t=================================[ 시재 현황 ]========================================");	
			System.out.println();
			System.out.println("\t\t1. 시재 확인");
			System.out.println("\t\t2. 시재 추가 입력");
			System.out.println();
			System.out.println("\t======================================================================================");	
			System.out.print("\t    원하시는 메뉴를 선택해주세요 : ");
			select = sc.next();

			if (!select.equals("1") && !select.equals("2"))
				throw new choiceException(select);
		}//try문 닫기
		catch (choiceException e)
		{
			e.showWrongChoice();
			System.out.println("\t선택을 처음부터 다시 진행합니다.");
			this.choiceMenu();
		}//catch 문 닫기

		switch (select)
		{
			case "1": ; this.printCash(); break;
			case "2": ; this.plusCash(); break;
		}

	}//choiceMoney 끝


	// 권종별 현금 현황 출력
	public void printCash() throws IOException
	{
		int totCash = getManW() + getOchunW() + getChunW() + getObakW() + getBakW();		// 최종 합산 금액
		int manCount, ochunCount, chunCount, obakCount, bakCount;		// 권종별 현재 수량

		// 권종별 현재 수량 계산 (금액/권종 한 몫 = 수량)
		manCount = getManW()/10000;
		ochunCount = getOchunW()/5000;
		chunCount = getChunW()/1000;
		obakCount = getObakW()/500;
		bakCount = getBakW()/100;

		System.out.println();
		System.out.println();
		System.out.println("\t======================================================================================");	
		System.out.println();
		System.out.println("\t\t      POS 현금");
		System.out.println("\t  권종\t      수량    금액");

		System.out.printf("\t10,000원\t%d\t%s\n", manCount, String.format("%,d", getManW()));
		System.out.printf("\t 5,000원\t%d\t%s\n", ochunCount, String.format("%,d", getOchunW()));
		System.out.printf("\t 1,000원\t%d\t%s\n", chunCount, String.format("%,d", getChunW()));		
		System.out.printf("\t   500원\t%d\t%s\n", obakCount, String.format("%,d", getObakW()));
		System.out.printf("\t   100원\t%d\t%s\n", bakCount, String.format("%,d", getBakW()));
		System.out.println();
		System.out.printf("\t    영업 준비금 : 100,000원\n");
		System.out.printf("\t   현재 총 금액 : %s원\n", String.format("%,d",totCash));
		System.out.println();
		System.out.println("\t======================================================================================");	
		
		managerMenu();
	}


	// 시재 추가 입력

	public void plusCash() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		int beforeCash;											// 시재 추가 전 총 금액
		int afterCash;											// 시재 추가 후 총 금액
		int[] cashList = {10000, 5000, 1000, 500, 100};
		int[] count = new int[5];								// 입력받는 권종별 수량
		int[] plusCash = new int[5];							// 권종별 추가 금액 (시재에 추가할 금액)
		int totalPlus=0;										// 총 추가 입력 금액

		// 현재 보유중인 현금 총금액
		beforeCash = getManW() + getOchunW() + getChunW() + getObakW() + getBakW();

		// 투입 권종, 수량 입력
		System.out.println();
		System.out.println();
		System.out.println("\t======================================================================================");	
		System.out.println();
		System.out.println("\t    권종별 추가 수량을 입력해주세요.");
		System.out.println();

		// 현금 권종별로 나뉜 배열 출력하며 해당 금액권의 수량 입력받기 → 권종별 투입금액 계산
		for (int i=0; i<cashList.length; i++)
		{
			System.out.printf("\t%5d원: ", cashList[i]);	// 10,000원
			count[i] = sc.nextInt();						// 3개
			plusCash[i] = cashList[i]*count[i];				// plusCash[0] = 10,000*3
			totalPlus += plusCash[i];						// totalPlus = 30,000+...+100*n
		}
		
		String commTplus = String.format("%,d", totalPlus);				//',' 찍은 추가금
		String commBtPlus = String.format("%,d", beforeCash+totalPlus);	//'.' 찍은 총 시재금

		System.out.println();
		System.out.println("\t======================================================================================");	
		System.out.println();
		System.out.println();

		// 입력받은 금액 확인
		System.out.println();
		System.out.println();
		System.out.println("\t======================================================================================");	
		System.out.println();
		System.out.println("\t    영업 준비금 : 100,000원");
		System.out.println("\t 추가 입력 금액 :  " + commTplus + "원");
		System.out.println("\t        총 금액 : " + commBtPlus + "원");
		System.out.println();
		System.out.println("\t======================================================================================");	
		System.out.print("\t상기 결과대로 시재를 입력하시겠습니까? (Y/N) : ");
		select = sc.next();

		if (select.equals("Y") || select.equals("y"))
		{

			// 입력받은 금액만큼 Cash클래스의 메소드를 통해 시재에 더하기
			this.plsPlus(plusCash[0], plusCash[1], plusCash[2], plusCash[3], plusCash[4]);

			// 시재 입력 후 현재 총 금액 계산
			afterCash = getManW() + getOchunW() + getChunW() + getObakW() + getBakW();

			System.out.println();
			System.out.println();
			System.out.println("\t입력이 완료되었습니다.");
			System.out.println();
			this.choiceMoney();							// 다시 선택메뉴로 돌아가기
		}
		else
		{
			System.out.println();
			System.out.println();
			System.out.println("\t시재 추가 입력을 취소하셨습니다.");
			this.choiceMoney();
		}
		
	}//plusCash 끝
	
} //SalesManagement 끝


// 정렬기준 1. 결제시간 오름차순 정렬
class DateArray implements Comparator<MemberInfo>
{
		@Override
		public int compare(MemberInfo o1, MemberInfo o2)
		{
			return o1.getD() - o2.getD();
		}
}


// 정렬기준 2. 메뉴 오름차순 정렬
class MenuArray implements Comparator<MemberInfo>
{
		@Override
		public int compare(MemberInfo o1, MemberInfo o2)
		{
			return o1.getMainMenu().compareTo(o2.getMainMenu());
		}
}

// 정렬기준 3. 회원ID 오름차순 정렬
class MemberArray implements Comparator<MemberInfo>
{
		@Override
		public int compare(MemberInfo o1, MemberInfo o2)
		{
			return o1.getName().compareTo(o2.getName());
		}
}

// 정렬기준 4. 결제수단 오름차순 정렬
class CardCashArray implements Comparator<MemberInfo>
{
		@Override
		public int compare(MemberInfo o1, MemberInfo o2)
		{
			return o1.getStrHow().compareTo(o2.getStrHow());
		}
}


public class AdminPayment
{
	public static void main(String[] args) throws IOException
	{

	}
}