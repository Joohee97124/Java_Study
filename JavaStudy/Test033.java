/*===============================
���� ���� �帧�� ��Ʈ��(���) ����
- if�� �ǽ�
===============================*/

// �� ����
// ����ڷκ��� ������ ������ �Է¹޾�
// �Է¹��� ������ ��������, ������� �Ǻ��Ͽ�
// ����� ����ϴ� ���α׷��� �����Ѵ�.
// ��, if ~ else ���ǹ��� Ȱ���� �� �ֵ��� �Ѵ�.

// ���� ��)
// ������ ���� �Է� : 2020
// >> 2020 �� ����
// ����Ϸ��� �ƹ� Ű��...

// ������ ���� �Է� : 2021
// >> 2021 �� ���
// ����Ϸ��� �ƹ� Ű��..

// �� ������ �Ǻ� ����
//    ������ 4�� ����̸鼭 100�� ����� �ƴϰų�
//	  �Ǵ� 400�� ����̸� ����~!
//	  �׷��� ������ ���~!

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test033
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int year;			//-- �Է� �޴� ����
		String result;		//-- "���", "����" ��
		result = "���";	//-- �ʱ�ȭ ����� ������ �ȳ�

		System.out.print("������ ���� �Է� : ");
		year = Integer.parseInt(br.readLine());

		if (year%400 == 0)		
		{
			result = "����";
		}
		else if (year%4 == 0)
		{
			if (year%100 != 0 )
			{
				result = "����";
			}
		}
		else
		{
			result = "���";
		}

		System.out.printf(">> %d �� %s\n", year, result);
	}
}

/* 
[���� ���]
������ ���� �Է� : 2020
>> 2020 �� ����
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ ���� �Է� : 2021
>> 2021 �� ���
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ ���� �Է� : 4000
>> 4000 �� ����
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/