import java.util.Scanner;
import java.util.Calendar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;


class Cash
{
	//MenuUser mu = new MenuUser();

	private int manW = 20000;			// ���� (�⺻ 2��) 
	private int ochunW = 30000;			// ��õ�� (�⺻ 6��)
	private int chunW = 30000;			// õ�� (�⺻ 30��)
	private int obakW = 15000;			// ����� (�⺻ 30��)
	private int bakW = 5000;			// ��� (�⺻ 50��)
	private int tmpTotal=14000;			// �ֹ� ���� �ݾ� (���� ���� ��) -�׽�Ʈ�Է�.. //MenuUser.finalTot;	
	private int	total;					// ���� ���� �� ���� ���� �ݾ�
	private int card;					// ī������ݾ�
	private int sumCash;				// ī�� ����� �հ�
	private int sumCard;				// ���� ����� �հ�


	public Cash(int manW, int ochunW, int chunW, int obakW, int bakW) 
	{
		this.manW += manW;
		this.ochunW += ochunW;		
		this.chunW += chunW;
		this.obakW += obakW;
		this.bakW += bakW;
	}

	Cash() 
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

	public int getCard(){ return card; }

	public int getSumCash(){ return sumCash; }

	public int getSumCard(){ return sumCard; }

	//setter
	public void setManW(int manW){ this.manW = manW; }

	public void setOchunW(int ochunW){ this.ochunW = ochunW; }

	public void setChunW(int chunW){ this.chunW = chunW; }

	public void setObakW(int obakW){ this.obakW = obakW; }

	public void setBakW(int bakW){ this.bakW = bakW; }

	public void setTmpTotal(int tmpTotal){ this.tmpTotal = tmpTotal; }

	public void setTotal(int total){ this.total = total; }

	public void setCard(int card){ this.card = card; }

	public void setSumCash(int sumCash){ this.sumCash = sumCash; }

	public void setSumCard(int sumCard){ this.sumCard = sumCard; }

}

//----------------------------------�׽�Ʈ�� ��� Ŭ����
class Members
{
	int orderTotal = 0;
	String name = "������";
	String birth = "19950316";
	int point = 100;
	
	int total = 10000;		//�׽�Ʈ�� �ֹ� ���� �ݾ�
	// total = �޴�����*�޴����� (+�߰��޴�)

	public int getOrderTotal()
	{
		return orderTotal;
	}

	public String getName()
	{
		return name;
	}

	public String getBirth()
	{
		return birth;
	}

	public int getPoint()
	{
		return point;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

	public void setPoint(int point)
	{
		this.point = point;
	}

}
//-----------------------------------�׽�Ʈ�� ��� Ŭ����

// ������ �߸� �Է����� ��� ��Ÿ�� ���� ���� ����
class choiceException extends Exception 
{ 
	String wrong;							// �߸��� �Է°� �����ϴ� ����
 
    public choiceException(String choice)		// �Է°��� �޴� ������
    {
        super("\t�߸� �����ϼ̽��ϴ�.");
        wrong = choice;							// ����ڰ� �Է��� ���� �߸��� �Է°� ������ ����
    }
 
    public void showWrongChoice() {
        System.out.println("\t" + wrong + "�� �ش��ϴ� ������ �������� �ʽ��ϴ�.");
    }
}
 

// ����ڿ��� �������� ���� �޴� Ŭ����
class UserPayment extends Cash
{

	UserPayment()
	{
	}

	//MemberInfo mem = new MemberInfo();		// MemberInfo Ŭ���� �ν��Ͻ� ����
	Members mem = new Members();

	String answer;							// �Է¹��� ����
	int cardOrCash;							// ���� ��� (ī��=1, ����=2)

	int userCash = 0;						// �� ���� �ݾ�
	int total;								// ����, ������ ������ ��� ���� ���� ���� �ݾ�
	int change = 0;							// ����ڰ� �޾ƾ� �ϴ� �Ž�����
	String cashReceipt;						// ���ݿ����� �߱� ��ȣ


	//String commTotal = String.format("%,d", this.getTotal());		//',' ���� ���� �ݾ�
	//String commCash = String.format("%,d", userCash);				//',' ���� ����ڿ��� �Է¹��� ���� �ݾ�
	//String commChange = String.format("%,d", change);				//',' ���� �Ž�����

	
	// ���� �� ������ ���� �޼ҵ�
	public void discount()
	{	

		double tmp;								// ���� ��� ���� �ӽú���
		int usePoint;							// ����� ����Ʈ

		// �� ���� ���� ���� ���� ���� Ķ���� �ν��Ͻ� ����
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		int birth = Integer.parseInt(mem.getBirth().substring(4,6));
	
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
				System.out.println("\t��������������������������������������������������������������������������");
				System.out.println();
				System.out.println("\t   " + mem.getName() + "��," + month + "�� ������ ���ϵ帳�ϴ�!");
				System.out.println();
				System.out.println("\t         ������������������������������������");
				System.out.println("\t         ��                ��");
				System.out.println("\t         ��  ���� ���� 30% ��");
				System.out.println("\t         ��                ��");
				System.out.println("\t         ������������������������������������");
				System.out.println();
				System.out.println("\t��������������������������������������������������������������������������");
				System.out.print("\t���� ������ ����Ͻðڽ��ϱ�? (Y/N) : ");
				answer = sc.next();

				// �������� ���� ���� ������*0.7 ����� ���� ���� �� �ݾ׿� ���, ��� ���ϸ� ��� ���� �׳� ���
				if (answer.equals("Y") || answer.equals("y"))
				{
					tmp = this.getTmpTotal() * 0.7;
					this.setTotal((int)tmp);
				}
				else if (answer.equals("N") || answer.equals("n"))
				{
					this.setTotal(this.getTmpTotal());
				}		
				else if (!answer.equals("Y") && !answer.equals("y") && !answer.equals("N") && !answer.equals("n"))
						throw new choiceException(answer);
			}
			else if (mem.getOrderTotal()==0)	
			{
				System.out.println();
				System.out.println();
				System.out.println("\t��������������������������������������������������������������������������");
				System.out.println();
				System.out.println("\t        " + mem.getName() + "��. �ݰ����ϴ�!");
				System.out.println("\tù ������ �����ϴ� ������ ���޵Ǿ����ϴ�.");
				System.out.println();
				System.out.println("\t         ������������������������������������");
				System.out.println("\t         ��                ��");
				System.out.println("\t         ��ù ���� ���� 20%��");
				System.out.println("\t         ��                ��");
				System.out.println("\t         ������������������������������������");
				System.out.println();
				System.out.println("\t��������������������������������������������������������������������������");
				System.out.print("\tù ���� ������ ����Ͻðڽ��ϱ�? (Y/N) : ");
				answer = sc.next();

				// �������� ���� ���� ������*0.8 ����� ���� ���� �� �ݾ׿� ���, ��� ���ϸ� ��� ���� �׳� ���
				if (answer.equals("Y") || answer.equals("y"))
				{
					tmp = this.getTmpTotal() * 0.8;
					this.setTotal((int)tmp);
				}
				else if (answer.equals("N") || answer.equals("n"))
				{
					this.setTotal(this.getTmpTotal());
				}
				else if (!answer.equals("Y") && !answer.equals("y") && !answer.equals("N") && !answer.equals("n"))
						throw new choiceException(answer);

			}//else if�� �ݱ�


			// ����Ʈ�� 100 �̻� �ִ� ��� ��� ������ �޼ҵ�
			if (mem.getPoint()>=100)
			{	
				int fix = this.getTotal();	// ������ ���� ��, ���� ����� �ֹ� �ݾ� ���� ����
				int prePointUse = fix;
				int point = mem.getPoint();

				System.out.println();
				System.out.println();
				System.out.println("\t��������������������������������������������������������������������������");
				System.out.println();
				System.out.println("\t" + mem.getName() + "���� ���� ���� ����Ʈ�� " + point + "�� �Դϴ�.");
				System.out.println();
				System.out.println("\t��������������������������������������������������������������������������");
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
							total = this.getTotal();

							// 2. ���� ����Ʈ - ��� ����Ʈ ���� �� Member ������ �ݿ��ϱ�
							point -= usePoint;
							mem.setPoint(point);
							this.selectPay();
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
					this.selectPay();							//�����޼ҵ� ȣ��
			}//if�� �ݱ�
		}//try�� �ݱ�
		catch (choiceException e)
		{
			e.showWrongChoice();
			System.out.println("\t������ ó������ �ٽ� �����մϴ�.");
			this.discount();
		}//catch �� �ݱ�
	} //discount() �޼ҵ� �ݱ�

	
   /* // ����Ʈ ���� �޼ҵ�
    public int pointStack()
    {
	   int temp = this.getTotal();
	  
	   double temppoint = temp*0.1;
	   int temp2 = (int)temppoint;

	   if (temp2 % 100 != 0 )
	   temp2 -= (temp%100);
		 
	   // MemberInfo Ŭ������ point�� ����                              
	   findById(name2).setPoint(temp2);
	   return temp2;
    }*/


	// ���� �޼ҵ�: ī��, ���� �� ����
	public void selectPay()
	{
		Scanner sc = new Scanner(System.in);
		ArrData ob = new ArrData();		// ī��, ���� �� ������ ���� ����� ��� �����Ϳ� �Ѱ��ֱ� ���� ������ �ν��Ͻ�

		do
		{
			System.out.println();
			System.out.println();
			System.out.println("\t��������������������������������������������������������������������������");	
			System.out.println();
			System.out.println("\t      �� ���� �ݾ��� " + total + "�� �Դϴ�.");
			System.out.println("\t    ���Ͻô� ���� ������ �������ּ���.");
			System.out.println();
			System.out.println("\t   1. ī��\t\t2.����");
			System.out.println();
			System.out.println("\t��������������������������������������������������������������������������");	
			System.out.print("\t   �޴� ���� : ");
			cardOrCash = sc.nextInt();
			ob.transfer(cardOrCash);	// ArrData Ŭ������ ���ǵ� transfer �޼ҵ� ȣ��: 1 �� ī��, 2 �� ���� ��ȯ
		}
		while (cardOrCash!=1 && cardOrCash!=2);

		switch (cardOrCash)
		{
			case 1 : this.cardPay(); break;	// ī�� ����
			case 2 : this.cashPay(); break;	// ���� ����
		}
	}


	// ī�� ����
	public void cardPay()
	{
		Scanner sc = new Scanner(System.in);
		this.setCard(total);				// ī�� �����ݾ� ������ ����

		System.out.println();
		System.out.println();
		System.out.println("\t��������������������������������������������������������������������������");	
		System.out.println();
		System.out.println("\t     �ϴܿ� ī�带 �Ⱦ��ּ���.");
		System.out.println();
		System.out.println("\t��������������������������������������������������������������������������");
		System.out.println("\t   " + total +"�� ������ �Ϸ�Ǿ����ϴ�.");
		System.out.print("\t   �������� ����Ͻðڽ��ϱ�? (Y/N) : ");
		answer = sc.nextLine();

		if (answer.equals("Y") || answer.equals("y"))
			this.printReceipt();			// ������ ��� �޼ҵ� ȣ��
		else
		{
			System.out.println();
			System.out.println();
			System.out.println("\t��������������������������������������������������������������������������");	
			System.out.println();
			System.out.println("\t     �ֹ��Ͻ� �޴��� ���Խ��ϴ�.");
			System.out.println("\t      �̿����ּż� �����մϴ�.");
			System.out.println();
			System.out.println("\t��������������������������������������������������������������������������");	
			//���Ǳ� ù ȭ������ �̵� �߰�!!
		}
	}//cardPay ��


	// ���� ����: ���� ����, ���� �Է� > ���ݿ����� ����(�޴�����ȣ �Է�)
	public void cashPay()
	{
		Scanner sc = new Scanner(System.in);

		int[] cashList = {10000, 5000, 1000, 500, 100};
		int[] count = new int[5];									// �Է¹޴� ������ ����
		int tmpMan=0, tmpOchun=0, tmpChun=0, tmpObak=0, tmpBak=0;	// ���Թ��� ������ �ݾ� (���翡 �߰��� �ݾ�)
		int ochun=0, chun=0, obak=0, bak=0;							// �Ž����� ���� �ʿ��� ����

		// ���� ����, ���� �Է�
		System.out.println();
		System.out.println();
		System.out.println("\t��������������������������������������������������������������������������");	
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
		System.out.println("\t��������������������������������������������������������������������������");
		System.out.println();
		System.out.println();

		// 1. userCash > total : �Ž����� ��� �� ��ȯ
		// 2. userCash < total : �ٽ� �Է¹ޱ�(�ʱ�ȭ)
		// 3. userCash = total : �Ž����� 0(default)
		System.out.println("\t      �� " + userCash + "���� ���ԵǾ����ϴ�.");
		System.out.println();

		if (userCash >= total)
		{
			change = userCash - total;
			// �Ž����� ��� (������ ���� ���� �� �� ������ ������, �������� �ٸ� ������ ������ �� ���� ������ ��)
			ochun = change/5000;
			chun = change%5000/1000;
			obak = change%5000%1000/500;
			bak = change%5000%1000%500/100;

			// �Է¹��� ������ �ݾ��� ���ϰ�, �Ž������� ���� ���� ���翡 �߰��ϱ�
			tmpMan = count[0] * cashList[0];
			tmpOchun = count[1] * cashList[1] - ochun;
			tmpChun = count[2] * cashList[2] - chun;
			tmpObak = count[3] * cashList[3] - obak;
			tmpBak = count[4] * cashList[4] - bak;
			
			Cash ch = new Cash(tmpMan, tmpOchun, tmpChun, tmpObak, tmpBak);	// ��������� �����ڷ� �� �Է��ϱ�

			System.out.println("\t         ������ �Ϸ�Ǿ����ϴ�.");
			System.out.println();
			System.out.println("\t��ȯ������ �Ž����� " + change + "���� Ȯ�����ּ���.");
			System.out.println();
			System.out.println("\t��������������������������������������������������������������������������");	
		}
		else if (userCash < total)
		{
			System.out.println("\t   �� ���� �ݾ��� " + this.getTotal() + "�� �Դϴ�.");
			System.out.println("\t     ���� �ݾ��� �����մϴ�.");
			System.out.println("\t��ȯ�Ǵ� ������ Ȯ���Ͻð�, �ٽ� �������ּ���.");
			System.out.println();
			this.cashPay();
		}

		// ���ݿ����� ���� (�޴��� ��ȣ �Է� or ������ ���)
		System.out.println();
		System.out.print("\t���� �������� �߱��Ͻðڽ��ϱ�? (Y/N) : ");
		answer = sc.next();
		

		if (answer.equals("Y") || answer.equals("y"))
		{
			System.out.print("\t  ���� ������ ��ȣ�� �Է����ּ���. : ");
			cashReceipt = sc.next();
		}
		
		// ������ ��� ����
		System.out.println();
		System.out.print("\t�������� ����Ͻðڽ��ϱ�? (Y/N) : ");
		answer = sc.next();

		if (answer.equals("Y") || answer.equals("y"))
			this.printReceipt();			// ������ ��� �޼ҵ� ȣ��
		else
		{
			System.out.println();
			System.out.println();
			System.out.println("\t��������������������������������������������������������������������������");	
			System.out.println();
			System.out.println("\t     �ֹ��Ͻ� �޴��� ���Խ��ϴ�.");
			System.out.println("\t       �̿����ּż� �����մϴ�.");
			System.out.println();
			System.out.println("\t��������������������������������������������������������������������������");	


		}	

	}//cashPay ��


	// ������ ���
	public void printReceipt()
	{
		Calendar now = Calendar.getInstance();

		int y = now.get(Calendar.YEAR);
		int m = now.get(Calendar.MONTH)+1;
		int d = now.get(Calendar.DATE);
		int h = now.get(Calendar.HOUR_OF_DAY);
		int min = now.get(Calendar.MINUTE);
		
		// ����(������ ��� ����)�� ��¥, �ð��� Ŭ������ ���� ����� fix��
		ArrData paytime = new ArrData(y, m, d, h, min);

		String menuName = "������";							// �޴� �̸� (�ֹ����� �޾ƿ���!!!!!!!!!)
		int menuCount = 1;									// �޴� �� �ֹ� ����
		String commTotal = String.format("%,d", total);		//',' ���� ���� �ݾ�
		String commCash = String.format("%,d", userCash);	//',' ���� ����ڿ��� �Է¹��� ���� �ݾ�
		String commChange = String.format("%,d", change);	//',' ���� �Ž�����

		System.out.println();
		System.out.println();
		System.out.println("\t��������������������������������������������������������������������������");	
		System.out.println();
		System.out.println("\t            <  ��  ��  ��  >");
		System.out.println();
		System.out.println("\t           Custom Cocktail ");

		System.out.println("\t����ڹ�ȣ: 411-82-05920");
		System.out.println("\t��      ��: ����� ������ �����źϷ� 21");
		System.out.println("\t��ȭ  ��ȣ: 010-8102-0384");
		System.out.printf("\t��      ��: %4d-%d-%d  %2d:%2d\n", y, m, d, h, min);
		System.out.println("\t��������������������������������������������������������������������������");	
		System.out.println("\t ǰ��\t\t����\t\t�ݾ�");
		System.out.printf("\t %s\t\t %d\t\t%5s\n", menuName, menuCount, commTotal);
		System.out.println("\t��������������������������������������������������������������������������");	
		System.out.printf("\t ��    �� : \t\t%5s\n", commTotal);

		if (cardOrCash==1)
			System.out.printf("\t ī    �� : \t\t%5s\n", commTotal);
		else if (cardOrCash==2)
		{
			System.out.printf("\t ��    �� : \t\t%5s\n", commCash);
			System.out.printf("\t �Ž����� : \t\t%5s\n", commChange);
			System.out.println();
			System.out.printf("\t ���ݿ����� : \t\t%5s\n", cashReceipt);
		}

		System.out.println("\t��������������������������������������������������������������������������");	
		System.out.println("\t      ***** ���� �Ϸ� �Ǽ��� *****");
		System.out.println();
		System.out.println();
		System.out.println("\t��������������������������������������������������������������������������");	
		System.out.println();
		System.out.println("\t      �ֹ��Ͻ� �޴��� ���Խ��ϴ�.");
		System.out.println("\t       �̿����ּż� �����մϴ�.");
		System.out.println();
		System.out.println("\t��������������������������������������������������������������������������");	
	}//printReceipt ��

}


// [�����ڸ��-������Ȳ] ���� ����� �������� ��� Ŭ����
class ArrData
{

	UserPayment ob = new UserPayment();
	//MemberInfo ob2 = new MemberInfo();

	// ���� ����: ����, ��, ��, �ð�, ��
	private int y;
	private int m;
	private int d;
	private int h;
	private int min;

	// ������ �̸�
	public String name = "������";

	// ���� �޴� -- �ӽ÷� �����. ����ڿ��� �Է¹����� �������!
	public String menu = "�߷��þ�";

	// ���� -- �ӽ÷� �����. ����ڿ��� �Է¹����� �������!
	public int count = 1;

	// ���� �ݾ�
	public int total = ob.total;

	// �������� (1=ī��, 2=����)
	public int how = ob.cardOrCash;

	// ��½� 1=ī��, 2=���� �����ֱ� ���� ����
	public String strHow="";

	public void transfer(int how) 	//UserPayment Ŭ�������� ȣ���ؼ� �� �־��� ��
	{
		if (how == 1)
			strHow = "ī��";
		else if (how == 2)
			strHow = "����";
	}	


	public ArrData(int y, int m, int d, int h, int min) 
	{
		this.y=y;
		this.m=m;
		this.d=d;
		this.h=h;
		this.min=min;
	}

	public ArrData(int y, int m, int d, int h, int min, String name, String menu, int count, int total, String strHow) 
	{
		this.y=y;
		this.m=m;
		this.d=d;
		this.h=h;
		this.min=min;
		this.name=name;
		this.menu=menu;
		this.count=count;
		this.total=total;
		this.strHow=strHow;	
	}

	public ArrData() 
	{
	}
	
	// getter
	public int getY(){ return y; }
	public int getM(){ return m; }
	public int getD(){ return d; }
	public int getH(){ return h; }
	public int getMin(){ return min;}

}//ArrData ��


// ���ı��� 1. �����ð� �������� ����
class DateArray implements Comparator<ArrData>
{
		@Override
		public int compare(ArrData o1, ArrData o2)
		{
			return o1.getD() - o2.getD();
		}
}

// ���ı��� 2. �޴� �������� ����
class MenuArray implements Comparator<ArrData>
{
		@Override
		public int compare(ArrData o1, ArrData o2)
		{
			return o1.menu.compareTo(o2.menu);
		}
}

// ���ı��� 3. ȸ��ID �������� ����
class MemberArray implements Comparator<ArrData>
{
		@Override
		public int compare(ArrData o1, ArrData o2)
		{
			return o1.name.compareTo(o2.name);
		}
}

// ���ı��� 4. �������� �������� ����
class CardCashArray implements Comparator<ArrData>
{
		@Override
		public int compare(ArrData o1, ArrData o2)
		{
			return o1.strHow.compareTo(o2.strHow);
		}
}



public class Payment
{
	public static void main(String[] args) 
	{


	}
}