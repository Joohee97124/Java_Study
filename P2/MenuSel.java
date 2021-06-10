import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

// ○ 사용자에게 출력되는 메뉴 클래스

class MenuSel
{
	//IlzoS2 il = new IlzoS2();
	MenuAdmin ma = new MenuAdmin();
	Recipe rc = new Recipe();

	int iBase, iCak;	// 사용자가 입력한 베이스 종류 저장하는 변수, 사용자가 입력한 칵테일 번호 저장하는 변수			
	int cusYN;			// 커스텀 여부에 대한 답변 담는 변수 → 전체 메뉴 출력에서 if문 쓸 때 사용하기 위해
	String side;		// 주문된 사이드 메뉴 이름 담는 변수 
	int n;				// 사이드 메뉴 수량 담는 변수
	int sideYN;
	int allYN;
	int count =0;
	int ok=0;
	int a;				// 사용자가 입력한 사이드 메뉴 번호 담는 변수
	int bQ; // 베이스의 양
	int iQ; // 재료 양
	int sPrice;



	ArrayList<String> vTemp1 = new ArrayList<String>();	//-- 임시로 사용할 vTemp
	ArrayList<Integer> vTemp2 = new ArrayList<Integer>();	
	String[] basis = {"데킬라", "럼", "브랜디", "보드카", "진"};	//-- 인덱스로 문자열과 대응시킬 배열
	ArrayList<Recipe> vTemp3 = new ArrayList<Recipe>();	
	
	//-- 커스텀 레시피를 저장하는 ArrayList 타입의 vCust

	ArrayList<String> vCust1 = new ArrayList<String>();
	ArrayList<Integer> vCust2 = new ArrayList<Integer>();
	ArrayList<Recipe> vCust3 = new ArrayList<Recipe>();

	MenuSel() throws IOException
	{
		ma.setting();
		ma.settingSide();
		baseSel();
		
	}
	
	// 칵테일 종류 선택 메소드

	void baseSel() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--------------[베이스 선택]--------------");
		System.out.println("1. 데킬라 2. 럼 3. 브랜디 4. 보드카 5. 진");
		System.out.println("-----------------------------------------");

		System.out.print("번호를 입력해 주세요 : ");
		iBase = sc.nextInt()-1;						// → 베이스 이름(int)이 0부터 구성되기 때문에 편의상 -1

		menuPrint(iBase);							// → 베이스 이름(int)을 매개변수로 받아 메뉴 출력 페이지로 넘어감
	}
	

	// 입력받은 베이스에 관련된 칵테일 메뉴 출력 메소드

	void menuPrint(int iBase) throws IOException
	{			
		int i=0;	// 0부터 시작할 루프 변수
		int l=1;	// 1부터 시작할 메뉴 번호 
		
		System.out.printf("\n====================[%s 베이스]===================", ma.basis[iBase]);
		System.out.printf("\n해당 베이스가 포함된 메뉴의 기본 가격은 %d 원입니다.\n", ma.price[iBase]);
		System.out.println("베이스 추가시 5ml당 2000원, 주스 및 큐라소 추가시 5ml당 1000원의 금액이 가산됩니다."); 
		System.out.println();

		for (int base : ma.v2)	// ① ma.v2 의 모든 요소(베이스 이름(int))를 출력해라 
		{
			if (base == iBase)	// ② i++ 하며 출력하다가 사용자가 입력한 iBase 와 같은 것이 있다면 
			{	
				System.out.printf("· [%d] %s: %s %dml + %s %dml\n", l, ma.v1.get(i), ma.basis[ma.v2.get(i)], ma.v3.get(i).getBaseQ(),
																						ma.v3.get(i).getIng(), ma.v3.get(i).getIngQ()); // ③ 해당 메뉴를 출력해라
				l++;

				// → 이렇게 출력되는 공통 베이스 집단은 그 집단 내에서 또 번호를 구분하여 활용해야 하기 때문에	
				// ④ 베이스가 같은 메뉴를 저장하는 임시 객체인 vTemp 에 담음 
				vTemp1.add(ma.v1.get(i));
				vTemp2.add(ma.v2.get(i));
				vTemp3.add(new Recipe(ma.v3.get(i).getBaseQ(), ma.v3.get(i).getIng(), ma.v3.get(i).getIngQ()));
			}

			i++;
		}

		System.out.println("======================================================");

		cakSelect();
	}
	

	// 베이스 내 칵테일 선택 메소드

	void cakSelect() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("칵테일 선택 : ");
		iCak = sc.nextInt();

		cakCustom(iCak);
	}


	// 커스텀 메소드 

	void cakCustom(int iCak) throws IOException
	{
		Scanner sc = new Scanner(System.in);


		//Recipe rc = new Recipe();	→ 계속 메뉴 만들어 오던 방식과 동일하게 rc 인스턴스 만들어서 Vcust 객체에 따로 저장할 것
		

		System.out.print("\n해당 메뉴를 커스텀하시겠습니까? : ");
		cusYN = System.in.read();
		
		// → 전제: 커스텀할 시 베이스의 양과 재료의 양만 수정 가능함
		

		// vCust3 에 저장할 rc 객체 구성

		if (cusYN == 89 || cusYN == 121)	// yes 라면
		{	
			System.out.print("\n베이스량 입력(5ml 단위) : ");

			bQ = sc.nextInt();
			rc.setBaseQ(bQ);
						
			// → 재료 이름은 수정이 불가능하기 때문에 입력받지 않고
			// 공통 베이스를 가지는 메뉴을 임시로 저장한 Temp 객체에서
			// 사용자가 입력한 인덱스를 통해 가져옴

			rc.setIng(vTemp3.get(iCak-1).getIng());				// iCak 으로 입력받은 숫자와 0부터 시작하는 인덱스 값을 대응시키기 위해서 -1
									
			System.out.print("재료량 입력(5ml 단위) : ");
									
			iQ = sc.nextInt();
			rc.setIngQ(iQ);
				
			vCust3.add(rc);
			
			// → 커스텀을 할 때마다 vCust1, 2, 3 에는 요소, 객체가 새롭게 저장됨
			// 때문에 ^커스텀을 진행한 시점에서 입력된 커스텀 메뉴^만 출력하기 위해서는
			// vCust3.add(rc); 구문이 수행된 후의 vCust3.size()-1 인덱스가 필요함 

			for (int k=vCust3.size()-1; k<vCust3.size(); k++)	// 임시 변수 k 에 vCust.size()-1 을 담음
			{
				// → 메뉴 이름, 베이스 이름 도 재료 이름과 마찬가지로 수정이 불가능하기 때문에
				// 공통 베이스를 가지는 메뉴를 임시로 저장한 Temp 객체에서
				// 사용자가 입력한 인덱스를 통해 가져옴

				vCust1.add(vTemp1.get(iCak-1));					// iCak 으로 입력받은 숫자와 0부터 시작하는 인덱스 값을 대응시키기 위해서 -1
				vCust2.add(vTemp2.get(iCak-1));

				System.out.printf("\n-* %s: %s %dml + %s %dml\n", vCust1.get(k), basis[vCust2.get(k)], vCust3.get(k).getBaseQ(),
																			 vCust3.get(k).getIng(), vCust3.get(k).getIngQ());
			}

			System.out.println("\n>> 입력하신 커스텀 레시피가 성공적으로 저장되었습니다!");
			System.out.println(">> 저장된 레시피는 이후 자판기 이용시 불러올 수 있습니다 :D");

			side();		
		}

		else if (cusYN == 78 || cusYN == 110)	// no 라면
		{	
			ok++;
			side();
		}
	}


	// 사이드 메뉴 메소드

	void side() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("\n사이드 메뉴를 추가하시겠습니까? : ");
		System.in.skip(2);	
		sideYN = System.in.read();

		if (sideYN == 89 || sideYN == 121) // yes 라면
		{
			ma.printSide();

			System.out.print("\n추가할 사이드 메뉴의 번호 입력 : ");
			a = sc.nextInt();
			
			switch (a)
			{
				case 1: side = ma.v4.get(a-1);
						sPrice = ma.sidePrice[a-1];
						break;
				case 2: side = ma.v4.get(a-1);
						sPrice = ma.sidePrice[a-1];
						break;
				case 3: side = ma.v4.get(a-1);
						sPrice = ma.sidePrice[a-1];
						break;
			}
			
			do
			{
				System.out.print("주문 수량 입력(최대 10개) : ");
				n = sc.nextInt();
			}
			while (n>10 || n<1);

			allPrint();
		}

		else if (sideYN == 78 || sideYN == 110) // no 라면
			allPrint();
	}
	

	// 주문 내역 출력 메소드

	void allPrint() throws IOException
	{
		System.out.println("\n========<최종 주문 내역을 확인해 주세요>========");
		// ① 메인 메뉴 출력
		
		// 커스텀 가격 연산
		int c = vCust3.get(vCust3.size()-1).getBaseQ();
		int d = vCust3.get(vCust3.size()-1).getIngQ();
		int customTot = ma.price[iBase] + ((bQ - c) * 2000); 

		if (cusYN == 89 || cusYN == 121) // cakCustom() 에서 y 를 입력했다면, 즉 커스텀 메뉴가 !존재한다면!
		{	
			// 커스텀 메뉴를 저장한 객체인 vCust1, 2, 3 을 통해 전과 같은 방식으로 메뉴 출력
			
			for (int k=vCust3.size()-1; k<vCust3.size(); k++)
				//customTot = ma.price[iBase] + ((((bQ-vCust3.get(k).getBaseQ())/5) * 2000) + (((iQ-vCust3.get(k).getIngQ())/5) * 1000));
				System.out.printf("%s: %s %dml + %s %dml", vCust1.get(k), basis[vCust2.get(k)], vCust3.get(k).getBaseQ(), vCust3.get(k).getIng(), vCust3.get(k).getIngQ());
			System.out.print(" " + customTot);
		}
		
		else if (cusYN == 78 || cusYN == 110) // cakCustom() 에서 n 을 입력했다면, 즉 커스텀 메뉴가 !존재하지 않는다면!
		{
			// 공통 베이스를 가진 메뉴를 저장한 객체인 Temp 1, 2, 3 을 통해 전과 같은 방식으로 메뉴 출력

			System.out.printf("%s: %s %dml + %s %dml - %d원", vTemp1.get(iCak-1), basis[vTemp2.get(iCak-1)], vTemp3.get(iCak-1).getBaseQ(), vTemp3.get(iCak-1).getIng(), vTemp3.get(iCak-1).getIngQ(), ma.price[iBase]); // iCak 번호가 1을 입력하면 0번째에 있는 값을 출력하도록 해야 돼서 -1 해 줌
		}
		
		// ② 사이드 메뉴 출력
		
		// 사이드 가격 연산
		int sideTot = n * sPrice;
		
		if (sideYN == 89 || sideYN == 121) // side() 에서 y 를 입력했다면, 즉 사이드 메뉴가 존재한다면
		{
			System.out.printf("\n%s - %d개 %d원", side, n, sideTot);	
		}
		
		System.out.println("\n================================================");
		
		// ③ 총 가격 연산


		// ④ 주문 내역 검증
		
		System.out.print("\n주문 내역이 정확합니까? : ");
		System.in.skip(2);
		allYN = System.in.read();
		System.out.println();
	
		if (allYN == 89 || allYN == 121) // 정확하다면
		{	
			count++;
			if (ok==1)
			{
				count--;
				--ok;
			}
			
			//test();

			/*
			for (int k=0; k<vCust3.size(); k++)
			{
				System.out.printf("· %s: %s %dml + %s %dml\n", vCust1.get(k), basis[vCust2.get(k)],
									vCust3.get(k).getBaseQ(), vCust3.get(k).getIng(), vCust3.get(k).getIngQ());
			}
			*/
		
			vTemp1.clear();
			vTemp2.clear();
			vTemp3.clear();	
		}
		
		if (allYN == 78 || allYN == 110) // 정확하지 않다면
		{
			count++;
				
			if (ok==1)
			{
				count--;
				--ok;
			}
			else
			{
				vCust1.remove(count-1);
				vCust2.remove(count-1);
				vCust3.remove(count-1);
				count--;
			}

			//test();

			vTemp1.clear();
			vTemp2.clear();
			vTemp3.clear();

			baseSel();
		}
	}
	
/*	
	// 커스텀 저장 Test 메소드

	void test() throws IOException
	{
		for (int k=0; k<vCust3.size(); k++)
		{
			System.out.printf("· %s: %s %dml + %s %dml\n", vCust1.get(k), basis[vCust2.get(k)],
								vCust3.get(k).getBaseQ(), vCust3.get(k).getIng(), vCust3.get(k).getIngQ());
		}	

		vTemp1.clear();
		vTemp2.clear();
		vTemp3.clear();

		baseSel();
	}
*/
}

/*
public class MenuSel
{
	public static void main(String[] args) throws IOException
	{
		
	}
}
*/
