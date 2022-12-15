/*======================================
���� Ŭ���� ��ޡ���
- �������̽�(Interface)
======================================*/

// �� �ǽ� ����
//	  ���� ó�� ���α׷��� �����Ѵ�.
//	  ��, �������̽��� Ȱ���� �� �ֵ��� �Ѵ�.

// ���� ��)
// �ο� �� �Է�(1~10) : 2
// 1�� ° �л��� �й� �̸� �Է� (���� ����) : 2104256 �ڹ��� 
// ���� ���� ���� ���� �Է� (���鱸��) : 90 100 85
// 2�� ° �л��� �й� �̸� �Է� (���� ����) : 2104257 �輭��
// ���� ���� ���� ���� �Է� (���鱸��) : 85 70 65

// 2104256 �ڹ���	90 100  85	275 91 
//					��  ��  �� 
// 2104257 �輭��	85  70  65	220 73
//					��  ��  ��

// ����Ϸ��� �ƹ� Ű��...

// 90 ~ 100 : ��
// 80 ~ 89 : ��
// 70 ~ 79 : ��
// 60 ~ 69 : ��
// ������  : ��

// �Ӽ��� �����ϴ� Ŭ���� �� �ڷ��� Ȱ��

import java.util.Scanner;

class Record
{
	String hak, name;		//-- �й�, �̸�
	int kor, eng, mat;		//-- ����, ����, ���� ����
	// int[] score = new int[3];	//-- ����, ����, ���� ������ �迭�� ó��
	int tot, avg;			//-- ����, ���(���ǻ� ���� ó��)
}

// �������̽�
interface Sungjuk
{
	public void set();
	public void input();
	public void print();
}

// ���� �ذ� �������� �����ؾ� �� Ŭ����
class SungjukImpl implements Sungjuk
{
	int n;				//-- �Է¹��� �ο� ��
	Record[] arrStu;	//-- Record Ÿ���� �迭 ����

	public void set()
	{
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.print("�ο� �� �Է�(1~10) :");
			n = sc.nextInt();
			arrStu = new Record[n];
		}
		while (n<1 || n>10);
	}


	public void input() 
	{
		Scanner sc = new Scanner(System.in);

		for (int i=0; i<arrStu.length ; i++ )
		{
			arrStu[i] = new Record();

			System.out.printf("%d�� ° �л��� �й� �̸� �Է� (���� ����) :",(i+1));
			arrStu[i].hak = sc.next();
			arrStu[i].name = sc.next();

			System.out.print("���� ���� ���� ���� �Է� (���鱸��) :");
			arrStu[i].kor = sc.nextInt();
			arrStu[i].eng = sc.nextInt();
			arrStu[i].mat = sc.nextInt();

			arrStu[i].tot = arrStu[i].kor + arrStu[i].eng + arrStu[i].mat;
			
			arrStu[i].avg = arrStu[i].tot / n;
		}
	}

	public void print()
	{
		for (int i=0; i<arrStu.length ; i++ )
		{
			System.out.print(arrStu[i].hak + " ");
			System.out.print(arrStu[i].name + " ");

			System.out.print("    ");
			System.out.print(arrStu[i].kor  + " ");
			System.out.print(arrStu[i].eng + " ");
			System.out.print(arrStu[i].mat + " ");

			System.out.print("    ");
			System.out.print(arrStu[i].tot + " ");
			System.out.print(arrStu[i].avg + " ");
		

			System.out.println();

			/*
			// ����,����,���� ������ �迭�� ó�� �� ��� ����̾簡 ���
			for (int j=0 ; j<3 ; j++ )
			{
				int a = arrStu[i].score[j] /10;

				switch (a)
				{
				case 10 : System.out.print("��  "); break;
				case 9 : System.out.print("��  "); break;
				case 8 : System.out.print("��  "); break;
				case 7 : System.out.print("��  "); break;
				case 6 : System.out.print("��  "); break;
				default : System.out.print("��  ");
				}
			}
			*/


			int a = arrStu[i].kor / 10;
			int b = arrStu[i].eng / 10;
			int c = arrStu[i].mat / 10;

			System.out.print("\t");

			switch (a)
			{
			case 10 : System.out.print("��  "); break;
			case 9 : System.out.print("��  "); break;
			case 8 : System.out.print("��  "); break;
			case 7 : System.out.print("��  "); break;
			case 6 : System.out.print("��  "); break;
			default : System.out.print("��  ");
			}

			switch (b)
			{
			case 10 : System.out.print("��  "); break;
			case 9 : System.out.print("��  "); break;
			case 8 : System.out.print("��  "); break;
			case 7 : System.out.print("��  "); break;
			case 6 : System.out.print("��  "); break;
			default : System.out.print("��  ");
			}

			switch (c)
			{
			case 10 : System.out.print("��  "); break;
			case 9 : System.out.print("��  "); break;
			case 8 : System.out.print("��  "); break;
			case 7 : System.out.print("��  "); break;
			case 6 : System.out.print("��  "); break;
			default : System.out.print("��  ");
			}

			System.out.println();

		}
	}

}



public class Test116
{
	public static void main(String[] args)
	{
		SungjukImpl ob0 = new SungjukImpl();
		// check~!!
		// Sungjuk �� �������̽�
		Sungjuk ob = (Sungjuk)ob0;
		
		// ���� �ذ� �������� �ۼ��ؾ� �� ob ����

		ob.set();
		ob.input();
		ob.print();
	}
}