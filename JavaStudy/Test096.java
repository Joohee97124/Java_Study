/* ===============================================
���� �޼ҵ� �ߺ�����(Method Oberloading) ����
- �޼ҵ� �����ε��� ������ ���¿� �Ұ����� ����
================================================*/


public class Test096
{
	public static void main(String[] args)
	{
		print();
		print(10);

		double result = print(10.1);
		print(10.1);
	}

	public static void print(){}
	public static void print(int i){}
	// public static void print(int j){}					 //-- (X)
	public static void print(char c){}						 //-- �� �ڵ� �� ��ȯ ��Ģ check~!!!
	public static void print(int i, int j){}
	public static void print(int i, double d){}				 //-- �� �ڵ� �� ��ȯ ��Ģ check~!!!
	public static void print(double d, int k){}				 //-- �� �ڵ� �� ��ȯ ��Ģ check~!!!
	public static double print(double d){return 3.14}	
	public static void print(double d){}					//-- (X)
	// 25,26 �� �ڹٴ� ����/���� ����,, �Ӻθ����� �� ���� ����
	// �������� ������ �ʾ� �ڹٴ� �� print�޼ҵ� ȣ�� �� �� �ڹٴ� 
	// ������ �׸� ���µ� ������ ���� �Ȱ���,,? �ڹٴ� ��ã��,,								

	public static String print(double d){}

}