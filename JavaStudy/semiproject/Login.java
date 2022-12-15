import java.util.Scanner;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

// �α��� �� ȸ������ �����ϴ� LoginŬ����
public class Login
{
	static List<MemberInfo> list;			//-- MemberInfo Ŭ���� Ÿ���� �迭�� ������ list ����
	static Scanner sc;

	String name2, pw2;						//--�α��ο� ������ ������� id/pw ��� ���θ޼ҵ忡�� �����ų ����
	
	static
	{
		list = new ArrayList<MemberInfo>(50);
		sc = new Scanner(System.in);
	}

	
	// �⺻ ȸ���� ���� �޼ҵ�
	public void defaultInfo()
	{
		list.add(new MemberInfo("������", "admin", "1234", "00000000000", "00000000",0));		
		list.add(new MemberInfo("�谡��", "gayoung", "rlarkdud", "01050501932", "19940225",1000));
		list.add(new MemberInfo("������", "jungjun", "qkrwjdwns", "01040207429", "19961031",1000));
		list.add(new MemberInfo("������", "jungmi", "dkswjdal", "01026194925", "19960125",1000));
		list.add(new MemberInfo("������", "hyerim", "wjsgPfla", "01080019506", "19950630",1000));
		list.add(new MemberInfo("������", "joohee", "wjdwngml", "01080192565", "19971224",1000));		
	}
	
	// ȸ�� Ȯ�� �޼ҵ�
	public void start() throws IOException
	{
		char a;

		System.out.println("\n\t==============================================");
		System.out.println("\t������ ilzo Ĭ���� ���Ǳ��Դϴ� ������");

		do
		{
			System.out.print("\n\tȸ���̽ʴϱ�? (Y/N) : ");
			a = (char)System.in.read();
			System.in.skip(100);
		}
		while (a!='y' && a!='Y' && a!='n' && a!='N');

		if (a == 'y' || a == 'Y')
			login();		// �α��� �޼ҵ�� �̵�
		else
			register();		// ȸ������ �޼ҵ�� �̵�
	}

	// ȸ���� ��� �� �α��� �޼ҵ�
	public void login() throws IOException
	{
		String userId, userPw;					// ����� �Է� Id/Pw ������ ���� ����
		MemberInfo member;						// findById �޼ҵ� ���� �� ��ȯ�� MemberInfo ��ü�� ������ ����

		System.out.println("\n\t������� �α��� ������ �Դϴ� �������");

		do
		{
			System.out.print("\n\tID�� �Է����ּ���: ");
			userId = sc.next();
			System.out.print("\tPW�� �Է����ּ���: ");
			userPw = sc.next();
			
			member = findById(userId);
			if(member == null)												
			// 1. ����� �Է� Id�� list�� �������� �ʴ� ���
				System.out.println("\n\t** ��ϵ��� ���� ID�Դϴ�.");
			else if(member.getPw().equals(userPw))							
			// 2. ����� �Է� Id�� list�� �����ϰ�, Pw���� ��ġ�ϴ� ���
			{
				System.out.println("\n\t�α��ο� �����߽��ϴ�~!!!");
				name2 = userId;
				pw2 = userPw;
			}
			else															
			// 3. ����� �Է� Id�� list�� �����ϰ�, Pw���� ��ġ���� �ʴ� ���
				System.out.println("\n\t** ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		}
		while (member == null || member.getPw().equals(userPw)!=true);		
		// 1 & 3 ���� ��� do while �� �ݺ� ����.
    }

	// ��ȸ���� ��� �� ȸ������ �޼ҵ�
	public void register() throws IOException
	{
		String userName, userBirth, userId, userPw, userPhone;				// ����� �Է� ������ ���� ����
		Calendar rightNow = Calendar.getInstance();							// ������ �⵵�� �˱� ���� Calendar �ν��Ͻ� ����

		System.out.println("\n\t������� ȸ�������� �����մϴ� �������");
		do
		{
			System.out.print("\t�̸� �Է�(�ִ� 5��): ");							
			userName = sc.next();
		}
		while (userName.length() < 1 || userName.length() > 5 );			// �̸� 1~5�� ����


		do
		{
			System.out.print("\t������� �Է�(8�ڸ�): ");					// ������� 8�� ����
			userBirth = sc.next();

			if (rightNow.get(Calendar.YEAR) - Integer.parseInt(userBirth.substring(0,4))<19)	// ������ �⵵ - ������� ��4�ڸ� < 19 �� ���
			{
				System.out.println("\n\t�̼����ڴ� ������ �� �����ϴ�.\n");
			} 
		}
		while (userBirth.length() != 8 || rightNow.get(Calendar.YEAR) - Integer.parseInt(userBirth.substring(0,4))<19);

		do
		{
			System.out.print("\tID �Է�(�ҹ���, �ִ� 10��): ");
			userId = sc.next();
		}
		while (userId.length() < 1 || userId.length() > 10 || checkId(userId)==false); // id 1~10�� ����, �ҹ��ڸ� �Է�

		do
		{
			System.out.print("\tPW �Է�(�ִ� 12��): ");
			userPw = sc.next();
		}
		while (userPw.length() < 1 || userPw.length() > 12 );				// pw 1~12�� ����

		do
		{
			System.out.print("\t��ȭ��ȣ �Է�(11�ڸ�): ");							
			userPhone = sc.next();
		}
		while (userPhone.length() != 11 );									// ��ȭ��ȣ 11�� ����
		
		        
        if(idCheck(userId))								// idCheck(userId) true �� ��� list�� ����� �Է� Id�� ������ Id ���� �����ϹǷ� �ߺ��˸� �޼��� ���
            System.out.println("\t�ߺ��� ID�Դϴ�.");
        else											// idCheck(userId) false �� ��� list �� �߰�
		{
			if (list.size()>=50)
			{
				System.out.println("\n\t���� ������ �ο���(50��)�� �ʰ��Ǿ����ϴ�.");		// �����ο� �� ����
				this.start();
			}
            list.add(new MemberInfo(userName, userId, userPw, userPhone, userBirth, 100));
            System.out.println("\n\t������ �Ϸ�Ǿ����ϴ�~!!!\n");
			System.out.println("\n\t�⺻ ������ 100���� ���޵Ǿ����ϴ�.^^\n");
        }
        
		this.start();
		
	}
	
	// id �ҹ��� üũ �޼ҵ�
	public boolean checkId(String textInput) 
	{
		char chrInput;

		for (int i = 0; i < textInput.length(); i++) 
		{
			chrInput = textInput.charAt(i); // �Է¹��� String���� ���� �ϳ��� �����ͼ� üũ

			if (chrInput >= 97 && chrInput <= 122) 
			{
				// �׳� �Ѿ�� �� ����(�ҹ���) OK!
			} 
	 
			else
				return false;   // ����(�ҹ���)�� �ƴ� ���
		}
		return true;

	}

	// MemberInfoŸ�� ��ü�� ��ȯ�ϴ� findById() �޼ҵ� : ����ڰ� �Է��� userId�� ���ڷ� �޾� list�� ���� Id���� �����ϸ� memberinfo�� ��ȯ. 
	// �������� ������ null ��ȯ
	protected MemberInfo findById(String userId) 
	{
		for(MemberInfo memberinfo : list)
		{
			if(memberinfo.getId().equals(userId)) 
				return memberinfo;
		}
		return null;
	}

	 // boolean�� ��ȯ�ϴ� idCheck() �޼ҵ� : ����ڰ� �Է��� userId�� ���ڷ� �޾� findById(userId) �޼ҵ� ���� ���� member�� ����
	 //                                       ����� �Է� Id�� ������ id���� list�� �����ϸ� true / �������� ������(null�̸�) false ��ȯ
    protected boolean idCheck(String userId) 
	{
        boolean check = true;
        MemberInfo member = findById(userId);
        if(member == null)
            check = false;
        return check;
    }

	
}

