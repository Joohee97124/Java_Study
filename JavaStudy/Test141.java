/*======================================
���� �ڹ��� �ֿ�(�߿�) Ŭ���� ����
- Random Ŭ����
======================================*/

/*
�� java.util.Random Ŭ������

   ���� ������ ������ �߻����� �����ϴ� Ŭ�����̴�..
   Math Ŭ������ ���� �޼ҵ��� random() �޼ҵ嵵 ������ �����ϴ� �޼ҵ�������
   0.0 ~ 1.0 ������ �Ǽ� ���¸� �߻��ϰ� �ǹǷ�
   �ʿ��� ���� ������ ������ ������ ���ؼ��� �߰����� ������� �����ؾ� �Ѵ�.
   �׷��� �ڹٴ� ���� ������ ������ �߻������ִ�
   ���� Ŭ������ Random Ŭ������ ������ �����ϰ� �ִ�.
*/

// �ζ� ��ȣ ������ (���� �߻� ���α׷�)

// ���α׷��� ����Ǹ� �⺻������ �ζǸ� 5���� �����ϴ� ���α׷��� �����Ѵ�.

// ���� ��)
// 1 4 17 23 44
// 1 2 8 16 28 42
//	:
// ����Ϸ��� �ƹ� Ű��...


// ���� �� Ǯ��
/*
import java.util.Random;

class Lotto
{
	int[] lo = new int [6]; 
	
	// ���� �߻�
	void cal()
	{
		Random rd = new Random();
		for (int i=0;i<=5 ;i++ )
		{
			lo[i] = rd.nextInt(45)+1;

			for (int j=0; j<i ; j++ )
			{
				if (j==0)
					continue;

				if (lo[j] == lo[i])
				{
					i--;
				}
			}
		}
	}
	
	// ������������ �����ϱ�
	void seq()
	{
		for (int j=1; j<=lo.length ; j++ )
		{
			for (int k=0; k <lo.length-j ; k++ )
			{
				if (lo[k] > lo[k+1])
				{
					lo[k] = lo[k]^lo[k+1];
					lo[k+1] = lo[k+1]^lo[k];
					lo[k] = lo[k+1]^lo[k];
				}
			}
		}
	}

	// ����ϱ�
	void print()
	{
		for (int i=0; i<=5 ;i++ )
		{
			System.out.printf("%4d", lo[i]);
		}
	}


}


public class Test141
{
	public static void main(String[] args)
	{
		Lotto lotto = new Lotto();

		for (int i=1; i<=5 ; i++ )
		{
			lotto.cal();
			lotto.seq();
			lotto.print();
			System.out.println();
		}
	}
}
*/


// �Բ� �� Ǯ��

import java.util.Random;
import java.util.Arrays;

class Lotto
{
	// �迭 ���� ���� �� �޸� �Ҵ� �� �ζ� ��ȣ�� ��Ƶ� �迭�� 6��
	private int[] num = new int[6];

	// getter
	public int[] getNum()
	{
		return num;
	}

	// 6���� ������ �߻���Ű�� �޼ҵ� ����
	public void start()
	{
		int cnt = 0;		//-- �ζ� �迭�� �ε���
		Random rd = new Random();
		int n;				//-- �߻� �� ����
		

		jump:
		while (cnt<6)	// cnt �� 0 1 2 3 4 5 
		{
			n = rd.nextInt(45)+1;	// 1 ~ 45	�� 27 3 14 (�����߻�)

			for (int i=0 ; i<cnt ; i++ )
			{
				// Ȯ��(�׽�Ʈ)
				//System.out.println("i : " + i + ", cnt : " + cnt);

				if (num[i] == n)
					continue jump;

			}

			num[cnt++] = n;	// num[0] 27  num[1] 3  num[2] 14 .... num[5] 30
			
		}
		// ���� �޼ҵ� ȣ��
		sorting();

	}// end start()
	

	// ���� �޼ҵ� ����
	private void sorting()
	{
		Arrays.sort(num);
	}
}


public class Test141
{
	public static void main(String[] args)
	{
		Lotto lotto = new Lotto();
		

		for (int i=1; i<=5 ; i++ )
		{
			// Ȯ��(�׽�Ʈ)
			lotto.start();
		
			// ��� ���
			for (int n: lotto.getNum())
				System.out.printf("%4d",n);
			System.out.println();
		}

	}
}
/*
[���� ���]
   5  12  18  29  32  37
   4  15  29  37  43  44
   8  18  21  28  41  43
   6  12  14  15  19  43
   2   7  34  35  36  40
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/