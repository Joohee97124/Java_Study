/*======================================
���� Ŭ������ �ν��Ͻ� ����
=======================================*/

// �� �ǽ� ����
// ���� ���̿� �ѷ� ���ϱ�

// ���� ���̿� �ѷ��� ���� �� �ִ� Ŭ������ ����������(������) �����Ѵ�.
// (Ŭ���� �� : CircleTest) �� CircleTest.java

// ���� ���� = ������ * ������ * 3.141592
// ���� �ѷ� = ������ * 2 * 3.141592

// ���� ��)
// ������ �Է� : xx

// >> �������� xx�� ����
// >> ���� : xxx.xx
// >> �ѷ� : xxx.xx
// ����Ϸ��� �ƹ� Ű��...

import java.io.IOException;

public class Test071
{
	public static void main(String[] args) throws IOException
	{

		// ���� �� Ǯ��
		/*
		CircleTest ob = new CircleTest();
		double a,b;

		ob.input();
		a = ob.calArea();
		b = ob.calLen();
		ob.print(a,b);
		*/

		// �Բ� �� Ǯ��
		
		CircleTest ob = new CircleTest();

		ob.input();	
		double area = ob.calArea();
		double length = ob.calLength();

		// System.out.println("area : " +area);
		// System.out.println("length : " + length);

		ob.print(area,length);

	}
}
/*
[���� ���]
������ �Է� : 5

>> �������� 5�� ����
>> ���� : 78.54
>> �ѷ� : 31.42
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/
