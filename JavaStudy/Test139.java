
/*======================================
���� �ڹ��� �ֿ�(�߿�) Ŭ���� ����
- Calendar Ŭ����
======================================*/

// �� �ǽ� ����
//    ������ ��������...
//	  �Է¹޴� ��¥��ŭ ���� ��, ��, ��, ������ Ȯ���Ͽ�
//	  ����� ����ϴ� ���α׷��� �����Ѵ�.
//	  ��, Calendar Ŭ������ Ȱ���Ͽ� ó���Ѵ�.

// ���� ��)
// ���� ��¥ : 2021-3-8 ������
// �� �� ���� ��¥�� Ȯ���ϰ��� �Ͻʴϱ�? : 200

// =========[Ȯ�ΰ��]=========
// 200�� �� : 2021-xx-xx x����
// ============================
// ����Ϸ��� �ƹ� Ű��...

// �� Ư�� ��¥�� �������� �� ���� ���ϴ� ���� �޼ҵ�
//	  ����¥��ü.add(Calendar.DATE, �� ��)��
import java.util.Calendar;
import java.util.Scanner;

public class Test139
{
	public static void main(String[] args)
	{
		// ���� Ǭ Ǯ�� (��Ǯ���~!)
		/*
		int n;	//-- �Է¹޴� ����
		Calendar cd = Calendar.getInstance();

		int year = cd.get(Calendar.YEAR);	
		int month = cd.get(Calendar.MONTH) +1;
		int date = cd.get(Calendar.DATE);
		int yoil = cd.get(Calendar.DAY_OF_WEEK);


		//System.out.print("���� ��¥ : " + cd.getTime());
		System.out.printf("���� ��¥ : %d-%d-%d %d",year,month,date,yoil);
		System.out.println();


		// ���� ���� ��¥ �Է¹ޱ� n
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.print("�� �� ���� ��¥�� Ȯ���ϰ��� �Ͻʴϱ�? :");
			n = sc.nextInt();

		}
		while (n<0);
		

		// n�� ���� ��� ����
		void add(int da, int n);
		{
			date = cd.get(Calendar.DATE) + n;
			if (date >cd.getActualMaximum(Calendar.DATE))
			{
				month += 1;
				date = 1;
			}
			if (month >12)
			{
				year += 1;
				month =1;
			}
		}

		 // date2 = cd.add(date, n);
		System.out.print(date2);
		*/


		// �Բ� �� Ǯ��
		Scanner sc = new Scanner(System.in);

		// Calendar Ŭ���� �ν��Ͻ� ����
		Calendar now = Calendar.getInstance();

		// �ֿ� ���� ����
		int nalsu;		//-- ����ڷκ��� �Է¹��� �� ��
		int y, m, d, w;	//-- ��, ��, ��, ����
		String[] week = {"��","��","ȭ","��","��","��","��"};
		

		// ������ ��, ��, ��, ���� Ȯ��(�������� : get())
		y = now.get(Calendar.YEAR);
		m = now.get(Calendar.MONTH) +1;	//check~!!!
		d = now.get(Calendar.DATE);
		w = now.get(Calendar.DAY_OF_WEEK);


		// ������ ��, ��, ��, ���� Ȯ�ΰ�� ���
		System.out.println("���� ��¥ : " + y + "-" + m + "-" + d + " " 
							+ week[w-1] + "����");
		System.out.printf("���� ��¥ (t��) : %tF %tA\n", now, now);
		//--==>> ���� ��¥ : 2021-3-8 ������

		do
		{
			System.out.print("�� �� ���� ��¥�� Ȯ���ϰ��� �Ͻʴϱ�? : " );
			nalsu = sc.nextInt();
		}
		while (nalsu<1);
		
		// �� �� ���ϱ� ����
		now.add(Calendar.DATE, nalsu);

		// ��� ���
		System.out.println();
		System.out.println("=========[Ȯ�ΰ��]=========");
		System.out.printf("%d�� �� : %tF %tA \n", nalsu, now, now);
		System.out.println("============================");

	}
}
/*
[���� ���]
���� ��¥ : 2021-3-8 ������
���� ��¥ (t��) : 2021-03-08 ������
�� �� ���� ��¥�� Ȯ���ϰ��� �Ͻʴϱ�? : 200

=========[Ȯ�ΰ��]=========
200�� �� : 2021-09-24 �ݿ���
============================
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/