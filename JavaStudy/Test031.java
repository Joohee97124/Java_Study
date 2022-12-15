/*===============================
���� ���� �帧�� ��Ʈ��(���) ����
- if�� �ǽ�
===============================*/

// ����ڷκ��� �̸�, ��������, ��������, ���������� �Է¹޾�
// ������ ���� ���·� ����ϴ� ���α׷��� �����Ѵ�.
// ��, BufferedReader �� reaLine()�� ���� �Է¹��� �� �ֵ��� �ϸ�
// printf() �� ���� ����� �� �ֵ��� �Ѵ�.

// ���� ��)
// �̸� �Է� : ������
// ���� ���� : 90
// ���� ���� : 80
// ���� ���� : 70

// >> ����� �̸��� �������Դϴ�.
// >> ���� ������ 90,
// >> ���� ������ 80,
// >> ���� ������ 70,
// >> ������ 240�̰�, ����� 80�Դϴ�.
// >> ����� B �Դϴ�.
// ����Ϸ��� �ƹ�Ű�� ...

// �� �� ��, ����� ��� ������ �������� ó���Ѵ�.
// 90�� �̻�			 : A		
// 80�� �̻� ~ 89�� �̸� : B 
// 70�� �̻� ~ 79�� �̸� : C		
// 60�� �̻� ~ 69�� �̸� : D
// 60�� �̸�			 : F


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test031
{
	public static void main(String[] args) throws IOException
	{
		// ���� �� Ǯ��
		/*
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		String name;
		int kor, eng, mat, tot, eve;
		char rank;

		System.out.print("�̸� �Է� : ");
		name = br.readLine();

		System.out.print("���� ���� �Է� : ");
		kor = Integer.parseInt(br.readLine());
		
		System.out.print("���� ���� �Է� : ");
		eng = Integer.parseInt(br.readLine());

		System.out.print("���� ���� �Է� : ");
		mat = Integer.parseInt(br.readLine());

		tot = kor + eng + mat;
		eve = tot/3;

		System.out.printf("����� �̸��� %s�Դϴ�.\n", name);
		System.out.printf("���� ������ %d,\n", kor);
		System.out.printf("���� ������ %d,\n", eng);
		System.out.printf("���� ������ %d,\n", mat);
		System.out.printf("������ %d �̰�, ����� %d �Դϴ�.\n", tot, eve);
		

		if (eve >= 90)
		{
			System.out.printf("����� A�Դϴ�\n");
		}
		
		else if(80 <= eve && eve <= 91)
		{
			System.out.printf("����� B�Դϴ�\n");
		}
		else if(70 <= eve && eve <= 81)
		{
			System.out.printf("����� C�Դϴ�\n");
		}
		else if(60 <= eve && eve<= 71)
		{
			System.out.printf("����� D�Դϴ�\n");
		}
		else if(eve < 60)
		{
			System.out.printf("����� F�Դϴ�\n");
		}
		*/


		// �Բ� �� Ǯ��
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		String name;				//-- �̸�
		int kor, eng, mat;			//-- ����, ����, ����
		int tot;					//-- ����
		double avg;					//-- ���
		char grade;					//-- ���
		// char grade = 'F';		// 1) �ʱ�ȭ �صΰų�
		
		System.out.print("�̸� �Է� : ");
		name = br.readLine();
		System.out.print("���� ���� : ");
		kor = Integer.parseInt(br.readLine());
		System.out.print("���� ���� : ");
		eng = Integer.parseInt(br.readLine());
		System.out.print("���� ���� :");
		mat = Integer.parseInt(br.readLine());

		// ���� ����
		tot = kor + eng + mat;

		// ��� ����
		avg = tot / 3.0;

		// ��� ����
		if (avg >= 90)		// 90�� �̻�
		{
			grade = 'A';
		}
		else if(avg >= 80)	//else if (avg >= 80 && avg < 90)
		{
			grade = 'B';
		}
		else if(avg >=70)
		{
			grade = 'C';
		}
		else if (avg >= 60)
		{
			grade = 'D';
		}
		else
		{
			grade = 'F';
		}
		// 2) else�� ó�����ֱ� , else if (avg < 60)


		System.out.println();
		System.out.printf(">> ����� �̸��� %s �Դϴ�.\n", name);
		System.out.printf(">> ���� ������ %d,\n", kor);
		System.out.printf(">> ���� ������ %d,\n", eng);
		System.out.printf(">> ���� ������ %d,\n", mat);
		System.out.printf(">> ������ %d�̰�, ����� %.2f�Դϴ�.\n",tot,avg);
		System.out.printf(">> ����� %c �Դϴ�.\n",grade);

	}
}

/*
[���� ���]
�̸� �Է� : ������
���� ���� : 90
���� ���� : 80
���� ���� :70

>> ����� �̸��� ������ �Դϴ�.
>> ���� ������ 90,
>> ���� ������ 80,
>> ���� ������ 70,
>> ������ 240�̰�, ����� 80.00�Դϴ�.
>> ����� B �Դϴ�.
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .


�̸� �Է� : �谡��
���� ���� : 90
���� ���� : 90
���� ���� :90

>> ����� �̸��� �谡�� �Դϴ�.
>> ���� ������ 90,
>> ���� ������ 90,
>> ���� ������ 90,
>> ������ 270�̰�, ����� 90.00�Դϴ�.
>> ����� A �Դϴ�.
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

*/
