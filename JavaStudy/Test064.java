/*======================================
���� ���� �帧�� ��Ʈ�� (���) ����
- break
	�� ����� + (�׸��� ����������)
=======================================*/

// ������ ���� ó���� �̷������ ���α׷��� �����Ѵ�.
// ��, �Է¹޴� ������ 1 ~ 1000 ���� �ȿ�����
// �����ϵ��� �ۼ��Ѵ�.

// ���� ��)
// ������ ���� �Է� (1~1000) : -10
// ������ ���� �Է� (1~1000) : 0
// ������ ���� �Է� (1~1000) : 2021
// ������ ���� �Է� (1~1000) : 10
// >> 1 ~ 10 ������ �� : 55
// ����Ͻðڽ��ϱ�?(Y/N) : y

// ������ ���� �Է� (1~1000) : 100
// >> 1 ~ 100 ������ �� : 5050
// ����Ͻðڽ��ϱ�?(Y/N) : N
// ����Ϸ��� �ƹ� Ű��...
 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test064
{
	public static void main(String[] args) throws IOException
	{

		// ���� (������ϰ�) �� Ǯ��
		/*
		int n;
		int result =0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		do
		 {
         System.out.print("������ ���� �Է�(1~1000) : ");
         n = Integer.parseInt(br.readLine());
		 }
		 while (1000<=n || n<=1);

		int a=1;

		while (a<=n)
		{
			result += a;
			a++;
		}

		System.out.printf(" >> 1 ~ %d ������ �� : %d\n",n,result);
		System.out.printf(" ����Ͻðڽ��ϱ�?(Y/N) : ");
		
		int j;
		j = (char)System.in.read();
		
		if (j=='Y'||j=='y')
		{
			System.out.print("������ ���� �Է� (1~1000) : ");
		}
		else
			return;
		*/
			


		// �Բ� �� Ǯ��


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n, s=0, i;		//-- ����� �Է°�, ������, ��������
		char ch;			//-- ��� ���� �Է°� 
		

		while (true)		//-- ���� ����(�ݺ�)
		{
			do
			{
				System.out.print("������ ���� �Է� (1~1000) : ");
				n = Integer.parseInt(br.readLine());				// " \r  \n "
			}
			while (n<1 || n>1000);		// �ݺ��� ������ ���� (OR) 
			
			// �ʱ�ȭ ��ġ check~!!! (�� ������ �Ȱ��� �� �־��� �� ���� 2�谡 ��)
			s=0; 

			for (i=1;i<=n;i++ )
			{
				s += i;
			}
			
			// �׽�Ʈ
			// System.out.println("������ :"+ s);
			System.out.printf("\n >> 1 ~ %d ������ �� : %d\n",n,s);

			System.out.print("����Ͻðڽ��ϱ�?(Y/N) : ");
			ch = (char)System.in.read();		// y + \r + \n	(
			
			// �׽�Ʈ
			// System.out.println("��ӿ��� : "+ch);

			
			// ch == 'n' ch == 'N' y�� �ƴϳ� -> � Ű���� �ߴ� (y�� ������ ����)
			// �Է°��� �ҹ���  y�� �ƴϴ�. �Է°��� �빮�� Y�� �ƴϴ�.
			//	�� ch != 'y				    ��	ch != 'Y'

			// SCE
			if (ch !='y' && ch !='Y')	// y�� �ƴϸ鼭 Y�� �ƴϾ���Ѵ� (&&)
			{
				// �ݺ��� �� ��while(true)�� �� �������� �� �ִ� �ڵ� �ۼ� �ʿ�
				//-- ���� ���� �ǻ� ǥ���� �ߴٸ�
				// �׵��� �����ߴ� �ݺ����� ���߰� �����������Ѵ�.
				break; 
				//-- ����� + (�׸��� ����������) check~!!

			}

			//  ���Ͱ�(\r + \n) �߰� ó��
			System.in.skip(2);

		}//end while(true)
		
		
		
		


	}//end main()
}//end class Test064


/*
[���� ���]

������ ���� �Է� (1~1000) : -1
������ ���� �Է� (1~1000) : 1200
������ ���� �Է� (1~1000) : 100

 >> 1 ~ 100 ������ �� : 5050
����Ͻðڽ��ϱ�?(Y/N) : y
������ ���� �Է� (1~1000) : 100

 >> 1 ~ 100 ������ �� : 5050
����Ͻðڽ��ϱ�?(Y/N) :
*/