/*=================================
���� �÷��� (Collection ) ����
==================================*/

// Set �� HashSet, TreeSet
// - ���� (�ǹ�) ����
// - �ߺ��� ������� �ʴ� ���� (�⺻)

/*
�� HashSet<E> Ŭ����

   - java.util.HashSet<E> Ŭ������
     Set �������̽��� �����ϴ� Ŭ������
	 ������ ������ �ƴ϶� ������ �������� �����ؾ� �ϴ� �ڷᱸ���̴�.
   - �̷� ���� �������� �ߺ��� ������� �ʴ´�
   - ����, ����ȭ�� �������� �ʴ´�.


*/

import java.util.Set;
import java.util.HashSet;

public class Test162
{
	public static void main(String[] args)
	{
		// Set<String> dogs = new Set<String>(); �������̽��� �ȴ�~~
		Set<String> dogs = new HashSet<String>(); //-- Set implement�ϰ��ִ� Ŭ������ ��ü ���� (��ĳ����)
		
		// dogs ��� HashSet �ڷᱸ���� ��� �߰�
		dogs.add("Ǫ��");
		dogs.add("�ùٰ�");
		dogs.add("��Ʈ����");
		dogs.add("ġ�Ϳ�");

		System.out.print("���� ������ Set : " );
		for (String str : dogs)
			System.out.print(str + " ");
		System.out.println();
		//--==>> ���� ������ set : ���� ������ Set : ��Ʈ���� Ǫ�� �ùٰ� ġ�Ϳ�
		//-- ������ �ǹ� ���� �ڷᱸ���̱� ������
		//	 ������ �Է� ����(�ڷᱸ���� ��� �ݳ� ����)��
		//	 ������� �����Ǿ� �ִ� ���� Ȯ��

		// ������(���) �߰�
		dogs.add("��Ƽ��");
		dogs.add("�˰�");
		dogs.add("�˰�");			// �� �ߺ� �����͸� �߰��Ѵٰ� �ؼ�
		dogs.add("�˰�");			//    ������ ���� �������� 
		dogs.add("�˰�");			//    ������ �߻��ϴ� ���� �ƴϴ�! 
		dogs.add("�˰�");
		dogs.add("��Ƽ��");
		dogs.add("��Ƽ��");
		dogs.add("��Ƽ��");
		dogs.add("��Ʈ����");
		dogs.add("��Ʈ����");
		dogs.add("��Ʈ����");
		dogs.add("��Ʈ����");
		dogs.add("������");
		dogs.add("ǳ�갳");
		dogs.add("ǳ�갳");
		dogs.add("ǳ�갳");

		System.out.print("�߰� �� ������ Set : " );
		for (String str : dogs)
			System.out.print(str + " ");
		System.out.println();
		//--==> �߰� �� ������ Set : ��Ʈ���� �˰� ������ Ǫ�� �ùٰ� ġ�Ϳ�  ��Ƽ�� ǳ�갳
		
		// �� ������ �߰��Ǵ� ������ ������� ����� �����Ǿ� ������
		//	  ���� ������ ���� �� �ݺ��Ǿ� �߰��� ��� (�ߺ� ������)
		//	  �ϳ��� ��ȿ�� �����ͷ� �����Ǿ� �ִ� ���� Ȯ�� �� �� �ִ�.
		//	  (�ƹ��� �߰��ص� �� ���� ��µ�)
	}
}