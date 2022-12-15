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
	public void exit() throws IOException						
	{
		SimpleDateFormat dayset = new SimpleDateFormat("yyyy�� MM�� dd�� E���� HH��");
		MachineRoom.offday = dayset.format(d);
		//UserPayment up = new UserPayment(d);

		System.out.println("\t���Ǳ� �ǸŰ� ���� �Ǿ����ϴ�.");
		System.out.printf("\t���Ǳ� �Ǹ� ���� ���� : %s\n", MachineRoom.offday);	
		
		try
		{	
			System.out.print("\n\t");
			String s = "���������������������������������������������������� �� �� �� �� �ߢ���������������������������������������������������������";
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
		System.exit(-1);							
	}
	
	// ���Ƿ� �ͼ� ���� ���� û��
	public void clear()	throws IOException				
	{	
		Management mg = new Management();
		UserPayment up = new UserPayment();

		System.out.println("\tĬ���� �Ǹ� Ƚ�� : " + up.getsellcount());

		System.out.print("\t������ û�� �Ͻðڽ��ϱ�? (Y/N) : ");
		select = (char)System.in.read();

		if (select == 'Y' || select == 'y')
		{
			up.setsellcount(0);

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

			mg.managerMenu();
		}
		
		else if (select == 'N' || select == 'n')
			mg.managerMenu();

		
	}
	

	// Ƚ�� ���� ����û�ұ� �޼ҵ�
	public void aiclear() throws IOException				
	{	
		// �Ǹ�Ƚ�� �ʱ�ȭ
		int num = 0;

		UserPayment up = new UserPayment();
		
		if (up.getsellcount()>1)								// �Ǹ� �ǰ��� �����ϱ� ������ �Ǹ��� �� �� - 1
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

			up.setsellcount(num);
		}
	}

	public void loading()
	{
		try
		{	
			System.out.print("\n\t");
			String s = "���������������������������������������������������� �� �� �� �� �ߢ���������������������������������������������������������";
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
