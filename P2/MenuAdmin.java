import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class MenuAdmin  
{	
	Management m = new Management();								// 5. 뒤로가기 에서 사용하기 위해 관리자 홈 인스턴스 생성

	// 필드 변수 선언

	static ArrayList<String> v1 = new ArrayList<String>();					// 메뉴 이름을 저장하는 ArrayList 타입의 v1

	static ArrayList<Integer> v2 = new ArrayList<Integer>();				// 베이스 이름(int)를 저장하는 ArrayList 타입의 v2
	String[] basis = {"데킬라", "럼", "브랜디", "보드카", "진"};	// 대응시킬 인덱스에 베이스 이름(String)을 저장하고 있는 배열 basisa
	int[] price = {10000, 15000, 20000, 18000, 10000};				// 대응시킬 인덱스에 가격을 저장하고 있는 배열 price

	static ArrayList<Recipe> v3 = new ArrayList<Recipe>();					// 메뉴 이름, 베이스 이름을 제외한 레시피(베이스량, 재료 이름, 재료량)를
																	// Recipe 객체로 저장하는 ArrayList 타입의 v3

	int[] sidePrice = {3000, 5000, 2000};
	
	// 메뉴 이름을 저장하는 객체를 따로 구성한 이유는
	// 메뉴 이름 대조를 통해 index 값을 찾아
	// 메뉴 수정과 삭제를 용이하게 하기 위함이고

	// 베이스 이름(int)를 저장하는 객체를 따로 구성한 이유는
	// 추후 사용자에게 메뉴를 출력할 때
	// 베이스 이름 대조를 통해 
	// 해당하는 베이스와 관련된 메뉴만을 출력하는 것을 용이하게 하기 위함임

	// 더 쉬운 방법이 있었을 것 같기도 함 ^^;

	static ArrayList<String> v4 = new ArrayList<String>();					// 사이드 메뉴의 이름을 저장하는 ArrayList 타입의 v4
	
	private int menu;



	// 메뉴관리 Home 메소드
	
	public void home() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println("\t       1. 메뉴 출력");
		System.out.println("\t       2. 메인 메뉴 추가");
		System.out.println("\t       3. 메인 메뉴 삭제");
		System.out.println("\t       4. 메인 메뉴 수정");
		System.out.println("\t       5. 뒤로 가기");

		System.out.print("\n\t       >> 메뉴 선택(1~4) : ");
		menu = sc.nextInt();

		System.out.println();

		switch (menu)
		{
			case 1 : print(); break;
			case 2 : input(); break;			
			case 3 : delete(); break;			
			case 4 : change(); break;
			case 5 : back(); break;
		}
	}


	// 기본 메뉴 + 레시피 설정 메소드

	static void setting() 
	{
		// v1 → 메뉴 이름
		v1.add("마가리타");
		v1.add("선 번");
		v1.add("데킬라 사워");
		v1.add("피나 콜라다");
		v1.add("블루 하와이");
		v1.add("발렌시아");
		v1.add("허니문");
		v1.add("블루 스카이");
		v1.add("코스모폴리탄");
		v1.add("클로버 클럽");
		v1.add("진 라임");
		
		// v2 → 베이스 이름(int)
		v2.add(0);
	    v2.add(0);
		v2.add(0);
		v2.add(1);
		v2.add(1);
		v2.add(2);
		v2.add(2);
		v2.add(3);
		v2.add(3);
		v2.add(4);
		v2.add(4);

		// v3 → 베이스량, 재료 이름, 재료량
		v3.add(new Recipe(30, "라임주스", 15));
		v3.add(new Recipe(35, "크랜베리주스", 90));
		v3.add(new Recipe(60, "레몬주스", 15));
		v3.add(new Recipe(30, "파인애플주스", 90));
		v3.add(new Recipe(30, "라임주스", 30));
		v3.add(new Recipe(40, "파인애플주스", 20));
		v3.add(new Recipe(25, "레몬주스", 30));
		v3.add(new Recipe(10, "블루 큐라소", 10));
		v3.add(new Recipe(30, "라임주스", 15));
		v3.add(new Recipe(60, "레몬주스", 15));
		v3.add(new Recipe(45, "라임주스", 15));
	}


	// 사이드 메뉴 설정 메소드

	static void settingSide()
	{
		v4.add("크래커");
		v4.add("치즈");
		v4.add("아몬드");
	}
	

	// 메뉴 전체 출력 메소드

	void print() throws IOException
	{
		System.out.println("==================[메인 메뉴]==================");
		// System.out.println(v1.size);

		for (int i=0; i<v1.size(); i++)
		{
			System.out.printf("· [%d] %s: %s %dml + %s %dml\n", i+1, v1.get(i), basis[v2.get(i)], v3.get(i).getBaseQ(),
																				v3.get(i).getIng(), v3.get(i).getIngQ());
			// → get() 을 통해 각 객체의 i번째에 있는 요소를 가져옴
			//	  v1, v2, v3 객체의 i번째 요소를 다같이 불러왔을 때 한 메뉴의 레시피를 구성하는 것이 가능하다
			//    ex. v1.get(1),  basis[v2.get(1)],  v3.get(1).getBaseQ(), v3.get(1).getIng(), v3.get(1).getIngQ()
			//		  ---------   ----------------   -------------------  ------------------  -------------------
			//		 "마가리타"  basis[0] = "데킬라"         30               "라임주스"              15																				
		}

		System.out.println("===============================================");

		home();
	}
	

	// 단일 메뉴 출력 메소드

	public void basic(String MenuName)
	{
		int i = v1.indexOf(MenuName);
		System.out.printf("%s 기본 레시피 : %s %dml + %s %dml\n", v1.get(i), basis[v2.get(i)], v3.get(i).getBaseQ(),
																			v3.get(i).getIng(), v3.get(i).getIngQ());
	}


	// 사이드 메뉴 전체 출력 메소드

	public void printSide()
	{

		System.out.println("\n=================[사이드 메뉴]=================");

		for (int i=0; i<v4.size(); i++)
		{
			System.out.printf("· [%d] %s %d원\n", i+1, v4.get(i), sidePrice[i]);
		}

		System.out.println("===============================================");
	}


	// 메뉴 추가 메소드

	void input() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		Recipe rc = new Recipe(); // 메뉴관리 속성 클래스인 Recipe 의 인스턴스 생성

		String iName; // 추가할 메뉴 이름 입력받을 변수
		int iBase;	  // 추가할 베이스 번호 입력받을 변수
		int a;		  // 추가할 재료 번호 입력받을 변수
					  // → 베이스양과 재료량은 따로 변수 설정하지 않고 setter 에 바로 넣음

		System.out.print("추가할 메뉴의 이름 : ");
		iName = sc.next();
		rc.setMenuName(iName);

		System.out.println("1. 데킬라 2. 럼 3. 브랜디 4. 보드카 5. 진");
		System.out.print("해당 메뉴에 들어갈 베이스 입력 : ");	
		iBase = sc.nextInt()-1;											// → 베이스 이름(int)가 0부터 구성되기 때문에 -1
		rc.setBase(iBase);

		System.out.print("베이스의 양(ml) 입력 : ");
		rc.setBaseQ(sc.nextInt());

		System.out.println("1. 라임주스 2. 레몬주스 3. 크랜베리주스 4. 파인애플주스 5.블루큐라소");
		System.out.print("해당 메뉴에 들어갈 재료 입력 : ");
		a = sc.nextInt();

		switch (a)
		{
			case 1: rc.setIng("라임주스"); break;
			case 2: rc.setIng("레몬주스"); break;
			case 3: rc.setIng("크랜베리주스"); break; 
			case 4: rc.setIng("파인애플주스"); break;
			case 5: rc.setIng("블루큐라소"); break;
		}
			
		System.out.print("재료의 양(ml) 입력 : ");
		rc.setIngQ(sc.nextInt());
		
		// 각 객체에 추가함으로써 하나의 추가 메뉴 구성 완료

		v1.add(iName);
		v2.add(iBase);
		v3.add(rc);

		home();
	}


	// 메뉴 삭제 메소드

	void delete() throws IOException
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String dName;	// 삭제할 메뉴 이름 입력받을 변수

		System.out.print("삭제할 메뉴 입력 : ");
		dName = br.readLine(); 

		System.out.println("[삭제 결과 출력]");

		if(v1.indexOf(dName)<0)
		{
			System.out.println("항목이 존재하지 않아 삭제할 수 없습니다.");			
		}
		else
		{	
			v2.remove(v1.indexOf(dName));		// → 메뉴 이름을 저장하고 있는 v1 에서 dName 이 포함된 인덱스를 찾아
			v3.remove(v1.indexOf(dName));		//    그 인덱스에 해당하는 v2, v3 를 삭제하고
			v1.remove(dName);					//    v1 역시 삭제함으로써 한 메뉴를 구성하는 모든 요소를 삭제
			
			System.out.println("삭제가 완료되었습니다.");
		}
		System.out.println();

		home();
	}


	// 메뉴 수정 메소드

	void change() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String cName;		// 수정할 메뉴 이름 입력받을 변수
		int i;				// 수정할 메뉴 이름이 속한 v1의 인덱스 값을 저장할 변수 
		int a=0, l;			// 변경할 재료 번호 입력받을 변수, 변경할 용량 입력받을 변수

		System.out.print("변경할 메뉴명 입력 : ");
		cName = br.readLine();
		
		if (v1.contains(cName))	// v1 이 cName 을 요소로 가지고 있다면
		{
			i = v1.indexOf(cName);
			
			System.out.println("1. 베이스 2. 재료");
			System.out.println("변경할 재료 입력 : ");
			a = Integer.parseInt(br.readLine());

			switch (a)
			{
				case 1: System.out.print("변경할 용량을 입력해 주세요. : ");
						l = Integer.parseInt(br.readLine());
						v3.get(i).setBaseQ(l);
						break;
				case 2: System.out.print("변경할 용량을 입력해 주세요. : ");
						l = Integer.parseInt(br.readLine());
						v3.get(i).setIngQ(l);
						break;
			}
		}
	
		else	// v1 이 cName 을 요소로 가지고 있지 않다면
			System.out.println("입력하신 품목이 존재하지 않습니다.");

		System.out.println();

		home();
	}
	

	// 뒤로가기 메소드
	public void back() throws IOException
	{
		m.managerMenu();
	}	
}