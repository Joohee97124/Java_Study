/*===============================
���� ���� �帧�� ��Ʈ��(���) ����
- if�� �ǽ�
===============================*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test032
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n;

		System.out.print("������ ���� �Է� : ");
		n = Integer.parseInt(br.readLine());
		
		// (X) 0������2 �� �������� 0,,
		/*
		if (n%2==0)
		{
			System.out.println(n + " �� ¦��");
		}
		else if (n==0)
		{
			System.out.println(n + " �� ��");
		}
		else
		{
			System.out.println(n + " �� Ȧ��");
		}
		*/
		
		// (O) 
		/*
		if (n%2!=0)
		{
			System.out.println(n + " �� Ȧ��");
		}
		else if (n==0)
		{
			System.out.println(n + " �� ��");
		}
		else
		{
			System.out.println(n + " �� ¦��");
		}
		*/

		/*
		if (n==0)
		{
			System.out.println(n + " �� ��");
		}
		else if (n%2==0)
		{
			System.out.println(n + " �� ¦��");
		}
		else
		{
			System.out.println(n + " �� Ȧ��");
		}
		// ¦���� ���Ǻ��� ���� ������ ���� �;��Ѵ�.
		// else Ȧ�� �κ��� ������ ���������δ� ������ ���� (Ȧ���� ���� ��)
		*/
		
		/* (O) 
		if (n==0)
		{
			System.out.println(n + " �� ��");
		}
		else if (n%2==0)
		{
			System.out.println(n + " �� ¦��");
		}
		else if (n%2 != 0 )
		{
			System.out.println(n + " �� Ȧ��");
		}
		{
			System.out.println("������ �Ұ����� ��Ȳ�Դϴ�");
		}
		*/


		System.out.print("���̽�ũ�� ���� ���� (1.����, 2.����) : ");
		n = Integer.parseInt(br.readLine());
		
		/* (O) ������ ...
		if (n==1)
		{
			System.out.println("���� ���̽�ũ���� �����ϼ̽��ϴ�~");
		}
		else
		{
			System.out.println("���� ���̽�ũ���� �����ϼ̽��ϴ�~");
		}
		*/

		if (n==1)
		{
			System.out.println("���� ���̽�ũ���� �����ϼ̽��ϴ�~");
		}
		else if(n==2)
		{
			System.out.println("���� ���̽�ũ���� �����ϼ̽��ϴ�~");
		}
		else
		{
			System.out.println("���� ���� �̿��� ���̽�ũ�� ���� �Ұ�~");
		}


	}
}
