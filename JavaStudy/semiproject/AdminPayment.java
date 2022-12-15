
import java.util.Scanner;
import java.util.Calendar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;


class SalesManagement extends Cash
{
	String buyer;								// MemberInfo������ �ޱ� ���� ���ο��� ��ġ��Ű�� �̸�
	String select;								// ����ڷκ��� �Է¹��� �޴� ����
	Calendar now = Calendar.getInstance();

	int arrTotal;								// ���� �� Ȯ���� �� �ִ� �� �����

	SalesManagement() throws IOException
	{
		
	}

	// ������Ȳ Ȯ�� or ���� Ȯ��, �Է� �޴� ����
	public void showChoice() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		// �޴� ����
		try
		{
			System.out.println();
			System.out.println();
			System.out.println("\t======================================================================================");	
			System.out.println();
			System.out.println("\t\t1. ���� ��Ȳ Ȯ��");
			System.out.println("\t\t2. ���� Ȯ�� �� �Է�");
			System.out.println();
			System.out.println("\t======================================================================================");	
			System.out.print("\t    ���Ͻô� �޴��� �������ּ��� : ");
			select = sc.next();

			if (!select.equals("1") && !select.equals("2"))
				throw new choiceException(select);
		}//try�� �ݱ�
		catch (choiceException e)
		{
			e.showWrongChoice();
			System.out.println("\t������ ó������ �ٽ� �����մϴ�.");
			this.choiceMenu();
		}//catch �� �ݱ�

		switch (select)
		{
			case "1": this.choiceMenu(); break;
			case "2": this.choiceMoney(); break;
		}
		
	}//showChoice ��
	

	// ������Ȳ ���� ��� ���� �޴�
	public void choiceMenu() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		// �޴� ����
		try
		{
			System.out.println();
			System.out.println();
			System.out.println("\t=========================================================================================================");
			System.out.println();
			System.out.println("\t\t1. ���ں� ������Ȳ");
			System.out.println("\t\t2. �޴��� ������Ȳ");
			System.out.println("\t\t3. ȸ���� ��������");
			System.out.println("\t\t4. �������ܺ� ������Ȳ");
			System.out.println("\t\t5. ��ǥ����װ� �޼���");
			System.out.println("\t\t6. ������ ���� ȭ������ ���ư���");
			System.out.println();
			System.out.println("\t=========================================================================================================");
			System.out.print("\t    ���Ͻô� �޴��� �������ּ��� : ");
			select = sc.next();

			if (!select.equals("1") && !select.equals("2") && !select.equals("3") && !select.equals("4") && !select.equals("5") && !select.equals("6"))
				throw new choiceException(select);
		}//try�� �ݱ�
		catch (choiceException e)
		{
			e.showWrongChoice();
			System.out.println("\t������ ó������ �ٽ� �����մϴ�.");
			this.choiceMenu();
		}//catch �� �ݱ�

		switch (select)
		{
			case "1": this.dateArray(); break;
			case "2": this.menuArray(); break;
			case "3": this.memberArray(); break;
			case "4": this.cardCashArray(); break;
			case "5": this.goalArray(); break;
			case "6": managerMenu(); break;
		}
	} //choiceMenu ��

	// MemberInfo�ڷ����� ������ ArrayList �ڷᱸ���� ����ؼ�
	// ������Ȳ ��� �� �ʿ��� �����͵��� �ѹ��� ���, ���ϴ� ��Ĵ�� �����ؼ� ����ϱ� ���� Ŭ����
	//�� ���ں� / �޴��� / ȸ���� / �������ܺ��� <Ŭ����>�� ����, ���� ������ �ٸ��� �������̵���

	// ���� ��� �� Ȯ���ϱ� ���� ���� ������ �߰�
	public void defaultData()
	{

		list.add(new MemberInfo(2021, 3, 15, "������", "�߷��þ�", 1, 20000, "ī��"));
		list.add(new MemberInfo(2021, 3, 16, "������", "��� �Ͽ���", 1, 10000, "ī��"));
		list.add(new MemberInfo(2021, 3, 17, "������", "������Ÿ", 1, 10000, "����"));
		list.add(new MemberInfo(2021, 3, 18, "������", "�� ����", 1, 10000, "����"));

		list.add(new MemberInfo(2021, 3, 15, "�谡��", "��ų�� ���", 1, 10000, "ī��"));
		list.add(new MemberInfo(2021, 3, 16, "�谡��", "�ڽ�������ź", 1, 18000, "ī��"));
		list.add(new MemberInfo(2021, 3, 17, "�谡��", "�� ��", 1, 10000, "����"));
		list.add(new MemberInfo(2021, 3, 18, "�谡��", "��Ϲ�", 1, 20000, "����"));

		list.add(new MemberInfo(2021, 3, 15, "������", "Ŭ�ι� Ŭ��", 1, 10000, "ī��"));
		list.add(new MemberInfo(2021, 3, 16, "������", "�ǳ� �ݶ��", 1, 15000, "ī��"));
		list.add(new MemberInfo(2021, 3, 17, "������", "�߷��þ�", 1, 20000, "����"));
		list.add(new MemberInfo(2021, 3, 18, "������", "ũ��Ŀ", 4, 12000, "����"));

		list.add(new MemberInfo(2021, 3, 15, "������", "�Ƹ��", 5, 10000, "ī��"));
		list.add(new MemberInfo(2021, 3, 16, "������", "��� �Ͽ���", 1, 15000, "ī��"));
		list.add(new MemberInfo(2021, 3, 17, "������", "�߷��þ�", 1, 20000, "����"));
		list.add(new MemberInfo(2021, 3, 18, "������", "��ų�� ���", 1, 10000, "����"));

		list.add(new MemberInfo(2021, 3, 15, "������", "������Ÿ", 1, 10000, "ī��"));
		list.add(new MemberInfo(2021, 3, 16, "������", "�ڽ�������ź", 1, 18000, "ī��"));
		list.add(new MemberInfo(2021, 3, 17, "������", "��� �Ͽ���", 1, 10000, "����"));
		list.add(new MemberInfo(2021, 3, 18, "������", "ũ��Ŀ", 5, 15000, "����"));
	}

	// ���ں� ������Ȳ
	public void dateArray() throws IOException
	{
		DateArray dateArray = new DateArray();
		int arrTot1 = 0;
			
		Collections.sort(list, dateArray);

		System.out.println();
		System.out.println();

		System.out.println();
		System.out.println("\t========================================= [ ���ں� ������Ȳ ] ===========================================");	
		System.out.println();
		System.out.println("\t  No   \t\t�����ð�\t\t  �����޴�\t������\t ����\t�����ݾ�\t��������");
		System.out.println("\t=========================================================================================================");	
		
		ListIterator it = list.listIterator();
		int num=0;

		while (it.hasNext())
		{
			MemberInfo obj = (MemberInfo)it.next();

			if (obj.getD()!=0)
			{
				num++;
				System.out.printf("\t  %2d\t\t%4d�� %2d�� %2d��\t%6s\t%3s\t%d��\t%,d\t\t%s\n",
				num, obj.getY(), obj.getM(), obj.getD(), obj.getMainMenu(),
				obj.getName(), obj.getMainCount(), obj.getEveryTotal(), obj.getStrHow());
			}
			arrTot1 += obj.getEveryTotal();
		}
		System.out.println();	
		
		System.out.println("\t=========================================================================================================");	
		System.out.printf("\t  �� �����: %,d��\n", arrTot1);
		System.out.println("\t=========================================================================================================");	
		
		choiceMenu();
	}


	// �޴��� ������Ȳ>>> ���� �޴� ���� �������� ����
	public void menuArray() throws IOException
	{
		
		// �޴� �������� �������� �����ϱ� ���� ���� ���� �������̵��� Ŭ���� �ν��Ͻ� ����
		MenuArray menuArray = new MenuArray();
		int arrTot2 = 0;

		// �޴����� �������� ���� �� ���
		Collections.sort(list, menuArray);
		
		System.out.println();
		System.out.println();
		System.out.println("\t========================================= [ �޴��� ������Ȳ ] ===========================================");	
		System.out.println();
		System.out.println("\t  No   \t �����޴�\t\t  �����ð�\t\t������\t ����\t�����ݾ�\t��������");
		System.out.println("\t=========================================================================================================");
		
		ListIterator it = list.listIterator();
		int num=0;

		while (it.hasNext())
		{
			MemberInfo obj = (MemberInfo)it.next();

			if (obj.getMainMenu()!="����")
			{
				num++;
				System.out.printf("\t  %2d   \t%6s\t\t%4d�� %2d�� %2d��\t%3s\t%d��\t%,d\t\t%s\n",
				num, obj.getMainMenu(), obj.getY(), obj.getM(), obj.getD(), 
				obj.getName(), obj.getMainCount(), obj.getEveryTotal(), obj.getStrHow());
			}
			arrTot2 += obj.getEveryTotal();

		}
		
		System.out.println();	
		
		System.out.println("\t=========================================================================================================");	
		System.out.printf("\t  �� �����: %,d��\n", arrTot2);
		System.out.println("\t=========================================================================================================");	
		
		choiceMenu();
	}


	// ȸ���� ������Ȳ >>>�̸� ���� ������������
	public void memberArray() throws IOException
	{
		MemberArray memberArray = new MemberArray();
		int arrTot3 = 0;

		Collections.sort(list, memberArray);

		System.out.println();
		System.out.println();
		System.out.println("\t========================================= [ ȸ���� ������Ȳ ] ===========================================");
		System.out.println();
		System.out.println("\t  No   \t������\t\t  �����ð�\t\t�����޴�\t ����\t�����ݾ�\t��������");
		System.out.println("\t=========================================================================================================");

		ListIterator it = list.listIterator();
		int num=0;

	
		while (it.hasNext())
		{
			MemberInfo obj = (MemberInfo)it.next();

			if (obj.getY()!=0)
			{
				num++;
				System.out.printf("\t  %2d   \t%3s\t\t%4d�� %2d�� %2d��\t%6s\t%d��\t%,d\t\t%s\n",
				num, obj.getName(), obj.getY(), obj.getM(), obj.getD(), 
				obj.getMainMenu(), obj.getMainCount(), obj.getEveryTotal(), obj.getStrHow());
			}
			arrTot3 += obj.getEveryTotal();

		}
		System.out.println();	
		
		System.out.println("\t=========================================================================================================");	
		System.out.printf("\t  �� �����: %,d��\n", arrTot3);
		System.out.println("\t=========================================================================================================");	

		choiceMenu();
	}

	// �������ܺ� ������Ȳ >>>�������� ���� �������� ���� or �˻����: ī�� or ����
	public void cardCashArray() throws IOException
	{
		CardCashArray ccArray = new CardCashArray();
		int arrTot4 = 0;

		Collections.sort(list, ccArray);

		System.out.println();
		System.out.println();
		System.out.println("\t===================================== [ �������ܺ� ������Ȳ ] ===========================================");
		System.out.println();
		System.out.println("\t  No   \t ��������\t  �����ð�\t\t�����޴�\t������\t ����\t�����ݾ�");
		System.out.println("\t=========================================================================================================");
		
		ListIterator it = list.listIterator();
		int num=0;
		while (it.hasNext())
		{
			MemberInfo obj = (MemberInfo)it.next();

			if (obj.getStrHow()!="����")
			{
				num++;
				System.out.printf("\t  %2d   \t%s\t\t%4d�� %2d�� %2d��\t%6s\t%3s\t%d��\t%,d\n",
				num, obj.getStrHow(), obj.getY(), obj.getM(), obj.getD(), 
				obj.getMainMenu(), obj.getName(), obj.getMainCount(), obj.getEveryTotal());
			}
			arrTot4 += obj.getEveryTotal();
		}
		System.out.println();	
		
		System.out.println("\t=========================================================================================================");	
		System.out.printf("\t  �� �����: %,d��\n", arrTot4);
		System.out.println("\t=========================================================================================================");	
		choiceMenu();
	}


	// ��ǥ����װ� �޼���
	public void goalArray() throws IOException
	{
		int arrTotal=0;
		ListIterator it = list.listIterator();
		while (it.hasNext())
		{
			MemberInfo obj = (MemberInfo)it.next();
			arrTotal += obj.getEveryTotal();
		}
		double goal = arrTotal/10000;					// �޼��� ���

		System.out.println();
		System.out.println();
		System.out.println("\t====================================== [ ��ǥ ����װ� �޼��� ] ========================================");
		System.out.println();
		System.out.println("\t\t   ��ǥ �����: 1,000,000��");
		System.out.printf("\t\t     �� �����: %,d��\n", arrTotal);
		System.out.printf("\t\t        �޼���: %.2f%%\n", goal);
		System.out.println();
		System.out.println("\t=========================================================================================================");
		
		choiceMenu();
	}



	// �Ž����� ��Ȳ Ȯ��(������) �� ���� �߰� �Է�

	// �޴����� 1. ���� Ȯ�� 2. ���� �߰� �Է�
	public void choiceMoney() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		// �޴� ����
		try
		{
			System.out.println();
			System.out.println();
			System.out.println("\t=================================[ ���� ��Ȳ ]========================================");	
			System.out.println();
			System.out.println("\t\t1. ���� Ȯ��");
			System.out.println("\t\t2. ���� �߰� �Է�");
			System.out.println();
			System.out.println("\t======================================================================================");	
			System.out.print("\t    ���Ͻô� �޴��� �������ּ��� : ");
			select = sc.next();

			if (!select.equals("1") && !select.equals("2"))
				throw new choiceException(select);
		}//try�� �ݱ�
		catch (choiceException e)
		{
			e.showWrongChoice();
			System.out.println("\t������ ó������ �ٽ� �����մϴ�.");
			this.choiceMenu();
		}//catch �� �ݱ�

		switch (select)
		{
			case "1": ; this.printCash(); break;
			case "2": ; this.plusCash(); break;
		}

	}//choiceMoney ��


	// ������ ���� ��Ȳ ���
	public void printCash() throws IOException
	{
		int totCash = getManW() + getOchunW() + getChunW() + getObakW() + getBakW();		// ���� �ջ� �ݾ�
		int manCount, ochunCount, chunCount, obakCount, bakCount;		// ������ ���� ����

		// ������ ���� ���� ��� (�ݾ�/���� �� �� = ����)
		manCount = getManW()/10000;
		ochunCount = getOchunW()/5000;
		chunCount = getChunW()/1000;
		obakCount = getObakW()/500;
		bakCount = getBakW()/100;

		System.out.println();
		System.out.println();
		System.out.println("\t======================================================================================");	
		System.out.println();
		System.out.println("\t\t      POS ����");
		System.out.println("\t  ����\t      ����    �ݾ�");

		System.out.printf("\t10,000��\t%d\t%s\n", manCount, String.format("%,d", getManW()));
		System.out.printf("\t 5,000��\t%d\t%s\n", ochunCount, String.format("%,d", getOchunW()));
		System.out.printf("\t 1,000��\t%d\t%s\n", chunCount, String.format("%,d", getChunW()));		
		System.out.printf("\t   500��\t%d\t%s\n", obakCount, String.format("%,d", getObakW()));
		System.out.printf("\t   100��\t%d\t%s\n", bakCount, String.format("%,d", getBakW()));
		System.out.println();
		System.out.printf("\t    ���� �غ�� : 100,000��\n");
		System.out.printf("\t   ���� �� �ݾ� : %s��\n", String.format("%,d",totCash));
		System.out.println();
		System.out.println("\t======================================================================================");	
		
		managerMenu();
	}


	// ���� �߰� �Է�

	public void plusCash() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		int beforeCash;											// ���� �߰� �� �� �ݾ�
		int afterCash;											// ���� �߰� �� �� �ݾ�
		int[] cashList = {10000, 5000, 1000, 500, 100};
		int[] count = new int[5];								// �Է¹޴� ������ ����
		int[] plusCash = new int[5];							// ������ �߰� �ݾ� (���翡 �߰��� �ݾ�)
		int totalPlus=0;										// �� �߰� �Է� �ݾ�

		// ���� �������� ���� �ѱݾ�
		beforeCash = getManW() + getOchunW() + getChunW() + getObakW() + getBakW();

		// ���� ����, ���� �Է�
		System.out.println();
		System.out.println();
		System.out.println("\t======================================================================================");	
		System.out.println();
		System.out.println("\t    ������ �߰� ������ �Է����ּ���.");
		System.out.println();

		// ���� �������� ���� �迭 ����ϸ� �ش� �ݾױ��� ���� �Է¹ޱ� �� ������ ���Աݾ� ���
		for (int i=0; i<cashList.length; i++)
		{
			System.out.printf("\t%5d��: ", cashList[i]);	// 10,000��
			count[i] = sc.nextInt();						// 3��
			plusCash[i] = cashList[i]*count[i];				// plusCash[0] = 10,000*3
			totalPlus += plusCash[i];						// totalPlus = 30,000+...+100*n
		}
		
		String commTplus = String.format("%,d", totalPlus);				//',' ���� �߰���
		String commBtPlus = String.format("%,d", beforeCash+totalPlus);	//'.' ���� �� �����

		System.out.println();
		System.out.println("\t======================================================================================");	
		System.out.println();
		System.out.println();

		// �Է¹��� �ݾ� Ȯ��
		System.out.println();
		System.out.println();
		System.out.println("\t======================================================================================");	
		System.out.println();
		System.out.println("\t    ���� �غ�� : 100,000��");
		System.out.println("\t �߰� �Է� �ݾ� :  " + commTplus + "��");
		System.out.println("\t        �� �ݾ� : " + commBtPlus + "��");
		System.out.println();
		System.out.println("\t======================================================================================");	
		System.out.print("\t��� ������ ���縦 �Է��Ͻðڽ��ϱ�? (Y/N) : ");
		select = sc.next();

		if (select.equals("Y") || select.equals("y"))
		{

			// �Է¹��� �ݾ׸�ŭ CashŬ������ �޼ҵ带 ���� ���翡 ���ϱ�
			this.plsPlus(plusCash[0], plusCash[1], plusCash[2], plusCash[3], plusCash[4]);

			// ���� �Է� �� ���� �� �ݾ� ���
			afterCash = getManW() + getOchunW() + getChunW() + getObakW() + getBakW();

			System.out.println();
			System.out.println();
			System.out.println("\t�Է��� �Ϸ�Ǿ����ϴ�.");
			System.out.println();
			this.choiceMoney();							// �ٽ� ���ø޴��� ���ư���
		}
		else
		{
			System.out.println();
			System.out.println();
			System.out.println("\t���� �߰� �Է��� ����ϼ̽��ϴ�.");
			this.choiceMoney();
		}
		
	}//plusCash ��
	
} //SalesManagement ��


// ���ı��� 1. �����ð� �������� ����
class DateArray implements Comparator<MemberInfo>
{
		@Override
		public int compare(MemberInfo o1, MemberInfo o2)
		{
			return o1.getD() - o2.getD();
		}
}


// ���ı��� 2. �޴� �������� ����
class MenuArray implements Comparator<MemberInfo>
{
		@Override
		public int compare(MemberInfo o1, MemberInfo o2)
		{
			return o1.getMainMenu().compareTo(o2.getMainMenu());
		}
}

// ���ı��� 3. ȸ��ID �������� ����
class MemberArray implements Comparator<MemberInfo>
{
		@Override
		public int compare(MemberInfo o1, MemberInfo o2)
		{
			return o1.getName().compareTo(o2.getName());
		}
}

// ���ı��� 4. �������� �������� ����
class CardCashArray implements Comparator<MemberInfo>
{
		@Override
		public int compare(MemberInfo o1, MemberInfo o2)
		{
			return o1.getStrHow().compareTo(o2.getStrHow());
		}
}


public class AdminPayment
{
	public static void main(String[] args) throws IOException
	{

	}
}