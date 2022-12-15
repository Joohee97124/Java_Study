/* ================================
���� �迭(Array) ����
- �迭�� ����
==================================*/

// �� �ǽ� ����
// ������ �迭 (a, b)�� ����ִ� ���ڵ��� �������� ����ϴ� ���α׷��� �����Ѵ�,.
// ��, �ߺ��� ���ŵ� ������ �������� ����� �� �ֵ��� �Ѵ�.
// ����, �迭 ���� ������ ������� ó���� �� �ֵ��� �Ѵ�.

// ex) ������ �� �迭�� ��������
// int[] a = {2, 3, 7, 10, 11}
// int[] b = {3,6,10,14}

// ���� ��)
/*
// ù ��° �迭 ��Ҹ� �Է��ϼ���(���� ����) : 2 3 7 10 11
// �� ��° �迭 ��Ҹ� �Է��ϼ���(���� ����) : 3 6 10 14
*/

// 2 3 5 7 10 11 6 14


// ���� �� Ǯ��

class Cal
{
	int n=0;			//-- �ߺ��Ǵ� ���� ����
	int m;


	int [] a = {2, 3, 7, 10, 11};
	int [] b = {3, 6, 10, 14};
	int [] c ;
	int index;
	

	public void arrSum()						//-- �ߺ��Ǵ� ���� ������ n++ 
	{
		for (int i=0; i<a.length ; i++ )
		{
			for (int j=0;j<b.length ;j++ )
			{
				if (a[i] == b[j])
				{
					n++;						
				}
			}
		}

		c = new int[a.length + b.length - n];	//-- �迭 c (��ġ��) ����

		
		for (m=0;m<a.length ;m++ )
			c[m] = a[m];

		
		for (int j=0; j<b.length ; j++ )
		{
			boolean flag = false;

			for (int k=0; k<c.length; k++)
			{
				if (b[j]==c[k])					//-- �ߺ��Ǵ� ���� ������ break;
				{
					flag = true;
					break;
				}
			}

			if (flag)
			{
				continue;
			}

			c[m] = b[j];
			m++;
		}

		

	}

	public void print()
	{
		for (int i=0; i<c.length; i++)
		{
			System.out.print(c[i]+" ");
		}

		
	}

}


public class Test099
{
	public static void main(String[] args)
	{
		// ���� �� Ǯ��
		Cal ob = new Cal();
		ob.arrSum();
		ob.print();


/*
		// �Բ� �� Ǯ��

		// ������ �� �迭
		int[] a = {2, 3, 7, 10, 11};
		int[] b = {3,6,10,14};

		// ��� ��
		// - ����  a�� ��ü ��� ���
		for (int i=0; i<a.length ; i++ )
			System.out.printf("%3d",a[i]);

		// - ����  b�� ��� ���
		//   ��, ���� b�� ���� a�� ��ҿ� �ߺ��Ǵ� �����͸�
		//   �����ϸ鼭 ���
		for (int i=0; i<b.length ; i++ )			// 4ȸ�� (b.length=4) �� 3 6 10 14(������ ���)
		{
			boolean flag = false;					// a�� �Ͱ� ���� �ʴٰ� ����

			for (int j=0; j<a.length ; j++ )		// 5ȸ��(a�� ��ҵ�� ��) �� 2 3 7 10 11
			{
				if (b[i]==a[j])						// b�� 
				{
					flag = true;
					break;							// ����� �׸��� ���������� 
													// (j ���� �ݺ��� Ż�� + �ߺ��Ǹ� ���� �͵��� �� ���غ��� ���� �� i �ݺ����� Ż��)
				}
			}

			if (flag)								// flag�� true��� ....
				continue;							// �޺κ� �����ϰ� ... ����ض�...

			System.out.printf("%3d",b[i]);			// �޺κ� (��� ����)

		}
		System.out.println();




		// ��� ��
		// - �ӽ� �迭�� �����
		// int [] temp = new int[???];
		int [] temp = new int[a.length + b.length];

		// - ������� �ӽ� �迭�� �ߺ����� ���� �迭 ��Ҹ� ä�� ����
		//check~!!!
		int n;							//-- ���� ���� ��ġ �߿�~!!!

		for (n=0; n<a.length ; n++ )
			temp[n] = a[n];

		// �׽�Ʈ
		// System.out.println(n);
		//--==>> 5


		for (int k=0; k<b.length ; k++)
		{
			boolean flag = false;

			for (int m=0 ; m<a.length ; m++ )
			{
				if (b[k] == a[m])
				{
					flag = true;
					break;			
				}
			}

			if (flag)
				continue;

			temp[n] = b[k];			//-- �޺κ�
			n++;					//-- �޺κ�

			// �׽�Ʈ
			// System.out.println(n);
			//--==>> 7

		}

		// - �׷��� ������ �ӽ� �迭�� ��� (ä������ŭ...)
		for (int h=0; h<n ; h++ )
		{
			System.out.printf("%3d",temp[h]);
		}
		System.out.println();
*/		

	}
}