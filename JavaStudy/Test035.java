/*===============================
���� ���� �帧�� ��Ʈ��(���) ����
- if�� �ǽ�
===============================*/

// ����ڷκ��� ������ ������ �Է¹޾�
// �Է¹��� ������ 2�� �������, 3�� �������
// 2�� 3�� �������, 2�� 3�� ����� �ƴ��� �Ǻ��Ͽ�
// ����� ����ϴ� ���α׷��� �����Ѵ�.

// ���� ��)
// ������ ���� �Է� : 8
// >> 8 �� 2�� ���~!!!
// ����Ϸ��� �ƹ� Ű��...

// ������ ���� �Է� : 9
// >> 9 �� 3�� ���~!!!
// ����Ϸ��� �ƹ� Ű��...

// ������ ���� �Է� : 6
// >> 6 �� 2�� 3�� ���~!!!
// ����Ϸ��� �ƹ� Ű��...

// ������ ���� �Է� : 11
// >> 11 �� 2�� 3�� ��� �ƴ�~!!!
// ����Ϸ��� �ƹ� Ű��...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test035
{
	public static void main(String[] args) throws IOException
	{
		// ���� �� Ǯ��
		/*
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

		int num; 

		System.out.print("������ ���� �Է� : ");
		num = Integer.parseInt(br.readLine());

		if (num%6 == 0)
		{
			System.out.printf("%d �� 2�� 3�� ���~!!\n",num);
		}
		else if (num%3 == 0)
		{
			System.out.printf("%d �� 3�� ���~!!\n",num);
		}
		else if (num%2 == 0)
		{
			System.out.printf("%d �� 2�� ���~!!\n",num);
		}
		else 
		{
			System.out.printf("%d �� ����ƴ�~!!\n",num);
		}
		*/

		// �Բ� �� Ǯ��
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

		int n;

		System.out.print("������ ���� �Է� : ");
		n = Integer.parseInt(br.readLine());
		
		/* (X)
		if (n%2==0)
		{
			System.out.println(">>" + n + " �� 2�� ���~!!!!");
		}
		else if (n%3 ==0)
		{
			System.out.println(">>" + n + " �� 3�� ���~!!!!");
		}
		else if (n%2==0 && n%3 ==0)
		{
			System.out.println(">>" + n + " �� 2�� 3�� ���~!!!!");
		}
		else if (n!%2==0 && n!%3 ==0)
		{
			System.out.println(">>" + n + " �� 2�� 3�� ����� �ƴ�~!!!!");
		}
		else
		{
			System.out.println(">>�Ǻ��� �Ұ����� ��Ȳ");
		}
		//�� ���� ���� ��Ȳ������ 2�� 3�� ������ (���� ���) ���ǽĿ���
		//   �����ϴ� �����Ͱ� �б� �� �� ���� ��Ȳ�̴�. check~!!
		*/

		if (n%2==0 && n%3 ==0)
		{
			System.out.println(">>" + n + " �� 2�� 3�� ���~!!!!");
		}
		else if (n%2==0)
		{
			System.out.println(">>" + n + " �� 2�� ���~!!!!");
		}else if (n%3 ==0)
		{
			System.out.println(">>" + n + " �� 3�� ���~!!!!");
		}
		else if (n%2!=0 && n%3!=0)
		{
			System.out.println(">>" + n + "�� 2�� 3�� ��� �ƴ�~!!!");
		}
		else
		{
			System.out.println(">>�Ǻ��� �Ұ����� ��Ȳ");
		}



	}
}

/*
[���� ���]
������ ���� �Է� : 2
>>2 �� 2�� ���~!!!!
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ ���� �Է� : 6
>>6 �� 2�� 3�� ���~!!!!
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ ���� �Է� : 3
>>3 �� 3�� ���~!!!!
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ ���� �Է� : 11
>>11�� 2�� 3�� ��� �ƴ�~!!!
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/