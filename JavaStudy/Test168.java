/*=================================
���� �ڹ��� �⺻ �����(I/O) ����
==================================*/

// Reader �ǽ�
// Test166.java �� ��~!!!

import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test168
{
	public static void main(String[] args) throws IOException
	{
		int data;
		char ch;

		// System.in		 : �ڹ��� ǥ�� �Է� ��Ʈ��(��ü) �� ����Ʈ ��� ��Ʈ�� 
		// InputStreamReader : ����Ʈ ��� ��Ʈ���� ���� ��� ��Ʈ������ ��ȯ
		//						(��ȯ��, ������ ���� ����)
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// Reader			 : ���� ��� ��Ʈ�� ��ü
		Reader rd = new InputStreamReader(System.in);
		// �Է� ��Ʈ���� ���ٱ⸦ ������.


		System.out.println("���ڿ� �Է�(����:Ctrl+z) " );
		
		while ((data = rd.read()) != -1)	// ���� ��� ��Ʈ���� �о�鿩�� (Reader rd)
		{
			ch = (char)data;
			System.out.print(ch);			//-- �ѱ� �ȱ���
			//--==>>
			/*
			[���� ���]
			���ڿ� �Է�(����:Ctrl+z)
			1234
			1234
			abcd
			abcd
			ABCD
			ABCD
			�����ٶ�
			�����ٶ�
			^Z
			*/
			
			// write() : OutputStream Ŭ������ ��ǥ�� �޼ҵ� (�� ����Ʈ ��Ʈ��)
			System.out.write(ch);			//-- �ѱ� ����
			//--==>>
			/*
			���ڿ� �Է�(����:Ctrl+z)
			1234
			1234
			abd
			abd
			ABCD
			ABCD
			�����ٶ�
			 ��|
			^Z
			*/
		}


	}
}
