/*=================================
���� �÷��� (Collection ) ����
==================================*/

// Set �� HashSet, TreeSet
// - ���� (�ǹ�) ����
// - �ߺ��� ������� �ʴ� ���� (�⺻)

/*
�� TreeSet<E> Ŭ����

	- java.util.TreeSet<E> Ŭ������
	  Set �������̽��� ����� SortedSet �������̽��� ������ Ŭ������
	  �����͸� �߰��ϸ� �����͵��� �ڵ����� �������� ���ĵȴ�.
*/
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Comparator;


// VO   �� Value Object 
// DTO  �� Data Transfer Object 
// DAO  �� Data Access Object

class GradeVO
{
	// �ֿ� �Ӽ� ����
	String hak;
	String name;
	int kor, eng, mat;
	// TreeSet<String> set = new TreeSet<String>();


	// getter / setter ����
	public String getHak()
	{
		return hak;
	}
	
	public void setHak(String hak)
	{
		this.hak = hak;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getKor()
	{
		return kor;
	}
	
	public void setKor(int kor)
	{
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public int getEng()
	{
		return eng;
	}
	
	public void setEng(int eng)
	{
		this.eng = eng;
	}

	public int getMat()
	{
		return mat;
	}
	
	public void setMat(int mat)
	{
		this.mat = mat;
	}


	// ������ (����� ���� ������ �� 5���� �Ű������� ���� ������)
	GradeVO(String hak, String name, int kor, int eng, int mat)
	{
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	// ������ (����� ���� ������ �� 5���� �Ű����� ���� �⺻ ������)
	GradeVO()
	{
	}

	// �߰� �޼ҵ� ���� �� ���� ����
	int getTotal()
	{
		return kor + eng + mat;
	}

}


class MyComparator<T> implements Comparator<T>
{
	@Override
	public int compare(T o1, T o2)
	{
		GradeVO s1 = (GradeVO)o1;
		GradeVO s2 = (GradeVO)o2;

		// �й� ���� ��������
		// return Integer.parseInt(s1.getHak()) - Integer.parseInt(s2.getHak());
		
		// ���� ���� ��������
		// return s1.getTotal() - s2.getTotal();		
		
		// ���� ���� ��������
		// return s2.getTotal() - s1.getTotal();
		
		// �̸� ����
		// return s1.getName() - s2.getName();
		//--==>> ���� �߻� (������ ����)
		// return Integer.parasInt(s1.getName()) - Integer.parseInt(s2.getName());
		//--==>> ���� �߻� (������ ����)
		return s1.getName().compareTo(s2.getName());
	}	
}

public class Test163 
{

	public static void main(String[] args) throws ClassCastException
	{
		// TreeSet �ڷᱸ�� �ν��Ͻ� ����
		TreeSet<String> set = new TreeSet<String>();

		// set �̶�� TreeSet �ڷᱸ���� ��� �߰� �� add()
		set.add("¯���¸�����");
		set.add("�Ʊ����Ѹ�");
		set.add("�Ƶ�����");
		set.add("���������緹��");
		set.add("��Ž���ڳ�");
		set.add("�ɽ�");
		set.add("���ϸ���");
		set.add("����ö��999");
		set.add("�̷��ҳ��ڳ�");

		// Iterator �� Ȱ���Ͽ� set ��� ��ü ���
		Iterator<String> it = set.iterator();
		while (it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		//--==>> ���������緹�� ��Ž���ڳ� �̷��ҳ��ڳ� �ɽ� �Ʊ����Ѹ� �Ƶ� ���� ����ö��999 ¯���¸����� ���ϸ���
		//-- Set data �ȿ� �̷��� �������� ���ĵǾ��ִ�.
		
/*		
		// TreeSet �ڷᱸ�� �ν��Ͻ� ����
		TreeSet<GradeVO> ts = new TreeSet<GradeVO>();

		// ������ �ڷᱸ���� ��� �߰�
		//-- 2103 �谡�� 90 80 70
		//	 2104 �弭�� 80 70 60
		//   2105 �ڳ��� 100 100 100
		//   2106 �̻��� 12 23 34
		//   2107 �輭�� 50 50 50
		GradeVO g1 = new GradeVO("2103","�谡��",90,80,70);
		GradeVO g2 = new GradeVO("2104","�弭��",80,70,60);
		GradeVO g3 = new GradeVO("2105","�ڳ���",100,100,100);
		GradeVO g4 = new GradeVO("2016","�̻���",12,23,34);
		GradeVO g5 = new GradeVO("2107","�輭��",50,50,50);

		ts.add(g1);
		ts.add(g2);
		ts.add(g3);
		ts.add(g4);
		ts.add(g5);
		


		// ��� �߰��� �ڷᱸ�� ��ü ���
		for (GradeVO data : ts)
		{
			System.out.print(data.getHak() + " " + data.getName()  + " " + data.getKor() + " " + data.getEng() + " " + data.getMat());
			System.out.println();
		}
*/

			


		// �Բ� �� Ǯ��
		// TreeSet �ڷᱸ�� �ν��Ͻ� ����
		// TreeSet<GradeVO> set2 = new TreeSet<GradeVO>();

		TreeSet<GradeVO> set2 = new TreeSet<GradeVO>(new MyComparator<GradeVO>());

		// ������ �ڷᱸ���� ��� �߰�
		// GradeVO vo1 = new GradeVO("2013","�谡��",90,80,70);
		// set2.add(vo1);

		set2.add(new GradeVO("2103","�谡��",90,80,70));
		set2.add(new GradeVO("2104","�弭��",80,70,60));
		set2.add(new GradeVO("2105","�ڳ���",100,100,100));
		set2.add(new GradeVO("2106","�̻���",12,23,34));
		set2.add(new GradeVO("2107","�輭��",50,50,50));


		// ��� �߰��� �ڷᱸ�� ��ü ���
		Iterator<GradeVO> it2 = set2.iterator();
		
		while (it2.hasNext())
		{
			GradeVO vo = it2.next();
			System.out.printf("%7s %7s %4d %4d %4d %6d\n"
				,vo.getHak(), vo.getName()
				,vo.getKor(), vo.getEng(), vo.getMat()
				,vo.getTotal());
		}
		System.out.println();

	}
}

/*
[���� ���]
// �й� ����
   2013     �谡��   90   80   70    240
   2016     �̻���   12   23   34     69
   2104     �弭��   80   70   60    210
   2105     �ڳ���  100  100  100    300
   2107     �輭��   50   50   50    150

// ���� ����
   2016     �̻���   12   23   34     69
   2107     �輭��   50   50   50    150
   2104     �弭��   80   70   60    210
   2013     �谡��   90   80   70    240
   2105     �ڳ���  100  100  100    300


// ���� ���� �������� 
   2105     �ڳ���  100  100  100    300
   2103     �谡��   90   80   70    240
   2104     �弭��   80   70   60    210
   2107     �輭��   50   50   50    150
   2106     �̻���   12   23   34     69

// �̸� ����
   2103     �谡��   90   80   70    240
   2107     �輭��   50   50   50    150
   2105     �ڳ���  100  100  100    300
   2106     �̻���   12   23   34     69
   2104     �弭��   80   70   60    210
*/