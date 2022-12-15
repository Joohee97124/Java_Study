/*=========================================
���� Ŭ���� ��ޡ���
- ��� (Inheritance)
==========================================*/

// �� �ǽ� ����
//	  ������ ���� ���α׷��� �����Ѵ�.
//	  ��, ����� ������ �����Ͽ� �ۼ��� �� �ֵ��� �Ѵ�.

// ���� ��)
// ������ �� ���� �Է�(���� ����) : 20 15
// ������ �Է� ( + - * / ) : -
// >> 20 - 15 = 5
// ����Ϸ��� �ƹ� Ű��...

import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


// super class
class AClass
{
	/*
	protected int x,y;
	protected char op;

	AClass()
	{

	}

	void write(double result)
	{
		System.out.printf(">> %d %c %d = %.2f\n",x, op, y, result);
	}


	public void input() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("������ �� ���� �Է�(���� ����) : ");
		x = sc.nextInt();
		y = sc.nextInt();

		System.out.print("������ �Է� ( + - * / ) : ");
		op = (char)System.in.read();
	}
	*/

	protected int x,y;
	protected char op;

	AClass()
	{
	}

	void write(double result)
	{
		System.out.printf(">> %d %c %d = %.2f\n",x, op, y, result);
	}

}



// sub class
class BClass extends AClass 
{
	/*
	double result;

	public void calc() throws IOException
	{
		super.input();	// �θ�Ŭ�������� �Է� �޼ҵ� ��������

		// �����ϱ�
		switch (op)
		{
		case '+' : result = x+y; break;
		case '-' : result = x-y; break;
		case '*' : result = x*y; break;
		case '/' : result = (double) x/y; 
		}

		 super.write(result);
	}
	*/

	BClass()
	{
	}
	
	boolean input() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("������ �� ���� �Է� (���� ����):");		// 20 15
		String temp = br.readLine();								// "20 15"

		String[] str = temp.split("\\s");	// ������ �� ����

		// �� ���ڿ�.split("������");
		//	  ex) "��� ���� �ٳ��� ���� ����".split(����);
		//		  ��ȯ �� �迭 �� {"���", "����", "�ٳ���", "����", "����"}
		//	  ex) "1 23 456 7".split(����);
		//	      ��ȯ �� �迭 �� {"1, "23", "456", "7"}

		//==>> String[] str = {"20", "15"};
	
		if (str.length != 2)	// �Է°� ������ 2���� �ƴ϶��~
			return false;		// input()�ޤǵ��� �ڸ��� ���� ��ȯ �� false �׸���.. �޼ҵ� ����~!!
								// false (����)�� ��ȯ�ϸ� input() �޼ҵ� ���� (main�޼ҵ� ���� X)
		
		// �� �� ���ǹ��� ������ ��� �Ʒ��� �ڵ尡 �����ִ� ��Ȳ�̴���
		//	  �� �̻� �������� �ʰ� ������� ��ȯ�ϸ� �޼ҵ�� ����ȴ�.

		x = Integer.parseInt(str[0]);
		y = Integer.parseInt(str[1]);


		System.out.print("������ �Է� ( + - */ ) : ");
		op = (char)System.in.read();
		
		/*
		if (op!='+' && op!='-' && op!='*' && op!='/')
			return false;

		return true;
		*/

		if (op=='+' || op=='-' || op=='*' || op=='/')
			return true;

		return false;

	}//end input()

	
	double calc()
	{
		double result = 0;
		
		switch (op)
		{
		case '+': result = x+y; break;
		case '-': result = x-y; break;
		case '*': result = x*y; break;
		case '/': result = (double)x/y; break;
		}


		return result;
	}

}


// main() �޼ҵ带 �����ϰ� �ִ� �ܺ��� �ٸ� class
public class Test108
{
	public static void main(String[] args) throws IOException
	{
		/*
		BClass ob = new BClass();

		ob.calc();
		*/

		BClass ob = new BClass();

		if (!ob.input())
		{
			System.out.println("Error...");
			return;			// main() �޼ҵ� ����
		}

		double result = ob.calc();
		ob.write(result);
	}
}
/*
[���� ���]
������ �� ���� �Է� (���� ����):20 15
������ �Է� ( + - * / ) : -
>> 20 - 15 = 5.00
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/