/*===========================================
���� �ڹ� �⺻ ���α׷��� ����
- ������ �ڷ���
- �ڹ��� �⺻ �����
===========================================*/

// ����ڷκ��� �̸��� ��������, ��������, ���������� �Է¹޾�
// �̸��� ������ ����ϴ� ���α׷��� �����Ѵ�.

// ���� ��)
// �̸��� �Է��ϼ��� : �ڳ���
// ���� ���� �Է� : 90
// ���� ���� �Է� : 80
// ���� ���� �Է� : 70

// ====[���]====
// �̸� : �ڳ���
// ���� : 240
// ==============
// ����Ϸ��� �ƹ� Ű�� ��������...

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
*/

import java.io.*;				//  �̰ź��� ������ ���,, (�츮�� 3���� ���µ� �Ⱦ��� ������ �ֵ��� �� �޸𸮿� ���� �Ť�)

public class Test014 
{
	public static void main(String[] args) throws IOException
	{
		// ���� �� Ǯ��
		/*
		String name;
		int k,e,m,total;

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

		System.out.print("�̸��� �Է��ϼ��� : ");
		name = br.readLine();	// ���ڿ��� Integer.parseInt ������ �� �ʿ�x �׳� ���� ���ڿ��� ���� �Ǵϱ�~

		System.out.print("���� ���� �Է� : ");
		k = Integer.parseInt(br.readLine());

		System.out.print("���� ���� �Է� : ");
		e = Integer.parseInt(br.readLine());

		System.out.print("���� ���� �Է� : ");
		m = Integer.parseInt(br.readLine());

		total = k+e+m ; // ��� ���⼭ �ʱ�ȭ ����� ��! (������ ���� k,e,m�� �ʱ�ȭ �ǰ� ����)

		System.out.println();

		System.out.println("=====[���]=====");
		// System.out.printf("�̸� : %s\n" , name);
		// System.out.printf("���� : %d\n", total);
		System.out.println("�̸� : "+ name);
		System.out.println("���� : "+ total);
		System.out.println("=================");

	
		// 0. BufferedReader �� ����
		// 1 �̸�
		// 2 ��������
		// 3 ����
		// 4 ����
		// 5 ����
		// 6 ���
		*/

		// �Բ� �� Ǯ��
		InputStreamReader isr = new InputStreamReader(System.in);	// �����⸸ ���� ����(InputStreamReader) + �޸� ����(System.in)
		BufferedReader br = new BufferedReader(isr);				// BufferedReader�� ��(isr)�� �ǳ��ָ� ��

		// �ֿ� ���� ����
		String strName;			//-- �̸� ����
		int nKor, nEng, nMat, nTot;	//-- ����, ����, ����, ���� ����
		
		// �߰� ���� ����
		String strTemp;			//-- ���ڿ� ������ �ӽ� ���� ����

		// ���� �� ó��
		// �� ����ڿ��� �ȳ� �޼��� ��� (�̸� �Է� �ȳ�)
		System.out.print("�̸��� �Է��ϼ��� : ");
		
		// ������ڰ� �Է��� ��(�ܺ� ������)�� ������ ��Ƴ���
		strName = br.readLine();
		// strName(���ڿ�) = br.readLine() (�Է°��� ���ڿ��� �޾Ƴ�) 
		//-- ������ �����ϴϱ� ����ȯ �ʿ� ����
		
		// ������ڿ��� �ȳ� �޼��� ��� (�������� �Է� �ȳ�)
		System.out.print("���� ���� �Է� : ");

		// ������ڰ� �Է��� ��(�ܺ� ������)�� ������ ��Ƴ���
		strTemp = br.readLine();			//-- ���ڿ� �ӽ� ���� "90"
		nKor = Integer.parseInt(strTemp);	//-- �ӽ����� ������ �� ��ȯ �� (���ڿ���������)
											//   �������� ������ ��Ƴ���
		
		// ������ڿ��� �ȳ� �޼��� ��� (�������� �Է� �ȳ�)
		System.out.print("���� ���� �Է� : ");
	
		// ������ڰ� �Է��� �� (�ܺ� ������) �� ������ ��Ƴ���
		strTemp = br.readLine();				//-- ���ڿ� �ӽ� ���� "80"
		nEng = Integer.parseInt(strTemp);		//-- �������� ���� ���������� ����Եȴ�
												//-- �ӽ����� ������ �� ��ȯ ��
												//   ���� ���� ������ ��Ƴ���

		
		// ������ڿ��� �ȳ� �޼��� ��� (�������� �Է� �ȳ�)
		System.out.print("���� ���� �Է� : ");

		// ������ڰ� �Է��� �� (�ܺ� ������) �� ������ ��Ƴ���
		strTemp = br.readLine();			//-- ���ڿ� �ӽ����� "70"
		nMat = Integer.parseInt(strTemp);	//-- �ӽ����� ������ �� ��ȯ ��
											//   �������� ������ ��Ƴ���

		// ���Էµ� �����͵� (nkor, nEng, nMat)�� �����Ͽ� ���� �����ϱ�
		nTot = nKor + nEng + nMat;



		// ��� ���
		System.out.println();	// ����
		System.out.println("=====[���]=====");
		System.out.println("�̸� : " + strName);
		System.out.println("���� : " + nTot);
		System.out.println("================");


	}
}