/*======================================
���� ���� �帧�� ��Ʈ�� (���) ����
- continue
	�� (�޺κ� �����ϰ�) + ����ض�
=======================================*/

// ���� ��)
/*
1 : 1
3 : 4
5 : 9
7 : 16
	:
	:
99 : 2500
��� : 2500
*/

public class Test065
{
	public static void main(String[] args)
	{
		// ���� �� Ǯ��
		/*
		int n1,n2, sum=0;		// ����1, ����2, ������
		n1 = n2 = 1;

		while (n1<100)
		{
			System.out.printf("%d : %d\n", n1, n2);
			
			n1 += 2;
			n2 += n1;

		}
		
		int n=1, s=1, sum =0;
		
		do
		{
			System.out.printf("%d : %d\n", n, s);
			n += 2;
			s += n;
			continue;

		}
		while (n<100);
		*/


		// �Բ� �� Ǯ��
		int n=0 , s=0;		//-- ���� ������

		while (n<100)		// 0 ~ 99
		{
			n++;			// 1 ~ 100

			if (n%2==0)		// ¦�����
				continue;	// (�޺κ� �����ϰ�) + ����ض�
			
			s += n;							// �޺κ�
			System.out.println(n+":"+s);	// �޺κ�
		}
		System.out.println("��� : "+s);
	

	

		
	}
}
/*
[������]

*/
