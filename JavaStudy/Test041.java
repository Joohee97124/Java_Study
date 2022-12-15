/*===============================
���� ���� �帧�� ��Ʈ��(���) ����
- switch�� �ǽ�
===============================*/

// 1���� 3������ ���� �� �ϳ��� ����ڷκ��� �Է¹޾�
// �Է¹��� ������ŭ ������(��)�� ��µǴ� ���α׷��� �ۼ��Ѵ�.
// ��, �� ���� ������� ������ �� �ֵ��� �Ѵ�.

// �� switch���� �Ϲ� ���� Ȱ���Ѵ�
// �� switch���� �⺻ ���� Ȱ���ϵ�,
//	  ��break���� �� �� ���� ����� �� �ֵ��� �Ѵ�.

// ���� ��)
// ������ ���� �Է�(1~3) : 3
// �ڡڡ�
// ����Ϸ��� �ƹ� Ű��...

// ������ ���� �Է�(1~3) : 1
// ��
// ����Ϸ��� �ƹ� Ű��...

// ������ ���� �Է�(1~3) : 7
// �Է� ����~!!!
// ����Ϸ��� �ƹ� Ű��...


import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Test041
{
	public static void main(String[] args) throws IOException
	{

		// ���� �� Ǯ��
		/*

		Scanner sc = new Scanner(System.in);
		
		int n;
		String star = " ";

		System.out.print("������ ���� �Է� (1~3) : ");
		n = sc.nextInt();
		
		
		switch (n)
		{
			case 1 : System.out.println("��"); break;
			case 2 : System.out.println("�ڡ�"); break;
			case 3 : System.out.println("�ڡڡ�"); break;
			default :  System.out.println("�Է¿���~!!!"); 
		}
		

		// ���ͳ��� ������ ����,,
		switch (n)
		{
			case 3 : star += "��"; 
			case 2 : star += "��"; 
			case 1 : star += "��"; break;
			default : System.out.println("�Է� ����~!!!");
		
		}
		System.out.println(star);
		*/
			

		// �Բ� �� Ǯ��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n;

		System.out.print("������ ���� �Է�(1~3) :");
		n = Integer.parseInt(br.readLine());

		/*
		// ��
		switch (n)
		{
			case 1 : System.out.println("��"); break;
			case 2 : System.out.println("�ڡ�"); break;
			case 3 : System.out.println("�ڡڡ�"); break;
			default : System.out.println(" �Է� ����~!!");
		}
		*/

		// ��
		switch (n)
		{
			case 3 : System.out.print("��");
			case 2 : System.out.print("��");
			case 1 : System.out.print("��"); break;
			
			default : System.out.println("�Է� ����~!!!");
		}
		System.out.println();


	}
}
/* 
[���� ���]
������ ���� �Է�(1~3) :3
�ڡڡ�
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/