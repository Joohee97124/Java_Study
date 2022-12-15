/*=================================
���� �÷��� (Collection ) ����
==================================*/

// ���� �ڷᱸ�� ��ü ���� �� ���� �� ����� ���� �ڷ��� Ŭ���� Ȱ��
// �� �ڷ������� Ȱ��~!!!

import java.util.Vector;

// ����� ���� Ŭ���� ���� �� �ڷ���ó�� Ȱ��
class MyData
{
	// �ֿ� �Ӽ� ���� �� �ֿ� ���� ����(��� ����)
	private String name;		//-- �̸�
	private int age;			//-- ����
	
	// getter / setter ����
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}


	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	// ������ (���� ���� ������)
	public MyData()
	{
		name = "";
		age =0;
	}

	// ������ (���� 2���� ������)
	public MyData(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

}

public class Test157
{
	public static void main(String[] args)
	{
		// ���� �ڷᱸ�� �ν��Ͻ� ����
		Vector<MyData> v = new Vector<MyData>();
		//-- MyData ������� ������ �ν��Ͻ���
		//	 Vector �ڷᱸ�� v�� �����ϴ� ���� ����

		// ���� �ڷᱸ�� v ��
		// ������ 16�� / �Ҽ��� 14�� / ������ 86��
		// ��Ƴ���

		// ��
/*
		MyData ob1 = new MyData();
		ob1.setName("������");
		ob1.setAge(16);
		v.add(ob1);

		MyData ob2 = new MyData();
		ob2.setName("�Ҽ���");
		ob2.setAge(14);
		v.add(ob2);

		MyData ob3 = new MyData();
		ob3.setName("������");
		ob3.setAge(86);
		v.add(ob3);
		*/


		// ��
		/*
		MyData st1 = new MyData("������", 16);
		v.add(st1);

		MyData st2 = new MyData("�Ҽ���", 14);
		v.add(st2);

		MyData st3 = new MyData("������", 86);
		v.add(st3);
		*/

		//��
		v.add(new MyData("������",16));
		v.add(new MyData("�Ҽ���",14));
		v.add(new MyData("������",86));

		

		// ���� �ڷᱸ�� v �� ��� ���� (���) ��ü ����ϱ�
		// ���� ��)
		// �̸� : ������ , ���� : 16
		// �̸� : �Ҽ��� , ���� : 14
		// �̸� : ������ , ���� : 86
		
		/*
		// ���� Ǭ Ǯ��
		for (MyData str : v )
		{
			System.out.print("�̸�:" + str.getName() +"  " + "���� : " + str.getAge() );
			System.out.println();
		}
		System.out.println();
		*/
		
		// ��
		/*
		for (MyData obj : v)
			System.out.printf("�̸� : %s, ���� : %d\n", obj.getName(), obj.getAge());
		*/

		// �� 
		
		for (int i=0; i<v.size() ;i++ )
		{
			System.out.printf("�̸� : %s, ���� : %d\n", v.elementAt(i).getName(), v.elemntAt(i).getAge());
		}
		System.out.println();
	


		// ��
		/*
		for (Object temp : v)
		{
			System.out.printf("�̸� : %s, ���� : %d\n",
				((MyData)temp).getName(), ((MyData)temp).getAge());
		}
		*/






	}
}