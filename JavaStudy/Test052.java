/*===============================
���� ���� �帧�� ��Ʈ��(���) ����
- �ݺ��� (while��) �ǽ�
===============================*/

// �� ����
// ����ڷκ��� ������ ������ �Է¹޾�
// 1���� �� �������� ��ü �հ�, ¦���� �հ�, Ȧ���� ����
// ���� ��������� ����ϴ� ���α׷��� �����Ѵ�.

// ���� ��)
// ������ ���� �Է� : 284
// >> 1 ~ 284 ���� ������ �� : xxxx
// >> 1 ~ 284 ���� ¦���� �� : xxxx
// >> 1 ~ 284 ���� Ȧ���� �� : xxxx
// ����Ϸ��� �ƹ� Ű��...


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test052
{
	public static void main(String[] args) throws IOException
	{
		int n, result, even, odd;
		result = even = odd =0;

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

		System.out.print("������ ���� �Է� : ");
		n = Integer.parseInt(br.readLine());
		

		int m =0;			// �� ���� m ���� �� 0���� �ʱ�ȭ

		while (m<=n)		// m<n�̸� (n����)
		{
			result += m;	// ���� ������
			
			if (m%2 == 0)	// ¦�� ������
			{
				even += m;
			}
			else			// Ȧ�� ������
			{
				odd += m;
			}

			m++;			// m++ 
			
		}


		System.out.printf(" >> 1 ~ %d ���� ������ �� : %d \n", n, result);
		System.out.printf(" >> 1 ~ %d ���� ¦���� �� : %d \n",n,even);
		System.out.printf(" >> 1 ~ %d ���� Ȧ���� �� : %d \n",n, odd);

		
	}
}
/*
[���� ���]
������ ���� �Է� : 17
 >> 1 ~ 17 ���� ������ �� : 153
 >> 1 ~ 17 ���� ¦���� �� : 72
 >> 1 ~ 17 ���� Ȧ���� �� : 81
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/