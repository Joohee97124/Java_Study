import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class MenuAdmin  
{	
	Management m = new Management();								// 5. �ڷΰ��� ���� ����ϱ� ���� ������ Ȩ �ν��Ͻ� ����

	// �ʵ� ���� ����

	static ArrayList<String> v1 = new ArrayList<String>();					// �޴� �̸��� �����ϴ� ArrayList Ÿ���� v1

	static ArrayList<Integer> v2 = new ArrayList<Integer>();				// ���̽� �̸�(int)�� �����ϴ� ArrayList Ÿ���� v2
	String[] basis = {"��ų��", "��", "�귣��", "����ī", "��"};	// ������ų �ε����� ���̽� �̸�(String)�� �����ϰ� �ִ� �迭 basisa
	int[] price = {10000, 15000, 20000, 18000, 10000};				// ������ų �ε����� ������ �����ϰ� �ִ� �迭 price

	static ArrayList<Recipe> v3 = new ArrayList<Recipe>();					// �޴� �̸�, ���̽� �̸��� ������ ������(���̽���, ��� �̸�, ��ᷮ)��
																	// Recipe ��ü�� �����ϴ� ArrayList Ÿ���� v3

	int[] sidePrice = {3000, 5000, 2000};
	
	// �޴� �̸��� �����ϴ� ��ü�� ���� ������ ������
	// �޴� �̸� ������ ���� index ���� ã��
	// �޴� ������ ������ �����ϰ� �ϱ� �����̰�

	// ���̽� �̸�(int)�� �����ϴ� ��ü�� ���� ������ ������
	// ���� ����ڿ��� �޴��� ����� ��
	// ���̽� �̸� ������ ���� 
	// �ش��ϴ� ���̽��� ���õ� �޴����� ����ϴ� ���� �����ϰ� �ϱ� ������

	// �� ���� ����� �־��� �� ���⵵ �� ^^;

	static ArrayList<String> v4 = new ArrayList<String>();					// ���̵� �޴��� �̸��� �����ϴ� ArrayList Ÿ���� v4
	
	private int menu;



	// �޴����� Home �޼ҵ�
	
	public void home() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println("\t       1. �޴� ���");
		System.out.println("\t       2. ���� �޴� �߰�");
		System.out.println("\t       3. ���� �޴� ����");
		System.out.println("\t       4. ���� �޴� ����");
		System.out.println("\t       5. �ڷ� ����");

		System.out.print("\n\t       >> �޴� ����(1~4) : ");
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


	// �⺻ �޴� + ������ ���� �޼ҵ�

	static void setting() 
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
		v3.add(new Recipe(30, "�����ֽ�", 15));
		v3.add(new Recipe(35, "ũ�������ֽ�", 90));
		v3.add(new Recipe(60, "�����ֽ�", 15));
		v3.add(new Recipe(30, "���ξ����ֽ�", 90));
		v3.add(new Recipe(30, "�����ֽ�", 30));
		v3.add(new Recipe(40, "���ξ����ֽ�", 20));
		v3.add(new Recipe(25, "�����ֽ�", 30));
		v3.add(new Recipe(10, "��� ť���", 10));
		v3.add(new Recipe(30, "�����ֽ�", 15));
		v3.add(new Recipe(60, "�����ֽ�", 15));
		v3.add(new Recipe(45, "�����ֽ�", 15));
	}


	// ���̵� �޴� ���� �޼ҵ�

	static void settingSide()
	{
		v4.add("ũ��Ŀ");
		v4.add("ġ��");
		v4.add("�Ƹ��");
	}
	

	// �޴� ��ü ��� �޼ҵ�

	void print() throws IOException
	{
		System.out.println("==================[���� �޴�]==================");
		// System.out.println(v1.size);

		for (int i=0; i<v1.size(); i++)
		{
			System.out.printf("�� [%d] %s: %s %dml + %s %dml\n", i+1, v1.get(i), basis[v2.get(i)], v3.get(i).getBaseQ(),
																				v3.get(i).getIng(), v3.get(i).getIngQ());
			// �� get() �� ���� �� ��ü�� i��°�� �ִ� ��Ҹ� ������
			//	  v1, v2, v3 ��ü�� i��° ��Ҹ� �ٰ��� �ҷ����� �� �� �޴��� �����Ǹ� �����ϴ� ���� �����ϴ�
			//    ex. v1.get(1),  basis[v2.get(1)],  v3.get(1).getBaseQ(), v3.get(1).getIng(), v3.get(1).getIngQ()
			//		  ---------   ----------------   -------------------  ------------------  -------------------
			//		 "������Ÿ"  basis[0] = "��ų��"         30               "�����ֽ�"              15																				
		}

		System.out.println("===============================================");

		home();
	}
	

	// ���� �޴� ��� �޼ҵ�

	public void basic(String MenuName)
	{
		int i = v1.indexOf(MenuName);
		System.out.printf("%s �⺻ ������ : %s %dml + %s %dml\n", v1.get(i), basis[v2.get(i)], v3.get(i).getBaseQ(),
																			v3.get(i).getIng(), v3.get(i).getIngQ());
	}


	// ���̵� �޴� ��ü ��� �޼ҵ�

	public void printSide()
	{

		System.out.println("\n=================[���̵� �޴�]=================");

		for (int i=0; i<v4.size(); i++)
		{
			System.out.printf("�� [%d] %s %d��\n", i+1, v4.get(i), sidePrice[i]);
		}

		System.out.println("===============================================");
	}


	// �޴� �߰� �޼ҵ�

	void input() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		Recipe rc = new Recipe(); // �޴����� �Ӽ� Ŭ������ Recipe �� �ν��Ͻ� ����

		String iName; // �߰��� �޴� �̸� �Է¹��� ����
		int iBase;	  // �߰��� ���̽� ��ȣ �Է¹��� ����
		int a;		  // �߰��� ��� ��ȣ �Է¹��� ����
					  // �� ���̽���� ��ᷮ�� ���� ���� �������� �ʰ� setter �� �ٷ� ����

		System.out.print("�߰��� �޴��� �̸� : ");
		iName = sc.next();
		rc.setMenuName(iName);

		System.out.println("1. ��ų�� 2. �� 3. �귣�� 4. ����ī 5. ��");
		System.out.print("�ش� �޴��� �� ���̽� �Է� : ");	
		iBase = sc.nextInt()-1;											// �� ���̽� �̸�(int)�� 0���� �����Ǳ� ������ -1
		rc.setBase(iBase);

		System.out.print("���̽��� ��(ml) �Է� : ");
		rc.setBaseQ(sc.nextInt());

		System.out.println("1. �����ֽ� 2. �����ֽ� 3. ũ�������ֽ� 4. ���ξ����ֽ� 5.���ť���");
		System.out.print("�ش� �޴��� �� ��� �Է� : ");
		a = sc.nextInt();

		switch (a)
		{
			case 1: rc.setIng("�����ֽ�"); break;
			case 2: rc.setIng("�����ֽ�"); break;
			case 3: rc.setIng("ũ�������ֽ�"); break; 
			case 4: rc.setIng("���ξ����ֽ�"); break;
			case 5: rc.setIng("���ť���"); break;
		}
			
		System.out.print("����� ��(ml) �Է� : ");
		rc.setIngQ(sc.nextInt());
		
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

		System.out.print("������ �޴� �Է� : ");
		dName = br.readLine(); 

		System.out.println("[���� ��� ���]");

		if(v1.indexOf(dName)<0)
		{
			System.out.println("�׸��� �������� �ʾ� ������ �� �����ϴ�.");			
		}
		else
		{	
			v2.remove(v1.indexOf(dName));		// �� �޴� �̸��� �����ϰ� �ִ� v1 ���� dName �� ���Ե� �ε����� ã��
			v3.remove(v1.indexOf(dName));		//    �� �ε����� �ش��ϴ� v2, v3 �� �����ϰ�
			v1.remove(dName);					//    v1 ���� ���������ν� �� �޴��� �����ϴ� ��� ��Ҹ� ����
			
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
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
		int a=0, l;			// ������ ��� ��ȣ �Է¹��� ����, ������ �뷮 �Է¹��� ����

		System.out.print("������ �޴��� �Է� : ");
		cName = br.readLine();
		
		if (v1.contains(cName))	// v1 �� cName �� ��ҷ� ������ �ִٸ�
		{
			i = v1.indexOf(cName);
			
			System.out.println("1. ���̽� 2. ���");
			System.out.println("������ ��� �Է� : ");
			a = Integer.parseInt(br.readLine());

			switch (a)
			{
				case 1: System.out.print("������ �뷮�� �Է��� �ּ���. : ");
						l = Integer.parseInt(br.readLine());
						v3.get(i).setBaseQ(l);
						break;
				case 2: System.out.print("������ �뷮�� �Է��� �ּ���. : ");
						l = Integer.parseInt(br.readLine());
						v3.get(i).setIngQ(l);
						break;
			}
		}
	
		else	// v1 �� cName �� ��ҷ� ������ ���� �ʴٸ�
			System.out.println("�Է��Ͻ� ǰ���� �������� �ʽ��ϴ�.");

		System.out.println();

		home();
	}
	

	// �ڷΰ��� �޼ҵ�
	public void back() throws IOException
	{
		m.managerMenu();
	}	
}