/*===============================
���� ���� �帧�� ��Ʈ��(���) ����
- �ݺ��� (while��) �ǽ�
===============================*/

// ����ڷκ��� ������ ������ �Է¹޾�
// �Է¹��� ������... �Ҽ����� �ƴ����� �Ǻ��Ͽ�
// ����� ����ϴ� ���α׷��� �����Ѵ�.

// ���� ��)
// ������ ���� �Է� : 10
// 10 �� �Ҽ� �ƴ�
// ����Ϸ��� �ƹ� Ű��...

// ������ ���� �Է� : 11
// 11 �� �Ҽ� 
// ����Ϸ��� �ƹ� Ű��...

// �� �Ҽ�  = 1 �Ǵ� �ڱ� �ڽ��� �� �̿��� � ���ε� ���� �� ���� ��
//			  ��, 1�� �Ҽ��� �ƴ�


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test050
{
	public static void main(String[] args) throws IOException
	{
		// ���� �� Ǯ��
		/*
		int n;

		while (true)
		{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("������ ���� �Է� : ");
		n = Integer.parseInt(br.readLine());
		
		if (n ==2 || n==3 || n==5 || n==7)
		{
			System.out.printf("%d �� �Ҽ�\n",n);
		}
		else if (n%2 == 0)
		{
			System.out.printf("%d �� �Ҽ� �ƴ�\n", n);
		}
		else if (n%3 == 0)
		{
			System.out.printf("%d �� �Ҽ� �ƴ�\n", n);
		}
		else if (n%5 == 0)
		{
			System.out.printf("%d �� �Ҽ� �ƴ�\n", n);
		}
		else if (n%7 == 0)
		{
			System.out.printf("%d �� �Ҽ� �ƴ�\n", n);
		}

		else
			System.out.printf("%d �� �Ҽ�\n",n);

		break;

		}
		*/


		// �Բ� �� Ǯ��
		
		// �� �ֿ� ���� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num;		//-- ����ڰ� �Է��ϴ� ������ ������ ��� �� ����
		
		// �� ���� �� ó��
		System.out.print("������ ���� �Է� : ");
		num = Integer.parseInt(br.readLine());		//89

		// 2  3 4 5 ... 88 ���� ��������
		// ��           

		int n = 2;		//-- ������� �Է°��� �������
						//   ������ ������ ������ ���� (1�� ���� ����)

		// String temp = "�Ҽ���~";
		boolean flag = true;		//-- �Ҽ���

		while (n<num)		// n�� num�� �Ǵ°� ���� �ȵ�
		{
			if (num%n==0)
			{
				flag = false;		//-- �Ҽ� �ƴϴ�
				// System.out.println(n);
				// break;			//-- while�� Ż��
			}

			n++;

		}

		// temp = "�Ҽ� �ƴ�";
		//flag = flalse;


		// �� ��� ���
		// (��� ���� �����ؾ� �� �߰� Ȯ�� �� 1���� ���ο� ���� Ȯ��
		//	�Ҽ��� && 1�� �ƴϴ�
		//	�� �������� ������� �Ҽ���
		//  �׷��� ������
		//	�� �������� ������� �Ҽ� �ƴϴ�

		if (flag && num!=1)				//-- flag�� �̹� true
		{
			System.out.printf("%d �� �Ҽ�!\n", num);

		}
		else
		{
			System.out.printf("%d �� �Ҽ��ƴ�!\n",num);
		

		}

	}
}

/*
[���� ���]
������ ���� �Է� : 2
2 �� �Ҽ�!
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ ���� �Է� : 10
10 �� �Ҽ��ƴ�!
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/