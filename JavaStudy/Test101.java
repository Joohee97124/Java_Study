/*==========================================
���� �ֹε�Ϲ�ȣ ��ȿ�� �˻����
==========================================*/

/*
�� �ֹι�ȣ ���� ����

	�� ������ �ڸ��� ������ ���ڸ� ���� ��Ģ�� �°� ���Ѵ�.

		123456 - 1234567 (�� �ֹι�ȣ)
		****** - ******
		234567 - 892345  (�� �� �ڸ��� ������ ��)

	�� ��Ģ�� �°� ���� ������ ������ ����� ��� ���Ѵ�.
		
		ex) 7 5 0 6 1 5 - 1 8 6 2 1 3 3
			* * * * * *   * * * * * * *
			2 3 4 5 6 7   8 9 2 3 4 5 
		----------------------------------
		�� 14 + 15 + 0 + 30 + 6 + 35 + 8 + 72 + 12 + 6 + 4 + 15 

		   == 217

	�� ������ ������� 11�� ����� ������������ ���Ѵ�.
		
		217 % 11 ��  ������=8

	�� 11���� �������� �� ������� ���Ѵ�.

	    11 - 8 �� 3

	�� �߰�
		�긦 ������ ��� 11�̳� 10�� ������ �Ǿ��� ���...
		��, ���� ���� ��� �������� 0�̳� 1�� ���...
		�ش� ���� 10���� ���� �������� ����.

	�� �꿡�� ó���� ���� ����� �ֹι�ȣ�� �����ϴ� ������ ���ڿ� 
		��ġ�ϴ��� ���Ѵ�.

		11 - 8 �� 3	 ==	�ֹι�ȣ ������ ���� 3
	
	�� ������ ���ڿ� ���� ��� ��ȿ�� �ֹε�Ϲ�ȣ~!!!

*/

// ���� ��)
// �ֹι�ȣ �Է�(xxxxxx-xxxxxxx) : 750615-1862133
// >> ��Ȯ�� �ֹι�ȣ~!!
// ����Ϸ��� �ƹ� Ű��...

// �ֹι�ȣ �Է�(xxxxxx-xxxxxxx) : 750615-1234567
// >> �߸��� �ֹι�ȣ~!!
// ����Ϸ��� �ƹ� Ű��...

// �ֹι�ȣ �Է�(xxxxxx-xxxxxxx) : 750615-12345	// �� �ڸ��� ������
// >> �Է� ����~!!
// ����Ϸ��� �ƹ� Ű��...

// �迭.length �� �迭���� ����(ũ��, ����)
// -> �޼ҵ� X, �Ӽ�

// �� ���ڿ�.length() �� ���ڿ��� ���� ��ȯ	(�Ӽ�X,�޼ҵ夷)
//	  ���ڿ�.substring() �� ���ڿ� ����

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test101
{
	public static void main(String[] args) throws IOException
	{
		// �׽�Ʈ
		// String strTemp = "���ع�����λ��� ������⵵��";
		// System.out.println(strTemp.length());
		//--==>> 15

		// �׽�Ʈ
		// System.out.println("�������� �� �ҳ���".length());
		//--==>> 10

		// �׽�Ʈ
		// System.out.println("abcdefghijklmnopqrstuvwxyz".substring(3,5));
		//--==>> de (3~4(=5-1))���� ���ڿ� ��ȯ
		// substring(m, n) �� ���ڿ� �ε��� m��°���� n-1 �� °���� ����
		//					  �ε����� 0����...

		// �׽�Ʈ
		// System.out.println("abcdefghijklmnopqrstuvwxyz".substring(3,24));
		//--==>> defghijklmnopqrstuvwx

		// System.out.println("abcdefghijklmnopqrstuvwxyz".substring(3,25));
		//--==>> defghijklmnopqrstuvwxy

		// System.out.println("abcdefghijklmnopqrstuvwxyz".substring(3,26));
		//--==>> defghijklmnopqrstuvwxyz

		// System.out.println("abcdefghijklmnopqrstuvwxyz".substring(3,27));
		//--==>> ���� �߻� (��Ÿ�� ����)
		//		 java.lang.StringIndexOutOfBoundsException

		//�׽�Ʈ
		// System.out.println("���̿��������װڳ�".substring(4,9));
		// �� System.out.println("�����װڳ�");
		//--==>> �����װڳ�

		// �׽�Ʈ
		// System.out.println("������������".substring(3));
		// System.out.println("������������".substring(3, "������������".length()));
		// System.out.println("������������".substring(3, 6));
		// System.out.println("������");
		//--==>> ������
		
		
		//���� �� Ǯ��
		/*
		String numbers;			// �ֹι�ȣ�� �Է¹��� ����

		int [] numbers2 = new int [14];
		int [] cal = {2,3,4,5,6,7};
		int [] cal2 = {8,9,2,3,4,5};

		int sum1=0;					// ��� �� ����
		int sum2=0;					


		Scanner sc = new Scanner(System.in);

		System.out.print("�ֹι�ȣ �Է�(xxxxxx-xxxxxxx) :");	// �ֹι�ȣ �Է¹ޱ�
		numbers = sc.next();									// String ���·� ����

		if (numbers.length() != 14)						// ���̸� ���� �Է¿��� Ȯ��
		{
			System.out.println("�Է� ����~!!!");
		}

		// Int������ ����ȯ (��)
		for (int i=0;i<6 ;i++ )									
		{
			numbers2[i] = Integer.parseInt(numbers.substring(i,(i+1)));
			// System.out.print(numbers.substring(i,(i+1)));
		}
		
		// Int������ ����ȯ (��)
		for (int i=7; i<14 ;i++ )								
		{
			numbers2[i] = Integer.parseInt(numbers.substring(i,(i+1)));
			 //System.out.print(numbers.substring(i,(i+1)));
		}
		
		// ����� ��� ����
		for (int i=0; i<6; i++ )
		{
			sum1 += numbers2[i] * cal[i];
		}
		//System.out.print(sum1);

		for (int i=7,j=0; i<13; i++,j++)
		{
			sum2 += numbers2[i] * cal2[j];
		}
		// System.out.print(sum2);
		

		int result = sum1 + sum2;		//  ��,����� ���� ��
		int nan = result%11 ;			// �� 11�� ���� ������
		int k = 11 - nan;
		int real=0;

		if (k==10 || k==11)
		{
			real = k%10;
		}

		if (k==numbers2[13] || real == numbers2[13])
		{
			System.out.println(">> ��Ȯ�� �ֹι�ȣ~!!");
		}
		else
			System.out.println(">> �߸��� �ֹι�ȣ~!!");
		*/


		// �Բ� �� Ǯ��
		
		// BufferedReader Ŭ���� �ν��Ͻ� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// �Է¹��� �ֹι�ȣ
		String str;

		// �ֹι�ȣ�� ������� �������� �� �迭 ����	// 123456-1234567
		int[] chk = {2, 3, 4, 5, 6, 7, 0, 8, 9, 2, 3, 4, 5};
		//						    __check~!!

		
		// ���� ���� �� ������
		// int tot = 1; �������̴ϱ� 1�� �ʱ�ȭ�Ǹ� +�� ������ ���� ! 0���� �ʱ�ȭ~
		int tot = 0;
		
		// ����ڿ��� �ȳ� �޼��� ��� �� �ֹι�ȣ �Է¹ޱ�
		System.out.print("�ֹι�ȣ �Է�(xxxxxx-xxxxxxx) :");
		str = br.readLine();
		
		if (str.length() != 14)
		{
			System.out.println(">> �Է¿���~!!");
			return;	// �޼ҵ� ���� �� ���α׷� ����
		}
		
		// Ȯ�� �׽�Ʈ
		// System.out.println(">>�ڸ����� ������ ��Ȳ~!!!");
		
		// 1 2 3 4 5 6 - 1 2 3 4 5 6   7 
		// 2 3 4 5 6 7 0 8 9 2 3 4 5
		for (int i=0; i<13 ; i++ )	// i �� 0 1 2 3 4 5 6 7 8 9 10 11 12 
									// chk�� ���̸�ŭ �ݺ�  
		{
			if (i==6)
				continue;			// �޺κ� �����ϰ� ����ض�...

			tot += chk[i] * Integer.parseInt(str.substring(i,(i+1)));	//�޺κ�

			// chk[0] * Integer.parseInt(�ֹι�ȣ 0��° �ڸ� ����)
			// chk[0] * Integer.parseInt(str.substring(0,1))
			// chk[i] * Integer.parseInt(str.substring(i,(i+1)))
		
			// tot += chk[6] * Integer.parseInt(str.substring(6,7));
			// tot += chk[6] * Integer.parseInt("123456-1234567".substring(6,7));
			// tot += chk[6] * Integer.parseInt("-");
			//				  ---------------------------- Error

		}

		//-- ������� �����ϸ� ��� �� �� ��� ���� ��Ȳ�̸�
		//	 ��Ģ�� �°� ���������� ������ ����� ��� ���� ����
		//	 ���� tot�� ����ִ� ���°� �ȴ�.

		
		int su = 11 - tot % 11;
		//            ----------
		//      ----------------

		// �׽�Ʈ (Ȯ��)
		// System.out.println(su);
		//--==>>
		
		// ���� ��� ��� ������ �߰� ���� �ʿ�~!!
		// �� su �� ���� ���� ����� �� �ڸ��� ���� ���
		//	  �ֹι�ȣ ������ �ڸ����� ���� �� ���� ��Ȳ
		su = su % 10;	// su %= 10;
		
		//-- ������� �����ϸ� ��� ��� �߰����� ��� ���� ��Ȳ�̸�
		//   ���� ���� ����� ���� su�� ����ִ� ��Ȳ�� �ȴ�.

		// ������� ���
		// if (su == Integer.parseInt(//�ֹι�ȣ�������ڸ� �ϳ� ����)
		// if (su == Integer.parseInt(str.�������ڸ� �ϳ� ����)
		if (su == Integer.parseInt(str.substring(13)))
			System.out.println(">> ��Ȯ�� �ֹι�ȣ~!!");

		else
			System.out.println(">> �߸��� �ֹι�ȣ~!");
	}
}
/*
[������]
�ֹι�ȣ �Է�(xxxxxx-xxxxxxx) :861212-1234567
>> �߸��� �ֹι�ȣ~!
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

�ֹι�ȣ �Է�(xxxxxx-xxxxxxx) :750615-1862133
>> ��Ȯ�� �ֹι�ȣ~!!
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

�ֹι�ȣ �Է�(xxxxxx-xxxxxxx) :1234
>> �Է¿���~!!
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/