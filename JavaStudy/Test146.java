/*======================================
���� ����(Exception) ó�� ����
======================================*/

// Test145.java ���ϰ� ��~!!!


class Demo2
{
	// �ֿ� �Ӽ� ����
	private int value;

	
	// setter
	public void setValue(int value) throws Exception // �߻��� ���ܸ� ó���������
	{
		if (value<=0)
			throw new Exception("value�� 0���� �۰ų� ���� �� �����ϴ�.");
			//-- ���ο� ���� �߻�~!!!
			
		this.value = value;
	}

	// getter
	public int getValue()
	{
		return value;
	}
}


public class Test146
{
	public static void main(String[] args) // �� throws Exception // ���⼭�� ������~!
	{
		/*
		��
		Demo2 ob = new Demo2();
		ob.setValue(-10);	// Exception ����� ������
		int result = ob.getValue();
		System.out.println(result);
		

		Exception in thread "main" java.lang.Exception: value�� 0���� �۰ų� ���� �� �����ϴ�.
        at Demo2.setValue(Test146.java:18)
        at Test146.main(Test146.java:37)
		����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
		*/

		
		// ��
		try
		{
			Demo2 ob = new Demo2();
			ob.setValue(-10);	// Exception ����� ������
			int result = ob.getValue();
			System.out.println(result);
		}
		catch (Exception e)
		{
			System.out.println("����ó���ϱ�~!!");
			System.out.println(e.toString());
		}
		/*
		����ó���ϱ�~!!
		java.lang.Exception: value�� 0���� �۰ų� ���� �� �����ϴ�.
		����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
		*/
	}
}