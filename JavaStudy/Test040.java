/*===============================
���� ���� �帧�� ��Ʈ��(���) ����
- switch�� �ǽ�
===============================*/

/*
�� ���� ���ù��̶� �ϸ�, switch�� ������ ���� ���� ����
   ���� ������ ���� �������� �б��� �� ����ϴ� �����̴�.

�� ���� �� ����
   swich(����)
   {
	   case ���1 : ����1; [break;]
	   case ���2 : ����2; [break;]

	   [default : ����n+1;] [break;]
	}

	switch���� �����ġ��� case�� ���������
	byte, short, int, long ���̾�� �Ѵ�.

	case �� �ڿ� ��break;�� ������ ���� ������ ���
	���� case���� ������ ����ؼ� �����ϰ� �ȴ�. (�⺻ ��)

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test040
{
	public static void main(String[] args) throws IOException
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("�̸� �Է� : ");
		String name = br.readLine();

		System.out.print("���� ���� : ");
		int kor = Integer.parseInt(br.readLine());

		System.out.print("���� ���� : ");
		int eng = Integer.parseInt(br.readLine());

		System.out.print("���� ���� : ");
		int mat = Integer.parseInt(br.readLine());

		int tot = kor + eng + mat;
		
		// doubl avg;
		int avg = tot / 3;
		char grade;

		/*
		// if���� ���
		if (avg>=90)
		{
		}
		else if (avg>=80)
		{
		}
		*/
		
		/*
		switch (avg)
		{
			case 100 : ; break;
			case 90 : ; break;
			case 98 : ; break;
			// ..
			case 0 : ; break;
		}
		*/

		/*
		switch (avg)
		{
			case 100 : case 99 : case 98 : ... grade = 'A'; break;
			case 89 : case 88 : ... grade = 'B'; break;
			// ..
			case 0 : ; break;
		}
		*/

		/*
		switch (avg/10)
		{
			case 10 : grade = 'A'; break;
			case 9 : grade = 'A'; break;
			case 8 : grade = 'B'; break;
			case 7 : grade = 'C'; break;
			case 6 : grade = 'D'; break;
			case 5 : grade = 'F'; break;
			// ..
			case 0 : ; grade = 'F'; break;
		}
		*/

		switch (avg/10)
		{
			case 10 : case 9 : grade = 'A'; break;
			case 8 : grade = 'B'; break;
			case 7 : grade = 'C'; break;
			case 6 : grade = 'D'; break;
			default : grade = 'F'; // break; ������ �������̱⿡ ������ ������!
		}
			
		System.out.println("grade : " + grade);
		// default ������ ������ ���� -> if else������ else ���� ����
		// default �� �� �־���Ѵ� (X) -> grade �� �ʱ�ȭ or default�� ������ֱ�


	}
}
/*
[���� ���]
�̸� �Է� : ������
���� ���� : 90
���� ���� : 80
���� ���� : 70
grade : B
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/