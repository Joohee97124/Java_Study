/*=======================================================
���� �޼ҵ� ���ȣ��(��� �޼ҵ�) ����
========================================================*/


public class Test067
{
	public static void main(String[] args)
	{	
		showHi(5);
	}
	
	/*
	public static void showHi(int cnt)	// 5 
	{
				// �ƹ��͵� �ΰ���� X
		
		System.out.println("Hi~~~");
		
		showHi(cnt--);					// showHi(5);

		if (cnt==1)
			return;
	*/

	//��

	public static void showHi(int cnt)	// 5			4
	{
				// �ƹ��͵� �ΰ���� X
		
		System.out.println("Hi~~~");
		
		if (cnt==1)						// if�� (1����) �� Ȯ���ϱ� ����
			return;

		showHi(--cnt);					// showHi(4);	3







		


	}

}