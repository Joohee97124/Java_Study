import java.util.Scanner;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

// ���� �޼ҵ带 ������ LoginŬ����
public class Login
{
	static List<MemberInfo> list;
	static Scanner sc;

	MemberInfo mi = new MemberInfo();
	String name2;
	
	static
	{
		list = new ArrayList<MemberInfo>(50);
		sc = new Scanner(System.in);
	}

	
	// �⺻ ȸ���� ���� �޼ҵ�
	public void defaultInfo()
	{
		list.add(new MemberInfo("������", "admin", "1234", " ", " ",0));		
		list.add(new MemberInfo("�谡��", "gayoung", "rlarkdud", "01050501932", "19940225",9000));
		list.add(new MemberInfo("������", "jungjun", "qkrwjdwns", "01055554444", "19960225",900));
		list.add(new MemberInfo("������", "jungmi", "dkswjdal", "01055553333", "19960225",8000));
		list.add(new MemberInfo("������", "hyerim", "wjsgPfla", "01055551111", "19950225",800));
		list.add(new MemberInfo("������", "joohee", "wjdwngml", "01055552222", "19960225",6000));		
	}
	
	// ȸ�� Ȯ�� �޼ҵ�
	public void start() throws IOException
	{
		char a;

		System.out.println("\n*=====================================*");
		System.out.println("   ilzo Ĭ���� ���Ǳ��Դϴ�*_*  ");

		do
		{
			System.out.print("    ȸ���̽ʴϱ�? (Y/N) : ");
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
		Management m = new Management();		// ������ ������ ��ȯ�� ���� ������ Ŭ���� �ν��Ͻ� ����
		String userId, userPw;					// ����� �Է� Id/Pw ������ ���� ����
		MemberInfo member;						// findById �޼ҵ� ���� �� ��ȯ�� MemberInfo ��ü�� ������ ����

		System.out.println("\n    *_* �α��������� �Դϴ� *_*");

		do
		{
			System.out.print("\n    ID�� �Է����ּ���: ");
			userId = sc.next();
			System.out.print("    PW�� �Է����ּ���: ");
			userPw = sc.next();
			
			member = findById(userId);
			if(member == null)												// 1. ����� �Է� Id�� list�� �������� �ʴ� ���
				System.out.println("\n    ** ��ϵ��� ���� ID�Դϴ�.");
			else if(member.getPw().equals(userPw))							// 2. ����� �Է� Id�� list�� �����ϰ�, Pw���� ��ġ�ϴ� ���
			{
				System.out.println("\n    �α��ο� �����߽��ϴ�~!!!");
				name2 = userId;
			}
			else															// 3. ����� �Է� Id�� list�� �����ϰ�, Pw���� ��ġ���� �ʴ� ���
				System.out.println("\n    ** ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		}
		while (member == null || member.getPw().equals(userPw)!=true);		// 1 & 3 ���� ��� do while �� �ݺ� ����.

		if (userId.equals("admin") && userPw.equals("1234"))				// ������ ������ ��ȯ Id & Pw ����
				m.managerMenu();
		
    }

	// ��ȸ���� ��� �� ȸ������ �޼ҵ�
	public void register() throws IOException
	{
		String userName, userBirth, userId, userPw, userPhone;				// ����� �Է� ������ ���� ����
		Calendar rightNow = Calendar.getInstance();							// ������ �⵵�� �˱� ���� Calendar �ν��Ͻ� ����

		System.out.println("\n    ȸ�������� �����մϴ�.");
		do
		{
			System.out.print("    �̸� �Է�(�ִ� 5��): ");							
			userName = sc.next();
		}
		while (userName.length() < 1 || userName.length() > 5 );			// �̸� 1~5�� ����

		do
		{
			System.out.print("    ������� �Է�(8�ڸ�): ");					// ������� 8�� ����
			userBirth = sc.next();
		}
		while (userBirth.length() != 8 );

		if (rightNow.get(Calendar.YEAR) - Integer.parseInt(userBirth.substring(0,4))<19)	// ������ �⵵ - ������� ��4�ڸ� < 19 �� ���
		{
			System.out.println("\n    �̼����ڴ� ������ �� �����ϴ�.");
			start();
		} 

		do
		{
			System.out.print("    ID �Է�(�ҹ���, �ִ� 10��): ");
			userId = sc.next();
		}
		while (userId.length() < 1 || userId.length() > 10 || checkId(userId)==false); // id 1~10�� ����, �ҹ��ڸ� �Է�

		do
		{
			System.out.print("    PW �Է�(�ִ� 12��): ");
			userPw = sc.next();
		}
		while (userPw.length() < 1 || userPw.length() > 12 );				// pw 1~12�� ����

		do
		{
			System.out.print("    ��ȭ��ȣ �Է�(11�ڸ�): ");							
			userPhone = sc.next();
		}
		while (userPhone.length() != 11 );									// ��ȭ��ȣ 11�� ����
		
		        
        if(idCheck(userId))								// idCheck(userId) true �� ��� list�� ����� �Է� Id�� ������ Id ���� �����ϹǷ� �ߺ��˸� �޼��� ���
            System.out.println("�ߺ��� ID�Դϴ�.");
        else											// idCheck(userId) false �� ��� list �� �߰�
		{
			if (list.size()>=50)
			{
				System.out.println("\n    ���� ������ �ο���(50��)�� �ʰ��Ǿ����ϴ�.");		// �����ο� �� ����
				this.start();
			}
            list.add(new MemberInfo(userName, userId, userPw, userPhone, userBirth, 0));
            System.out.println("\n    ������ �Ϸ�Ǿ����ϴ�~!!!\n");
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

	// MemberInfoŸ�� ��ü�� ��ȯ�ϴ� findById() �޼ҵ� : ����ڰ� �Է��� userId�� ���ڷ� �޾� list�� ���� Id���� �����ϸ� memberinfo�� ��ȯ. �������� ������ null ��ȯ
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


	// ������ ����Ʈ�� ȸ��DB�� �����ϴ� �޼ҵ�
   /*public void pointN()
   {
      int point1 = findById(name2).getPoint();
      int point2 = mi.pointC();
      findById(name2).setPoint( point1 + point2 );
      System.out.println("���� ����Ʈ: "+findById(name2).getPoint());
   }*/
	
}

