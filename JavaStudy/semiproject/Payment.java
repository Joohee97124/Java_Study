import java.util.Scanner;
import java.util.Calendar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;


class Cash extends MenuUser
{

	private static int manW = 20000;			// 만원 (기본 2장) 
	private static int ochunW = 30000;			// 오천원 (기본 6장)
	private static int chunW = 30000;			// 천원 (기본 30장)
	private static int obakW = 15000;			// 오백원 (기본 30개)
	private static int bakW = 5000;			// 백원 (기본 50개)
	private int tmpTotal;				// 주문 누적 금액 (할인 적용 전) //==MenuUser.finalTot;	
	private int	total;					// 할인 적용 후 최종 결제 금액


	// 값을 한번에 더해주기 위한 메소드
	public static void plsPlus(int man, int ochun, int chun, int obak, int bak)
	{
		manW += man;
		ochunW += ochun;		
		chunW += chun;
		obakW += obak;
		bakW += bak;
	}

	Cash() throws IOException
	{
	}

	//getter
	public int getManW(){ return manW; } 

	public int getOchunW(){ return ochunW; }

	public int getChunW(){ return chunW; }

	public int getObakW(){ return obakW; }

	public int getBakW(){ return bakW; }

	public int getTmpTotal(){ return tmpTotal; }

	public int getTotal(){ return total; }


	//setter
	public void setManW(int manW){ this.manW = manW; }

	public void setOchunW(int ochunW){ this.ochunW = ochunW; }

	public void setChunW(int chunW){ this.chunW = chunW; }

	public void setObakW(int obakW){ this.obakW = obakW; }

	public void setBakW(int bakW){ this.bakW = bakW; }

	public void setTmpTotal(int tmpTotal){ this.tmpTotal = tmpTotal; }

	public void setTotal(int total){ this.total = total; }

}


// 선택을 잘못 입력했을 경우 나타날 예외 구문 정의
class choiceException extends Exception 
{ 
	String wrong;								// 잘못된 입력값 저장하는 변수
 
    public choiceException(String choice)		// 입력값을 받는 생성자
    {
        super("\t잘못 선택하셨습니다.");
        wrong = choice;							// 사용자가 입력한 선택 잘못된 입력값 변수에 저장
    }
 
    public void showWrongChoice()
	{
        System.out.println("\t" + wrong + "에 해당하는 선택은 존재하지 않습니다.");
    }
}
 

// 사용자에게 보여지는 결제 메뉴 클래스
class UserPayment extends Cash
{

	UserPayment() throws IOException
	{
	}

	// 결제를 진행하며 사용자에게 입력받는 변수들 (입력받은 값을 계산해서 저장하는 변수들)

	String name;								// MemberInfo 객체를 받아오기 위해 가져오는 Login, MemberUser 클래스와 동일한 이름
	String answer;								// 입력받은 응답
	String cashAnswer;							// 현금영수증 응답
	public int cardOrCash;						// 결제 방식 (카드=1, 현금=2)
	String cardOrCashStr;						// 결제 방식 문자열로 변환

	int userCash = 0;							// 총 투입 금액
	int point;									// 로그인 회원이 현재 보유하고 있는 포인트
	int beforeTot;								// 로그인 회원의 현재 총 주문 누적 금액 (할인 적용 전)
	int change = 0;								// 사용자가 받아야 하는 거스름돈
	String cashReceipt;							// 현금영수증 발급 번호

	String menuName;							// 주 메뉴 이름
	int menuTot;								// 주 메뉴 가격합

	String subName;								// 서브 메뉴 이름
	int subCount;								// 서브 메뉴 수량
	int subTot;									// 서브 메뉴 가격 합
		
	int msTotal;								// 최종 결제 금액

	int y, m, d, h, min;						// 결제 시 시간 (영수증 출력 기준)

	int usePoint=0;								// 사용할 포인트
	static int tmpMan, tmpOchun, tmpChun, tmpObak, tmpBak;	// 투입받은 권종별 금액 (시재에 추가할 금액)
	
	// 쿠폰 및 적립금 적용 메소드
	public void discount() throws IOException
	{	

		double tmp=0;							// 할인 계산 위한 임시변수
		point = findById(name).getPoint();

		// MenuUser 클래스에서 넘어온 주문금액을 MemberInfo에 저장했기 때문에
		// findById(name) = 객체의 메소드를 통해 값을 가져옴
		beforeTot = findById(name).getOrderTotal();	
		this.setTmpTotal(beforeTot);			
		this.setTotal(beforeTot);				// 우선 결제 최종금액에도 할인전 주문금액 넣음
	
		// 이 달의 생일 쿠폰 적용 위한 캘린더 인스턴스 생성
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		int birth = Integer.parseInt(findById(name).getBirth().substring(4,6));

		Scanner sc = new Scanner(System.in);

		// 쿠폰이 있는 경우 적용되는 로직
		// 1. 첫 구매(Member클래스의 orderTotal=총 구매금액이 0)인경우 첫 구매 쿠폰 안내
		// 2. 주민번호의 월이 오늘의 월과 일치할 경우 생일 쿠폰 안내
		//-- 중복 사용 불가, 중복 시 할인율이 큰 생일 쿠폰만 안내
		//** try ~ catch로 y/n 잘못 입력한 경우 문구, ** 주민번호 비교
		
		try
		{
			if (birth==month)
			{
				System.out.println();
				System.out.println();
				System.out.println("\t======================================================================================");
				System.out.println();
				System.out.println("\t   " + findById(name).getName() + "님," + month + "월 생일을 축하드립니다!");
				System.out.println();
				System.out.println("\t         ┌────────────────┐");
				System.out.println("\t         │                │");
				System.out.println("\t         │  생일 할인 30% │");
				System.out.println("\t         │                │");
				System.out.println("\t         └────────────────┘");
				System.out.println();
				System.out.println("\t======================================================================================");
				System.out.print("\t생일 쿠폰을 사용하시겠습니까? (Y/N) : ");
				answer = sc.next();

				// 할인쿠폰 사용시 구매 누적액*0.7 계산해 할인 적용 후 금액에 담기, 사용 안하면 계산 없이 그냥 담기
				if (answer.equals("Y") || answer.equals("y"))
				{
					tmp = this.getTmpTotal() * 0.7;
					this.setTotal((int)tmp);
					System.out.println();
					System.out.println("\t      총 결제 금액은 " + this.getTotal() + "원 입니다.");
				}
				else if (!answer.equals("Y") && !answer.equals("y") && !answer.equals("N") && !answer.equals("n"))
					throw new choiceException(answer);
			}
			else if (findById(name).getEveryTotal()==0)
			{
				System.out.println();
				System.out.println("\t======================================================================================");
				System.out.println();
				System.out.println("\t        " + findById(name).getName() + "님. 반갑습니다!");
				System.out.println("\t첫 만남을 축하하는 쿠폰이 지급되었습니다.");
				System.out.println();
				System.out.println("\t         ┌────────────────┐");
				System.out.println("\t         │                │");
				System.out.println("\t         │첫 구매 할인 20%│");
				System.out.println("\t         │                │");
				System.out.println("\t         └────────────────┘");
				System.out.println();
				System.out.println("\t======================================================================================");
				System.out.print("\t첫 구매 쿠폰을 사용하시겠습니까? (Y/N) : ");
				answer = sc.next();

				// 할인쿠폰 사용시 구매 누적액*0.8 계산해 할인 적용 후 금액에 담기, 사용 안하면 계산 없이 그냥 담기
				if (answer.equals("Y") || answer.equals("y"))
				{
					tmp = this.getTmpTotal() * 0.8;
					this.setTotal((int)tmp);
					System.out.println();
					System.out.println("\t      총 결제 금액은 " + this.getTotal() + "원 입니다.");
				}
				else if (!answer.equals("Y") && !answer.equals("y") && !answer.equals("N") && !answer.equals("n"))
					throw new choiceException(answer);
			}//else if문 닫기


			// 포인트가 100 이상 있는 경우 사용 가능한 메소드
			if (point>=100)
			{	
				int prePointUse = this.getTotal();	// 적립금 적용 전, 쿠폰 적용된 주문 금액 따로 저장
				System.out.println();
				System.out.println();
				System.out.println("\t======================================================================================");
				System.out.println();
				System.out.println("\t" + findById(name).getName() + "님의 현재 누적 포인트는 " + point + "점 입니다.");
				System.out.println();
				System.out.println("\t======================================================================================");
				System.out.println();			
				System.out.print("\t   포인트를 사용하시겠습니까? (Y/N) : ");
				answer = sc.next();

				if (answer.equals("Y") || answer.equals("y"))
				{
					do
					{
						System.out.print("\t사용할 포인트를 입력해주세요(100원 단위) : ");
						usePoint = sc.nextInt();

						if (usePoint%100 != 0)			  // 사용 포인트를 제대로 입력하지 않은 경우
						{
							System.out.println("\t  포인트 사용은 100원 단위만 가능합니다.");
							System.out.println();
						}
						else if (point >= usePoint)			 // 보유포인트가 사용포인트보다 큰 경우 (통과)
						{
							// 1. 쿠폰 적용 or 적용하지 않은 결제 금액에서 사용 포인트만큼 차감
							int i = this.getTotal() - usePoint;
							this.setTotal(i);

							// 2. 현재 포인트 - 사용 포인트 차감 후 Member 정보에 반영하기
							int p = point - usePoint;
							findById(name).setPoint(p);

							// 3. 결제 페이지 이동
							this.selectPay();
							break;
						}
						else if (point < usePoint)			// 보유 포인트가 사용포인트보다 작은 경우 
						{
							System.out.println("\t   보유하신 포인트를 초과했습니다.");
							System.out.println();
						}
					}
					while (prePointUse==this.getTotal());	// 주문누적금액이 그대로인 경우(포인트 적용되지 X) 반복
				}
				else if (answer.equals("N") || answer.equals("n"))
					this.selectPay();						//결제메소드 호출
			}//if문 닫기
			else if (point<100)
			{
				this.selectPay();
			}
		}//try문 닫기
		catch (choiceException e)
		{
			e.showWrongChoice();
			System.out.println("\t선택을 처음부터 다시 진행합니다.");
			this.discount();
		}//catch 문 닫기
		
	} //discount() 메소드 닫기


    // 포인트 적립 메소드 (10%)
    public void pointStack10()
    {
		int point0 = findById(name).getPoint();

		// 매출액의 0.1 & 게임의 0.1 적립
		int realTotal = getTotal();

		double temppoint = realTotal*0.1;
		int temp2 = (int)temppoint;
		
		if (temp2>0 && temp2 % 100 != 0 )
			temp2 -= (temp2%100);
		else
			temp2 = temp2;

		findById(name).setPoint(point0 + temp2);

		System.out.println("\t적립 포인트: "+temp2);
    }


	// 포인트 적립 메소드 (5%)
	public void pointStack5() 
	{
		int point0 = findById(name).getPoint();

		// 게임의 0.05 적립
		int realTotal = getTotal();

		double temppoint2 = realTotal*0.05;
		int temp3 = (int)temppoint2;

		if (temp3>0 && temp3 % 100 !=0)
			temp3 -= (temp3%100);
		else 
			temp3 = temp3;
		findById(name).setPoint(point0 + temp3);
		System.out.println("\t적립 포인트: "+temp3);
	}


	// 결제 메소드: 카드, 현금 중 선택
	public void selectPay() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.println();
			System.out.println();
			System.out.println("\t======================================================================================");	
			System.out.println();
			System.out.println("\t      총 결제 금액은 " + this.getTotal() + "원 입니다.");
			System.out.println("\t    원하시는 결제 수단을 선택해주세요.");
			System.out.println();
			System.out.println("\t   1. 카드\t\t2.현금");
			System.out.println();
			System.out.println("\t======================================================================================");	
			System.out.print("\t   메뉴 선택 : ");
			cardOrCash = sc.nextInt();
		}
		while (cardOrCash!=1 && cardOrCash!=2);

		switch (cardOrCash)
		{
			// 문자열로 변환한 결제방식을 MemberInfo 객체에 저장함 
			case 1 : cardOrCashStr = "카드"; findById(name).setStrHow(cardOrCashStr); this.cardPay(); break;	// 카드 선택
			case 2 : cardOrCashStr = "현금"; findById(name).setStrHow(cardOrCashStr); this.cashPay(); break;	// 현금 선택
		}
	}

	// 카드 결제
	public void cardPay() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		findById(name).setPayTotal(this.getTotal());	// MemberInfo 객체에 할인 후 최종 결제 금액 저장

		System.out.println();
		System.out.println();
		System.out.println("\t======================================================================================");	
		System.out.println();
		System.out.println("\t     하단에 카드를 꽂아주세요.");
		System.out.println();
		System.out.println("\t======================================================================================");
		System.out.println("\t   " + this.getTotal() +"원 결제가 완료되었습니다.");
		System.out.print("\t   영수증을 출력하시겠습니까? (Y/N) : ");
		answer = sc.nextLine();

		if (answer.equals("Y") || answer.equals("y"))
			this.printReceipt();			// 영수증 출력 메소드 호출
		else
		{
			System.out.println();
			System.out.println();
			System.out.println("\t======================================================================================");	
			System.out.println();
			System.out.println("\t     주문하신 메뉴가 나왔습니다.");
			System.out.println("\t      이용해주셔서 감사합니다.");
			System.out.println();
			System.out.println("\t======================================================================================");	

		}
	}//cardPay 끝


	// 현금 결제: 투입 권종, 수량 입력 > 현금영수증 여부(휴대폰번호 입력)
	public void cashPay() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		findById(name).setPayTotal(this.getTotal());				// MemberInfo 객체에 할인 후 최종 결제 금액 저장

		int[] cashList = {10000, 5000, 1000, 500, 100};
		int[] count = new int[5];									// 입력받는 권종별 수량
		int ochun=0, chun=0, obak=0, bak=0;							// 거스름돈 계산시 필요한 변수

		// 투입 권종, 수량 입력
		System.out.println();
		System.out.println();
		System.out.println("\t======================================================================================");	
		System.out.println();
		System.out.println("\t       현금을 투입해주세요.");

		// 현금 권종별로 나뉜 배열 출력하며 해당 금액권의 수량 입력받기 → 총 투입금액 계산
		for (int i=0; i<cashList.length; i++)
		{
			System.out.printf("\t%5d원: ", cashList[i]);
			count[i] = sc.nextInt();
			userCash += cashList[i]*count[i];
		}

		System.out.println();
		System.out.println("\t======================================================================================");
		System.out.println();
		System.out.println();

		// 1. userCash > total : 거스름돈 계산 후 반환
		// 2. userCash < total : 다시 입력받기(초기화)
		// 3. userCash = total : 거스름돈 0(default)
		System.out.println("\t      총 " + userCash + "원이 투입되었습니다.");
		System.out.println();

		if (userCash >= getTotal())
		{
			change = userCash - getTotal();
			// 거스름돈 계산 (단위로 나눈 값이 곧 그 단위의 개수고, 나머지를 다른 단위로 나누면 그 몫이 개수가 됨)
			ochun = change/5000;					//-거슬러줘야 할 오천원의 개수
			chun = change%5000/1000;				//-거슬러줘야 할 천원의 개수
			obak = change%5000%1000/500;			//-거슬러줘야 할 오백원의 개수
			bak = change%5000%1000%500/100;			//-거슬러줘야 할 백원의 개수

			// 입력받은 권종별 금액은 더하고, 거스름돈은 빼서 현재 시재에 추가하기
			tmpMan = count[0] * cashList[0];
			tmpOchun = (count[1] - ochun) * cashList[1];
			tmpChun = (count[2] - chun) * cashList[2];
			tmpObak = (count[3] - obak) * cashList[3];
			tmpBak = (count[4] - bak) * cashList[4];
			
			// 받은 금액-돌려준 금액(거스름돈) 계산해서 Cash 클래스 값에 저장
			plsPlus(tmpMan, tmpOchun, tmpChun, tmpObak, tmpBak);

			System.out.println("\t         결제가 완료되었습니다.");
			System.out.println();
			System.out.println("\t반환구에서 거스름돈 " + change + "원을 확인해주세요.");
			System.out.println();
			System.out.println("\t======================================================================================");	
		}
		else if (userCash < getTotal())
		{
			System.out.println("\t   총 결제 금액은 " + getTotal() + "원 입니다.");
			System.out.println("\t     투입 금액이 부족합니다.");
			System.out.println("\t반환되는 현금을 확인하시고, 다시 투입해주세요.");
			System.out.println();
			userCash = 0;					// 입력 받은 금액 초기화
			cashPay();

			return;
		}

		// 현금영수증 여부 (휴대폰 번호 입력 or 영수증 출력)
		System.out.println();
		System.out.print("\t현금 영수증을 발급하시겠습니까? (Y/N) : ");
		cashAnswer = sc.next();
		

		if (cashAnswer.equals("Y") || cashAnswer.equals("y"))
		{
			System.out.print("\t  현금 영수증 번호를 입력해주세요. : ");
			cashReceipt = sc.next();
		}
		
		// 영수증 출력 여부
		System.out.println();
		System.out.print("\t영수증을 출력하시겠습니까? (Y/N) : ");
		answer = sc.next();

		if (answer.equals("Y") || answer.equals("y"))
			printReceipt();			// 영수증 출력 메소드 호출
		else
		{
			System.out.println();
			System.out.println();
			System.out.println("\t======================================================================================");	
			System.out.println();
			System.out.println("\t     주문하신 메뉴가 나왔습니다.");
			System.out.println("\t       이용해주셔서 감사합니다.");
			System.out.println();
			System.out.println("\t======================================================================================");	
			findById(name).setEveryTotal(this.getTotal());			// 회원 정보에 결제 금액 누적하기

		}	

	}//cashPay 끝


	// 영수증 출력
	public void printReceipt() throws IOException
	{
		// pointStack10();					// 포인트 적립

		Calendar now = Calendar.getInstance();

		y = now.get(Calendar.YEAR);
		m = now.get(Calendar.MONTH)+1;
		d = now.get(Calendar.DATE);
		h = now.get(Calendar.HOUR_OF_DAY);
		min = now.get(Calendar.MINUTE);
		
		// 결제(영수증 출력 시점)의 날짜, 시간을 MemberInfo에 fix함
		findById(name).setY(y);
		findById(name).setM(m);
		findById(name).setD(d);

		menuName = findById(name).getMainMenu();			// 주 메뉴 이름
		int menuCount = 1;									// 주 메뉴 주문 수량
		menuTot = findById(name).getMainTotal();			// 주 메뉴 가격합

		subName = findById(name).getSubMenu();				// 서브 메뉴 이름
		subCount = findById(name).getSubMenuCount();		// 서브 메뉴 수량
		subTot = findById(name).getSubTotal();				// 서브 메뉴 가격 합
		
		msTotal = findById(name).getPayTotal();				// 총 결제 가격 합 (메인+서브메뉴)

		String commTotal = String.format("%,d", menuTot);	//',' 찍은 주 메뉴 금액
		String commsubTot = String.format("%,d", subTot);	//',' 찍은 서브 메뉴 금액
		String commMsTot = String.format("%,d", msTotal);	//',' 찍은 총 금액
		String commCash = String.format("%,d", userCash);	//',' 찍은 사용자에게 입력받은 현금 금액
		String commChange = String.format("%,d", change);	//',' 찍은 거스름돈

		System.out.println();
		System.out.println();
		System.out.println("\t======================================================================================");	
		System.out.println();
		System.out.println("\t          <  영  수  증  >");
		System.out.println();
		System.out.println("\t           Custom Cocktail ");

		System.out.println("\t사업자번호: 411-82-05920");
		System.out.println("\t주      소: 서울시 마포구 월드컵북로 21");
		System.out.println("\t전화  번호: 010-8102-0384");
		System.out.printf("\t일      자: %4d-%d-%d  %2d:%2d\n", y, m, d, h, min);
		System.out.println("\t======================================================================================");	
		System.out.println("\t 품명\t\t수량\t\t금액");
		System.out.printf("\t %-6s\t %d\t\t%5s\n", menuName, menuCount, commTotal);
		if (subCount!=0)
				System.out.printf("\t %-6s\t %d\t\t%5s\n", subName, subCount, commsubTot);
		System.out.println("\t======================================================================================");	
		System.out.printf("\t 합         계 : \t\t%5s\n", commMsTot);

		if (cardOrCash==1)
		{
			System.out.printf("\t 카         드 : \t\t%5s\n", commMsTot);
			System.out.printf("\t 사용된 포인트 : \t\t%5d\n", usePoint);
		}
		else if (cardOrCash==2)
		{
			System.out.printf("\t 받은     현금 : \t\t%5s\n", commCash);
			System.out.printf("\t 사용된 포인트 : \t\t%5d\n", usePoint);
			System.out.printf("\t 거  스  름 돈 : \t\t%5s\n", commChange);
			System.out.println();
			if (cashAnswer.equals("Y") || cashAnswer.equals("y"))
				System.out.printf("\t 현 금  영수증 :        \t%s\n", cashReceipt);
		}

		System.out.println("\t======================================================================================");	
		System.out.println("\t      ***** 좋은 하루 되세요 *****");
		System.out.println();
		System.out.println();
		System.out.println("\t======================================================================================");	
		System.out.println();
		System.out.println("\t      주문하신 메뉴가 나왔습니다.");
		System.out.println("\t       이용해주셔서 감사합니다.");
		System.out.println();
		System.out.println("\t======================================================================================");	
		findById(name).setEveryTotal(this.getTotal());			// 회원 정보에 결제 금액 누적하기
		userCash = 0;											// 사용자가 낸 돈 0으로 초기화

	}//printReceipt 끝



//--------------------------------------------------- 게임

	int sel;								// 게임 확률 선택
	private int user;						// 사용자
	private int com;						// 컴퓨터

	private static int sellcount;			// 칵테일 판 횟수



	public int getsellcount()
	{
		return sellcount;
	}	

	public static void setsellcount(int sellcount)
	{	
		UserPayment.sellcount = sellcount;
	}
	

	public void rsp() throws InterruptedException
	{	
		MachineRoom mr = new MachineRoom();
		Imagefile jpg = new Imagefile();
		
	
			Scanner sc = new Scanner(System.in);
			Random rd = new Random();

			System.out.println();
			System.out.println();
		    System.out.println("\t======================================================================================");	
			System.out.println();
			System.out.println("\t적립금 지급을 위한 미니 게임(참참참)을 하시겠습니까?\n");
			System.out.println("\t1. 이길 확률 80% (적립금 5%) \t 2. 이길 확률 66.6% (적립금 10%) \t 3. 안 할래요.");

			do
			{
				System.out.println();
				System.out.print("\n\t 당신의 선택은?! : ");
				sel = sc.nextInt();
			}
			while (sel < 1 || sel > 3);

		
			if (sel==1)
			{
				com = rd.nextInt(4)+1; // → 1 2 3 4 5
				System.out.println();
				System.out.println("\n\t확률 80 % 게임을 선택하셨습니다.");
				game1();
			}
			
			else if(sel==2)
			{
				com = rd.nextInt(2)+1; // → 1 2 3
				System.out.println();
				System.out.println("\n\t확률 66.6 % 게임을 선택하셨습니다.");

				game2();
			}
			
			else if(sel==3)
			{
				System.out.println();
				System.out.println("\n\t이용 해 주셔서 감사합니다.");
				System.out.println();
				// 처음 화면으로 돌아가는 클래스 메소드 호출.
			}
			
			sellcount +=1;															// 칵테일 판 횟수
	}
	
	public void game1()
	{	
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.println();
			System.out.print("\t1. 위 2. 아래 3. 중앙 4. 왼쪽 5. 오른쪽 : ");
			user = sc.nextInt();
		}
		while (user < 1 || user > 5);

		try
		{
			Thread.sleep(3000);			
		}
		catch (InterruptedException e)
		{
			System.out.println();
		}

		try
		{	
			System.out.print("\t");
			Thread.sleep(3);			
		}
		catch (InterruptedException e)
		{
			System.out.println();
		}
		
		String[] str = {"위", "아래", "중앙", "왼쪽", "오른쪽"};

		System.out.println("\n\t - 유저	  : " + str[user-1]);
		System.out.println("  \t - 컴퓨터 : " + str[com-1]);
		
		if (user==com)
			System.out.println("\n\t패배 하셨습니다 :( 다음 기회에...");
		else
		{
			System.out.println("\n\t승리 하셨습니다!! :-D");

			// 포인트 적립 (5%)
			pointStack5();		
		}

	}


	void game2()
	{	
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.println();
			System.out.print("\t1. 왼쪽 2. 중앙 3. 오른쪽 : ");
			user = sc.nextInt();
		}
		while (user < 1 || user > 3);
		
		try
		{
			Thread.sleep(3000);			
		}
		catch (InterruptedException e)
		{
			System.out.println();
		}

		String[] str = {"왼쪽", "중앙", "오른쪽"};

		System.out.println("\n\t - 유저	  : " + str[user-1]);
		System.out.println("  \t - 컴퓨터 : " + str[com-1]);
		
		if (user==com)
			System.out.println("\n\t패배 하셨습니다 :( 다음 기회에...");
		else
		{
			System.out.println("\n\t승리 하셨습니다!! :-D");
			// 포인트 적립 (10%)
			pointStack10();

		}
	}
}



public class Payment
{
	public static void main(String[] args) throws IOException
	{


	}
}