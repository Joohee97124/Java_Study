import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

class Lime
{
	private static final String ingName = "�����ֽ�";
	int ingNum = 1;
	private static int minQty = 15;
	private static int nowQty = 200;
	private static String supplier = "(��)ǳ���ֽ�";
	
	// �����ֽ��� ���Ե� �޴� ���

	public static void print_Rmenu()
	{
		System.out.println("\t������Ÿ");
		System.out.println("\t��� �Ͽ���");
		System.out.println("\t�ڽ�������ź");
		System.out.println("\t�� ����");
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
	private static final String ingName = "�����ֽ�";
	int ingNum = 2;
	private static int minQty = 15;
	private static int nowQty = 100;
	private static String supplier = "(��)ǳ���ֽ�";

	// �����ֽ��� ���Ե� �޴� ���

	public static void print_Rmenu()
	{
		System.out.println("\t��ų�� ���");
		System.out.println("\t��Ϲ�");
		System.out.println("\tŬ�ι� Ŭ��");
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
	private static final String ingName = "ũ�������ֽ�";
	int ingNum = 3;
	private static int minQty = 15;
	private static int nowQty = 0;
	private static String supplier = "(��)ǳ���ֽ�";

	// ũ�������ֽ��� ���Ե� �޴� ���

	public static void print_Rmenu()
	{
		System.out.println("\t�� ��");
		System.out.println("\t�ڽ�������ź");
		System.out.println("\tŬ�ι� Ŭ��");
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
	private static final String ingName = "���ξ����ֽ�";
	int ingNum = 4;
	private static int minQty = 20;
	private static int nowQty = 100;
	private static String supplier = "(��)ǳ���ֽ�";

	// ���ξ����ֽ��� ���Ե� �޴� ���

	public static void print_Rmenu()
	{
		System.out.println("\t�ǳ� �ݶ��");
		System.out.println("\t�߷��þ�");
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
	private static final String ingName = "���ť���";
	int ingNum = 5;
	private static int minQty = 10;
	private static int nowQty = 100;
	private static String supplier = "(��)ǳ���ֽ�";

	// ���ť��Ұ� ���Ե� �޴� ���

	public static void print_Rmenu()
	{
		System.out.println("\t��� �Ͽ���");
		System.out.println("\t��� ��ī��");
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
	private static final String ingName = "ũ��Ŀ";
	int ingNum = 6;
	private static int minQty = 0 ;
	private static int nowQty = 20;
	private static String supplier = "(��)�ѱ�����";

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
	private static final String ingName = "ġ��";
	int ingNum = 7;
	private static int minQty = 10;
	private static int nowQty = 50;
	private static String supplier = "(��)�ѱ�����";

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
	private static final String ingName = "�Ƹ��";
	int ingNum = 8;
	private static int minQty = 10;
	private static int nowQty = 200;
	private static String supplier = "(��)�ѱ�����";

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
	private static final String ingName = "��ų��";
	int ingNum = 9;
	private static int minQty = 30;
	private static int nowQty = 240;
	private static String supplier = "(��)��������";
	
	// ��ų�� ���Ե� �޴� ���
	public static void print_Rmenu()
	{
		System.out.println("\t������Ÿ");
		System.out.println("\t�� ��");
		System.out.println("\t��ų�� ���");
	}
	
	public static String getIngName()
	{
		return ingName;
	}

	public static String getSupplier()
	{
		return supplier;
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
	private static final String ingName = "��";
	int ingNum = 10;
	private static int minQty = 30;
	private static int nowQty = 210;
	private static String supplier = "(��)��������";

	// ���� ���Ե� �޴� ���
	public static void print_Rmenu()
	{
		System.out.println("\t�ǳ� �ݶ��");
		System.out.println("\t��� �Ͽ���");
	}

	public static String getIngName()
	{
		return ingName;
	}

	public static String getSupplier()
	{
		return supplier;
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
	private static final String ingName = "�귣��";
	int ingNum = 11;
	private static int minQty = 25;
	private static int nowQty = 0;
	private static String supplier = "(��)��������";

	// �귣�� ���Ե� �޴� ���
	public static void print_Rmenu()
	{
		System.out.println("\t�߷��þ�");
		System.out.println("\t��Ϲ�");
	}
	
	public static String getIngName()
	{
		return ingName;
	}

	public static String getSupplier()
	{
		return supplier;
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
	private static final String ingName = "����ī";
	int ingNum = 12;
	private static int minQty = 10;
	private static int nowQty = 200;
	private static String supplier = "(��)��������";

	// ����ī�� ���Ե� �޴� ���
	public static void print_Rmenu()
	{
		System.out.println("\t��� ��ī��");
		System.out.println("\t�ڽ�������ź");
	}

	
	public static String getIngName()
	{
		return ingName;
	}

	public static String getSupplier()
	{
		return supplier;
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
	private static final String ingName = "��";
	int ignNum = 13;
	private static int minQty = 45;
	private static int nowQty = 250;
	private static String supplier = "(��)��������";

	// ���� ���Ե� �޴� ���
	public static void print_Rmenu()
	{
		System.out.println("\tŬ�ι� Ŭ��");
		System.out.println("\t������");
	}

	public static String getIngName()
	{
		return ingName;
	}

	public static String getSupplier()
	{
		return supplier;
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



// �������� ù ������ (�޴�) Ŭ����
class InvPage
{
	
	public static void stockManage() 
	{
		valPage vp = new valPage();
		
		try
		{
			int n;
			Management stock1 = new Management();

			InventoryM.bujok();		// ���� ���� ��¹�
			
			Scanner sc = new Scanner(System.in);

			do
			{
				System.out.print("\t������ �޴��� �����ϼ��� �� 1. ��� �˻�    2. ���� ����    3. ������ �������� �̵�: ");
				n = sc.nextInt();
				System.out.println();
			}
			while (n<1 || n>3);
			// 1-3 �̿��� �޴� ��ȣ �Է� �� �޴� ���� �ٽ� �ݺ�


			if (n==1)
			{	// ��� �˻� ȣ��
				InventoryM.searchI();

			}
			
			else if (n==2)
			{
				// ���� ���� �޴� ������ ȣ��
				vp.valMenu1();
			}
			
			else if (n==3)
			{ // ������ ù �޴� ������ ȣ��
				stock1.managerMenu();
			}
			else 
				System.out.println("\t�߸��� �޴� ��ȣ�Դϴ�.");
			}
		catch (InputMismatchException e1)
		{
			System.out.println("\t�߸��� �޴� ��ȣ�Դϴ�.");
		}

		catch (IOException e2)
		{
			System.out.println("\t�߸��� �޴� ��ȣ�Դϴ�.");
		}
	}
}



// �ŷ�ó ���� ������ (�޴�) Ŭ����
class valPage
{
	public static int n;

	public static void valMenu1() throws IOException
	{
		MainOffice mo = new MainOffice();
		OkOffice ok = new OkOffice();
		InvPage invent = new InvPage();

		Scanner sc = new Scanner(System.in);

		System.out.print("\t���� ���� �޴��� �����ϼ��� �� 1. �ŷ�ó Ȯ��    2. ���� �Է� : ");
		n = sc.nextInt();


		if (n==1)
		{
			// �ŷ�ó Ȯ�� Ŭ����,�޼ҵ� ȣ��
			ok.printOffice();
			invent.stockManage();	// ������ ù �������� �̵�
			
		}
		else if (n==2)
		{
			// ���� �Է� Ŭ�����޼ҵ� ȣ��
			mo.selectOffice();
		}
	}
}



// ��� ��¹�, �˻� �� ��Ȳ ��� Ŭ����
class InventoryM 
{
	public static String search;


	// ��� ���� �� ������ִ� �޼ҵ�
	public static void bujok()
	{
		System.out.println("\t======================================================================================");

		if (Lime.getNowQty() < Lime.getMinQty())
			System.out.println("\t�����ӡ���� ��� �����մϴ�");
		if (Lemon.getNowQty() < Lemon.getMinQty())
			System.out.println("\t��᷹������ ��� �����մϴ�");
		if (Cranberry.getNowQty() < Cranberry.getMinQty())
			System.out.println("\t���ũ����������� ��� �����մϴ�");
		if (Pineapple.getNowQty() < Pineapple.getMinQty())
			System.out.println("\t������ξ��á���� ��� �����մϴ�");
		if (BlueCu.getNowQty() < BlueCu.getMinQty())
			System.out.println("\t����� ť��ҡ���� ��� �����մϴ�");
		if (Cracker.getNowQty() < Cracker.getMinQty())
			System.out.println("\t���ũ��Ŀ����� ��� �����մϴ�");
		if (Cheese.getNowQty() < Cheese.getMinQty())
			System.out.println("\t���ġ������ ��� �����մϴ�");
		if (Almond.getNowQty() < Almond.getMinQty())
			System.out.println("\t���Ƹ������ ��� �����մϴ�");
		if (Tequila.getNowQty() < Tequila.getMinQty())
			System.out.println("\t��ᵥų��(���̽�)����� ��� �����մϴ�");
		if (Rum.getNowQty() < Rum.getMinQty())
			System.out.println("\t��ᷳ(���̽�)����� ��� �����մϴ�");
		if (Brandy.getNowQty() < Brandy.getMinQty())
			System.out.println("\t���귣��(���̽�)����� ��� �����մϴ�");
		if (Vodka.getNowQty() < Vodka.getMinQty())
			System.out.println("\t��Ẹ��ī(���̽�)����� ��� �����մϴ�");
		if (Jin.getNowQty() < Jin.getMinQty())
			System.out.println("\t�����(���̽�)����� ��� �����մϴ�");

		System.out.println("\t======================================================================================");
		System.out.println();
	}


	// ��� �˻� �޼ҵ�
	public static void searchI() throws IOException
	{
		InvPage invent = new InvPage();
		Management stock1 = new Management();

		Scanner sc = new Scanner(System.in);

		System.out.print("\t�˻��� ��Ḧ �Է��ϼ��� : ");
		search = sc.next();

		if (search.equals("�����ֽ�") || search.equals("���� �ֽ�") || search.equals("����")
			|| search.equals("Lime") || search.equals("lime") )
		{
			String na = Lime.getIngName();
			String su = Lime.getSupplier();
			int m = Lime.getMinQty();
			int n = Lime.getNowQty();

			System.out.println("\t���� : " + na);
			System.out.println("\t�ּ� ���� : " + m);
			System.out.println("\t���� ���� : " + n);
			System.out.println("\t����ó : " + su);
		}

		else if (search.equals("�����ֽ�") || search.equals("���� �ֽ�") || search.equals("����")
			|| search.equals("Lemon") || search.equals("lemon") )
		{
			String na = Lemon.getIngName();
			String su = Lemon.getSupplier();
			int m = Lemon.getMinQty();
			int n = Lemon.getNowQty();

			System.out.println("\t���� : " + na);
			System.out.println("\t�ּ� ���� : " + m);
			System.out.println("\t���� ���� : " + n);
			System.out.println("\t����ó : " + su);
		}

		else if (search.equals("ũ�������ֽ�") || search.equals("ũ������ �ֽ�") || search.equals("ũ������")
			|| search.equals("Cranberry") || search.equals("cranberry") )
		{
			String na = Cranberry.getIngName();
			String su = Cranberry.getSupplier();
			int m = Cranberry.getMinQty();
			int n = Cranberry.getNowQty();

			System.out.println("\t���� : " + na);
			System.out.println("\t�ּ� ���� : " + m);
			System.out.println("\t���� ���� : " + n);
			System.out.println("\t����ó : " + su);
		}

		else if (search.equals("���ξ����ֽ�") || search.equals("���ξ��� �ֽ�") || search.equals("���ξ���")
			|| search.equals("Pineapple") || search.equals("pinapple") )
		{
			String na = Pineapple.getIngName();
			String su = Pineapple.getSupplier();
			int m = Pineapple.getMinQty();
			int n = Pineapple.getNowQty();

			System.out.println("\t���� : " + na);
			System.out.println("\t�ּ� ���� : " + m);
			System.out.println("\t���� ���� : " + n);
			System.out.println("\t����ó : " + su);
		}

		else if (search.equals("���ť���") || search.equals("��� ť���") 
			|| search.equals("BlueCu") || search.equals("bluecu") )
		{
			String na = BlueCu.getIngName();
			String su = BlueCu.getSupplier();
			int m = BlueCu.getMinQty();
			int n = BlueCu.getNowQty();

			System.out.println("\t���� : " + na);
			System.out.println("\t�ּ� ���� : " + m);
			System.out.println("\t���� ���� : " + n);
			System.out.println("\t����ó : " + su);
		}

		else if (search.equals("ũ��Ŀ") || search.equals("Cracker") || search.equals("cracker") )
		{
			String na = Cracker.getIngName();
			String su = Cracker.getSupplier();
			int m = Cracker.getMinQty();
			int n = Cracker.getNowQty();

			System.out.println("\t���� : " + na);
			System.out.println("\t�ּ� ���� : " + m);
			System.out.println("\t���� ���� : " + n);
			System.out.println("\t����ó : " + su);
		}

		else if (search.equals("ġ��") || search.equals("Cheese") || search.equals("cheese") )
		{
			String na = Cheese.getIngName();
			String su = Cheese.getSupplier();
			int m = Cheese.getMinQty();
			int n = Cheese.getNowQty();

			System.out.println("\t���� : " + na);
			System.out.println("\t�ּ� ���� : " + m);
			System.out.println("\t���� ���� : " + n);
			System.out.println("\t����ó : " + su);
		}

		else if (search.equals("�Ƹ��") || search.equals("Almond") || search.equals("almond") )
		{
			String na = Almond.getIngName();
			String su = Almond.getSupplier();
			int m = Almond.getMinQty();
			int n = Almond.getNowQty();

			System.out.println("\t���� : " + na);
			System.out.println("\t�ּ� ���� : " + m);
			System.out.println("\t���� ���� : " + n);
			System.out.println("\t����ó : " + su);
		}

		else if (search.equals("��ų��") || search.equals("������") || search.equals("Tequila") || search.equals("tequila") )
		{
			String na = Tequila.getIngName();
			String su = Tequila.getSupplier();
			int m = Tequila.getMinQty();
			int n = Tequila.getNowQty();

			System.out.println("���� : " + na);
			System.out.println("�ּ� ���� : " + m);
			System.out.println("���� ���� : " + n);
			System.out.println("����ó : " + su);
		}

		else if (search.equals("��") || search.equals("Rum") || search.equals("rum") )
		{
			String na = Rum.getIngName();
			String su = Rum.getSupplier();
			int m = Rum.getMinQty();
			int n = Rum.getNowQty();

			System.out.println("\t���� : " + na);
			System.out.println("\t�ּ� ���� : " + m);
			System.out.println("\t���� ���� : " + n);
			System.out.println("\t����ó : " + su);
		}

		else if (search.equals("�귣��") || search.equals("Brandy") || search.equals("brandy") )
		{
			String na = Brandy.getIngName();
			String su = Brandy.getSupplier();
			int m = Brandy.getMinQty();
			int n = Brandy.getNowQty();

			System.out.println("\t���� : " + na);
			System.out.println("\t�ּ� ���� : " + m);
			System.out.println("\t���� ���� : " + n);
			System.out.println("\t����ó : " + su);
		}

		else if (search.equals("����ī") || search.equals("Vodka") || search.equals("vodka") )
		{
			String na = Vodka.getIngName();
			String su = Vodka.getSupplier();
			int m = Vodka.getMinQty();
			int n = Vodka.getNowQty();

			System.out.println("\t���� : " + na);
			System.out.println("\t�ּ� ���� : " + m);
			System.out.println("\t���� ���� : " + n);
			System.out.println("\t����ó : " + su);
		}

		else if (search.equals("��") || search.equals("Jin") || search.equals("jin") )
		{
			String na = Jin.getIngName();
			String su = Jin.getSupplier();
			int m = Jin.getMinQty();
			int n = Jin.getNowQty();

			System.out.println("\t���� : " + na);
			System.out.println("\t�ּ� ���� : " + m);
			System.out.println("\t���� ���� : " + n);
			System.out.println("\t����ó : " + su);
		}

		else
		{
			System.out.printf("\t�Է��Ͻ� ��� (%s) �� �����ϴ�.\n",search);
			System.out.println();
			// �Է��� ��ᰡ ���� ����� ��� ������ ù �������� ���ư���
			invent.stockManage();
		}	

		System.out.println();	// ����


		// ��Ȳ ��� �� ���� �Է��� �����
		InventoryM.inputJe();
		System.in.skip(2);
	}



	// ��� �Է��� ����� �޼ҵ�
	public static void inputJe() throws IOException
	{
		Management mg = new Management();
		MainOffice mo = new MainOffice();
		InvPage invent = new InvPage();
		char n;

		Scanner sc = new Scanner(System.in);

		System.out.print("\t��� ���� �Ͻðڽ��ϱ�?(Y/N) : ");
		n = (char)System.in.read();
		System.in.skip(2);
		System.out.println();

		if (n == 'y' || n == 'Y')
		{
			// ����Է� Ŭ����.�޼ҵ� ȣ��
			mo.selectOffice();
		}
		else 
			invent.stockManage();
	}
}


class StackStop
{
	// ��� ���� �޼ҵ� (�⺻ ������)
	public void StackMin1() throws IOException
	{
		MenuUser mu = new MenuUser();
		int b = mu.bQ;
		int i = mu.iQ;
		int base = mu.iBase;
		int cak = mu.iCak;

		if (base == 0 )
		{
			
			if (cak == 1)
			{
				int tequila1 = Tequila.getNowQty();
				int tequila2 = tequila1 - 30;
				Tequila.setNowQty(tequila2);

				int lime1 = Lime.getNowQty();
				int lime2 = lime1 - 15;
				Lime.setNowQty(lime2);
			}
			else if (cak == 2)
			{
				int tequila1 = Tequila.getNowQty();
				int tequila2 = tequila1 - 35;
				Tequila.setNowQty(tequila2);

				int cranberry1 = Cranberry.getNowQty();
				int cranberry2 = cranberry1 - 90;
				Cranberry.setNowQty(cranberry2);
			}
			else if (cak == 3)
			{
				int tequila1 = Tequila.getNowQty();
				int tequila2 = tequila1 - 60;
				Tequila.setNowQty(tequila2);

				int lemon1 = Lemon.getNowQty();
				int lemon2 = lemon1 - 15;
				Lemon.setNowQty(lemon2);
			}
		}

		if (base == 1)
		{
			int rum1 = Rum.getNowQty();
			int rum2 = rum1 - 30;
			Rum.setNowQty(rum2);

			if (cak == 1)
			{
				int pineapple1 = Pineapple.getNowQty();
				int pineapple2 = pineapple1 - 90;
				Pineapple.setNowQty(pineapple2);
			}
			else if (cak == 2)
			{
				int lime1 = Lime.getNowQty();
				int lime2 = lime1 - 30;
				Lime.setNowQty(lime2);
			}
		}

		if (base == 2)
		{
			int brandy1 = Brandy.getNowQty();
			int brandy2 = brandy1 - b;
			Brandy.setNowQty(brandy2);

			if (cak == 1)
			{
				int brandy12 = Brandy.getNowQty();
				int brandy22 = brandy12 - 40;
				Brandy.setNowQty(brandy2);

				int pineapple1 = Pineapple.getNowQty();
				int pineapple2 = pineapple1 - 20;
				Pineapple.setNowQty(pineapple2);
			}
			else if (cak == 2)
			{
				int brandy12 = Brandy.getNowQty();
				int brandy22 = brandy12 - 25;
				Brandy.setNowQty(brandy22);

				int lemon1 = Lemon.getNowQty();
				int lemon2 = lemon1 - 30;
				Lemon.setNowQty(lemon2);
			}
		}

		if (base == 3)
		{
			int vodka12 = Vodka.getNowQty();
			int vodka22 = vodka12 - b;
			Vodka.setNowQty(vodka22);


			if (cak == 1)
			{
				int vodka1 = Vodka.getNowQty();
				int vodka2 = vodka1 - 10;
				Vodka.setNowQty(vodka2);

				int bluecu1 = BlueCu.getNowQty();
				int bluecu2 = bluecu1 - 10;
				BlueCu.setNowQty(bluecu2);
			}
			else if (cak == 2)
			{
				int vodka1 = Vodka.getNowQty();
				int vodka2 = vodka1 - 30;
				Vodka.setNowQty(vodka2);

				int lime1 = Lime.getNowQty();
				int lime2 = lime1 - 15;
				Lime.setNowQty(lime2);
			}

		}

		if (base == 4)
		{
			if (cak == 1)
			{
				int jin12 = Jin.getNowQty();
				int jin22 = jin12 - 60;
				Jin.setNowQty(jin22);

				int lemon1 = Lemon.getNowQty();
				int lemon2 = lemon1 - 15;
				Lemon.setNowQty(lemon2);
			}
			else if (cak == 2)
			{
				int jin12 = Jin.getNowQty();
				int jin22 = jin12 - 45;
				Jin.setNowQty(jin22);

				int lime1 = Lime.getNowQty();
				int lime2 = lime1 - 15;
				Lime.setNowQty(lime2);
			}
		}		
	}


	// ��� ���� �޼ҵ� (Ŀ���� ������)
	public void StackMin2() throws IOException
	{
		MenuUser mu = new MenuUser();
		int b = mu.bQ;
		int i = mu.iQ;
		int base = mu.iBase;
		int cak = mu.iCak;

		if (base == 0 )
		{
			int tequila1 = Tequila.getNowQty();
			int tequila2 = tequila1 - b;
			Tequila.setNowQty(tequila2);
			
			if (cak == 1)
			{
				int lime1 = Lime.getNowQty();
				int lime2 = lime1 - b;
				Lime.setNowQty(lime2);
			}
			else if (cak == 2)
			{
				int cranberry1 = Cranberry.getNowQty();
				int cranberry2 = cranberry1 - b;
				Cranberry.setNowQty(cranberry2);
			}
			else if (cak == 3)
			{
				int lemon1 = Lemon.getNowQty();
				int lemon2 = lemon1 - b;
				Lemon.setNowQty(lemon2);
			}
		}

		if (base == 1)
		{
			int rum1 = Rum.getNowQty();
			int rum2 = rum1 - b;
			Rum.setNowQty(rum2);

			if (cak == 1)
			{
				int pineapple1 = Pineapple.getNowQty();
				int pineapple2 = pineapple1 - b;
				Pineapple.setNowQty(pineapple2);
			}
			else if (cak == 2)
			{
				int lime1 = Lime.getNowQty();
				int lime2 = lime1 - b;
				Lime.setNowQty(lime2);
			}
		}

		if (base == 2)
		{
			int brandy1 = Brandy.getNowQty();
			int brandy2 = brandy1 - b;
			Brandy.setNowQty(brandy2);

			if (cak == 1)
			{
				int pineapple1 = Pineapple.getNowQty();
				int pineapple2 = pineapple1 - b;
				Pineapple.setNowQty(pineapple2);
			}
			else if (cak == 2)
			{
				int lemon1 = Lemon.getNowQty();
				int lemon2 = lemon1 - b;
				Lemon.setNowQty(lemon2);
			}
		}

		if (base == 3)
		{
			int vodka1 = Vodka.getNowQty();
			int vodka2 = vodka1 - b;
			Vodka.setNowQty(vodka2);


			if (cak == 1)
			{
				int bluecu1 = BlueCu.getNowQty();
				int bluecu2 = bluecu1 - b;
				BlueCu.setNowQty(bluecu2);
			}
			else if (cak == 2)
			{
				int lime1 = Lime.getNowQty();
				int lime2 = lime1 - b;
				Lime.setNowQty(lime2);
			}

		}

		if (base == 4)
		{
			int jin1 = Jin.getNowQty();
			int jin2 = jin1 - b;
			Jin.setNowQty(jin2);


			if (cak == 1)
			{
				int lemon1 = Lemon.getNowQty();
				int lemon2 = lemon1 - b;
				Lemon.setNowQty(lemon2);
			}
			else if (cak == 2)
			{
				int lime1 = Lime.getNowQty();
				int lime2 = lime1 - b;
				Lime.setNowQty(lime2);
			}
		}		
	}
}






public class Ingredients 
{
	public static void main(String[] args) throws IOException
	{
		Login l = new Login();
		l.defaultInfo();
		l.start();


		

	}
}
