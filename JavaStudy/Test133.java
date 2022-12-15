/*======================================
���� �ڹ��� �ֿ�(�߿�) Ŭ���� ����
- StringBuffer Ŭ����
======================================*/

/*
�� StringBuffer Ŭ������
   ���ڿ��� ó���ϴ� Ŭ������ String Ŭ�������� ��������
   String Ŭ������ ���� ���ڿ� �������� ������ �Ұ���������
   StringBuffer Ŭ������ ���ڿ��� ����� ��
   ���� ���ڿ��� ���� �ܰ迡�� �����Ҽ� �ִٴ� ���̴�.

   ��, StringBuffer ��ü�� �������� ���̸� �����Ƿ�
   ��ü�� �����ϴ� �������� �̸� �� ũ�⳪ ���� �����ϰų�
   ���� ������ ���� ũ�⸦ �ٲ� �� �ִ� ����� �����ϴ� ���̴�.

   ���� JDK 1.5 ���ĺ��ʹ�
   ���ڿ��� ó���ϴ� StringBuilder ��� Ŭ������ �����Ѵ�.
   StringBuilder Ŭ������ ����� StringBuffer Ŭ������ ����������
   ���� ū �������� multi-thread unsafe ��� ���̴�.
   ��, Syncronization �� ���� ������ 
   StringBuffer ���� ������ ���ü�(����ȭ) ������ ���ٸ�
   StringBuilder �� ����ϴ� ���� ������ ����ų �� �ִ�.

*/

// import java.lang.*;

public class Test133
{
	public static void main(String[] args)
	{
		StringBuffer sb1 = new StringBuffer("korea");
		StringBuffer sb2 = new StringBuffer("korea");
		
		System.out.println(sb1==sb2);			//--==>> false
		System.out.println(sb1.equals(sb2));	//--==>> false

		System.out.println(sb1.toString().equals(sb2.toString()));
		//--==>> true

		/*
		String str1 = sb1.toString();
		String str2 = sb2.toString();

		Sytem.out.println(str.equals(str2));
		*/


		StringBuffer sb3 = new StringBuffer();
		//-- StringBuffer �⺻ ������ ȣ�� ��(�ν��Ͻ� ���� ����)
		//	 �⺻������ �����Ǵ� ���� ũ�� ��16��

		System.out.println("���� ũ�� : " + sb3.capacity());
		//--==>> ���� ũ�� : 16


		////////////////////////////////////////////////////////////////////////////

		System.out.println(sb3);
		//--==>> �� 

		sb3.append("seoul");			// sb3 += "seoul"; �� sb3 = sb3 + "seoul"; �� sb3 = "" + "seoul"; �� sb3 = "seoul";
		sb3.append("korea");
		sb3.append("�츮����");
		sb3.append("���ѹα�");

		System.out.println(sb3);
		//--==>> seoulkorea�츮������ѹα�

		System.out.println(sb3.toString());
		//--==>> seoulkorea�츮������ѹα�

		System.out.println("���� ũ�� : " + sb3.capacity());
		//--==>> ���� ũ�� : 34

		
		////////////////////////////////////////////////////////////////////////////

		String temp1 = "java and oracle";
		System.out.println(temp1.toUpperCase());
		//--==>> JAVA AND ORACLE

		String temp2 = "JAVA AND ORACLE";
		System.out.println(temp2.toLowerCase());
		//--==>> java and oracle 
		
		// System.out.println(sb3.toUpperCase());
		// System.out.println(sb3.toLowerCase());

		String temp3 = sb3.toString();
		System.out.println(temp3.toUpperCase());
		System.out.println(temp3.toLowerCase());
		System.out.println(sb3.toString().toUpperCase());
		//--==>> SEOULKOREA�츮������ѹα�
		//       seoulkorea�츮������ѹα�
		//		 SEOULKOREA�츮������ѹα�
		// sb3�� ���� �ٲ� ���� X


		//       seoulkorea�츮������ѹα�
		
		// �� ����ڿ�(sb3) �� seoul ���ڿ� �տ�
		//	  ���ѱ����̶�� ���ڿ� �߰�
		sb3.insert(0, "�ѱ�");
		System.out.println("seoul �տ� ���ѱ��� �߰� : " + sb3.toString());
		//--==>> seoul �տ� ���ѱ��� �߰� : �ѱ�seoulkorea�츮������ѹα�

		// �ѱ�seoulkorea�츮������ѹα�

		// �� ��� ���ڿ�(sb3) �� seoul ���ڿ� �ڿ� 
		//	  ��������̶�� ���ڿ� �߰�
		//	  ��, ��� ���ڿ��� �ε����� ���� Ȯ������ ����...
		
		/*
		// 1. insert() �޼ҵ� ����ϱ�
		sb3.insert (sb3.indexOf("seoul")+5, "���");
		System.out.println("seoul �ڿ� ������� �߰� : " +sb3.toString());

		
		// 2. append() �޼ҵ� ����ϱ� �� append("�߰��� ���ڿ�" , �� �ε���, �߰��� ���ڿ� ����);
		sb3.append("���", sb3.indexOf("seoul"), 2);
		System.out.println("seoul �ڿ� ������� �߰� : " +sb3.toString());
		//-- sb3.indexOf("seoul"); �� 2
		*/

		
		// step 1
		System.out.println(sb3.toString());
		//--==>> �ѱ�seoulkorea�츮������ѹα�

		// step 2
		// sb3.insert(7, "���");
		// System.out.println("seoul �ڿ� ������� �߰� : " + sb3.toString());
		//--==>> seoul �ڿ� ������� �߰� : �ѱ�seoul���korea�츮������ѹα�

		// step 3
		System.out.println(sb3.indexOf("seoul"));	
		//--==>> 2


		// step 4
		// sb3.insert(sb3.indexOf("seoul"), "���");
		// System.out.println(sb3.toString());
		//--==>> �ѱ�seoulkorea�츮������ѹα�

		// step 5
		// sb3.insert(sb3.indexOf("seoul")+5, "���");
		// System.out.println(sb3.toString());
		//--==>> �ѱ�seoul���korea�츮������ѹα�

		// step 6
		// sb.insert(sb3.indexOf("seoul")+(("seoul"�� ����), "���");
		// System.out.println(sb3.toString());
		
		// step 7
		sb3.insert(sb3.indexOf("seoul") + "seoul".length(), "���");
		System.out.println(sb3.toString());
		//--==>> �ѱ�seoul���korea�츮������ѹα�


		// �� ���츮���� ���ڿ� ����
		// sb3.delete(14, 18);
		// System.out.println(sb3.toString());
		//--==>> �ѱ�seoul���korea���ѹα�
		

		sb3.delete(sb3.indexOf("�츮����") , sb3.indexOf("�츮����")+"�츮����".length() );
		System.out.println(sb3.toString());
		//--==>> �ѱ�seoul���korea���ѹα�
		

		
		// �� ��� ���ڿ�(sb3)����
		//	  ��korea�� ���� ���ڿ� ����
		// sb3.delete(sb3.indexOf("korea") , sb3.indexOf("korea") + "korea���ѹα�".length() );
		// System.out.println(sb3.toString());
		//--==>> �ѱ�seoul���


		// sb3.delete(sb3��"korea"���ڿ�������ġ , sb3�ǹ��ڿ����� );
		sb3.delete(sb3.indexOf("korea") , sb3.length() );
		System.out.println(sb3.toString());
		//--==>> �ѱ�seoul���


		// �� ��� ���ڿ�(sb3) ����
		//	  ��seoul�� ���� ���ڿ� ���� (seoul ����)
		sb3.delete(sb3.indexOf("seoul")+"seoul".length() , sb3.length());
		System.out.println(sb3.toString());
		//--==>> �ѱ�seoul

		
		///////////////////////////////////////////////////////////////////////////////////

		// ���� ũ�� Ȯ��
		System.out.println("���� ũ�� : " + sb3.capacity());
		//--==>> ���� ũ�� : 34
		
		// ���ڿ� (sb3)�� ���� Ȯ��
		System.out.println("���ڿ��� ���� : " + sb3.length() );
		//--==>> ���ڿ��� ���� : 7

		// ���� ũ�� ���� �� ���� ���ڿ��� ��Ƶ� �� �ִ� ���� ũ���....
		sb3.trimToSize();
		
		// ���� ũ�� ���� ���� �ٽ� ���� ũ�� Ȯ��
		System.out.println("���� ũ�� : " + sb3.capacity());
		//--==>> ���� ũ�� : 7



		
	}
}
