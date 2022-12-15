/*=========================================
���� ����(Sort) �˰������
- ���� ���� ����(Bubble Sort : ��ǰ ����)
==========================================*/

// �� �ǽ� ����
//	  ����ڷκ��� ���� �л��� ���� �����͸� ���� ���·� �Է¹޾�
//	  ������ ���� ������ ����� �ο��Ͽ� ����� ����ϴ� ���α׷��� �����Ѵ�.
//	  ��, �迭�� ���� �˰����� Ȱ���Ͽ� �ۼ��� �� �ֵ��� �Ѵ�.

// ���� ��)
// �ο� �� �Է� : 5
// �̸� ���� �Է�(1) : ������ 90
// �̸� ���� �Է�(2) : ������ 80
// �̸� ���� �Է�(3) : �Ҽ��� 85
// �̸� ���� �Է�(4) : ������ 75
// �̸� ���� �Է�(5) : ������ 95

// ================
// 1�� ������ 95
// 2�� ������ 90
// 3�� �Ҽ��� 85
// 4�� ������ 80
// 5�� ������ 75
// ================
// ����Ϸ��� �ƹ� Ű��...


import java.util.Scanner;

class Record
{
	String name;
	int score;
}

public class Test105
{
	public static void main(String[] args)
	{
		// ���� �� �迭 ����
		int n;	// �Է¹��� �ο� ��
		Record[] arrStu;	// RecordŸ�� �迭 ����
		
		
		// �ο� �� �Է� �ޱ�
		Scanner sc = new Scanner(System.in);

		do				
		{
			System.out.print("�ο� �� �Է� :");
			n = sc.nextInt();
		}
		while (n<1);
		

		// �迭 ����
		arrStu = new Record [n];	
		
		// �̸� �� ���� �Է� �ޱ�
		for (int i=0;i<arrStu.length; i++)
		{
			arrStu[i] = new Record();	// �ν��Ͻ� ����

			System.out.printf("�̸� ���� �Է�(%d) :",(i+1));

			arrStu[i].name = sc.next();
			arrStu[i].score = sc.nextInt();
		}

		
		// �������� ���� (��������)
		// �� �迭 �����
		int[] temp = new int [n];
		for (int i=0; i<temp.length;i++ )
			temp[i] = arrStu[i].score;


		int i,j;

		for (i=0;i<arrStu.length-1 ;i++ )
		{
			for (j=i+1;j<arrStu.length;j++ )
			{
				if (temp[i] < temp[j])
				{
					// �ڸ� �ٲٱ�
					temp[i] = temp[i]^temp[j];
					temp[j] = temp[j]^temp[i];
					temp[i] = temp[i]^temp[j];
				}
			}
		}

		// �׽�Ʈ
		// for (int k=0;k<temp.length ; k++)
			// System.out.print(temp[k] + " ");

		
		// ����ϱ�
		System.out.println("================");
		
		for (i =0 ; i<temp.length; i++)
		{
			for (j=0; j<arrStu.length; j++ )
			{
				if (temp[i] == arrStu[j].score)
				{
					System.out.printf("%d��  ",(j+1));
					System.out.printf("%s  ",arrStu[j].name);
					System.out.printf("%d  ",arrStu[j].score);
				}
			}
			System.out.println();

		}

		System.out.println("================");

	}
}

// ���� �迭�� ��� ������ε� Ǯ���

