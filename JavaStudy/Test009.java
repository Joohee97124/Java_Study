/*==================================================
���� ������ �ڷ��� ����
- ������ �ڷ��� �ǽ� �� �׽�Ʈ : double
===================================================*/

public class Test009
{
	public static void main(String[] args)
	{
		// ������ ������ ������
		double a = 1/2;				//  ������ ������ ������ �� �� ���´�! 
		// double a = 0;
		// �� ���� 0�� int �� double �� �ڵ� ����ȯ �Ǿ� double a = 0.0�� �ȴ� 
		System.out.println("double a : " + a);
		//--==>> double a : 0.0

		double b = 1/2 + 1/2;
		// double b = 0 + 1/2;
		// double b = 0 + 0;
		// double b = 0;
		System.out.println("double b : " + b);
		//--=>> double b : 0.0

		// ������ �Ǽ��� ������ �� �Ǽ� ������� �������� ����ȴ�
		double c = 1/2.0;
		System.out.println("double c : " + c);
		// --==>> double c : 0.5
		// -- ������ ����� �����Ͽ� �ǿ����� �� �Ǽ��� ���ԵǾ� �ִٸ�
		//    �Ǽ� ����� ������ �̷������ ��� ���� �Ǽ� ���·�
		//    ����Ǿ� ��ȯ�ȴ�.
		// (int 1�� double 1.0 ���� �ڵ�����ȯ�Ǿ� ����Ǵ°�!)


		double d = 3/2 + 1/2;
		// double d = 1 + 1/2;
		// double d = 1 + 0;
		// double d = 1;
		System.out.println("double d : " + d);
		// --==>> double d : 1.0

		double e = 3/2 + 1/2.0;
		// double e = 1 + 1/2.0;
		// double e = 1 + 0.5;			
		// double e = 1.5;
		System.out.println("double e : " + e);
		// --==>> double e : 1.5
		// (int 1�� double 1.0 ���� �ڵ�����ȯ�Ǿ� ����Ǵ°�!)

		// �����Ϸ��� �ǿ����� �� ���� ������ ������ ���ƾ� �Ѵ�!

	}
}

/*
[���� ���]
double a : 0.0
double b : 0.0
double c : 0.5
double d : 1.0
double e : 1.5
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/