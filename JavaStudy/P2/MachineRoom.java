// ���Ƿ� �����ؼ� û���ϴ� �޼ҵ�
// �뷡 Ŭ���� ����
// ���� ���� �� ����Ʈ ������ 10�� �����δ� �� ������!

import java.util.Random;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;

// �������
class MachineRoom
{	
	private int sel;							// �޴� ���� ����	
	private char select;						// YES Ȥ�� NO..
	private static final Date d = new Date();	// ��¥ ��Ƴ� ����
	public static String offday;				// ���� ��¥ ��Ƴ� ����

	public void setMachine() throws IOException
	{	
		Scanner sc = new Scanner(System.in);
		int sel;

		System.out.println("\t1. ���� û��\t2. ���Ǳ� ���� OFF");
		do
		{
			System.out.print("\n\t���� �� �ּ��� : ");
			sel = sc.nextInt();
		}
		while (sel < 1 || sel > 2);


		if (sel==1)
		{
			clear();
		}

		if (sel==2)
		{
			exit();
		}
	}
	

	// ���Ǳ� ���� OFF �޼ҵ�
	public void exit()						
	{
		SimpleDateFormat dayset = new SimpleDateFormat("yyyy�� MM�� dd�� E���� HH��");
		MachineRoom.offday = dayset.format(d);

		System.out.println("\t���Ǳ� �ǸŰ� ���� �Ǿ����ϴ�.");
		System.out.printf("\t���Ǳ� �Ǹ� ���� ���� : %s\n", MachineRoom.offday);	

		System.exit(-1);							
	}
	
	// ���Ƿ� �ͼ� ���� ���� û��
	public void clear()	throws IOException				
	{
		game gm = new game();

		System.out.println("\tĬ���� �Ǹ� Ƚ�� : " + gm.getsellcount());

		System.out.print("\t������ û�� �Ͻðڽ��ϱ�? (Y/N) : ");
		select = (char)System.in.read();

		if (select == 'Y' || select == 'y')
		{
			gm.setsellcount(0);

			try
			{	
				System.out.print("\n\t");
				String s = " �� �� �� û �� �� . . . �� �� �� û �� �� . . . �� �� �� û �� �� . . . ";
				for (int i = 0; i < s.length(); i++) 
				{ 
					Thread.sleep(150);							// s ���ڿ��� ���鼭 sleep() ���� ���� ���� �� ���ھ� ���!
					System.out.print(s.charAt(i));
				}

				System.out.println("\n");
			}
			catch (InterruptedException e)
			{
				System.out.println();							// ������� ���� ó���� ����� ��..
			}
		}
		
		else if (select == 'Y' || select == 'y')
			setMachine();
		
		Login ln = new Login();
		ln.login();
		
	}
	

	// Ƚ�� ���� ����û�ұ� �޼ҵ�
	public void aiclear()				
	{	
		// �Ǹ�Ƚ�� �ʱ�ȭ
		int num = 0;

		game gm = new game();
		
		if (gm.getsellcount()>2)								// �Ǹ� �ǰ��� �����ϱ� ������ �Ǹ��� �� �� - 1
		{	
			System.out.println("\t ���� ���� ���� �����ϴ�... ");
			
			try
			{	
				System.out.print("\n\t");
				String s = " �� �� �� û �� �� . . . �� �� �� û �� �� . . . �� �� �� û �� �� . . . ";
				for (int i = 0; i < s.length(); i++) 
				{ 
					Thread.sleep(150);							// s ���ڿ��� ���鼭 sleep() ���� ���� ���� �� ���ھ� ���!
					System.out.print(s.charAt(i));
				}

				System.out.println("\n");
			}
			catch (InterruptedException e)
			{
				System.out.println();							// ������� ���� ó���� ����� ��..
			}

			gm.setsellcount(num);
		}
	}

	public void loading()
	{
		try
		{	
			System.out.print("\n\t");
			String s = "����������������������������������������������������������������������������������������������������������������������������";
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
	}

	public void temploading()
	{
		try
		{	
			System.out.print("\n\t");
			String s = "�������������������������������������������������� ������ �Ϸ� �Ǿ����ϴ� ��������������������������������������������������";
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
	}
}



// �̴ϰ���
class game
{	
	private int sel;						// ���� Ȯ�� ����
	private int user;						// �����
	private int com;						// ��ǻ��

	private int sellcount;			// Ĭ���� �� Ƚ��

	UserPayment up = new UserPayment();
	MemberInfo mi = new MemberInfo();

	int total = up.getTotal();		// �����ݾ��� ������.
	int point = mi.getPoint();		// ������ ����Ʈ ����

	public int getsellcount()
	{
		return sellcount;
	}	

	public void setsellcount(int sellcount)
	{	
		this.sellcount = sellcount;
	}
	

	public void rsp() throws InterruptedException
	{	
		MachineRoom mr = new MachineRoom();
		Imagefile jpg = new Imagefile();

		mr.temploading();
		
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		System.out.println("\t������ ������ ���� �̴� ����(������)�� �Ͻðڽ��ϱ�?\n");
		System.out.println("\t1. �̱� Ȯ�� 80% ����(������ 5%) \t\t 2. �̱� Ȯ�� 66.6%(������ 10%) \t\t 3. �� �ҷ���.");

		do
		{
			System.out.print("\n\t ���� �� �ּ��� : ");
			sel = sc.nextInt();
		}
		while (sel < 1 || sel > 3);

	
		if (sel==1)
		{
			com = rd.nextInt(4)+1; // �� 1 2 3 4 5
			System.out.println("\n\tȮ�� 80 % ������ �����ϼ̽��ϴ�.");
			game1();
		}
		
		else if(sel==2)
		{
			com = rd.nextInt(2)+1; // �� 1 2 3
			System.out.println("\n\tȮ�� 66.6 % ������ �����ϼ̽��ϴ�.");
			game2();
		}
		
		else if(sel==3)
		{
			System.out.println("\n\t�̿� �� �ּż� �����մϴ�.");						
			mr.exit();// ó�� ȭ������ ���ư��� Ŭ���� �޼ҵ� ȣ��.
		}
		
		sellcount +=1;															// Ĭ���� �� Ƚ��

	}
	

	private void game1()
	{	
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.print("\t1. �� 2. �Ʒ� 3. �߾� 4. ���� 5. ������ : ");
			user = sc.nextInt();
		}
		while (user < 1 || user > 5);

		try
		{
			Thread.sleep(3000);			
		}
		catch (InterruptedException e)
		{
			System.out.println();
		}

		try
		{	
			System.out.print("\t");
			Thread.sleep(3);			
		}
		catch (InterruptedException e)
		{
			System.out.println();
		}
		
		String[] str = {"��", "�Ʒ�", "�߾�", "����", "������"};

		System.out.println("\n\t - ����	  : " + str[user-1]);
		System.out.println("  \t - ��ǻ�� : " + str[com-1]);
		
		if (user==com)
			System.out.println("\n\t�й� �ϼ̽��ϴ�~!!");
		else
		{
			System.out.println("\n\t�¸� �ϼ̽��ϴ�~!!");

			// ����Ʈ ����
			double temppoint = total*0.05;
			int temp = (int)temppoint;
			
			// 100�� ������ ����������� ������ 100 ������ ����������� ������ֱ�
			if (temp % 100 != 0)
				temp -= (temp%100);
			
			// MemberInfo Ŭ������ point�� ����
			point += temp;												
			mi.setPoint(point);
		}

	}


	private void game2()
	{	
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.print("\t1. ���� 2. �߾� 3. ������ : ");
			user = sc.nextInt();
		}
		while (user < 1 || user > 3);
		
		try
		{
			Thread.sleep(3000);			
		}
		catch (InterruptedException e)
		{
			System.out.println();
		}

		String[] str = {"����", "�߾�", "������"};

		System.out.println("\n\t - ����	  : " + str[user-1]);
		System.out.println("  \t - ��ǻ�� : " + str[com-1]);
		
		if (user==com)
			System.out.println("\n\t�й� �ϼ̽��ϴ�~!!");
		else
		{
			System.out.println("\n\t�¸� �ϼ̽��ϴ�~!!");
			// ����Ʈ ����
			double temppoint = total*0.01;
			int temp = (int)temppoint;
			
			// 100�� ������ ����������� ������ 100 ������ ����������� ������ֱ�
			if (temp % 100 != 0)
				temp -= (temp%100);
			
			// MemberInfo Ŭ������ point�� ����
			point += temp;												
			mi.setPoint(point);									
		}

	}
}