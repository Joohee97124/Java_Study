import java.util.Scanner;
import java.util.Vector;
import java.io.IOException;

class Lime
{
	static final String ingName = "�����ֽ�";
	int ingNum = 1;
	private static int minQty = 15;
	private static int nowQty = 10;
	static String supplier = "(��)ǳ���ֽ�";
	
	// �����ֽ��� ���Ե� �޴� ���
	public static void print_Rmenu()
	{
		System.out.println("������Ÿ");
		System.out.println("��� �Ͽ���");
		System.out.println("�ڽ�������ź");
		System.out.println("�� ����");
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
	static final String ingName = "�����ֽ�";
	int ingNum = 2;
	private static int minQty = 15;
	private static int nowQty = 0;
	static String supplier = "(��)ǳ���ֽ�";

	// �����ֽ��� ���Ե� �޴� ���

	public static void print_Rmenu()
	{
		System.out.println("��ų�� ���");
		System.out.println("��Ϲ�");
		System.out.println("Ŭ�ι� Ŭ��");
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
	static final String ingName = "ũ�������ֽ�";
	int ingNum = 3;
	private static int minQty = 15;
	private static int nowQty = 0;
	static String supplier = "(��)ǳ���ֽ�";

	// ũ�������ֽ��� ���Ե� �޴� ���

	public static void print_Rmenu()
	{
		System.out.println("�� ��");
		System.out.println("�ڽ�������ź");
		System.out.println("Ŭ�ι� Ŭ��");
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
	static final String ingName = "���ξ����ֽ�";
	int ingNum = 4;
	private static int minQty = 20;
	private static int nowQty = 0;
	static String supplier = "(��)ǳ���ֽ�";

	// ���ξ����ֽ��� ���Ե� �޴� ���

	public static void print_Rmenu()
	{
		System.out.println("�ǳ� �ݶ��");
		System.out.println("�߷��þ�");
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
	static final String ingName = "���ť���";
	int ingNum = 5;
	private static int minQty = 10;
	private static int nowQty = 0;
	static String supplier = "(��)ǳ���ֽ�";

	// ���ť��Ұ� ���Ե� �޴� ���

	public static void print_Rmenu()
	{
		System.out.println("��� �Ͽ���");
		System.out.println("��� ��ī��");
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
	static final String ingName = "ũ��Ŀ";
	int ingNum = 6;
	private static int minQty = 10 ;
	private static int nowQty = 0;
	static String supplier = "(��)�ѱ�����";

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
	static final String ingName = "ġ��";
	int ingNum = 7;
	private static int minQty = 10;
	private static int nowQty = 0;
	static String supplier = "(��)�ѱ�����";

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
	static final String ingName = "�Ƹ��";
	int ingNum = 8;
	private static int minQty = 10;
	private static int nowQty = 0;
	static String supplier = "(��)�ѱ�����";

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
	static final String ingName = "��ų��";
	int ingNum = 9;
	private static int minQty = 30;
	private static int nowQty = 0;
	static String supplier = "(��)��������";
	
	// ��ų�� ���Ե� �޴� ���
	public static void print_Rmenu()
	{
		System.out.println("������Ÿ");
		System.out.println("�� ��");
		System.out.println("��ų�� ���");
	}
	
	// �ּ� ������ getter()
	public static int getMinQty()
	{
		return minQty;
	}

	// �ּ� ������ setter()
	public static void setMinQty(int minQty)
	{
		Tequila.minQty = minQty;
	}

	// ���� ������ getter()
	public static int getNowQty()
	{
		return nowQty;
	}

	// ���� ������ setter()
	public static void setNowQty(int nowQty)
	{
		Tequila.nowQty = nowQty;
	}
}

class Rum
{
	static final String ingName = "��";
	int ingNum = 10;
	private static int minQty = 30;
	private static int nowQty = 0;
	static String suppiler = "(��)��������";

	// ���� ���Ե� �޴� ���
	public static void print_Rmenu()
	{
		System.out.println("�ǳ� �ݶ��");
		System.out.println("��� �Ͽ���");
	}

	// �ּ� ������ getter()
	public static int getMinQty()
	{
		return minQty;
	}

	// �ּ� ������ setter()
	public static void setMinQty(int minQty)
	{
		Rum.minQty = minQty;
	}

	// ���� ������ getter()
	public static int getNowQty()
	{
		return nowQty;
	}

	// ���� ������ setter()
	public static void setNowQty(int nowQty)
	{
		Rum.nowQty = nowQty;
	}
}

class Brandy
{
	static final String ingName = "�귣��";
	int ingNum = 11;
	private static int minQty = 25;
	private static int nowQty = 0;
	static String supplier = "(��)��������";

	// �귣�� ���Ե� �޴� ���
	public static void print_Rmenu()
	{
		System.out.println("�߷��þ�");
		System.out.println("��Ϲ�");
	}


	// �ּ� ������ getter()
	public static int getMinQty()
	{
		return minQty;
	}

	// �ּ� ������ setter()
	public static void setMinQty(int minQty)
	{
		Brandy.minQty = minQty;
	}

	// ���� ������ getter()
	public static int getNowQty()
	{
		return nowQty;
	}

	// ���� ������ setter()
	public static void setNowQty(int nowQty)
	{
		Brandy.nowQty = nowQty;
	}
}

class Vodka
{
	static final String ingName = "����ī";
	int ingNum = 12;
	private static int minQty = 10;
	private static int nowQty = 0;
	static String supplier = "(��)��������";

	// ����ī�� ���Ե� �޴� ���
	public static void print_Rmenu()
	{
		System.out.println("��� ��ī��");
		System.out.println("�ڽ�������ź");
	}


	// �ּ� ������ getter()
	public static int getMinQty()
	{
		return minQty;
	}

	// �ּ� ������ setter()
	public static void setMinQty(int minQty)
	{
		Vodka.minQty = minQty;
	}

	// ���� ������ getter()
	public static int getNowQty()
	{
		return nowQty;
	}

	// ���� ������ setter()
	public static void setNowQty(int nowQty)
	{
		Vodka.nowQty = nowQty;
	}
}

class Jin
{
	static final String ingName = "��";
	int ignNum = 13;
	private static int minQty = 45;
	private static int nowQty = 0;
	static String supplier = "(��)��������";

	// ���� ���Ե� �޴� ���
	public static void print_Rmenu()
	{
		System.out.println("Ŭ�ι� Ŭ��");
		System.out.println("������");
	}


	// �ּ� ������ getter()
	public static int getMinQty()
	{
		return minQty;
	}

	// �ּ� ������ setter()
	public static void setMinQty(int minQty)
	{
		Jin.minQty = minQty;
	}

	// ���� ������ getter()
	public static int getNowQty()
	{
		return nowQty;
	}

	// ���� ������ setter()
	public static void setNowQty(int nowQty)
	{
		Jin.nowQty = nowQty;
	}
}
//--------------------------------------------------------------

// ���ָ� �Է��� �� ���� ����� ��ȣ�� ������ �Է�.

// ���� ������ ����ó�� ������ �� �ִ� Ŭ����

// ��Ằ ����ó ����.

/*
	static final String ingName = "��";
	int ignNum = 13;
	private static int minQty = 45;
	private static int nowQty = 0;
	static String supplier = "(��)��������";
*/

/* ��� �̸�, �ŷ�ó �̸� ���� ���..
class Officechange
{
	public static void ingnames()
	{
		Scanner sc = new Scanner(System.in);
		Jin officeJin = new Jin();
		
		System.out.println(" �޴� �ֿ��� " );
		System.out.println("������ �޴��� ���� �� �ּ��� : ");
		
		System.out.println(Jin.ingName);

		String newIngName = sc.next();
		Jin.ingName = newIngName;

		System.out.println("�ٲ�" + Jin.ingName);
	}
}
*/



// ��� ���� Ŭ����.
class MainOffice
{	
	private static int qty;					// ���ַ�
	private static int sumqty;				// ������ ��� ���ַ��� ���� ����!
	private static int num;					// ���� ���ִ� ����..
	private static char select;				// YES / NO

	public static void selectOffice() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\t1. �ֽ�  2. ����  3. ���̽�");
		System.out.print("\t���� �Ͻ� ��Ḧ ����ּ��� : ");
		num = sc.nextInt();
		System.out.println();

		switch (num)
		{
			case 1 : orderingOffice1(); break;
			case 2 : orderingOffice2(); break;
			case 3 : orderingOffice3(); break;

			// case 4: �ٸ� �������� �Ѿ ��.
		}
	}

	// ǳ�� �ֽ� �ŷ�ó �޼ҵ� �ֽ�( 1~ 5 )
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
		
		System.out.print("\t������ ǰ���� �����ּ��� : " );
		num = sc.nextInt();
		System.out.println();

		do
		{	
			System.out.println("\t�� ǳ���ֽ� �ŷ�ó �Դϴ�. �ּ� ���ַ��� 20ml " );
			System.out.println();
			System.out.print("\t�ش� ����� ������ ��(ea)�� �Է� �� �ּ��� : ");
			qty = sc.nextInt();
		}
		while (qty < 20);

		try
		{	
			System.out.print("\n\t");
			String s = " �� �� �� �� �� �� �� �� �� �� . . . .";
			for (int i = 0; i < s.length(); i++) 
			{ 
			   // �ε� ȿ�� ������
			   Thread.sleep(80);					// s ���ڿ��� ���鼭 sleep() ���� ���� ���� �� ���ھ� ���!
			   System.out.print(s.charAt(i));
			}

			System.out.println("\n");
		}
		catch (InterruptedException e)
		{
			System.out.println();					// ������� ���� ó���� ����� ��..
		}

		if (num == 1)
		{	
			System.out.print("\t["+ orderLime.ingName + "] ���� ���緮 : " + orderLime.getNowQty() + "\t");
			sumqty = orderLime.getNowQty()+qty;
			orderLime.setNowQty(sumqty);
			System.out.println("���� �� ���緮 : " + orderLime.getNowQty());
		}

		else if (num == 2)
		{
			System.out.print("\t["+ orderLemon.ingName + "] ���� ���緮 : " + orderLemon.getNowQty() + "\t");
			sumqty = orderLemon.getNowQty()+qty;
			orderLemon.setNowQty(sumqty);
			System.out.println("���� �� ���緮 : " + orderLemon.getNowQty());
		}
		else if (num == 3)
		{
			System.out.print("\t["+ orderCranberry.ingName + "] ���� ���緮 : " + orderCranberry.getNowQty() + "\t");
			sumqty = orderCranberry.getNowQty()+qty;
			orderCranberry.setNowQty(sumqty);
			System.out.println("���� �� ���緮 : " + orderCranberry.getNowQty());
		}
		else if (num == 4)
		{
			System.out.print("\t["+ orderPineapple.ingName + "] ���� ���緮 : " + orderPineapple.getNowQty() + "\t");
			sumqty = orderPineapple.getNowQty()+qty;
			orderPineapple.setNowQty(sumqty);
			System.out.println("���� �� ���緮 : " + orderPineapple.getNowQty());
		}
		else if (num == 5)
		{
			System.out.print("\t["+ orderBlueCu.ingName + "] ���� ���緮 : " + orderBlueCu.getNowQty() + "\t");
			sumqty = orderBlueCu.getNowQty()+qty;
			orderBlueCu.setNowQty(sumqty);
			System.out.println("���� �� ���緮 : " + orderBlueCu.getNowQty());
		}
		System.out.println();

		System.out.print("\t��� ���� �Ͻðڽ��ϱ�?(Y/N) : ");
		select = (char)System.in.read();

		if (select == 'Y' || select == 'y')
			selectOffice();
		System.out.println();
		
			// ���� �� �ٰ�..
	}

	// �ѱ� ���� �ŷ�ó ���� ( 6 ~ 8 )
	public static void orderingOffice2() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		Cracker orderCracker = new Cracker();
		Cheese orderCheese = new Cheese();
		Almond orderAlmond = new Almond();

		System.out.println("\t1. "+ orderCracker.ingName + "2. " + orderCheese.ingName +
							 "3. "+ orderAlmond.ingName);
		
		System.out.print("\t������ ǰ���� �����ּ��� : ");
		num = sc.nextInt();
		System.out.println();

		do
		{	
			System.out.println("\t�� �ѱ����� �ŷ�ó �Դϴ� (�ּ� ���ַ� 10ea).");
			System.out.print("\t�ش� ����� ������ ��(ea)�� �Է� �� �ּ��� : ");
			qty = sc.nextInt();
		}
		while (qty < 10);

		try
		{	
			System.out.print("\n\t");
			String s = " �� �� �� �� �� �� �� �� �� �� . . . .";
			for (int i = 0; i < s.length(); i++) 
			{ 
			   // �ε� ȿ�� ������
			   Thread.sleep(80);					// s ���ڿ��� ���鼭 sleep() ���� ���� ���� �� ���ھ� ���!
			   System.out.print(s.charAt(i));
			}

			System.out.println("\n");
		}
		catch (InterruptedException e)
		{
			System.out.println();					// ������� ���� ó���� ����� ��..
		}

		if (num == 1)
		{	
			System.out.print("\t["+ orderCracker.ingName + "] ���� ���緮 : " + orderCracker.getNowQty() + "\t");
			sumqty = orderCracker.getNowQty()+qty;
			orderCracker.setNowQty(sumqty);
			System.out.println("���� �� ���緮 : " + orderCracker.getNowQty());
		}

		else if (num == 2)
		{
			System.out.print("\t["+ orderCheese.ingName + "] ���� ���緮 : " + orderCheese.getNowQty() + "\t");
			sumqty = orderCheese.getNowQty()+qty;
			orderCheese.setNowQty(sumqty);
			System.out.println("���� �� ���緮 : " + orderCheese.getNowQty());
		}
		else if (num == 3)
		{
			System.out.print("\t["+ orderAlmond.ingName + "] ���� ���緮 : " + orderAlmond.getNowQty() + "\t");
			sumqty = orderAlmond.getNowQty()+qty;
			orderAlmond.setNowQty(sumqty);
			System.out.println("���� �� ���緮 : " + orderAlmond.getNowQty());
		}
		System.out.println();

		System.out.print("\t��� ���� �Ͻðڽ��ϱ�?(Y/N) : ");
		select = (char)System.in.read();

		if (select == 'Y' || select == 'y')
			selectOffice();
		System.out.println();
	}

	// �ѱ� ���� �ŷ�ó ��..( 9 ~ 13 )
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
		
		System.out.print("\t������ ǰ���� �����ּ��� : " );
		num = sc.nextInt();
		System.out.println();

		do
		{	
			System.out.println("\t�� �������� �ŷ�ó �Դϴ�. (�ּ� ���ַ� 45ml) " );
			System.out.print("\t�ش� ����� ������ ��(ml)�� �Է� �� �ּ��� : ");
			qty = sc.nextInt();
			System.out.println();
		}
		while (qty < 45);

		try
		{	
			System.out.print("\n\t");
			String s = " �� �� �� �� �� �� �� �� �� �� . . . .";
			for (int i = 0; i < s.length(); i++) 
			{ 
			   // �ε� ȿ�� ������
			   Thread.sleep(80);					// s ���ڿ��� ���鼭 sleep() ���� ���� ���� �� ���ھ� ���!
			   System.out.print(s.charAt(i));
			}

			System.out.println("\n");
		}
		catch (InterruptedException e)
		{
			System.out.println();					// ������� ���� ó���� ����� ��..
		}

		if (num == 1)
		{	
			System.out.print("\t["+ orderTequila.ingName + "] ���� ���緮 : " + orderTequila.getNowQty() + "\t");
			sumqty = orderTequila.getNowQty()+qty;
			orderTequila.setNowQty(sumqty);
			System.out.println("���� �� ���緮 : " + orderTequila.getNowQty());
		}

		else if (num == 2)
		{
			System.out.print("\t["+ orderRum.ingName + "] ���� ���緮 : " + orderRum.getNowQty() + "\t");
			sumqty = orderRum.getNowQty()+qty;
			orderRum.setNowQty(sumqty);
			System.out.println("���� �� ���緮 : " + orderRum.getNowQty());
		}
		else if (num == 3)
		{
			System.out.print("\t["+ orderBrandy.ingName + "] ���� ���緮 : " + orderBrandy.getNowQty() + "\t");
			sumqty = orderBrandy.getNowQty()+qty;
			orderBrandy.setNowQty(sumqty);
			System.out.println("���� �� ���緮 : " + orderBrandy.getNowQty());
		}
		else if (num == 4)
		{
			System.out.print("\t["+ orderVodka.ingName + "] ���� ���緮 : " + orderVodka.getNowQty() + "\t");
			sumqty = orderVodka.getNowQty()+qty;
			orderVodka.setNowQty(sumqty);
			System.out.println("���� �� ���緮 : " + orderVodka.getNowQty());
		}
		else if (num == 5)
		{
			System.out.print("\t["+ orderJin.ingName + "] ���� ���緮 : " + orderJin.getNowQty() + "\t");
			sumqty = orderJin.getNowQty()+qty;
			orderJin.setNowQty(sumqty);
			System.out.println("���� �� ���緮 : " + orderJin.getNowQty());
		}
		
		System.out.print("\t��� ���� �Ͻðڽ��ϱ�?(Y/N) : ");
		select = (char)System.in.read();

		if (select == 'Y' || select == 'y')
			selectOffice();
		System.out.println();
	}
}

// ����� ��Ȳ�� Ŭ������ �޾ƿ��µ�,, �ŷ�ó������ �۾��� Ŭ���� �ȿ��� �̷��������.
// vector�� ����.. 

// ��� Ŭ�����鿡�� ���� ������ �޾ƿ´�..


// �ŷ�ó Ȯ�� Ŭ����
class OkOffice
{
	public static void printOffice()
	{
		System.out.println("----------------------------------------------------------");
		System.out.println("�ŷ�ó�� : (��)ǳ���ֽ�");
		System.out.println();
		System.out.println("�ּ� : ��⵵ ȭ���� ������ ���Ϸ�66 ");
		System.out.println("�ŷ� ǰ�� : �����ֽ� | �����ֽ� | ũ�������ֽ� | ���ξ����ֽ� | ���ť��� ");
		System.out.println("��ȭ��ȣ : 031-8282-8585");
		System.out.println();
		System.out.println();
		System.out.println("�ŷ�ó�� : (��)��������");
		System.out.println();
		System.out.println("�ּ� : ��û���� ��õ�� ��õ��137 ");
		System.out.println("�ŷ� ǰ�� : ��ų�� || �� || �귣�� || ����ī || �� ");
		System.out.println("��ȭ��ȣ : 1544-0909");
		System.out.println();
		System.out.println();
		System.out.println("�ŷ�ó�� : (��)�ѱ�����");
		System.out.println();
		System.out.println("�ּ� : ��⵵ ����� ���յ� �Ⱦ�õ��32 ");
		System.out.println("�ŷ� ǰ�� : ũ��Ŀ || ġ�� || �Ƹ�� ");
		System.out.println("��ȭ��ȣ : 031-8041-1000");
		System.out.println("----------------------------------------------------------");
	}



}