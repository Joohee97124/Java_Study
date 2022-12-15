/*==================================
���� ����(Sort) �˰������
- ���� ����(Selection Sort)
==================================*/
/*
�� ����
	: �����͸� Ư���� ��Ģ(����)�� �°� ������� ����(��������, ��������)

�� ������ ����
	: ������ ó�� ������ ���Ǽ��̳� �������� ���̱� ����
	�� ���� ����... �˻��ϱ� ����

�� ������.. ���ҽ� �Ҹ� ���ϴ�

�� ������ ����
	: ���� ����, ���� ����, ���� ����, �� ����, �� ����, �� ����, ...
*/

// ���� �� )
// Source Data : 52, 42, 12, 62, 60
// Sorted Data : 12, 42, 52, 60, 62
// ����Ϸ��� �ƹ� Ű��...

public class Test102
{
	public static void main(String[] args)
	{
		int [] a = {52, 42, 12, 62, 60};

		/*
		52, 42, 12, 62, 60		�� 0 1
		======
		
		42, 52, 12, 62, 60		�� 0 2
		==      ==		

		12, 52, 42, 62, 60		�� 0 3
		==          == 

		12, 52, 42, 62, 60		�� 0 4
		==              == 

		------------------------------- 1ȸ��

		12, 52, 42, 62, 60		�� 1 2
		    =======
		12, 42, 52, 62, 60		�� 1 3
			==      ==
		12, 42, 52, 62, 60		�� 1 4
			==          ==
		------------------------------- 2ȸ��

		12, 42, 52, 62, 60		�� 2 3
				======
		12, 42, 52, 62, 60		�� 2 4
				==      ==
		------------------------------- 3ȸ��
		
		12, 42, 52, 60, 62		�� 3 4
					======
		------------------------------- 4ȸ��

		*/
		
		// ���� �� Ǯ��
		/*
		System.out.print("Source Data : ");
		for (int i=0; i<a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
		
		int n=1;	// j�� 1~4 / 2~4 / 3~4�� ���ƾ��ϴϱ� �����ϴ� ���ڸ� n���� �ΰ�
					// n++����~~~

		for (int i=0; i<a.length; i++)
		{
			
			for (int j=n; j<5 ; j++)
			{
				
				if (a[i]>a[j])
				{
					a[i] = a[i]^a[j];
					a[j] = a[j]^a[i];
					a[i] = a[i]^a[j];
				}
			}
			n++;
		}

		System.out.print("Sorted Ddata : ");
		for (int k=0; k<a.length ;k++ )
			System.out.print(a[k]+" ");
		System.out.println();
		*/

		int i, j;
		
		System.out.print("Source Data : ");

		/*
		for (int i=0; i<a.length ;i++ )
			System.out.print(a[i]+ " ");
		System.out.println();
		*/

		// ���� for�� ��forEach ����
		for (int n : a )
			System.out.print(n + " ");
		System.out.println();
		//==>> Source Data : 52 42 12 62 60
		
		// Selection Sort ����
		for (i=0; i<a.length-1; i++ )		// i �� 0 1 2 3 �� �� ���� ������ �ε���
		{	
			// System.out.println("��"); �� 4ȸ��

			for (j=i+1; j<a.length; j++ )	// j �� 0 �� 1 2 3 4 
											//	    1 �� 2 3 4
											//	    2 �� 3 4
											//		3 �� 4
			{
				// System.out.println("��"); 
				
				if (a[i] > a[j])			// �� �������� ���� ����
				{
					// �ڸ� �ٲٱ�
					a[i] = a[i]^a[j];
					a[j] = a[j]^a[i];
					a[i] = a[i]^a[j];
				}
			}
		}


		// ����� ���
		System.out.print("Sorted Data : ");

		for (int n: a )
			System.out.print(n + " ");
		System.out.println();
	}
}
/*
[���� ���]
Source Data : 52 42 12 62 60
Sorted Data : 12 42 52 60 62
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/