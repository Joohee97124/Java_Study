/*======================================
���� �ڹ��� �ֿ�(�߿�) Ŭ���� ����
- String Ŭ����
======================================*/


public class Test132
{
	public static void main(String[] args)
	{
		String s = "seoul korea";
		System.out.println(s);
		//--==>> seoul korea
		

		// �� ���ڿ� ����
		System.out.println(s.substring(6, 9));
		//--==>> kor
		//-- ��String Ŭ������ substring(s, e)��
		//   String ���ڿ��� �������
		//	 s ��°���� e-1 ��°����...
		//	 (��, �ε����� 0���� ����)

		System.out.println(s.substring(7));
		//--==>> orea
		//-- ��String Ŭ������ substring(s)��
		//	  String ���ڿ��� �������
		//	  s��°���� ������... (��, ���ڿ��� ���� ���̸�ŭ..)



		// �� ���ڿ� �������� �� ��
		System.out.println(s.equals("seoul korea"));		//--==>> true
		// = s�� seoul korea�� �����Ǿ��ִ�?
		System.out.println(s.equals("seoul Korea"));		//--==>> false
		//-- ��ҹ��� ������ ����

		System.out.println(s.equalsIgnoreCase("Seoul KoreA"));	//--==>> true
		//-- ��ҹ��� ���� ����
		


		// �� ã���� �ϴ� ��� ���ڿ�(s) ��
		//	  kor ���ڿ��� �����ұ�?
		//	  �����Ѵٸ� �� ��ġ�� ��� �ɱ�?

		// seoul korea 
		System.out.println(s.indexOf("kor"));	//--==>> 6 
		System.out.println(s.indexOf("ea"));	//--==>> 9
		System.out.println(s.indexOf("e"));		//--=>> 1  (ã�ڸ��� �پ��)
		System.out.println(s.indexOf("tt"));	//--==>> -1 (������ -1) 
		//-- ã���� �ϴ� ���ڿ��� ��� ���ڿ��� ������ ���
		//	 �� ���ڿ��� �ε����� ��ȯ������
		//	 �������� ���� ��� ������ ��ȯ�ϰ� �ȴ� (-1)
		


		// �� ��� ���ڿ�(s) �� ��rea���� ���������� ���� Ȯ��
		//	  (true / false)

		// seoul korea
		System.out.println(s.endsWith("rea"));	//--==>> true
		System.out.println(s.endsWith("oul"));	//--==>> false



		// �� ã���� �ϴ� ��� ���ڿ�(s)��
		//    ��e�� ���ڿ��� �����ұ�?
		//    �����Ѵٸ� �� ��ġ�� ��� �ɱ�?
		//    (��, �ڿ������� �˻�)

		// seoul korea
		System.out.println(s.indexOf("e"));			//--==>> 1
		System.out.println(s.indexOf("o"));			//--==>> 2
		System.out.println(s.lastIndexOf("e"));		//--==>> 9
		System.out.println(s.lastIndexOf("o"));		//--==>> 7



		// �� ��� ���ڿ�(s) ��
		//	  ��6����° �ε��� ��ġ�� ���ڴ�?
		
		// seoul korea
		System.out.println(s.charAt(6));		//--==>> k
		// System.out.println(s.charAt(20));		//--==>> ���� �߻� (��Ÿ�� ����)
		//-- java.lang.StringIndexOutOfBoundsException


		
		// �� ��� ���ڿ�(s)�� �� ���ڿ�("seoul corea") ��
		//	  � ���ڿ��� �� ū��?
		//	  �� ���ڿ��� �ٸ��ٸ� ���̸� Ȯ�� (������ �迭)

		System.out.println(s.compareTo("seoul corea"));		//--==>> 8
		//-- c ~ k �� defghijk (8)

		System.out.println(s.compareTo("seoul koreab"));	//--==>> -1
		//-- b ~ a �� a (-1)

		System.out.println(s.compareTo("seoua korea"));		//--==>> 11
		//-- a ~ l �� bcdefghijk (11)



		// �� ��� ���ڿ�(s) ��
		//	  �ش� ���ڿ��� ã�� ���ϴ� ���·� ����

		s = "�츮���� ���ѹα� ���ѵ��� ����";
		s = s.replaceAll("����","����");
		// s = "�츮���� ���۹α� ���۵��� ����";
		// s�� �����ؾ� ��
		System.out.println("s : " + s);
		
		

		// �� ���� ���� (space)

		s = "        ��      ��        ";
		System.out.println("|" + s + "|");
		//--==>> |        ��      ��        |

		System.out.println("|" + s.trim() + "|");
		//--==>> |��      ��|
		//-- ���� ���� �����ڸ� ���� ����

		System.out.println("|" + s.replaceAll(" ", "") + "|");
		//-- ������ �������� ������ ��������
		//--==>> |���|


		// �� 
		int n = 2345678;
		//System.out.printf("%d", n);
		//System.out.format("%d", n);
		//--==>> 23456782345678
		// ���⼭�� �Ѵ� ����ض���,,
		
		System.out.println();

		s = String.format("%d", n);
		// ����ض� X , ���ڿ����·� ��ȯ�ض� �� (return�ڷ����� String -> void X)
		// Ŭ���� �޼ҵ�
		System.out.println(s);
		//--==>> 2345678

		s =String.format("%,d",n);
		System.out.println(s);
		//--==>> 2,345,678

		double p = 3.141592;
		s = String.format("%f", p);
		System.out.println(s);
		//--==>> 3.141592

		s = String.format("%.2f",p);
		System.out.println(s);
		//--==>> 3.14

		
		String[] strArray = "�⺻,����,���".split(",");	// {"�⺻", "����", "���"}
		for (String str : strArray )
			System.out.print(str + " ");
		System.out.println();
		//--==>> �⺻ ���� ���


		
		
		

	}	
}