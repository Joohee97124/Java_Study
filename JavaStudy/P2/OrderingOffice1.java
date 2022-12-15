import java.util.Scanner;
import java.util.Vector;
import java.io.IOException;

class Lime
{
	static final String ingName = "라임주스";
	int ingNum = 1;
	private static int minQty = 15;
	private static int nowQty = 10;
	static String supplier = "(주)풍성주스";
	
	// 라임주스가 포함된 메뉴 출력
	public static void print_Rmenu()
	{
		System.out.println("마가리타");
		System.out.println("블루 하와이");
		System.out.println("코스모폴리탄");
		System.out.println("진 라임");
	}

	// getter setter 

	public static int getMinQty()
	{
		return minQty;
	}

	public static void setMinQty(int minQty)
	{
		Lime.minQty = minQty;
	}

	public static int getNowQty()
	{
		return nowQty;
	}

	public static void setNowQty(int nowQty)
	{
		Lime.nowQty = nowQty;
	}
}

class Lemon
{
	static final String ingName = "레몬주스";
	int ingNum = 2;
	private static int minQty = 15;
	private static int nowQty = 0;
	static String supplier = "(주)풍성주스";

	// 레몬주스가 포함된 메뉴 출력

	public static void print_Rmenu()
	{
		System.out.println("데킬라 사워");
		System.out.println("허니문");
		System.out.println("클로버 클럽");
	}

	// getter setter 

	public static int getMinQty()
	{
		return minQty;
	}

	public static void setMinQty(int minQty)
	{
		Lemon.minQty = minQty;
	}

	public static int getNowQty()
	{
		return nowQty;
	}

	public static void setNowQty(int nowQty)
	{
		Lemon.nowQty = nowQty;
	}
}

class Cranberry
{
	static final String ingName = "크랜베리주스";
	int ingNum = 3;
	private static int minQty = 15;
	private static int nowQty = 0;
	static String supplier = "(주)풍성주스";

	// 크랜베리주스가 포함된 메뉴 출력

	public static void print_Rmenu()
	{
		System.out.println("선 번");
		System.out.println("코스모폴리탄");
		System.out.println("클로버 클럽");
	}


	// getter setter 

	public static int getMinQty()
	{
		return minQty;
	}

	public static void setMinQty(int minQty)
	{
		Cranberry.minQty = minQty;
	}

	public static int getNowQty()
	{
		return nowQty;
	}

	public static void setNowQty(int nowQty)
	{
		Cranberry.nowQty = nowQty;
	}
}

class Pineapple
{
	static final String ingName = "파인애플주스";
	int ingNum = 4;
	private static int minQty = 20;
	private static int nowQty = 0;
	static String supplier = "(주)풍성주스";

	// 파인애플주스가 포함된 메뉴 출력

	public static void print_Rmenu()
	{
		System.out.println("피나 콜라다");
		System.out.println("발렌시아");
	}

	// getter setter 

	public static int getMinQty()
	{
		return minQty;
	}

	public static void setMinQty(int minQty)
	{
		Pineapple.minQty = minQty;
	}

	public static int getNowQty()
	{
		return nowQty;
	}

	public static void setNowQty(int nowQty)
	{
		Pineapple.nowQty = nowQty;
	}
}

class BlueCu
{
	static final String ingName = "블루큐라소";
	int ingNum = 5;
	private static int minQty = 10;
	private static int nowQty = 0;
	static String supplier = "(주)풍성주스";

	// 블루큐라소가 포함된 메뉴 출력

	public static void print_Rmenu()
	{
		System.out.println("블루 하와이");
		System.out.println("블루 스카이");
	}

	// getter setter 

	public static int getMinQty()
	{
		return minQty;
	}

	public static void setMinQty(int minQty)
	{
		BlueCu.minQty = minQty;
	}

	public static int getNowQty()
	{
		return nowQty;
	}

	public static void setNowQty(int nowQty)
	{
		BlueCu.nowQty = nowQty;
	}
}

class Cracker
{
	static final String ingName = "크래커";
	int ingNum = 6;
	private static int minQty = 10 ;
	private static int nowQty = 0;
	static String supplier = "(주)한국안주";

	// getter setter 

	public static int getMinQty()
	{
		return minQty;
	}

	public static void setMinQty(int minQty)
	{
		Cracker.minQty = minQty;
	}

	public static int getNowQty()
	{
		return nowQty;
	}

	public static void setNowQty(int nowQty)
	{
		Cracker.nowQty = nowQty;
	}
}

class Cheese
{
	static final String ingName = "치즈";
	int ingNum = 7;
	private static int minQty = 10;
	private static int nowQty = 0;
	static String supplier = "(주)한국안주";

	// getter setter 

	public static int getMinQty()
	{
		return minQty;
	}

	public static void setMinQty(int minQty)
	{
		Cheese.minQty = minQty;
	}

	public static int getNowQty()
	{
		return nowQty;
	}

	public static void setNowQty(int nowQty)
	{
		Cheese.nowQty = nowQty;
	}
}

class Almond
{
	static final String ingName = "아몬드";
	int ingNum = 8;
	private static int minQty = 10;
	private static int nowQty = 0;
	static String supplier = "(주)한국안주";

	// getter setter 

	public static int getMinQty()
	{
		return minQty;
	}

	public static void setMinQty(int minQty)
	{
		Almond.minQty = minQty;
	}

	public static int getNowQty()
	{
		return nowQty;
	}

	public static void setNowQty(int nowQty)
	{
		Almond.nowQty = nowQty;
	}
}

class Tequila
{
	static final String ingName = "데킬라";
	int ingNum = 9;
	private static int minQty = 30;
	private static int nowQty = 0;
	static String supplier = "(주)대한음료";
	
	// 데킬라가 포함된 메뉴 출력
	public static void print_Rmenu()
	{
		System.out.println("마가리타");
		System.out.println("선 번");
		System.out.println("데킬라 사워");
	}
	
	// 최소 수량의 getter()
	public static int getMinQty()
	{
		return minQty;
	}

	// 최소 수량의 setter()
	public static void setMinQty(int minQty)
	{
		Tequila.minQty = minQty;
	}

	// 현재 수량의 getter()
	public static int getNowQty()
	{
		return nowQty;
	}

	// 현재 수량의 setter()
	public static void setNowQty(int nowQty)
	{
		Tequila.nowQty = nowQty;
	}
}

class Rum
{
	static final String ingName = "럼";
	int ingNum = 10;
	private static int minQty = 30;
	private static int nowQty = 0;
	static String suppiler = "(주)대한음료";

	// 럼이 포함된 메뉴 출력
	public static void print_Rmenu()
	{
		System.out.println("피나 콜라다");
		System.out.println("블루 하와이");
	}

	// 최소 수량의 getter()
	public static int getMinQty()
	{
		return minQty;
	}

	// 최소 수량의 setter()
	public static void setMinQty(int minQty)
	{
		Rum.minQty = minQty;
	}

	// 현재 수량의 getter()
	public static int getNowQty()
	{
		return nowQty;
	}

	// 현재 수량의 setter()
	public static void setNowQty(int nowQty)
	{
		Rum.nowQty = nowQty;
	}
}

class Brandy
{
	static final String ingName = "브랜디";
	int ingNum = 11;
	private static int minQty = 25;
	private static int nowQty = 0;
	static String supplier = "(주)대한음료";

	// 브랜디가 포함된 메뉴 출력
	public static void print_Rmenu()
	{
		System.out.println("발렌시아");
		System.out.println("허니문");
	}


	// 최소 수량의 getter()
	public static int getMinQty()
	{
		return minQty;
	}

	// 최소 수량의 setter()
	public static void setMinQty(int minQty)
	{
		Brandy.minQty = minQty;
	}

	// 현재 수량의 getter()
	public static int getNowQty()
	{
		return nowQty;
	}

	// 현재 수량의 setter()
	public static void setNowQty(int nowQty)
	{
		Brandy.nowQty = nowQty;
	}
}

class Vodka
{
	static final String ingName = "보드카";
	int ingNum = 12;
	private static int minQty = 10;
	private static int nowQty = 0;
	static String supplier = "(주)대한음료";

	// 보드카가 포함된 메뉴 출력
	public static void print_Rmenu()
	{
		System.out.println("블루 스카이");
		System.out.println("코스모폴리탄");
	}


	// 최소 수량의 getter()
	public static int getMinQty()
	{
		return minQty;
	}

	// 최소 수량의 setter()
	public static void setMinQty(int minQty)
	{
		Vodka.minQty = minQty;
	}

	// 현재 수량의 getter()
	public static int getNowQty()
	{
		return nowQty;
	}

	// 현재 수량의 setter()
	public static void setNowQty(int nowQty)
	{
		Vodka.nowQty = nowQty;
	}
}

class Jin
{
	static final String ingName = "진";
	int ignNum = 13;
	private static int minQty = 45;
	private static int nowQty = 0;
	static String supplier = "(주)대한음료";

	// 진이 포함된 메뉴 출력
	public static void print_Rmenu()
	{
		System.out.println("클로버 클럽");
		System.out.println("진라임");
	}


	// 최소 수량의 getter()
	public static int getMinQty()
	{
		return minQty;
	}

	// 최소 수량의 setter()
	public static void setMinQty(int minQty)
	{
		Jin.minQty = minQty;
	}

	// 현재 수량의 getter()
	public static int getNowQty()
	{
		return nowQty;
	}

	// 현재 수량의 setter()
	public static void setNowQty(int nowQty)
	{
		Jin.nowQty = nowQty;
	}
}
//--------------------------------------------------------------

// 발주를 입력할 때 보통 재료의 번호에 수량을 입력.

// 현재 수량과 발주처를 선택할 수 있는 클래스

// 재료별 발주처 변경.

/*
	static final String ingName = "진";
	int ignNum = 13;
	private static int minQty = 45;
	private static int nowQty = 0;
	static String supplier = "(주)대한음료";
*/

/* 재료 이름, 거래처 이름 수정 등등..
class Officechange
{
	public static void ingnames()
	{
		Scanner sc = new Scanner(System.in);
		Jin officeJin = new Jin();
		
		System.out.println(" 메뉴 주우우욱 " );
		System.out.println("변경할 메뉴를 선택 해 주세요 : ");
		
		System.out.println(Jin.ingName);

		String newIngName = sc.next();
		Jin.ingName = newIngName;

		System.out.println("바뀜" + Jin.ingName);
	}
}
*/



// 재고 관리 클래스.
class MainOffice
{	
	private static int qty;					// 발주량
	private static int sumqty;				// 기존의 양과 발주량을 더할 변수!
	private static int num;					// 선택 해주는 변수..
	private static char select;				// YES / NO

	public static void selectOffice() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\t1. 주스  2. 안주  3. 베이스");
		System.out.print("\t발주 하실 재료를 골라주세요 : ");
		num = sc.nextInt();
		System.out.println();

		switch (num)
		{
			case 1 : orderingOffice1(); break;
			case 2 : orderingOffice2(); break;
			case 3 : orderingOffice3(); break;

			// case 4: 다른 페이지로 넘어갈 곳.
		}
	}

	// 풍성 주스 거래처 메소드 주스( 1~ 5 )
	public static void orderingOffice1() throws IOException
	{	
		Scanner sc = new Scanner(System.in);

		Lime orderLime = new Lime();
		Lemon orderLemon = new Lemon();
		Cranberry orderCranberry = new Cranberry();
		Pineapple orderPineapple = new Pineapple();
		BlueCu orderBlueCu = new BlueCu();

		System.out.println("\t1. "+ orderLime.ingName + "2. " + orderLemon.ingName +
							 "3. "+ orderCranberry.ingName + "4. " + orderPineapple.ingName + "5. " + orderBlueCu.ingName);
		
		System.out.print("\t발주할 품목을 정해주세요 : " );
		num = sc.nextInt();
		System.out.println();

		do
		{	
			System.out.println("\t㈜ 풍성주스 거래처 입니다. 최소 발주량은 20ml " );
			System.out.println();
			System.out.print("\t해당 재료의 발주할 양(ea)을 입력 해 주세요 : ");
			qty = sc.nextInt();
		}
		while (qty < 20);

		try
		{	
			System.out.print("\n\t");
			String s = " 발 주 내 역 전 송 중 입 니 다 . . . .";
			for (int i = 0; i < s.length(); i++) 
			{ 
			   // 로딩 효과 스레드
			   Thread.sleep(80);					// s 문자열을 돌면서 sleep() 안의 단위 마다 한 문자씩 출력!
			   System.out.print(s.charAt(i));
			}

			System.out.println("\n");
		}
		catch (InterruptedException e)
		{
			System.out.println();					// 쓰레드는 예외 처리를 해줘야 함..
		}

		if (num == 1)
		{	
			System.out.print("\t["+ orderLime.ingName + "] 기존 적재량 : " + orderLime.getNowQty() + "\t");
			sumqty = orderLime.getNowQty()+qty;
			orderLime.setNowQty(sumqty);
			System.out.println("발주 후 적재량 : " + orderLime.getNowQty());
		}

		else if (num == 2)
		{
			System.out.print("\t["+ orderLemon.ingName + "] 기존 적재량 : " + orderLemon.getNowQty() + "\t");
			sumqty = orderLemon.getNowQty()+qty;
			orderLemon.setNowQty(sumqty);
			System.out.println("발주 후 적재량 : " + orderLemon.getNowQty());
		}
		else if (num == 3)
		{
			System.out.print("\t["+ orderCranberry.ingName + "] 기존 적재량 : " + orderCranberry.getNowQty() + "\t");
			sumqty = orderCranberry.getNowQty()+qty;
			orderCranberry.setNowQty(sumqty);
			System.out.println("발주 후 적재량 : " + orderCranberry.getNowQty());
		}
		else if (num == 4)
		{
			System.out.print("\t["+ orderPineapple.ingName + "] 기존 적재량 : " + orderPineapple.getNowQty() + "\t");
			sumqty = orderPineapple.getNowQty()+qty;
			orderPineapple.setNowQty(sumqty);
			System.out.println("발주 후 적재량 : " + orderPineapple.getNowQty());
		}
		else if (num == 5)
		{
			System.out.print("\t["+ orderBlueCu.ingName + "] 기존 적재량 : " + orderBlueCu.getNowQty() + "\t");
			sumqty = orderBlueCu.getNowQty()+qty;
			orderBlueCu.setNowQty(sumqty);
			System.out.println("발주 후 적재량 : " + orderBlueCu.getNowQty());
		}
		System.out.println();

		System.out.print("\t계속 발주 하시겠습니까?(Y/N) : ");
		select = (char)System.in.read();

		if (select == 'Y' || select == 'y')
			selectOffice();
		System.out.println();
		
			// 연결 해 줄곳..
	}

	// 한국 안주 거래처 안주 ( 6 ~ 8 )
	public static void orderingOffice2() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		Cracker orderCracker = new Cracker();
		Cheese orderCheese = new Cheese();
		Almond orderAlmond = new Almond();

		System.out.println("\t1. "+ orderCracker.ingName + "2. " + orderCheese.ingName +
							 "3. "+ orderAlmond.ingName);
		
		System.out.print("\t발주할 품목을 정해주세요 : ");
		num = sc.nextInt();
		System.out.println();

		do
		{	
			System.out.println("\t㈜ 한국안주 거래처 입니다 (최소 발주량 10ea).");
			System.out.print("\t해당 재료의 발주할 양(ea)을 입력 해 주세요 : ");
			qty = sc.nextInt();
		}
		while (qty < 10);

		try
		{	
			System.out.print("\n\t");
			String s = " 발 주 내 역 전 송 중 입 니 다 . . . .";
			for (int i = 0; i < s.length(); i++) 
			{ 
			   // 로딩 효과 스레드
			   Thread.sleep(80);					// s 문자열을 돌면서 sleep() 안의 단위 마다 한 문자씩 출력!
			   System.out.print(s.charAt(i));
			}

			System.out.println("\n");
		}
		catch (InterruptedException e)
		{
			System.out.println();					// 쓰레드는 예외 처리를 해줘야 함..
		}

		if (num == 1)
		{	
			System.out.print("\t["+ orderCracker.ingName + "] 기존 적재량 : " + orderCracker.getNowQty() + "\t");
			sumqty = orderCracker.getNowQty()+qty;
			orderCracker.setNowQty(sumqty);
			System.out.println("발주 후 적재량 : " + orderCracker.getNowQty());
		}

		else if (num == 2)
		{
			System.out.print("\t["+ orderCheese.ingName + "] 기존 적재량 : " + orderCheese.getNowQty() + "\t");
			sumqty = orderCheese.getNowQty()+qty;
			orderCheese.setNowQty(sumqty);
			System.out.println("발주 후 적재량 : " + orderCheese.getNowQty());
		}
		else if (num == 3)
		{
			System.out.print("\t["+ orderAlmond.ingName + "] 기존 적재량 : " + orderAlmond.getNowQty() + "\t");
			sumqty = orderAlmond.getNowQty()+qty;
			orderAlmond.setNowQty(sumqty);
			System.out.println("발주 후 적재량 : " + orderAlmond.getNowQty());
		}
		System.out.println();

		System.out.print("\t계속 발주 하시겠습니까?(Y/N) : ");
		select = (char)System.in.read();

		if (select == 'Y' || select == 'y')
			selectOffice();
		System.out.println();
	}

	// 한국 안주 거래처 술..( 9 ~ 13 )
	public static void orderingOffice3() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		Tequila orderTequila = new Tequila();
		Rum orderRum = new Rum();
		Brandy orderBrandy = new Brandy();
		Vodka orderVodka = new Vodka();
		Jin orderJin = new Jin();

		System.out.println("\t1. "+ orderTequila.ingName + "2. " + orderRum.ingName +
							 "3. "+ orderBrandy.ingName + "4. " + orderVodka.ingName + "5. " + orderJin.ingName);
		
		System.out.print("\t발주할 품목을 정해주세요 : " );
		num = sc.nextInt();
		System.out.println();

		do
		{	
			System.out.println("\t㈜ 대한음료 거래처 입니다. (최소 발주량 45ml) " );
			System.out.print("\t해당 재료의 발주할 양(ml)을 입력 해 주세요 : ");
			qty = sc.nextInt();
			System.out.println();
		}
		while (qty < 45);

		try
		{	
			System.out.print("\n\t");
			String s = " 발 주 내 역 전 송 중 입 니 다 . . . .";
			for (int i = 0; i < s.length(); i++) 
			{ 
			   // 로딩 효과 스레드
			   Thread.sleep(80);					// s 문자열을 돌면서 sleep() 안의 단위 마다 한 문자씩 출력!
			   System.out.print(s.charAt(i));
			}

			System.out.println("\n");
		}
		catch (InterruptedException e)
		{
			System.out.println();					// 쓰레드는 예외 처리를 해줘야 함..
		}

		if (num == 1)
		{	
			System.out.print("\t["+ orderTequila.ingName + "] 기존 적재량 : " + orderTequila.getNowQty() + "\t");
			sumqty = orderTequila.getNowQty()+qty;
			orderTequila.setNowQty(sumqty);
			System.out.println("발주 후 적재량 : " + orderTequila.getNowQty());
		}

		else if (num == 2)
		{
			System.out.print("\t["+ orderRum.ingName + "] 기존 적재량 : " + orderRum.getNowQty() + "\t");
			sumqty = orderRum.getNowQty()+qty;
			orderRum.setNowQty(sumqty);
			System.out.println("발주 후 적재량 : " + orderRum.getNowQty());
		}
		else if (num == 3)
		{
			System.out.print("\t["+ orderBrandy.ingName + "] 기존 적재량 : " + orderBrandy.getNowQty() + "\t");
			sumqty = orderBrandy.getNowQty()+qty;
			orderBrandy.setNowQty(sumqty);
			System.out.println("발주 후 적재량 : " + orderBrandy.getNowQty());
		}
		else if (num == 4)
		{
			System.out.print("\t["+ orderVodka.ingName + "] 기존 적재량 : " + orderVodka.getNowQty() + "\t");
			sumqty = orderVodka.getNowQty()+qty;
			orderVodka.setNowQty(sumqty);
			System.out.println("발주 후 적재량 : " + orderVodka.getNowQty());
		}
		else if (num == 5)
		{
			System.out.print("\t["+ orderJin.ingName + "] 기존 적재량 : " + orderJin.getNowQty() + "\t");
			sumqty = orderJin.getNowQty()+qty;
			orderJin.setNowQty(sumqty);
			System.out.println("발주 후 적재량 : " + orderJin.getNowQty());
		}
		
		System.out.print("\t계속 발주 하시겠습니까?(Y/N) : ");
		select = (char)System.in.read();

		if (select == 'Y' || select == 'y')
			selectOffice();
		System.out.println();
	}
}

// 재고의 현황을 클래스로 받아오는데,, 거래처에서의 작업도 클래스 안에서 이루어져야함.
// vector를 쓰면.. 

// 재료 클래스들에서 현재 수량을 받아온다..


// 거래처 확인 클래스
class OkOffice
{
	public static void printOffice()
	{
		System.out.println("----------------------------------------------------------");
		System.out.println("거래처명 : (주)풍성주스");
		System.out.println();
		System.out.println("주소 : 경기도 화성시 남양읍 무하로66 ");
		System.out.println("거래 품목 : 라임주스 | 레몬주스 | 크랜베리주스 | 파인애플주스 | 블루큐라소 ");
		System.out.println("전화번호 : 031-8282-8585");
		System.out.println();
		System.out.println();
		System.out.println("거래처명 : (주)대한음료");
		System.out.println();
		System.out.println("주소 : 충청남도 서천군 서천읍137 ");
		System.out.println("거래 품목 : 데킬라 || 럼 || 브랜디 || 보드카 || 진 ");
		System.out.println("전화번호 : 1544-0909");
		System.out.println();
		System.out.println();
		System.out.println("거래처명 : (주)한국안주");
		System.out.println();
		System.out.println("주소 : 경기도 시흥시 정왕동 안양천로32 ");
		System.out.println("거래 품목 : 크래커 || 치즈 || 아몬드 ");
		System.out.println("전화번호 : 031-8041-1000");
		System.out.println("----------------------------------------------------------");
	}



}