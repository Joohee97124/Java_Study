/*=================================================
���� �ڹ� �⺻ ���α׷��� ����
- ������ �ڷ���
- �ڹ��� �⺻ ����� 
=================================================*/

// �� �ﰢ���� ���� = �غ� * ���� / 2

// �ﰢ���� �غ��� ���̿� ���̸� ����ڷκ��� �Է� �޾�
// �ﰢ���� ���̸� ���ϴ� ���α׷��� �����Ѵ�.

// ���� ��)
// �� �ﰢ���� ���� ���ϱ� ��
// - �ﰢ���� �غ� �Է� : 3
// - �ﰢ���� ���� �Է� : 5
// >> �غ��� 3, ���̰� 5�� �ﰢ���� ���� : xxxx
// ����Ϸ��� �ƹ� Ű�� ��������...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Test013
{
	public static void main(String[] args) throws IOException
	{
		
		// ���� Ǯ�� �� ����
		/*
		System.out.println("�� �ﰢ���� ���� ���ϱ� ��");

		

		System.out.print("- �ﰢ���� �غ� �Է� : " );
		BufferedReader br1 = new BufferedReader (new InputStreamReader(System.in));

		int a;		//-- a = �غ�
		a = Integer.parseInt(br1.readLine());

		

		System.out.print("- �ﰢ���� ���� �Է� : " );
		BufferedReader br2 = new BufferedReader (new InputStreamReader(System.in));

		int b;		//-- b = ����
		b = Integer.parseInt(br2.readLine());

		

		int area;	//-- c = ����
		area = (a*b)/2;

	

		System.out.printf(">>> �غ��� %d, ���̰�  %d�� �ﰢ���� ���� : %d\n", a, b, area);



		
		// 1 �غ��� ���� �Է¹ޱ�
		// 2 �Է¹����� ������ �����ϱ�
		// 3 �ﰢ�� ���� �� ���ϱ� (������)
		// 4 >>�� 2�� �����ϱ�
		*/



		// �Բ� �� Ǯ�� ����


		// �ܺηκ��� �����͸� �Է¹޵��� ó���ϱ� ���ؼ�
		// BufferedReader �ν��Ͻ� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// import ���� & throw IOE ��������

		// �ֿ� ���� ����
		int underLength, height;		//-- �غ�, ����
		double area;					//-- ���� check~!!
	

		// ���� �� ó��
		// �� ����ڿ��� �ȳ� �޼��� ���
		System.out.println("�� �ﰢ���� ���� ���ϱ� ��");
		System.out.print("- �ﰢ���� �غ� �Է� : ");			// ln �ƴϴ�

		// �� ����ڰ� �Է��� ������(�غ�)�� 
		//    ���� ���·� ��ȯ�� �� 
		//    ���� underLength �� ��Ƴ���
		underLength = Integer.parseInt(br.readLine());

		// �� �ٽ� ����ڿ��� �ȳ� �޼��� ���
		System.out.print("- �ﰢ���� ���� �Է� : ");
		
		// �� ����ڰ� �Է��� ������(����)��
		//    ���� ���·� ��ȯ�� ��
		//    ���� height�� ��Ƴ���
		height = Integer.parseInt(br.readLine());		// readLine() : ������ ����
		//							"1200"			"ȫ�浿"�� ���� (Integer.parseInt , int������ �����ϱ� ����)
		//		---------------------------------
		//			1200
		
		// �� �ﰢ���� ���̸� ���ϴ� ���� ó��
		// �ﰢ���� ���� = �غ� * ���� / 2
		// area = underLength * height / 2
		//		������		 ������
		//				����		/ 2
		// �� 7�� area���� 7.0 ���� �� (7.5�� �ƴ϶��)
		area = underLength * height / 2.0;
		//-- �Ǽ� �ڷ����� ��������� ������ ��������
		//   �Ǽ� ����� ������ �ʿ��� ��Ȳ�̴�.
		//   ������ ��2���� �ƴ� �Ǽ��� ��2.0������ ������ ������ �����ϰ� �Ǹ�
		//   �� ������ �Ǽ� ������� ó���ȴ�.


		// ��� ���
		System.out.println();	// ()�� ����ΰ� ���� ��������ش�.
		// System.out.print();	// �̰� ����,,
		System.out.printf(">> �غ��� %d, ���̰� %d�� �ﰢ���� ���� : %.2f\n",underLength, height, area);


	}
}

/*
[���� ���]
�� �ﰢ���� ���� ���ϱ� ��
- �ﰢ���� �غ� �Է� : 3
- �ﰢ���� ���� �Է� : 5

>> �غ��� 3, ���̰� 5�� �ﰢ���� ���� : 7.50
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/