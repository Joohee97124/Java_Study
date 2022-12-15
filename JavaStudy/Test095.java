/* ====================================
���� Ŭ������ �ν��Ͻ� ����
- Ŭ������ �ν��Ͻ� Ȱ��
======================================*/

// �� �ǽ� ����
// 1 ~ 3 ������ ���� ������ ������ �߻�����
// ����, ����, �� ���� ���α׷��� �����Ѵ�.
// ��, Ŭ������ ������ Ȱ���Ͽ� ó���� �� �ֵ��� �Ѵ�.
// ����, �迭�� Ȱ���Ͽ� ó���� �� �ֵ��� �Ѵ�,

// ���� ������ �� 1:����, 2:����, 3:��

// ���� ��)
// 1:����, 2:����, 3:�� �� �Է�(1~3) : 4
// 1:����, 2:����, 3:�� �� �Է�(1~3) : -10
// 1:����, 2:����, 3:�� �� �Է�(1~3) : 2
// - ���� : ����
// - ��ǻ�� : ��
// >> �º�������� : ��ǻ�Ͱ� �̰���ϴ�~!!!
// ����Ϸ��� �ƹ� Ű��...

import java.util.Scanner;
import java.util.Random;

/*
class Data
{
	int num;
	String gap;
}

class RpsGame
{
	int user;
	int com;

	int n;				//-- �Է� ��
	Data [] arrGame;	//-- �迭 ����
	int i;				//-- ���� ����
	int nan;			//-- ���� �� 
	String winner;		//-- �̱� ���
	String [] ops = {"����","����","��"};


	public void input()
	{
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.print("1:����, 2:����, 3:�� �� �Է�(1~3) :");
			n = sc.nextInt();

		}
		while (n<1 || n>3);

		arrGame = new Data [3];
	}

	public void cal()
	{
		// arrGame[] �迭�� ���������� �ֱ�
		for (int i=0;i<3 ; i++)
		{
			arrGame [i] = new Data();
			
			arrGame[i].num = (i+1);
			arrGame[i].gap = ops[i];

		}

		
		// ��ǻ�Ϳ��� ���� �߻� ��Ű��
		Random rd = new Random();
		do
		{
			nan = rd.nextInt(3)+1;
		}
		while (nan==0);
		// nan = rd.nextInt(3)+1;


		// ������ - ���Ϳ� - �ֱ�
		user = n;
		com = nan;

	}

	public void print()
	{
		System.out.println("���� : "+ arrGame[n-1].gap);
		System.out.println("��ǻ�� : "+arrGame[nan-1].gap);

		if (nan>n)
		{
			if (nan==3&&n==1)
			{
				System.out.print(">> �º� ���� ��� : ������ �̰���ϴ�~\n");
			}
			System.out.print(">> �º� ���� ��� : ��ǻ�Ͱ� �̰���ϴ�~\n");
		}
		else if (n>nan)
		{
			if (nan==1&&n==3)
			{
				System.out.print(">> �º� ���� ��� : ��ǻ�Ͱ� �̰���ϴ�~\n");
			}
			System.out.print(">> �º� ���� ��� : ������ �̰���ϴ�~\n"); 
		}
		else
			System.out.print(">> �º� ���� ��� : �����ϴ�~\n"); 
	}



}
*/

import java.util.Random;
import java.util.Scanner;

class RpsGame
{
	int user;
	int com;


	private void runCom()		 //-- ��ǻ�Ͱ� ���� �����ϴ� �޼ҵ�
	{
		Random rd = new Random();
		com = rd.nextInt(3) + 1;		// 0 1 2 �� 0 1 2 3
	}


	public void input()			//-- ���� �Է¹޴� �޼ҵ�
	{
		runCom();				 //-- ���� �������� �޼ҵ� ȣ�� 

		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.print(" 1:����, 2:����, 3:�� �� �Է�(1~3) :");
			user = sc.nextInt();
		}
		while (user<1 || user>3);
	}


	public void middleCalc()	//-- ��ȣ�� ������ �迭 ���� �޼ҵ� (�������� ���´���)
	{
		String [] str = {"����","����","��"};

		System.out.println("- ���� : " + str[user-1]);
		System.out.println("- ��ǻ�� : " + str[com-1]);
	}


	public String resultCalc()	//-- �ºο� ���� ��� Ȯ�� �޼ҵ�
	{
		String result = "���º�";

		if ((user==1&&com==3) || (user==2&&com==1) || (user==3&&com==2))
			result = "����� �¸��߽��ϴ�~!";


		if ((user==1&&com==2) || (user==2&&com==3) || (user==3&&com==1))
			result = "��ǻ�Ͱ� �¸��߽��ϴ�~!";
		// �������� if�ΰ��� ������ if�� -> else if������ ���ߵ� ���� �� �������� �������� Ʋ�� ��


		return result;
	}


	public void print(String result)	//-- ��� �޼ҵ�
	{
		System.out.println(">> �º� ������� : " + result);
	}


}

public class Test095
{
	public static void main(String[] args)
	{
		// ���� �� Ǯ��
		/*
		RpsGame ob = new RpsGame();
		ob.input();
		ob.cal();
		ob.print();
		*/

		// �԰� �� Ǯ��
		RpsGame ob = new RpsGame();
		ob.input();
		ob.middleCalc();
		String result = ob.resultCalc();
		ob.print(result);

	}
}
/*
[������]
 1:����, 2:����, 3:�� �� �Է�(1~3) :2
- ���� : ����
- ��ǻ�� : ����
>> �º� ������� : ���º�
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

1:����, 2:����, 3:�� �� �Է�(1~3) :1
- ���� : ����
- ��ǻ�� : ��
>> �º� ������� : ����� �¸��߽��ϴ�~!
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

 1:����, 2:����, 3:�� �� �Է�(1~3) :3
- ���� : ��
- ��ǻ�� : ����
>> �º� ������� : ��ǻ�Ͱ� �¸��߽��ϴ�~!
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/