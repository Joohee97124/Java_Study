import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

// �� ����ڿ��� ��µǴ� �޴� Ŭ����

class MenuUser extends MenuAdmin
{	
	int iBase, iCak;						// ����ڰ� �Է��� ���̽� ��ȣ, ����ڰ� �Է��� Ĭ���� ��ȣ �� Ŭ���� �� �޼ҵ� ���ݿ��� ����� �ʵ� ������ ����			
	int cusYN, sideYN, allYN;				// Ŀ���� �ֹ� ����, ���̵� �ֹ� ����, ���� �ֹ� üũ�� ���� �亯
	String userId;	
	String sideName;						// ����ڰ� �ֹ��� ���̵� �޴� �̸� 
	int sideN;								// ����ڰ� �Է��� ���̵� �޴� ����
	int a;									// ����ڰ� �Է��� ���̵� �޴� ��ȣ
	int bQ, iQ;								// ���̽���, ��ᷮ
	int sPrice;								// ���̵�޴� ����	
	int mainTot, sideTot, finalTot;			// ���θ޴� ���� �հ�, ���̵�޴� ���� �հ�, �� ���� �հ�

	int[][] check = new int[5][4];			// ǰ�� �޴� ���� �� 
 
	// ���̽��� �޴��� �����ϴ� ArrayList Ÿ���� vTemp
	ArrayList<String> vTemp1 = new ArrayList<String>();
	ArrayList<Integer> vTemp2 = new ArrayList<Integer>();		
	ArrayList<Recipe> vTemp3 = new ArrayList<Recipe>();	

	// ����� ���� ������

	MenuUser() throws IOException
	{
		// setting();
		// settingSide();		
	}
	
	// Ĭ���� ���� ���� �޼ҵ�

	void baseSel() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			try
			{
				do
				{
					System.out.println("\n\t--------------[���̽� ����]--------------");
					System.out.println("\t1. ��ų�� 2. �� 3. �귣�� 4. ����ī 5. ��");
					System.out.println("\t-----------------------------------------");

					System.out.print("\t��ȣ�� �Է��� �ּ��� : ");
					iBase = sc.nextInt()-1;						// �� ���̽� �̸�(int)�� 0���� �����Ǳ� ������ ���ǻ� -1


					menuPrint(iBase);							// �� ���̽� �̸�(int)�� �Ű������� �޾� �޴� ��� �������� �Ѿ
				}
				while (iBase<0 || iBase>5);
				return;
			}
			catch (ArrayIndexOutOfBoundsException e)
				{
					System.out.println("\t1~5 ������ ��ȣ�� ����ּ���");
				}
		}
			
	}
	

	// �Է¹��� ���̽��� ���õ� Ĭ���� �޴� ��� �޼ҵ�

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

		int i=0;	// 0���� ������ ���� ����
		int l=1;	// 1���� ������ �޴� ��ȣ 
		
		System.out.printf("\n\t====================================[%s ���̽�]===================================", basis[iBase]);
		System.out.printf("\n\t�ش� ���̽��� ���Ե� �޴��� �⺻ ������ %d ���Դϴ�.\n", price[iBase]);
		System.out.println("\t���̽� �߰��� 5ml�� 2000��, �ֽ� �� ť��� �߰��� 5ml�� 1000���� �ݾ��� ����˴ϴ�."); 
		System.out.println();

		for (int base : v2)	// �� v2 �� ��� ���(���̽� �̸�(int))�� ����ض� 
		{
			if (base == iBase)	// �� i++ �ϸ� ����ϴٰ� ����ڰ� �Է��� iBase �� ���� ���� �ִٸ� 
			{	
				System.out.printf("\t�� [%d] %s: %s %dml + %s %dml\n", l, v1.get(i), basis[v2.get(i)], v3.get(i).getBaseQ(),
																						v3.get(i).getIng(), v3.get(i).getIngQ()); // �� �ش� �޴��� ����ض�
				l++;
				
				if (basis[v2.get(i)].equals("��ų��"))
					{	
						if (v3.get(i).getIng().equals("�����ֽ�"))
						{
							check[0][0] = 0;
							if (newTequila.getNowQty() < 150 || newLime.getNowQty() < 150)
							{
								System.out.println("\tǰ���Դϴ�. �ٸ� �޴��� ���� �� �ּ���..");
								check[0][0] = 1;
							}
						}

						if (v3.get(i).getIng().equals("ũ�������ֽ�"))
						{
							check[0][1] = 0;
							if (newTequila.getNowQty() < 150 || newCranberry.getNowQty() < 150)
							{
								System.out.println("\tǰ���Դϴ�. �ٸ� �޴��� ���� �� �ּ���..");
								check[0][1] = 1;
							}
						}

						if (v3.get(i).getIng().equals("�����ֽ�"))
						{
							check[0][2] = 0;
							if (newTequila.getNowQty() < 150 || newLemon.getNowQty() < 150)
							{
								System.out.println("\tǰ���Դϴ�. �ٸ� �޴��� ���� �� �ּ���..");
								check[0][2] = 1;
							}
						}
					}



				if (basis[v2.get(i)].equals("��"))
					{	
						if (v3.get(i).getIng().equals("\t���ξ����ֽ�"))
						{
							check[1][0] = 0;
							if (newRum.getNowQty() < 150 || newPineapple.getNowQty() <150)
							{
								System.out.println("\tǰ���Դϴ�. �ٸ� �޴��� ���� �� �ּ���..");
								check[1][0] = 1;
							}
						}

						if (v3.get(i).getIng().equals("�����ֽ�"))
						{
							check[1][1] = 0;
							if (newRum.getNowQty() < 150 || newLime.getNowQty() < 150)
							{
								System.out.println("\tǰ���Դϴ�. �ٸ� �޴��� ���� �� �ּ���..");
								check[1][1] = 1;
							}
						}
					}

				if (basis[v2.get(i)].equals("�귣��"))
					{				
						if (v3.get(i).getIng().equals("\t���ξ����ֽ�"))
						{
							check[2][0] = 0;
							if (newBrandy.getNowQty() < 150 || newPineapple.getNowQty() <150)
							{
								System.out.println("\tǰ���Դϴ�. �ٸ� �޴��� ���� �� �ּ���..");
								check[2][0] = 1;
							}
						}

						if (v3.get(i).getIng().equals("�����ֽ�"))
						{
							check[2][1] = 0;
							if (newBrandy.getNowQty() < 150 || newLemon.getNowQty() < 150)
							{
								System.out.println("\tǰ���Դϴ�. �ٸ� �޴��� ���� �� �ּ���..");
								check[2][1] = 1;
							}
						}
					}

				if (basis[v2.get(i)].equals("����ī"))
					{	
						if (v3.get(i).getIng().equals("��� ť���"))
						{
							check[3][0] = 0;
							if (newVodka.getNowQty() < 150 || newBlueCu.getNowQty() < 150)
							{
								System.out.println("\tǰ���Դϴ�. �ٸ� �޴��� ���� �� �ּ���..");
								check[3][0] = 1;
							}
						}

						if (v3.get(i).getIng().equals("�����ֽ�"))
						{
							check[3][1] = 0;
							if (newVodka.getNowQty() < 150 || newLime.getNowQty() < 150)
							{
								System.out.println("\tǰ���Դϴ�. �ٸ� �޴��� ���� �� �ּ���..");
								check[3][1] = 1;
							}
						}
					}
					
				if (basis[v2.get(i)].equals("��"))
					{
						if (v3.get(i).getIng().equals("�����ֽ�"))
						{
							check[4][0] = 0;
							if (newJin.getNowQty() < 150 || newLemon.getNowQty() < 150)
							{
								System.out.println("\tǰ���Դϴ�. �ٸ� �޴��� ���� �� �ּ���..");
								check[4][0] = 1;
							}
						}

						if (v3.get(i).getIng().equals("�����ֽ�"))
						{
							check[4][1] = 0;
							if (newJin.getNowQty() < 150 || newLime.getNowQty() < 150)
							{
								System.out.println("\tǰ���Դϴ�. �ٸ� �޴��� ���� �� �ּ���..");
								check[4][1] = 1;
							}
						}
					}
					
				// �� �̷��� ��µǴ� ���� ���̽� ������ �� ���� ������ �� ��ȣ�� �����Ͽ� Ȱ���ؾ� �ϱ� ������	
				// �� ���̽��� ���� �޴��� �����ϴ� �ӽ� ��ü�� vTemp �� ���� 

				vTemp1.add(v1.get(i));
				vTemp2.add(v2.get(i));
				vTemp3.add(new Recipe(v3.get(i).getBaseQ(), v3.get(i).getIng(), v3.get(i).getIngQ()));
			}
			i++;
		}

		System.out.println("\t======================================================================================");

		cakSelect();
	}
	

	// ���̽� �� Ĭ���� ���� �޼ҵ�

	void cakSelect() throws IOException
	{
		boolean checker = false;

		// ��� ǰ���Ǿ��� ��� �ٽ� ���̽� ���� ȭ������ ���ư��� ��

		System.out.print("\tĬ���� ����(0�� �Է��Ͻ� ���, ���̽� ���� ȭ������ ���ư��ϴ�) : ");
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
							// �� ����ڰ� ������ ���̽��� Ĭ������ �����ϴ� vTemp �� clear �ϰ�
							vTemp1.clear();
							vTemp2.clear();
							vTemp3.clear();
							
							// �� baseSel �� ���ư���
							baseSel();
							
							// �� ���� ������ �������� �ʰ� return �� ���Ե� cakSelect() �޼ҵ带 ������  
							return;
						}

						// ǰ���̸� ����	
						if (check[iBase][iCak-1]==1)
						{
							System.out.println("\tǰ���Դϴ�. �ٸ� �޴��� ���� �� �ּ���..");
							System.out.print("\tĬ���� ����(0�� �Է��Ͻ� ���, ���̽� ���� ȭ������ ���ư��ϴ�) : ");
							iCak = sc.nextInt();
							checker = true;
						}

						// �ƴϸ� ����!
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
					System.out.println("\t�޴��� ��ȣ�� ����ּ���");
				}
		}
	
		


		//cakCustom(iCak);
	}

	// Ŀ���� �޼ҵ� 

	void cakCustom(int iCak) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.print("\n\t�ش� �޴��� Ŀ�����Ͻðڽ��ϱ�? (Y/N) : ");
			cusYN = System.in.read();
			System.in.skip(2);
		}
		while (cusYN != 89 && cusYN != 121 && cusYN != 78 && cusYN != 110);
				
		// �� ����: Ŀ������ �� ���̽��� ��� ����� �縸 ���� ������

		if (cusYN == 89 || cusYN == 121) // Ŀ���� �� �Ŷ��
		{	
			if (findById(userId).getCustomBase() >-1) // ���� Ŀ���� ������ �ִٸ�
			{
				System.out.println("\n\t������ �ֹ��Ͻ� Ŀ���� ���̽� & �ֽ�/ť��� �뷮������ ������ ���� �����մϴ�.");
				System.out.println("\t����� " + findById(userId).getName() + " ���� ������ : ���̽� " +
					findById(userId).getCustomBase() + "ml & �ֽ�/ť��� " + findById(userId).getCustomJuice()+ "ml ");
				System.out.print("\n\tĿ���� �뷮�� �������ðڽ��ϱ�? (Y/N) : ");
				char a = (char)System.in.read();

				if (a == 'Y'|| a == 'y') // ���� Ŀ���� ������ �������ڴٸ�
				{
					bQ = findById(userId).getCustomBase();
					iQ = findById(userId).getCustomJuice();

					System.out.println("\n\t>>����� " + findById(userId).getName() + " ���� �����Ƿ� �ֹ��� �Ϸ� �Ǿ����ϴ�! ");
				}

				else if (a == 'N' || a == 'n') // ���� Ŀ���� ������ �� �������ڴٸ� 
				{
					System.out.println("\n\tĬ���� Ŀ������ ���̽��� �ֽ�/ť��Ҹ� ���� 150ml �������� ����˴ϴ�.");
					System.out.println("\t���̽����� �Է��� �ֽø�, 150ml ���� �Է��� ���̽����� ������ ��ŭ �ڵ����� �ֽ����� �����˴ϴ�!");
					
					do
					{
						System.out.print("\n\t���̽��� �Է�(5ml ����, �ִ� 150ml) : ");
						bQ = sc.nextInt();
					}
					while (bQ <= 0 || bQ > 150);
					
					System.out.println("\n\t>> �Է��Ͻ� Ŀ���� �����ǰ� ���������� ����Ǿ����ϴ�!");
					System.out.println("\t>> ����� �����Ǵ� ���� ���Ǳ� �̿�� �ҷ��� �� �ֽ��ϴ� :D");
					findById(userId).setCustomBase(bQ);

					iQ = 150 - bQ;
					findById(userId).setCustomJuice(iQ);

					System.out.println("\n\t>> ���� ����� " + findById(userId).getName() + " ���� ������ : ���̽� " +
					findById(userId).getCustomBase() + "ml & �ֽ�/ť��� " + findById(userId).getCustomJuice()+ "ml ");
				}
			}

			else // ���� Ŀ���� ������ ���ٸ�
			{
				System.out.println("\n\tĬ���� Ŀ������ ���̽��� �ֽ�/ť��Ҹ� ���� 150ml �������� ����˴ϴ�.");
				System.out.println("\t���̽����� �Է��� �ֽø�, 150ml ���� �Է��� ���̽����� ������ ��ŭ �ڵ����� �ֽ����� �����˴ϴ�!");
				
				do
				{
					System.out.print("\n\t���̽��� �Է�(5ml ����, �ִ� 150ml) : ");
					bQ = sc.nextInt();
				}
				while (bQ <= 0 || bQ > 150);
				
				System.out.println("\n\t>> �Է��Ͻ� Ŀ���� �����ǰ� ���������� ����Ǿ����ϴ�!");
				System.out.println("\t>> ����� �����Ǵ� ���� ���Ǳ� �̿�� �ҷ��� �� �ֽ��ϴ� :D");
				findById(userId).setCustomBase(bQ);

				iQ = 150 - bQ;
				findById(userId).setCustomJuice(iQ);

				System.out.println("\n\t>> ���� ����� " + findById(userId).getName() + " ���� ������ : ���̽� " +
				findById(userId).getCustomBase() + "ml & �ֽ�/ť��� " + findById(userId).getCustomJuice()+ "ml ");
			}

			side();	
		}	

		else if (cusYN == 78 || cusYN == 110)	// Ŀ���� �� �ϰڴٸ�

		side();
	}


	// ���̵� �޴� �޼ҵ�

	void side() throws IOException
	{
		Cracker newCracker = new Cracker();
		Cheese newCheese = new Cheese();
		Almond newAlmond = new Almond();		
		boolean checker = false;

		Scanner sc = new Scanner(System.in);

		System.out.print("\n\t���̵� �޴��� �߰��Ͻðڽ��ϱ�? (Y/N) : ");
		System.in.skip(2);	
		sideYN = System.in.read();

		if (sideYN == 89 || sideYN == 121) // yes ���
		{
			printSide();

			System.out.print("\n\t�߰��� ���̵� �޴��� ��ȣ �Է� : ");
			a = sc.nextInt();

			do
			{
				if(newCracker.getNowQty() < 1 && a==1 )
				{
					System.out.println("\t\tǰ���Դϴ�. �ٸ� �޴��� ���� �� �ּ���..");
					System.out.print("\n\t�߰��� ���̵� �޴��� ��ȣ �Է� : ");
					a = sc.nextInt();
					checker = true;
				}

				else if(newCheese.getNowQty() < 1 && a==2 )
				{
					System.out.println("\t\tǰ���Դϴ�. �ٸ� �޴��� ���� �� �ּ���..");
					System.out.print("\n\t�߰��� ���̵� �޴��� ��ȣ �Է� : ");
					a = sc.nextInt();
					checker = true;
				}

				else if(newAlmond.getNowQty() < 1 && a==3 )
				{
					System.out.println("\t\tǰ���Դϴ�. �ٸ� �޴��� ���� �� �ּ���..");
					System.out.print("\n\t�߰��� ���̵� �޴��� ��ȣ �Է� : ");
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
				System.out.print("\t�ֹ� ���� �Է�(�ִ� 10��) : ");
				sideN = sc.nextInt();
			}
			while (sideN>10 || sideN<1);

			allPrint();
		}

		else if (sideYN == 78 || sideYN == 110) // no ���
			allPrint();
	}
	

	// �ֹ� ���� ��� �޼ҵ�

	void allPrint() throws IOException
	{
		System.out.println("\n\t==========<���� �ֹ� ������ Ȯ���� �ּ���>==========");

		// �� ���� �޴� ���
		
		// Ŀ���� ���� ����
		mainTot= price[iBase] + ((bQ - vTemp3.get(iCak-1).getBaseQ())/5 * 2000) + ((iQ - vTemp3.get(iCak-1).getIngQ())/5 * 1000);
		
		if (cusYN == 89 || cusYN == 121) // cakCustom() ���� y �� �Է��ߴٸ�, �� Ŀ���� �޴��� ������ ��
		{	
			if (bQ - vTemp3.get(iCak-1).getBaseQ() < 0)		// �Էµ� ���̽����� ���� ���̽������� �۴ٸ�
			{
				mainTot -= (bQ - vTemp3.get(iCak-1).getBaseQ())/5 * 2000;	// ������ ����� �״� ���̽��� ������ ������
			}

			if (iQ - vTemp3.get(iCak-1).getIngQ() <0)		// �Էµ� ��ᷮ�� ���� ��ᷮ���� ���ٸ�
			{
				mainTot -= (iQ - vTemp3.get(iCak-1).getIngQ())/5 * 1000;	// ������ ����� �״� ��ᷮ ������ ������
			}

			System.out.printf("\t%s: %s %dml + %s %dml �� %d ��", vTemp1.get(iCak-1), basis[vTemp2.get(iCak-1)], bQ, vTemp3.get(iCak-1).getIng(), iQ, mainTot);
		}
		
		else if (cusYN == 78 || cusYN == 110) // cakCustom() ���� n �� �Է��ߴٸ�, �� Ŀ���� �޴��� �������� ���� ��
		{
			mainTot = price[iBase];
			
			// vTemp 1, 2, 3 �� ���� �޴� ���
			System.out.printf("\t%s: %s %dml + %s %dml �� %d ��", vTemp1.get(iCak-1), basis[vTemp2.get(iCak-1)], vTemp3.get(iCak-1).getBaseQ(),
																vTemp3.get(iCak-1).getIng(), vTemp3.get(iCak-1).getIngQ(), mainTot);
		}
		
		// �� ���̵� �޴� ���
		
		// ���̵� ���� ����
		sideTot = sideN * sPrice;
		
		if (sideYN == 89 || sideYN == 121) // side() ���� y �� �Է��ߴٸ�, �� ���̵� �޴��� �����Ѵٸ�
		{
			System.out.printf("\n\t%s %d�� �� %d ��", sideName, sideN, sideTot);	
		}
		else if (sideYN == 78 || sideYN == 110) // n �� �Է��ߴٸ�, �� ���̵� �޴��� �������� �ʴ´ٸ� 0 ���� �ʱ�ȭ
		{
			sideTot = 0;				
		}
		
		
		// �� �� ���� ����
		
		finalTot = mainTot + sideTot;
		System.out.println();
		System.out.printf("\n\t�Ѱ� : %d ��", finalTot);
		System.out.println("\n\t====================================================");

		// �� �ֹ� ���� ����

		System.out.print("\n\t�ֹ� ������ ��Ȯ�մϱ�? (Y/N) : ");
		System.in.skip(2);
		allYN = System.in.read();
		System.out.println();
		
		
		// �ֹ������� �¾Ƶ� Ŀ���� �� ������ ���ٸ�. ������ �������� ����!
		

		if (allYN == 89 || allYN == 121) // ��Ȯ�ϴٸ�
		{	
			// �ֹ� ������ �´� ���, MemberInfo ��ü�� �ش� ������ ����
			findById(userId).setMainMenu(vTemp1.get(iCak-1));
			findById(userId).setMainTotal(mainTot);
			findById(userId).setSubMenu(sideName);
			findById(userId).setSubMenuCount(sideN);
			findById(userId).setSubTotal(sideTot);
			findById(userId).setOrderTotal(finalTot);
			
			// ��� ����
			stackMin1();
			stackMin2();
			
			// ���� �ֹ� ���μ����� ���� �ش� ����ڰ� ������ ���̽��� Ĭ���ϵ��� ��� vTemp �� clear ��
			vTemp1.clear();
			vTemp2.clear();
			vTemp3.clear();
		}
		
		if (allYN == 78 || allYN == 110) // ��Ȯ���� �ʴٸ�
		{	
			// ���� �ֹ� ���μ����� ���� �ش� ����ڰ� ������ ���̽��� Ĭ���ϵ��� ��� vTemp �� clear ��
			vTemp1.clear();
			vTemp2.clear();
			vTemp3.clear();

			baseSel();	
		}
	}


	// ��� ���� �޼ҵ� (�⺻ ������)
	public void stackMin1() throws IOException
	{
		/*
		int b = bQ;							// ���̽�(��) ��
		int i = iQ;							// �ֽ� ��
		int base = iBase;					// ���̽� �ε���
		int cak = iCak;						// �ֽ� ���� ��ȣ
		*/
		
		if (cusYN == 89 || cusYN == 121)				// Ŀ���� �� �� ��� ����
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

		else													// �⺻ �������� �� ��� ����
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
	


	// ���� ���� �޼ҵ�
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