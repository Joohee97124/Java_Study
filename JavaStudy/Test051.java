/*===============================
���� ���� �帧�� ��Ʈ��(���) ����
- �ݺ��� (while��) �ǽ�
===============================*/

// ����ڷκ��� ������ �� ������ �Է¹޾�
// ���� �� ���� ū �� ������ ���� ���Ͽ�
// ����� ����ϴ� ���α׷��� �����Ѵ�.

// ���� ��)
// ù ��° ���� �Է� : 10
// �� ��° ���� �Է� : 20
// >> 10 - 20 ������ �� : xxxx
// ����Ϸ��� �ƹ� Ű��...

// ù ��° ���� �Է� : 10
// �� ��° ���� �Է� : 2
// >> 2 - 10 ������ �� : xxxx
// ����Ϸ��� �ƹ� Ű��...


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test051
{
	public static void main(String[] args) throws IOException
	{

		// ���� ���ͳ��� �� Ǯ��
		/*
		int num1, num2, n, result=0;
	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("ù ��° ���� �Է� : ");
		num1 = Integer.parseInt(br.readLine());

		System.out.print("�� ��° ���� �Է� : ");
		num2 = Integer.parseInt(br.readLine());

		
		if (num1>num2)		// ���� ���� ������ �����´�
		{
			num1 = num1^num2;
			num2 = num2^num1;
			num1 = num1^num2;
		}
		
		n = num1;			// ������ ������ ���� ������� num1���� ������ش�

		while (n<=num2)
		{
			result += n;
			n++;
		}
		
		System.out.printf("%d - %d�� �� : %d\n ",num1,num2,result);

		// �ѹ� �� �� ��Ĵ�� Ǯ���
		*/
			

	
		// �Բ� �� Ǯ��

		// �� �ֿ� ���� ����

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n, su1, su2, result=0;
		//-- ��������, ù��° �Է°�, �ι�° �Է°�, �����(������ ���� ���)

		// �� ���� �� ó��
		// ������ڿ��� �ȳ� �޼��� ��� �� �Է°� ��Ƴ���
		System.out.print("ù ��° ���� �Է� : ");
		su1 = Integer.parseInt(br.readLine());

		System.out.print("�� ��° ���� �Է� : ");
		su2 = Integer.parseInt(br.readLine());
		
		// �������� ���꿡 ���� �ռ�
		//	 �Է� ���� �� ���� ũ�� �� �� �ڸ� �ٲ�
		//	 ��, su1�� su2 ���� Ŭ ��� �� ���� �ڸ��� �ٲ� �� �ֵ��� ó��
		if (su1>su2)
		{
			// �� ���� �ڸ� �ٲ�
			su1 = su1^su2;
			su2 = su2^su1;
			su1 = su1^su2;
		}
		
		n = su1;	// ��ġ �߿� (ũ����ϰ� �ڸ��ٲ� ���Ŀ� �־�!)

		while (n<=su2)
		{
			result += n;
			n++;
		}

		// �� ��� ���
		System.out.printf(">> %d - %d ������ �� : %d\n", su1,su2,result);
		
	}
}

/*
[������]
ù ��° ���� �Է� : 50
�� ��° ���� �Է� : 2
>> 2 - 50 ������ �� : 1274
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

ù ��° ���� �Է� : 2
�� ��° ���� �Է� : 5
>> 2 - 5 ������ �� : 14
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/