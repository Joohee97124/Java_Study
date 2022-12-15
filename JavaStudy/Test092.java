/* ====================================
���� Ŭ������ �ν��Ͻ� ����
- Ŭ���� ����
- �迭 Ȱ��
======================================*/

// �� �ǽ� ����
// �Ʒ��� Ŭ���� (WeekDay)�� �ϼ��Ѵ�.
// ����ڷκ��� ��, ��, ���� �Է¹޾�
// �ش� ��¥�� ������ ����ϴ� ���α׷��� �����Ѵ�.
// ��, �޷� Ŭ���� (Calendar) �� ������� �ʴ´�.
// ����, Ŭ������ ������ Ȱ���Ͽ� �ۼ��� �� �ֵ��� �Ѵ�.
// �׸���, �迭�� ���䵵 ������� �ۼ��� �� �ֵ��� �Ѵ�.

// ���� ��)
// �� �� �� �Է�(���� ����) : 1997 10 6

// >> 1997�� 10�� 6�� �� ������
// ����Ͻ÷��� �ƹ� Ű�� ...

// �� ���� �ν� �� �м�
//	  - ���� �� ����� ���� ����
//	  - 1�� 1�� 1�� �� ������ 
//    ��ĥ�������� ī���� �� ������ 7

import java.util.Scanner;

class WeekDay
{
	// ���� �� Ǯ��
	/*

	// �ֿ� ���� ���� (�Ӽ� ����)
	private int y, m, d;
	private String yoil;
	
	// �޼ҵ� ���� (�Է¹ޱ�)
	void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�� �� �� �Է�(���� ����) :");
		y = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();
	}

	// �޼ҵ� ���� (���� �����ϱ�)
	String week()
	{
		String [] arrDay = {"������", "ȭ����", "������", "�����", "�ݿ���", "�����", "�Ͽ���"};
		
		int count=0,year=0,month=0,fin=0;
	
		for (int i =1 ; i< y ; i++)
		{
			if (i%4==0 && i%100!=0 || i%400==0)
			{
				year += 366;
			}
			else
				year += 365;
		}
		System.out.printf("year : %d\n",year);
		

		for (int j=1;j<m ;j++ )
		{
			if (j==2)
			{
					if (y%4==0 && y%100!=0 || y%400==0)
					{
						month += 29;
					}
					else 
						month += 28;
			}

			else if (j==4||j==6||j==9||j==11)
			{
				month += 30;
			}

			else
				month += 31;
			
		}
		System.out.printf("month : %d\n",month);


		int date = d*1;
		
		count = year + month + date;
		System.out.println(count);
		fin = count%7;
		// System.out.println(fin);
		
		
		switch (fin)
		{
		case 0 : yoil = arrDay[6]; break;
		case 1 : yoil = arrDay[0]; break;
		case 2 : yoil = arrDay[1]; break;
		case 3 : yoil = arrDay[2]; break;
		case 4 : yoil = arrDay[3]; break;
		case 5 : yoil = arrDay[4]; break;
		case 6 : yoil = arrDay[5]; break;
		
		}	

		return yoil;

	}

	// �޼ҵ� ���� (��� ����ϱ�)
	void print(String day)
	{
		System.out.printf(">> %d�� %d�� %d�� �� %s\n",y,m,d,yoil);
	}
	*/

	// �ֿ� ���� ���� (�Ӽ� ����)
	private int y, m, d;
	
	// �޼ҵ� ���� (�Է¹ޱ�)
	void input()
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("�� �� �� �Է�(���� ����) :");
		y = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();
	}

	// �޼ҵ� ���� (���� �����ϱ�)
	String week()
	{
		// �� ���� ������ ��¥ (�� ���� �ִ밪)�� �迭 ���·� ����
		int [] months = {31,0,31,30,31,30,31,31,30,31,30,31};			//-- 2���� ����θ� �ȵ� (���� �Ӷ� �־��!)

		// ���ϸ� ���� �迭 ����
		String [] weekNames = {"��","��","ȭ","��","��","��","��"};
		
		// �� ���� ������ ����, ���� ����, ���� ����
		int nalsu, i, w;
		
		// ���⿡ ���� 2���� �� �� ���
		// �����̶��... 2���� ������ ��¥�� 29�Ϸ� ���� �� month[1] = 29;
		// ����̶��... 2���� ������ ��¥�� 28�Ϸ� ���� �� month[1] = 28;
		if (y%4==0 && y%100!=0 || y%400==0)	//-- �Է��� �⵵�� �����̶��...
		{
			// 2���� ������ ��¥�� 29�Ϸ� ����
			months[1] = 29;
		}
		else								//-- �Է��� �⵵�� ����̶��...
		{
			// 2���� ������ ��¥�� 28�Ϸ� ����
			months[1] = 28;
		}


		// �� 1�� 1�� 1�� ���� �Է¹��� �⵵�� ���� �⵵ 12�� 31�� ������ �� �� ���
		nalsu = (y-1)*365 + (y-1)/4 - (y-1)/100 + (y-1)/400;
		
		//�׽�Ʈ
		// System.out.println(nalsu);
		// 1.1.1 ~ 1996.12.31
		

		// �� �ش� �⵵�� 1�� 1�� ���� �Է� ���� ���� ���� �������� 
		//    �� �� ��� �� 1�� ����� ���ϴ� ����
		for (i=0; i<(m-1) ;i++ )
		{
			nalsu += months[i];
		}
		
		//�׽�Ʈ
		// System.out.println(nalsu);
		// 1.1.1 ~ 1997.9.30


		// �� �Է¹��� ���� ��¥��ŭ �� �� ��� ��
		//	  2�� ����� ���ϴ� ����
		nalsu += d;			//-- �� ���� d��ŭ �������Ѷ�~

		//�׽�Ʈ
		// System.out.println(nalsu);
		// 1.1.1 ~ 1997.10.6


		//------------------------------------------------������� �����ϸ� �� �� ���� ��~!!

		
		// ���� �������� Ȯ���ϱ� ���� ����
		w = nalsu % 7;			// ��ü �� �� % 7 == 0 �� �Ͽ���
								// ��ü �� �� % 7 == 1 �� ������
								// ��ü �� �� % 7 == 2 �� ȭ����
								//				:
								
		//�׽�Ʈ
		// System.out.println(w);
		// --1997 10 6 --==>> 1 �� ������
		//	 2021 02 22--==>> 1 �� ������

		return weekNames[w];
	}

	// �޼ҵ� ���� (��� ����ϱ�)
	void print(String day)
	{
		System.out.printf("\n >> %d�� %d�� %d���� �� %s����\n",y,m,d,day);
		
	}


}


public class Test092
{
	public static void main(String[] args)
	{
		WeekDay wd = new WeekDay();

		wd.input();						//-- �Է¸޼ҵ� ȣ��
		String result = wd.week();		//-- ���� ���� �޼ҵ� ȣ��
		wd.print(result);				//-- ��� ��� �޼ҵ� ȣ��
	}
}

/*
1. �Է¹ޱ�
2. ���� �����ϱ�
-> 
1��1��1�� ������ : ���� �迭 �����
~ ��ĥ ��������(��¥��) ī���� : 
y-1 * 365 + m-1 *  d*1
==>> �����ΰ�� , 30.31�� 
������ 7 : �������� ������ ���ư��� ��¥
3. ��� ���
*/