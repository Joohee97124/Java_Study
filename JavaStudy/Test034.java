/*===============================
���� ���� �帧�� ��Ʈ��(���) ����
- if ~ else�� �ǽ�
===============================*/

// ����ڷκ��� ������ �� ������ �����ڸ� �Է¹޾�
// �ش� �����ڿ� �ش��ϴ� ������ ó�� ����� ����ϴ� ���α׷��� �����Ѵ�.
// ��, ���ǹ��� Ȱ���Ͽ� ó���� �� �ֵ��� �ϸ�,
// ������ ����� ���ǻ� ���� ���·� ó���� �� �ֵ��� �Ѵ�.

// ���� ��)
// ù ��° ���� �Է� : 10
// �� ��° ���� �Է� : 24
// ������ �Է� (+ - * /) : +

// >> 10 + 24 = 34
// ����Ͻ÷��� �ƹ� Ű�� ...

//--------------------------------

// ù ��° ���� �Է� : 5
// �� ��° ���� �Է� : 3
// ������ �Է� (+ - * /) : /

// >> 5 / 3 = 1
// ����Ͻ÷��� �ƹ� Ű�� ...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test034
{
	public static void main(String[] args) throws IOException
	{
		// ���� § �ڵ�
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num1, num2;
		char num3;
		int result;
		result =0;

		System.out.print("ù ��° ���� �Է� :");
		num1 = Integer.parseInt(br.readLine());

		System.out.print("�� ��° ���� �Է� :");
		num2 = Integer.parseInt(br.readLine());

		System.out.print("������ �Է� (+ - * /) : ");
		num3 = (char)System.in.read();
		

		if (num3 == '+')
		{
			result = num1 + num2;
		}
		
		else if (num3 == '-')
		{
			result = num1 - num2;
		}
		else if (num3 == '*')
		{
			result = num1 * num2;
		}
		else if (num3 == '/')
		{
			result = num1 / num2;
		}
		else 
		{ 
			System.out.printf("�߸��� �������Դϴ�.");
		}

		System.out.printf("%d %c %d = %d\n",num1,num3,num2,result);
		}
	}
		*/


		// �Բ� § �ڵ�
		/*
		// ��� ��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a, b;
		char op;

		System.out.print("ù ��° ���� �Է� : ");
		a = Integer.parseInt(br.readLine());

		System.out.print("�� ��° ���� �Է� : ");
		b = Integer.parseInt(br.readLine());

		System.out.print("������ �Է� (+ - * /) : ");
		// op = br.readLine();
		// op = Integer.parseInt(br.readLine());
		op = (char)System.in.read();
		
		if (op == '+')
		{
			System.out.printf("\n >> %d + %d = %d\n", a, b, (a+b));
		}
		else if (op == '-')
		{
			System.out.printf("\n >> %d - %d = %d\n", a, b, (a-b));
		}
		else if (op == '*')
		{
			System.out.printf("\n >> %d * %d = %d\n", a, b, (a*b));
		}
		else if (op == '/')
		{
			System.out.printf("\n >> %d / %d = %d\n", a, b, (a/b));
		}
		else
		{
			System.out.println("�Է� ������ ������ �����մϴ�.");
		}
		*/


		/*
		// �����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a,b,op;

		System.out.print("ù ��° ���� �Է� : ");
		a = Integer.parseInt(br.readLine());

		System.out.print("�� ���� ���� �Է� : ");
		b = Integer.parseInt(br.readLine());

		System.out.print("������ �Է� (+ - * /) : ");
		// op = Integer.parseInt(br.readLine()); �� Integer.parseInt("+") �� (X)
		op = System.in.read();

		// "1234" �� Integer.parseInt("1234") �� 1234
		// "ABCD" �� Integer.paresInt("ABCD") �� (X)
		
		// �׽�Ʈ (Ȯ��)
		// System.out.println("op : " + op);
		//-- ��+�� �� 43
		//   ��-�� �� 45
		//   ��*�� �� 42
		//   ��/�� ��47

		if (op == 43)
		{
			System.out.printf("\n>> %d + %d = %d\n",a,b,(a+b));
		}
		else if (op==45)
		{
			System.out.printf("\n>> %d - %d = %d\n",a,b,(a-b));
		}
		else if (op==42)
		{
			System.out.printf("\n>> %d * %d = %d\n",a,b,(a*b));
		}
		else if (op==47)
		{
			System.out.printf("\n>> %d / %d = %d\n",a,b,(a/b));
		}
		*/


		// �����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a,b, result =0;
		char op;

		System.out.print("ù ��° ���� �Է� : ");
		a = Integer.parseInt(br.readLine());

		System.out.print("�� ��° ���� �Է� : ");
		b = Integer.parseInt(br.readLine());

		System.out.print("������ �Է� (+ - * /) : ");
		op = (char)System.in.read();

		if (op == '+')
			result = a+b;
		else if (op == '-')
			result = a - b;
		else if (op == '*')
			result = a * b;
		else if (op == '/')
			result = a / b;

		System.out.printf("\n>> %d %c %d = %d\n",a ,op, b, result);

		

	}
}
/*
[���� ���]
ù ��° ���� �Է� : 10
�� ��° ���� �Է� : 5
������ �Է� (+ - * /) : +

>> 10 + 5 = 15
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

*/