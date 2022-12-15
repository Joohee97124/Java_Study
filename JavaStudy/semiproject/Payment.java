import java.util.Scanner;
import java.util.Calendar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;


class Cash extends MenuUser
{

	private static int manW = 20000;			// ���� (�⺻ 2��) 
	private static int ochunW = 30000;			// ��õ�� (�⺻ 6��)
	private static int chunW = 30000;			// õ�� (�⺻ 30��)
	private static int obakW = 15000;			// ����� (�⺻ 30��)
	private static int bakW = 5000;			// ��� (�⺻ 50��)
	private int tmpTotal;				// �ֹ� ���� �ݾ� (���� ���� ��) //==MenuUser.finalTot;	
	private int	total;					// ���� ���� �� ���� ���� �ݾ�


	// ���� �ѹ��� �����ֱ� ���� �޼ҵ�
	public static void plsPlus(int man, int ochun, int chun, int obak, int bak)
	{
		manW += man;
		ochunW += ochun;		
		chunW += chun;
		obakW += obak;
		bakW += bak;
	}

	Cash() throws IOException
	{
	}

	//getter
	public int getManW(){ return manW; } 

	public int getOchunW(){ return ochunW; }

	public int getChunW(){ return chunW; }

	public int getObakW(){ return obakW; }

	public int getBakW(){ return bakW; }

	public int getTmpTotal(){ return tmpTotal; }

	public int getTotal(){ return total; }


	//setter
	public void setManW(int manW){ this.manW = manW; }

	public void setOchunW(int ochunW){ this.ochunW = ochunW; }

	public void setChunW(int chunW){ this.chunW = chunW; }

	public void setObakW(int obakW){ this.obakW = obakW; }

	public void setBakW(int bakW){ this.bakW = bakW; }

	public void setTmpTotal(int tmpTotal){ this.tmpTotal = tmpTotal; }

	public void setTotal(int total){ this.total = total; }

}


// ������ �߸� �Է����� ��� ��Ÿ�� ���� ���� ����
class choiceException extends Exception 
{ 
	String wrong;								// �߸��� �Է°� �����ϴ� ����
 
    public choiceException(String choice)		// �Է°��� �޴� ������
    {
        super("\t�߸� �����ϼ̽��ϴ�.");
        wrong = choice;							// ����ڰ� �Է��� ���� �߸��� �Է°� ������ ����
    }
 
    public void showWrongChoice()
	{
        System.out.println("\t" + wrong + "�� �ش��ϴ� ������ �������� �ʽ��ϴ�.");
    }
}
 

// ����ڿ��� �������� ���� �޴� Ŭ����
class UserPayment extends Cash
{

	UserPayment() throws IOException
	{
	}

	// ������ �����ϸ� ����ڿ��� �Է¹޴� ������ (�Է¹��� ���� ����ؼ� �����ϴ� ������)

	String name;								// MemberInfo ��ü�� �޾ƿ��� ���� �������� Login, MemberUser Ŭ������ ������ �̸�
	String answer;								// �Է¹��� ����
	String cashAnswer;							// ���ݿ����� ����
	public int cardOrCash;						// ���� ��� (ī��=1, ����=2)
	String cardOrCashStr;						// ���� ��� ���ڿ��� ��ȯ

	int userCash = 0;							// �� ���� �ݾ�
	int point;									// �α��� ȸ���� ���� �����ϰ� �ִ� ����Ʈ
	int beforeTot;								// �α��� ȸ���� ���� �� �ֹ� ���� �ݾ� (���� ���� ��)
	int change = 0;								// ����ڰ� �޾ƾ� �ϴ� �Ž�����
	String cashReceipt;							// ���ݿ����� �߱� ��ȣ

	String menuName;							// �� �޴� �̸�
	int menuTot;								// �� �޴� ������

	String subName;								// ���� �޴� �̸�
	int subCount;								// ���� �޴� ����
	int subTot;									// ���� �޴� ���� ��
		
	int msTotal;								// ���� ���� �ݾ�

	int y, m, d, h, min;						// ���� �� �ð� (������ ��� ����)

	int usePoint=0;								// ����� ����Ʈ
	static int tmpMan, tmpOchun, tmpChun, tmpObak, tmpBak;	// ���Թ��� ������ �ݾ� (���翡 �߰��� �ݾ�)
	
	// ���� �� ������ ���� �޼ҵ�
	public void discount() throws IOException
	{	

		double tmp=0;							// ���� ��� ���� �ӽú���
		point = findById(name).getPoint();

		// MenuUser Ŭ�������� �Ѿ�� �ֹ��ݾ��� MemberInfo�� �����߱� ������
		// findById(name) = ��ü�� �޼ҵ带 ���� ���� ������
		beforeTot = findById(name).getOrderTotal();	
		this.setTmpTotal(beforeTot);			
		this.setTotal(beforeTot);				// �켱 ���� �����ݾ׿��� ������ �ֹ��ݾ� ����
	
		// �� ���� ���� ���� ���� ���� Ķ���� �ν��Ͻ� ����
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		int birth = Integer.parseInt(findById(name).getBirth().substring(4,6));

		Scanner sc = new Scanner(System.in);

		// ������ �ִ� ��� ����Ǵ� ����
		// 1. ù ����(MemberŬ������ orderTotal=�� ���űݾ��� 0)�ΰ�� ù ���� ���� �ȳ�
		// 2. �ֹι�ȣ�� ���� ������ ���� ��ġ�� ��� ���� ���� �ȳ�
		//-- �ߺ� ��� �Ұ�, �ߺ� �� �������� ū ���� ������ �ȳ�
		//** try ~ catch�� y/n �߸� �Է��� ��� ����, ** �ֹι�ȣ ��
		
		try
		{
			if (birth==month)
			{
				System.out.println();
				System.out.println();
				System.out.println("\t======================================================================================");
				System.out.println();
				System.out.println("\t   " + findById(name).getName() + "��," + month + "�� ������ ���ϵ帳�ϴ�!");
				System.out.println();
				System.out.println("\t         ������������������������������������");
				System.out.println("\t         ��                ��");
				System.out.println("\t         ��  ���� ���� 30% ��");
				System.out.println("\t         ��                ��");
				System.out.println("\t         ������������������������������������");
				System.out.println();
				System.out.println("\t======================================================================================");
				System.out.print("\t���� ������ ����Ͻðڽ��ϱ�? (Y/N) : ");
				answer = sc.next();

				// �������� ���� ���� ������*0.7 ����� ���� ���� �� �ݾ׿� ���, ��� ���ϸ� ��� ���� �׳� ���
				if (answer.equals("Y") || answer.equals("y"))
				{
					tmp = this.getTmpTotal() * 0.7;
					this.setTotal((int)tmp);
					System.out.println();
					System.out.println("\t      �� ���� �ݾ��� " + this.getTotal() + "�� �Դϴ�.");
				}
				else if (!answer.equals("Y") && !answer.equals("y") && !answer.equals("N") && !answer.equals("n"))
					throw new choiceException(answer);
			}
			else if (findById(name).getEveryTotal()==0)
			{
				System.out.println();
				System.out.println("\t======================================================================================");
				System.out.println();
				System.out.println("\t        " + findById(name).getName() + "��. �ݰ����ϴ�!");
				System.out.println("\tù ������ �����ϴ� ������ ���޵Ǿ����ϴ�.");
				System.out.println();
				System.out.println("\t         ������������������������������������");
				System.out.println("\t         ��                ��");
				System.out.println("\t         ��ù ���� ���� 20%��");
				System.out.println("\t         ��                ��");
				System.out.println("\t         ������������������������������������");
				System.out.println();
				System.out.println("\t======================================================================================");
				System.out.print("\tù ���� ������ ����Ͻðڽ��ϱ�? (Y/N) : ");
				answer = sc.next();

				// �������� ���� ���� ������*0.8 ����� ���� ���� �� �ݾ׿� ���, ��� ���ϸ� ��� ���� �׳� ���
				if (answer.equals("Y") || answer.equals("y"))
				{
					tmp = this.getTmpTotal() * 0.8;
					this.setTotal((int)tmp);
					System.out.println();
					System.out.println("\t      �� ���� �ݾ��� " + this.getTotal() + "�� �Դϴ�.");
				}
				else if (!answer.equals("Y") && !answer.equals("y") && !answer.equals("N") && !answer.equals("n"))
					throw new choiceException(answer);
			}//else if�� �ݱ�


			// ����Ʈ�� 100 �̻� �ִ� ��� ��� ������ �޼ҵ�
			if (point>=100)
			{	
				int prePointUse = this.getTotal();	// ������ ���� ��, ���� ����� �ֹ� �ݾ� ���� ����
				System.out.println();
				System.out.println();
				System.out.println("\t======================================================================================");
				System.out.println();
				System.out.println("\t" + findById(name).getName() + "���� ���� ���� ����Ʈ�� " + point + "�� �Դϴ�.");
				System.out.println();
				System.out.println("\t======================================================================================");
				System.out.println();			
				System.out.print("\t   ����Ʈ�� ����Ͻðڽ��ϱ�? (Y/N) : ");
				answer = sc.next();

				if (answer.equals("Y") || answer.equals("y"))
				{
					do
					{
						System.out.print("\t����� ����Ʈ�� �Է����ּ���(100�� ����) : ");
						usePoint = sc.nextInt();

						if (usePoint%100 != 0)			  // ��� ����Ʈ�� ����� �Է����� ���� ���
						{
							System.out.println("\t  ����Ʈ ����� 100�� ������ �����մϴ�.");
							System.out.println();
						}
						else if (point >= usePoint)			 // ��������Ʈ�� �������Ʈ���� ū ��� (���)
						{
							// 1. ���� ���� or �������� ���� ���� �ݾ׿��� ��� ����Ʈ��ŭ ����
							int i = this.getTotal() - usePoint;
							this.setTotal(i);

							// 2. ���� ����Ʈ - ��� ����Ʈ ���� �� Member ������ �ݿ��ϱ�
							int p = point - usePoint;
							findById(name).setPoint(p);

							// 3. ���� ������ �̵�
							this.selectPay();
							break;
						}
						else if (point < usePoint)			// ���� ����Ʈ�� �������Ʈ���� ���� ��� 
						{
							System.out.println("\t   �����Ͻ� ����Ʈ�� �ʰ��߽��ϴ�.");
							System.out.println();
						}
					}
					while (prePointUse==this.getTotal());	// �ֹ������ݾ��� �״���� ���(����Ʈ ������� X) �ݺ�
				}
				else if (answer.equals("N") || answer.equals("n"))
					this.selectPay();						//�����޼ҵ� ȣ��
			}//if�� �ݱ�
			else if (point<100)
			{
				this.selectPay();
			}
		}//try�� �ݱ�
		catch (choiceException e)
		{
			e.showWrongChoice();
			System.out.println("\t������ ó������ �ٽ� �����մϴ�.");
			this.discount();
		}//catch �� �ݱ�
		
	} //discount() �޼ҵ� �ݱ�


    // ����Ʈ ���� �޼ҵ� (10%)
    public void pointStack10()
    {
		int point0 = findById(name).getPoint();

		// ������� 0.1 & ������ 0.1 ����
		int realTotal = getTotal();

		double temppoint = realTotal*0.1;
		int temp2 = (int)temppoint;
		
		if (temp2>0 && temp2 % 100 != 0 )
			temp2 -= (temp2%100);
		else
			temp2 = temp2;

		findById(name).setPoint(point0 + temp2);

		System.out.println("\t���� ����Ʈ: "+temp2);
    }


	// ����Ʈ ���� �޼ҵ� (5%)
	public void pointStack5() 
	{
		int point0 = findById(name).getPoint();

		// ������ 0.05 ����
		int realTotal = getTotal();

		double temppoint2 = realTotal*0.05;
		int temp3 = (int)temppoint2;

		if (temp3>0 && temp3 % 100 !=0)
			temp3 -= (temp3%100);
		else 
			temp3 = temp3;
		findById(name).setPoint(point0 + temp3);
		System.out.println("\t���� ����Ʈ: "+temp3);
	}


	// ���� �޼ҵ�: ī��, ���� �� ����
	public void selectPay() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.println();
			System.out.println();
			System.out.println("\t======================================================================================");	
			System.out.println();
			System.out.println("\t      �� ���� �ݾ��� " + this.getTotal() + "�� �Դϴ�.");
			System.out.println("\t    ���Ͻô� ���� ������ �������ּ���.");
			System.out.println();
			System.out.println("\t   1. ī��\t\t2.����");
			System.out.println();
			System.out.println("\t======================================================================================");	
			System.out.print("\t   �޴� ���� : ");
			cardOrCash = sc.nextInt();
		}
		while (cardOrCash!=1 && cardOrCash!=2);

		switch (cardOrCash)
		{
			// ���ڿ��� ��ȯ�� ��������� MemberInfo ��ü�� ������ 
			case 1 : cardOrCashStr = "ī��"; findById(name).setStrHow(cardOrCashStr); this.cardPay(); break;	// ī�� ����
			case 2 : cardOrCashStr = "����"; findById(name).setStrHow(cardOrCashStr); this.cashPay(); break;	// ���� ����
		}
	}

	// ī�� ����
	public void cardPay() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		findById(name).setPayTotal(this.getTotal());	// MemberInfo ��ü�� ���� �� ���� ���� �ݾ� ����

		System.out.println();
		System.out.println();
		System.out.println("\t======================================================================================");	
		System.out.println();
		System.out.println("\t     �ϴܿ� ī�带 �Ⱦ��ּ���.");
		System.out.println();
		System.out.println("\t======================================================================================");
		System.out.println("\t   " + this.getTotal() +"�� ������ �Ϸ�Ǿ����ϴ�.");
		System.out.print("\t   �������� ����Ͻðڽ��ϱ�? (Y/N) : ");
		answer = sc.nextLine();

		if (answer.equals("Y") || answer.equals("y"))
			this.printReceipt();			// ������ ��� �޼ҵ� ȣ��
		else
		{
			System.out.println();
			System.out.println();
			System.out.println("\t======================================================================================");	
			System.out.println();
			System.out.println("\t     �ֹ��Ͻ� �޴��� ���Խ��ϴ�.");
			System.out.println("\t      �̿����ּż� �����մϴ�.");
			System.out.println();
			System.out.println("\t======================================================================================");	

		}
	}//cardPay ��


	// ���� ����: ���� ����, ���� �Է� > ���ݿ����� ����(�޴�����ȣ �Է�)
	public void cashPay() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		findById(name).setPayTotal(this.getTotal());				// MemberInfo ��ü�� ���� �� ���� ���� �ݾ� ����

		int[] cashList = {10000, 5000, 1000, 500, 100};
		int[] count = new int[5];									// �Է¹޴� ������ ����
		int ochun=0, chun=0, obak=0, bak=0;							// �Ž����� ���� �ʿ��� ����

		// ���� ����, ���� �Է�
		System.out.println();
		System.out.println();
		System.out.println("\t======================================================================================");	
		System.out.println();
		System.out.println("\t       ������ �������ּ���.");

		// ���� �������� ���� �迭 ����ϸ� �ش� �ݾױ��� ���� �Է¹ޱ� �� �� ���Աݾ� ���
		for (int i=0; i<cashList.length; i++)
		{
			System.out.printf("\t%5d��: ", cashList[i]);
			count[i] = sc.nextInt();
			userCash += cashList[i]*count[i];
		}

		System.out.println();
		System.out.println("\t======================================================================================");
		System.out.println();
		System.out.println();

		// 1. userCash > total : �Ž����� ��� �� ��ȯ
		// 2. userCash < total : �ٽ� �Է¹ޱ�(�ʱ�ȭ)
		// 3. userCash = total : �Ž����� 0(default)
		System.out.println("\t      �� " + userCash + "���� ���ԵǾ����ϴ�.");
		System.out.println();

		if (userCash >= getTotal())
		{
			change = userCash - getTotal();
			// �Ž����� ��� (������ ���� ���� �� �� ������ ������, �������� �ٸ� ������ ������ �� ���� ������ ��)
			ochun = change/5000;					//-�Ž������ �� ��õ���� ����
			chun = change%5000/1000;				//-�Ž������ �� õ���� ����
			obak = change%5000%1000/500;			//-�Ž������ �� ������� ����
			bak = change%5000%1000%500/100;			//-�Ž������ �� ����� ����

			// �Է¹��� ������ �ݾ��� ���ϰ�, �Ž������� ���� ���� ���翡 �߰��ϱ�
			tmpMan = count[0] * cashList[0];
			tmpOchun = (count[1] - ochun) * cashList[1];
			tmpChun = (count[2] - chun) * cashList[2];
			tmpObak = (count[3] - obak) * cashList[3];
			tmpBak = (count[4] - bak) * cashList[4];
			
			// ���� �ݾ�-������ �ݾ�(�Ž�����) ����ؼ� Cash Ŭ���� ���� ����
			plsPlus(tmpMan, tmpOchun, tmpChun, tmpObak, tmpBak);

			System.out.println("\t         ������ �Ϸ�Ǿ����ϴ�.");
			System.out.println();
			System.out.println("\t��ȯ������ �Ž����� " + change + "���� Ȯ�����ּ���.");
			System.out.println();
			System.out.println("\t======================================================================================");	
		}
		else if (userCash < getTotal())
		{
			System.out.println("\t   �� ���� �ݾ��� " + getTotal() + "�� �Դϴ�.");
			System.out.println("\t     ���� �ݾ��� �����մϴ�.");
			System.out.println("\t��ȯ�Ǵ� ������ Ȯ���Ͻð�, �ٽ� �������ּ���.");
			System.out.println();
			userCash = 0;					// �Է� ���� �ݾ� �ʱ�ȭ
			cashPay();

			return;
		}

		// ���ݿ����� ���� (�޴��� ��ȣ �Է� or ������ ���)
		System.out.println();
		System.out.print("\t���� �������� �߱��Ͻðڽ��ϱ�? (Y/N) : ");
		cashAnswer = sc.next();
		

		if (cashAnswer.equals("Y") || cashAnswer.equals("y"))
		{
			System.out.print("\t  ���� ������ ��ȣ�� �Է����ּ���. : ");
			cashReceipt = sc.next();
		}
		
		// ������ ��� ����
		System.out.println();
		System.out.print("\t�������� ����Ͻðڽ��ϱ�? (Y/N) : ");
		answer = sc.next();

		if (answer.equals("Y") || answer.equals("y"))
			printReceipt();			// ������ ��� �޼ҵ� ȣ��
		else
		{
			System.out.println();
			System.out.println();
			System.out.println("\t======================================================================================");	
			System.out.println();
			System.out.println("\t     �ֹ��Ͻ� �޴��� ���Խ��ϴ�.");
			System.out.println("\t       �̿����ּż� �����մϴ�.");
			System.out.println();
			System.out.println("\t======================================================================================");	
			findById(name).setEveryTotal(this.getTotal());			// ȸ�� ������ ���� �ݾ� �����ϱ�

		}	

	}//cashPay ��


	// ������ ���
	public void printReceipt() throws IOException
	{
		// pointStack10();					// ����Ʈ ����

		Calendar now = Calendar.getInstance();

		y = now.get(Calendar.YEAR);
		m = now.get(Calendar.MONTH)+1;
		d = now.get(Calendar.DATE);
		h = now.get(Calendar.HOUR_OF_DAY);
		min = now.get(Calendar.MINUTE);
		
		// ����(������ ��� ����)�� ��¥, �ð��� MemberInfo�� fix��
		findById(name).setY(y);
		findById(name).setM(m);
		findById(name).setD(d);

		menuName = findById(name).getMainMenu();			// �� �޴� �̸�
		int menuCount = 1;									// �� �޴� �ֹ� ����
		menuTot = findById(name).getMainTotal();			// �� �޴� ������

		subName = findById(name).getSubMenu();				// ���� �޴� �̸�
		subCount = findById(name).getSubMenuCount();		// ���� �޴� ����
		subTot = findById(name).getSubTotal();				// ���� �޴� ���� ��
		
		msTotal = findById(name).getPayTotal();				// �� ���� ���� �� (����+����޴�)

		String commTotal = String.format("%,d", menuTot);	//',' ���� �� �޴� �ݾ�
		String commsubTot = String.format("%,d", subTot);	//',' ���� ���� �޴� �ݾ�
		String commMsTot = String.format("%,d", msTotal);	//',' ���� �� �ݾ�
		String commCash = String.format("%,d", userCash);	//',' ���� ����ڿ��� �Է¹��� ���� �ݾ�
		String commChange = String.format("%,d", change);	//',' ���� �Ž�����

		System.out.println();
		System.out.println();
		System.out.println("\t======================================================================================");	
		System.out.println();
		System.out.println("\t          <  ��  ��  ��  >");
		System.out.println();
		System.out.println("\t           Custom Cocktail ");

		System.out.println("\t����ڹ�ȣ: 411-82-05920");
		System.out.println("\t��      ��: ����� ������ �����źϷ� 21");
		System.out.println("\t��ȭ  ��ȣ: 010-8102-0384");
		System.out.printf("\t��      ��: %4d-%d-%d  %2d:%2d\n", y, m, d, h, min);
		System.out.println("\t======================================================================================");	
		System.out.println("\t ǰ��\t\t����\t\t�ݾ�");
		System.out.printf("\t %-6s\t %d\t\t%5s\n", menuName, menuCount, commTotal);
		if (subCount!=0)
				System.out.printf("\t %-6s\t %d\t\t%5s\n", subName, subCount, commsubTot);
		System.out.println("\t======================================================================================");	
		System.out.printf("\t ��         �� : \t\t%5s\n", commMsTot);

		if (cardOrCash==1)
		{
			System.out.printf("\t ī         �� : \t\t%5s\n", commMsTot);
			System.out.printf("\t ���� ����Ʈ : \t\t%5d\n", usePoint);
		}
		else if (cardOrCash==2)
		{
			System.out.printf("\t ����     ���� : \t\t%5s\n", commCash);
			System.out.printf("\t ���� ����Ʈ : \t\t%5d\n", usePoint);
			System.out.printf("\t ��  ��  �� �� : \t\t%5s\n", commChange);
			System.out.println();
			if (cashAnswer.equals("Y") || cashAnswer.equals("y"))
				System.out.printf("\t �� ��  ������ :        \t%s\n", cashReceipt);
		}

		System.out.println("\t======================================================================================");	
		System.out.println("\t      ***** ���� �Ϸ� �Ǽ��� *****");
		System.out.println();
		System.out.println();
		System.out.println("\t======================================================================================");	
		System.out.println();
		System.out.println("\t      �ֹ��Ͻ� �޴��� ���Խ��ϴ�.");
		System.out.println("\t       �̿����ּż� �����մϴ�.");
		System.out.println();
		System.out.println("\t======================================================================================");	
		findById(name).setEveryTotal(this.getTotal());			// ȸ�� ������ ���� �ݾ� �����ϱ�
		userCash = 0;											// ����ڰ� �� �� 0���� �ʱ�ȭ

	}//printReceipt ��



//--------------------------------------------------- ����

	int sel;								// ���� Ȯ�� ����
	private int user;						// �����
	private int com;						// ��ǻ��

	private static int sellcount;			// Ĭ���� �� Ƚ��



	public int getsellcount()
	{
		return sellcount;
	}	

	public static void setsellcount(int sellcount)
	{	
		UserPayment.sellcount = sellcount;
	}
	

	public void rsp() throws InterruptedException
	{	
		MachineRoom mr = new MachineRoom();
		Imagefile jpg = new Imagefile();
		
	
			Scanner sc = new Scanner(System.in);
			Random rd = new Random();

			System.out.println();
			System.out.println();
		    System.out.println("\t======================================================================================");	
			System.out.println();
			System.out.println("\t������ ������ ���� �̴� ����(������)�� �Ͻðڽ��ϱ�?\n");
			System.out.println("\t1. �̱� Ȯ�� 80% (������ 5%) \t 2. �̱� Ȯ�� 66.6% (������ 10%) \t 3. �� �ҷ���.");

			do
			{
				System.out.println();
				System.out.print("\n\t ����� ������?! : ");
				sel = sc.nextInt();
			}
			while (sel < 1 || sel > 3);

		
			if (sel==1)
			{
				com = rd.nextInt(4)+1; // �� 1 2 3 4 5
				System.out.println();
				System.out.println("\n\tȮ�� 80 % ������ �����ϼ̽��ϴ�.");
				game1();
			}
			
			else if(sel==2)
			{
				com = rd.nextInt(2)+1; // �� 1 2 3
				System.out.println();
				System.out.println("\n\tȮ�� 66.6 % ������ �����ϼ̽��ϴ�.");

				game2();
			}
			
			else if(sel==3)
			{
				System.out.println();
				System.out.println("\n\t�̿� �� �ּż� �����մϴ�.");
				System.out.println();
				// ó�� ȭ������ ���ư��� Ŭ���� �޼ҵ� ȣ��.
			}
			
			sellcount +=1;															// Ĭ���� �� Ƚ��
	}
	
	public void game1()
	{	
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.println();
			System.out.print("\t1. �� 2. �Ʒ� 3. �߾� 4. ���� 5. ������ : ");
			user = sc.nextInt();
		}
		while (user < 1 || user > 5);

		try
		{
			Thread.sleep(3000);			
		}
		catch (InterruptedException e)
		{
			System.out.println();
		}

		try
		{	
			System.out.print("\t");
			Thread.sleep(3);			
		}
		catch (InterruptedException e)
		{
			System.out.println();
		}
		
		String[] str = {"��", "�Ʒ�", "�߾�", "����", "������"};

		System.out.println("\n\t - ����	  : " + str[user-1]);
		System.out.println("  \t - ��ǻ�� : " + str[com-1]);
		
		if (user==com)
			System.out.println("\n\t�й� �ϼ̽��ϴ� :( ���� ��ȸ��...");
		else
		{
			System.out.println("\n\t�¸� �ϼ̽��ϴ�!! :-D");

			// ����Ʈ ���� (5%)
			pointStack5();		
		}

	}


	void game2()
	{	
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.println();
			System.out.print("\t1. ���� 2. �߾� 3. ������ : ");
			user = sc.nextInt();
		}
		while (user < 1 || user > 3);
		
		try
		{
			Thread.sleep(3000);			
		}
		catch (InterruptedException e)
		{
			System.out.println();
		}

		String[] str = {"����", "�߾�", "������"};

		System.out.println("\n\t - ����	  : " + str[user-1]);
		System.out.println("  \t - ��ǻ�� : " + str[com-1]);
		
		if (user==com)
			System.out.println("\n\t�й� �ϼ̽��ϴ� :( ���� ��ȸ��...");
		else
		{
			System.out.println("\n\t�¸� �ϼ̽��ϴ�!! :-D");
			// ����Ʈ ���� (10%)
			pointStack10();

		}
	}
}



public class Payment
{
	public static void main(String[] args) throws IOException
	{


	}
}