/*===============================
���� ���� �帧�� ��Ʈ��(���) ����
- if�� �ǽ�
===============================*/

// ����ڷκ��� ������ ������ �� �� �Է¹޾�
// ���� �� ���� ū �� ������ ����ϴ� ���α׷��� �����Ѵ�.

// ���� ��)
// ù ��° ���� �Է� : 45
// �� ��° ���� �Է� : 81
// �� ��° ���� �Է� : 13

// >> ���� ��� : 13 45 81
// ����Ϸ��� �ƹ� Ű��...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test036
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		

		/*
		// ���� �� Ǯ��

		int n1,n2,n3;

		System.out.print("ù ��° ���� �Է� : ");
		n1 = Integer.parseInt(br.readLine());

		System.out.print("�� ��° ���� �Է� : ");
		n2 = Integer.parseInt(br.readLine());

		System.out.print("�� ��° ���� �Է� : ");
		n3 = Integer.parseInt(br.readLine());
		
		
		// ���� ���� �߽����� ã��
		if (n1<n2 && n1<n3)
		{
			if(n2<n3)
				System.out.printf("%d %d %d\n",n1,n2,n3);
			else
				System.out.printf("%d %d %d\n",n1,n3,n2);
		}
		else if (n2<n1 && n2<n3)
		{
			if(n1<n3)
				System.out.printf("%d %d %d\n",n2,n1,n3);
			else
				System.out.printf("%d %d %d\n", n2,n3,n1);
		}
		else if (n3<n1 && n3<n2)
		{
			if (n1<n2)
				System.out.printf("%d %d %d\n",n3,n1,n2);		
			else
				System.out.printf("%d %d %d\n",n3,n2,n1);
		}
		else
			System.out.printf("�߸� �Է��ϼ̽��ϴ�.");
		*/


		// �Բ� �� Ǯ��

		int a, b, c;		//-- ����ڰ� �Է��ϴ� ������ ������ ���� ����
		int temp;			//- �ӽ� ���� ���� (�� ��)

		System.out.print("ù ��° ���� �Է� : ");
		a = Integer.parseInt(br.readLine());

		System.out.print("�� ��° ���� �Է� : ");
		b = Integer.parseInt(br.readLine());

		System.out.print("�� ��° ���� �Է� : ");
		c = Integer.parseInt(br.readLine());
		

		// 2 2 2 | 3 2 1	| 2 1 3	 | 3 1 2	| 1 3 2	| 1 2 3 
		//		 | 2 3 1	| 1 2 3	 | 1 3 2	| 1 2 3
		//       | 2 1 3			 | 1 2 3 
		//		 | 1 2 3	

		
		if (a>b)		// �� ù ��° ������ �� ��° �������� ũ�ٸ�....
		{
			// �� ����(a�� b)�� �ڸ��� �ٲ۴�. 
			temp = a;
			a = b;
			b = temp;
		}

		if(b>c)	// �� �� ��° ������ �� ��° �������� ũ�ٸ�...
		{
			// �� ����(b�� c)�� �ڸ��� �ٲ۴�.
			temp = b;
			b = c;
			c = temp;
		}

		if (a>b)	// �� ù ��° ������ �� ��° �������� ũ�ٸ�...
		{
			// �� ����(a�� b)�� �ڸ��� �ٲ۴�.
			temp = a;
			a = b;
			b = temp;
		}
		// �̴� ������ �������� �ܵ� if���� �� (else if�� ���̸� 3�� ��ü�� �������� �ʱ� ����)

		System.out.printf(">> ���� ��� : %d %d %d\n", a, b, c);	
		// if������ �ڸ��� �ٲ��ִϱ� �׳� abc������� ������ ��
	}
}
/* 
[���� ���]
ù ��° ���� �Է� : 45
�� ��° ���� �Է� : 8
�� ��° ���� �Է� : 13
>> ���� ��� : 8 13 45
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/