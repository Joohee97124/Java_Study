/*===============================
���� ���� �帧�� ��Ʈ��(���) ����
- if�� �ǽ�
===============================*/

// �� ����
//    ����ڷκ��� ������ ���ĺ� �� ���ڸ� �Է¹޾Ƽ� �̸� �Ǻ��Ͽ�
//	  �ҹ��ڸ� �Է¹޾��� ���.... �빮�ڷ� ��ȯ�ϰ�
//    �빮�ڸ� �Է¹޾��� ���.... �ҹ��ڷ� ��ȯ�ϴ�
//    ���α׷��� �����Ѵ�.

// ���� ��)
// ���ĺ� �� ���� �Է� : T
// >> t
// ����Ϸ��� �ƹ� Ű��...

// ���ĺ� �� ���� �Է� : c
// >> C
// ����Ϸ��� �ƹ� Ű��...

// ���ĺ� �� ���� �Է� : 6
// >> �Է� ����~!!!
// ����Ϸ��� �ƹ� Ű��...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test039
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

		char ap1 , ap2;
		ap2 = 'a';

		System.out.print("���ĺ� �� ���� �Է� : ");
		ap1 = (char)System.in.read();

		if (ap1>=65 && ap1<=90)						//-- �빮���� ���
		{
			ap2 = (char)( ap1+32) ;					//-- �빮���� �ƽ�Ű�ڵ� +32 = �ҹ����� �ƽ�Ű�ڵ�
			System.out.printf(">> %c\n",ap2);
			
		}
		else if (ap1>=97 && ap1<=122)				//-- �ҹ���
		{
			ap2 = (char)( ap1-32 );					//-- �ҹ����� �ƽ�Ű�ڵ� -32 = �빮���� �ƽ�Ű�ڵ�
			System.out.printf(">> %c\n",ap2);
		}
		else 
		{
			System.out.println("�Է� ����~!!!");	//-- ���ĺ��� �ƴ� ���
		}

	}
}

/*
[���� ���]
���ĺ� �� ���� �Է� : A
>> a
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/