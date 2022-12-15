/*=============================
  ���� �迭(array) ����
  - �迭�� �⺻���� Ȱ��
=============================*/

// �� ����
// ����ڷκ��� �л� ���� �Է¹ް�, �� ��ŭ�� ����(��������)�� �Է¹޾�
// ��ü �л� ������ ��, ���, ������ ���Ͽ� ����� ����ϴ� ���α׷��� �����Ѵ�.
// ��, �迭�� Ȱ���Ͽ� ó���� �� �ֵ��� �Ѵ�.
// ���� = ��� �������� ����

// ���� ��)
// �л� �� �Է� : 5
// 1�� �л��� ���� �Է� : 90
// 2�� �л��� ���� �Է� : 82
// 3�� �л��� ���� �Է� : 64
// 4�� �л��� ���� �Է� : 36
// 5�� �л��� ���� �Է� : 98

// >> ��   : 370
// >> ��� : 74.0
// >> ����
// 90 : -16.0
// 82 : -8.0
// 64 : 10.0
// 36 : 38.0
// 98 : -24.0
// ����Ϸ��� �ƹ� Ű��...

import java.util.Scanner;

public class Test085
{
	public static void main(String[] args)
	{
		// ���� ����
		int n;					// �л��� ���� ����
		double sum=0, avg=0, dev=0;		// ��, ���, ���� ���� ����
		
		// �л� �� �Է� �ޱ�
		Scanner sc = new Scanner(System.in);

		System.out.print("�л� �� �Է� :");
		n = sc.nextInt();
		
		// �л� ���� �迭 ����
		int [] arrScore = new int [n];

		// �迭 �ʱ�ȭ
		for (int i=0;i<arrScore.length ; i++)
		{
			System.out.printf("%d�� �л��� ���� �Է� :",(i+1));
			arrScore[i] = sc.nextInt();
		}
	
		System.out.println();

		// �� ���
		for (int i=0;i<arrScore.length ;i++ )
		{
			sum += arrScore[i];
		}
		System.out.printf(">> ��   : %.1f\n",sum);

		// ��� ���
		for (int i=0;i<arrScore.length ;i++ )
		{
			avg = sum / (double) n;
		}
		System.out.printf(">> ��� : %.1f\n",avg);


		// ���� �迭 ���� �� �ʱ�ȭ �� ���
		double [] arrDev = new double [n];
		
		System.out.println(">> ����");
		for (int i=0;i<arrDev.length ;i++ )
		{
			arrDev[i] = avg - (double)arrScore[i];
			System.out.printf("%d : %.1f\n",arrScore[i], arrDev[i]);
		}
		

	}
}
/*
[���� ���]
�л� �� �Է� :3
1�� �л��� ���� �Է� :100
2�� �л��� ���� �Է� :20
3�� �л��� ���� �Է� :35

>> ��   : 155.0
>> ��� : 51.7
>> ����
100 : -48.3
20 : 31.7
35 : 16.7
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/