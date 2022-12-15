import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class MenuAdmin extends Management
{	
	// �ʵ� ���� ����

	static ArrayList<String> v1 = new ArrayList<String>();					// �޴� �̸��� �����ϴ� ArrayList Ÿ���� v1
	static ArrayList<Integer> v2 = new ArrayList<Integer>();				// ���̽� �̸�(int)�� �����ϴ� ArrayList Ÿ���� v2
	static ArrayList<Recipe> v3 = new ArrayList<Recipe>();					// �޴� �̸�, ���̽� �̸��� ������ ������(���̽���, ��� �̸�, ��ᷮ)��
																	// Recipe ��ü�� �����ϴ� ArrayList Ÿ���� v3
	
	String[] basis = {"��ų��", "��", "�귣��", "����ī", "��"};	// ���̽� �ε����� ������ų ���̽� �̸�(String)�� �����ϰ� �ִ� �迭 basis
	int[] price = {10000, 15000, 20000, 18000, 10000};				// ���̽� �ε����� ������ų ������ �����ϰ� �ִ� �迭 price

	// �޴� �̸��� �����ϴ� ��ü�� ���� ������ ������
	// �޴� �̸� ������ ���� index ���� ã��
	// �޴� ������ ������ �����ϰ� �ϱ� �����̰�

	// ���̽� �̸�(int)�� �����ϴ� ��ü�� ���� ������ ������
	// ���� ����ڿ��� �޴��� ����� ��
	// ���̽� �̸� ������ ���� 
	// �ش��ϴ� ���̽��� ���õ� �޴����� ����ϴ� ���� �����ϰ� �ϱ� ������

	// �� ���� ����� �־��� �� ���⵵ �� ^^;

	static ArrayList<String> v4 = new ArrayList<String>();					// ���̵� �޴��� �̸��� �����ϴ� ArrayList Ÿ���� v4
	int[] sidePrice = {3000, 5000, 2000};							// ���̵� �޴��� ������ �����ϴ� �迭
	
	private int menu;	// �޴� �������� ������ �޴� ��ȣ


	// �޴����� Home �޼ҵ�
	
	public void home() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println("\t1. �޴� ���");
		System.out.println("\t2. ���� �޴� �߰�");
		System.out.println("\t3. ���� �޴� ����");
		System.out.println("\t4. ���� �޴� ����");
		System.out.println("\t5. �ڷ� ����");

		System.out.print("\n\t>> �޴� ����(1~4) : ");
		menu = sc.nextInt();

		System.out.println();

		switch (menu)
		{
			case 1 : print(); break;
			case 2 : input(); break;			
			case 3 : delete(); break;			
			case 4 : change(); break;
			case 5 : managerMenu(); break;
		}
	}


	// �⺻ �޴� + ������ ���� �޼ҵ�

	void setting() 
	{
		// v1 �� �޴� �̸�
		v1.add("������Ÿ");
		v1.add("�� ��");
		v1.add("��ų�� ���");
		v1.add("�ǳ� �ݶ��");
		v1.add("��� �Ͽ���");
		v1.add("�߷��þ�");
		v1.add("��Ϲ�");
		v1.add("��� ��ī��");
		v1.add("�ڽ�������ź");
		v1.add("Ŭ�ι� Ŭ��");
		v1.add("�� ����");
		
		// v2 �� ���̽� �̸�(int)
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

		// v3 �� ���̽���, ��� �̸�, ��ᷮ
		v3.add(new Recipe(90, "�����ֽ�", 60));
		v3.add(new Recipe(60, "ũ�������ֽ�", 90));
		v3.add(new Recipe(100, "�����ֽ�", 50));
		v3.add(new Recipe(60, "���ξ����ֽ�", 90));
		v3.add(new Recipe(85, "�����ֽ�", 65));
		v3.add(new Recipe(50, "���ξ����ֽ�", 100));
		v3.add(new Recipe(75, "�����ֽ�", 75));
		v3.add(new Recipe(60, "��� ť���", 90));
		v3.add(new Recipe(70, "�����ֽ�", 80));
		v3.add(new Recipe(80, "�����ֽ�", 70));
		v3.add(new Recipe(90, "�����ֽ�", 60));
	}


	// ���̵� �޴� ���� �޼ҵ�

	void settingSide()
	{
		v4.add("ũ��Ŀ");
		v4.add("ġ��");
		v4.add("�Ƹ��");
	}
	

	// �޴� ��ü ��� �޼ҵ�

	void print() throws IOException
	{
		System.out.println("\t==================[���� �޴�]==================");

		for (int i=0; i<v1.size(); i++)
		{
			System.out.printf("\t�� [%d] %s: %s %dml + %s %dml\n", i+1, v1.get(i), basis[v2.get(i)], v3.get(i).getBaseQ(),
																				v3.get(i).getIng(), v3.get(i).getIngQ());
			// �� get() �� ���� �� ��ü�� i��°�� �ִ� ��Ҹ� ������
			//	  v1, v2, v3 ��ü�� i��° ��Ҹ� �ٰ��� �ҷ����� �� �� �޴��� �����Ǹ� �����ϴ� ���� �����ϴ�
			//    ex. v1.get(1),  basis[v2.get(1)],  v3.get(1).getBaseQ(), v3.get(1).getIng(), v3.get(1).getIngQ()
			//		  ---------   ----------------   -------------------  ------------------  -------------------
			//		 "������Ÿ"  basis[0] = "��ų��"         30               "�����ֽ�"              15																				
		}

		System.out.println("\t===============================================");

		home();
	}
	

	// ���� �޴� ��� �޼ҵ�

	public void basic(String MenuName)
	{
		int i = v1.indexOf(MenuName);
		System.out.printf("\t%s �⺻ ������ : %s %dml + %s %dml\n", v1.get(i), basis[v2.get(i)], v3.get(i).getBaseQ(),
																			v3.get(i).getIng(), v3.get(i).getIngQ());
	}


	// ���̵� �޴� ��ü ��� �޼ҵ�

	public void printSide()
	{
		Cracker newCracker = new Cracker();
		Cheese newCheese = new Cheese();
		Almond newAlmond = new Almond();

		System.out.println("\n\t=================[���̵� �޴�]=================");

		for (int i=0; i<v4.size(); i++)
		{	
			System.out.printf("\t�� [%d] %s %d��\n", i+1, v4.get(i), sidePrice[i]);
			
			if (v4.get(i).equals("ũ��Ŀ") && newCracker.getNowQty() < 1)
				{
					System.out.println("\t\tǰ���Դϴ�. �ٸ� �޴��� ���� �� �ּ���..");
				}

			if (v4.get(i).equals("ġ��") && newCheese.getNowQty() < 1)
				{
					System.out.println("\t\tǰ���Դϴ�. �ٸ� �޴��� ���� �� �ּ���..");
				}
			
			if (v4.get(i).equals("�Ƹ��") && newAlmond.getNowQty() < 1)
				{
					System.out.println("\t\tǰ���Դϴ�. �ٸ� �޴��� ���� �� �ּ���..");
				}
		}

		System.out.println("\t===============================================");
	}


	// �޴� �߰� �޼ҵ�

	void input() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		Recipe rc = new Recipe(); // �޴����� �Ӽ� Ŭ������ Recipe �� �ν��Ͻ� ����

		String iName;			// �߰��� �޴� �̸� �Է¹��� ����
		int iBase, iBaseQ;		// �߰��� ���̽� ��ȣ, ���̽��� �Է¹��� ����
		int a;					// �߰��� ��� ��ȣ �Է¹��� ����

		System.out.print("\n\t�߰��� �޴��� �̸� : ");
		iName = sc.next();

		System.out.println("\n\t1. ��ų�� 2. �� 3. �귣�� 4. ����ī 5. ��");
		System.out.print("\n\t�ش� �޴��� �� ���̽� �Է� : ");	
		iBase = sc.nextInt()-1;											// �� ���̽� �̸�(int)�� 0���� �����Ǳ� ������ -1
		
		do
		{
			System.out.print("\n\t���̽��� ��(ml) �Է� : ");
			iBaseQ = sc.nextInt();
		}
		while (iBaseQ <= 0 || iBaseQ > 150);
		
		rc.setBaseQ(iBaseQ);
		
		System.out.println("\n\t�ֽ�/ť����� ���� �⺻ �뷮�� 150ml ���� ���̽����� ������ ��ŭ �ڵ����� �����˴ϴ�.");
		System.out.println("\n\t1. �����ֽ� 2. �����ֽ� 3. ũ�������ֽ� 4. ���ξ����ֽ� 5.���ť���");
		System.out.print("\n\t�ش� �޴��� �� �ֽ�/ť��� �Է� : ");
		a = sc.nextInt();

		switch (a)
		{
			case 1: rc.setIng("�����ֽ�"); break;
			case 2: rc.setIng("�����ֽ�"); break;
			case 3: rc.setIng("ũ�������ֽ�"); break; 
			case 4: rc.setIng("���ξ����ֽ�"); break;
			case 5: rc.setIng("���ť���"); break;
		}
			
		rc.setIngQ(150-iBaseQ);
		
		// �� ��ü�� �߰������ν� �ϳ��� �߰� �޴� ���� �Ϸ�

		v1.add(iName);
		v2.add(iBase);
		v3.add(rc);

		home();
	}


	// �޴� ���� �޼ҵ�

	void delete() throws IOException
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String dName;	// ������ �޴� �̸� �Է¹��� ����

		System.out.print("\t������ �޴� �Է� : ");
		dName = br.readLine(); 

		System.out.println("\t[���� ��� ���]");

		if(v1.indexOf(dName)<0)
		{
			System.out.println("\t�׸��� �������� �ʾ� ������ �� �����ϴ�.");			
		}
		else
		{	
			v2.remove(v1.indexOf(dName));		// �� �޴� �̸��� �����ϰ� �ִ� v1 ���� dName �� ���Ե� �ε����� ã��
			v3.remove(v1.indexOf(dName));		//    �� �ε����� �ش��ϴ� v2, v3 �� �����ϰ�
			v1.remove(dName);					//    v1 ���� ���������ν� �� �޴��� �����ϴ� ��� ��Ҹ� ����
			
			System.out.println("\t������ �Ϸ�Ǿ����ϴ�.");
		}
		System.out.println();

		home();
	}


	// �޴� ���� �޼ҵ�

	void change() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String cName;		// ������ �޴� �̸� �Է¹��� ����
		int i;				// ������ �޴� �̸��� ���� v1�� �ε��� ���� ������ ���� 
		int a=0, l;			// ������ ��ȣ �Է¹��� ����, ������ �뷮 �Է¹��� ����

		System.out.print("\t������ �޴��� �Է� : ");
		cName = br.readLine();
		
		if (v1.contains(cName))	// v1 �� cName �� ��ҷ� ������ �ִٸ�
		{
			i = v1.indexOf(cName);
			
			System.out.println("\t1. ���̽� 2. ���");
			System.out.print("\t������ ��� �Է� : ");
			a = Integer.parseInt(br.readLine());

			switch (a)
			{
				case 1: do
						{
							System.out.print("\t������ �뷮�� �Է��� �ּ���. : ");
							l = Integer.parseInt(br.readLine());
						}
						while (l <= 0 || l > 150);

						v3.get(i).setBaseQ(l);
						v3.get(i).setIngQ(150-l);

						break;
				case 2: do
						{
							System.out.print("\t������ �뷮�� �Է��� �ּ���. : ");
								l = Integer.parseInt(br.readLine());
						}
						while (l <= 0 || l > 150);

						v3.get(i).setIngQ(l);
						v3.get(i).setBaseQ(150-l);
						break;
			}
		}
	
		else	// v1 �� cName �� ��ҷ� ������ ���� �ʴٸ�
			System.out.println("\t�Է��Ͻ� ǰ���� �������� �ʽ��ϴ�.");

		System.out.println();

		home();
	}
}