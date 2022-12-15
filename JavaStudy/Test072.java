/*======================================
���� Ŭ������ �ν��Ͻ� ����
- Ŭ���� ���� ���� �� Ŭ���� ���� �ǽ�
=======================================*/

// ����ڷκ��� ������ ������ �Է¹޾�
// 1���� �Է¹��� �� ������ ���� �����Ͽ�
// ����� ����ϴ� ���α׷��� �����Ѵ�.

// ��, Ŭ������ �ν��Ͻ��� ������ Ȱ���Ͽ� ó���� �� �ֵ��� �Ѵ�.
// ����, �Է� ó�� �������� BufferedReader�� readLine()�� ����ϸ�,
// �Է¹��� �����Ͱ� 1���� �۰ų� 1000���� ū ���
// �ٽ� �Է¹��� �� �ִ� ó���� �����Ͽ� ���α׷��� ������ �� �ֵ��� �Ѵ�.

// ���� ��)
// ������ ���� �Է� (1~1000) : 1002
// ������ ���� �Է� (1~1000) : -20
// ������ ���� �Է� (1~1000) : 100
// >> 1~100������ �� : 5050
// ����Ϸ��� �ƹ� Ű��...

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Hap
{
	// ���� �� Ǯ��
	/*

	// �Է� �޴� ���� ����
	int n, i=0;
	int sum=0;

	// ���� �Է� �޴� �޼ҵ�
	void input()
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("������ ���� �Է� (1~1000) :");
		n = sc.nextInt();
	}

	// �ݺ��ϴ� �޼ҵ�
	void again()
	{
		Scanner sc = new Scanner(System.in);

		while (true)
		{
			if (n<0 || n>1000)
			{
			System.out.print("������ ���� �Է� (1~1000) :");
			n = sc.nextInt();
			}
			else
				return;		//-- �޼ҵ� ����
		}
	}
	
	

	// ������ ���� �޼ҵ�
	void add()
	{
		while (i<=n)
		{
			sum += i;
			i++;
		}
	}


	// ��� �޼ҵ�
	void print()
	{
		System.out.printf("<< 1 ~ %d ������ �� : %d\n",n,sum);
	}
	*/


	// �Բ� �� Ǯ��
	
	// �� �ֿ� ���� ���� (������� �Է°��� ��Ƶ� ����)
	int su;

	// �� �Է� �޼ҵ� ����
	void input() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do
		{
			System.out.print("������ ���� �Է�(1~1000):");
			su = Integer.parseInt(br.readLine());
		}
		while (su<1||su>1000);
	}

	// �� ���� �޼ҵ� ����
	int calculate()
	{
		int result =0;
		
		for (int i=1;i<=su;i++ )
			result += i;

		return result;
	}

	// �� ��� ��� �޼ҵ� ����
	// >> 1 ~ 100 ������ �� : 5050
	void print(int sum)
	{
		System.out.printf(">> 1 ~ %d ������ �� : %d\n", su, sum);
	}

}


public class Test072
{
	public static void main(String[] args) throws IOException
	{
		// ���� �� Ǯ��
		/*

		Hap ob = new Hap();
		int a;

		ob.input();		//-- �� ó���� ������ �Է¹ް�
		ob.again();		//-- ������ �����ȿ� ������ ������ �������� �Է¹ޱ� , 
						//	 ���� �ȿ� ������ �޼ҵ� ����
		ob.add();		//-- ���� �ȿ� ���� �� ������ ����
		ob.print();		//-- ������ ���
		*/


		// �Բ� �� Ǯ��

		// Hap Ŭ���� �ν��Ͻ� ����
		Hap ob = new Hap();
		
		// ������ �ν��Ͻ��� ���� �Է� �޼ҵ� ȣ��! �� throws IOException ó��
		ob.input();
		
		// ������ �ν��Ͻ��� ���� ���� �޼ҵ� ȣ��! �� int�� ����� ��ȯ �� �޾Ƴ� �� �ִ� ó�� !
		int s = ob.calculate();
		
		// ������ �ν��Ͻ��� ���� ��� �޼ҵ� ȣ��! �� �Ű����� ���� (=������)
		ob.print(s);
		


	}
}