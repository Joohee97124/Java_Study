
import java.util.Scanner;
import java.util.Calendar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;



class SalesManagement //extends Cash
{
	String select;							// ����ڷκ��� �Է¹��� �޴� ����
	Calendar now = Calendar.getInstance();

	// ������Ȳ Ȯ�� or ���� Ȯ��, �Է� �޴� ����
	public void showChoice() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		// �޴� ����
		try
		{
			System.out.println();
			System.out.println();
			System.out.println("\t��������������������������������������������������������������������������");	
			System.out.println();
			System.out.println("\t\t1. ���� ��Ȳ Ȯ��");
			System.out.println("\t\t2. ���� Ȯ�� �� �Է�");
			System.out.println();
			System.out.println("\t��������������������������������������������������������������������������");	
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
		Management mg = new Management();

		// �޴� ����
		try
		{
			System.out.println();
			System.out.println();
			System.out.println("\t��������������������������������������������������������������������������");	
			System.out.println();
			System.out.println("\t\t1. ���ں� ������Ȳ");
			System.out.println("\t\t2. �޴��� ������Ȳ");
			System.out.println("\t\t3. ȸ���� ��������");
			System.out.println("\t\t4. �������ܺ� ������Ȳ");
			System.out.println("\t\t5. ��ǥ����װ� �޼���");
			System.out.println("\t\t6. ������ ���� ȭ������ ���ư���");
			System.out.println();
			System.out.println("\t��������������������������������������������������������������������������");	
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
			case "6": mg.managerMenu(); break;
		}
	} //choiceMenu ��

	// ArrData���� ������ ArrayList �ڷᱸ���� ����ؼ�
	// ������Ȳ ��� �� �ʿ��� �����͵��� �ѹ��� ���, ���ϴ� ��Ĵ�� �����ؼ� ����ϱ� ���� Ŭ����
	//�� ���ں� / �޴��� / ȸ���� / �������ܺ��� <Ŭ����>�� ����, ���� ������ �ٸ��� �������̵���

	// ���ں� ������Ȳ
	public void dateArray() throws IOException
	{
		List<ArrData> list = new ArrayList<ArrData>();
		DateArray dateArray = new DateArray();
		int arrTotal=0;	
		String insertDate;

		Scanner sc = new Scanner(System.in);


		// ���� ��� �� Ȯ���ϱ� ���� ���� ������ �߰�
		list.add(new ArrData(2021, 3, 15, 10, 10, "������", "�߷��þ�", 1, 20000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 12, 10, "������", "��� �Ͽ���", 1, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 20, 30, "������", "������Ÿ", 1, 10000, "����"));
		list.add(new ArrData(2021, 3, 18, 22, 22, "������", "�� ����", 1, 10000, "����"));

		list.add(new ArrData(2021, 3, 15, 11, 15, "�谡��", "��ų�� ���", 1, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 10, 22, "�谡��", "�ڽ�������ź", 1, 18000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 18, 39, "�谡��", "�� ��", 1, 10000, "����"));
		list.add(new ArrData(2021, 3, 18, 20, 40, "�谡��", "��Ϲ�", 1, 20000, "����"));

		list.add(new ArrData(2021, 3, 15, 15, 21, "������", "Ŭ�ι� Ŭ��", 1, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 17, 10, "������", "�ǳ� �ݶ��", 1, 15000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 22, 51, "������", "�߷��þ�", 1, 20000, "����"));
		list.add(new ArrData(2021, 3, 18, 23, 50, "������", "ũ��Ŀ", 4, 12000, "����"));

		list.add(new ArrData(2021, 3, 15, 12, 20, "������", "�Ƹ��", 5, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 14, 28, "������", "��� �Ͽ���", 1, 15000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 21, 43, "������", "�߷��þ�", 1, 20000, "����"));
		list.add(new ArrData(2021, 3, 18, 20, 52, "������", "��ų�� ���", 1, 10000, "����"));

		list.add(new ArrData(2021, 3, 15, 16, 25, "������", "������Ÿ", 1, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 19, 37, "������", "�ڽ�������ź", 1, 18000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 22, 58, "������", "��� �Ͽ���", 1, 10000, "����"));
		list.add(new ArrData(2021, 3, 18, 11, 43, "������", "ũ��Ŀ", 5, 15000, "����"));


		// ���α׷� ���� �� �ԷµǴ� ���� �����ؼ� �� ���� �߰�
		//list.add(new ArrData());
		
		Collections.sort(list, dateArray);

		System.out.println();
		System.out.println();
		//System.out.print("\t� ��¥�� ���� ������ ����ұ��? (���� 8�ڸ��� �Է��ϼ���: ex. 20190527) : ");
		//insertDate = sc.next();	// 20210317

		/*
		insertDate.substring(0,4)
		
		if (list.)
		{
		}
		*/

		System.out.println();
		System.out.println("\t���������������������������������������������������������������������������� [ ���ں� ������Ȳ ] ������������������������������������������������������������������������������������");	
		System.out.println();
		System.out.println("\t  No   \t\t�����ð�\t\t  �����޴�\t������\t ����\t�����ݾ�\t��������");
		System.out.println("\t����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");	
		
		ListIterator it = list.listIterator();
		int num=0;
		while (it.hasNext())
		{
			num++;
			ArrData obj = (ArrData)it.next();
			System.out.printf("\t  %2d   %4d�� %2d�� %2d�� %2d�� %2d��\t%6s\t%s\t%2d��\t%,d\t\t%s\n",
			num, obj.getY(), obj.getM(), obj.getD(), 
			obj.getH(), obj.getMin(), obj.menu, obj.name, obj.count, obj.total, obj.strHow);
			arrTotal += obj.total;
		}
		System.out.println();	
		
		System.out.println("\t����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");	
		System.out.printf("\t  �� �����: %,d��\n", arrTotal);
		System.out.println("\t����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");	
		
		choiceMenu();
	}		


	// �޴��� ������Ȳ>>> ���� �޴� ���� �������� ����
	public void menuArray() throws IOException
	{
		List<ArrData> list = new ArrayList<ArrData>();
		int arrTotal=0;							// ���� ���ǿ��� �ɷ��� ������ �� ���� ��
		
		// �޴� �������� �������� �����ϱ� ���� ���� ���� �������̵��� Ŭ���� �ν��Ͻ� ����
		MenuArray menuArray = new MenuArray();

		// ���� ��� �� Ȯ���ϱ� ���� ���� ������ �߰�
		list.add(new ArrData(2021, 3, 15, 10, 10, "������", "�߷��þ�", 1, 20000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 12, 10, "������", "��� �Ͽ���", 1, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 20, 30, "������", "������Ÿ", 1, 10000, "����"));
		list.add(new ArrData(2021, 3, 18, 22, 22, "������", "�� ����", 1, 10000, "����"));

		list.add(new ArrData(2021, 3, 15, 11, 15, "�谡��", "��ų�� ���", 1, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 10, 22, "�谡��", "�ڽ�������ź", 1, 18000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 18, 39, "�谡��", "�� ��", 1, 10000, "����"));
		list.add(new ArrData(2021, 3, 18, 20, 40, "�谡��", "��Ϲ�", 1, 20000, "����"));

		list.add(new ArrData(2021, 3, 15, 15, 21, "������", "Ŭ�ι� Ŭ��", 1, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 17, 10, "������", "�ǳ� �ݶ��", 1, 15000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 22, 51, "������", "�߷��þ�", 1, 20000, "����"));
		list.add(new ArrData(2021, 3, 18, 23, 50, "������", "ũ��Ŀ", 4, 12000, "����"));

		list.add(new ArrData(2021, 3, 15, 12, 20, "������", "�Ƹ��", 5, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 14, 28, "������", "��� �Ͽ���", 1, 15000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 21, 43, "������", "�߷��þ�", 1, 20000, "����"));
		list.add(new ArrData(2021, 3, 18, 20, 52, "������", "��ų�� ���", 1, 10000, "����"));

		list.add(new ArrData(2021, 3, 15, 16, 25, "������", "������Ÿ", 1, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 19, 37, "������", "�ڽ�������ź", 1, 18000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 22, 58, "������", "��� �Ͽ���", 1, 10000, "����"));
		list.add(new ArrData(2021, 3, 18, 11, 43, "������", "ũ��Ŀ", 5, 15000, "����"));

		// ���α׷� ���� �� �ԷµǴ� ���� �����ؼ� �� ���� �߰�
		//list.add(new ArrData());

		// �޴����� �������� ���� �� ���
		Collections.sort(list, menuArray);
		
		System.out.println();
		System.out.println();
		System.out.println("\t���������������������������������������������������������������������������� [ �޴��� ������Ȳ ] ������������������������������������������������������������������������������������");	
		System.out.println();
		System.out.println("\t  No   \t �����޴�\t\t  �����ð�\t\t������\t ����\t�����ݾ�\t��������");
		System.out.println("\t����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");	
		
		ListIterator it = list.listIterator();
		int num=0;
		while (it.hasNext())
		{
			num++;
			ArrData obj = (ArrData)it.next();
			System.out.printf("\t  %2d   %7s\t%4d�� %2d�� %2d�� %2d�� %2d��\t%s\t%2d��\t%,d\t\t%s\n",
			num, obj.menu, obj.getY(), obj.getM(), obj.getD(), 
			obj.getH(), obj.getMin(), obj.name, obj.count, obj.total, obj.strHow);
			arrTotal += obj.total;
		}
		System.out.println();	
		
		System.out.println("\t����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");	
		System.out.printf("\t  �� �����: %,d��\n", arrTotal);
		System.out.println("\t����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");	
		
		choiceMenu();
	}


	// ȸ���� ������Ȳ >>>�̸� ���� ������������
	public void memberArray() throws IOException
	{
		List<ArrData> list = new ArrayList<ArrData>();
		MemberArray memberArray = new MemberArray();
		int arrTotal=0;							// ���� ���ǿ��� �ɷ��� ������ �� ���� ��

		list.add(new ArrData(2021, 3, 15, 10, 10, "������", "�߷��þ�", 1, 20000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 12, 10, "������", "��� �Ͽ���", 1, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 20, 30, "������", "������Ÿ", 1, 10000, "����"));
		list.add(new ArrData(2021, 3, 18, 22, 22, "������", "�� ����", 1, 10000, "����"));

		list.add(new ArrData(2021, 3, 15, 11, 15, "�谡��", "��ų�� ���", 1, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 10, 22, "�谡��", "�ڽ�������ź", 1, 18000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 18, 39, "�谡��", "�� ��", 1, 10000, "����"));
		list.add(new ArrData(2021, 3, 18, 20, 40, "�谡��", "��Ϲ�", 1, 20000, "����"));

		list.add(new ArrData(2021, 3, 15, 15, 21, "������", "Ŭ�ι� Ŭ��", 1, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 17, 10, "������", "�ǳ� �ݶ��", 1, 15000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 22, 51, "������", "�߷��þ�", 1, 20000, "����"));
		list.add(new ArrData(2021, 3, 18, 23, 50, "������", "ũ��Ŀ", 4, 12000, "����"));

		list.add(new ArrData(2021, 3, 15, 12, 20, "������", "�Ƹ��", 5, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 14, 28, "������", "��� �Ͽ���", 1, 15000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 21, 43, "������", "�߷��þ�", 1, 20000, "����"));
		list.add(new ArrData(2021, 3, 18, 20, 52, "������", "��ų�� ���", 1, 10000, "����"));

		list.add(new ArrData(2021, 3, 15, 16, 25, "������", "������Ÿ", 1, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 19, 37, "������", "�ڽ�������ź", 1, 18000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 22, 58, "������", "��� �Ͽ���", 1, 10000, "����"));
		list.add(new ArrData(2021, 3, 18, 11, 43, "������", "ũ��Ŀ", 5, 15000, "����"));

		Collections.sort(list, memberArray);

		System.out.println();
		System.out.println();
		System.out.println("\t���������������������������������������������������������������������������� [ ȸ���� ������Ȳ ] ������������������������������������������������������������������������������������");	
		System.out.println();
		System.out.println("\t  No   \t������\t\t  �����ð�\t\t�����޴�\t ����\t�����ݾ�\t��������");
		System.out.println("\t����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");	
		
		ListIterator it = list.listIterator();
		int num=0;
		while (it.hasNext())
		{
			num++;
			ArrData obj = (ArrData)it.next();
			System.out.printf("\t  %2d   %s\t%4d�� %2d�� %2d�� %2d�� %2d��\t%6s\t%2d��\t%,d\t\t%s\n",
			num, obj.name, obj.getY(), obj.getM(), obj.getD(), 
			obj.getH(), obj.getMin(), obj.menu, obj.count, obj.total, obj.strHow);
			arrTotal += obj.total;
		}
		System.out.println();	
		
		System.out.println("\t����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");	
		System.out.printf("\t  �� �����: %,d��\n", arrTotal);
		System.out.println("\t����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");	
	
		choiceMenu();
	}

	// �������ܺ� ������Ȳ >>>�������� ���� �������� ���� or �˻����: ī�� or ����
	public void cardCashArray()  throws IOException
	{
		List<ArrData> list = new ArrayList<ArrData>();
		CardCashArray ccArray = new CardCashArray();
		int arrTotal=0;							// ���� ���ǿ��� �ɷ��� ������ �� ���� ��

		list.add(new ArrData(2021, 3, 15, 10, 10, "������", "�߷��þ�", 1, 20000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 12, 10, "������", "��� �Ͽ���", 1, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 20, 30, "������", "������Ÿ", 1, 10000, "����"));
		list.add(new ArrData(2021, 3, 18, 22, 22, "������", "�� ����", 1, 10000, "����"));

		list.add(new ArrData(2021, 3, 15, 11, 15, "�谡��", "��ų�� ���", 1, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 10, 22, "�谡��", "�ڽ�������ź", 1, 18000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 18, 39, "�谡��", "�� ��", 1, 10000, "����"));
		list.add(new ArrData(2021, 3, 18, 20, 40, "�谡��", "��Ϲ�", 1, 20000, "����"));

		list.add(new ArrData(2021, 3, 15, 15, 21, "������", "Ŭ�ι� Ŭ��", 1, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 17, 10, "������", "�ǳ� �ݶ��", 1, 15000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 22, 51, "������", "�߷��þ�", 1, 20000, "����"));
		list.add(new ArrData(2021, 3, 18, 23, 50, "������", "ũ��Ŀ", 4, 12000, "����"));

		list.add(new ArrData(2021, 3, 15, 12, 20, "������", "�Ƹ��", 5, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 14, 28, "������", "��� �Ͽ���", 1, 15000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 21, 43, "������", "�߷��þ�", 1, 20000, "����"));
		list.add(new ArrData(2021, 3, 18, 20, 52, "������", "��ų�� ���", 1, 10000, "����"));

		list.add(new ArrData(2021, 3, 15, 16, 25, "������", "������Ÿ", 1, 10000, "ī��"));
		list.add(new ArrData(2021, 3, 16, 19, 37, "������", "�ڽ�������ź", 1, 18000, "ī��"));
		list.add(new ArrData(2021, 3, 17, 22, 58, "������", "��� �Ͽ���", 1, 10000, "����"));
		list.add(new ArrData(2021, 3, 18, 11, 43, "������", "ũ��Ŀ", 5, 15000, "����"));
		
		Collections.sort(list, ccArray);

		System.out.println();
		System.out.println();
		System.out.println("\t���������������������������������������������������������������������������� [ ���� ���ܺ� ������Ȳ ] ������������������������������������������������������������������������������������");	
		System.out.println();
		System.out.println("\t  No   \t ��������\t  �����޴�\t�����ð�\t\t������\t ����\t�����ݾ�");
		System.out.println("\t����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");	
		
		ListIterator it = list.listIterator();
		int num=0;
		while (it.hasNext())
		{
			num++;
			ArrData obj = (ArrData)it.next();
			System.out.printf("\t  %2d   %s\t\t%6s\t%4d�� %2d�� %2d�� %2d�� %2d��\t%s\t%2d��\t%,d\n",
			num, obj.strHow, obj.menu, obj.getY(), obj.getM(), obj.getD(), 
			obj.getH(), obj.getMin(), obj.name, obj.count, obj.total);
			arrTotal += obj.total;
		}
		System.out.println();	
		
		System.out.println("\t����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");	
		System.out.printf("\t  �� �����: %,d\n", arrTotal);
		System.out.println("\t����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");	
		
		choiceMenu();
	}


	// ��ǥ����װ� �޼���
	public void goalArray() throws IOException
	{
		//int goal = (int)(arrTotal/10000);		// �޼��� ���
		//int arrTotal=0;							// ���� ���ǿ��� �ɷ��� ������ �� ���� ��

		System.out.println();
		System.out.println();
		System.out.println("\t������������������������������������������������������������������������ [ ��ǥ ����װ� �޼��� ] ��������������������������������������������������������������������������������");	
		System.out.println();
		System.out.println("\t\t  ��ǥ �����: 1,000,000��");
		//System.out.printf("\t\t     �� �����: %,d", arrTotal);
		//System.out.println("\t\t       �޼���: %d", goal);
		System.out.println();
		System.out.println("\t����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");	
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
			System.out.println("\t��������������������������������������������������������������������������");	
			System.out.println();
			System.out.println("\t\t1. ���� Ȯ��");
			System.out.println("\t\t2. ���� �߰� �Է�");
			System.out.println();
			System.out.println("\t��������������������������������������������������������������������������");	
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
	public void printCash()  throws IOException
	{
		Cash c = new Cash();

		int[] cashList = {10000, 5000, 1000, 500, 100};
		int totCash = c.getManW() + c.getOchunW() + c.getChunW() + c.getObakW() + c.getBakW();		// ���� �ջ� �ݾ�

		int manCount, ochunCount, chunCount, obakCount, bakCount;		// ������ ���� ����

		// ������ ���� ���� ��� (�ݾ�/���� �� �� = ����)
		manCount = c.getManW()/10000;
		ochunCount = c.getOchunW()/5000;
		chunCount = c.getChunW()/1000;
		obakCount = c.getObakW()/500;
		bakCount = c.getBakW()/100;

		System.out.println();
		System.out.println();
		System.out.println("\t������������������������������������������������������������������������ [ ���� ��Ȳ ] ��������������������������������������������������������������������������������");	
		System.out.println();
		System.out.println("\t\t      POS ����");
		System.out.println("\t  ����\t      ����    �ݾ�");

		System.out.printf("\t10,000��\t%d\t%s\n", manCount, String.format("%,d",c.getManW()));
		System.out.printf("\t 5,000��\t%d\t%s\n", ochunCount, String.format("%,d",c.getOchunW()));
		System.out.printf("\t 1,000��\t%d\t%s\n", chunCount, String.format("%,d",c.getChunW()));		
		System.out.printf("\t   500��\t%d\t%s\n", obakCount, String.format("%,d",c.getObakW()));
		System.out.printf("\t   100��\t%d\t%s\n", bakCount, String.format("%,d",c.getBakW()));
		System.out.println();
		System.out.printf("\t    ���� �غ�� : 100,000��\n");
		System.out.printf("\t   ���� �� �ݾ� : %s��\n", String.format("%,d",totCash));
		System.out.println();
		System.out.println("\t������������������������������������������������������������������������������������������������������������������������������������������������������������������������");	
		
		choiceMenu();
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
		int totalPlus = 0;										// �� �߰� �Է� �ݾ�

		// ���� �������� ���� �ѱݾ�
		Cash ch = new Cash();
		beforeCash = ch.getManW() + ch.getOchunW() + ch.getChunW() + ch.getObakW() + ch.getBakW();

		// ���� ����, ���� �Է�
		System.out.println();
		System.out.println();
		System.out.println("\t��������������������������������������������������������������������������");	
		System.out.println();
		System.out.println("\t    ������ �߰� ������ �Է����ּ���.");
		System.out.println();

		// ���� �������� ���� �迭 ����ϸ� �ش� �ݾױ��� ���� �Է¹ޱ� �� ������ ���Աݾ� ���
		for (int i=0; i<cashList.length; i++)
		{
			System.out.printf("\t%5d��: ", cashList[i]);
			count[i] = sc.nextInt();
			plusCash[i] += cashList[i]*count[i];
			totalPlus += plusCash[i];
		}

		System.out.println();
		System.out.println("\t��������������������������������������������������������������������������");
		System.out.println();
		System.out.println();

		// �Է¹��� �ݾ� Ȯ��
		System.out.println();
		System.out.println();
		System.out.println("\t��������������������������������������������������������������������������");	
		System.out.println();
		System.out.printf("\t    ���� �غ�� : 100,000��\n");
		System.out.printf("\t �߰� �Է� �ݾ� : %,d��\n" + totalPlus);
		System.out.printf("\t        �� �ݾ� : %,d��\n" + (beforeCash+totalPlus));
		System.out.println();
		System.out.println("\t��������������������������������������������������������������������������");
		System.out.print("\t��� ������ ���縦 �Է��Ͻðڽ��ϱ�? (Y/N) : ");
		select = sc.next();

		if (select.equals("Y") || select.equals("y"))
		{

			// �Է¹��� �ݾ׸�ŭ ����� ���� ������ ���� ���翡 ���ϱ�
			Cash c = new Cash(plusCash[0], plusCash[1], plusCash[2], plusCash[3], plusCash[4]);

			// ���� �Է� �� ���� �� �ݾ� ���
			afterCash = c.getManW() + c.getOchunW() + c.getChunW() + c.getObakW() + c.getBakW();

			System.out.println();
			System.out.println();
			System.out.println("\t�Է��� �Ϸ�Ǿ����ϴ�.");
			System.out.println();
			this.choiceMoney();							// �ٽ� ���ø޴��� ���ư���??
		}
		else
		{
			System.out.println();
			System.out.println();
			System.out.println("���� �߰� �Է��� ����ϼ̽��ϴ�.");
			this.choiceMoney();
		}
		
	}//plusCash ��
	
} //SalesManagement ��


public class AdminPayment
{
	public static void main(String[] args)
	{

	}
}