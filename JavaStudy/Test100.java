/* ================================
���� ���� �޷� ����
==================================*/

// �� ������ ���� ���α׷��� �����Ѵ�.

// ���� ��)
// ���������� �Է��ϼ��� : 2021
// �������� �Է��ϼ��� : 7
/*
	[ 2021�� 7�� ]

  �� �� ȭ �� �� �� ��
=========================
			   1  2  3
   4  5  6  7  8  9 10
  11 12 13 14 15 16 17
  18 19 20 21 22 23 24
  25 26 27 28 29 30 31
=========================
����Ϸ��� �ƹ�Ű��...
*/


// ���� �� Ǯ��
/*
import java.util.Scanner;

class MakeCaledar
{
	private int y,m;		// �Է¹޴� ����, ��
	private String [] yoil = {"��", "��", "ȭ","��","��","��","��"};
	private int [] month = {31,0,31,30,31,30,31,31,30,31,30,31};
	private int count;				// �� ��¥ ���� ����
	private int nan;				// count%7
	//int [] calendar = new int [35];			// �� ���� �޷� ��� �� �� �迭 ����
	int [] calendar;
	int value=1;						// �޷¿� ��� �Ǵ� ��
	private int a;						// ����-1 �ε����� ���� ���� ����

	public void input()				// ������ �� �Է¹ޱ�
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("���������� �Է��ϼ��� : ");
		y = sc.nextInt();

		System.out.print("�������� �Է��ϼ��� :");
		m = sc.nextInt();
	}

	public void set()				// 2�� ���� �迭�� �� �ֱ�
	{
		if (y%4==0 && y%100!=0 || y%400==0)
		{
			month[1] = 29;
		}
		else
			month[1] = 28;
	}

	public void cal()				// �Է¹��� ���� 1���� ���� ���� ���� ã��
	{
		count += y*365 + y/4 - y/100 + y/400;
	
		for (int i=0;i<m-1 ; i++ )
		{
			count += month[i];
		}

		count += 1;				// �Է¹��� ���� 1��

		nan = count%7;			// ������ ã�� ���� 7�� ������ ������ ���� nan�� ����
		
		System.out.printf("%s\n",yoil[nan-1]);
		a = nan-1;
		System.out.println(a);
	}


	public void preprint()		// 7���� ���缭 ��¥�� ����ϱ� ���� �غ� (�� �ֱ�)
	{
			calendar = new int[month[m]];
			
			for (int i=a; i< month[m]  ; i++)
			{				
				calendar[i] = value;
				value++;

			}
	}
	

	public void print()
	{
		System.out.printf("[ %d�� %d�� ]\n",y,m);
		System.out.println();
		
		for (int i=0; i<yoil.length ; i++ )
			System.out.print(yoil[i] + "	");
			

		System.out.println();
		System.out.println("=================================================");
		
		
		for (int i=0;i<a ;i++ )
		{
			System.out.print("	");	
		}

		for (int i=a; i<7; i++ )
		{
			System.out.print(calendar[i] + "	");
		}
		System.out.println();

		for (int i=7; i<14 ; i++ )
		{
			System.out.print(calendar[i] + "	");
		}
		System.out.println();

		for (int i=14; i<21 ; i++ )
		{
			System.out.print(calendar[i] + "	");
		}
		System.out.println();

		for (int i=21; i<28 ; i++ )
		{
			System.out.print(calendar[i] + "	");
		}
		System.out.println();

		for (int i=28; i<calendar.length  ; i++ )
		{
			System.out.print(calendar[i] + "	");
		}
		System.out.println();

		System.out.println("================================================");
	}
}

*/

// �Բ� �� Ǯ��
/*
�� ���� �ν� �� �м�

	- ���� 1�� 1�� 1�� : ������
	- ������ 4�� ����̸鼭 100�� ����� �ƴϰų�,
	  400�� ����̸� 2���� 29��(����),
	  ������ 2���� 28��(���)

	- 2021�� 7���� �޷��� �׸��ٰ� �����ϸ�
	  1. 1. 1 ~ 2021.6.30 ������ ��ü �� ���� ���Ѵ�.
	  �� �� ���� +1 ������ �����ϸ�...(2021�� 7�� 1���� ���� Ȯ��)
	  7���� �޷��� �׸� �غ� ��~!!

	- ���� = ��ü �� �� % 7
	  ���� = 0 �� �Ͽ���
			 1 �� ������
			 	 :
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test100
{
	public static void main(String[] args) throws IOException
	{

		// ���� �� Ǯ��
		/*
		MakeCaledar ob = new MakeCaledar();

		ob.input();
		ob.set();
		ob.cal();
		ob.preprint();
		ob.print();
		*/


		// �Բ� �� Ǯ��

		// BufferedReader Ŭ���� �ν��Ͻ� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// �迭 ���� �� �ʱ�ȭ
		// �� ���� ����ִ� ������ ��¥ (�� ���� �ִ� ��¥)
		int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

		// Ȯ��
		// System.out.println(days.length);
		//--==>> 12

		// �ֿ� ���� ����
		int nalsu, y, m, w;			//-- ����, ��, ��, ����

		do
		{
			System.out.print("���������� �Է��ϼ��� :");
			y = Integer.parseInt(br.readLine());
		}
		while (y<1);

		do
		{
			System.out.print("�������� �Է��ϼ��� :");
			m = Integer.parseInt(br.readLine());
		}
		while (m<1 || m>12);

		//----------------------------- ������� �����ϸ� ��ȿ�� ����, �� �Է��� ����~!!

		// �Է¹��� �⵵�� �ش��ϴ� 2���� ������ �� ���
		if ((y%4==0 && y%100!=0 || y%400==0))				//-- �����̶��....
		{	
			days[1] = 29;
		}
		else
		{
			days[1] = 28;
		}
		//-- else ������
		//	 ����  days �迭�� 1��° ��Ұ� �⺻������ 28�� �ԷµǾ� �ִ�
		//	 �����̱� ������ ������ ������ ������ �ȴ�.

		// 1�� 1�� 1�� ~ �Է¹��� �⵵�� �����⵵�� 12�� 31�� ������
		// �� �� ���
		nalsu = (y-1)*365 + (y-1)/4 - (y-1)/100 + (y-1)/400;

		// Ȯ��
		// System.out.println(nalsu);
		/*
		���������� �Է��ϼ��� :2021
		�������� �Է��ϼ��� :7
		737790						�� 1.1.1 ~ 2018.12.31
		����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
		*/

		// �Է¹����⵵ (�ش�⵵) 1�� 1�� ~ �Է��� ���� ���� ��������
		// �� �� ���� ����
		// ��, ���� ���� ������...
		// 2019�� 1�� 1�� ~ 2019�� 4�� 30�� ������ �� �� �����Ͽ�
		// ���� nalsu�� ����
		for (int i=0; i<(m-1) ; i++ )			// i<(m-1) check~!!!
			nalsu += days[i];

		// Ȯ��
		// System.out.println(nalsu);
		/*
		���������� �Է��ϼ��� :2019
		�������� �Է��ϼ��� :5
		737179						�� 1.1.1 ~ 2019.4.30
		����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
		*/

		// �Է¹��� ���� 1��
		nalsu += 1;				// ++nalsu;

		// Ȯ��
		// System.out.println(nalsu);
		//--==>>737180
		/*
		���������� �Է��ϼ��� :2019
		�������� �Է��ϼ��� :5
		737180			�� 1.1.1 ~ 2019.5.1
		����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
		*/
		
		//--------------------------------������� �����ϸ� ��� �� ���� ���� ���� �Ϸ�~

		// ���� ����
		// : �Է¹��� ���� 1���� ���� �������� Ȯ���ϱ� ���� ����
		w = nalsu % 7;		//-- 0:�Ͽ���, 1:������, 2:ȭ���� ...

		// Ȯ��
		// System.out.println(w);
		//--==>>
		/*
		���������� �Է��ϼ��� :2019
		�������� �Է��ϼ��� :5
		3							�� 2019�� 5�� 1�� �� ������
		����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
		*/


		// ��� (�޷� �׸���)
		System.out.println();
		System.out.println("\t [ " +y + "��" + m + "�� ]");
		System.out.println("  ��  ��  ȭ  ��  ��  ��  ��");	// ��ĭ ����
		System.out.println("==============================");
		
		// Ư�� ���Ϻ��� 1���� ��� �� �� �ֵ��� ���� �߻�(����)
		for (int i=1; i<=w ; i++ )
			System.out.print("    ");							// �� ĭ ����
		
		// Ȯ��  
		// System.out.printf("%4d",1);

		// �ش� ��(�Է��� ��)�� ��¥�� ��µ� �� �ֵ��� �ݺ��� ����
		for (int i=1; i<= days[m-1] ; i++ )
		{
			System.out.printf("%4d",i);
			w++;

			if (w%7 == 0)	// �Ͽ��ϸ���
			{
				System.out.println();	// ����
			}
		}
		
		// ���� ������ ��¥�� ��� ������ ��� ä���� ���
		// �̹� �Ͽ��� ������ �̷������ ������
		// �� ��쿡�� �߰� ������ ���� �ʵ��� ó��
		if (w%7!=0)
			System.out.println();

		System.out.println("==============================");
	}
}