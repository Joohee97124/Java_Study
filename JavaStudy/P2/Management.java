import java.io.IOException;

class Management extends Login
{
	int selection; // ����� �Է°�

	// ������ ȭ�� �޴� ��� �޼ҵ�
	public void managerMenu() throws IOException
	{
		UserAdmin ua = new UserAdmin();			// ȸ�� ���� Ŭ���� �ν��Ͻ� ����
		InvPage ip = new InvPage();				// ��� ���� Ŭ���� �ν��Ͻ� ����
		MenuAdmin ma = new MenuAdmin();			// �޴� ���� Ŭ���� �ν��Ͻ� ����
		SalesManagement sm = new SalesManagement(); // ���� ���� Ŭ���� �ν��Ͻ� ����
		MachineRoom mr = new MachineRoom();		// ��� ���� Ŭ���� �ν��Ͻ� ����

		System.out.println("\n\n\t\t\t\t\t[ ������ ��� ]\n");
		System.out.println("\t1. ȸ�� ����  2. �޴� ����  3. ��� ����  4. ���� ����  5. ��� ����  6. ùȭ��");

		do
		{
			System.out.print("\tȮ���ϰ��� �ϴ� ������ ����(1~6) : ");
			selection = sc.nextInt();
		}
		while (selection<1 || selection>6);

		switch (selection)
		{
			case 1 : ua.userAdminMenu(); break;		// ȸ�� ���� �޼ҵ�� ����
			case 2 : ma.home(); break;// �޴� ���� �޼ҵ�� ����				//ma.setting();
			case 3 : ip.stockManage(); break;		// ��� ���� �޼ҵ�� ����
			case 4 : sm.showChoice(); break;		// ���� ���� �޼ҵ�� ����
			case 5 : mr.setMachine(); break;		// ��� ���� �޼ҵ�� ����
			case 6 : start(); break;				// ù ȭ��� ����
		}
	}
}
