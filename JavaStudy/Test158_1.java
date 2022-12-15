/*=================================
 ���� �÷��� (Collection) ����
==================================*/

// �� �ǽ�����
//	  ���� �ۼ����� Test158 Ŭ������ �ϼ��Ͽ�
//	  ���� ����� ���� ���α׷��� �����Ѵ�.

/*
���� ��)
	
	[�޴� ����]
	1. ��� �߰�
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ����
	>> �޴� ���� (1~6) : 1
	
	1��° ��� �Է� : ������
	1��° ��� �Է� ���� ~!!!
	��� �Է� ���(Y/N) : y

	2 ��° ��� �Է� : ������
	2��° ��� �Է� ����~!!!
	��� �Է� ���(Y/N) : n

		[�޴� ����]
	1. ��� �߰�
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ����
	>> �޴� ���� (1~6) : 2

	[���� ��ü ���]
		������
		������

	���� ��ü ��� �Ϸ�~!!!

	[�޴� ����]
	1. ��� �߰�
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ����
	>> �޴� ���� (1~6) : 3

	�˻��� ��� �Է� : ������

	[�˻� ��� ���]
	�׸��� �����մϴ�.

		[�޴� ����]
	1. ��� �߰�
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ����
	>> �޴� ���� (1~6) : 4

	������ ��� �Է� : ������

	[���� ��� ���]
	�׸��� �������� �ʾ� ������ �� �����ϴ�.
	���������� ������ �Ϸ�Ǿ����ϴ�.

		[�޴� ����]
	1. ��� �߰�
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ����
	>> �޴� ���� (1~6) : 5

	������ ��� �Է� : ������
	������ ���� �Է� : ������

	[���� ��� ���]
	������ �Ϸ�Ǿ����ϴ�.
	
		[�޴� ����]
	1. ��� �߰�
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ����
	>> �޴� ���� (1~6) : 6
	
	���α׷� ����
	>> ����Ϸ��� �ƹ� Ű��...

*/

import java.util.Vector;
import java.util.Scanner;
import java.io.IOException;

public class Test158_1
{
	public static void main(String[] args) throws IOException
	{
		int n;				//-- �Է� �޴� �޴� ��ȣ
		Vector<String> v = new Vector<String>();		//-- ���� �ڷᱸ�� �ν��Ͻ� ����

		String str;			//-- �Է� �޴� ��ҵ�
		char yn;			//-- y/n �Է�
		int i=1;			//-- ��� �Է� �� ��µǴ� ��ȣ
		String daum;		//-- �˻� �� �Է� ���� ���
		String rem;			//-- ���� �� �Է� ���� ���
		int in;				//-- ���� �� Ȯ�� �� �ε���
		String change;		//-- ���� �� �Է� ���� ���
		String change2;		//-- ���� �� ������ ��

		Scanner sc = new Scanner(System.in);

		while(true)
		{
			do
			{
				System.out.println("\t [�޴� ����]");
				System.out.println("1. ��� �߰�");
				System.out.println("2. ��� ���");
				System.out.println("3. ��� �˻�");
				System.out.println("4. ��� ����");
				System.out.println("5. ��� ����");
				System.out.println("6. ����");
				System.out.print(">> �޴� ���� (1~6) :");
				n = sc.nextInt();
				System.out.println();
					


				if (n==1)
				{
					do
					{
						System.out.printf("%d��° ��� �Է� :",(i));
						str = sc.next();
						v.add(str);
						System.out.printf("%d��° ��� �Է� ���� ~!!!\n",i);
						System.out.print("��� �Է� ���(Y/N) : ");
						yn = (char)System.in.read();
						i++;
					}
					while (yn == 'y' || yn == 'Y');
				}

				if (n==2)
				{
					System.out.println("	[���� ��ü ���]");
					for (String yoso : v)
						System.out.printf("%s\n",yoso);
				}

				if (n==3)
				{
					System.out.print("�˻��� ��� �Է� : ");
					daum = sc.next();

					System.out.println("\t[�˻� ��� ���]");
					if (v.contains(daum))
						System.out.println("�׸��� �����մϴ�.");
					else
						System.out.println("�׸��� �������� �ʽ��ϴ�.");
				}

				if (n==4)
				{
					System.out.print("\t[���� ��� ���] : \n");

					
					System.out.print("������ ��� �Է� : ");
					rem = sc.next();

					if (v.contains(rem))
					{
						in = v.indexOf(rem);
						v.remove(in);
						System.out.println("���������� ������ �Ϸ�Ǿ����ϴ�.");
					}
					else
						System.out.println("�׸��� �������� �ʾ� ������ �� �����ϴ�.");
				}

				if (n==5)
				{
					System.out.print("������ ��� �Է� :");
					change = sc.next();

					if (v.contains(change))
					{
						in = v.indexOf(change);
						System.out.print("������ ���� �Է� :");
						change2 = sc.next();

						v.set(in,change2);
						System.out.println("\t[���� ��� ���]");
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					}
					else
						System.out.println("���� ����� �������� �ʽ��ϴ�.");
				}

				if (n==6)
					return;

			
			}
			while (n<0 || n>5);
		}


	}
	
	
	
}