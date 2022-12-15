import java.util.Iterator;
import java.io.IOException;

class UserAdmin extends Management
{
	int i=0;

	// ȸ�� ���� ������
	public void userAdminMenu() throws IOException
	{
		System.out.println("\n\n\t=================[ ȸ�� ���� ������ ]==================\n");
		System.out.println("\t1. ȸ�� ���� ���  2. ȸ�� ���� �˻�  3. ȸ�� ���� ���� 4. Ŀ���� ������ ����(�˻�)  5. ���ư���");

		do
		{
			System.out.print("\tȮ���ϰ��� �ϴ� ������ ����(1~5) : ");
			selection = sc.nextInt();
		}
		while (selection<1 || selection>5);

		switch (selection)
		{
			case 1 : showDB(); break;				// ȸ�� ���� ��� �޼ҵ�� ����
			case 2 : searchDB(); break;				// ȸ�� ���� �˻� �޼ҵ�� ����
			case 3 : deleteDB(); break;				// ȸ�� ���� ���� �޼ҵ�� ����
			case 4 : searchRecipe(); break;			// Ŀ���� ������ ����(�˻�) �޼ҵ�� ����
			case 5 : managerMenu(); break;			// ���ư���
		}
	}

	public void showDB()throws IOException
	{
		System.out.println("\n\t=================[ȸ�� ���� ����Ʈ ��ü ���]==================\n");
		Iterator it = list.iterator();

		while (it.hasNext())
		{
			MemberInfo str = (MemberInfo)it.next();
			if (str.getId().equals(""))
				continue;

			System.out.println("\t" + str);
		}
		System.out.println("\n\t����Ʈ ��ü ��� ��.\n");	
		userAdminMenu();
	}

	public void searchDB()throws IOException
	{
		
		System.out.print("\n\t�˻��ϰ��� �ϴ� ȸ�� ID �Է� : ");
		String s = sc.next();
		System.out.println("\n\t=================[�˻� ��� ���]==================");
		
		if (idCheck(s))
		{
			MemberInfo m = findById(s);
			System.out.printf("\n\t�̸� : %s\n\tID : %s\n\tPW : %s\n\t��ȭ��ȣ : %s\n\t������� : %s\n\t������ : %d\n"
				,m.getName(),m.getId() ,m.getPw(),m.getPhone(),m.getBirth(),m.getPoint());
		}
		else
			System.out.println("\t�Է��Ͻ� ȸ�� ID�� �������� �ʾ� �˻��� �� �����ϴ�.");

		userAdminMenu();
		
	}

	public void deleteDB()throws IOException
	{
		System.out.print("\n\t������ ȸ�� ID �Է� : ");
		String s = sc.next();

		if (idCheck(s))
		{
			list.remove(findById(s));
			System.out.printf("\n\t���������� ������ �Ϸ�Ǿ����ϴ�.");
		}
		else
			System.out.println("\t�Է��Ͻ� ȸ�� ID�� �������� �ʾ� ������ �� �����ϴ�.");

		userAdminMenu();
	}

	public void searchRecipe() throws IOException
	{
		System.out.print("\n\t�˻��ϰ��� �ϴ� ȸ���� ID �Է�: ");
		String s = sc.next();

		if (idCheck(s))
		{
			MemberInfo m = findById(s);
			System.out.printf("\n\t %s ���� Ŀ���ҷ����� : ���̽� %s ml & �ֽ�/ť��� %s ml"
				,m.getName(),m.getCustomBase(),m.getCustomJuice());
		}
		else
			System.out.println("\t�Է��Ͻ� ȸ�� ID�� �������� �ʾ� �����Ǹ� ����� �� �����ϴ�.");

		userAdminMenu();
		
	}

}
