/*===========================================
���� �ڹ� �⺻ ���α׷��� ����
- �ڹ��� �⺻ ����� : printf()
===========================================*/

public class Test016 
{
	public static void main(String[] args)
	{
		System.out.print("AAA");
		System.out.print("BBB");
		System.out.print("CCC\n");		//-- \n ����

		// ���� ��� �޼ҵ�
		System.out.printf("12345678901234567890");
		System.out.printf("12345678901234567890\n");	//-- \n ����
		System.out.printf("12345678901234567890%n");	//-- %n ����
		System.out.printf("%d + %d = %d\n", 10, 20, 30);
	
		//--==>> AABBCC
		//		 123456789012345678901234567890
		//		 1234567890
		//		 10 + 20 = 30
		//		 ����Ϸ��� �ƹ� Ű�� �����ʽÿ�...

		System.out.printf("%d\n", 123);
		System.out.printf("%7d\n", 123);
		System.out.printf("%10d\n", 123);	// 10�� ��ġ�� �� ����س��� %10d
		System.out.printf("%010d\n", 123);
		//--==>> (0ĭ)123
		//--==>>    (4ĭ)123    (��7ĭ�� ���°�)
		//				(7ĭ)123 (�������� 10ĭ�� ������ Ȯ���ϰ� ���������� 123�� �־�, �������� ��ĭ�� 7ĭ -> ��10ĭ�� ���°�)
		//		0000000123 (�� 10ĭ ����ϴµ� 123�� ���������� �Էµǰ� ������ ��ĭ�� 0�� �־���)

		System.out.printf("%d\n", 365);
		System.out.printf("%+d\n", 365);		// ����
		System.out.printf("+%d\n", 365);
		//--==>> 365
		//		 +365
		//		 +365

		System.out.printf("%d\n", +365);	// ��� ���·� �ȳ���
		//--==>> 365
		System.out.printf("%d\n", -365);	// ���� ���·� ����
		//--==>> -365

		// System.out.printf("%-d\n", 365); ��Ÿ�� ���� �߻�
		// --==>> ���� �߻� (��Ÿ�� ����)
		// printf �ȿ��� ���̴� �ֵ� (�ɼǿ���) �� ��Ÿ�ӿ���! (�����ϰ������� �ڹٰ� Ȯ�� ����) �ɼ� �� Ȯ���ϱ�!
		
		System.out.printf("-%d\n", 365);
		//--==>> -365

		
		System.out.println(); // ����
		
		System.out.printf("%(d\n", -365);	// check~!!!
		System.out.printf("%(d\n", 365);		// check~!!!
		//--==>> (365)
		//		 365


		// System.out.printf("%d\n",'A');
		//--==>> ���� �߻� (��Ÿ�� ����)
		System.out.printf("%c\n",'A');

		// System.out.printf("%c\n","ABCD");
		//--==>> ���� �߻� (��Ÿ�� ����)
		System.out.printf("%s\n","ABCD");
		//--==>> A
		//		 ABCD

	
		System.out.println();	// ����

		System.out.printf("%h\n", 365);
		System.out.printf("%o\n", 24);
		//--==>> 16d (16������ ���� 365 �� ǥ��)
 		//		 30	 (8������ ���� 24 �� ǥ��)		 

		System.out.println();	// ����

		System.out.printf("%s\n", "true");
		System.out.printf("%b\n", true);
		//--==>> true (���ڿ�)
		//		 true (boolean��)

		System.out.printf("%s\n", true);
		// �ڵ�����ȯ! (�ڹٰ� �׳� ����)
		// ��� �� ��� ������� %d,s,b,f ������� ���~ ���ڿ�! �̾�!
		
		
		System.out.println();	// ����

		System.out.printf("%f\n", 123.23);
		System.out.printf("%.2f\n", 123.23);
		System.out.printf("%.2f\n", 123.236);	//-- �Ҽ��� 3��° �ڸ����� �ݿø� 
		System.out.printf("%.2f\n", 123.231);	
		System.out.printf("%8.2f\n", 123.236);	//-- 8: ��ü �� (������ �����ؼ�) 8�ڸ��� �� -> �տ� ���� 2ĭ ����
		System.out.printf("%2.2f\n", 123.1234); //-- 2: 2ĭ �ȿ� 123.12�� ���� �� ���⿡ �׳� 123.12 ��� ��µǰ� ����
		//--==> 123.230000
		//		123.23	check~!!!
		//		123.24	check~!!!
		//		  123.24	check~!!!
		//		123.12	check~!!!


	}
}


/*
[���� ���]
AAABBBCCC
1234567890123456789012345678901234567890
12345678901234567890
10 + 20 = 30
123
    123
       123
0000000123
365
+365
+365
365
-365
-365

(365)
365
A
ABCD

16d
30

true
true
true

123.230000
123.23
123.24
123.23
  123.24
123.12
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/