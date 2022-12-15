/*=================================
���� �ڹ��� �⺻ �����(I/O) ����
==================================*/

// Reader Writer �ǽ�

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.Reader;
import java.io.OutputStreamWriter;
import java.io.Writer;


public class Test170
{
	public void process(InputStream is)
	{
		int data;

		System.out.println("���ڿ� �Է�(����:Ctrl+z)");

		try
		{
			// �Ű����� is ��� ����Ʈ ����� �Է� ��Ʈ�� ��ü(InputStream)��
			// ���� ��Ʈ������ ��ȯ�Ͽ� Reader Ÿ���� rd ���� ������ �� �ֵ��� ó��
			Reader rd = new InputStreamReader(is);
			
			// ����Ʈ ��� ��Ʈ���� �ڹ� �⺻ ��� ��Ʈ�� ��ü (OutputStream - System.out)��
			// ���� ��Ʈ������ ��ȯ�Ͽ� Writer Ÿ���� wt ���� ������ �� �ֵ��� ó��
			Writer wt = new OutputStreamWriter(System.out);

			while ((data = rd.read()) != -1)	// ���ڽ�Ʈ������ �о���� ����
			{
				wt.write(data);	// ���ڱ�� ��Ʈ������ write() ��
								//-- ��Ʈ�� ���ٱ⿡ ��� (�Ѷ� �Ѷ�...)
				wt.flush();		//-- ����� ��Ʈ���� �о�� ������ (�ֻ�� �ǽ���)
			}
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}
	}

	public static void main(String[] args)
	{
		Test170 ob = new Test170();
		ob.process(System.in);
	}
}
/*
[���� ���]
���ڿ� �Է�(����:Ctrl+z)
abcd
abcd
1234
1234
ABCD
ABCD
�����ٶ�
�����ٶ�
^Z
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/