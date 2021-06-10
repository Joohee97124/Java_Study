import java.util.Scanner;
import java.util.Calendar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;


class Cash
{
	//MenuUser mu = new MenuUser();

	private int manW = 20000;			// 만원 (기본 2장) 
	private int ochunW = 30000;			// 오천원 (기본 6장)
	private int chunW = 30000;			// 천원 (기본 30장)
	private int obakW = 15000;			// 오백원 (기본 30개)
	private int bakW = 5000;			// 백원 (기본 50개)
	private int tmpTotal=14000;			// 주문 누적 금액 (할인 적용 전) -테스트입력.. //MenuUser.finalTot;	
	private int	total;					// 할인 적용 후 최종 결제 금액
	private int card;					// 카드결제금액
	private int sumCash;				// 카드 매출액 합계
	private int sumCard;				// 현금 매출액 합계


	public Cash(int manW, int ochunW, int chunW, int obakW, int bakW) 
	{
		this.manW += manW;
		this.ochunW += ochunW;		
		this.chunW += chunW;
		this.obakW += obakW;
		this.bakW += bakW;
	}

	Cash() 
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

	public int getCard(){ return card; }

	public int getSumCash(){ return sumCash; }

	public int getSumCard(){ return sumCard; }

	//setter
	public void setManW(int manW){ this.manW = manW; }

	public void setOchunW(int ochunW){ this.ochunW = ochunW; }

	public void setChunW(int chunW){ this.chunW = chunW; }

	public void setObakW(int obakW){ this.obakW = obakW; }

	public void setBakW(int bakW){ this.bakW = bakW; }

	public void setTmpTotal(int tmpTotal){ this.tmpTotal = tmpTotal; }

	public void setTotal(int total){ this.total = total; }

	public void setCard(int card){ this.card = card; }

	public void setSumCash(int sumCash){ this.sumCash = sumCash; }

	public void setSumCard(int sumCard){ this.sumCard = sumCard; }

}

//----------------------------------테스트용 멤버 클래스
class Members
{
	int orderTotal = 0;
	String name = "전혜림";
	String birth = "19950316";
	int point = 100;
	
	int total = 10000;		//테스트용 주문 누적 금액
	// total = 메뉴가격*메뉴수량 (+추가메뉴)

	public int getOrderTotal()
	{
		return orderTotal;
	}

	public String getName()
	{
		return name;
	}

	public String getBirth()
	{
		return birth;
	}

	public int getPoint()
	{
		return point;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

	public void setPoint(int point)
	{
		this.point = point;
	}

}
//-----------------------------------테스트용 멤버 클래스

// 선택을 잘못 입력했을 경우 나타날 예외 구문 정의
class choiceException extends Exception 
{ 
	String wrong;							// 잘못된 입력값 저장하는 변수
 
    public choiceException(String choice)		// 입력값을 받는 생성자
    {
        super("\t잘못 선택하셨습니다.");
        wrong = choice;							// 사용자가 입력한 선택 잘못된 입력값 변수에 저장
    }
 
    public void showWrongChoice() {
        System.out.println("\t" + wrong + "에 해당하는 선택은 존재하지 않습니다.");
    }
}
 

// 사용자에게 보여지는 결제 메뉴 클래스
class UserPayment extends Cash
{

	UserPayment()
	{
	}

	//MemberInfo mem = new MemberInfo();		// MemberInfo 클래스 인스턴스 생성
	Members mem = new Members();

	String answer;							// 입력받은 응답
	int cardOrCash;							// 결제 방식 (카드=1, 현금=2)

	int userCash = 0;						// 총 투입 금액
	int total;								// 쿠폰, 적립금 적용이 모두 끝난 최종 결제 금액
	int change = 0;							// 사용자가 받아야 하는 거스름돈
	String cashReceipt;						// 현금영수증 발급 번호


	//String commTotal = String.format("%,d", this.getTotal());		//',' 찍은 최종 금액
	//String commCash = String.format("%,d", userCash);				//',' 찍은 사용자에게 입력받은 현금 금액
	//String commChange = String.format("%,d", change);				//',' 찍은 거스름돈

	
	// 쿠폰 및 적립금 적용 메소드
	public void discount()
	{	

		double tmp;								// 할인 계산 위한 임시변수
		int usePoint;							// 사용할 포인트

		// 이 달의 생일 쿠폰 적용 위한 캘린더 인스턴스 생성
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		int birth = Integer.parseInt(mem.getBirth().substring(4,6));
	
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
				System.out.println("\t─────────────────────────────────────");
				System.out.println();
				System.out.println("\t   " + mem.getName() + "님," + month + "월 생일을 축하드립니다!");
				System.out.println();
				System.out.println("\t         ┌────────────────┐");
				System.out.println("\t         │                │");
				System.out.println("\t         │  생일 할인 30% │");
				System.out.println("\t         │                │");
				System.out.println("\t         └────────────────┘");
				System.out.println();
				System.out.println("\t─────────────────────────────────────");
				System.out.print("\t생일 쿠폰을 사용하시겠습니까? (Y/N) : ");
				answer = sc.next();

				// 할인쿠폰 사용시 구매 누적액*0.7 계산해 할인 적용 후 금액에 담기, 사용 안하면 계산 없이 그냥 담기
				if (answer.equals("Y") || answer.equals("y"))
				{
					tmp = this.getTmpTotal() * 0.7;
					this.setTotal((int)tmp);
				}
				else if (answer.equals("N") || answer.equals("n"))
				{
					this.setTotal(this.getTmpTotal());
				}		
				else if (!answer.equals("Y") && !answer.equals("y") && !answer.equals("N") && !answer.equals("n"))
						throw new choiceException(answer);
			}
			else if (mem.getOrderTotal()==0)	
			{
				System.out.println();
				System.out.println();
				System.out.println("\t─────────────────────────────────────");
				System.out.println();
				System.out.println("\t        " + mem.getName() + "님. 반갑습니다!");
				System.out.println("\t첫 만남을 축하하는 쿠폰이 지급되었습니다.");
				System.out.println();
				System.out.println("\t         ┌────────────────┐");
				System.out.println("\t         │                │");
				System.out.println("\t         │첫 구매 할인 20%│");
				System.out.println("\t         │                │");
				System.out.println("\t         └────────────────┘");
				System.out.println();
				System.out.println("\t─────────────────────────────────────");
				System.out.print("\t첫 구매 쿠폰을 사용하시겠습니까? (Y/N) : ");
				answer = sc.next();

				// 할인쿠폰 사용시 구매 누적액*0.8 계산해 할인 적용 후 금액에 담기, 사용 안하면 계산 없이 그냥 담기
				if (answer.equals("Y") || answer.equals("y"))
				{
					tmp = this.getTmpTotal() * 0.8;
					this.setTotal((int)tmp);
				}
				else if (answer.equals("N") || answer.equals("n"))
				{
					this.setTotal(this.getTmpTotal());
				}
				else if (!answer.equals("Y") && !answer.equals("y") && !answer.equals("N") && !answer.equals("n"))
						throw new choiceException(answer);

			}//else if문 닫기


			// 포인트가 100 이상 있는 경우 사용 가능한 메소드
			if (mem.getPoint()>=100)
			{	
				int fix = this.getTotal();	// 적립금 적용 전, 쿠폰 적용된 주문 금액 따로 저장
				int prePointUse = fix;
				int point = mem.getPoint();

				System.out.println();
				System.out.println();
				System.out.println("\t─────────────────────────────────────");
				System.out.println();
				System.out.println("\t" + mem.getName() + "님의 현재 누적 포인트는 " + point + "점 입니다.");
				System.out.println();
				System.out.println("\t─────────────────────────────────────");
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
							total = this.getTotal();

							// 2. 현재 포인트 - 사용 포인트 차감 후 Member 정보에 반영하기
							point -= usePoint;
							mem.setPoint(point);
							this.selectPay();
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
					this.selectPay();							//결제메소드 호출
			}//if문 닫기
		}//try문 닫기
		catch (choiceException e)
		{
			e.showWrongChoice();
			System.out.println("\t선택을 처음부터 다시 진행합니다.");
			this.discount();
		}//catch 문 닫기
	} //discount() 메소드 닫기

	
   /* // 포인트 적립 메소드
    public int pointStack()
    {
	   int temp = this.getTotal();
	  
	   double temppoint = temp*0.1;
	   int temp2 = (int)temppoint;

	   if (temp2 % 100 != 0 )
	   temp2 -= (temp%100);
		 
	   // MemberInfo 클래스의 point로 연동                              
	   findById(name2).setPoint(temp2);
	   return temp2;
    }*/


	// 결제 메소드: 카드, 현금 중 선택
	public void selectPay()
	{
		Scanner sc = new Scanner(System.in);
		ArrData ob = new ArrData();		// 카드, 현금 중 선택한 결제 방법을 출력 데이터에 넘겨주기 위해 생성한 인스턴스

		do
		{
			System.out.println();
			System.out.println();
			System.out.println("\t─────────────────────────────────────");	
			System.out.println();
			System.out.println("\t      총 결제 금액은 " + total + "원 입니다.");
			System.out.println("\t    원하시는 결제 수단을 선택해주세요.");
			System.out.println();
			System.out.println("\t   1. 카드\t\t2.현금");
			System.out.println();
			System.out.println("\t─────────────────────────────────────");	
			System.out.print("\t   메뉴 선택 : ");
			cardOrCash = sc.nextInt();
			ob.transfer(cardOrCash);	// ArrData 클래스에 정의된 transfer 메소드 호출: 1 → 카드, 2 → 현금 변환
		}
		while (cardOrCash!=1 && cardOrCash!=2);

		switch (cardOrCash)
		{
			case 1 : this.cardPay(); break;	// 카드 선택
			case 2 : this.cashPay(); break;	// 현금 선택
		}
	}


	// 카드 결제
	public void cardPay()
	{
		Scanner sc = new Scanner(System.in);
		this.setCard(total);				// 카드 결제금액 변수에 저장

		System.out.println();
		System.out.println();
		System.out.println("\t─────────────────────────────────────");	
		System.out.println();
		System.out.println("\t     하단에 카드를 꽂아주세요.");
		System.out.println();
		System.out.println("\t─────────────────────────────────────");
		System.out.println("\t   " + total +"원 결제가 완료되었습니다.");
		System.out.print("\t   영수증을 출력하시겠습니까? (Y/N) : ");
		answer = sc.nextLine();

		if (answer.equals("Y") || answer.equals("y"))
			this.printReceipt();			// 영수증 출력 메소드 호출
		else
		{
			System.out.println();
			System.out.println();
			System.out.println("\t─────────────────────────────────────");	
			System.out.println();
			System.out.println("\t     주문하신 메뉴가 나왔습니다.");
			System.out.println("\t      이용해주셔서 감사합니다.");
			System.out.println();
			System.out.println("\t─────────────────────────────────────");	
			//자판기 첫 화면으로 이동 추가!!
		}
	}//cardPay 끝


	// 현금 결제: 투입 권종, 수량 입력 > 현금영수증 여부(휴대폰번호 입력)
	public void cashPay()
	{
		Scanner sc = new Scanner(System.in);

		int[] cashList = {10000, 5000, 1000, 500, 100};
		int[] count = new int[5];									// 입력받는 권종별 수량
		int tmpMan=0, tmpOchun=0, tmpChun=0, tmpObak=0, tmpBak=0;	// 투입받은 권종별 금액 (시재에 추가할 금액)
		int ochun=0, chun=0, obak=0, bak=0;							// 거스름돈 계산시 필요한 변수

		// 투입 권종, 수량 입력
		System.out.println();
		System.out.println();
		System.out.println("\t─────────────────────────────────────");	
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
		System.out.println("\t─────────────────────────────────────");
		System.out.println();
		System.out.println();

		// 1. userCash > total : 거스름돈 계산 후 반환
		// 2. userCash < total : 다시 입력받기(초기화)
		// 3. userCash = total : 거스름돈 0(default)
		System.out.println("\t      총 " + userCash + "원이 투입되었습니다.");
		System.out.println();

		if (userCash >= total)
		{
			change = userCash - total;
			// 거스름돈 계산 (단위로 나눈 값이 곧 그 단위의 개수고, 나머지를 다른 단위로 나누면 그 몫이 개수가 됨)
			ochun = change/5000;
			chun = change%5000/1000;
			obak = change%5000%1000/500;
			bak = change%5000%1000%500/100;

			// 입력받은 권종별 금액은 더하고, 거스름돈은 빼서 현재 시재에 추가하기
			tmpMan = count[0] * cashList[0];
			tmpOchun = count[1] * cashList[1] - ochun;
			tmpChun = count[2] * cashList[2] - chun;
			tmpObak = count[3] * cashList[3] - obak;
			tmpBak = count[4] * cashList[4] - bak;
			
			Cash ch = new Cash(tmpMan, tmpOchun, tmpChun, tmpObak, tmpBak);	// 사용자정의 생성자로 값 입력하기

			System.out.println("\t         결제가 완료되었습니다.");
			System.out.println();
			System.out.println("\t반환구에서 거스름돈 " + change + "원을 확인해주세요.");
			System.out.println();
			System.out.println("\t─────────────────────────────────────");	
		}
		else if (userCash < total)
		{
			System.out.println("\t   총 결제 금액은 " + this.getTotal() + "원 입니다.");
			System.out.println("\t     투입 금액이 부족합니다.");
			System.out.println("\t반환되는 현금을 확인하시고, 다시 투입해주세요.");
			System.out.println();
			this.cashPay();
		}

		// 현금영수증 여부 (휴대폰 번호 입력 or 영수증 출력)
		System.out.println();
		System.out.print("\t현금 영수증을 발급하시겠습니까? (Y/N) : ");
		answer = sc.next();
		

		if (answer.equals("Y") || answer.equals("y"))
		{
			System.out.print("\t  현금 영수증 번호를 입력해주세요. : ");
			cashReceipt = sc.next();
		}
		
		// 영수증 출력 여부
		System.out.println();
		System.out.print("\t영수증을 출력하시겠습니까? (Y/N) : ");
		answer = sc.next();

		if (answer.equals("Y") || answer.equals("y"))
			this.printReceipt();			// 영수증 출력 메소드 호출
		else
		{
			System.out.println();
			System.out.println();
			System.out.println("\t─────────────────────────────────────");	
			System.out.println();
			System.out.println("\t     주문하신 메뉴가 나왔습니다.");
			System.out.println("\t       이용해주셔서 감사합니다.");
			System.out.println();
			System.out.println("\t─────────────────────────────────────");	


		}	

	}//cashPay 끝


	// 영수증 출력
	public void printReceipt()
	{
		Calendar now = Calendar.getInstance();

		int y = now.get(Calendar.YEAR);
		int m = now.get(Calendar.MONTH)+1;
		int d = now.get(Calendar.DATE);
		int h = now.get(Calendar.HOUR_OF_DAY);
		int min = now.get(Calendar.MINUTE);
		
		// 결제(영수증 출력 시점)의 날짜, 시간을 클래스를 따로 만들어 fix함
		ArrData paytime = new ArrData(y, m, d, h, min);

		String menuName = "모히또";							// 메뉴 이름 (주문에서 받아오기!!!!!!!!!)
		int menuCount = 1;									// 메뉴 당 주문 수량
		String commTotal = String.format("%,d", total);		//',' 찍은 최종 금액
		String commCash = String.format("%,d", userCash);	//',' 찍은 사용자에게 입력받은 현금 금액
		String commChange = String.format("%,d", change);	//',' 찍은 거스름돈

		System.out.println();
		System.out.println();
		System.out.println("\t─────────────────────────────────────");	
		System.out.println();
		System.out.println("\t            <  영  수  증  >");
		System.out.println();
		System.out.println("\t           Custom Cocktail ");

		System.out.println("\t사업자번호: 411-82-05920");
		System.out.println("\t주      소: 서울시 마포구 월드컵북로 21");
		System.out.println("\t전화  번호: 010-8102-0384");
		System.out.printf("\t일      자: %4d-%d-%d  %2d:%2d\n", y, m, d, h, min);
		System.out.println("\t─────────────────────────────────────");	
		System.out.println("\t 품명\t\t수량\t\t금액");
		System.out.printf("\t %s\t\t %d\t\t%5s\n", menuName, menuCount, commTotal);
		System.out.println("\t─────────────────────────────────────");	
		System.out.printf("\t 합    계 : \t\t%5s\n", commTotal);

		if (cardOrCash==1)
			System.out.printf("\t 카    드 : \t\t%5s\n", commTotal);
		else if (cardOrCash==2)
		{
			System.out.printf("\t 현    금 : \t\t%5s\n", commCash);
			System.out.printf("\t 거스름돈 : \t\t%5s\n", commChange);
			System.out.println();
			System.out.printf("\t 현금영수증 : \t\t%5s\n", cashReceipt);
		}

		System.out.println("\t─────────────────────────────────────");	
		System.out.println("\t      ***** 좋은 하루 되세요 *****");
		System.out.println();
		System.out.println();
		System.out.println("\t─────────────────────────────────────");	
		System.out.println();
		System.out.println("\t      주문하신 메뉴가 나왔습니다.");
		System.out.println("\t       이용해주셔서 감사합니다.");
		System.out.println();
		System.out.println("\t─────────────────────────────────────");	
	}//printReceipt 끝

}


// [관리자모드-매출현황] 에서 출력할 정보들이 담긴 클래스
class ArrData
{

	UserPayment ob = new UserPayment();
	//MemberInfo ob2 = new MemberInfo();

	// 결제 시점: 연도, 월, 일, 시간, 분
	private int y;
	private int m;
	private int d;
	private int h;
	private int min;

	// 구매자 이름
	public String name = "전혜림";

	// 결제 메뉴 -- 임시로 적어둠. 사용자에게 입력받은거 끌어오기!
	public String menu = "발렌시아";

	// 수량 -- 임시로 적어둠. 사용자에게 입력받은거 끌어오기!
	public int count = 1;

	// 결제 금액
	public int total = ob.total;

	// 결제수단 (1=카드, 2=현금)
	public int how = ob.cardOrCash;

	// 출력시 1=카드, 2=현금 보여주기 위한 변수
	public String strHow="";

	public void transfer(int how) 	//UserPayment 클래스에서 호출해서 값 넣어줄 것
	{
		if (how == 1)
			strHow = "카드";
		else if (how == 2)
			strHow = "현금";
	}	


	public ArrData(int y, int m, int d, int h, int min) 
	{
		this.y=y;
		this.m=m;
		this.d=d;
		this.h=h;
		this.min=min;
	}

	public ArrData(int y, int m, int d, int h, int min, String name, String menu, int count, int total, String strHow) 
	{
		this.y=y;
		this.m=m;
		this.d=d;
		this.h=h;
		this.min=min;
		this.name=name;
		this.menu=menu;
		this.count=count;
		this.total=total;
		this.strHow=strHow;	
	}

	public ArrData() 
	{
	}
	
	// getter
	public int getY(){ return y; }
	public int getM(){ return m; }
	public int getD(){ return d; }
	public int getH(){ return h; }
	public int getMin(){ return min;}

}//ArrData 끝


// 정렬기준 1. 결제시간 오름차순 정렬
class DateArray implements Comparator<ArrData>
{
		@Override
		public int compare(ArrData o1, ArrData o2)
		{
			return o1.getD() - o2.getD();
		}
}

// 정렬기준 2. 메뉴 오름차순 정렬
class MenuArray implements Comparator<ArrData>
{
		@Override
		public int compare(ArrData o1, ArrData o2)
		{
			return o1.menu.compareTo(o2.menu);
		}
}

// 정렬기준 3. 회원ID 오름차순 정렬
class MemberArray implements Comparator<ArrData>
{
		@Override
		public int compare(ArrData o1, ArrData o2)
		{
			return o1.name.compareTo(o2.name);
		}
}

// 정렬기준 4. 결제수단 오름차순 정렬
class CardCashArray implements Comparator<ArrData>
{
		@Override
		public int compare(ArrData o1, ArrData o2)
		{
			return o1.strHow.compareTo(o2.strHow);
		}
}



public class Payment
{
	public static void main(String[] args) 
	{


	}
}