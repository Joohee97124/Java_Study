/*=====================================
     ���� �迭 (array) ����
	 - �迭�� �迭 (2���� �迭)
=====================================*/

// �迭�� �迭(������ �迭)�� Ȱ���Ͽ�
// ������ ���� �����͸� ��ҷ� ���ϴ� �迭(5x5)�� �����ϰ�
// �� ����� ����ϴ� ���α׷��� �����Ѵ�.

// ���� ��)
/* 
 1  2  3  4  5		�� i=0
 2  3  4  5  6		�� i=1
 3  4  5  6  7		�� i=2
 4  5  6  7  8		�� i=3
 5  6  7  8  9		�� i=4
����Ϸ��� �ƹ� Ű�� ��
*/

public class Test088
{ 
	public static void main(String[] args)
	{
		/* [���� �� Ǯ��]
	
		int n=5;								// ���� ����

		int [][] arr1 = new int [5][5];			// 2���� �迭 ���� 

		// �迭�ʱ�ȭ
			
		for (int i=0;i<arr1.length ;i++ )
		{
			n = n-4;

			for (int j=0;j<arr1.length ; j++)
			{
				arr1[i][j] = n;
				n++;
			}
		}

		// ��±���

		for (int i=0;i<arr1.length; i++)
		{
			for (int j=0;j<arr1.length ; j++ )
			{
				System.out.printf("%s", arr1[i][j]);
			}
			System.out.println();
		}
		*/

		// [���� Ǯ��]
		// �迭�� �迭 ���� �� �޸� �Ҵ�
		int [][] arr = new int[5][5];

		int n;
		
		// �� ����
		for (int i=0; i<arr.length; i++ )		 // i �� 0 1 2 3 4
		{	
			n = i + 1;

			// ���� ����
			for (int j=0; j<arr[i].length; j++ ) // j �� 0 1 2 3 4
			{
				arr[i][j] = n;
				n++;
			}
		}

		// �迭�� �迭 ��� ��ü ���
		for (int i=0; i<arr.length; i++ )
		{
			for (int j=0; j<arr[i].length; j++ )
			{
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}

	}
}

/* [���� ���]
  1  2  3  4  5
  2  3  4  5  6
  3  4  5  6  7
  4  5  6  7  8
  5  6  7  8  9
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/