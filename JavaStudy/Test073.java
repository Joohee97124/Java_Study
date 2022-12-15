/*======================================
���� Ŭ������ �ν��Ͻ� ����
- Ŭ���� ���� ���� �� Ŭ���� ���� �ǽ�
=======================================*/

// ����ڷκ��� ������ �� ������ �����ڸ� �Է¹޾�
// ��Ģ ������ �����ϴ� ���α׷��� �����Ѵ�.
// ��, Ŭ������ �ν��Ͻ��� ������ �����Ͽ� �ۼ��� �� �ֵ��� �Ѵ�.
// ���ǻ� ���� ������� ó���Ѵ�.

// ���� ��)
// ������ �� ���� �Է� (���� ����) : 30 15
// ������ ������ �Է� (+ - * /) : +
// >> 30 + 15 = 45
// ����Ϸ��� �ƹ� Ű��....

import java.util.Scanner;
import java.io.IOException;

class Calculate
{
	// �� �ֿ� �Ӽ� ����
	int su1, su2;
	char op;

	// ���� Ǭ Ǯ��
	/*

	// �Է� �޼ҵ� (����2, ������)
	void input() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.printf("������ �� ���� �Է� (���� ����) : %d %d",su1,su2);
		su1 = Integer.parseInt(br.readLine());
		su2 = Integer.parseInt(br.readLine());

		System.out.printf("������ ������ �Է� (+ - * /) : %c",op);
		op = (char)System.in.read();

	}

	// ���� �޼ҵ�
	int cal()
	{
		int result;

		if (op == '+')
		{
			result = su1+su2;
		}
		else if (op == '-')
		{
			result = su1 -su2;
		}
		else if (op =='*)
		{
			result = su1*su2;
		}
		else
		{
			result = su1/su2;
		}

		return result;
	}
	
	// ��� �޼ҵ�
	void print(int result)
	{
		System.out.printf("%d %c %d = %d \n", su1,op,su2,result);

	}
	*/

	// �Բ� �� Ǯ��

	// �� �Է� �޼ҵ� ����
	void input () throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �� ���� �Է� (���� ����): ");
		su1 = sc.nextInt();
		su2 = sc.nextInt();

		System.out.print("������ ������ �Է� (+ - * /) : ");
		op = (char)System.in.read();
	}

	// �� ���� �޼ҵ� ����
	int cal()
	{
		int result = 0;

		switch (op)
		{
			case '+' : result = su1+su2; break;
			case '-' : result = su1-su2; break;
			case '*' : result = su1*su2; break;
			case '/' : result = su1/su2; break;
		}

		return result;
	}

	// �� ��� �޼ҵ� ����
	// >> 30 + 15 = 45
	void print(int r)
	{
		System.out.printf(">> %d %c %d = %d \n",su1, op, su2, r);

	}
}


// main() �޼ҵ带 �����ϰ� �ִ� �ܺ��� �ٸ� Ŭ���� 
public class Test073
{
	public static void main(String[] args) throws IOException
	{
		// Calculate Ŭ���� ����� �ν��Ͻ� ����
		Carculate ob = new Carculate();
		
		// ������ �ν��Ͻ��� ���� �Է� �޼ҵ� ȣ��
		ob.input();

		// ������ �ν��Ͻ��� ���� ���� �޼ҵ� ȣ��
		int result = ob.cal();

		// ������ �ν��Ͻ��� ���� ��� �޼ҵ� ȣ��
		ob.print(result);
	}
}