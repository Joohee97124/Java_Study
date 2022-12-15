import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

// ○ 사용자에게 출력되는 메뉴 클래스

class MenuUser extends MenuAdmin
{	
	int iBase, iCak;						// 사용자가 입력한 베이스 번호, 사용자가 입력한 칵테일 번호 → 클래스 내 메소드 전반에서 사용해 필드 변수로 선언			
	int cusYN, sideYN, allYN;				// 커스텀 주문 여부, 사이드 주문 여부, 최종 주문 체크에 대한 답변
	String userId;	
	String sideName;						// 사용자가 주문한 사이드 메뉴 이름 
	int sideN;								// 사용자가 입력한 사이드 메뉴 수량
	int a;									// 사용자가 입력한 사이드 메뉴 번호
	int bQ, iQ;								// 베이스량, 재료량
	int sPrice;								// 사이드메뉴 가격	
	int mainTot, sideTot, finalTot;			// 메인메뉴 가격 합계, 사이드메뉴 가격 합계, 총 가격 합계

	int[][] check = new int[5][4];			// 품절 메뉴 선택 시 
 
	// 베이스별 메뉴를 저장하는 ArrayList 타입의 vTemp
	ArrayList<String> vTemp1 = new ArrayList<String>();
	ArrayList<Integer> vTemp2 = new ArrayList<Integer>();		
	ArrayList<Recipe> vTemp3 = new ArrayList<Recipe>();	

	// 사용자 정의 생성자

	MenuUser() throws IOException
	{
		// setting();
		// settingSide();		
	}
	
	// 칵테일 종류 선택 메소드

	void baseSel() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			try
			{
				do
				{
					System.out.println("\n\t--------------[베이스 선택]--------------");
					System.out.println("\t1. 데킬라 2. 럼 3. 브랜디 4. 보드카 5. 진");
					System.out.println("\t-----------------------------------------");

					System.out.print("\t번호를 입력해 주세요 : ");
					iBase = sc.nextInt()-1;						// → 베이스 이름(int)이 0부터 구성되기 때문에 편의상 -1


					menuPrint(iBase);							// → 베이스 이름(int)을 매개변수로 받아 메뉴 출력 페이지로 넘어감
				}
				while (iBase<0 || iBase>5);
				return;
			}
			catch (ArrayIndexOutOfBoundsException e)
				{
					System.out.println("\t1~5 사이의 번호를 골라주세요");
				}
		}
			
	}
	

	// 입력받은 베이스에 관련된 칵테일 메뉴 출력 메소드

	void menuPrint(int iBase) throws IOException
	{	
		Lime newLime = new Lime();
		Lemon newLemon = new Lemon();
		Cranberry newCranberry = new Cranberry();
		Pineapple newPineapple = new Pineapple();
		BlueCu newBlueCu = new BlueCu();
		Tequila newTequila = new Tequila();
		Rum newRum = new Rum();
		Brandy newBrandy = new Brandy();
		Vodka newVodka = new Vodka();
		Jin newJin = new Jin();

		int i=0;	// 0부터 시작할 루프 변수
		int l=1;	// 1부터 시작할 메뉴 번호 
		
		System.out.printf("\n\t====================================[%s 베이스]===================================", basis[iBase]);
		System.out.printf("\n\t해당 베이스가 포함된 메뉴의 기본 가격은 %d 원입니다.\n", price[iBase]);
		System.out.println("\t베이스 추가시 5ml당 2000원, 주스 및 큐라소 추가시 5ml당 1000원의 금액이 가산됩니다."); 
		System.out.println();

		for (int base : v2)	// ① v2 의 모든 요소(베이스 이름(int))를 출력해라 
		{
			if (base == iBase)	// ② i++ 하며 출력하다가 사용자가 입력한 iBase 와 같은 것이 있다면 
			{	
				System.out.printf("\t· [%d] %s: %s %dml + %s %dml\n", l, v1.get(i), basis[v2.get(i)], v3.get(i).getBaseQ(),
																						v3.get(i).getIng(), v3.get(i).getIngQ()); // ③ 해당 메뉴를 출력해라
				l++;
				
				if (basis[v2.get(i)].equals("데킬라"))
					{	
						if (v3.get(i).getIng().equals("라임주스"))
						{
							check[0][0] = 0;
							if (newTequila.getNowQty() < 150 || newLime.getNowQty() < 150)
							{
								System.out.println("\t품절입니다. 다른 메뉴를 선택 해 주세요..");
								check[0][0] = 1;
							}
						}

						if (v3.get(i).getIng().equals("크랜베리주스"))
						{
							check[0][1] = 0;
							if (newTequila.getNowQty() < 150 || newCranberry.getNowQty() < 150)
							{
								System.out.println("\t품절입니다. 다른 메뉴를 선택 해 주세요..");
								check[0][1] = 1;
							}
						}

						if (v3.get(i).getIng().equals("레몬주스"))
						{
							check[0][2] = 0;
							if (newTequila.getNowQty() < 150 || newLemon.getNowQty() < 150)
							{
								System.out.println("\t품절입니다. 다른 메뉴를 선택 해 주세요..");
								check[0][2] = 1;
							}
						}
					}



				if (basis[v2.get(i)].equals("럼"))
					{	
						if (v3.get(i).getIng().equals("\t파인애플주스"))
						{
							check[1][0] = 0;
							if (newRum.getNowQty() < 150 || newPineapple.getNowQty() <150)
							{
								System.out.println("\t품절입니다. 다른 메뉴를 선택 해 주세요..");
								check[1][0] = 1;
							}
						}

						if (v3.get(i).getIng().equals("라임주스"))
						{
							check[1][1] = 0;
							if (newRum.getNowQty() < 150 || newLime.getNowQty() < 150)
							{
								System.out.println("\t품절입니다. 다른 메뉴를 선택 해 주세요..");
								check[1][1] = 1;
							}
						}
					}

				if (basis[v2.get(i)].equals("브랜디"))
					{				
						if (v3.get(i).getIng().equals("\t파인애플주스"))
						{
							check[2][0] = 0;
							if (newBrandy.getNowQty() < 150 || newPineapple.getNowQty() <150)
							{
								System.out.println("\t품절입니다. 다른 메뉴를 선택 해 주세요..");
								check[2][0] = 1;
							}
						}

						if (v3.get(i).getIng().equals("레몬주스"))
						{
							check[2][1] = 0;
							if (newBrandy.getNowQty() < 150 || newLemon.getNowQty() < 150)
							{
								System.out.println("\t품절입니다. 다른 메뉴를 선택 해 주세요..");
								check[2][1] = 1;
							}
						}
					}

				if (basis[v2.get(i)].equals("보드카"))
					{	
						if (v3.get(i).getIng().equals("블루 큐라소"))
						{
							check[3][0] = 0;
							if (newVodka.getNowQty() < 150 || newBlueCu.getNowQty() < 150)
							{
								System.out.println("\t품절입니다. 다른 메뉴를 선택 해 주세요..");
								check[3][0] = 1;
							}
						}

						if (v3.get(i).getIng().equals("라임주스"))
						{
							check[3][1] = 0;
							if (newVodka.getNowQty() < 150 || newLime.getNowQty() < 150)
							{
								System.out.println("\t품절입니다. 다른 메뉴를 선택 해 주세요..");
								check[3][1] = 1;
							}
						}
					}
					
				if (basis[v2.get(i)].equals("진"))
					{
						if (v3.get(i).getIng().equals("레몬주스"))
						{
							check[4][0] = 0;
							if (newJin.getNowQty() < 150 || newLemon.getNowQty() < 150)
							{
								System.out.println("\t품절입니다. 다른 메뉴를 선택 해 주세요..");
								check[4][0] = 1;
							}
						}

						if (v3.get(i).getIng().equals("라임주스"))
						{
							check[4][1] = 0;
							if (newJin.getNowQty() < 150 || newLime.getNowQty() < 150)
							{
								System.out.println("\t품절입니다. 다른 메뉴를 선택 해 주세요..");
								check[4][1] = 1;
							}
						}
					}
					
				// → 이렇게 출력되는 공통 베이스 집단은 그 집단 내에서 또 번호를 구분하여 활용해야 하기 때문에	
				// ④ 베이스가 같은 메뉴를 저장하는 임시 객체인 vTemp 에 담음 

				vTemp1.add(v1.get(i));
				vTemp2.add(v2.get(i));
				vTemp3.add(new Recipe(v3.get(i).getBaseQ(), v3.get(i).getIng(), v3.get(i).getIngQ()));
			}
			i++;
		}

		System.out.println("\t======================================================================================");

		cakSelect();
	}
	

	// 베이스 내 칵테일 선택 메소드

	void cakSelect() throws IOException
	{
		boolean checker = false;

		// 모두 품절되었을 경우 다시 베이스 선택 화면으로 돌아가야 함

		System.out.print("\t칵테일 선택(0을 입력하실 경우, 베이스 선택 화면으로 돌아갑니다) : ");
		iCak = sc.nextInt();
		
		while(true)
		{
			try
			{
				do
				{						
					for (int i=0; i<=iBase; i++)
					{	
						if (iCak==0)
						{
							// ① 사용자가 선택한 베이스별 칵테일을 저장하는 vTemp 를 clear 하고
							vTemp1.clear();
							vTemp2.clear();
							vTemp3.clear();
							
							// ② baseSel 로 돌아가며
							baseSel();
							
							// ③ 뒤의 내용을 실행하지 않고 return 이 포함된 cakSelect() 메소드를 종료함  
							return;
						}

						// 품절이면 실행	
						if (check[iBase][iCak-1]==1)
						{
							System.out.println("\t품절입니다. 다른 메뉴를 선택 해 주세요..");
							System.out.print("\t칵테일 선택(0을 입력하실 경우, 베이스 선택 화면으로 돌아갑니다) : ");
							iCak = sc.nextInt();
							checker = true;
						}

						// 아니면 나가!
						else if (check[i][iCak-1]!=1)
						{
							checker = false;
						}
						cakCustom(iCak);
					}		
				}
				while (checker);
				return;

			}
			catch (ArrayIndexOutOfBoundsException e)
				{
					System.out.println("\t메뉴의 번호를 골라주세요");
				}
		}
	
		


		//cakCustom(iCak);
	}

	// 커스텀 메소드 

	void cakCustom(int iCak) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.print("\n\t해당 메뉴를 커스텀하시겠습니까? (Y/N) : ");
			cusYN = System.in.read();
			System.in.skip(2);
		}
		while (cusYN != 89 && cusYN != 121 && cusYN != 78 && cusYN != 110);
				
		// → 전제: 커스텀할 시 베이스의 양과 재료의 양만 수정 가능함

		if (cusYN == 89 || cusYN == 121) // 커스텀 할 거라면
		{	
			if (findById(userId).getCustomBase() >-1) // 기존 커스텀 내용이 있다면
			{
				System.out.println("\n\t이전에 주문하신 커스텀 베이스 & 주스/큐라소 용량정보가 다음과 같이 존재합니다.");
				System.out.println("\t저장된 " + findById(userId).getName() + " 님의 레시피 : 베이스 " +
					findById(userId).getCustomBase() + "ml & 주스/큐라소 " + findById(userId).getCustomJuice()+ "ml ");
				System.out.print("\n\t커스텀 용량을 가져오시겠습니까? (Y/N) : ");
				char a = (char)System.in.read();

				if (a == 'Y'|| a == 'y') // 기존 커스텀 내용을 가져오겠다면
				{
					bQ = findById(userId).getCustomBase();
					iQ = findById(userId).getCustomJuice();

					System.out.println("\n\t>>저장된 " + findById(userId).getName() + " 님의 레시피로 주문이 완료 되었습니다! ");
				}

				else if (a == 'N' || a == 'n') // 기존 커스텀 내용을 안 가져오겠다면 
				{
					System.out.println("\n\t칵테일 커스텀은 베이스와 주스/큐라소를 합쳐 150ml 기준으로 진행됩니다.");
					System.out.println("\t베이스량을 입력해 주시면, 150ml 에서 입력한 베이스량을 차감한 만큼 자동으로 주스량이 설정됩니다!");
					
					do
					{
						System.out.print("\n\t베이스량 입력(5ml 단위, 최대 150ml) : ");
						bQ = sc.nextInt();
					}
					while (bQ <= 0 || bQ > 150);
					
					System.out.println("\n\t>> 입력하신 커스텀 레시피가 성공적으로 저장되었습니다!");
					System.out.println("\t>> 저장된 레시피는 이후 자판기 이용시 불러올 수 있습니다 :D");
					findById(userId).setCustomBase(bQ);

					iQ = 150 - bQ;
					findById(userId).setCustomJuice(iQ);

					System.out.println("\n\t>> 새로 저장된 " + findById(userId).getName() + " 님의 레시피 : 베이스 " +
					findById(userId).getCustomBase() + "ml & 주스/큐라소 " + findById(userId).getCustomJuice()+ "ml ");
				}
			}

			else // 기존 커스텀 내용이 없다면
			{
				System.out.println("\n\t칵테일 커스텀은 베이스와 주스/큐라소를 합쳐 150ml 기준으로 진행됩니다.");
				System.out.println("\t베이스량을 입력해 주시면, 150ml 에서 입력한 베이스량을 차감한 만큼 자동으로 주스량이 설정됩니다!");
				
				do
				{
					System.out.print("\n\t베이스량 입력(5ml 단위, 최대 150ml) : ");
					bQ = sc.nextInt();
				}
				while (bQ <= 0 || bQ > 150);
				
				System.out.println("\n\t>> 입력하신 커스텀 레시피가 성공적으로 저장되었습니다!");
				System.out.println("\t>> 저장된 레시피는 이후 자판기 이용시 불러올 수 있습니다 :D");
				findById(userId).setCustomBase(bQ);

				iQ = 150 - bQ;
				findById(userId).setCustomJuice(iQ);

				System.out.println("\n\t>> 새로 저장된 " + findById(userId).getName() + " 님의 레시피 : 베이스 " +
				findById(userId).getCustomBase() + "ml & 주스/큐라소 " + findById(userId).getCustomJuice()+ "ml ");
			}

			side();	
		}	

		else if (cusYN == 78 || cusYN == 110)	// 커스텀 안 하겠다면

		side();
	}


	// 사이드 메뉴 메소드

	void side() throws IOException
	{
		Cracker newCracker = new Cracker();
		Cheese newCheese = new Cheese();
		Almond newAlmond = new Almond();		
		boolean checker = false;

		Scanner sc = new Scanner(System.in);

		System.out.print("\n\t사이드 메뉴를 추가하시겠습니까? (Y/N) : ");
		System.in.skip(2);	
		sideYN = System.in.read();

		if (sideYN == 89 || sideYN == 121) // yes 라면
		{
			printSide();

			System.out.print("\n\t추가할 사이드 메뉴의 번호 입력 : ");
			a = sc.nextInt();

			do
			{
				if(newCracker.getNowQty() < 1 && a==1 )
				{
					System.out.println("\t\t품절입니다. 다른 메뉴를 선택 해 주세요..");
					System.out.print("\n\t추가할 사이드 메뉴의 번호 입력 : ");
					a = sc.nextInt();
					checker = true;
				}

				else if(newCheese.getNowQty() < 1 && a==2 )
				{
					System.out.println("\t\t품절입니다. 다른 메뉴를 선택 해 주세요..");
					System.out.print("\n\t추가할 사이드 메뉴의 번호 입력 : ");
					a = sc.nextInt();
					checker = true;
				}

				else if(newAlmond.getNowQty() < 1 && a==3 )
				{
					System.out.println("\t\t품절입니다. 다른 메뉴를 선택 해 주세요..");
					System.out.print("\n\t추가할 사이드 메뉴의 번호 입력 : ");
					a = sc.nextInt();
					checker = true;
				}

				else
					checker = false;
			}
			while (checker);	
			
			switch (a)
			{
				case 1: sideName = v4.get(a-1);
						sPrice = sidePrice[a-1];
						break;
				case 2: sideName = v4.get(a-1);
						sPrice = sidePrice[a-1];
						break;
				case 3: sideName = v4.get(a-1);
						sPrice = sidePrice[a-1];
						break;
			}

			do
			{
				System.out.print("\t주문 수량 입력(최대 10개) : ");
				sideN = sc.nextInt();
			}
			while (sideN>10 || sideN<1);

			allPrint();
		}

		else if (sideYN == 78 || sideYN == 110) // no 라면
			allPrint();
	}
	

	// 주문 내역 출력 메소드

	void allPrint() throws IOException
	{
		System.out.println("\n\t==========<최종 주문 내역을 확인해 주세요>==========");

		// ① 메인 메뉴 출력
		
		// 커스텀 가격 연산
		mainTot= price[iBase] + ((bQ - vTemp3.get(iCak-1).getBaseQ())/5 * 2000) + ((iQ - vTemp3.get(iCak-1).getIngQ())/5 * 1000);
		
		if (cusYN == 89 || cusYN == 121) // cakCustom() 에서 y 를 입력했다면, 즉 커스텀 메뉴가 존재할 때
		{	
			if (bQ - vTemp3.get(iCak-1).getBaseQ() < 0)		// 입력된 베이스량이 기존 베이스량보다 작다면
			{
				mainTot -= (bQ - vTemp3.get(iCak-1).getBaseQ())/5 * 2000;	// 가격이 감산될 테니 베이스량 연산을 제거함
			}

			if (iQ - vTemp3.get(iCak-1).getIngQ() <0)		// 입력된 재료량이 기존 재료량보다 적다면
			{
				mainTot -= (iQ - vTemp3.get(iCak-1).getIngQ())/5 * 1000;	// 가격이 감산될 테니 재료량 연산을 제거함
			}

			System.out.printf("\t%s: %s %dml + %s %dml → %d 원", vTemp1.get(iCak-1), basis[vTemp2.get(iCak-1)], bQ, vTemp3.get(iCak-1).getIng(), iQ, mainTot);
		}
		
		else if (cusYN == 78 || cusYN == 110) // cakCustom() 에서 n 을 입력했다면, 즉 커스텀 메뉴가 존재하지 않을 때
		{
			mainTot = price[iBase];
			
			// vTemp 1, 2, 3 을 통해 메뉴 출력
			System.out.printf("\t%s: %s %dml + %s %dml → %d 원", vTemp1.get(iCak-1), basis[vTemp2.get(iCak-1)], vTemp3.get(iCak-1).getBaseQ(),
																vTemp3.get(iCak-1).getIng(), vTemp3.get(iCak-1).getIngQ(), mainTot);
		}
		
		// ② 사이드 메뉴 출력
		
		// 사이드 가격 연산
		sideTot = sideN * sPrice;
		
		if (sideYN == 89 || sideYN == 121) // side() 에서 y 를 입력했다면, 즉 사이드 메뉴가 존재한다면
		{
			System.out.printf("\n\t%s %d개 → %d 원", sideName, sideN, sideTot);	
		}
		else if (sideYN == 78 || sideYN == 110) // n 을 입력했다면, 즉 사이드 메뉴가 존재하지 않는다면 0 으로 초기화
		{
			sideTot = 0;				
		}
		
		
		// ③ 총 가격 연산
		
		finalTot = mainTot + sideTot;
		System.out.println();
		System.out.printf("\n\t총계 : %d 원", finalTot);
		System.out.println("\n\t====================================================");

		// ④ 주문 내역 검증

		System.out.print("\n\t주문 내역이 정확합니까? (Y/N) : ");
		System.in.skip(2);
		allYN = System.in.read();
		System.out.println();
		
		
		// 주문내역이 맞아도 커스텀 한 내용이 없다면. 정보를 저장하지 않음!
		

		if (allYN == 89 || allYN == 121) // 정확하다면
		{	
			// 주문 내역이 맞는 경우, MemberInfo 객체에 해당 정보들 저장
			findById(userId).setMainMenu(vTemp1.get(iCak-1));
			findById(userId).setMainTotal(mainTot);
			findById(userId).setSubMenu(sideName);
			findById(userId).setSubMenuCount(sideN);
			findById(userId).setSubTotal(sideTot);
			findById(userId).setOrderTotal(finalTot);
			
			// 재고 감소
			stackMin1();
			stackMin2();
			
			// 다음 주문 프로세스를 위해 해당 사용자가 선택한 베이스의 칵테일들이 담긴 vTemp 를 clear 함
			vTemp1.clear();
			vTemp2.clear();
			vTemp3.clear();
		}
		
		if (allYN == 78 || allYN == 110) // 정확하지 않다면
		{	
			// 다음 주문 프로세스를 위해 해당 사용자가 선택한 베이스의 칵테일들이 담긴 vTemp 를 clear 함
			vTemp1.clear();
			vTemp2.clear();
			vTemp3.clear();

			baseSel();	
		}
	}


	// 재고 차감 메소드 (기본 레시피)
	public void stackMin1() throws IOException
	{
		/*
		int b = bQ;							// 베이스(술) 양
		int i = iQ;							// 주스 양
		int base = iBase;					// 베이스 인덱스
		int cak = iCak;						// 주스 선택 번호
		*/
		
		if (cusYN == 89 || cusYN == 121)				// 커스텀 할 때 재고 차감
		{	
			if (iBase == 0 )
			{
				int tequila1 = Tequila.getNowQty();
				int tequila2 = tequila1 - bQ;
				Tequila.setNowQty(tequila2);
				
				if (iCak == 1)
				{
					int lime1 = Lime.getNowQty();
					int lime2 = lime1 - iQ;
					Lime.setNowQty(lime2);
				}
				else if (iCak == 2)
				{
					int cranberry1 = Cranberry.getNowQty();
					int cranberry2 = cranberry1 - iQ;
					Cranberry.setNowQty(cranberry2);
				}
				else if (iCak == 3)
				{
					int lemon1 = Lemon.getNowQty();
					int lemon2 = lemon1 - iQ;
					Lemon.setNowQty(lemon2);
				}
			}

			if (iBase == 1)
			{
				int rum1 = Rum.getNowQty();
				int rum2 = rum1 - bQ;
				Rum.setNowQty(rum2);

				if (iCak == 1)
				{
					int pineapple1 = Pineapple.getNowQty();
					int pineapple2 = pineapple1 - iQ;
					Pineapple.setNowQty(pineapple2);
				}
				else if (iCak == 2)
				{
					int lime1 = Lime.getNowQty();
					int lime2 = lime1 - iQ;
					Lime.setNowQty(lime2);
				}
			}

			if (iBase == 2)
			{
				int brandy1 = Brandy.getNowQty();
				int brandy2 = brandy1 - bQ;
				Brandy.setNowQty(brandy2);

				if (iCak == 1)
				{
					int pineapple1 = Pineapple.getNowQty();
					int pineapple2 = pineapple1 - iQ;
					Pineapple.setNowQty(pineapple2);
				}
				else if (iCak == 2)
				{
					int lemon1 = Lemon.getNowQty();
					int lemon2 = lemon1 - iQ;
					Lemon.setNowQty(lemon2);
				}
			}

			if (iBase == 3)
			{
				int vodka1 = Vodka.getNowQty();
				int vodka2 = vodka1 - bQ;
				Vodka.setNowQty(vodka2);


				if (iCak == 1)
				{
					int bluecu1 = BlueCu.getNowQty();
					int bluecu2 = bluecu1 - iQ;
					BlueCu.setNowQty(bluecu2);
				}
				else if (iCak == 2)
				{
					int lime1 = Lime.getNowQty();
					int lime2 = lime1 - iQ;
					Lime.setNowQty(lime2);
				}

			}

			if (iBase == 4)
			{
				int jin1 = Jin.getNowQty();
				int jin2 = jin1 - bQ;
				Jin.setNowQty(jin2);


				if (iCak == 1)
				{
					int lemon1 = Lemon.getNowQty();
					int lemon2 = lemon1 - iQ;
					Lemon.setNowQty(lemon2);
				}
				else if (iCak == 2)
				{
					int lime1 = Lime.getNowQty();
					int lime2 = lime1 - iQ;
					Lime.setNowQty(lime2);
				}
			}		
		}

		else													// 기본 레시피일 때 재고 차감
		{
			
			if (iBase == 0 )
			{
				
				if (iCak == 1)
				{
					int tequila1 = Tequila.getNowQty();
					int tequila2 = tequila1 - 90;
					Tequila.setNowQty(tequila2);

					int lime1 = Lime.getNowQty();
					int lime2 = lime1 - 60;
					Lime.setNowQty(lime2);
				}
				else if (iCak == 2)
				{
					int tequila1 = Tequila.getNowQty();
					int tequila2 = tequila1 - 60;
					Tequila.setNowQty(tequila2);

					int cranberry1 = Cranberry.getNowQty();
					int cranberry2 = cranberry1 - 90;
					Cranberry.setNowQty(cranberry2);
				}
				else if (iCak == 3)
				{
					int tequila1 = Tequila.getNowQty();
					int tequila2 = tequila1 - 100;
					Tequila.setNowQty(tequila2);

					int lemon1 = Lemon.getNowQty();
					int lemon2 = lemon1 - 50;
					Lemon.setNowQty(lemon2);
				}
			}

			if (iBase == 1)
			{
				if (iCak == 1)
				{
					int rum1 = Rum.getNowQty();
					int rum2 = rum1 - 60;
					Rum.setNowQty(rum2);

					int pineapple1 = Pineapple.getNowQty();
					int pineapple2 = pineapple1 - 90;
					Pineapple.setNowQty(pineapple2);
				}
				else if (iCak == 2)
				{
					int rum1 = Rum.getNowQty();
					int rum2 = rum1 - 85;
					Rum.setNowQty(rum2);

					int lime1 = Lime.getNowQty();
					int lime2 = lime1 - 65;
					Lime.setNowQty(lime2);
				}
			}

			if (iBase == 2)
			{
				int brandy1 = Brandy.getNowQty();
				int brandy2 = brandy1 - bQ;
				Brandy.setNowQty(brandy2);

				if (iCak == 1)
				{
					int brandy12 = Brandy.getNowQty();
					int brandy22 = brandy12 - 50;
					Brandy.setNowQty(brandy2);

					int pineapple1 = Pineapple.getNowQty();
					int pineapple2 = pineapple1 - 100;
					Pineapple.setNowQty(pineapple2);
				}
				else if (iCak == 2)
				{
					int brandy12 = Brandy.getNowQty();
					int brandy22 = brandy12 - 75;
					Brandy.setNowQty(brandy22);

					int lemon1 = Lemon.getNowQty();
					int lemon2 = lemon1 - 75;
					Lemon.setNowQty(lemon2);
				}
			}

			if (iBase == 3)
			{
				int vodka12 = Vodka.getNowQty();
				int vodka22 = vodka12 - bQ;
				Vodka.setNowQty(vodka22);


				if (iCak == 1)
				{
					int vodka1 = Vodka.getNowQty();
					int vodka2 = vodka1 - 60;
					Vodka.setNowQty(vodka2);

					int bluecu1 = BlueCu.getNowQty();
					int bluecu2 = bluecu1 - 90;
					BlueCu.setNowQty(bluecu2);
				}
				else if (iCak == 2)
				{
					int vodka1 = Vodka.getNowQty();
					int vodka2 = vodka1 - 70;
					Vodka.setNowQty(vodka2);

					int lime1 = Lime.getNowQty();
					int lime2 = lime1 - 80;
					Lime.setNowQty(lime2);
				}

			}

			if (iBase == 4)
			{
				if (iCak == 1)
				{
					int jin12 = Jin.getNowQty();
					int jin22 = jin12 - 80;
					Jin.setNowQty(jin22);

					int lemon1 = Lemon.getNowQty();
					int lemon2 = lemon1 - 70;
					Lemon.setNowQty(lemon2);
				}
				else if (iCak == 2)
				{
					int jin12 = Jin.getNowQty();
					int jin22 = jin12 - 90;
					Jin.setNowQty(jin22);

					int lime1 = Lime.getNowQty();
					int lime2 = lime1 - 60;
					Lime.setNowQty(lime2);
				}
			}		
		}
	}
	


	// 안주 차감 메소드
	public void stackMin2() throws IOException
	{
		/*
		int am = a;
		int bm = sideN;
		int side = sideYN;
		*/
			
		if (sideYN == 89 || sideYN == 121)
		{
				if (a == 1)
			{
				int cracker1 = Cracker.getNowQty();
				int cracker2 = cracker1 - sideN;
				Cracker.setNowQty(cracker2);
			}
			else if (a == 2)
			{
				int cheese1 = Cheese.getNowQty();
				int cheese2 = cheese1 - sideN;
				Cheese.setNowQty(cheese2);
			}
			else if (a == 3)
			{
				int almond1 = Almond.getNowQty();
				int almond2 = almond1 - sideN;
				Almond.setNowQty(almond2);
			}
		}
	}
}