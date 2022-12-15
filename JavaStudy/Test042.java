/*===============================
���� ���� �帧�� ��Ʈ��(���) ����
- switch�� �ǽ�
===============================*/

// ����ڷκ��� ������ �� ������ �����ڸ� �Է¹޾�
// �ش� ������ ó�� ����� ����ϴ� ���α׷��� �����Ѵ�.
// ��, switch ���� Ȱ���Ͽ� ó���� �� �ֵ��� �ϸ�,
// ���� ����� ���ǻ� ���� ���·� ó���Ѵ�.

// ���� ��)
// ù ��° ���� �Է� : 10
// �� ��° ���� �Է� : 31
// ������ �Է� (+ - * /) : +

// >> 10 + 31 = 41
// ����Ϸ��� �ƹ� Ű�� ��������...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test042
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���� �� Ǯ��
		/*
		int n1, n2, result;
		result = 0;
		char op;

		System.out.print("ù ��° ���� �Է� : ");
		n1 = Integer.parseInt(br.readLine());

		System.out.print("�� ��° ���� �Է� : ");
		n2 = Integer.parseInt(br.readLine());

		System.out.print("������ �Է� (+ - * /) : ");
		op = (char)System.in.read();

		switch (op)
		{
			case '+' : op = '+';
					   result = n1 + n2; break;
			case '-' : op = '-';
				       result = n1 - n2; break;
			case '*' : op = '*';
					   result = n1 * n2; break;
			case '/' : op = '/'; 
					   result = n1 / n2; break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}

		System.out.printf(">> %d %c %d = %d\n",n1,op,n2,result);
		*/


		// �Բ� �� Ǯ��
		
		int a, b, result;
		char op;

		System.out.print("ù ��° ���� �Է� : ");
		a = Integer.parseInt(br.readLine());

		System.out.print("�� ��° ���� �Է� : ");
		b = Integer.parseInt(br.readLine());

		System.out.print("������ �Է� (+ - * /) : ");
		op = (char)System.in.read();
		

		/*
		if (op == '+')
		{...
		}
		*/

	
		// jdk 1.5 ���� ���ǿ� ����Ÿ�� (char) �� �� �� �ֵ��� �����ȴ�.
		// jdk 1.7 ���ʹ� ���ڿ� (String) ���� �� �� ����
		switch (op)
		{
			case '+' : result = a+b; break;
			case '-' : result = a-b; break;
			case '*' : result = a*b; break;
			case '/' : result = a/b; break;
			
			default : return;	//-- �޼ҵ� ���� �� main()�޼ҵ� ���� �ǹ� �� ���α׷� ���� 
		}


		// �� ��return�� : 1. ���� ��ȯ ex) return 10; 
		//				   2. �޼ҵ��� ����
		

		System.out.println();
		System.out.printf(">> %d %c %d = %d\n",a,op,b,result);

	}
}
/*
[���� ���]
ù ��° ���� �Է� : 5
�� ��° ���� �Է� : 3
������ �Է� (+ - * /) : +

>> 5 + 3 = 8
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

ù ��° ���� �Է� : 5
�� ��° ���� �Է� : 3
������ �Է� (+ - * /) : ;
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/