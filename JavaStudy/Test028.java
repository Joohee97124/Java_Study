/*===============================
���� ������ (Operator) ����
- ���� ������ == ���� ������
===============================*/

// ����ڷκ��� ������ ������ �Է¹޾�
// �Է¹��� ������ �������, ��������, 0���� �����Ͽ�
// ����� ����ϴ� ���α׷��� �����Ѵ�.
// ��, �Է� �����ʹ� BufferedReader�� readLine()�� ���� �Ѱܹ��� �� �ֵ��� �Ѵ�.
// ����, ���� ������ (���� ������)�� Ȱ���Ͽ� ����� ������ �� �ֵ��� �Ѵ�.

// ���� ��)
// ������ ���� �Է� : -12
// -12 �� ����
// ����Ϸ��� �ƹ� Ű��...

// ������ ���� �Է� : 257
// 257 �� ���
// ����Ϸ��� �ƹ� Ű��...

// ������ ���� �Է� : 0
// 0 �� ��
// ����Ϸ��� �ƹ� Ű��...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test028
{
	public static void main(String[] args) throws IOException
	{
		//���� �� Ǯ��
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n;
		String result;

		System.out.print("������ ���� �Է� : ");
		n = Integer.parseInt(br.readLine());
		
		result = n==0 ? "��" : (n>0 ? "���" : "����") ;
		// result = n==0 ? "��" : n>0 ? "���" : n<0 ? "����" : "��¼��" ;	-- ��� �̾ �� �ִ�.

		
		System.out.printf("%d �� %s\n",n,result);
		*/



		// �Բ� �� Ǯ��

		// �� �ֿ� ���� ����
		// ��BufferedReader �ν��Ͻ� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// ������� �Է� ���� ���� ����
		int n;
		// ���������� ������� ������ �� �� ����� ���� ����
		String strResult;


		// �� ���� �� ó��
		// �� ����ڿ��� �ȳ� �޼��� ���
		System.out.print("������ ���� �Է� : ");
		// �� ����� �Է� �����͸� ���� n�� ��Ƴ���
		n = Integer.parseInt(br.readLine());

		/*
		n�� 0���� ũ�� �� true   �� ���
						  false  �� n�� 0���� �۴� �� true  �� ����
						  							  false �� 0
		*/
		
		// �� �Է°��� ���� �Ǻ� ����
		strResult = n>0 ? "���" : (n<0 ? "����" : "��");


		// �� ��� ���
		System.out.println(n + "��" + strResult);


	}
}

/* 
[���� ���]
������ ���� �Է� : 0
0�濵
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ ���� �Է� : 5
5����
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ ���� �Է� : -3
-3������
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/