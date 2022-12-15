/*===============================
���� ������ (Operator) ����
- ���� ������ == ���� ������
===============================*/

// ����ڷκ��� ������ ������ �Է¹޾�
// �Է¹��� ������ ... �������� ������� �Ǻ��Ͽ�
// ����� ����ϴ� ���α׷��� �����Ѵ�.
// ��, �Է��� BufferedReader �� readLine() �� Ȱ���ϰ�
// ������ ���� �����ڸ� Ȱ���� �� �ֵ��� �Ѵ�.

// ���� ��)
// ������ ���� �Է� : 2000
// 2000�� �� ����
// ����Ϸ��� �ƹ� Ű��...

// ������ ���� �Է� : 2011
// 2011�� �� ���
// ����Ϸ��� �ƹ� Ű��...

// �� ������ �Ǻ� ����
//	  ������ 4�� ����̸鼭 100�� ����� �ƴϰų�
//	  �Ǵ�, 400�� ����̸� ����~!!!
//	  �׷��� ������.. ���~!!!

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test029
{
	public static void main(String[] args) throws IOException
	{

		// ���� �� Ǯ��
		/*
		// �� BufferedReader �ν��Ͻ� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// �� �ֿ� ���� ����
		int year;			//-- ����
		String result;		//-- ��� (����, ���)

		// �� ���� �� ó��
		System.out.print("������ ���� �Է� : ");
		year = Integer.parseInt(br.readLine());
		
		result = year%4 == 0 ? (year%100 == 0 ? (year%400 == 0 ? "����" : "���") : " ����") : "���"  ;

		
		// �� ��� ���
		System.out.printf("%d �� %s\n", year, result);
		*/

		

		// �Բ� �� Ǯ��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int year;
		String strResult;

		System.out.print("������ ���� �Է� : ");
		year = Integer.parseInt(br.readLine());
		
		// �� ������ Ȱ��! (������ 2�� �̻��� ��)
		strResult = (year%4==0 && year%100!=0 || year%400==0) ? "����" : "���";
		
		System.out.printf("%d�� �� %s\n", year, strResult);


	}
}

/*
4�� ��� -> true -> 100�� ��� ->true -> 400�� ���? -> true   -> ����
													 ->	false  -> ���

							   ->false -> ����
			false -> ���
*/


/* 
[���� ���]
������ ���� �Է� : 2020
2020�� �� ����
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ ���� �Է� : 2021
2021�� �� ���
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/