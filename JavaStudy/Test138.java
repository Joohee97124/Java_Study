/*======================================
���� �ڹ��� �ֿ�(�߿�) Ŭ���� ����
- Calendar Ŭ����
======================================*/

/*
�� java.util.Calendar Ŭ������
   ��¥�� �ð��� ��ü �𵨸�ȭ �� Ŭ������
   ��, ��, ��, ����, ��, ��, �� ������
   �ð��� ��¥�� ���õ� ������ �����Ѵ�.
   �׸���, Calendar Ŭ������ �߻�Ŭ�����̹Ƿ� ���� ��ü�� ������ �� ������
   �������� �޼ҵ� ������ Calendar Ŭ������ ���� Ŭ������
   ��GregorianCalendar�� Ŭ������ ���ǵǾ� �ִ�.

   �ý������κ��� ���� �ý��� �ð� ������ ���� ��
   ��getInstance()�� ��� ����(static) �޼ҵ带 �̿��Ͽ� ��ü�� ������ �� �ִ�.
   ������ Calendar Ŭ���� ��ü�� �ý����� ���� ��¥�� �ð� ������ ������,
   �� ��ü�� �����Ǹ� ���� �ִ� �ð� �������� 
   ��get()���޼ҵ带 �̿��Ͽ� ���� ������(�����) �� �ִ�.
	
	��getInstance()���޼ҵ�� ���������� GregorianCalendar ��ü�� �����Ͽ�
	�����ֱ� ������ GregorianCalendar ��ü�� ���� �����Ͽ� ��¥ �ð� ������
	���� ���� �ִ�.
*/

// �� �ǽ� ����
//	  ����ڷκ��� ��, ���� �Է¹޾�
//	  �ش� �� ���� �޷��� �׷��ִ�(����ϴ�) ���α׷��� �����Ѵ�.
//	  ��, Calendar Ŭ������ Ȱ���Ͽ� �ۼ��� �� �ֵ��� �Ѵ�.

// ���� ��)
// ���� �Է� : 0
// ���� �Է� : 2021
// �� �Է� : -2
// �� �Է� : 16
// �� �Է� : 7
/*
	[ 2021�� 7�� ]

 �� �� ȭ �� �� �� ��
=======================
              1  2  3
  4  5  6  7  8  9 10
 11 12 13 14 15 16 17
 18 19 20 21 22 23 24
 25 26 27 28 29 30 31
=======================
*/

import java.util.Calendar;
import java.util.Scanner;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Test138
{
	public static void main(String[] args) throws IOException
	{
		// ���� �� Ǯ��
		/*
		int y,m;
		Calendar yd = Calendar.getInstance();
		String[] week = {"�Ͽ���", "������", "ȭ����", "������", "�����", "�ݿ���", "�����"};

		
		// ������ �� �Է¹ޱ�
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.print("���� �Է� : ");
			y = sc.nextInt();
		}
		while (y<0);

		do
		{
			System.out.print("�� �Է� : ");
			m = sc.nextInt();
		}
		while (m<1 || m>12);

		
		// set() �޼ҵ�� �Է¹��� �������� 1�� ���� �˾Ƴ���
		yd.set(y, m-1, 1);
		String w = week[yd.get(Calendar.DAY_OF_WEEK) -1 ];
		
		System.out.printf("%s\n",w);


		// ����ϱ�
		System.out.printf ("	[%d�� %d��]	\n",y,m);
		System.out.println("��  ��  ȭ  ��  ��  ��  ��");
		System.out.println("=========================================");
		
		int mon = yd.getActualMaximum(Calendar.DATE);
		// System.out.print(mon);
		int ww = yd.get(Calendar.DAY_OF_WEEK);
		//System.out.print(ww);
 
		// ���� ���
		for (int i=1; i<ww ; i++ )
		{
			System.out.print("    ");
		}
		
		// ��¥ ���
		for (int j=1; j < mon ; j++)
		{
			System.out.printf(" %d ",j);

			if (ww % 7 == 0)
			{
				System.out.println();
			}
			ww ++ ;
		}
		System.out.println();
		*/



		// �Բ� �� Ǯ��
		
		// BufferedReader Ŭ���� �ν��Ͻ� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Calendar �ν��Ͻ� ����
		Calendar cal = Calendar.getInstance();

		// �ֿ� ���� ����
		int y, m;		//-- ��,��
		int w;			//-- ����
		int i;			//-- ��������

		do
		{
			System.out.print("���� �Է� : ");
			y = Integer.parseInt(br.readLine());
		}
		while (y<1);

		do
		{
			System.out.print("�� �Է� : ");
			m = Integer.parseInt(br.readLine());
		}
		while (m<1 || m>12);

		// ����ڷκ��� �Է¹��� ������ ��(y), ��(m)�� �̿��Ͽ� 
		// �޷��� ��¥ ����
		// cal.set(����, ��, ��);
		cal.set(y, m-1, 1);
		//-- �� ���� �� �Է°�(m)�� �״�� ����ϴ� ���� �ƴ϶�
		//	 �Է°����� 1�� �� ������ ���� �����ؾ� �Ѵ�.
		//-- �� ���� �� �Է¹��� ��, ���� �ش��ϴ� 1�Ϸ� �����ؾ� �Ѵ�.
		
		// ���õ� �޷��� ���� ��������
		w = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(w);

		// Ȯ�� (�׽�Ʈ)
		// System.out.println(w);
		//--==>> 2 �� 2021�� 3�� ���� �� ������ �� 2021�� 3�� 1�� : ������
		

		// �� Calendar Ŭ������ ��getActualMaximum()�� �޼ҵ� check~!!!
		
		// Ȯ�� (�׽�Ʈ)
		// System.out.printf("%d\n",cal.getActualMaximum(Calendar.YEAR));
		//--==>> 292278994
		// System.out.printf("%d\n", cal.getActualMaximum(Calendar.MONTH)+1);
		//--==>> 12
		// System.out.printf("%d\n", cal.getActualMaximum(Calendar.DATE));
		//--==>> 31 �� 2021�� 3�� ����
		// System.out.printf("%d\n",cal.getActualMaximum(Calendar.DAY_OF_WEEK));
		//--==>> 7
	
		System.out.printf("%d\n", cal.getActualMaximum(Calendar.DATE));
		//--==>> 28 �� 2021�� 2�� ����

		

		// ��� ��� �� �޷� �׸���
		System.out.println();
		System.out.println("\t [ " + y + "��" + m + "��]\n" );
		System.out.println("  ��  ��  ȭ  ��  ��  ��  �� ");
		System.out.println("==============================");

		// ��¥ �׸��� �����ϴ� �������� ���� �߻�
		for (i=1; i<w ; i++ )
			System.out.print("    ");	// ���� 4ĭ

		// Ȯ�� (�׽�Ʈ)
		//System.out.printf("%4d",1);
		
		// ��¥ �׸���
		for (i=1 ; i<=cal.getActualMaximum(Calendar.DATE) ; i++ )
		{
			System.out.printf("%4d",i);
			w++;	//-- �ݺ����� �����ϸ� ��¥�� ������ ������
					//   ���ϵ� �Բ� ������ �� �ֵ��� ó��

			if (w%7 == 1)	//-- ������ ������ �Ͽ����� �� ������ ���� �� ���
				System.out.println();
		}
		
		if (w%7 !=1 )
			System.out.println();	// ����

		System.out.println("==============================");

	}
}

/* 
[���� ���]
���� �Է� : 2021
�� �Է� : 7
31

         [ 2021��7��]

  ��  ��  ȭ  ��  ��  ��  ��
==============================
                   1   2   3
   4   5   6   7   8   9  10
  11  12  13  14  15  16  17
  18  19  20  21  22  23  24
  25  26  27  28  29  30  31
==============================
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/