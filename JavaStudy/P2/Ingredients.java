import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

class Lime
{
	private static final String ingName = "�����ֽ�";
	int ingNum = 1;
	private static int minQty = 15;
	private static int nowQty = 100;
	private static String supplier = "(��)ǳ���ֽ�";
	
	// �����ֽ��� ���Ե� �޴� ���

	public static void print_Rmenu()
	{
		System.out.println("������Ÿ");
		System.out.println("��� �Ͽ���");
		System.out.println("�ڽ�������ź");
		System.out.println("�� ����");
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
		System.out.println("��ų�� ���");
		System.out.println("��Ϲ�");
		System.out.println("Ŭ�ι� Ŭ��");
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
		System.out.println("�� ��");
		System.out.println("�ڽ�������ź");
		System.out.println("Ŭ�ι� Ŭ��");
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
		System.out.println("�ǳ� �ݶ��");
		System.out.println("�߷��þ�");
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
		System.out.println("��� �Ͽ���");
		System.out.println("��� ��ī��");
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
	private static int nowQty = 120;
	private static String supplier = "(��)��������";
	
	// ��ų�� ���Ե� �޴� ���
	public static void print_Rmenu()
	{
		System.out.println("������Ÿ");
		System.out.println("�� ��");
		System.out.println("��ų�� ���");
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
		System.out.println("�ǳ� �ݶ��");
		System.out.println("��� �Ͽ���");
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
		System.out.println("�߷��þ�");
		System.out.println("��Ϲ�");
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
		System.out.println("��� ��ī��");
		System.out.println("�ڽ�������ź");
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
		System.out.println("Ŭ�ι� Ŭ��");
		System.out.println("������");
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
				System.out.print("������ �޴��� �����ϼ��� �� 1. ��� �˻�    2. ���� ����    3. ������ �������� �̵�: ");
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
				System.out.println("�߸��� �޴� ��ȣ�Դϴ�.");
			}
		catch (InputMismatchException e1)
		{
			System.out.println("�߸��� �޴� ��ȣ�Դϴ�.");
		}

		catch (IOException e2)
		{
			System.out.println("�߸��� �޴� ��ȣ�Դϴ�.");
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

		System.out.print("���� ���� �޴��� �����ϼ��� �� 1. �ŷ�ó Ȯ��    2. ���� �Է� : ");
		n = sc.nextInt();


		if (n==1)
		{
			// �ŷ�ó Ȯ�� Ŭ����,�޼ҵ� ȣ��
			ok.printOffice();
			
		}
		else if (n==2)
		{
			// ���� �Է� Ŭ�����޼ҵ� ȣ��
			mo.selectOffice();
		}
		
		invent.stockManage();	// ������ ù �������� �̵�

	}
}



// ��� ��¹�, �˻� �� ��Ȳ ��� Ŭ����
class InventoryM 
{
	public static String search;


	// ��� ���� �� ������ִ� �޼ҵ�
	public static void bujok()
	{
		System.out.println("============================================================");

		if (Lime.getNowQty() < Lime.getMinQty())
			System.out.println("�����ӡ���� ��� �����մϴ�");
		if (Lemon.getNowQty() < Lemon.getMinQty())
			System.out.println("��᷹������ ��� �����մϴ�");
		if (Cranberry.getNowQty() < Cranberry.getMinQty())
			System.out.println("���ũ����������� ��� �����մϴ�");
		if (Pineapple.getNowQty() < Pineapple.getMinQty())
			System.out.println("������ξ��á���� ��� �����մϴ�");
		if (BlueCu.getNowQty() < BlueCu.getMinQty())
			System.out.println("����� ť��ҡ���� ��� �����մϴ�");
		if (Cracker.getNowQty() < Cracker.getMinQty())
			System.out.println("���ũ��Ŀ�� ����ᰡ �����մϴ�");
		if (Cheese.getNowQty() < Cheese.getMinQty())
			System.out.println("���ġ������ ��� �����մϴ�");
		if (Almond.getNowQty() < Almond.getMinQty())
			System.out.println("���Ƹ������ ��� �����մϴ�");
		if (Tequila.getNowQty() < Tequila.getMinQty())
			System.out.println("��ᵥų��(���̽�)����� ��� �����մϴ�");
		if (Rum.getNowQty() < Rum.getMinQty())
			System.out.println("��ᷳ(���̽�)����� ��� �����մϴ�");
		if (Brandy.getNowQty() < Brandy.getMinQty())
			System.out.println("���귣��(���̽�)����� ��� �����մϴ�");
		if (Vodka.getNowQty() < Vodka.getMinQty())
			System.out.println("��Ẹ��ī(���̽�)����� ��� �����մϴ�");
		if (Jin.getNowQty() < Jin.getMinQty())
			System.out.println("�����(���̽�)����� ��� �����մϴ�");

		System.out.println("============================================================");
		System.out.println();
	}


	// ��� �˻� �޼ҵ�
	public static void searchI() throws IOException
	{
		InvPage invent = new InvPage();
		Management stock1 = new Management();

		Scanner sc = new Scanner(System.in);

		System.out.print("�˻��� ��Ḧ �Է��ϼ��� : ");
		search = sc.next();

		if (search.equals("�����ֽ�") || search.equals("���� �ֽ�") || search.equals("����")
			|| search.equals("Lime") || search.equals("lime") )
		{
			String na = Lime.getIngName();
			String su = Lime.getSupplier();
			int m = Lime.getMinQty();
			int n = Lime.getNowQty();

			System.out.println("���� : " + na);
			System.out.println("�ּ� ���� : " + m);
			System.out.println("���� ���� : " + n);
			System.out.println("����ó : " + su);
		}

		else if (search.equals("�����ֽ�") || search.equals("���� �ֽ�") || search.equals("����")
			|| search.equals("Lemon") || search.equals("lemon") )
		{
			String na = Lemon.getIngName();
			String su = Lemon.getSupplier();
			int m = Lemon.getMinQty();
			int n = Lemon.getNowQty();

			System.out.println("���� : " + na);
			System.out.println("�ּ� ���� : " + m);
			System.out.println("���� ���� : " + n);
			System.out.println("����ó : " + su);
		}

		else if (search.equals("ũ�������ֽ�") || search.equals("ũ������ �ֽ�") || search.equals("ũ������")
			|| search.equals("Cranberry") || search.equals("cranberry") )
		{
			String na = Cranberry.getIngName();
			String su = Cranberry.getSupplier();
			int m = Cranberry.getMinQty();
			int n = Cranberry.getNowQty();

			System.out.println("���� : " + na);
			System.out.println("�ּ� ���� : " + m);
			System.out.println("���� ���� : " + n);
			System.out.println("����ó : " + su);
		}

		else if (search.equals("���ξ����ֽ�") || search.equals("���ξ��� �ֽ�") || search.equals("���ξ���")
			|| search.equals("Pineapple") || search.equals("pinapple") )
		{
			String na = Pineapple.getIngName();
			String su = Pineapple.getSupplier();
			int m = Pineapple.getMinQty();
			int n = Pineapple.getNowQty();

			System.out.println("���� : " + na);
			System.out.println("�ּ� ���� : " + m);
			System.out.println("���� ���� : " + n);
			System.out.println("����ó : " + su);
		}

		else if (search.equals("���ť���") || search.equals("��� ť���") 
			|| search.equals("BlueCu") || search.equals("bluecu") )
		{
			String na = BlueCu.getIngName();
			String su = BlueCu.getSupplier();
			int m = BlueCu.getMinQty();
			int n = BlueCu.getNowQty();

			System.out.println("���� : " + na);
			System.out.println("�ּ� ���� : " + m);
			System.out.println("���� ���� : " + n);
			System.out.println("����ó : " + su);
		}

		else if (search.equals("ũ��Ŀ") || search.equals("Cracker") || search.equals("cracker") )
		{
			String na = Cracker.getIngName();
			String su = Cracker.getSupplier();
			int m = Cracker.getMinQty();
			int n = Cracker.getNowQty();

			System.out.println("���� : " + na);
			System.out.println("�ּ� ���� : " + m);
			System.out.println("���� ���� : " + n);
			System.out.println("����ó : " + su);
		}

		else if (search.equals("ġ��") || search.equals("Cheese") || search.equals("cheese") )
		{
			String na = Cheese.getIngName();
			String su = Cheese.getSupplier();
			int m = Cheese.getMinQty();
			int n = Cheese.getNowQty();

			System.out.println("���� : " + na);
			System.out.println("�ּ� ���� : " + m);
			System.out.println("���� ���� : " + n);
			System.out.println("����ó : " + su);
		}

		else if (search.equals("�Ƹ��") || search.equals("Almond") || search.equals("almond") )
		{
			String na = Almond.getIngName();
			String su = Almond.getSupplier();
			int m = Almond.getMinQty();
			int n = Almond.getNowQty();

			System.out.println("���� : " + na);
			System.out.println("�ּ� ���� : " + m);
			System.out.println("���� ���� : " + n);
			System.out.println("����ó : " + su);
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

			System.out.println("���� : " + na);
			System.out.println("�ּ� ���� : " + m);
			System.out.println("���� ���� : " + n);
			System.out.println("����ó : " + su);
		}

		else if (search.equals("�귣��") || search.equals("Brandy") || search.equals("brandy") )
		{
			String na = Brandy.getIngName();
			String su = Brandy.getSupplier();
			int m = Brandy.getMinQty();
			int n = Brandy.getNowQty();

			System.out.println("���� : " + na);
			System.out.println("�ּ� ���� : " + m);
			System.out.println("���� ���� : " + n);
			System.out.println("����ó : " + su);
		}

		else if (search.equals("����ī") || search.equals("Vodka") || search.equals("vodka") )
		{
			String na = Vodka.getIngName();
			String su = Vodka.getSupplier();
			int m = Vodka.getMinQty();
			int n = Vodka.getNowQty();

			System.out.println("���� : " + na);
			System.out.println("�ּ� ���� : " + m);
			System.out.println("���� ���� : " + n);
			System.out.println("����ó : " + su);
		}

		else if (search.equals("��") || search.equals("Jin") || search.equals("jin") )
		{
			String na = Jin.getIngName();
			String su = Jin.getSupplier();
			int m = Jin.getMinQty();
			int n = Jin.getNowQty();

			System.out.println("���� : " + na);
			System.out.println("�ּ� ���� : " + m);
			System.out.println("���� ���� : " + n);
			System.out.println("����ó : " + su);
		}

		else
		{
			System.out.printf("�Է��Ͻ� ��� (%s) �� �����ϴ�.\n",search);
			System.out.println();
			// �Է��� ��ᰡ ���� ����� ��� ������ ù �������� ���ư���
			invent.stockManage();
		}	

		System.out.println();	// ����


		// ��Ȳ ��� �� ���� �Է��� �����
		InventoryM.inputJe();
	}



	// ��� �Է��� ����� �޼ҵ�
	public static void inputJe() throws IOException
	{
		MainOffice mo = new MainOffice();
		InvPage invent = new InvPage();
		char n;

		Scanner sc = new Scanner(System.in);

		System.out.print("��Ḧ �����Ͻðڽ��ϱ�? (Y/N)");
		n = (char)System.in.read();
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





public class Ingredients 
{
	public static void main(String[] args) throws IOException
	{
	


		

	}
}
