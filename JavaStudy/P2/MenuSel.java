import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

// �� ����ڿ��� ��µǴ� �޴� Ŭ����

class MenuSel
{
	//IlzoS2 il = new IlzoS2();
	MenuAdmin ma = new MenuAdmin();
	Recipe rc = new Recipe();

	int iBase, iCak;	// ����ڰ� �Է��� ���̽� ���� �����ϴ� ����, ����ڰ� �Է��� Ĭ���� ��ȣ �����ϴ� ����			
	int cusYN;			// Ŀ���� ���ο� ���� �亯 ��� ���� �� ��ü �޴� ��¿��� if�� �� �� ����ϱ� ����
	String side;		// �ֹ��� ���̵� �޴� �̸� ��� ���� 
	int n;				// ���̵� �޴� ���� ��� ����
	int sideYN;
	int allYN;
	int count =0;
	int ok=0;
	int a;				// ����ڰ� �Է��� ���̵� �޴� ��ȣ ��� ����
	int bQ; // ���̽��� ��
	int iQ; // ��� ��
	int sPrice;



	ArrayList<String> vTemp1 = new ArrayList<String>();	//-- �ӽ÷� ����� vTemp
	ArrayList<Integer> vTemp2 = new ArrayList<Integer>();	
	String[] basis = {"��ų��", "��", "�귣��", "����ī", "��"};	//-- �ε����� ���ڿ��� ������ų �迭
	ArrayList<Recipe> vTemp3 = new ArrayList<Recipe>();	
	
	//-- Ŀ���� �����Ǹ� �����ϴ� ArrayList Ÿ���� vCust

	ArrayList<String> vCust1 = new ArrayList<String>();
	ArrayList<Integer> vCust2 = new ArrayList<Integer>();
	ArrayList<Recipe> vCust3 = new ArrayList<Recipe>();

	MenuSel() throws IOException
	{
		ma.setting();
		ma.settingSide();
		baseSel();
		
	}
	
	// Ĭ���� ���� ���� �޼ҵ�

	void baseSel() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--------------[���̽� ����]--------------");
		System.out.println("1. ��ų�� 2. �� 3. �귣�� 4. ����ī 5. ��");
		System.out.println("-----------------------------------------");

		System.out.print("��ȣ�� �Է��� �ּ��� : ");
		iBase = sc.nextInt()-1;						// �� ���̽� �̸�(int)�� 0���� �����Ǳ� ������ ���ǻ� -1

		menuPrint(iBase);							// �� ���̽� �̸�(int)�� �Ű������� �޾� �޴� ��� �������� �Ѿ
	}
	

	// �Է¹��� ���̽��� ���õ� Ĭ���� �޴� ��� �޼ҵ�

	void menuPrint(int iBase) throws IOException
	{			
		int i=0;	// 0���� ������ ���� ����
		int l=1;	// 1���� ������ �޴� ��ȣ 
		
		System.out.printf("\n====================[%s ���̽�]===================", ma.basis[iBase]);
		System.out.printf("\n�ش� ���̽��� ���Ե� �޴��� �⺻ ������ %d ���Դϴ�.\n", ma.price[iBase]);
		System.out.println("���̽� �߰��� 5ml�� 2000��, �ֽ� �� ť��� �߰��� 5ml�� 1000���� �ݾ��� ����˴ϴ�."); 
		System.out.println();

		for (int base : ma.v2)	// �� ma.v2 �� ��� ���(���̽� �̸�(int))�� ����ض� 
		{
			if (base == iBase)	// �� i++ �ϸ� ����ϴٰ� ����ڰ� �Է��� iBase �� ���� ���� �ִٸ� 
			{	
				System.out.printf("�� [%d] %s: %s %dml + %s %dml\n", l, ma.v1.get(i), ma.basis[ma.v2.get(i)], ma.v3.get(i).getBaseQ(),
																						ma.v3.get(i).getIng(), ma.v3.get(i).getIngQ()); // �� �ش� �޴��� ����ض�
				l++;

				// �� �̷��� ��µǴ� ���� ���̽� ������ �� ���� ������ �� ��ȣ�� �����Ͽ� Ȱ���ؾ� �ϱ� ������	
				// �� ���̽��� ���� �޴��� �����ϴ� �ӽ� ��ü�� vTemp �� ���� 
				vTemp1.add(ma.v1.get(i));
				vTemp2.add(ma.v2.get(i));
				vTemp3.add(new Recipe(ma.v3.get(i).getBaseQ(), ma.v3.get(i).getIng(), ma.v3.get(i).getIngQ()));
			}

			i++;
		}

		System.out.println("======================================================");

		cakSelect();
	}
	

	// ���̽� �� Ĭ���� ���� �޼ҵ�

	void cakSelect() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("Ĭ���� ���� : ");
		iCak = sc.nextInt();

		cakCustom(iCak);
	}


	// Ŀ���� �޼ҵ� 

	void cakCustom(int iCak) throws IOException
	{
		Scanner sc = new Scanner(System.in);


		//Recipe rc = new Recipe();	�� ��� �޴� ����� ���� ��İ� �����ϰ� rc �ν��Ͻ� ���� Vcust ��ü�� ���� ������ ��
		

		System.out.print("\n�ش� �޴��� Ŀ�����Ͻðڽ��ϱ�? : ");
		cusYN = System.in.read();
		
		// �� ����: Ŀ������ �� ���̽��� ��� ����� �縸 ���� ������
		

		// vCust3 �� ������ rc ��ü ����

		if (cusYN == 89 || cusYN == 121)	// yes ���
		{	
			System.out.print("\n���̽��� �Է�(5ml ����) : ");

			bQ = sc.nextInt();
			rc.setBaseQ(bQ);
						
			// �� ��� �̸��� ������ �Ұ����ϱ� ������ �Է¹��� �ʰ�
			// ���� ���̽��� ������ �޴��� �ӽ÷� ������ Temp ��ü����
			// ����ڰ� �Է��� �ε����� ���� ������

			rc.setIng(vTemp3.get(iCak-1).getIng());				// iCak ���� �Է¹��� ���ڿ� 0���� �����ϴ� �ε��� ���� ������Ű�� ���ؼ� -1
									
			System.out.print("��ᷮ �Է�(5ml ����) : ");
									
			iQ = sc.nextInt();
			rc.setIngQ(iQ);
				
			vCust3.add(rc);
			
			// �� Ŀ������ �� ������ vCust1, 2, 3 ���� ���, ��ü�� ���Ӱ� �����
			// ������ ^Ŀ������ ������ �������� �Էµ� Ŀ���� �޴�^�� ����ϱ� ���ؼ���
			// vCust3.add(rc); ������ ����� ���� vCust3.size()-1 �ε����� �ʿ��� 

			for (int k=vCust3.size()-1; k<vCust3.size(); k++)	// �ӽ� ���� k �� vCust.size()-1 �� ����
			{
				// �� �޴� �̸�, ���̽� �̸� �� ��� �̸��� ���������� ������ �Ұ����ϱ� ������
				// ���� ���̽��� ������ �޴��� �ӽ÷� ������ Temp ��ü����
				// ����ڰ� �Է��� �ε����� ���� ������

				vCust1.add(vTemp1.get(iCak-1));					// iCak ���� �Է¹��� ���ڿ� 0���� �����ϴ� �ε��� ���� ������Ű�� ���ؼ� -1
				vCust2.add(vTemp2.get(iCak-1));

				System.out.printf("\n-* %s: %s %dml + %s %dml\n", vCust1.get(k), basis[vCust2.get(k)], vCust3.get(k).getBaseQ(),
																			 vCust3.get(k).getIng(), vCust3.get(k).getIngQ());
			}

			System.out.println("\n>> �Է��Ͻ� Ŀ���� �����ǰ� ���������� ����Ǿ����ϴ�!");
			System.out.println(">> ����� �����Ǵ� ���� ���Ǳ� �̿�� �ҷ��� �� �ֽ��ϴ� :D");

			side();		
		}

		else if (cusYN == 78 || cusYN == 110)	// no ���
		{	
			ok++;
			side();
		}
	}


	// ���̵� �޴� �޼ҵ�

	void side() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("\n���̵� �޴��� �߰��Ͻðڽ��ϱ�? : ");
		System.in.skip(2);	
		sideYN = System.in.read();

		if (sideYN == 89 || sideYN == 121) // yes ���
		{
			ma.printSide();

			System.out.print("\n�߰��� ���̵� �޴��� ��ȣ �Է� : ");
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
				System.out.print("�ֹ� ���� �Է�(�ִ� 10��) : ");
				n = sc.nextInt();
			}
			while (n>10 || n<1);

			allPrint();
		}

		else if (sideYN == 78 || sideYN == 110) // no ���
			allPrint();
	}
	

	// �ֹ� ���� ��� �޼ҵ�

	void allPrint() throws IOException
	{
		System.out.println("\n========<���� �ֹ� ������ Ȯ���� �ּ���>========");
		// �� ���� �޴� ���
		
		// Ŀ���� ���� ����
		int c = vCust3.get(vCust3.size()-1).getBaseQ();
		int d = vCust3.get(vCust3.size()-1).getIngQ();
		int customTot = ma.price[iBase] + ((bQ - c) * 2000); 

		if (cusYN == 89 || cusYN == 121) // cakCustom() ���� y �� �Է��ߴٸ�, �� Ŀ���� �޴��� !�����Ѵٸ�!
		{	
			// Ŀ���� �޴��� ������ ��ü�� vCust1, 2, 3 �� ���� ���� ���� ������� �޴� ���
			
			for (int k=vCust3.size()-1; k<vCust3.size(); k++)
				//customTot = ma.price[iBase] + ((((bQ-vCust3.get(k).getBaseQ())/5) * 2000) + (((iQ-vCust3.get(k).getIngQ())/5) * 1000));
				System.out.printf("%s: %s %dml + %s %dml", vCust1.get(k), basis[vCust2.get(k)], vCust3.get(k).getBaseQ(), vCust3.get(k).getIng(), vCust3.get(k).getIngQ());
			System.out.print(" " + customTot);
		}
		
		else if (cusYN == 78 || cusYN == 110) // cakCustom() ���� n �� �Է��ߴٸ�, �� Ŀ���� �޴��� !�������� �ʴ´ٸ�!
		{
			// ���� ���̽��� ���� �޴��� ������ ��ü�� Temp 1, 2, 3 �� ���� ���� ���� ������� �޴� ���

			System.out.printf("%s: %s %dml + %s %dml - %d��", vTemp1.get(iCak-1), basis[vTemp2.get(iCak-1)], vTemp3.get(iCak-1).getBaseQ(), vTemp3.get(iCak-1).getIng(), vTemp3.get(iCak-1).getIngQ(), ma.price[iBase]); // iCak ��ȣ�� 1�� �Է��ϸ� 0��°�� �ִ� ���� ����ϵ��� �ؾ� �ż� -1 �� ��
		}
		
		// �� ���̵� �޴� ���
		
		// ���̵� ���� ����
		int sideTot = n * sPrice;
		
		if (sideYN == 89 || sideYN == 121) // side() ���� y �� �Է��ߴٸ�, �� ���̵� �޴��� �����Ѵٸ�
		{
			System.out.printf("\n%s - %d�� %d��", side, n, sideTot);	
		}
		
		System.out.println("\n================================================");
		
		// �� �� ���� ����


		// �� �ֹ� ���� ����
		
		System.out.print("\n�ֹ� ������ ��Ȯ�մϱ�? : ");
		System.in.skip(2);
		allYN = System.in.read();
		System.out.println();
	
		if (allYN == 89 || allYN == 121) // ��Ȯ�ϴٸ�
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
				System.out.printf("�� %s: %s %dml + %s %dml\n", vCust1.get(k), basis[vCust2.get(k)],
									vCust3.get(k).getBaseQ(), vCust3.get(k).getIng(), vCust3.get(k).getIngQ());
			}
			*/
		
			vTemp1.clear();
			vTemp2.clear();
			vTemp3.clear();	
		}
		
		if (allYN == 78 || allYN == 110) // ��Ȯ���� �ʴٸ�
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
	// Ŀ���� ���� Test �޼ҵ�

	void test() throws IOException
	{
		for (int k=0; k<vCust3.size(); k++)
		{
			System.out.printf("�� %s: %s %dml + %s %dml\n", vCust1.get(k), basis[vCust2.get(k)],
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
