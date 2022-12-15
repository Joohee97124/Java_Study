/*=================================
���� �÷��� (Collection ) ����
==================================*/

import java.util.Queue;
import java.util.LinkedList;

public class Test152
{

	// ���� ���ڿ� �迭 ���� �� �ʱ�ȭ
	private static final String[] colors = {"����", "���", "�ʷ�", "�Ķ�", "����", "����"};


	public static void main(String[] args)
	{
		/*
		// Queue �ڷᱸ�� ����
		Queue<String> myQue = new LinkedList<String>();


		// �ش� �ڷᱸ���� colors �� ������ �Է�
		
		// ��
		for (int i=0; i<colors.length ;i++ )
		{
			myQue.add(colors[i]);
		}
		
		
		// ��
		for (String color : colors)
		{
			myQue.add(color);
		}


		// �ش� �ڷᱸ���� ��� ������ ���
		String val;

		while (true)
		{
			val = (String)myQue.poll();

			if (val == null)
				break;
			else 
				System.out.println("colors : " + val);
		}
		*/
	
		// Queue �ڷᱸ�� ����
		Queue<String> myQue = new LinkedList<String>();
		//-- Queue �������̽� ����� �ν��Ͻ��� �����ϱ� ���ؼ���
		//   new �����ڸ� �̿��Ͽ� Q �������̽��� implements ��
		//	 ���� Ŭ������ �����ڸ� ȣ���ؾ��Ѵ�.
		Queue<String> qu = new LinkedList<String>();


		// qu��� �ش� �ڷᱸ��(Queue) �� colors�� ������ �Է� �� offers()
		for (String color : colors )
			qu.offer(color);

		// qu ��� �ش� �ڷᱸ��(Queue) �� ��� ������ ���
		while (qu.peek() != null)
			System.out.println(qu.poll() + " ");
		System.out.println();

	}
}