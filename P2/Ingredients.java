import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

class Lime
{
	private static final String ingName = "라임주스";
	int ingNum = 1;
	private static int minQty = 15;
	private static int nowQty = 100;
	private static String supplier = "(주)풍성주스";
	
	// 라임주스가 포함된 메뉴 출력

	public static void print_Rmenu()
	{
		System.out.println("마가리타");
		System.out.println("블루 하와이");
		System.out.println("코스모폴리탄");
		System.out.println("진 라임");
	}

	// getter setter 
	public static String getIngName()
	{
		return ingName;
	}

	public static String getSupplier()
	{
		return supplier;
	}

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
	private static final String ingName = "레몬주스";
	int ingNum = 2;
	private static int minQty = 15;
	private static int nowQty = 100;
	private static String supplier = "(주)풍성주스";

	// 레몬주스가 포함된 메뉴 출력

	public static void print_Rmenu()
	{
		System.out.println("데킬라 사워");
		System.out.println("허니문");
		System.out.println("클로버 클럽");
	}

	// getter setter 
	public static String getIngName()
	{
		return ingName;
	}

	public static String getSupplier()
	{
		return supplier;
	}

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
	private static final String ingName = "크랜베리주스";
	int ingNum = 3;
	private static int minQty = 15;
	private static int nowQty = 0;
	private static String supplier = "(주)풍성주스";

	// 크랜베리주스가 포함된 메뉴 출력

	public static void print_Rmenu()
	{
		System.out.println("선 번");
		System.out.println("코스모폴리탄");
		System.out.println("클로버 클럽");
	}


	// getter setter 
	public static String getIngName()
	{
		return ingName;
	}

	public static String getSupplier()
	{
		return supplier;
	}

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
	private static final String ingName = "파인애플주스";
	int ingNum = 4;
	private static int minQty = 20;
	private static int nowQty = 100;
	private static String supplier = "(주)풍성주스";

	// 파인애플주스가 포함된 메뉴 출력

	public static void print_Rmenu()
	{
		System.out.println("피나 콜라다");
		System.out.println("발렌시아");
	}

	// getter setter 
	public static String getIngName()
	{
		return ingName;
	}

	public static String getSupplier()
	{
		return supplier;
	}

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
	private static final String ingName = "블루큐라소";
	int ingNum = 5;
	private static int minQty = 10;
	private static int nowQty = 100;
	private static String supplier = "(주)풍성주스";

	// 블루큐라소가 포함된 메뉴 출력

	public static void print_Rmenu()
	{
		System.out.println("블루 하와이");
		System.out.println("블루 스카이");
	}

	// getter setter 
	public static String getIngName()
	{
		return ingName;
	}

	public static String getSupplier()
	{
		return supplier;
	}

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
	private static final String ingName = "크래커";
	int ingNum = 6;
	private static int minQty = 0 ;
	private static int nowQty = 20;
	private static String supplier = "(주)한국안주";

	// getter setter 
	public static String getIngName()
	{
		return ingName;
	}

	public static String getSupplier()
	{
		return supplier;
	}

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
	private static final String ingName = "치즈";
	int ingNum = 7;
	private static int minQty = 10;
	private static int nowQty = 50;
	private static String supplier = "(주)한국안주";

	// getter setter 
	public static String getIngName()
	{
		return ingName;
	}

	public static String getSupplier()
	{
		return supplier;
	}

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
	private static final String ingName = "아몬드";
	int ingNum = 8;
	private static int minQty = 10;
	private static int nowQty = 200;
	private static String supplier = "(주)한국안주";

	// getter setter 
	public static String getIngName()
	{
		return ingName;
	}

	public static String getSupplier()
	{
		return supplier;
	}

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
	private static final String ingName = "데킬라";
	int ingNum = 9;
	private static int minQty = 30;
	private static int nowQty = 120;
	private static String supplier = "(주)대한음료";
	
	// 데킬라가 포함된 메뉴 출력
	public static void print_Rmenu()
	{
		System.out.println("마가리타");
		System.out.println("선 번");
		System.out.println("데킬라 사워");
	}
	
	public static String getIngName()
	{
		return ingName;
	}

	public static String getSupplier()
	{
		return supplier;
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
	private static final String ingName = "럼";
	int ingNum = 10;
	private static int minQty = 30;
	private static int nowQty = 210;
	private static String supplier = "(주)대한음료";

	// 럼이 포함된 메뉴 출력
	public static void print_Rmenu()
	{
		System.out.println("피나 콜라다");
		System.out.println("블루 하와이");
	}

	public static String getIngName()
	{
		return ingName;
	}

	public static String getSupplier()
	{
		return supplier;
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
	private static final String ingName = "브랜디";
	int ingNum = 11;
	private static int minQty = 25;
	private static int nowQty = 0;
	private static String supplier = "(주)대한음료";

	// 브랜디가 포함된 메뉴 출력
	public static void print_Rmenu()
	{
		System.out.println("발렌시아");
		System.out.println("허니문");
	}
	
	public static String getIngName()
	{
		return ingName;
	}

	public static String getSupplier()
	{
		return supplier;
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
	private static final String ingName = "보드카";
	int ingNum = 12;
	private static int minQty = 10;
	private static int nowQty = 200;
	private static String supplier = "(주)대한음료";

	// 보드카가 포함된 메뉴 출력
	public static void print_Rmenu()
	{
		System.out.println("블루 스카이");
		System.out.println("코스모폴리탄");
	}

	
	public static String getIngName()
	{
		return ingName;
	}

	public static String getSupplier()
	{
		return supplier;
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
	private static final String ingName = "진";
	int ignNum = 13;
	private static int minQty = 45;
	private static int nowQty = 250;
	private static String supplier = "(주)대한음료";

	// 진이 포함된 메뉴 출력
	public static void print_Rmenu()
	{
		System.out.println("클로버 클럽");
		System.out.println("진라임");
	}

	public static String getIngName()
	{
		return ingName;
	}

	public static String getSupplier()
	{
		return supplier;
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



// 재고관리의 첫 페이지 (메뉴) 클래스
class InvPage
{
	
	public static void stockManage() 
	{
		valPage vp = new valPage();
		
		try
		{
			int n;
			Management stock1 = new Management();

			InventoryM.bujok();		// 부족 시의 출력문
			
			Scanner sc = new Scanner(System.in);

			do
			{
				System.out.print("재고관리 메뉴를 선택하세요 → 1. 재료 검색    2. 발주 관리    3. 관리자 페이지로 이동: ");
				n = sc.nextInt();
				System.out.println();
			}
			while (n<1 || n>3);
			// 1-3 이외의 메뉴 번호 입력 시 메뉴 선택 다시 반복


			if (n==1)
			{	// 재료 검색 호출
				InventoryM.searchI();

			}
			
			else if (n==2)
			{
				// 발주 관련 메뉴 페이지 호출
				vp.valMenu1();
			}
			
			else if (n==3)
			{ // 관리자 첫 메뉴 페이지 호출
				stock1.managerMenu();
			}
			else 
				System.out.println("잘못된 메뉴 번호입니다.");
			}
		catch (InputMismatchException e1)
		{
			System.out.println("잘못된 메뉴 번호입니다.");
		}

		catch (IOException e2)
		{
			System.out.println("잘못된 메뉴 번호입니다.");
		}
	}
}



// 거래처 관련 페이지 (메뉴) 클래스
class valPage
{
	public static int n;

	public static void valMenu1() throws IOException
	{
		MainOffice mo = new MainOffice();
		OkOffice ok = new OkOffice();
		InvPage invent = new InvPage();

		Scanner sc = new Scanner(System.in);

		System.out.print("발주 관련 메뉴를 선택하세요 → 1. 거래처 확인    2. 발주 입력 : ");
		n = sc.nextInt();


		if (n==1)
		{
			// 거래처 확인 클래스,메소드 호출
			ok.printOffice();
			
		}
		else if (n==2)
		{
			// 발주 입력 클래스메소드 호출
			mo.selectOffice();
		}
		
		invent.stockManage();	// 재고관리 첫 페이지로 이동

	}
}



// 재고 출력문, 검색 → 현황 출력 클래스
class InventoryM 
{
	public static String search;


	// 재고 부족 시 출력해주는 메소드
	public static void bujok()
	{
		System.out.println("============================================================");

		if (Lime.getNowQty() < Lime.getMinQty())
			System.out.println("■■라임■■의 재고가 부족합니다");
		if (Lemon.getNowQty() < Lemon.getMinQty())
			System.out.println("■■레몬■■의 재고가 부족합니다");
		if (Cranberry.getNowQty() < Cranberry.getMinQty())
			System.out.println("■■크랜베리■■의 재고가 부족합니다");
		if (Pineapple.getNowQty() < Pineapple.getMinQty())
			System.out.println("■■파인애플■■의 재고가 부족합니다");
		if (BlueCu.getNowQty() < BlueCu.getMinQty())
			System.out.println("■■블루 큐라소■■의 재고가 부족합니다");
		if (Cracker.getNowQty() < Cracker.getMinQty())
			System.out.println("■■크래커의 재고■■가 부족합니다");
		if (Cheese.getNowQty() < Cheese.getMinQty())
			System.out.println("■■치즈■■의 재고가 부족합니다");
		if (Almond.getNowQty() < Almond.getMinQty())
			System.out.println("■■아몬드■■의 재고가 부족합니다");
		if (Tequila.getNowQty() < Tequila.getMinQty())
			System.out.println("■■데킬라(베이스)■■의 재고가 부족합니다");
		if (Rum.getNowQty() < Rum.getMinQty())
			System.out.println("■■럼(베이스)■■의 재고가 부족합니다");
		if (Brandy.getNowQty() < Brandy.getMinQty())
			System.out.println("■■브랜디(베이스)■■의 재고가 부족합니다");
		if (Vodka.getNowQty() < Vodka.getMinQty())
			System.out.println("■■보드카(베이스)■■의 재고가 부족합니다");
		if (Jin.getNowQty() < Jin.getMinQty())
			System.out.println("■■진(베이스)■■의 재고가 부족합니다");

		System.out.println("============================================================");
		System.out.println();
	}


	// 재고 검색 메소드
	public static void searchI() throws IOException
	{
		InvPage invent = new InvPage();
		Management stock1 = new Management();

		Scanner sc = new Scanner(System.in);

		System.out.print("검색할 재료를 입력하세요 : ");
		search = sc.next();

		if (search.equals("라임주스") || search.equals("라임 주스") || search.equals("라임")
			|| search.equals("Lime") || search.equals("lime") )
		{
			String na = Lime.getIngName();
			String su = Lime.getSupplier();
			int m = Lime.getMinQty();
			int n = Lime.getNowQty();

			System.out.println("재료명 : " + na);
			System.out.println("최소 수량 : " + m);
			System.out.println("현재 수량 : " + n);
			System.out.println("발주처 : " + su);
		}

		else if (search.equals("레몬주스") || search.equals("레몬 주스") || search.equals("레몬")
			|| search.equals("Lemon") || search.equals("lemon") )
		{
			String na = Lemon.getIngName();
			String su = Lemon.getSupplier();
			int m = Lemon.getMinQty();
			int n = Lemon.getNowQty();

			System.out.println("재료명 : " + na);
			System.out.println("최소 수량 : " + m);
			System.out.println("현재 수량 : " + n);
			System.out.println("발주처 : " + su);
		}

		else if (search.equals("크랜베리주스") || search.equals("크랜베리 주스") || search.equals("크랜베리")
			|| search.equals("Cranberry") || search.equals("cranberry") )
		{
			String na = Cranberry.getIngName();
			String su = Cranberry.getSupplier();
			int m = Cranberry.getMinQty();
			int n = Cranberry.getNowQty();

			System.out.println("재료명 : " + na);
			System.out.println("최소 수량 : " + m);
			System.out.println("현재 수량 : " + n);
			System.out.println("발주처 : " + su);
		}

		else if (search.equals("파인애플주스") || search.equals("파인애플 주스") || search.equals("파인애플")
			|| search.equals("Pineapple") || search.equals("pinapple") )
		{
			String na = Pineapple.getIngName();
			String su = Pineapple.getSupplier();
			int m = Pineapple.getMinQty();
			int n = Pineapple.getNowQty();

			System.out.println("재료명 : " + na);
			System.out.println("최소 수량 : " + m);
			System.out.println("현재 수량 : " + n);
			System.out.println("발주처 : " + su);
		}

		else if (search.equals("블루큐라소") || search.equals("블루 큐라소") 
			|| search.equals("BlueCu") || search.equals("bluecu") )
		{
			String na = BlueCu.getIngName();
			String su = BlueCu.getSupplier();
			int m = BlueCu.getMinQty();
			int n = BlueCu.getNowQty();

			System.out.println("재료명 : " + na);
			System.out.println("최소 수량 : " + m);
			System.out.println("현재 수량 : " + n);
			System.out.println("발주처 : " + su);
		}

		else if (search.equals("크래커") || search.equals("Cracker") || search.equals("cracker") )
		{
			String na = Cracker.getIngName();
			String su = Cracker.getSupplier();
			int m = Cracker.getMinQty();
			int n = Cracker.getNowQty();

			System.out.println("재료명 : " + na);
			System.out.println("최소 수량 : " + m);
			System.out.println("현재 수량 : " + n);
			System.out.println("발주처 : " + su);
		}

		else if (search.equals("치즈") || search.equals("Cheese") || search.equals("cheese") )
		{
			String na = Cheese.getIngName();
			String su = Cheese.getSupplier();
			int m = Cheese.getMinQty();
			int n = Cheese.getNowQty();

			System.out.println("재료명 : " + na);
			System.out.println("최소 수량 : " + m);
			System.out.println("현재 수량 : " + n);
			System.out.println("발주처 : " + su);
		}

		else if (search.equals("아몬드") || search.equals("Almond") || search.equals("almond") )
		{
			String na = Almond.getIngName();
			String su = Almond.getSupplier();
			int m = Almond.getMinQty();
			int n = Almond.getNowQty();

			System.out.println("재료명 : " + na);
			System.out.println("최소 수량 : " + m);
			System.out.println("현재 수량 : " + n);
			System.out.println("발주처 : " + su);
		}

		else if (search.equals("데킬라") || search.equals("데낄라") || search.equals("Tequila") || search.equals("tequila") )
		{
			String na = Tequila.getIngName();
			String su = Tequila.getSupplier();
			int m = Tequila.getMinQty();
			int n = Tequila.getNowQty();

			System.out.println("재료명 : " + na);
			System.out.println("최소 수량 : " + m);
			System.out.println("현재 수량 : " + n);
			System.out.println("발주처 : " + su);
		}

		else if (search.equals("럼") || search.equals("Rum") || search.equals("rum") )
		{
			String na = Rum.getIngName();
			String su = Rum.getSupplier();
			int m = Rum.getMinQty();
			int n = Rum.getNowQty();

			System.out.println("재료명 : " + na);
			System.out.println("최소 수량 : " + m);
			System.out.println("현재 수량 : " + n);
			System.out.println("발주처 : " + su);
		}

		else if (search.equals("브랜디") || search.equals("Brandy") || search.equals("brandy") )
		{
			String na = Brandy.getIngName();
			String su = Brandy.getSupplier();
			int m = Brandy.getMinQty();
			int n = Brandy.getNowQty();

			System.out.println("재료명 : " + na);
			System.out.println("최소 수량 : " + m);
			System.out.println("현재 수량 : " + n);
			System.out.println("발주처 : " + su);
		}

		else if (search.equals("보드카") || search.equals("Vodka") || search.equals("vodka") )
		{
			String na = Vodka.getIngName();
			String su = Vodka.getSupplier();
			int m = Vodka.getMinQty();
			int n = Vodka.getNowQty();

			System.out.println("재료명 : " + na);
			System.out.println("최소 수량 : " + m);
			System.out.println("현재 수량 : " + n);
			System.out.println("발주처 : " + su);
		}

		else if (search.equals("진") || search.equals("Jin") || search.equals("jin") )
		{
			String na = Jin.getIngName();
			String su = Jin.getSupplier();
			int m = Jin.getMinQty();
			int n = Jin.getNowQty();

			System.out.println("재료명 : " + na);
			System.out.println("최소 수량 : " + m);
			System.out.println("현재 수량 : " + n);
			System.out.println("발주처 : " + su);
		}

		else
		{
			System.out.printf("입력하신 재료 (%s) 는 없습니다.\n",search);
			System.out.println();
			// 입력한 재료가 없는 재료일 경우 재고관리 첫 페이지로 돌아가기
			invent.stockManage();
		}	

		System.out.println();	// 개행


		// 현황 출력 후 발주 입력을 물어보기
		InventoryM.inputJe();
	}



	// 재고 입력을 물어보는 메소드
	public static void inputJe() throws IOException
	{
		MainOffice mo = new MainOffice();
		InvPage invent = new InvPage();
		char n;

		Scanner sc = new Scanner(System.in);

		System.out.print("재료를 발주하시겠습니까? (Y/N)");
		n = (char)System.in.read();
		System.out.println();

		if (n == 'y' || n == 'Y')
		{
			// 재고입력 클래스.메소드 호출
			mo.selectOffice();
		}
		else 
			invent.stockManage();
	}
}





public class Ingredients 
{
	public static void main(String[] args) throws IOException
	{
	


		

	}
}
