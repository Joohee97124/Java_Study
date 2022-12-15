/*======================================
���� �ڹ��� �ֿ�(�߿�) Ŭ���� ����
- Wrapper Ŭ����
======================================*/


public class Test129
{
	public static void main(String[] args)
	{
		byte b = 3;
		int i = 256;

		Byte b2 = new Byte(b);				//-- boxing
		Integer i2 = new Integer(i);		//-- boxing

		System.out.println(b2);				//-- 3
		System.out.println(i2);				//-- 256

		print(b2);
		print(i2);

	}
	
	/*
	// �����ε�
	static void print(Byte b)
	{
		//...
	}

	static void print(Integer i)
	{
		//...
	}
	*/
	

	// Object : �ᵵ ���� �Ѱܹ��� n�� ��ü�����̸� �� ��~~
	// � ��ü�� �Ѱ��ִ��� �������� => �������� �������� Ȯ�� X
	// �ƹ��ų� ����ִ� �� = �Ӱ� ������� Ȯ���ϱ� �������� ���ǻ��׵� �� ���� ����,,

	// Number : 

	// �� java.lang.Number Ŭ����(�߻�Ŭ����) ��
	//	  ��� Wrapper Ŭ������ �θ� Ŭ���� (����Ŭ����, ����Ŭ����)�̴�.
	//	  b2, i2 �ڷ����� Number n�� �Ѿ���鼭
	//	  �� ĳ������ �ڵ������� �Ͼ�� �ȴ�. (Auto-Boxing ����)

	// static void print(������Ÿ�� �����̸�)
	static void print(Number n)
	{
		System.out.println(n);
	}

}